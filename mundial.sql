-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-12-2022 a las 17:52:33
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mundial`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `continente`
--

CREATE TABLE `continente` (
  `id` int(12) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seleccion`
--

CREATE TABLE `seleccion` (
  `id` int(12) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `continente_id` int(12) NOT NULL,
  `tecnico` varchar(45) NOT NULL,
  `goles_favor` int(11) NOT NULL,
  `goles_contra` int(11) NOT NULL,
  `partidos_ganados` int(11) NOT NULL,
  `partidos_perdidos` int(11) NOT NULL,
  `partidos_jugados` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `continente`
--
ALTER TABLE `continente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `seleccion`
--
ALTER TABLE `seleccion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `continente_id` (`continente_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `continente`
--
ALTER TABLE `continente`
  MODIFY `id` int(12) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `seleccion`
--
ALTER TABLE `seleccion`
  ADD CONSTRAINT `seleccion_ibfk_1` FOREIGN KEY (`continente_id`) REFERENCES `continente` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
