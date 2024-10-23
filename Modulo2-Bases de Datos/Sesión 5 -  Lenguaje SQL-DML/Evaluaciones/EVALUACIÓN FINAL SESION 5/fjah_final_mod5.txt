
/*********************************************************
SCRIPT EJERCICIO FINAL N°2 | MODULO 3
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
-- 1. Inserte los datos de una empresa
INSERT INTO empresa 
(rut, nombre, direccion, telefono, correo, web) 
VALUES
('12345678-9', 'Herramientas y Más', 'Calle de las Herramientas 456, Santiago', '223456789', 'info@herramientasymás.cl', 'www.herramientasymás.cl');

-- 2. Inserte 5 herramientas
INSERT INTO herramienta 
(idherramienta, nombre, preciodia) 
VALUES
(1, 'Taladro Eléctrico', 5000),
(2, 'Sierra Circular', 7000),
(3, 'Martillo', 2000),
(4, 'Destornillador', 1500),
(5, 'Lijadora', 6000);

-- 3. Inserte 3 clientes
INSERT INTO cliente 
(rut, nombre, correo, direccion, celular) 
VALUES
('98765432-1', 'Ana Torres', 'ana.torres@gmail.com', 'Av. del Trabajo 123, Santiago', '987123456'),
('12345678-9', 'Luis Pérez', 'luis.perez@yahoo.com', 'Calle Futura 456, Valparaíso', '912345678'),
('23456789-0', 'María López', 'maria.lopez@outlook.com', 'Calle Verde 789, Concepción', '923456789');

-- 4. Elimina el último cliente
DELETE FROM cliente
WHERE rut = '23456789-0';

-- 5. Elimina la primera herramienta
DELETE FROM herramienta
WHERE idherramienta = 1;

-- 6. Inserte 2 arriendos para cada cliente
INSERT INTO arriendo 
(folio, fecha, dias, valordia, garantia, herramienta_idherramienta, cliente_rut) 
VALUES
(1001, '2024-09-20', 3, 5000, 'Depósito de 15000', 1, '98765432-1'),  -- Arriendo de Taladro Eléctrico por Ana Torres
(1002, '2024-09-22', 5, 7000, 'Depósito de 35000', 2, '98765432-1'),  -- Arriendo de Sierra Circular por Ana Torres
(1003, '2024-09-21', 2, 2000, 'Depósito de 5000', 3, '12345678-9'),  -- Arriendo de Martillo por Luis Pérez
(1004, '2024-09-23', 4, 1500, 'Depósito de 6000', 4, '12345678-9');  -- Arriendo de Destornillador por Luis Pérez

-- 7. Modifique el correo electrónico del primer cliente
UPDATE cliente 
SET correo = 'ana.torres_new@gmail.com'
WHERE rut = '98765432-1';

-- 8. Liste todas las herramientas
SELECT idherramienta, nombre, preciodia 
FROM
herramienta h ;

-- 9. Liste los arriendos del segundo cliente
SELECT a.folio, a.fecha, a.dias, a.valordia, a.garantia, h.nombre AS herramienta_nombre
FROM arriendo a
JOIN herramienta h ON a.herramienta_idherramienta = h.idherramienta
WHERE a.cliente_rut = '12345678-9';  -- RUT de Luis Pérez

-- 10. Liste los clientes cuyo nombre contenga una a
SELECT rut, nombre, correo, direccion, celular
FROM cliente
WHERE nombre ILIKE '%a%'; 

-- 11. Obtenga el nombre de la segunda herramienta insertada
SELECT nombre
FROM herramienta
ORDER BY idherramienta
OFFSET 1 LIMIT 1;  -- Ignorar el primer registro y obtener el segundo

-- 12. Modifique los primeros 2 arriendos insertados con fecha 15/01/2020
-- Modificar el primer arriendo
UPDATE arriendo
SET fecha = '2020-01-15'
WHERE folio = 1001;

-- Modificar el segundo arriendo
UPDATE arriendo
SET fecha = '2020-01-15'
WHERE folio = 1002;

-- 13. Liste Folio, Fecha y ValorDia de los arriendos de enero del 2020
SELECT folio, fecha, valordia
FROM arriendo
WHERE fecha >= '2020-01-01' AND fecha < '2020-02-01';  -- Filtrar por enero de 2020
















