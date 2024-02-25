CREATE TABLE MOVIE (
       id INT AUTO_INCREMENT PRIMARY KEY,
       title VARCHAR(255),
       description TEXT,
       rating FLOAT,
       image VARCHAR(255),
       createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO MOVIE (title, description, rating, image) VALUES
      ('Pengabdi Setan 2 Comunion', 'Dalah sebuah film horor Indonesia tahun 2022 yang disutradarai dan ditulis oleh Joko Anwar sebagai sekuel dari film tahun 2017, Pengabdi Setan.', 7.0, 'https://id.pinterest.com/pin/674203006690104692/'),
      ('Pengabdi Setan', 'Pengabdi Setan adalah sebuah film horor Indonesia yang dirilis pada tahun 2017. Film ini disutradarai oleh Joko Anwar dan menjadi salah satu film horor tersukses di Indonesia. Cerita berpusat pada seorang ibu tunggal dan empat anaknya yang mulai mengalami kejadian mistis setelah sang ibu meninggal dunia. Mereka kemudian menemukan bahwa ibu mereka memiliki hubungan dengan kekuatan supranatural yang menyeramkan.', 8.0, 'https://example.com/pengabdi_setan.jpg'),
      ('Misteri Hutan Gelap', 'Sebuah film thriller yang mengisahkan kejadian misterius di dalam hutan gelap, disutradarai oleh Siti Nuraini.', 6.5, 'https://example.com/misteri_hutan_gelap.jpg'),
      ('Rahasia Malam', 'Film horor yang mengungkap rahasia gelap di sebuah desa terpencil, disutradarai oleh Budi Santoso.', 7.8, 'https://example.com/rahasia_malam.jpg'),
      ('Hantu Rumah Kosong', 'Sebuah cerita seram tentang hantu-hantu yang menghuni rumah kosong di pinggiran kota, disutradarai oleh Triawan Adi.', 6.2, 'https://example.com/hantu_rumah_kosong.jpg'),
      ('Sesal di Malam Jumat', 'Film horor komedi yang mengisahkan petualangan lucu dan menyeramkan di malam Jumat, disutradarai oleh Dian Pratiwi.', 7.5, 'https://example.com/sesal_di_malam_jumat.jpg'),
      ('Kutukan Pusara', 'Sebuah kutukan mengerikan yang terjadi setelah pusara kuno digali kembali, disutradarai oleh Anton Widodo.', 6.9, 'https://example.com/kutukan_pusara.jpg'),
      ('Rumah Terlarang', 'Film horor yang mengisahkan petualangan menegangkan di dalam rumah terlarang, disutradarai oleh Maya Susanti.', 8.2, 'https://example.com/rumah_terlarang.jpg'),
      ('Teror Di Sekolah', 'Kejadian misterius dan teror di sebuah sekolah yang menyimpan rahasia kelam, disutradarai oleh Eko Nugroho.', 7.3, 'https://example.com/teror_di_sekolah.jpg');

SELECT * FROM MOVIE;

SELECT * FROM MOVIE WHERE id = 1;

UPDATE MOVIE
SET title = 'Judul Film Terupdate', description = 'Deskripsi film yang diperbarui', rating = 8.0, image = 'https://example.com/updated_image.jpg', updatedAt = NOW()
WHERE id = 1;

DELETE FROM MOVIE WHERE id = 1;
