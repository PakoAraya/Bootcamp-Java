
/*********************************************************
SCRIPT EJERCICIO SESION N5 | MODULO 3
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
/*********************************************************
	1- Inserte los datos de la empresa
*********************************************************/
INSERT INTO automotora.empresa  
(rut, nombre, direccion, telefono, correo, web)
VALUES
('76451234-5', 'Automotora Los Pinos', 'Av. Libertad 1234, Santiago', '228765432', 'contacto@lospinos.cl', 'www.lospinos.cl'),
('76567890-1', 'Vehículos El Roble', 'Calle Central 567, Valparaíso', '322345678', 'ventas@elroble.cl', 'www.elrobleautos.cl');

/*********************************************************
	2- Inserte 2 tipos de vehiculos
*********************************************************/
INSERT INTO tipo_vehiculo 
(idtipo_vehiculo, nombre) 
VALUES
(1, 'Sedán'),
(2, 'SUV');

/*********************************************************
	3- Inserte 3 clientes
*********************************************************/
INSERT INTO cliente 
(rut, nombre, correo, direccion, celular, alta)
VALUES
('12345678-9', 'Juan Pérez', 'juan.perez@gmail.com', 'Av. Siempre Viva 742, Santiago', '987654321', 'S'),
('98765432-1', 'María González', 'maria.gonzalez@yahoo.com', 'Calle Las Rosas 123, Valparaíso', '912345678', 'N'),
('11223344-5', 'Carlos Martínez', 'carlos.martinez@outlook.com', 'Pje. Los Olivos 456, Concepción', '923456789', 'S');

/*********************************************************
	4- Inserte 2 marcas
*********************************************************/
INSERT INTO marca 
(idmarca, nombre) 
VALUES
(1, 'Toyota'),
(2, 'Ford');

/*********************************************************
	5- Inserte 5 vehiculos
*********************************************************/
INSERT INTO automotora.vehiculo 
(idvehiculo, patente, marca, modelo, color, precio, frecuencia_mantencion, marca_idmarca, tipovehiculo_idtipovehiculo) 
VALUES
(1, 'ABC1234', 'Toyota', 'Corolla', 'Blanco', 12000000, 10000, 1, 1),
(2, 'DEF5678', 'Ford', 'Focus', 'Rojo', 9500000, 12000, 2, 1),
(3, 'GHI9101', 'Toyota', 'RAV4', 'Negro', 18000000, 15000, 1, 2),
(4, 'JKL1213', 'Ford', 'Explorer', 'Azul', 22000000, 15000, 2, 2),
(5, 'MNO1415', 'Toyota', 'Yaris', 'Gris', 11000000, 10000, 1, 1);

/*********************************************************
	6- Elimina el ultimo cliente
*********************************************************/
DELETE FROM automotora.cliente
WHERE rut = '11223344-5';

/*********************************************************
	7- Inserte 1 venta para cada cliente
*********************************************************/
INSERT INTO automotora.venta (folio, fecha, monto, vehiculo_idvehiculo, cliente_rut) 
VALUES
(1001, '2024-09-20', 12000000, 1, '12345678-9'),  -- Venta de un Toyota Corolla a Juan Pérez
(1002, '2024-09-21', 9500000, 2, '98765432-1'),   -- Venta de un Ford Focus a María González
(1003, '2024-09-22', 18000000, 3, '12345678-9');  -- Venta de un Toyota RAV4 a Juan Pérez

/*********************************************************
	8- Modifique el nombre del segundo cliente
*********************************************************/
UPDATE automotora.cliente 
SET nombre = 'Maria Fernanda Esquivel'
WHERE rut = '98765432-1';

/*********************************************************
	9- Liste todas las ventas
*********************************************************/
SELECT v.folio, v.fecha, v.monto, v.vehiculo_idvehiculo, c.nombre AS nombre_cliente 
FROM venta v 
JOIN automotora .cliente c ON v.cliente_rut = c.rut;

/*********************************************************
	10- Liste las ventas del primer cliente
*********************************************************/
SELECT v.folio, v.fecha, v.monto, v.vehiculo_idvehiculo
FROM automotora.venta v
WHERE v.cliente_rut = '12345678-9';

/*********************************************************
	11- Obtenga la patente de todos los vehiculos
*********************************************************/
SELECT idvehiculo, patente
FROM automotora.vehiculo;











