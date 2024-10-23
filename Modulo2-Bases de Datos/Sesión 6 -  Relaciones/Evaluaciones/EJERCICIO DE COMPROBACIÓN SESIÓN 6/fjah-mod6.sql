
/*********************************************************
SCRIPT EJERCICIO SESION N6 | MODULO 3
ALUMNO			: Francisco Javier Araya Hernandez
FECHA				: 12/09/2024
CURSO: 			: BOTIC-SOFOF-23-30-13-0064
*********************************************************/

/*********************************************************
SCRIPT CREACION DE ENTIDADES DE LA BASE DE DATOS
*********************************************************/
-- Tabla Empresa
CREATE TABLE automotora.empresa(
	rut					VARCHAR(10) PRIMARY KEY,
	nombre			VARCHAR(120),
	direccion		VARCHAR(120),
	telefono		VARCHAR(15),
	correo			VARCHAR(80),
	web					VARCHAR(50)
);

-- Tabla Cliente
CREATE TABLE automotora.cliente(
	rut 				VARCHAR(10) PRIMARY KEY,
	nombre			VARCHAR(120),
	correo			VARCHAR(80),
	direccion 	VARCHAR(120),
	celular			VARCHAR(15),
	alta				char(1)
);

-- Tabla Tipo_Vehiculo
CREATE TABLE tipo_vehiculo(
	idtipo_vehiculo		numeric(12,0) PRIMARY KEY,
	nombre						varchar(120)
);

-- Tabla Marca
CREATE TABLE automotora.marca(
	idmarca			NUMERIC(12,0) PRIMARY KEY,
	nombre			VARCHAR(120)
);

-- Tabla Vehiculo
CREATE TABLE automotora.vehiculo(
	idvehiculo			NUMERIC(12,0) PRIMARY KEY,
	patente					VARCHAR(10),
	marca						VARCHAR(20),
	modelo					VARCHAR(20),
	color						VARCHAR(15),
	precio					NUMERIC(12,0),
	frecuencia_mantencion	NUMERIC(5,0),
	marca_idmarca		NUMERIC(12,0),
	tipovehiculo_idtipovehiculo	NUMERIC(12,0),
	
	CONSTRAINT vehiculo_tipovehiculo_fk FOREIGN KEY (marca_idmarca) REFERENCES automotora.tipo_vehiculo(idtipo_vehiculo),
	CONSTRAINT vehiculo_marca_fk FOREIGN KEY (tipovehiculo_idtipovehiculo) REFERENCES automotora.marca(idmarca)
);

-- Tabla Venta
CREATE TABLE automotora.venta(
	folio				NUMERIC(12,0) PRIMARY KEY,
	fecha				DATE,
	monto				NUMERIC(12,0),
	vehiculo_idvehiculo	NUMERIC(12,0),
	cliente_rut	VARCHAR(10),
	
	CONSTRAINT venta_vehiculo_fk FOREIGN KEY (vehiculo_idvehiculo) REFERENCES automotora.vehiculo(idvehiculo),
	CONSTRAINT venta_cliente_fk FOREIGN KEY (cliente_rut) REFERENCES automotora.cliente(rut)
);

-- Tabla Mantencion
CREATE TABLE automotora.mantencion(
	idmantencion			NUMERIC(12,0) PRIMARY KEY,
	fecha							DATE,
	trabajosrealizados	VARCHAR(1000),
	venta_folio				NUMERIC(12,0),
	
	CONSTRAINT mantencion_venta_fk FOREIGN KEY (venta_folio) REFERENCES automotora.venta(folio)
);

/*********************************************************
	DESARROLLO DE EJERICICIOS
*********************************************************/
-- 1. Listar todos los vehículos que no han sido vendidos.
SELECT v.idvehiculo, v.patente, v.marca, v.modelo, v.color, v.precio
FROM automotora.vehiculo v
LEFT JOIN automotora.venta ve ON v.idvehiculo = ve.vehiculo_idvehiculo
WHERE ve.vehiculo_idvehiculo IS NULL;

-- 2. Listar todas las ventas de enero del 2020 con las columnas (Folio, FechaVenta,
-- MontoVenta, NombreCliente, RutCliente, Patente, NombreMarca, Modelo).
SELECT v.folio,
       v.fecha AS FechaVenta, 
       v.monto AS MontoVenta, 
       c.nombre AS NombreCliente, 
       c.rut AS RutCliente, 
       vh.patente, 
       m.nombre AS NombreMarca, 
       vh.modelo
FROM automotora.venta v
JOIN automotora.cliente c ON v.cliente_rut = c.rut
JOIN automotora.vehiculo vh ON v.vehiculo_idvehiculo = vh.idvehiculo
JOIN automotora.marca m ON vh.marca_idmarca = m.idmarca
WHERE v.fecha BETWEEN '2020-01-01' AND '2020-01-31';

-- 3. Sume las ventas por mes y marca del año 2020.
SELECT 
    TO_CHAR(v.fecha, 'YYYY-MM') AS Mes, 
    m.nombre AS NombreMarca, 
    SUM(v.monto) AS TotalVentas
FROM automotora.venta v
JOIN automotora.vehiculo vh ON v.vehiculo_idvehiculo = vh.idvehiculo
JOIN automotora.marca m ON vh.marca_idmarca = m.idmarca
WHERE v.fecha BETWEEN '2020-01-01' AND '2020-12-31'
GROUP BY Mes, m.nombre
ORDER BY Mes, m.nombre;

-- 4. Liste Rut y Nombre de las tablas cliente y empresa.
SELECT rut, nombre 
FROM automotora.cliente
UNION
SELECT rut, nombre 
FROM automotora.empresa;










