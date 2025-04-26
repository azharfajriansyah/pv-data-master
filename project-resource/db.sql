CREATE DATABASE `penjualan` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `kasir` (
  `id` varchar(10) NOT NULL,
  `nama` varchar(30) DEFAULT NULL,
  `jenis_kelamin` varchar(15) DEFAULT NULL,
  `no_telepon` varchar(20) DEFAULT NULL,
  `agama` varchar(15) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `pelanggan` (
  `id` varchar(6) NOT NULL,
  `nmplg` varchar(25) DEFAULT NULL,
  `jenis` varchar(20) DEFAULT NULL,
  `telepon` varchar(20) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `barang` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `kode` varchar(100) DEFAULT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `jenis` varchar(100) DEFAULT NULL,
  `harga_beli` int DEFAULT NULL,
  `harga_jual` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
