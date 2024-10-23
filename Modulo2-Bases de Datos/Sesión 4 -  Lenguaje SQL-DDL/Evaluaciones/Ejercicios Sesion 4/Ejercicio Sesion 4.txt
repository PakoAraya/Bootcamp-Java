
/*********************************************************
CREACION SCRIPT BASE DE DATOS SESION 4 | MODULO 3
ALUMNO: Francisco Javier Araya Hernandez
FECHA: 03/09/2024
MOTOR BASE DE DATOS: PostgreSQL 16.4-Alpine
*********************************************************/

-- Creacion tabla empresa
CREATE TABLE modulo3.empresa(
	rut							VARCHAR(10),
	nombre					VARCHAR(120),
	direccion				VARCHAR(120),
	telefono				VARCHAR(15),
	correo					varchar(80),
	web							VARCHAR(50)
);


-- Creacion tabla cliente
CREATE TABLE modulo3.cliente(
	rut							VARCHAR(10) PRIMARY KEY,
	nombre					VARCHAR(120),
	correo					VARCHAR(80),
	direccion				VARCHAR(120),
	celular					VARCHAR(15),
	alta						CHAR(1)
);

-- Creacion de la tabla 
CREATE TABLE modulo3.tipovehiculo(
	idtipovehiculo	NUMERIC(12) PRIMARY KEY,
	nombre					VARCHAR(120)
);

-- Creacion de la tabla marca
CREATE TABLE modulo3.marca(
	idmarca				NUMERIC(12) PRIMARY KEY,
	nombre					VARCHAR(120)
);

-- Creacion de la tabla vehiculo
CREATE TABLE modulo3.vehiculo(
	idvehiculo									NUMERIC(12) PRIMARY KEY,
	patente											VARCHAR(10),
	marca												VARCHAR(20),
	modelo											VARCHAR(20),
	color												VARCHAR(15),
	precio											NUMERIC(12),
	frecuenciamantencion				NUMERIC(5),
	marca_idmarca								NUMERIC(12),
	tipovehiculo_idtipovehiculo	NUMERIC(12),
	
	CONSTRAINT idmarca_fk1 FOREIGN KEY(marca_idmarca) REFERENCES modulo3.marca,
	CONSTRAINT idtipovehiculo_fk2 FOREIGN KEY(tipovehiculo_idtipovehiculo) REFERENCES modulo3.tipovehiculo
);

-- Creacion de la tabla venta
CREATE TABLE modulo3.venta(
	folio								NUMERIC(12) PRIMARY KEY,
	fecha								DATE,
	monto								NUMERIC(12),
	vehiculo_idvehiculo	NUMERIC(12),
	cliente_rut					VARCHAR(10),
	
	CONSTRAINT idvehiculo_fk1 FOREIGN KEY(vehiculo_idvehiculo) REFERENCES modulo3.vehiculo,
	CONSTRAINT idcliente_fk2 FOREIGN KEY(cliente_rut) REFERENCES modulo3.cliente	
);

-- Creacion de la tabla mantencion
CREATE TABLE modulo3.mantencion(
	idmantencion				NUMERIC(12) PRIMARY KEY,
	fecha								DATE,
	trabajosrealizados	VARCHAR(1000),
	venta_folio					NUMERIC(12),
	
	CONSTRAINT idventa_fk1 FOREIGN KEY(venta_folio) REFERENCES modulo3.venta
);


-- SELECT * from modulo3.mantencion;