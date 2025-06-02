-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-06-2025 a las 07:02:28
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdduser`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `id_materia` int(11) DEFAULT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`id`, `nombre`, `apellido`, `id_materia`, `id_user`) VALUES
(1, 'Luis', 'Gómez', 1, 1),
(2, 'Ana', 'Gómez', 1, 1),
(4, 'kevin', 'kevin', 4, 3),
(7, 'Francisco Herrera', 'prueba', 6, 6),
(8, 'Waldo jose', 'prueba', 7, 8),
(11, 'Juana Karla', 'Aguillon', 9, 21),
(12, 'Juana Karla', 'Aguillon', 9, 25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`id`, `nombre`) VALUES
(1, 'Programación Java'),
(3, 'Matemáticas Básicas'),
(4, 'Matemáticas Discreta'),
(6, 'Programacion Orientada a Objetos'),
(7, 'Poo'),
(9, 'Estructuras');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id_user`, `username`, `firstname`, `lastname`, `age`, `password`) VALUES
(1, 'Jose_alumno', 'Jose', 'registro de alumno', 40, '$2a$10$2jdD5YPejtQlvkf6jl87E.xOshpE9lybW20ruA38CuwuIhaIebXpm'),
(2, 'profesor', 'Ana', 'Pérez', 30, '$2a$10$1YZYD.2YqSm.jOGQQGEZe.Ql3/LtBHgi04DhbIAXBPVhd9xNmlyo6'),
(3, 'profe_juan', 'Juan', 'Pérez', 35, '$2a$10$iU1kKFOYFguRyBsmPjNbt.Hvb4hO2JDq5JqoBlNAoQLitihjExJv2'),
(4, 'profe_maria', 'María', 'Rodríguez', 40, '$2a$10$kGqm6tzVCL/JZ0CbeK.1Ee6s/dY98HDpnOo9cfbWJg7GT7wmxkapm'),
(5, 'kevin', 'kevin', 'Rodríguez', 40, '$2a$10$meYTnxSqBHDWVkxeKmwvke8S1OA3Lyu52aiZpC2WCDWff04mhtzUK'),
(6, 'waldo1', 'waldo', 'Aguillon', 40, '$2a$10$TJCRILRUxxQneobvyLAH2uFtIN4J7iOkXl1EBsK.GgWTQi9sZ8l7m'),
(7, 'Francisco Herrera', 'prueba', 'Herrera', 45, '$2a$10$dNm24HZuJAPU0EcZV.5ELuNexMDhEh5WUh1t/MiBXcxW2weyfccAS'),
(8, 'Waldo jose', 'prueba', 'Herrera', 45, '$2a$10$5a9FK.fOAr/a6BNFzK/9ruXjVOYMTw9uQptGgByUGs39hZsNHTCPW'),
(18, 'Waldo jose', 'prueba', 'Herrera', 45, '$2a$10$lh7HWAIRo/Nts88PMi4rF.H9wKhSqsbpZw5WTtA7MuMNgLl/3/i0e'),
(19, 'Waldo jose', 'prueba', 'Herrera', 45, '$2a$10$gN0aJWCLYAQ1ZAP8dKG7b.PdPIFvdHedVcXyw/z6kKkfgKLXoOOGW'),
(21, 'pablo mena', 'prueba', 'Herrera', 45, '$2a$10$WwQQzZOtcbK7ezjW00Q4WeUtFYaVx4no3MfPp6OYFIRRqVxY5Cpka'),
(25, 'maria juana', 'perez', 'martin', 45, '$2a$10$KzAQNzPDnyirO2bF9OOEpOUZRAPgwTelB4kKGljnFx8ASgiRqQ0gu'),
(26, 'mario jose', 'mario', 'jose', 45, '$2a$10$q07AJcjFDISiQKJ4l8FKQeWJSX/M6FDHPDSKk4G/pHK1preTR1btO'),
(27, 'karen maria', 'karen', 'perez', 45, '$2a$10$/u0AB/B3YhXC229LC4A9pOBzB1EGQSsBOBY3681FJ39i2bJQwkwJi'),
(28, 'waldo mario', 'waldo', 'perez', 45, '$2a$10$.iJ94Qoy5wghuVY1te/Xq.DRlxxCLFDmh2Y//x8BsfdVpvrxad/Pu');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_materia` (`id_materia`),
  ADD KEY `id_user` (`id_user`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `materia`
--
ALTER TABLE `materia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD CONSTRAINT `alumno_ibfk_1` FOREIGN KEY (`id_materia`) REFERENCES `materia` (`id`),
  ADD CONSTRAINT `alumno_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
