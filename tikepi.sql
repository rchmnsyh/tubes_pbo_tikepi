-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2018 at 09:50 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 5.6.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tikepi`
--

-- --------------------------------------------------------

--
-- Table structure for table `gerbong`
--

CREATE TABLE `gerbong` (
  `id_gerbong` char(5) NOT NULL,
  `id_kereta` char(5) DEFAULT NULL,
  `nomor_gerbong` varchar(1) DEFAULT NULL,
  `kapasitas` double DEFAULT NULL,
  `status` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gerbong`
--

INSERT INTO `gerbong` (`id_gerbong`, `id_kereta`, `nomor_gerbong`, `kapasitas`, `status`) VALUES
('GK001', 'KA001', '1', 3, 'Tersedia'),
('GK002', 'KA001', '2', 3, 'Tersedia'),
('GK003', 'KA002', '1', 3, 'Tersedia'),
('GK004', 'KA002', '2', 3, 'Tersedia'),
('GK005', 'KA003', '1', 3, 'Tersedia'),
('GK006', 'KA003', '2', 3, 'Tersedia'),
('GK007', 'KA004', '1', 3, 'Tersedia'),
('GK008', 'KA004', '2', 3, 'Tersedia'),
('GK009', 'KA005', '1', 3, 'Tersedia'),
('GK010', 'KA005', '2', 3, 'Tersedia'),
('GK011', 'KA006', '1', 3, 'Tersedia'),
('GK012', 'KA006', '2', 3, 'Tersedia'),
('GK013', 'KA007', '1', 3, 'Tersedia'),
('GK014', 'KA007', '2', 3, 'Tersedia'),
('GK015', 'KA008', '1', 3, 'Tersedia'),
('GK016', 'KA008', '2', 3, 'Tersedia'),
('GK017', 'KA009', '1', 4, 'Tersedia'),
('GK018', 'KA009', '2', 4, 'Tersedia'),
('GK019', 'KA010', '1', 4, 'Tersedia'),
('GK020', 'KA010', '2', 4, 'Tersedia'),
('GK021', 'KA011', '1', 4, 'Tersedia'),
('GK022', 'KA011', '2', 4, 'Tersedia'),
('GK023', 'KA012', '1', 4, 'Tersedia'),
('GK024', 'KA012', '2', 4, 'Tersedia'),
('GK025', 'KA013', '1', 4, 'Tersedia'),
('GK026', 'KA013', '2', 4, 'Tersedia'),
('GK027', 'KA014', '1', 4, 'Tersedia'),
('GK028', 'KA014', '2', 4, 'Tersedia'),
('GK029', 'KA015', '1', 6, 'Tersedia'),
('GK030', 'KA015', '2', 6, 'Tersedia'),
('GK031', 'KA016', '1', 6, 'Tersedia'),
('GK032', 'KA016', '2', 6, 'Tersedia'),
('GK033', 'KA017', '1', 6, 'Tersedia'),
('GK034', 'KA017', '2', 6, 'Tersedia'),
('GK035', 'KA018', '1', 6, 'Tersedia'),
('GK036', 'KA018', '2', 6, 'Tersedia'),
('GK037', 'KA019', '1', 6, 'Tersedia'),
('GK038', 'KA019', '2', 6, 'Tersedia'),
('GK039', 'KA020', '1', 6, 'Tersedia'),
('GK040', 'KA020', '2', 6, 'Tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `jadwal`
--

CREATE TABLE `jadwal` (
  `kode_jadwal` char(5) NOT NULL,
  `id_kereta` char(5) DEFAULT NULL,
  `stasiun_asal` char(4) DEFAULT NULL,
  `stasiun_tujuan` char(4) DEFAULT NULL,
  `tgl_berangkat` date NOT NULL,
  `jam_berangkat` varchar(5) DEFAULT NULL,
  `jam_tiba` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jadwal`
--

INSERT INTO `jadwal` (`kode_jadwal`, `id_kereta`, `stasiun_asal`, `stasiun_tujuan`, `tgl_berangkat`, `jam_berangkat`, `jam_tiba`) VALUES
('JD001', 'KA001', 'BD', 'GMR', '2018-12-01', '18:30', '20:30'),
('JD002', 'KA002', 'SMT', 'SB', '2018-12-04', '02:30', '04:15'),
('JD003', 'KA003', 'JAKK', 'SB', '2018-12-03', '02:30', '23:15'),
('JD004', 'KA004', 'GMR', 'SB', '2018-12-01', '08:00', '15:00'),
('JD005', 'KA004', 'SB', 'GMR', '2018-12-04', '15:00', '22:00'),
('JD006', 'KA005', 'GMR', 'SLO', '2018-12-01', '08:00', '16:35'),
('JD007', 'KA006', 'SLO', 'GMR', '2018-12-01', '08:00', '16:35'),
('JD008', 'KA007', 'GMR', 'CN', '2018-12-05', '09:00', '11:56'),
('JD009', 'KA007', 'CN', 'GMR', '2018-12-05', '13:50', '16:49'),
('JD010', 'KA007', 'GMR', 'CN', '2018-12-05', '17:20', '20:16'),
('JD011', 'KA008', 'BD', 'SB', '2018-12-06', '08:00', '17:30'),
('JD012', 'KA008', 'SB', 'BD', '2018-12-06', '17:30', '23:30'),
('JD013', 'KA009', 'GMR', 'SMT', '2018-12-07', '06:00', '12:00'),
('JD014', 'KA009', 'SMT', 'GMR', '2018-12-07', '16:15', '22:15'),
('JD015', 'KA010', 'BD', 'SMT', '2018-12-05', '05:27', '14:00'),
('JD016', 'KA010', 'SMT', 'BD', '2018-12-05', '14:20', '22;18'),
('JD017', 'KA011', 'GMR', 'SB', '2018-12-10', '05:00', '18:00'),
('JD018', 'KA012', 'BD', 'SLO', '2018-12-13', '07:10', '15:48'),
('JD019', 'KA012', 'SLO', 'BD', '2018-12-13', '15:58', '23:55'),
('JD020', 'KA013', 'BD', 'ML', '2018-12-10', '07:05', '22:25'),
('JD021', 'KA014', 'PSE', 'YK', '2018-12-12', '06:15', '14:35'),
('JD022', 'KA014', 'YK', 'PSE', '2018-12-12', '14:50', '22:47'),
('JD023', 'KA015', 'PSE', 'CN', '2018-12-13', '05:45', '08:45'),
('JD024', 'KA016', 'PSE', 'KTA', '2018-12-11', '08:15', '19:15'),
('JD025', 'KA017', 'GMR', 'BD', '2018-12-16', '12:35', '16:00'),
('JD026', 'KA018', 'CN', 'GMR', '2018-12-18', '05:50', '09:05'),
('JD027', 'KA019', 'ML', 'PSE', '2018-12-13', '07:12', '22:47'),
('JD028', 'KA020', 'SMT', 'PSE', '2018-12-18', '08:00', '14:30'),
('JD029', 'KA020', 'PSE', 'SMT', '2018-12-18', '14:50', '22:39');

-- --------------------------------------------------------

--
-- Table structure for table `kereta`
--

CREATE TABLE `kereta` (
  `id_kereta` char(5) NOT NULL,
  `nama_kereta` varchar(20) DEFAULT NULL,
  `kapasitas` double DEFAULT NULL,
  `kelas` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kereta`
--

INSERT INTO `kereta` (`id_kereta`, `nama_kereta`, `kapasitas`, `kelas`) VALUES
('KA001', 'Argo Bromo', 6, 'Eksekutif'),
('KA002', 'Argo Dwipangga', 6, 'Eksekutif'),
('KA003', 'Argo Lawu', 6, 'Eksekutif'),
('KA004', 'Argo Jati', 6, 'Eksekutif'),
('KA005', 'Turangga', 6, 'Eksekutif'),
('KA006', 'Argo Sindoro', 6, 'Eksekutif'),
('KA007', 'Harina', 6, 'Eksekutif'),
('KA008', 'Gumarang', 6, 'Eksekutif'),
('KA009', 'Lodaya', 8, 'Bisnis'),
('KA010', 'Malabar', 8, 'Bisnis'),
('KA011', 'Fajar Utama', 8, 'Bisnis'),
('KA012', 'Senja Utama', 8, 'Bisnis'),
('KA013', 'Sawunggalih', 8, 'Bisnis'),
('KA014', 'Argo Parahyangan', 8, 'Bisnis'),
('KA015', 'Tegal Bahari', 12, 'Ekonomi'),
('KA016', 'Cirebon Ekspres', 12, 'Ekonomi'),
('KA017', 'Majapahit', 12, 'Ekonomi'),
('KA018', 'Menoreh', 12, 'Ekonomi'),
('KA019', 'Joglokerto', 12, 'Ekonomi'),
('KA020', 'Kutojaya', 12, 'Ekonomi');

-- --------------------------------------------------------

--
-- Table structure for table `kursi`
--

CREATE TABLE `kursi` (
  `id_kursi` char(6) NOT NULL,
  `id_gerbong` char(5) DEFAULT NULL,
  `kolom_kursi` char(1) DEFAULT NULL,
  `baris_kursi` char(1) DEFAULT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kursi`
--

INSERT INTO `kursi` (`id_kursi`, `id_gerbong`, `kolom_kursi`, `baris_kursi`, `status`) VALUES
('KRS001', 'GK001', '1', '1', 'Tersedia'),
('KRS002', 'GK001', '1', '2', 'Tersedia'),
('KRS003', 'GK001', '1', '3', 'Tersedia'),
('KRS004', 'GK002', '1', '1', 'Tersedia'),
('KRS005', 'GK002', '1', '2', 'Tersedia'),
('KRS006', 'GK002', '1', '3', 'Tersedia'),
('KRS007', 'GK003', '1', '1', 'Tersedia'),
('KRS008', 'GK003', '1', '2', 'Tersedia'),
('KRS009', 'GK003', '1', '3', 'Tersedia'),
('KRS010', 'GK004', '1', '1', 'Tersedia'),
('KRS011', 'GK004', '1', '2', 'Tersedia'),
('KRS012', 'GK004', '1', '3', 'Tersedia'),
('KRS013', 'GK005', '1', '1', 'Tersedia'),
('KRS014', 'GK005', '1', '2', 'Tersedia'),
('KRS015', 'GK005', '1', '3', 'Tersedia'),
('KRS016', 'GK006', '1', '1', 'Tersedia'),
('KRS017', 'GK006', '1', '2', 'Tersedia'),
('KRS018', 'GK006', '1', '3', 'Tersedia'),
('KRS019', 'GK007', '1', '1', 'Tersedia'),
('KRS020', 'GK007', '1', '2', 'Tersedia'),
('KRS021', 'GK007', '1', '3', 'Tersedia'),
('KRS022', 'GK008', '1', '1', 'Tersedia'),
('KRS023', 'GK008', '1', '2', 'Tersedia'),
('KRS024', 'GK008', '1', '3', 'Tersedia'),
('KRS025', 'GK009', '1', '1', 'Tersedia'),
('KRS026', 'GK009', '1', '2', 'Tersedia'),
('KRS027', 'GK009', '1', '3', 'Tersedia'),
('KRS028', 'GK010', '1', '1', 'Tersedia'),
('KRS029', 'GK010', '1', '2', 'Tersedia'),
('KRS030', 'GK010', '1', '3', 'Tersedia'),
('KRS031', 'GK011', '1', '1', 'Tersedia'),
('KRS032', 'GK011', '1', '2', 'Tersedia'),
('KRS033', 'GK011', '1', '3', 'Tersedia'),
('KRS034', 'GK012', '1', '1', 'Tersedia'),
('KRS035', 'GK012', '1', '2', 'Tersedia'),
('KRS036', 'GK012', '1', '3', 'Tersedia'),
('KRS037', 'GK013', '1', '1', 'Tersedia'),
('KRS038', 'GK013', '1', '2', 'Tersedia'),
('KRS039', 'GK013', '1', '3', 'Tersedia'),
('KRS040', 'GK014', '1', '1', 'Tersedia'),
('KRS041', 'GK014', '1', '2', 'Tersedia'),
('KRS042', 'GK014', '1', '3', 'Tersedia'),
('KRS043', 'GK015', '1', '1', 'Tersedia'),
('KRS044', 'GK015', '1', '2', 'Tersedia'),
('KRS045', 'GK015', '1', '3', 'Tersedia'),
('KRS046', 'GK016', '1', '1', 'Tersedia'),
('KRS047', 'GK016', '1', '2', 'Tersedia'),
('KRS048', 'GK016', '1', '3', 'Tersedia'),
('KRS049', 'GK017', '2', '1', 'Tersedia'),
('KRS050', 'GK017', '2', '2', 'Tersedia'),
('KRS051', 'GK018', '2', '1', 'Tersedia'),
('KRS052', 'GK018', '2', '2', 'Tersedia'),
('KRS053', 'GK019', '2', '1', 'Tersedia'),
('KRS054', 'GK019', '2', '2', 'Tersedia'),
('KRS055', 'GK020', '2', '1', 'Tersedia'),
('KRS056', 'GK020', '2', '2', 'Tersedia'),
('KRS057', 'GK021', '2', '1', 'Tersedia'),
('KRS058', 'GK021', '2', '2', 'Tersedia'),
('KRS059', 'GK022', '2', '1', 'Tersedia'),
('KRS060', 'GK022', '2', '2', 'Tersedia'),
('KRS061', 'GK023', '2', '1', 'Tersedia'),
('KRS062', 'GK023', '2', '2', 'Tersedia'),
('KRS063', 'GK024', '2', '1', 'Tersedia'),
('KRS064', 'GK024', '2', '2', 'Tersedia'),
('KRS065', 'GK025', '2', '1', 'Tersedia'),
('KRS066', 'GK025', '2', '2', 'Tersedia'),
('KRS067', 'GK026', '2', '1', 'Tersedia'),
('KRS068', 'GK026', '2', '2', 'Tersedia'),
('KRS069', 'GK027', '2', '1', 'Tersedia'),
('KRS070', 'GK027', '2', '2', 'Tersedia'),
('KRS071', 'GK028', '2', '1', 'Tersedia'),
('KRS072', 'GK028', '2', '2', 'Tersedia'),
('KRS073', 'GK029', '1', '1', 'Tersedia'),
('KRS074', 'GK029', '2', '1', 'Tersedia'),
('KRS075', 'GK030', '3', '1', 'Tersedia'),
('KRS076', 'GK030', '1', '2', 'Tersedia'),
('KRS077', 'GK031', '2', '2', 'Tersedia'),
('KRS078', 'GK031', '3', '2', 'Tersedia'),
('KRS079', 'GK032', '1', '1', 'Tersedia'),
('KRS080', 'GK032', '2', '1', 'Tersedia'),
('KRS081', 'GK033', '3', '1', 'Tersedia'),
('KRS082', 'GK033', '1', '2', 'Tersedia'),
('KRS083', 'GK034', '2', '2', 'Tersedia'),
('KRS084', 'GK034', '3', '2', 'Tersedia'),
('KRS085', 'GK035', '1', '1', 'Tersedia'),
('KRS086', 'GK035', '2', '1', 'Tersedia'),
('KRS087', 'GK036', '3', '1', 'Tersedia'),
('KRS088', 'GK036', '1', '2', 'Tersedia'),
('KRS089', 'GK037', '2', '2', 'Tersedia'),
('KRS090', 'GK037', '3', '2', 'Tersedia'),
('KRS091', 'GK038', '1', '1', 'Tersedia'),
('KRS092', 'GK038', '2', '1', 'Tersedia'),
('KRS093', 'GK039', '3', '1', 'Tersedia'),
('KRS094', 'GK039', '1', '2', 'Tersedia'),
('KRS095', 'GK040', '2', '2', 'Tersedia'),
('KRS096', 'GK040', '3', '2', 'Tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `penumpang`
--

CREATE TABLE `penumpang` (
  `id_penumpang` char(20) NOT NULL,
  `tipe_id` varchar(10) NOT NULL,
  `nama` varchar(40) DEFAULT NULL,
  `jenis_kelamin` char(1) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `no_hp` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penumpang`
--

INSERT INTO `penumpang` (`id_penumpang`, `tipe_id`, `nama`, `jenis_kelamin`, `tgl_lahir`, `no_hp`, `email`, `alamat`) VALUES
('1234567890987654310', 'Paspor', 'Novani Paliling', 'P', '1974-02-18', '(+62) 742-3322', 'Novani@ggril.com', 'Graha Motorent, Jl. KH. Abdullah Syafei No.3C-D Tebet Utara, Jakarta Selatan'),
('1234567890987654311', 'Paspor', 'Martius Rambulangi', 'L', '1952-07-12', '(+62) 811-2707', 'Martius@gjlil.com', 'JL Kebon Kacang 1 No. 2010240'),
('1234567890987654320', 'KTP', 'Yusri Marni Nathan', 'P', '1992-06-22', '(+62) 318-6575', 'Yusri@gjlil.com', 'Jl Palmerah Utr 14 Central Mas Pacific Bldg Lt 4 Suite 404,Kemanggisan'),
('1234567890987654321', 'KTP', 'Indri Tocing Lamba', 'P', '1961-02-03', '(+62) 750-6088', 'Indri@gmail.com', 'Mangga Dua Square Lt.1 Blok C no. 148-149 Jakarta, Mangga Dua Square Lt.1 Blok C no. 148-149 Jakarta'),
('1234567890987654322', 'KTP', 'Norce Basiang', 'P', '1972-01-02', '(+62) 511-5533', 'Norce@gwoil.com', 'Wonorejo Permai Timur I / 71, Jawa Timur'),
('1234567890987654323', 'KTP', 'Irmayana Agung', 'L', '1995-11-05', '(+62) 551-1470', 'Irmayana@gjlil.com', 'Jl Jend Sudirman Kav 10-11 Midplaza 2 Lt 17,Karet Tengsin'),
('1234567890987654324', 'KTP', 'Yanto Taruk Lembang', 'L', '1918-04-20', '(+62) 240-5927', 'Yanto@gjlil.com', 'Jl Puyuh Brt VI 9,Jurang Manggu Timur'),
('1234567890987654325', 'KTP', 'Rayni Sipah', 'P', '1966-02-19', '(+62) 741-4594', 'Rayni@gjlil.com', 'Jl.D-4 No. 8 Kel. Kebon Baru Kec. Tebet Jakarta, Dki Jakarta'),
('1234567890987654326', 'SIM', 'Lince Rambulangi', 'P', '1996-12-13', '(+62) 890-2689', 'Lince@gjail.com', 'JALAN JENDRAL SUDIRMAN KAV 11-12 NO. 08-09 SENAPELAN, RIAU 28884, INDONESIA'),
('1234567890987654327', 'SIM', 'Rachman Singgi', 'L', '1952-02-13', '(+62) 384-5792', 'Rachman@gjlil.com', 'Jl. Wijaya VIII No. 2 Melawai - Kebayoran Baru, Jakarta Selatan'),
('1234567890987654328', 'SIM', 'Bertus Bolle', 'L', '1976-10-02', '(+62) 406-7540', 'Bertus@g62il.com', '623/1 lt.3 Begum Rokeya Sarani'),
('1234567890987654329', 'SIM', 'Irwanto Pulullung', 'P', '1988-11-11', '(+62) 868-6326', 'Irwanto@gjlil.com', 'Jl Jatiwangi Kompl Antilope Bl B-17/195-B,Jati Waringin'),
('1234567890987654331', 'Paspor', 'Delfi Ayasari', 'P', '1972-05-21', '(+62) 576-6758', 'Delfi@gjlil.com', 'Jln Pendidikan 3, Dki Jakarta'),
('1234567890987654333', 'KTM', 'Febrianti Asri', 'P', '1995-08-21', '(+62) 895-8461', 'Febrianti@gjlil.com', 'Jln.Kiaracondong.GG.Advent No.45 KIRCON BANDUNG, Jawa Barat'),
('1234567890987654342', 'SIM', 'Dean Palobo', 'P', '1984-04-12', '(+62) 820-4793', 'Dean@gjlil.com', 'Jl Daan Mogot Kompl Marina Sayang Bl A-17'),
('1234567890987654376', 'Paspor', 'Ansi Palalangan', 'P', '1975-11-12', '(+62) 367-8068', 'Ansi@gruil.com', 'Ruko Sunset Indah II, Blok A4JL Sunset Boulevard, Kuta'),
('1234567890987654377', 'SIM', 'Melvin Palindang', 'L', '1983-12-13', '(+62) 524-3451', 'Melvin@gjlil.com', 'Jl Arteri Kelapa Dua II Bl B/40,Kebon Jeruk'),
('1234567890987654385', 'Paspor', 'Rampean Tanja', 'L', '1980-02-13', '(+62) 218-3296', 'Rampean@gjlil.com', 'jl.Dr Muwardi no.7, Bali'),
('1234567890987654392', 'SIM', 'Yohana Kalija', 'L', '1983-04-24', '(+62) 291-5441', 'Yohana@gjlil.com', 'Jl. Raya Berbek 46 Waru'),
('1234567890987654394', 'Paspor', 'Rizky Amba', 'L', '1990-02-11', '(+62) 348-1121', 'Rizky@gjlil.com', 'Jl Kendal 22,Menteng'),
('1301170066', 'KTP', 'Rachmansyah Adhi Widhianto', 'L', '1999-04-02', '089696969147', 'rachmansyah@student.telkomuniversity.ac.id', 'Moment of truth');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `id_petugas` char(8) NOT NULL,
  `nama` varchar(40) DEFAULT NULL,
  `jenis_kelamin` char(1) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `no_hp` varchar(15) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`id_petugas`, `nama`, `jenis_kelamin`, `tgl_lahir`, `no_hp`, `email`, `alamat`, `password`) VALUES
('PTGS0000', 'Dummy', 'X', '1945-08-17', NULL, NULL, NULL, 'Password'),
('PTGS0001', 'Arya Asoka', 'L', '1983-01-11', '(+62) 648-8959', 'Arya@grmal.com', 'Jl Imam Bonjol 61 Plaza Bumi Daya Lt 11,Menteng', 'Password'),
('PTGS0002', 'Aditya Abimanyu', 'L', '1984-02-21', '(+62) 977-0247', 'Aditya@grmal.com', 'Kediri, Tabanan, Bali', 'Password'),
('PTGS0003', 'Arjuna Basudewa', 'L', '1993-04-02', '(+62) 867-2478', 'Arjuna@grmal.com', 'Jl Industri Slt IV Kawasan Industri Jababeka Tahap II Bl GG-5', 'Password'),
('PTGS0004', 'Birendra Birawa', 'L', '1973-03-07', '(+62) 401-6385', 'Birendra@grmal.com', 'Jl Tarum Brt Ruko Puri Sentra Niaga Bl A/9,Cipinang Melayu', 'Password'),
('PTGS0005', 'Bimasena Barata', 'L', '1984-12-03', '(+62) 393-7553', 'Bimasena@grmal.com', 'Jalan Penggilingan Raya no.579 Cakung-Jakarta Timur', 'Password'),
('PTGS0006', 'Chandra Aji', 'L', '1980-10-12', '(+62) 958-0161', 'Chandra@grmal.com', 'Jl Lombok I Kawasan Industri MM 2100 Bl N/10-11', 'Password'),
('PTGS0007', 'Ekata Dananjaya', 'L', '1992-04-18', '(+62) 590-0380', 'Ekata@grmal.com', 'Perkantoran Plaza Pasifik Blok B3 No. 71, Jalan Raya Boulevard Barat. Kelapa Gading, Dki Jakarta', 'Password'),
('PTGS0008', 'Indra Hara', 'L', '1982-02-17', '(+62) 940-3218', 'Indra@grmal.com', 'Jl. Raya Ciater - BSD No.41', 'Password'),
('PTGS0009', 'Janu Kalya', 'L', '1966-06-12', '(+62) 505-2629', 'Janu@grmal.com', 'Jl. Raya Hankam No. 1 C', 'Password'),
('PTGS0010', 'Kamal Irawan', 'L', '1978-08-24', '(+62) 914-0095', 'Kamal@grmal.com', 'Jl Bukit Barisan Dlm 3, Sumatera Utara, 20111', 'Password'),
('PTGS0011', 'Mahesa Mahabala', 'L', '1980-02-12', '(+62) 481-8558', 'Mahesa@grmal.com', 'Jl.Rambutan Timur VIII no.226', 'Password'),
('PTGS0012', 'Tarendra Tanwira', 'L', '1992-07-16', '(+62) 980-5207', 'Tarendra@grmal.com', 'Jl Sultan Iskandar Muda Kav 30 Wisma Sentosa 12240', 'Password'),
('PTGS0013', 'Wira Widipa', 'L', '1982-02-17', '(+62) 686-2614', 'Wira@grmal.com', 'Banjar Dinas Melanting, Kec.Banjar', 'Password'),
('PTGS0014', 'Yasa Wijaya', 'L', '1994-11-03', '(+62) 787-9958', 'Yasa@grmal.com', 'Jl Cikini Raya Raya 84 RT RT 016/01,Cikini', 'Password'),
('PTGS0015', 'Yudistira Simanjuntak', 'L', '1986-03-02', '(+62) 945-9234', 'Yudistira@grmal.com', 'Jl Boulevard Artha Gading Rukan Artha Gading Niaga Bl F/21', 'Password'),
('PTGS0016', 'Adeen Abraham', 'L', '1998-12-01', '(+62) 408-1652', 'Adeen@grmal.com', 'Komplek Rukan Graha Cempaka Mas C 2 / 14, Jl. Letjend. Suprapto (Cempaka Mas Timur), Jakarta Pusat', 'Password'),
('PTGS0017', 'Bryan Christopher', 'L', '1997-09-15', '(+62) 899-1493', 'Bryan@grmal.com', 'Jl Pasanggrahan Raya 3-B,Meruya Ilir', 'Password'),
('PTGS0018', 'Ethan Frumentius', 'L', '1972-04-01', '(+62) 854-3835', 'Ethan@grmal.com', 'L-haj Shamsuddin Mansion (2nd Floor), 17', 'Password'),
('PTGS0019', 'Isaac Immanuel', 'L', '1982-05-13', '(+62) 872-2828', 'Isaac@grmal.com', 'Jl Pejuangan,Kebon Jeruk', 'Password'),
('PTGS0020', 'Ian Ismael', 'L', '1975-08-24', '(+62) 697-7867', 'Ian@grmal.com', 'Ampera 3 no 8 Daerah Khusus Ibukota Jakarta', 'Password');

-- --------------------------------------------------------

--
-- Table structure for table `stasiun`
--

CREATE TABLE `stasiun` (
  `kode_stasiun` char(4) NOT NULL,
  `nama_stasiun` varchar(20) DEFAULT NULL,
  `alamat_stasiun` varchar(50) DEFAULT NULL,
  `kelas_stasiun` varchar(15) DEFAULT NULL,
  `daerah_operasi` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stasiun`
--

INSERT INTO `stasiun` (`kode_stasiun`, `nama_stasiun`, `alamat_stasiun`, `kelas_stasiun`, `daerah_operasi`) VALUES
('AND', 'Andir', 'Jalan Ciroyom No. 1', 'Lokal', 'Bandung'),
('BD', 'Bandung', 'Jalan Stasiun Timur 1', 'Interlokal', 'Bandung'),
('CCL', 'Cicalengka', 'Jalan Stasiun Cicalengka No. 1', 'Lokal', 'Bandung'),
('CN', 'Cirebon', 'Jalan Raya Siliwangi', 'Lokal', 'Cirebon'),
('GDB', 'Gedebage', 'Jalan Gedebage', 'Lokal', 'Bandung'),
('GMR', 'Gambir', 'Jalan Medan Merdeka Timur No. 1', 'Interlokal', 'Jakarta'),
('JAKK', 'Jakarta Kota', 'Jalan Stasiun Kota No. 1', 'Interlokal', 'Jakarta'),
('KAC', 'Kiaracondong', 'Jalan Babakan Sari', 'Lokal', 'Bandung'),
('KTA', 'Kutoarjo', 'Jalan Stasiun Kutoarjo', 'Lokal', 'Purwokerto'),
('ML', 'Malang', 'Jalan Trunojoyo', 'Interlokal', 'Surabaya'),
('MRI', 'Manggarai', 'Jalan Manggarai Utara 1', 'Interlokal', 'Jakarta'),
('PDL', 'Padalarang', 'Jalan Raya Stasiun Padalarang No. 1', 'Lokal', 'Bandung'),
('PSE', 'Pasar Senen', 'Jalan Stasiun Senen No. 14', 'Interlokal', 'Jakarta'),
('PWT', 'Purwokerto', 'Jalan Stasiun Purwokerto', 'Lokal', 'Purwokerto'),
('SB', 'Surabaya', 'Jalan Stasiun Kota No. 9', 'Interlokal', 'Surabaya'),
('SLO', 'Solo Balapan', 'Jalan Wolter Monginsidi 112', 'Interlokal', 'Yogyakarta'),
('SMT', 'Semarang', 'Jalan Taman Tawang 1', 'Lokal', 'Semarang'),
('TEB', 'Tebet', 'Jalan Lapangan Ros Raya', 'Lokal', 'Jakarta'),
('TG', 'Tegal', 'Jalan Pancasila 1', 'Lokal', 'Semarang'),
('YK', 'Yogyakarta', 'Jalan Margo Utomo 1', 'Interlokal', 'Yogyakarta');

-- --------------------------------------------------------

--
-- Table structure for table `tiket`
--

CREATE TABLE `tiket` (
  `kode_tiket` char(6) NOT NULL,
  `id_penumpang` char(20) DEFAULT NULL,
  `id_petugas` char(8) DEFAULT NULL,
  `kode_jadwal` char(5) DEFAULT NULL,
  `id_kursi` char(6) DEFAULT NULL,
  `id_kereta` char(5) DEFAULT NULL,
  `tgl_pesan` date DEFAULT NULL,
  `harga` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tiket`
--

INSERT INTO `tiket` (`kode_tiket`, `id_penumpang`, `id_petugas`, `kode_jadwal`, `id_kursi`, `id_kereta`, `tgl_pesan`, `harga`) VALUES
('TIX001', '1301170066', 'PTGS0000', 'JD011', 'KRS005', 'KA008', '2018-12-01', 300000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gerbong`
--
ALTER TABLE `gerbong`
  ADD PRIMARY KEY (`id_gerbong`),
  ADD KEY `gerbong_fk` (`id_kereta`);

--
-- Indexes for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD PRIMARY KEY (`kode_jadwal`),
  ADD KEY `jadwal_fk1` (`stasiun_asal`),
  ADD KEY `jadwal_fk2` (`stasiun_tujuan`),
  ADD KEY `jadwal_fk3` (`id_kereta`);

--
-- Indexes for table `kereta`
--
ALTER TABLE `kereta`
  ADD PRIMARY KEY (`id_kereta`);

--
-- Indexes for table `kursi`
--
ALTER TABLE `kursi`
  ADD PRIMARY KEY (`id_kursi`),
  ADD KEY `kursi_fk` (`id_gerbong`);

--
-- Indexes for table `penumpang`
--
ALTER TABLE `penumpang`
  ADD PRIMARY KEY (`id_penumpang`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`id_petugas`);

--
-- Indexes for table `stasiun`
--
ALTER TABLE `stasiun`
  ADD PRIMARY KEY (`kode_stasiun`);

--
-- Indexes for table `tiket`
--
ALTER TABLE `tiket`
  ADD PRIMARY KEY (`kode_tiket`),
  ADD KEY `tiket_fk4` (`id_kursi`),
  ADD KEY `tiket_fk5` (`id_kereta`),
  ADD KEY `tiket_fk2` (`id_petugas`) USING BTREE,
  ADD KEY `tiket_fk1` (`id_penumpang`) USING BTREE,
  ADD KEY `tiket_fk3` (`kode_jadwal`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `gerbong`
--
ALTER TABLE `gerbong`
  ADD CONSTRAINT `gerbong_fk` FOREIGN KEY (`id_kereta`) REFERENCES `kereta` (`id_kereta`) ON DELETE CASCADE;

--
-- Constraints for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD CONSTRAINT `jadwal_fk1` FOREIGN KEY (`stasiun_asal`) REFERENCES `stasiun` (`kode_stasiun`) ON DELETE CASCADE,
  ADD CONSTRAINT `jadwal_fk2` FOREIGN KEY (`stasiun_tujuan`) REFERENCES `stasiun` (`kode_stasiun`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `jadwal_fk3` FOREIGN KEY (`id_kereta`) REFERENCES `kereta` (`id_kereta`);

--
-- Constraints for table `kursi`
--
ALTER TABLE `kursi`
  ADD CONSTRAINT `kursi_fk` FOREIGN KEY (`id_gerbong`) REFERENCES `gerbong` (`id_gerbong`) ON DELETE CASCADE;

--
-- Constraints for table `tiket`
--
ALTER TABLE `tiket`
  ADD CONSTRAINT `tiket_fk1` FOREIGN KEY (`id_penumpang`) REFERENCES `penumpang` (`id_penumpang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tiket_fk2` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id_petugas`) ON DELETE CASCADE,
  ADD CONSTRAINT `tiket_fk3` FOREIGN KEY (`kode_jadwal`) REFERENCES `jadwal` (`kode_jadwal`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tiket_fk4` FOREIGN KEY (`id_kursi`) REFERENCES `kursi` (`id_kursi`) ON DELETE CASCADE,
  ADD CONSTRAINT `tiket_fk5` FOREIGN KEY (`id_kereta`) REFERENCES `kereta` (`id_kereta`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
