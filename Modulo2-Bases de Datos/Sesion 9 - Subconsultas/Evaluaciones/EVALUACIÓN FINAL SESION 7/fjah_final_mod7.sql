
/*********************************************************
SCRIPT EJERCICIO FINAL N°7 | MODULO 3
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
-- 1. Listar los clientes sin arriendos por medio de una subconsulta.
SELECT *
FROM cliente
WHERE rut NOT IN (
    SELECT cliente_rut
    FROM arriendo
);

-- 2. Listar todos arriendos con las siguientes columnas: Folio, Fecha, Días, ValorDia,
-- NombreCliente, RutCliente.
SELECT 
    a.folio,
    a.fecha,
    a.dias,
    a.valordia,
    c.nombre AS NombreCliente,
    c.rut AS RutCliente
FROM arriendo a
JOIN cliente c ON a.cliente_rut = c.rut;

--3. Por medio de una subconsulta listar los clientes con el nombre de la herramienta más
-- arrendada.
-- Clasificar los clientes según la siguiente tabla:
-- Cantidad de arriendos mensuales entre  |  Clasificacion
-- 0 y 1 																 	|  Bajo
-- 1 y 3 																 	|  Medio
-- 3 o mas     													 	|  Alto
SELECT 
    c.rut,
    c.nombre AS NombreCliente,
    h.nombre AS HerramientaMásArrendada,
    COUNT(a.folio) AS CantidadArriendos,
    CASE 
        WHEN COUNT(a.folio) BETWEEN 0 AND 1 THEN 'Bajo'
        WHEN COUNT(a.folio) BETWEEN 2 AND 3 THEN 'Medio'
        ELSE 'Alto'
    END AS Clasificacion
FROM cliente c
LEFT JOIN arriendo a ON c.rut = a.cliente_rut
LEFT JOIN herramienta h ON a.herramienta_idherramienta = h.idherramienta
WHERE h.nombre = (SELECT h2.nombre
                FROM herramienta h2
                JOIN arriendo a2 ON h2.idherramienta = a2.herramienta_idherramienta
                GROUP BY h2.nombre
                ORDER BY COUNT(a2.folio) DESC
                LIMIT 1)
GROUP BY 
    c.rut, c.nombre, h.nombre;














