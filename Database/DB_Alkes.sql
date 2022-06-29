-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.18-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for db_alat_kesehatan
CREATE DATABASE IF NOT EXISTS `db_alat_kesehatan` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `db_alat_kesehatan`;

-- Dumping structure for table db_alat_kesehatan.tb_login
CREATE TABLE IF NOT EXISTS `tb_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `foto` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_alat_kesehatan.tb_login: ~5 rows (approximately)
/*!40000 ALTER TABLE `tb_login` DISABLE KEYS */;
INSERT INTO `tb_login` (`id`, `nama`, `username`, `password`, `foto`) VALUES
	(1, 'Alif', 'admin', 'admin', 'https://images.tokopedia.net/img/cache/900/product-1/2020/4/14/batch-upload/batch-upload_274e1b09-484d-4e31-aabd-9092f6b95a49.jpg'),
	(2, 'Amin', 'cimon', 'cimon', 'https://images.tokopedia.net/img/cache/900/product-1/2020/4/14/batch-upload/batch-upload_274e1b09-484d-4e31-aabd-9092f6b95a49.jpg'),
	(27, 'kelompok3', 'kelompok3', 'kelompok3', ''),
	(28, 'kelompok3', 'kelompok3', 'kelompok3', ''),
	(29, 'helen', 'helen', 'helen', ''),
	(30, 'tes', 'tes', 'tes', '');
/*!40000 ALTER TABLE `tb_login` ENABLE KEYS */;

-- Dumping structure for table db_alat_kesehatan.tb_produk
CREATE TABLE IF NOT EXISTS `tb_produk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nm_produk` varchar(1000) NOT NULL DEFAULT '0',
  `dec_produk` varchar(1000) NOT NULL DEFAULT '0',
  `harga` int(11) NOT NULL DEFAULT 0,
  `image` varchar(200) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_alat_kesehatan.tb_produk: ~4 rows (approximately)
/*!40000 ALTER TABLE `tb_produk` DISABLE KEYS */;
INSERT INTO `tb_produk` (`id`, `nm_produk`, `dec_produk`, `harga`, `image`) VALUES
	(1, 'Kursi Roda', 'Kursi roda standar Rumah sakit yang berbahan besi ', 970000, 'https://static.bmdstatic.com/pk/product/large/5e69fc819b289.jpg'),
	(2, 'tes', 'uwuwuwuwuwuuwiwuiwiwwiw\neiwieiw', 35000, 'https://images.tokopedia.net/img/cache/900/product-1/2020/8/4/108293876/108293876_39b924df-82d5-4349-b7e3-8eddde9bb865_700_700'),
	(3, 'Tabung oksigen 1m³', 'Tbung Set Oksigen dengan volume oksigen 1m3 (satu meter kubik)', 12000, 'https://images.tokopedia.net/img/cache/900/VqbcmM/2021/11/9/66e31679-ef47-45a6-9ae0-1e6c55285260.jpg'),
	(4, 'Tensi Meter', 'Tensimeter Enhanced Intellisense', 460000, 'https://images.tokopedia.net/img/cache/900/product-1/2021/2/23/9153539/9153539_0fd021d3-f5e1-41f4-a995-ba3758bf146c.jpg');
/*!40000 ALTER TABLE `tb_produk` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
