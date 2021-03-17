-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 08-03-2021 a las 22:35:22
-- Versión del servidor: 8.0.13-4
-- Versión de PHP: 7.2.24-0ubuntu0.18.04.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dqFgfi37e7`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulos`
--

CREATE TABLE `articulos` (
  `CodigoArt` char(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `DescrArt` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CostoArt` float NOT NULL,
  `ImpuestoArt` int(11) NOT NULL,
  `Margen` float NOT NULL,
  `PvP` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `articulos`
--

INSERT INTO `articulos` (`CodigoArt`, `DescrArt`, `CostoArt`, `ImpuestoArt`, `Margen`, `PvP`) VALUES
('A001', 'Patatas', 5, 10, 5, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `capacidades`
--

CREATE TABLE `capacidades` (
  `NifEmp` varchar(9) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Capacidades` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `NIFCliente` varchar(9) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `DomicilioCliente` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NombreCliente` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`NIFCliente`, `DomicilioCliente`, `NombreCliente`) VALUES
('02745407A', 'Toledo', 'Maria'),
('02745407N', 'Casarrubios del Monte', 'Ochovo'),
('77777777B', 'Calle Alcorcon 12', 'Daniel');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contienen`
--

CREATE TABLE `contienen` (
  `CantidadArticulo` int(11) NOT NULL,
  `CodigoArt` char(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CodigoSuper` int(3) NOT NULL,
  `NumeroPedido` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `NombreEmp` int(50) NOT NULL,
  `TlfEmp` int(9) NOT NULL,
  `NifEmp` varchar(9) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `passwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `login`
--

INSERT INTO `login` (`id_usuario`, `nombre`, `passwd`) VALUES
(1, 'ochovo', '1234'),
(2, 'a', 'a');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `FechaPedido` date NOT NULL,
  `NumeroPedido` int(9) NOT NULL,
  `HoraPerido` time NOT NULL,
  `PrecioPedido` float NOT NULL,
  `CodigoSuper` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sirven`
--

CREATE TABLE `sirven` (
  `NumeroPedido` int(11) NOT NULL,
  `CodigoSuper` int(3) NOT NULL,
  `NIFCliente` varchar(9) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NifEmp` varchar(9) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `supermercados`
--

CREATE TABLE `supermercados` (
  `CodigoSuper` int(3) NOT NULL,
  `TlfSuper` int(9) NOT NULL,
  `SuperficieSuper` int(10) NOT NULL,
  `DomicilioSuper` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajan`
--

CREATE TABLE `trabajan` (
  `FucionEmp` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CodigoSuper` int(3) NOT NULL,
  `NifEmp` varchar(9) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulos`
--
ALTER TABLE `articulos`
  ADD PRIMARY KEY (`CodigoArt`);

--
-- Indices de la tabla `capacidades`
--
ALTER TABLE `capacidades`
  ADD PRIMARY KEY (`NifEmp`,`Capacidades`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`NIFCliente`);

--
-- Indices de la tabla `contienen`
--
ALTER TABLE `contienen`
  ADD PRIMARY KEY (`CodigoArt`,`CodigoSuper`,`NumeroPedido`),
  ADD KEY `CodigoSuper` (`CodigoSuper`),
  ADD KEY `NumeroPedido` (`NumeroPedido`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`NifEmp`);

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id_usuario`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`NumeroPedido`,`CodigoSuper`),
  ADD KEY `CodigoSuper` (`CodigoSuper`);

--
-- Indices de la tabla `sirven`
--
ALTER TABLE `sirven`
  ADD PRIMARY KEY (`NumeroPedido`,`CodigoSuper`,`NIFCliente`,`NifEmp`),
  ADD KEY `CodigoSuper` (`CodigoSuper`),
  ADD KEY `NIFCliente` (`NIFCliente`),
  ADD KEY `NifEmp` (`NifEmp`);

--
-- Indices de la tabla `supermercados`
--
ALTER TABLE `supermercados`
  ADD PRIMARY KEY (`CodigoSuper`);

--
-- Indices de la tabla `trabajan`
--
ALTER TABLE `trabajan`
  ADD PRIMARY KEY (`CodigoSuper`,`NifEmp`),
  ADD KEY `NifEmp` (`NifEmp`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `login`
--
ALTER TABLE `login`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `supermercados`
--
ALTER TABLE `supermercados`
  MODIFY `CodigoSuper` int(3) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `capacidades`
--
ALTER TABLE `capacidades`
  ADD CONSTRAINT `Capacidades_ibfk_1` FOREIGN KEY (`NifEmp`) REFERENCES `empleados` (`nifemp`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `contienen`
--
ALTER TABLE `contienen`
  ADD CONSTRAINT `Contienen_ibfk_1` FOREIGN KEY (`CodigoArt`) REFERENCES `articulos` (`codigoart`) ON UPDATE CASCADE,
  ADD CONSTRAINT `Contienen_ibfk_2` FOREIGN KEY (`CodigoSuper`) REFERENCES `supermercados` (`codigosuper`) ON UPDATE CASCADE,
  ADD CONSTRAINT `Contienen_ibfk_3` FOREIGN KEY (`NumeroPedido`) REFERENCES `pedidos` (`numeropedido`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `Empleados_ibfk_1` FOREIGN KEY (`NifEmp`) REFERENCES `capacidades` (`nifemp`);

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `Pedidos_ibfk_1` FOREIGN KEY (`CodigoSuper`) REFERENCES `supermercados` (`codigosuper`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `sirven`
--
ALTER TABLE `sirven`
  ADD CONSTRAINT `Sirven_ibfk_1` FOREIGN KEY (`CodigoSuper`) REFERENCES `supermercados` (`codigosuper`) ON UPDATE CASCADE,
  ADD CONSTRAINT `Sirven_ibfk_2` FOREIGN KEY (`NIFCliente`) REFERENCES `cliente` (`nifcliente`) ON UPDATE CASCADE,
  ADD CONSTRAINT `Sirven_ibfk_3` FOREIGN KEY (`NifEmp`) REFERENCES `empleados` (`nifemp`) ON UPDATE CASCADE,
  ADD CONSTRAINT `Sirven_ibfk_4` FOREIGN KEY (`NumeroPedido`) REFERENCES `pedidos` (`numeropedido`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `supermercados`
--
ALTER TABLE `supermercados`
  ADD CONSTRAINT `Supermercados_ibfk_1` FOREIGN KEY (`CodigoSuper`) REFERENCES `contienen` (`codigosuper`);

--
-- Filtros para la tabla `trabajan`
--
ALTER TABLE `trabajan`
  ADD CONSTRAINT `Trabajan_ibfk_1` FOREIGN KEY (`CodigoSuper`) REFERENCES `supermercados` (`codigosuper`) ON UPDATE CASCADE,
  ADD CONSTRAINT `Trabajan_ibfk_2` FOREIGN KEY (`NifEmp`) REFERENCES `empleados` (`nifemp`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
