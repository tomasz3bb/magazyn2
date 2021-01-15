-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 15 Sty 2021, 10:25
-- Wersja serwera: 10.4.16-MariaDB
-- Wersja PHP: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `storage`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `tproduct`
--

CREATE TABLE `tproduct` (
  `id` int(10) NOT NULL,
  `category` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `code` varchar(25) NOT NULL,
  `quantity` int(20) NOT NULL,
  `price` double(6,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `tproduct`
--

INSERT INTO `tproduct` (`id`, `category`, `name`, `code`, `quantity`, `price`) VALUES
(1, 'Motherboard', 'ASUS Pro 1', 'ASP12', 5, 465.00),
(2, 'Mouse', 'Gaming X2', 'GX2', 26, 50.00);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `tuser`
--

CREATE TABLE `tuser` (
  `id` int(10) NOT NULL,
  `login` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `role` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `tuser`
--

INSERT INTO `tuser` (`id`, `login`, `pass`, `role`) VALUES
(1, 'admin', 'admin', 'ADMIN'),
(2, 'tomek', 'tomek', 'USER');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `tproduct`
--
ALTER TABLE `tproduct`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `tuser`
--
ALTER TABLE `tuser`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `tproduct`
--
ALTER TABLE `tproduct`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT dla tabeli `tuser`
--
ALTER TABLE `tuser`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
