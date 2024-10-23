
-- Ejercicio 1
-- 1 Crear tabla empleados
CREATE TABLE	empleado(
	id_empleado			serial PRIMARY KEY,
	nombre					varchar(50),
	apellido				varchar (50),
	salario					decimal(10,2)
);
-- 2 Insertar al menos 3 empleados.
INSERT INTO empleado (
	nombre,
	apellido,
	salario 
)values
	('Pedro', 'Rodriguez', 5000000.90),
	('Luisa', 'Lane', 700000.80),
	('Tomas', 'Cox', 800000.80);
-- 3 Actualizar salario
UPDATE empleado 
	SET salario = 500000.50
	WHERE id_empleado  = 1;
-- 4 Eliminar un empleado
DELETE FROM empleado 
WHERE	apellido = 'Cox';
-- 5 Consultar los empleados con salario mayor a $3500
SELECT * 
FROM empleado e 
WHERE salario >= 3500;

--------------------------------------------------------------
-- Ejercicio 2
-- 1 Crear la tabla productos
CREATE TABLE	producto (
	id_producto				serial PRIMARY	KEY,
	nombre_producto		varchar(50),
	precio						decimal(10,2),
	cantidad					numeric(10)
);
-- 2 Insertar al menos 3 productos con sus nombres, precios y cantidades
INSERT INTO producto (
	nombre_producto , 
	precio,
	cantidad
)values 
	('Choquita', 150.50, 15),
	('Chocman', 200.30, 50),
	('Golpe', 180.80, 35);
-- 3 Actualizar la cantidad de alguno de los productos
UPDATE producto 
	SET cantidad = 50, precio = 800
	WHERE nombre_producto LIKE 'Choquita';
-- 4 Eliminar uno de los productos de la tabla
DELETE FROM producto 
	WHERE nombre_producto LIKE 'Golpe';
-- 5 Consultar productos cuyo precio sea mayor a %500
SELECT *
FROM producto p 
WHERE precio >= 500;

--------------------------------------------------------------
-- Ejercicio 3
-- 1 Crear la tabla clientes
CREATE TABLE cliente2(
	id_cliente			serial PRIMARY KEY,
	nombre					varchar (50),
	apellido 				varchar (50),
	email						varchar(50)
);
-- 2 Insertar clientes
INSERT INTO cliente2 (
	nombre,
	apellido,
	email 
)values 
	('Pedro', 'Escamoso','pescamoso@gmail.com'),
	('Peter', 'Peternov', 'ppeternov@peternov.com'),
	('Jacqueline', 'Mora', 'jackamoza@morazancorp.com');
-- 3 Actualizar el correo electronico de algun cliente
UPDATE cliente2
	SET email = 'pnov@peternov.com'
	WHERE id_cliente = 2;
-- 4 Eliminar un cliente
DELETE FROM cliente2 
WHERE id_cliente = 1;
-- 5 Consultar los clientes con apellido Ramirez
SELECT *
FROM cliente2 c 
WHERE apellido LIKE 'Ramirez';


--------------------------------------------------------------
-- Ejercicio 4
-- 1 Crear la tabla ventas
CREATE TABLE	ventas(
	id_venta 			serial PRIMARY KEY,
	fecha					date,
	total					decimal(10,2)
);
-- 2 Insertar 3 ventas, fechas y totales
INSERT INTO ventas(
	fecha,
	total
)values 
	('2022-07-22',50000.50),
	('2023-08-15',85000.80),
	('2024-04-30',75769.90);
-- 3 Actualizar el total de una venta
UPDATE ventas 
SET total = 86563.78
WHERE fecha = '2023-08-15'; 
-- 4 Eliminar una venta
DELETE FROM ventas 
WHERE id_venta = 3;
-- 5 Consultas ventas mayores a $2000
SELECT *
FROM ventas 
WHERE total >= 2000;

--------------------------------------------------------------
-- Ejercicio 5
-- 1 Crear la tabla proveedores
CREATE TABLE proveedores(
	id_proveedor			serial PRIMARY KEY,
	nombre_proveedor	varchar (50),
	telefono					varchar (15),
	ciudad						varchar (50)
);
-- 2 Insertar 3 proveedores
INSERT INTO proveedores(
	nombre_proveedor,
	telefono,
	ciudad 
) values 
	('Asturias-corp','87563597','Melipilla'),
	('Bazrap','87547597','Malloco'),
	('Talent','68563597','Santiago');
-- 3 Actualizar el telefono de un proveedor
UPDATE proveedores 
SET telefono = '78476047'
WHERE nombre_proveedor LIKE 'Bazrap';
-- 4 Eliminar un proveedor
DELETE FROM proveedores 
WHERE nombre_proveedor LIKE 'Talent';
-- 5 Consultar un proveedor de la ciudad de santiago
SELECT *
FROM proveedores p 
WHERE ciudad LIKE 'Santiago';



SELECT * FROM proveedores ;







