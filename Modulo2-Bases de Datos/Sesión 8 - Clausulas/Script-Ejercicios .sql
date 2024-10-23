
/*********************************************************
CREACION SCRIPT BASE DE DATOS SESION 7 | MODULO 3
ALUMNO			: Francisco Javier Araya Hernandez
FECHA				: 10/09/2024
TEMATICA		: FUNCIONES DE AGREGACION
COUNT() | SUM() | AVG() | MAX() | MIN()
*********************************************************/

/*********************************************************
SCRIPT PARA TRABAJAR
*********************************************************/
CREATE TABLE Clientes (
    id_cliente SERIAL PRIMARY KEY,
    nombre_cliente VARCHAR(100)
);
INSERT INTO Clientes (nombre_cliente)
VALUES
('Cliente 1'),
('Cliente 2'),
('Cliente 3'),
('Cliente 4'),
('Cliente 5'),
('Cliente 6');


CREATE TABLE Vendedores (
    id_vendedor SERIAL PRIMARY KEY,
    nombre_vendedor VARCHAR(100)
);

INSERT INTO Vendedores (nombre_vendedor) 
VALUES
('Juan Pérez'),
('Ana García'),
('Carlos López');


CREATE TABLE Ventas (
    id_venta SERIAL PRIMARY KEY,
    fecha DATE,
    monto DECIMAL(10,2),
    id_vendedor INT REFERENCES Vendedores(id_vendedor),
    id_cliente INT REFERENCES Clientes(id_cliente)
);

INSERT INTO Ventas (fecha, monto, id_vendedor, id_cliente) 
VALUES
('2024-09-01', 200.00, 1, 1),
('2024-09-02', 150.00, 1, 2),
('2024-09-03', 100.00, 2, 3),
('2024-09-04', 300.00, 2, 4),
('2024-09-05', 500.00, 3, 5),
('2024-09-06', 700.00, 3, 6),
('2024-09-07', 250.00, 1, 2),
('2024-09-08', 100.00, 2, 3),
('2024-09-09', 400.00, 2, 4),
('2024-09-10', 200.00, 3, 5);

-- COUNT (Cuenta las filas)
-- Numero total de ventas realizadas
SELECT count(*) AS total_ventas 
FROM ventas v;
--Para contar el total de clientes
SELECT count(*) AS total_clientes
FROM clientes c ;
--Contar el numero de ventas que superen los $300
SELECT count(*) AS total_ventas 
FROM ventas v
WHERE monto >= 300;

-- SUMA (Suma los valores de las filas)
SELECT sum(ventas.monto) AS moto_total 
FROM ventas ;
-- Que sume todas las ventas de un vendedor en particular
SELECT sum(v.monto) AS monto_total 
FROM ventas v 
WHERE id_vendedor = 3;

-- AVG (Calcula el promedio de un valor de filas)
SELECT avg(v.monto) AS promedio_ventas 
FROM ventas v;
-- O agregarle una condicion
SELECT avg(v.monto) AS promedio_ventas 
FROM ventas v
WHERE id_vendedor = 3;

-- MAX y MIN (Muestran el valor maximo y minimo de un rango de datos)
-- Para calcular el monto mas alto
SELECT max(v.monto) AS monto_maximo
FROM	ventas v;
-- Buscar por un vendedor en especifico
SELECT max(v.monto) AS monto_maximo
FROM	ventas v
WHERE id_vendedor =3;
-- Y para el minimo es lo mismo
SELECT min(v.monto) AS monto_minimo
FROM	ventas v;
-- Se puede preguntar por cada vendedor
SELECT min(v.monto) AS monto_minimo
FROM	ventas v
WHERE id_vendedor =3;
-- Y tambien se pueden combinar las funciones
SELECT max(v.monto) AS monto_maximo, min(v.monto) AS monto_minimo
FROM ventas v;

/*********************************************************
FUNCIONES DE AGREGACION
*********************************************************/
-- Clausula GROUP BY
/**********************************************************************************************
El GROUP BY se utiliza en consultas SQL cuando necesitas agrupar filas que 
tienen valores en común en una o más columnas. Si estás trabajando con dos tablas, 
puedes utilizarlo en una consulta que involucre un JOIN (combinación de tablas) 
para agrupar los resultados con base en alguna de las columnas de ambas tablas.

Un ejemplo típico sería cuando tienes dos tablas relacionadas y quieres obtener 
algún tipo de resumen o agregación de los datos, como sumas, conteos o promedios, 
agrupados por alguna columna.

En el fondo, elimina los datos duplicados que se repiten al agrupar data, en vez de que
salga 5 veces el mismo vendedor con cada venta, ahora aparece una sola vez con el monto total
***********************************************************************************************/

-- Esta query da error porque se deben agrupar los datos con un group by
SELECT max(monto) AS monto_maximo, id_vendedor 
FROM	ventas;
-- Asi se corrige
SELECT max(v.monto) AS monto_maximo, v.id_vendedor 
FROM	ventas v
GROUP BY id_vendedor ;

--Aqui tambien entrega error y solicita group by
SELECT v2.nombre_vendedor, count(*) AS total_ventas
FROM ventas v 
INNER JOIN vendedores v2 ON v.id_vendedor = v2.id_vendedor ;

-- Asi se corrige
SELECT v2.nombre_vendedor, count(*) AS total_ventas
FROM ventas v 
INNER JOIN vendedores v2 ON v.id_vendedor = v2.id_vendedor 
GROUP BY v2.nombre_vendedor ;

