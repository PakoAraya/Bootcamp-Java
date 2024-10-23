
-- EJERCICIOS DENTRO DE LA CLASE
CREATE TABLE	cliente(
	id_cliente			serial PRIMARY KEY,
	nombre					varchar(100),
	correo					varchar(100)
);

-- Cliente 1.n Pedido
-- Forma 1
CREATE TABLE pedido(
	id_pedido				serial PRIMARY KEY,
	id_cliente 			int,
	producto				varchar (100),
	cantidad				int,
	fecha						date,
	FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);
-- Forma 2
CREATE TABLE pedido(
	id_pedido				serial PRIMARY KEY,
	id_cliente 			int REFERENCES cliente (id_cliente),
	producto				varchar (100),
	cantidad				int,
	fecha						date
);
-- Tercera Forma
CREATE TABLE pedido(
	id_pedido				serial PRIMARY KEY,
	id_cliente 			int,
	producto				varchar (100),
	cantidad				int,
	fecha						date
);
ALTER TABLE	pedido 
	ADD CONSTRAINT id_cliente 
	FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente);

-- Vamos a ingresar clientes
INSERT INTO cliente (
	nombre,
	correo
)VALUES
('Juan Perez', 'juan.perez@gmail.com'),
('Ana Gomez', 'ana.gomez@gmail.com'),
('Carlos Sanchez', 'carlos.sanchez@gmail.com');

INSERT INTO pedido (
	id_cliente,
	producto,
	cantidad,
	fecha 
)VALUES
(1, 'parlante', 2, '2024-09-05');

-- Ejemplo de ver relacion de columnas con relacion por llave primaria
SELECT c.nombre, p.producto 
	FROM cliente c, pedido p
	WHERE p.id_cliente = c.id_cliente; 
-- Y a esa misma consulta le podemos filtrar por otra condicion como la cantidad
SELECT c.nombre, p.producto 
	FROM cliente c, pedido p
	WHERE p.id_cliente = c.id_cliente AND p.cantidad <=1; 

BEGIN;	
INSERT INTO pedido (
	id_cliente,
	producto,
	cantidad,
	fecha 
)VALUES
(2, 'pelota', 8, '2024-09-04');
COMMIT;

ROLLBACK;

SELECT * FROM cliente ;
SELECT * FROM pedido ;


