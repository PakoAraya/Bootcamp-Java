
-- TRABAJO SISTEMA DE GESTION DE BIBLIOTECA
-- Alumno: FRANCISCO JAVIER ARAYA HERNANDEZ
-- FECHA: Viernes 06/09/2024
-- Motor base de datos: PostgreSQL 16.4-Alpine

-- Creacion de la tabla Autores
CREATE TABLE autores(
	id_autor 					serial PRIMARY KEY,
	nombre						varchar	(50),
	apellido					varchar (50),
	nacionalidad			varchar (50)
);

-- Creacion de la tabla Usuarios
CREATE TABLE usuarios(
	id_usuario				serial PRIMARY KEY,
	nombre 						varchar (50),
	apellido 					varchar (50)
);

-- Creacion de la tabla categoria
CREATE TABLE categoria(
	id_categoria			serial PRIMARY KEY,
	categoria 				varchar (100)
);

-- Creacion de la tabla Libros
CREATE TABLE	libros(
	id_libro						serial PRIMARY KEY,
	titulo							varchar (100),
	anio_publicacion		date,
	id_autor					  int,
	
	CONSTRAINT libros_fk1_autor FOREIGN KEY (id_autor) REFERENCES autores (id_autor) 
);

-- Creacion de la tabla Prestamos
CREATE TABLE prestamos(
	id_prestamos 				serial PRIMARY KEY,
	fecha_prestamo			date,
	fecha_devolucion		date,
	estado_devolucion		boolean,
	id_usuario 					int,
	id_libro 						int,
	
	CONSTRAINT prestamos_fk1_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios (id_usuario),
	CONSTRAINT prestamos_fk2_libro FOREIGN KEY (id_libro) REFERENCES libros (id_libro)
);

-- Creacion de la tabla intermedia Libro-Categoria
CREATE TABLE libro_categoria(
	id_libro 						int,
	id_categoria 				int,
	
	CONSTRAINT pk_libro_categoria PRIMARY KEY (id_libro, id_categoria),
  CONSTRAINT fk_libro FOREIGN KEY (id_libro) REFERENCES libros(id_libro),
  CONSTRAINT fk_categoria FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);


-- CARGA DE LA BASE DE DATOS
-- Insertar datos en la tabla Autores
INSERT INTO autores (nombre, apellido, nacionalidad) VALUES
('Juan', 'Pérez', 'Mexicano'),
('Ana', 'García', 'Española'),
('Luis', 'Fernández', 'Argentino'),
('María', 'López', 'Colombiana'),
('Carlos', 'Mendoza', 'Chileno'),
('Laura', 'Sánchez', 'Peruana'),
('Jorge', 'Martínez', 'Uruguayo'),
('Sofía', 'Ramírez', 'Venezolana'),
('Andrés', 'Morales', 'Boliviano'),
('Isabel', 'Torres', 'Ecuatoriana'),
('Daniel', 'Hernández', 'Salvadoreño'),
('Paula', 'Jiménez', 'Guatemalteca'),
('Pedro', 'Rojas', 'Hondureño'),
('Carmen', 'Vega', 'Nicaragüense'),
('Ricardo', 'Gómez', 'Panameño'),
('Valentina', 'Pérez', 'Paraguaya'),
('Alejandro', 'Castro', 'Boliviano'),
('Natalia', 'Gutiérrez', 'Cubana'),
('Santiago', 'Moreno', 'Dominicano'),
('Camila', 'Salazar', 'Costarricense');

INSERT INTO usuarios (nombre, apellido) VALUES
('Pedro', 'Alvarez'),
('Marta', 'Reyes'),
('Luis', 'Serrano'),
('Claudia', 'Castillo'),
('Ricardo', 'Martín'),
('Gabriela', 'Figueroa'),
('Antonio', 'García'),
('Daniela', 'Mendoza'),
('Felipe', 'Herrera'),
('Sandra', 'Ramírez'),
('Javier', 'López'),
('Verónica', 'Cano'),
('Manuel', 'Torres'),
('Andrea', 'Vásquez'),
('Alejandro', 'Pérez'),
('Carolina', 'Vega'),
('Sergio', 'Mora'),
('Laura', 'Ríos'),
('Fernando', 'Ponce'),
('Natalia', 'Gómez');

-- Insertar datos en la tabla Categoría
INSERT INTO categoria (categoria) VALUES
('Fantasía'),
('Historia'),
('Ciencia Ficción');

-- Insertar datos en la tabla Libros
INSERT INTO libros (titulo, anio_publicacion, id_autor) VALUES
('El poder del ahora', '1997-10-01', 1),
('Cien años de soledad', '1967-05-30', 2),
('Don Quijote de la Mancha', '1605-01-16', 3),
('Orgullo y prejuicio', '1813-01-28', 4),
('1984', '1949-06-08', 5),
('La sombra del viento', '2001-10-05', 6),
('El alquimista', '1988-05-01', 7),
('Los detectives salvajes', '1998-09-01', 8),
('El nombre de la rosa', '1980-11-01', 9),
('La catedral del mar', '2006-01-01', 10),
('El fin de la soledad', '2016-03-01', 11),
('El libro de la selva', '1894-10-01', 12),
('Mujer y hombre', '2009-05-01', 13),
('El día de mañana', '2018-02-01', 14),
('La isla del tesoro', '1883-11-14', 15),
('Los pilares de la Tierra', '1989-01-01', 16),
('La chica del tren', '2015-01-13', 17),
('El gran Gatsby', '1925-04-10', 18),
('El código Da Vinci', '2003-03-18', 19),
('El juego del ángel', '2008-11-01', 20);