/********************************************************************************************
-- Clausula HAVING
***********************************************************************************************
La cláusula HAVING se utiliza en SQL para filtrar los resultados de una consulta que utiliza 
funciones de agregación, como COUNT, SUM, AVG, entre otras. Es similar a la cláusula WHERE, 
pero HAVING se aplica después de que los datos han sido agrupados por GROUP BY, mientras que 
WHERE filtra antes de agrupar los datos.

Siguiendo el ejemplo de vendedores y ventas, si quisieras mostrar solo aquellos vendedores 
que han realizado más de 5 ventas, usarías la cláusula HAVING después de agrupar los resultados

Por ejemplo, si quisieras filtrar las ventas antes de agruparlas (por ejemplo, solo incluir 
ventas superiores a $100), usarías WHERE:
WHERE v.precio > 100 filtra las ventas que tienen un precio mayor a 100 antes de hacer el 
agrupamiento.
HAVING COUNT(*) > 5 filtra los vendedores que, después de agrupar, tienen más de 5 ventas.
**********************************************************************************************/


-- No puede haber un having sin antes un group by
SELECT v2.nombre_vendedor, count(*) AS total_ventas
FROM ventas v 
INNER JOIN vendedores v2 ON v.id_vendedor = v2.id_vendedor 
GROUP BY v2.nombre_vendedor 
HAVING count(*) >3 ;

/********************************************************************************************
-- DESARROLLO DE EJERCICIOS
*********************************************************************************************/
-- 1 Ventas por clientes
SELECT c.nombre_cliente, COUNT(ve.id_venta) AS total_ventas
FROM Ventas ve
INNER JOIN Clientes c ON ve.id_cliente = c.id_cliente
GROUP BY c.nombre_cliente;
-- 2 Mostrar el total de las ventas realizadas por cada vendedor
SELECT v.nombre_vendedor, SUM(ve.monto) AS total_ventas
FROM Ventas ve
INNER JOIN Vendedores v ON ve.id_vendedor = v.id_vendedor
GROUP BY v.nombre_vendedor;
-- 3 Obtener el promedio de las ventas de cada vendedor
SELECT v.nombre_vendedor, AVG(ve.monto) AS promedio_ventas
FROM Ventas ve
INNER JOIN Vendedores v ON ve.id_vendedor = v.id_vendedor
GROUP BY v.nombre_vendedor;
-- 4 Mostrar los vendedores que han realizado mas de 2 ventas
SELECT v.nombre_vendedor, COUNT(ve.id_venta) AS total_ventas
FROM Ventas ve
INNER JOIN Vendedores v ON ve.id_vendedor = v.id_vendedor
GROUP BY v.nombre_vendedor
HAVING COUNT(ve.id_venta) > 2;
-- 5 Obtener el total de ventas diarias
SELECT ve.fecha, SUM(ve.monto) AS total_ventas_diarias
FROM Ventas ve
GROUP BY ve.fecha;
-- 6 Mostrar el monto total de ventas realizadas por cada cliente
-- agrupa por el nombre del cliente
SELECT c.nombre_cliente, SUM(ve.monto) AS total_ventas
FROM Ventas ve
INNER JOIN Clientes c ON ve.id_cliente = c.id_cliente
GROUP BY c.nombre_cliente;
-- 7 Mostrar el vendedor con el monto promedio mas alto
SELECT v.nombre_vendedor, AVG(ve.monto) AS promedio_ventas
FROM Ventas ve
INNER JOIN Vendedores v ON ve.id_vendedor = v.id_vendedor
GROUP BY v.nombre_vendedor
ORDER BY AVG(ve.monto) DESC;
-- 8 Mostrar el dia con la venta mas alta usando MAX().
SELECT fecha, MAX(monto) AS venta_maxima_dia
FROM Ventas
GROUP BY fecha
ORDER BY venta_maxima_dia DESC
LIMIT 1;

-- Otra forma
SELECT fecha, MAX(monto) AS venta_maxima
FROM Ventas
GROUP BY fecha
HAVING MAX(monto) = (
    SELECT MAX(monto)
    FROM Ventas);
    
-- 9 Obtener el promedio de ventas para los clientes que han comprado más de una
-- vez. Usa AVG() y filtra con HAVING para mostrar solo clientes con más de una venta.
SELECT c.nombre_cliente, AVG(ve.monto) AS promedio_ventas
FROM Ventas ve
INNER JOIN Clientes c ON ve.id_cliente = c.id_cliente
GROUP BY c.id_cliente, c.nombre_cliente
HAVING COUNT(ve.id_venta) > 1;

-- 10 Mostrar el total de ventas realizadas en los primeros 5 días.
-- Filtra los resultados por fecha y usa SUM() para obtener el total.
SELECT SUM(v.monto) AS total_ventas
FROM Ventas v
WHERE v.fecha BETWEEN '2024-09-01' AND '2024-09-05';

-- 11 Muestra los clientes que han gastado más de 500 en total en ventas, junto con el
-- nombre del cliente y el total gastado.
SELECT c.nombre_cliente, SUM(v.monto) AS total_gastado
FROM Ventas v
INNER JOIN Clientes c ON v.id_cliente = c.id_cliente
GROUP BY c.id_cliente, c.nombre_cliente
HAVING SUM(v.monto) > 500;



SELECT * FROM clientes c ;
SELECT * FROM vendedores v ;
SELECT * FROM ventas ;












