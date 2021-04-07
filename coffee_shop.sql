-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 07, 2021 at 03:14 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coffee_shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `drink`
--

CREATE TABLE `drink` (
  `drinkID` int(11) NOT NULL,
  `drinkName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `drinkTypeID` int(11) NOT NULL,
  `price` double NOT NULL,
  `image` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `drink`
--

INSERT INTO `drink` (`drinkID`, `drinkName`, `drinkTypeID`, `price`, `image`) VALUES
(2, 'CatKhox', 1, 112000, 'C:\\Users\\Administrator\\OneDrive\\Pictures\\emoji\\khok.png'),
(3, 'MeoReee', 4, 35000, 'C:\\Users\\Administrator\\OneDrive\\Pictures\\emoji\\2867_CatRee.png');

-- --------------------------------------------------------

--
-- Table structure for table `drinktype`
--

CREATE TABLE `drinktype` (
  `drinkTypeID` int(11) NOT NULL,
  `drinkTypeName` varchar(51) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `drinktype`
--

INSERT INTO `drinktype` (`drinkTypeID`, `drinkTypeName`) VALUES
(1, 'HKT\'s Drink'),
(3, 'Unknow drink'),
(4, 'Food');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employeeID` int(10) NOT NULL,
  `name` varchar(225) COLLATE utf8_unicode_ci NOT NULL,
  `role` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `salary` int(12) DEFAULT NULL,
  `email` varchar(225) COLLATE utf8_unicode_ci NOT NULL,
  `gender` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(225) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employeeID`, `name`, `role`, `salary`, `email`, `gender`, `address`, `password`) VALUES
(2, 'employee8', 'Employee', 10000099, 'email@gmail.com', 'Male', 'null', '123'),
(3, 'employee11', 'Employee', 10001100, 'email@gmail.com', 'Male', 'null fake', '123'),
(5, 'employee9', 'Admin', 1000000, 'email@gmail.com', 'Male', 'null', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `drink`
--
ALTER TABLE `drink`
  ADD PRIMARY KEY (`drinkID`),
  ADD KEY `drinkTypeID` (`drinkTypeID`);

--
-- Indexes for table `drinktype`
--
ALTER TABLE `drinktype`
  ADD PRIMARY KEY (`drinkTypeID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employeeID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `drink`
--
ALTER TABLE `drink`
  MODIFY `drinkID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `drinktype`
--
ALTER TABLE `drinktype`
  MODIFY `drinkTypeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `employeeID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `drink`
--
ALTER TABLE `drink`
  ADD CONSTRAINT `drink_ibfk_1` FOREIGN KEY (`drinkTypeID`) REFERENCES `drinktype` (`drinkTypeID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
