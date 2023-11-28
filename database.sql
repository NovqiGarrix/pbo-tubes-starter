
SHOW DATABASES;

CREATE DATABASE praktikum_gui;

USE praktikum_gui;

CREATE TABLE jenis_kelamin (
    id VARCHAR(20) NOT NULL PRIMARY KEY,
    label VARCHAR(20) NOT NULL
) ENGINE InnoDB;

INSERT INTO jenis_kelamin
VALUES  ('laki-laki', 'Laki - Laki'),
        ('perempuan', 'Perempuan');

SELECT * FROM jenis_kelamin;

CREATE TABLE kategori_tiket (
    id VARCHAR(20) NOT NULL PRIMARY KEY,
    kategori VARCHAR(20) NOT NULL
) ENGINE InnoDB;

INSERT INTO kategori_tiket
VALUES  ('platinum', 'Platinum'),
        ('gold', 'Gold'),
        ('diamond', 'Diamond'),
        ('vvip', 'VVIP'),
        ('mega-vvip', 'Mega VVIP');

SELECT * FROM kategori_tiket;

CREATE TABLE users (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nama VARCHAR(265) NOT NULL,
    # Ini merupakan ForeignKey ke tabel jenis_kelamin
    jk VARCHAR(20) NOT NULL,
    email VARCHAR(64) NOT NULL,
    no_hp VARCHAR(14) NOT NULL,
    tgl_lahir DATE NOT NULL,
    # Ini merupakan ForeignKey ke tabel kategori_tiket
    kategori_tiket VARCHAR(20) NOT NULL,
    jlh_tiket INT NOT NULL
) ENGINE InnoDB;

SHOW TABLES;

SELECT * FROM users;

DELETE FROM users;