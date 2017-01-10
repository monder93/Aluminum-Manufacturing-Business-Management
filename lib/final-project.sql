-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 10, 2017 at 09:12 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `final-project`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `id` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  `lname` varchar(20) COLLATE utf8_bin NOT NULL,
  `address` varchar(50) COLLATE utf8_bin NOT NULL,
  `phone` int(11) NOT NULL,
  `email` varchar(50) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`id`, `name`, `lname`, `address`, `phone`, `email`) VALUES
(1, 'monder', 'ashkar', 'deir hana', 520002001, 'monder@mondercompany.com');

-- --------------------------------------------------------

--
-- Table structure for table `customersdebts`
--

CREATE TABLE `customersdebts` (
  `סה"כ חוב (ש"ח)` int(11) NOT NULL,
  `סה"כ שולם (ש"ח)` int(11) NOT NULL,
  `סה"כ לתשלום(ש"ח)` int(11) NOT NULL,
  `שם לקוח` varchar(20) COLLATE utf8_bin NOT NULL,
  `תאריך` date NOT NULL,
  `מס'` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `debtsforsuppliers`
--

CREATE TABLE `debtsforsuppliers` (
  `סה"כ חוב (ש"ח)` int(11) NOT NULL,
  `סה"כ שולם (ש"ח)` int(11) NOT NULL,
  `סה"כ לתשלום(ש"ח)` int(11) NOT NULL,
  `שם ספק` int(11) NOT NULL,
  `תאריך` int(11) NOT NULL,
  `מס'` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `glassorders`
--

CREATE TABLE `glassorders` (
  `הערות` varchar(500) COLLATE utf8_bin NOT NULL,
  `שם ספק` varchar(50) COLLATE utf8_bin NOT NULL,
  `תיאור` varchar(500) COLLATE utf8_bin NOT NULL,
  `תאריך` date NOT NULL,
  `מס'` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `glassorders`
--

INSERT INTO `glassorders` (`הערות`, `שם ספק`, `תיאור`, `תאריך`, `מס'`) VALUES
('עד שבוע', 'M.S.I', 'בידודית', '2017-01-07', 1);

-- --------------------------------------------------------

--
-- Table structure for table `lintelsorders`
--

CREATE TABLE `lintelsorders` (
  `שם ספק` varchar(50) COLLATE utf8_bin NOT NULL,
  `כמות` int(11) NOT NULL,
  `תיאור` varchar(500) COLLATE utf8_bin NOT NULL,
  `תאריך` date NOT NULL,
  `מס'` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `perfectionsorders`
--

CREATE TABLE `perfectionsorders` (
  `שם ספק` varchar(50) COLLATE utf8_bin NOT NULL,
  `תיאור` varchar(500) COLLATE utf8_bin NOT NULL,
  `תאריך` date NOT NULL,
  `מס'` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `profilesorders`
--

CREATE TABLE `profilesorders` (
  `הערות` varchar(500) COLLATE utf8_bin NOT NULL,
  `שם ספק` varchar(50) COLLATE utf8_bin NOT NULL,
  `צבע` varchar(50) COLLATE utf8_bin NOT NULL,
  `תיאור` varchar(500) COLLATE utf8_bin NOT NULL,
  `תאריך` date NOT NULL,
  `מס'` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `projects`
--

CREATE TABLE `projects` (
  `מספר פרויקט` int(11) NOT NULL,
  `איש קשר` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `אתר` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `שם מזמין` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `צבע` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `מחיר צבע` int(50) NOT NULL,
  `זיגוג` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `מחיר זיגוג` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `projects`
--

INSERT INTO `projects` (`מספר פרויקט`, `איש קשר`, `אתר`, `שם מזמין`, `צבע`, `מחיר צבע`, `זיגוג`, `מחיר זיגוג`) VALUES
(1, 'זהבי', 'חיפה', 'גלעד', 'IRON', 40, 'בידודית', 40),
(8, 'ח', 'ח', 'ח', 'ח', 30, 'ח', 40);

-- --------------------------------------------------------

--
-- Table structure for table `projectsproducts`
--

CREATE TABLE `projectsproducts` (
  `מספר פרויקט` int(11) NOT NULL,
  `מספר מוצר` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `projectsproducts`
--

INSERT INTO `projectsproducts` (`מספר פרויקט`, `מספר מוצר`) VALUES
(1, 14),
(1, 12),
(1, 6),
(2, 14),
(2, 7),
(8, 111);

-- --------------------------------------------------------

--
-- Table structure for table `shuttersorders`
--

CREATE TABLE `shuttersorders` (
  `הערות` varchar(500) COLLATE utf8_bin NOT NULL,
  `שם ספק` varchar(50) COLLATE utf8_bin NOT NULL,
  `תיאור` varchar(500) COLLATE utf8_bin NOT NULL,
  `תאריך` date NOT NULL,
  `מס'` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `id` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  `lname` varchar(20) COLLATE utf8_bin NOT NULL,
  `number` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`id`, `name`, `lname`, `number`) VALUES
(1, 'hosam', 'khatib', 509363830),
(2, 'hosam', 'khatib', 509363830);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`מספר פרויקט`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `projects`
--
ALTER TABLE `projects`
  MODIFY `מספר פרויקט` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
