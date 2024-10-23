-- Database: bootcamp
CREATE TABLE cliente (
    id_cliente SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    correo VARCHAR(100)
);
--  cliente  1- n pedido  
-- primera forma
CREATE TABLE pedido (
    id_pedido SERIAL PRIMARY KEY,
    id_cliente INT,
    producto VARCHAR(100),
    cantidad INT,
    fecha DATE,
    FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
);

INSERT INTO cliente (nombre, correo) VALUES 
('Juan Pérez', 'juan.perez@mail.com'),
('Ana Gómez', 'ana.gomez@mail.com'),
('Carlos Sánchez', 'carlos.sanchez@mail.com');

SELECT * FROM cliente;
SELECT * FROM pedido;


INSERT INTO pedido(id_cliente, producto, cantidad, fecha)
            VALUES(2,'tv',1,'2024-09-05');


SELECT p.id_cliente,c.nombre, p.producto,p.cantidad
    FROM cliente c , pedido p
        WHERE p.id_cliente=c.id_cliente AND p.cantidad= 1
        ---------FK----=--------PK


    
BEGIN;--inicio transaccion 
    INSERT INTO pedido(id_cliente, producto, cantidad, fecha)
            VALUES(2,'pelota',2,'2024-09-04');
    INSERT INTO pedido(id_cliente, producto, cantidad, fecha)
            VALUES(2,'pelota',2,'2024-09-04');
    
COMMIT;--aceptar cambios

ROLLBACK;-- volver atras 


    
--segunda forma
CREATE TABLE pedido (
    id_pedido SERIAL PRIMARY KEY,
    id_cliente INT REFERENCES cliente (id_cliente),
    producto VARCHAR(100),
    cantidad INT,
    fecha DATE
    )

--tercera forma
CREATE TABLE PEDIDO (
    ID_PEDIDO SERIAL PRIMARY KEY,
    ID_CLIENTE INT,
    PRODUCTO VARCHAR(100),
    CANTIDAD INT,
    FECHA DATE
)
ALTER TABLE PEDIDO
ADD CONSTRAINT ID_CLIETE FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTE (ID_CLIENTE)
---------------------------------------------------------------------------------