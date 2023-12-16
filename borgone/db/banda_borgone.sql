-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Set 02, 2023 alle 20:44
-- Versione del server: 10.4.27-MariaDB
-- Versione PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `banda_borgone`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `brano`
--

CREATE TABLE `brano` (
  `id_music_sheet` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `author` varchar(50) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `note` varchar(200) DEFAULT NULL,
  `progressive_number` int(11) NOT NULL,
  `title` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `brano_evento`
--

CREATE TABLE `brano_evento` (
  `id_music_sheet` bigint(20) NOT NULL,
  `id_event` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `calendario`
--

CREATE TABLE `calendario` (
  `id_calendar` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `end_date` date DEFAULT NULL,
  `note` varchar(200) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `evento`
--

CREATE TABLE `evento` (
  `id_event` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `event_date` date DEFAULT NULL,
  `event_hour` varchar(20) DEFAULT NULL,
  `event_place` varchar(30) DEFAULT NULL,
  `id_calendar` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `evento_personale`
--

CREATE TABLE `evento_personale` (
  `id_event` bigint(20) NOT NULL,
  `id_musiciant` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `musico`
--

CREATE TABLE `musico` (
  `id_musician` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `identification_document` varchar(20) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `start_year` varchar(15) DEFAULT NULL,
  `surname` varchar(30) DEFAULT NULL,
  `tax_id_code` varchar(20) DEFAULT NULL,
  `tessarate` bit(1) NOT NULL,
  `id_instrument` bigint(20) DEFAULT NULL,
  `id_role` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `ruolo`
--

CREATE TABLE `ruolo` (
  `id_role` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `role_name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `ruolo`
--

INSERT INTO `ruolo` (`id_role`, `active`, `role_name`) VALUES
(1, b'1', 'Presidente');

-- --------------------------------------------------------

--
-- Struttura della tabella `strumento`
--

CREATE TABLE `strumento` (
  `id_instrument` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `instrument_key` varchar(20) DEFAULT NULL,
  `instrument_name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `brano`
--
ALTER TABLE `brano`
  ADD PRIMARY KEY (`id_music_sheet`);

--
-- Indici per le tabelle `brano_evento`
--
ALTER TABLE `brano_evento`
  ADD KEY `FKlyt6dqa9l8gfisxniynskvy11` (`id_event`),
  ADD KEY `FK3drgbr3kgx6poj3bcptvaieoi` (`id_music_sheet`);

--
-- Indici per le tabelle `calendario`
--
ALTER TABLE `calendario`
  ADD PRIMARY KEY (`id_calendar`);

--
-- Indici per le tabelle `evento`
--
ALTER TABLE `evento`
  ADD PRIMARY KEY (`id_event`),
  ADD KEY `FK1fxvc40w6iokybcfkkxbve7nn` (`id_calendar`);

--
-- Indici per le tabelle `evento_personale`
--
ALTER TABLE `evento_personale`
  ADD KEY `FKd9kem69i92ne77hlub7yxvcde` (`id_musiciant`),
  ADD KEY `FKcrtkbrgqpqxkl91w0pl6v36qg` (`id_event`);

--
-- Indici per le tabelle `musico`
--
ALTER TABLE `musico`
  ADD PRIMARY KEY (`id_musician`),
  ADD KEY `FK9i4gysfq78shclwmeeics8mmc` (`id_instrument`),
  ADD KEY `FKf7ac1nxouyuwavfufa6wouc4` (`id_role`);

--
-- Indici per le tabelle `ruolo`
--
ALTER TABLE `ruolo`
  ADD PRIMARY KEY (`id_role`);

--
-- Indici per le tabelle `strumento`
--
ALTER TABLE `strumento`
  ADD PRIMARY KEY (`id_instrument`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `brano`
--
ALTER TABLE `brano`
  MODIFY `id_music_sheet` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `calendario`
--
ALTER TABLE `calendario`
  MODIFY `id_calendar` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `evento`
--
ALTER TABLE `evento`
  MODIFY `id_event` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `musico`
--
ALTER TABLE `musico`
  MODIFY `id_musician` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `ruolo`
--
ALTER TABLE `ruolo`
  MODIFY `id_role` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `strumento`
--
ALTER TABLE `strumento`
  MODIFY `id_instrument` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `brano_evento`
--
ALTER TABLE `brano_evento`
  ADD CONSTRAINT `FK3drgbr3kgx6poj3bcptvaieoi` FOREIGN KEY (`id_music_sheet`) REFERENCES `evento` (`id_event`),
  ADD CONSTRAINT `FKlyt6dqa9l8gfisxniynskvy11` FOREIGN KEY (`id_event`) REFERENCES `brano` (`id_music_sheet`);

--
-- Limiti per la tabella `evento`
--
ALTER TABLE `evento`
  ADD CONSTRAINT `FK1fxvc40w6iokybcfkkxbve7nn` FOREIGN KEY (`id_calendar`) REFERENCES `calendario` (`id_calendar`);

--
-- Limiti per la tabella `evento_personale`
--
ALTER TABLE `evento_personale`
  ADD CONSTRAINT `FKcrtkbrgqpqxkl91w0pl6v36qg` FOREIGN KEY (`id_event`) REFERENCES `musico` (`id_musician`),
  ADD CONSTRAINT `FKd9kem69i92ne77hlub7yxvcde` FOREIGN KEY (`id_musiciant`) REFERENCES `evento` (`id_event`);

--
-- Limiti per la tabella `musico`
--
ALTER TABLE `musico`
  ADD CONSTRAINT `FK9i4gysfq78shclwmeeics8mmc` FOREIGN KEY (`id_instrument`) REFERENCES `strumento` (`id_instrument`),
  ADD CONSTRAINT `FKf7ac1nxouyuwavfufa6wouc4` FOREIGN KEY (`id_role`) REFERENCES `ruolo` (`id_role`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
