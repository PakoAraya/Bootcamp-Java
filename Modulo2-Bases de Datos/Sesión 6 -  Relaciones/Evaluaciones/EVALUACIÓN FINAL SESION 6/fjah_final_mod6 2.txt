
/*********************************************************
SCRIPT EJERCICIO FINAL N°6 | MODULO 3
ALUMNO			: Francisco Javier Araya Hernandez
FECHA				: 12/09/2024
CURSO       : BOTIC-SOFOF-23-30-13-0064
*********************************************************/

/*********************************************************
SCRIPT CREACION DE ENTIDADES DE LA BASE DE DATOS
*********************************************************/
-- Tabla Empresa
CREATE TABLE empresa(
	rut					varchar(10) PRIMARY KEY,
	nombre			varchar(120),
	direccion		varchar(120),
	telefono		varchar(15),
	correo			varchar(80),
	web					varchar(50)
);

-- Tabla Cliente
CREATE TABLE cliente(
	rut 				varchar(10) PRIMARY KEY,
	nombre 			varchar(120),
	correo 			varchar(80),
	direccion 	varchar(120),
	celular			varchar(15)
);

-- Tabla Herramienta
CREATE TABLE herramienta(
	idherramienta			numeric(12,0) PRIMARY KEY,
	nombre 						varchar(120),
	preciodia					numeric(12,0)
);

-- Tabla Arriendo
CREATE TABLE arriendo(
	folio							numeric(12,0) PRIMARY KEY,
	fecha							date,
	dias							numeric(5,0),
	valordia 					numeric(12,0),
	garantia					varchar(30),
	herramienta_idherramienta		numeric(12,0),
	cliente_rut				varchar(10),
	
	CONSTRAINT arriendo_herramienta_fk FOREIGN KEY (herramienta_idherramienta) REFERENCES herramienta (idherramienta),
	CONSTRAINT arriendo_cliente_fk FOREIGN KEY (cliente_rut) REFERENCES cliente (rut)
);

/*********************************************************
	DESARROLLO DE LOS EJERCICIOS
*********************************************************/
-- 1. Listar todos arriendos con las siguientes columnas: Folio, Fecha, Días, ValorDia,
-- NombreCliente, RutCliente.
SELECT 
    a.folio,
    a.fecha,
    a.dias,
    a.valordia,
    c.nombre AS NombreCliente,
    c.rut AS RutCliente
FROM arriendo a
JOIN cliente c ON a.cliente_rut = c.rut;


--2. Listar los clientes sin arriendos.
SELECT 
    c.rut, 
    c.nombre 
FROM cliente c
LEFT JOIN arriendo a ON c.rut = a.cliente_rut
WHERE a.folio IS NULL;

-- 3. Liste RUT y Nombre de las tablas empresa y cliente.
SELECT rut, nombre 
FROM empresa
UNION
SELECT rut, nombre 
FROM cliente;

-- 4. Liste la cantidad de arriendos por mes.
SELECT 
    EXTRACT(YEAR FROM fecha) AS anio,
    EXTRACT(MONTH FROM fecha) AS mes,
    COUNT(*) AS cantidad_arriendos
FROM arriendo
GROUP BY anio, mes
ORDER BY anio, mes;















