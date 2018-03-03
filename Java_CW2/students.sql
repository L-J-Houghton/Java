-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 06, 2017 at 12:25 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `students`
--

-- --------------------------------------------------------

--
-- Table structure for table `marks_table`
--

CREATE TABLE `marks_table` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `year` int(11) NOT NULL,
  `marks` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marks_table`
--

INSERT INTO `marks_table` (`id`, `name`, `year`, `marks`) VALUES
(1, 'Alain A', 2, '75'),
(2, 'Michael B', 3, '85'),
(3, 'Chen C', 1, '55'),
(4, 'Caroline D', 2, '60'),
(5, 'Mohamed E', 2, '60'),
(6, 'Alex F', 1, '55'),
(7, 'Sofia O', 3, '88'),
(8, 'Samir O', 1, '95'),
(9, 'Rob G', 2, '78'),
(10, 'Big K', 3, '55');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `marks_table`
--
ALTER TABLE `marks_table`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `marks_table`
--
ALTER TABLE `marks_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
