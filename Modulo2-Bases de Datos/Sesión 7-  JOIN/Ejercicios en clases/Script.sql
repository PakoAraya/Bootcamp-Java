
/*********************************************************
CREACION SCRIPT BASE DE DATOS SESION 6 | MODULO 3
ALUMNO			: Francisco Javier Araya Hernandez
FECHA				: 09/09/2024
TEMATICA		: JOIN
*********************************************************/

-- Script para comenzar a trabajar en la base de datos.
CREATE TABLE Autor (
    id_autor SERIAL PRIMARY KEY,
    nombre_autor VARCHAR(100) NOT NULL,
    nacionalidad VARCHAR(50)
);
CREATE TABLE Libro (
    id_libro SERIAL PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    anio_publicacion INT,
    id_autor INT,
    FOREIGN KEY (id_autor) REFERENCES Autor(id_autor)
);
CREATE TABLE Categoria (
    id_categoria SERIAL PRIMARY KEY,
    nombre_categoria VARCHAR(100) NOT NULL
);
CREATE TABLE Libro_Categoria (
    id_libro INT,
    id_categoria INT,
    PRIMARY KEY (id_libro, id_categoria),
    FOREIGN KEY (id_libro) REFERENCES Libro(id_libro),
    FOREIGN KEY (id_categoria) REFERENCES Categoria(id_categoria)
);
CREATE TABLE Persona (
    id_persona SERIAL PRIMARY KEY,
    nombre_persona VARCHAR(100),
    apellido_persona VARCHAR(100)
);

CREATE TABLE Prestamo (
    id_prestamo SERIAL PRIMARY KEY,
    fecha_prestamo DATE NOT NULL,
    fecha_devolucion DATE,
    id_libro INT,
    id_persona INT,
    FOREIGN KEY (id_libro) REFERENCES Libro(id_libro),
    FOREIGN KEY (id_persona) REFERENCES Persona(id_persona)
);


INSERT INTO Autor (nombre_autor, nacionalidad)
VALUES 
('Gabriel García Márquez', 'Colombiana'),
('J.K. Rowling', 'Británica'),
('George Orwell', 'Británica');
INSERT INTO Libro (titulo, anio_publicacion, id_autor)
VALUES 
('Cien Años de Soledad', 1967, 1),
('Harry Potter y la Piedra Filosofal', 1997, 2),
('1984', 1949, 3);
INSERT INTO Categoria (nombre_categoria)
VALUES 
('Novela'),
('Fantasía'),
('Ciencia Ficción');
INSERT INTO Libro_Categoria (id_libro, id_categoria)
VALUES 
(1, 1), -- Cien Años de Soledad -> Novela
(2, 2), -- Harry Potter -> Fantasía
(3, 3); -- 1984 -> Ciencia Ficción
INSERT INTO Persona (nombre_persona, apellido_persona)
VALUES 
('Juan', 'Pérez'),
('Ana', 'García');

INSERT INTO Prestamo (fecha_prestamo, fecha_devolucion, id_libro, id_persona)
VALUES 
('2024-09-01', '2024-09-15', 1, 1), -- Juan presta Cien Años de Soledad
('2024-09-02', NULL, 2, 2); -- Ana presta Harry Potter (no lo ha devuelto aún)

/*********************************************************
EJECUCION DE JOINS
*********************************************************/
-- Seleccion absoluta
SELECT * FROM libro l ;
SELECT * FROM autor a ;

-- Se puede hacer con Where, pero no es eficiente
SELECT l.*, a.nombre_autor 
FROM libro l, autor a
WHERE l.id_autor = a.id_autor; 

-- Para traer elemetos comunes entre ambas tablas se usa INNER JOIN
SELECT libro.*, autor.nombre_autor 
FROM libro  
INNER	JOIN autor ON libro.id_autor = autor.id_autor; 

-- LEFT JOIN para traer datos de la tabla A y parte de la tabla B o
-- traer de la tabla A menos lo que intersecta a la tabla B
-- Vamos a mostrar como seria un ejemplo con Where
SELECT libro.titulo, prestamo.fecha_prestamo 
FROM libro, prestamo 
WHERE libro.id_libro = prestamo.id_libro ;

-- Left Join que nos muestra lo que esta en A y parte de B
SELECT libro.titulo, prestamo.fecha_prestamo 
FROM libro
LEFT JOIN	prestamo ON libro.id_libro = prestamo.id_libro;

-- Este Left Join traeria solo el contenido de la tabla A y quita lo de B
SELECT libro.titulo, prestamo.fecha_prestamo 
FROM libro
LEFT JOIN	prestamo ON libro.id_libro = prestamo.id_libro
WHERE prestamo.id_prestamo IS NULL;

/*********************************************************
EJERCICIOS JOINS
*********************************************************/
/*********************************************************
INNER JOIN
*********************************************************/
-- Ejercicio 1
SELECT l.titulo, a.nombre_autor 
FROM libro l
INNER JOIN autor a ON l.id_autor = a.id_autor; 
-- Ejercicio 2
SELECT p.id_prestamo, l.titulo, l.anio_publicacion, au.nombre_autor, per.nombre_persona, per.apellido_persona 
FROM prestamo p
INNER JOIN libro l ON p.id_libro = l.id_libro
INNER JOIN persona per ON p.id_persona = per.id_persona
INNER JOIN autor au ON l.id_autor = au.id_autor ;

/*********************************************************
LEFT JOIN
*********************************************************/
-- Ejercicio 3
SELECT au.nombre_autor, l.titulo, l.anio_publicacion 
FROM autor au
LEFT JOIN libro l ON au.id_autor = l.id_autor;
-- Ejercicio 4
SELECT c.nombre_categoria, l.titulo
FROM Categoria c
LEFT JOIN Libro_Categoria lc ON c.id_categoria = lc.id_categoria
LEFT JOIN Libro l ON lc.id_libro = l.id_libro;

/*********************************************************
RIGHT JOIN
*********************************************************/
-- Ejercicio 5
SELECT c.nombre_categoria, l.titulo
FROM Libro l
RIGHT JOIN Libro_Categoria lc ON l.id_libro = lc.id_libro
RIGHT JOIN Categoria c ON lc.id_categoria = c.id_categoria;

SELECT c.nombre_categoria, l.titulo
FROM Categoria c
RIGHT JOIN Libro_Categoria lc ON c.id_categoria = lc.id_categoria
RIGHT JOIN Libro l ON lc.id_libro = l.id_libro;

-- Ejercicio 6
SELECT l.titulo, p.fecha_prestamo, p.fecha_devolucion 
FROM prestamo p 
RIGHT JOIN libro l ON p.id_libro = l.id_libro;

/*********************************************************
FULL OUTER JOIN
*********************************************************/
-- Ejercicio 7
SELECT l.titulo, c.nombre_categoria
FROM Libro l
FULL OUTER JOIN Libro_Categoria lc ON l.id_libro = lc.id_libro
FULL OUTER JOIN Categoria c ON lc.id_categoria = c.id_categoria;






SELECT * FROM prestamo p ;
SELECT * FROM persona p ;
SELECT * FROM libro l ;
SELECT * FROM autor;
SELECT * FROM categoria c ;
SELECT * FROM libro_categoria lc ;






