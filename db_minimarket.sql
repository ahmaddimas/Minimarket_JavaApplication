-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 04 Mar 2017 pada 13.38
-- Versi Server: 10.1.10-MariaDB
-- PHP Version: 7.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `minimarket`
--
CREATE DATABASE IF NOT EXISTS `minimarket` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `minimarket`;

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `id_barang` varchar(20) NOT NULL,
  `kategori` text NOT NULL,
  `nama_barang` text NOT NULL,
  `stok` int(20) NOT NULL,
  `harga_jual` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`id_barang`, `kategori`, `nama_barang`, `stok`, `harga_jual`) VALUES
('1', 'Elektronik', 'TV', 5, 400000),
('2', 'Elektronik', 'AC', 9, 500000),
('3', 'makanan', 'Sari Roti', 6, 10000),
('4', 'DLL', 'Racun', 10, 5000),
('5', 'Alat Mandi', 'Sabun', 100, 1500),
('6', 'Alat Mandi', 'Odol', 98, 1500),
('8991389220016', 'DLL', 'buku', 9, 2000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori`
--

CREATE TABLE `kategori` (
  `idKat` int(11) NOT NULL,
  `kategori` text NOT NULL,
  `deskripsi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kategori`
--

INSERT INTO `kategori` (`idKat`, `kategori`, `deskripsi`) VALUES
(2, 'Elektronik', 'Alat - alat elektronik untuk rumah tangga'),
(4, 'makanan', 'makanan'),
(6, 'DLL', 'Dll'),
(7, 'Alat Mandi', 'Berbagai alat mandi seperti sabun, shampoo, sikat gigi, pasta, dll');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengadaan`
--

CREATE TABLE `pengadaan` (
  `id_pengadaan` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `supplier` text NOT NULL,
  `jumlah` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengadaan`
--

INSERT INTO `pengadaan` (`id_pengadaan`, `username`, `id_barang`, `tanggal`, `supplier`, `jumlah`) VALUES
('TB.01.03.2016.100', 'Admin', 1, '2016-03-01', 'Aku', 0),
('TB.01.03.2016.101', 'Admin', 1, '2016-03-01', 'Aku', 0),
('TB.01.03.2016.102', 'Admin', 1, '2016-03-01', 'Saya', 0),
('TB.01.03.2016.103', 'Admin', 1, '2016-03-01', 'Saya', 0),
('TB.02.03.2017.100', 'Admin', 1, '2017-03-02', 'Aa', 6),
('TB.02.03.2017.101', 'Admin', 1, '2017-03-02', 'Aa', 6),
('TB.02.03.2017.102', 'Admin', 1, '2017-03-02', 'Aa', 6),
('TB.02.03.2017.103', 'Admin', 4, '2017-03-02', 'Aa', 6),
('TB.17.03.2016.100', 'Admin', 3, '2016-03-17', 'Trischa', 89);

-- --------------------------------------------------------

--
-- Struktur dari tabel `penjualan`
--

CREATE TABLE `penjualan` (
  `id_penjualan` int(11) NOT NULL,
  `no_struk` varchar(30) NOT NULL,
  `username` text NOT NULL,
  `id_barang` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `tanggal_penjualan` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `penjualan`
--

INSERT INTO `penjualan` (`id_penjualan`, `no_struk`, `username`, `id_barang`, `jumlah`, `harga`, `tanggal_penjualan`) VALUES
(1, ' 04052016_143735', 'root', 2, 1, 500000, '2016-05-04'),
(2, ' 04052016_143827', 'root', 3, 3, 30000, '2016-05-04'),
(3, ' 04052016_143827', 'root', 6, 2, 3000, '2016-05-04'),
(4, ' 03032017_103145', 'root', 2, 1, 500000, '2017-03-03'),
(5, ' 03032017_103220', 'root', 4, 10, 50000, '2017-03-03');

-- --------------------------------------------------------

--
-- Struktur dari tabel `rel_pengadaan_barang`
--

CREATE TABLE `rel_pengadaan_barang` (
  `id_pengadaan` varchar(30) NOT NULL,
  `id_barang` varchar(30) NOT NULL,
  `jumlah` int(30) NOT NULL,
  `harga_beli_satuan` int(30) NOT NULL,
  `belum_terjual` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `rel_penjualan_barang`
--

CREATE TABLE `rel_penjualan_barang` (
  `id_barang` varchar(30) NOT NULL,
  `id_penjualan` varchar(30) NOT NULL,
  `jumlah` int(30) NOT NULL,
  `laba` int(30) NOT NULL,
  `harga_barang` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `level` varchar(30) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `no_telp` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`username`, `password`, `level`, `nama`, `alamat`, `no_telp`) VALUES
('root', 'root', '1', 'Admin', 'Admin', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`idKat`);

--
-- Indexes for table `pengadaan`
--
ALTER TABLE `pengadaan`
  ADD PRIMARY KEY (`id_pengadaan`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`id_penjualan`);

--
-- Indexes for table `rel_pengadaan_barang`
--
ALTER TABLE `rel_pengadaan_barang`
  ADD PRIMARY KEY (`id_pengadaan`);

--
-- Indexes for table `rel_penjualan_barang`
--
ALTER TABLE `rel_penjualan_barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kategori`
--
ALTER TABLE `kategori`
  MODIFY `idKat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `id_penjualan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
