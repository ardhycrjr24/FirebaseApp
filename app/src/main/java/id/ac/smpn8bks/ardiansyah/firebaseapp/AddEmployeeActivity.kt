package id.ac.smpn8bks.ardiansyah.firebaseapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

import id.ac.smpn8bks.ardiansyah.firebaseapp.databinding.ActivityAddEmployeeBinding

import org.valiktor.ConstraintViolationException

class AddEmployeeActivity : AppCompatActivity() {

    private lateinit var binding:
            ActivityAddEmployeeBinding

    private lateinit var dbRef:
            DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            ActivityAddEmployeeBinding.inflate(
                layoutInflater
            )

        setContentView(binding.root)

        dbRef =
            FirebaseDatabase
                .getInstance()
                .getReference("Employees")

        binding.btnSave.setOnClickListener {

            saveEmployeeData()
        }
    }

    private fun saveEmployeeData() {

        val empName =
            binding.etName.text.toString()

        val empEmail =
            binding.etEmail.text.toString()

        val empAge =
            binding.etAge.text.toString()

        val empSalary =
            binding.etSalary.text.toString()

        var error = false

        // VALIDASI KOSONG

        if (empName.isEmpty()) {

            binding.etName.error =
                "Nama tidak boleh kosong!"

            error = true
        }

        if (empEmail.isEmpty()) {

            binding.etEmail.error =
                "Email tidak boleh kosong!"

            error = true
        }

        if (empAge.isEmpty()) {

            binding.etAge.error =
                "Umur tidak boleh kosong!"

            error = true
        }

        if (empSalary.isEmpty()) {

            binding.etSalary.error =
                "Pendapatan tidak boleh kosong!"

            error = true
        }

        if (error)
            return

        var intAge: Int
        var longSalary: Long

        // VALIDASI ANGKA

        try {

            intAge = empAge.toInt()

            longSalary = empSalary.toLong()

        } catch (_: NumberFormatException) {

            Toast.makeText(
                this,
                "Input umur atau pendapatan salah!",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        val empID =
            dbRef.push().key!!

        val employee:
                EmployeeModel

        // VALIDASI VALIKTOR

        try {

            employee =
                EmployeeModel(
                    empID,
                    empName,
                    empEmail,
                    intAge,
                    longSalary
                )

        } catch (
            ex: ConstraintViolationException
        ) {

            val message =
                ex.constraintViolations

                    .joinToString("\n") { violation ->

                        val field =
                            when (violation.property) {

                                "empName" ->
                                    "Nama"

                                "empEmail" ->
                                    "Email"

                                "empAge" ->
                                    "Umur"

                                "empSalary" ->
                                    "Pendapatan"

                                else ->
                                    violation.property
                            }

                        val errorMessage =

                            when (
                                violation.constraint.name
                            ) {

                                "Size" ->
                                    "Panjang karakter harus antara 3 dan 30"

                                "Email" ->
                                    "Email tidak valid"

                                "Positive" ->
                                    "Nilai harus lebih besar dari 0"

                                "Between" ->
                                    "Nilai harus antara 17 dan 55"

                                else ->
                                    "Input tidak valid"
                            }

                        "$field : $errorMessage"
                    }

            showFullTextToast(
                this,
                message
            )

            return
        }

        // INSERT FIREBASE

        dbRef.child(empID)

            .setValue(employee)

            .addOnCompleteListener {

                Toast.makeText(
                    this,
                    "Data berhasil ditambahkan",
                    Toast.LENGTH_SHORT
                ).show()

                // CLEAR INPUT

                binding.etName.text.clear()

                binding.etEmail.text.clear()

                binding.etAge.text.clear()

                binding.etSalary.text.clear()
            }

            .addOnFailureListener { err ->

                Toast.makeText(
                    this,
                    "Error : ${err.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    // CUSTOM TOAST

    fun showFullTextToast(
        context: Context,
        message: String
    ) {

        val inflater =
            LayoutInflater.from(context)

        val toastView: View =
            inflater.inflate(
                R.layout.custom_toast,
                null
            )

        val toastText =
            toastView.findViewById<TextView>(
                R.id.toast_text
            )

        toastText.text =
            message

        val toast =
            Toast(context)

        toast.view =
            toastView

        toast.duration =
            Toast.LENGTH_LONG

        toast.show()
    }
}