
-- Ejercicio de relaciones sql
CREATE TABLE	proveedor(
	id_proveedor			serial PRIMARY KEY,
	nombre 						varchar(100),
	email							varchar (100),
	telefono					varchar (15),
	direccion 				varchar(100)
);



CREATE TABLE producto(
	id_producto				serial PRIMARY KEY,
	nombre 						varchar (100),
	precio						decimal(12,2),
	cantidad					int,
	fecha							date,
	id_proveedor			serial REFERENCES proveedor (id_proveedor)
);

--Insertar 5 proveedores y 8 productos
INSERT INTO proveedor (
	nombre, email, telefono, direccion 
)VALUES
('Carozzi', 'carozzi@gmail.com', '57638576', 'Av. Siempre Viva 112'),
('Parma', 'parma@parma.com', '57763675', 'Av. Toscana 567'),
('Luchetti', 'contacto@luchetti.com', '75663856', 'Los Laureles 115'),
('Colun', 'mercado@colun.com', '567884356', 'Av Osorno 456'),
('Coca Cola', 'contacto@cocacola.com', '5566788', 'Av El Colorado 739');

INSERT INTO producto (
	nombre, precio, cantidad, fecha, id_proveedor 
)VALUES
('Pasta 77', 3500, 500, '2024-09-05', 1),
('Pasta 88', 3550, 1000, '2024-08-15', 1),
('Bebida 3Lt', 1890, 468, '2023-07-25', 5),
('Pasta 77', 3300, 500, '2024-09-05', 2),
('Pasta 88', 3450, 800, '2024-08-25', 2),
('Salsa de tomate', 1000, 500, '2024-09-05', 3),
('Manjar', 800, 350, '2024-7-15', 4),
('Bebida 2Lt', 1350, 1050, '2024-06-12', 5);

-- Ejercicio 2 mostrar los datos de prodcuto con nombre de proveedor
SELECT a.nombre AS nombre_producto, b.nombre AS nombre_proveedor
FROM	producto a, proveedor b
WHERE a.id_proveedor = b.id_proveedor;
-- Otra forma
SELECT p2.nombre, p2.precio, p2.cantidad, p2.fecha, p.nombre 
FROM proveedor p , producto p2 
WHERE p2.id_producto  = p.id_proveedor;
-- otra forma
SELECT a.nombre AS nombre_producto, b.nombre AS nombre_proveedor 
FROM	producto a, proveedor b
WHERE a.id_proveedor = b.id_proveedor 
AND b.id_proveedor  = 1;

-- Ejercicio 3
-- a
SELECT *
FROM proveedor p 
WHERE id_proveedor = 4;
-- b 
SELECT *
FROM producto p 
WHERE p.precio < 10000;
-- c mostrar productos de septiembre
SELECT nombre, precio, cantidad, fecha 
FROM producto 
WHERE fecha >= '2024-09-01' AND fecha <= '2024-09-30';
-- otra forma
SELECT *
FROM producto p 
WHERE fecha BETWEEN '2024-09-01' AND '2024-09-30';
-- otra forma
SELECT nombre, precio, cantidad, fecha 
FROM producto 
WHERE EXTRACT(MONTH FROM fecha) = 9;
-- otra forma
SELECT nombre, precio, cantidad, fecha 
FROM producto 
WHERE EXTRACT(MONTH FROM fecha) = 9 AND EXTRACT(YEAR FROM fecha) = 2024;

-- Ejercicio 4
-- Eliminar clave foranea
--Asi podemos saber si sale las constraints
SELECT 
    constraint_name 
FROM 
    information_schema.table_constraints
WHERE 
    table_name = 'producto'
    AND constraint_type = 'FOREIGN KEY';
   
ALTER TABLE producto 
DROP CONSTRAINT producto_id_proveedor_fkey;

-- Este otro comando tambien permite ver todas las claves o constraint
SELECT conname 
FROM pg_constraint
WHERE conrelid = 'producto'::regclass;

-- Ahora volver a agregarla relacion entre las tablas
-- creacion de constraint
ALTER TABLE producto
ADD CONSTRAINT fk_id_proveedor
FOREIGN KEY (id_proveedor) REFERENCES proveedor(id_proveedor);

-- Ejercicio 5
-- Insertar un nuevo producto y verificar que el id_proveedor exista en la tabla proveedores
-- Insertar el nuevo producto si el id_proveedor existe
INSERT INTO producto (nombre, precio, cantidad, fecha, id_proveedor)
SELECT 'Inca Cola', 1350, 100, '2024-09-06', 5
WHERE EXISTS (SELECT 1 FROM proveedor WHERE id_proveedor = 1);

-- Otra forma de hacerlo
INSERT INTO producto (nombre, precio, cantidad, fecha, id_proveedor)
SELECT 'Dulce de leche', 2500.00, 100, '2024-08-26', 4
FROM proveedor
WHERE id_proveedor = 4;

-- Probando con un proveedor que no existe
-- No ingresa nada porque no existe
INSERT INTO producto (nombre, precio, cantidad, fecha, id_proveedor)
SELECT 'Dulce de leche', 2500.00, 100, '2024-08-26', 6
FROM proveedor
WHERE id_proveedor = 6;


COMMIT;


