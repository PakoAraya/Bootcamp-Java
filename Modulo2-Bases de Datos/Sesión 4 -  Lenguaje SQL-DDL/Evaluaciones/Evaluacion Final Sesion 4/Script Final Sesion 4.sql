
-- Database: bootcamp

/*********************************************************
CREACION SCRIPT BASE DE DATOS SESION 4 | MODULO 3
ALUMNO: Francisco Javier Araya Hernandez
FECHA: 04/09/2024
MOTOR BASE DE DATOS: PostgreSQL 16.4-Alpine
*********************************************************/

-- Ejercicio final modulo 3
-- Creacion tabla empresa
CREATE TABLE modulo3.empresa(
	rut					VARCHAR(10) PRIMARY KEY,
	nombre			VARCHAR(120),
	direccion		VARCHAR(120),
	telefono		VARCHAR(15),
	correo			VARCHAR(80),
	web					VARCHAR(50)
);

-- Creacion tabla clientes
CREATE TABLE modulo3.cliente(
	rut					VARCHAR(10) PRIMARY KEY,
	nombre			VARCHAR(120),
	correo			VARCHAR(80),
	direccion 	VARCHAR(120),
	celular			VARCHAR(15)
);

-- Creacion tabla herramienta
CREATE TABLE modulo3.herramienta(
	idherramienta	NUMERIC(12) PRIMARY KEY,
	nombre				VARCHAR(120),
	preciodia			NUMERIC(12)
);

-- Creacion de la tabla arriendo
CREATE TABLE modulo3.arriendo(
	folio					NUMERIC(12) PRIMARY KEY,
	fecha					DATE,
	dias					NUMERIC(5),
	valordia			NUMERIC(12),
	garantia			VARCHAR(30),
	herramienta_idherramienta		NUMERIC(12),
	cliente_rut		VARCHAR(10),
	
	CONSTRAINT idherramienta_fk1 FOREIGN KEY(herramienta_idherramienta) REFERENCES modulo3.herramienta,
	CONSTRAINT icliente_fk2 FOREIGN KEY(cliente_rut) REFERENCES modulo3.cliente
);
