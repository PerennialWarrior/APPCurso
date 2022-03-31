-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 31, 2022 at 03:05 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `appcurso`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrador`
--

CREATE TABLE `administrador` (
  `usuario` varchar(50) NOT NULL,
  `contrasena` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `administrador`
--

INSERT INTO `administrador` (`usuario`, `contrasena`) VALUES
('', ''),
('', ''),
('', ''),
('admin', 'pass123');

-- --------------------------------------------------------

--
-- Table structure for table `cursos`
--

CREATE TABLE `cursos` (
  `id` int(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `fechainicio` varchar(50) NOT NULL,
  `fechafin` varchar(50) NOT NULL,
  `horarios` varchar(50) NOT NULL,
  `fechasparciales` varchar(50) NOT NULL,
  `grupo` varchar(50) NOT NULL,
  `cupos` varchar(50) NOT NULL,
  `profesor` varchar(50) NOT NULL,
  `registrado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cursos`
--

INSERT INTO `cursos` (`id`, `nombre`, `descripcion`, `fechainicio`, `fechafin`, `horarios`, `fechasparciales`, `grupo`, `cupos`, `profesor`, `registrado`) VALUES
(8, 'Bases de datos 2', 'gsdfgsdf.', '23/1/1900', '26/1/1900', '1:23-12:23-Marte y Miércoles', '25/1/1900-24/1/1900-27/1/1900', '1', '23', '', '0');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `desactivar` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `cedula` varchar(50) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `rol` varchar(50) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `facultad` varchar(50) NOT NULL,
  `programa` varchar(50) NOT NULL,
  `cursos` varchar(50) NOT NULL,
  `matriculado` varchar(50) NOT NULL,
  `horarioatencion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`desactivar`, `nombre`, `apellido`, `cedula`, `usuario`, `rol`, `contrasena`, `codigo`, `correo`, `telefono`, `facultad`, `programa`, `cursos`, `matriculado`, `horarioatencion`) VALUES
('1', 'FASFASDF', 'FDSAF', '123', '1123', 'Estudiante', '123', '34543354', '5345', '34543', 'Facultad de Ciencias Administrativas', 'Administración de Empresas', 'Administración de sistemas', '0', ''),
('1', 'DFASF', 'FASDF', '1235', '1234', 'Estudiante', '123', '3445', '3455345345', '345345', 'Facultad de Ciencias Administrativas', 'Administración de Empresas', 'Administración de sistemas', '0', ''),
('1', 'FASDFDSAASD', 'FADS', '2344', '234231', 'Profesor', '123', '', 'fasdf', '2733-2733', 'Facultad de Ciencias Administrativas', '', 'Bases de datos 2', '0', '18:29-18:29'),
('1', 'WEFSDAFASD', 'ASDFS', '345345435', '4535', 'Profesor', '123', '', 'fsda', '7323723723-73233', 'Facultad de Ciencias Administrativas', '', 'Administración de sistemas', '0', '18:25-18:25'),
('1', 'DSAFAS', 'AFSDFSA', '345435', 'dsfasd', 'Profesor', '123', '', 'sadf', '27337233-237327', 'Facultad de Ciencias Administrativas', '', 'Administración de sistemas', '0', '18:26-18:26'),
('1', 'FADSFF', 'SDAFDSAF', '4536', '34523454', 'Estudiante', '123', '5345234', 'fdsafads', '72333723', 'Facultad de Ciencias Administrativas', 'Administración de Empresas', 'Bases de datos 2', '0', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`cedula`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cursos`
--
ALTER TABLE `cursos`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