-- Insertar datos en la tabla Prestamos
INSERT INTO prestamos (fecha_prestamo, fecha_devolucion, estado_devolucion, id_usuario, id_libro) VALUES
('2024-01-01', '2024-01-15', true, 1, 1),
('2024-01-05', NULL, false, 2, 2),
('2024-01-10', '2024-01-25', true, 3, 3),
('2024-01-15', '2024-01-30', true, 4, 4),
('2024-01-20', NULL, false, 5, 5),
('2024-01-25', '2024-02-10', true, 6, 6),
('2024-01-30', '2024-02-15', true, 7, 7),
('2024-02-01', NULL, false, 8, 8),
('2024-02-05', '2024-02-25', true, 9, 9),
('2024-02-10', '2024-03-01', true, 10, 10),
('2024-02-15', NULL, false, 11, 11),
('2024-02-20', '2024-03-10', true, 12, 12),
('2024-03-01', '2024-03-15', true, 13, 13),
('2024-03-05', NULL, false, 14, 14),
('2024-03-10', '2024-03-25', true, 15, 15),
('2024-03-15', '2024-04-01', true, 16, 16),
('2024-03-20', NULL, false, 17, 17),
('2024-03-25', '2024-04-10', true, 18, 18),
('2024-04-01', '2024-04-15', true, 19, 19),
('2024-04-05', NULL, false, 20, 20);

-- Insertar datos en la tabla Libro-Categoría
INSERT INTO libro_categoria (id_libro, id_categoria) VALUES
(1, 1),
(1, 2),
(2, 2),
(2, 3),
(3, 2),
(3, 1),
(4, 1),
(4, 3),
(5, 3),
(5, 2),
(6, 1),
(6, 2),
(7, 3),
(7, 1),
(8, 2),
(8, 3),
(9, 3),
(9, 1),
(10, 2),
(10, 3);


--SECCION DE CONSULTAS
-- Titulos de los libros prestados a un usuario determinado
-- Forma 1
SELECT l.titulo 
FROM prestamos p 
JOIN libros l ON p.id_libro = l.id_libro
WHERE p.id_usuario = 5;

-- Forma 2
SELECT titulo
FROM libros
WHERE id_libro IN (SELECT id_libro FROM prestamos WHERE id_usuario = 5);

-- Mostrar titulos de categoria seleccionada.
-- Forma 1
SELECT l.titulo
FROM libros l
JOIN libro_categoria lc ON l.id_libro = lc.id_libro
WHERE lc.id_categoria = 2;

-- Forma2
SELECT l.titulo 
FROM libros l
WHERE id_libro IN (SELECT id_libro FROM	libro_categoria lc WHERE id_categoria = 2);

-- Muestra los libros que no han sido devueltos (NULL)
--Forma 1
SELECT *
FROM prestamos
WHERE fecha_devolucion IS NULL;
-- Forma 2
SELECT *
FROM prestamos
WHERE estado_devolucion = FALSE ;
-- Forma 3 devolviendo nombres y apellidos
SELECT p.id_prestamos, p.fecha_prestamo, p.fecha_devolucion, u.nombre, u.apellido 
FROM prestamos p 
JOIN usuarios u ON p.id_usuario = u.id_usuario 
WHERE p.fecha_devolucion IS NULL ;
-- Forma 4
SELECT p.id_prestamos, p.fecha_prestamo, p.estado_devolucion, u.nombre, u.apellido 
FROM	prestamos p 
JOIN usuarios u ON p.id_usuario = u.id_usuario 
WHERE p.estado_devolucion = FALSE ;

-- Muestra los nombres y apellidos de los usuarios que han prestado un libro especifico
-- Forma 1
SELECT u.nombre, u.apellido
FROM usuarios u
JOIN prestamos p ON u.id_usuario = p.id_usuario
WHERE p.id_libro = 3;
-- Forma 2
SELECT u.nombre, u.apellido
FROM usuarios u
JOIN prestamos p ON u.id_usuario = p.id_usuario
WHERE p.id_libro = u.id_usuario ;
-- Forma 3 uniendo el titulo del libro prestado
SELECT u.nombre, u.apellido, l.titulo
FROM usuarios u
JOIN prestamos p ON u.id_usuario = p.id_usuario
JOIN libros l ON p.id_libro = l.id_libro
WHERE l.id_libro = p.id_libro;
-- Forma 4 con un id especifico
SELECT u.nombre, u.apellido, l.titulo
FROM usuarios u
JOIN prestamos p ON u.id_usuario = p.id_usuario
JOIN libros l ON p.id_libro = l.id_libro
WHERE l.id_libro = 2;

-- Muestra las categorías a las que esta asociado un libro determinado (por ejemplo, con id_libro = 4).
SELECT c.categoria
FROM categoria c
JOIN libro_categoria lc ON c.id_categoria = lc.id_categoria
WHERE lc.id_libro = 4;

-- Muestra los préstamos que fueron realizados en una fecha determinada (por ejemplo, el 1 de septiembre de 2024).
SELECT *
FROM prestamos
WHERE fecha_prestamo = '2024-03-01';




