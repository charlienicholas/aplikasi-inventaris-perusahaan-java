# Aplikasi Inventaris Perusahaan

Aplikasi Inventaris Perusahaan adalah aplikasi desktop berbasis Java Swing untuk mengelola data stok barang perusahaan. Aplikasi ini menggunakan MySQL sebagai database dan Maven sebagai build tool.

## Fitur

- Menampilkan daftar stok persediaan barang.
- Menambahkan data barang baru.
- Mengubah data barang yang sudah ada.
- Menghapus data barang.
- Validasi input stok agar hanya menerima angka.
- Form otomatis dikosongkan kembali setelah proses simpan, edit, atau hapus.

## Teknologi

- Java
- Java Swing
- Maven
- MySQL
- MySQL Connector/J 8.3.0

## Struktur Project

```text
.
├── pom.xml
└── src/main/java/com/charlie/aplikasiinventarisperusahaan
    ├── AplikasiInventarisPerusahaan.java
    ├── FormInventaris.java
    ├── FormInventaris.form
    └── Koneksi.java
```

## Prasyarat

Pastikan perangkat sudah memiliki:

- JDK sesuai konfigurasi Maven project.
- Apache Maven.
- MySQL Server.
- NetBeans, opsional untuk membuka dan mengedit form Swing.

Project saat ini menggunakan konfigurasi compiler berikut di `pom.xml`:

```xml
<maven.compiler.release>25</maven.compiler.release>
```

Jika JDK yang digunakan belum mendukung release tersebut, ubah nilainya sesuai versi JDK yang tersedia, misalnya `17` atau `21`.

## Setup Database

Buat database MySQL dengan nama `db_perusahaan`, lalu buat tabel `stok_persediaan`.

```sql
CREATE DATABASE IF NOT EXISTS db_perusahaan;

USE db_perusahaan;

CREATE TABLE IF NOT EXISTS stok_persediaan (
    kode_barang VARCHAR(50) PRIMARY KEY,
    jenis_barang VARCHAR(100),
    nama_barang VARCHAR(150) NOT NULL,
    stok_barang INT NOT NULL
);
```

Sesuaikan konfigurasi koneksi database pada file:

```text
src/main/java/com/charlie/aplikasiinventarisperusahaan/Koneksi.java
```

Konfigurasi default:

```java
String url = "jdbc:mysql://localhost:3306/db_perusahaan";
String user = "charlie";
String pass = "21";
```

## Cara Menjalankan

Jalankan aplikasi dengan Maven:

```bash
mvn clean compile exec:java
```

Atau buka project melalui NetBeans, lalu jalankan class utama:

```text
com.charlie.aplikasiinventarisperusahaan.AplikasiInventarisPerusahaan
```

## Cara Menggunakan

1. Isi data barang pada field Kode Barang, Jenis Barang, Nama Barang, dan Stok Barang.
2. Klik `Simpan` untuk menambahkan data baru.
3. Klik salah satu baris pada tabel untuk memilih data.
4. Klik `Edit` untuk memperbarui data yang dipilih.
5. Klik `Hapus` untuk menghapus data yang dipilih.
6. Klik `Reset` untuk mengosongkan form.
7. Klik `Keluar` untuk menutup aplikasi.

## Catatan Pengembangan

- Kolom `kode_barang` digunakan sebagai primary key.
- Saat data dipilih dari tabel, field kode barang dikunci agar primary key tidak diubah ketika proses edit.
- File `FormInventaris.form` dibuat oleh GUI Builder NetBeans, jadi sebaiknya perubahan layout dilakukan melalui NetBeans.
