# Firebase Realtime Database — Modul 13

Aplikasi Android berbasis Kotlin yang menerapkan Firebase Realtime Database sebagai backend cloud database untuk menyimpan dan melakukan sinkronisasi data secara realtime.

---

# Tujuan Praktikum

* Mengenal Firebase Realtime Database
* Menghubungkan Android dengan Firebase
* Menyimpan data ke Firebase
* Menampilkan data realtime dari Firebase
* Mengubah dan menghapus data Firebase
* Memahami sinkronisasi realtime pada Android

---

# Teknologi Yang Digunakan

* Kotlin
* Android Studio
* Firebase Realtime Database
* Firebase SDK
* Material Design
* RecyclerView
* ViewBinding

---

# Konsep Firebase Realtime Database

Firebase Realtime Database merupakan layanan database NoSQL berbasis cloud dari Google Firebase yang menyimpan data dalam bentuk JSON tree dan melakukan sinkronisasi data secara realtime ke seluruh client yang terhubung.

Keunggulan Firebase:

* Realtime synchronization
* Cloud database
* Mudah diintegrasikan dengan Android
* Mendukung offline data
* Tidak memerlukan backend server manual

---

# Fitur Yang Diimplementasikan

* Koneksi Android ke Firebase
* Insert data realtime
* Read data realtime
* Update data realtime
* Delete data realtime
* Menampilkan data menggunakan RecyclerView

---

# Struktur Data Firebase

Contoh struktur data JSON:

```json id="f1"
{
  "users": {
    "user1": {
      "nama": "Ardiansyah",
      "email": "ardhy@gmail.com"
    }
  }
}
```

---

# Dependency Firebase

Tambahkan dependency berikut pada Gradle:

```kotlin id="f2"
implementation(platform("com.google.firebase:firebase-bom:33.1.0"))
implementation("com.google.firebase:firebase-database-ktx")
```

---

# Konfigurasi Firebase

1. Membuat project di Firebase Console
2. Menambahkan aplikasi Android
3. Mengunduh file `google-services.json`
4. Meletakkan file pada folder `app/`
5. Menambahkan plugin Firebase pada Gradle

---

# Fitur CRUD Firebase

| Operasi | Fungsi           |
| ------- | ---------------- |
| Create  | Menambahkan data |
| Read    | Menampilkan data |
| Update  | Mengubah data    |
| Delete  | Menghapus data   |

---

# Screenshot Praktikum

## Firebase Console

Tambahkan screenshot Firebase Console di sini.

---

## Insert Data Firebase

Tambahkan screenshot insert data di sini.

---

## Read Data Firebase

Tambahkan screenshot read data di sini.

---

## Update Data Firebase

Tambahkan screenshot update data di sini.

---

## Delete Data Firebase

Tambahkan screenshot delete data di sini.

---

# Hasil Praktikum

Pada praktikum ini aplikasi Android berhasil dihubungkan dengan Firebase Realtime Database. Data dapat ditambahkan, ditampilkan, diubah, dan dihapus secara realtime tanpa perlu membuat backend server manual.

Firebase Realtime Database juga berhasil melakukan sinkronisasi data otomatis antara aplikasi Android dan cloud database secara realtime.

---

# Author

**Ardiansyah**
D4 Rekayasa Perangkat Lunak
Politeknik Negeri Bengkalis

GitHub:

```text id="f3"
https://github.com/ardhycrjr24
```
