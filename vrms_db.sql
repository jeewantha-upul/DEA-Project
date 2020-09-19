-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 03, 2020 at 04:03 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vrms_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `cat_id` int(11) NOT NULL,
  `type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`cat_id`, `type`) VALUES
(1, 'Luxury'),
(2, 'Normal');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `phone_no` varchar(10) NOT NULL,
  `email` varchar(45) NOT NULL,
  `nic` varchar(12) NOT NULL,
  `dl_no` varchar(10) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`first_name`, `last_name`, `gender`, `phone_no`, `email`, `nic`, `dl_no`, `dob`, `address`) VALUES
('Thissa', 'Dukgannarala', 'Male', '0318905673', 'thissa@gmail.com', '981234567V', 'BL123789', '1998-05-09', 'Thissamaharama');

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `phone_no` varchar(10) NOT NULL,
  `email` varchar(45) NOT NULL,
  `nic` varchar(12) NOT NULL,
  `dl_no` varchar(10) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`first_name`, `last_name`, `gender`, `phone_no`, `email`, `nic`, `dl_no`, `dob`, `address`) VALUES
('Santha', 'Rajapaksha', 'Male', '0318905673', 'santha@gmail.com', '981238905V', 'BL123789', '1998-09-25', 'Kahawatte, Rathnapura, Sri Lanka'),
('Thissa', 'Dukgannarala', 'Male', '0318905673', 'thissa@gmail.com', '981238905V', 'CL132456', '1998-05-05', 'Thissamaharama,\r\nKatharagama,\r\nSri Lanka                                            ');

-- --------------------------------------------------------

--
-- Table structure for table `make`
--

CREATE TABLE `make` (
  `make_id` int(11) NOT NULL,
  `name` varchar(35) NOT NULL,
  `cat_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `make`
--

INSERT INTO `make` (`make_id`, `name`, `cat_id`) VALUES
(1, 'Mitsubishi', 1),
(2, 'Suzuki', 2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_name` varchar(20) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `gender` varchar(10) NOT NULL,
  `phone_no` varchar(10) NOT NULL,
  `email` varchar(40) NOT NULL,
  `user_role` varchar(10) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_name`, `first_name`, `last_name`, `gender`, `phone_no`, `email`, `user_role`, `password`) VALUES
('admin', 'Indrajith', 'Liyanage', 'Male', '0773264114', 'uldindrajith@gmail.com', 'admin', 'pass'),
('kavinda', 'Kavinda', 'Jayasekara', 'Male', '0771234567', 'kavinda@gmail.com', 'admin', 'kavi1'),
('pavani', 'Pavani', 'Wijesekara', 'Female', '0779801234', 'wnpmanthila@gmail.com', 'admin', '123'),
('viraj', 'Sudasun Viraj', 'Malaviarachchi', 'Male', '0771234567', 'viraj@gmail.com', 'admin', 'koli1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`cat_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`nic`);

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`dl_no`);

--
-- Indexes for table `make`
--
ALTER TABLE `make`
  ADD PRIMARY KEY (`make_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
