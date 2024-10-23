
/*********************************************************
SCRIPT EJERCICIO SESION N7 | MODULO 3
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
-- 1. Listar los clientes sin ventas por medio de una subconsulta.
SELECT *
FROM automotora.cliente c
WHERE c.rut NOT IN (
    SELECT v.cliente_rut
    FROM automotora.venta v
);

-- 2. Listar todas ventas con las siguientes columnas: Folio, Fecha, Monto, NombreCliente, RutCliente. 
SELECT 
    v.folio,
    v.fecha,
    v.monto,
    c.nombre AS NombreCliente,
    c.rut AS RutCliente
FROM 
    automotora.venta v
JOIN 
    automotora.cliente c ON v.cliente_rut = c.rut;

-- 3. Por medio de una subconsulta listar las ventas con la marca del vehículo más vendido
-- Clasificar los clientes según la siguiente tabla:
-- Total de ventas anuales    |  Clasificacion
-- 0 a 1.000.000							|  Standar
-- 1.000.001 a 3.000.000 			|  Gold
-- 3.000.001 o mas						|  Premium
SELECT 
    v.folio,
    v.fecha,
    v.monto,
    c.nombre AS NombreCliente,
    c.rut AS RutCliente,
    (CASE 
        WHEN SUM(v.monto) OVER (PARTITION BY c.rut) BETWEEN 0 AND 1000000 THEN 'Standar'
        WHEN SUM(v.monto) OVER (PARTITION BY c.rut) BETWEEN 1000001 AND 3000000 THEN 'Gold'
        WHEN SUM(v.monto) OVER (PARTITION BY c.rut) > 3000000 THEN 'Premium'
    END) AS Clasificacion,
    m.nombre AS MarcaMasVendida
FROM automotora.venta v
JOIN automotora.cliente c ON v.cliente_rut = c.rut
JOIN automotora.vehiculo ve ON v.vehiculo_idvehiculo = ve.idvehiculo
JOIN automotora.marca m ON ve.tipovehiculo_idtipovehiculo = m.idmarca
GROUP BY v.folio, v.fecha, v.monto, c.nombre, c.rut, m.nombre
ORDER BY v.fecha;






