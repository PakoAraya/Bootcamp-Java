
-- Ejercicios hora asincrona
-- Creacion de tablas
-- Creacion de tabla libros
CREATE TABLE libros(
	id_libro						serial PRIMARY KEY,
	titulo							varchar (50),
	autor								varchar (50),
	categoria						varchar (50),
	precio							decimal(12,2),
	stock_disponible		numeric(12)
);
-- Creacion de la tabla empleados
CREATE TABLE empleados(
	id_empleado					serial PRIMARY KEY,
	nombre							varchar (50),
	apellido						varchar (50),
	cargo								varchar (50),
	fecha_contratacion	date,
	salario							decimal (10,2)
);
-- Creacion de la tabla clientes
CREATE TABLE clientes(
	id_cliente					serial PRIMARY KEY,
	nombre 							varchar (50),
	apellido 						varchar (50),
	correo_electronico	varchar (30),
	telefono						varchar (15)
);



-- Carga de data para la base de datos
-- Carga de datos para la tabla libros
INSERT INTO libros (titulo, autor, categoria, precio, stock_disponible)
VALUES
('El Quijote', 'Miguel de Cervantes', 'Novela', 19.99, 100),
('Cien Años de Soledad', 'Gabriel García Márquez', 'Novela', 25.50, 50),
('La Odisea', 'Homero', 'Poesía', 18.75, 20),
('Crimen y Castigo', 'Fiódor Dostoyevski', 'Novela', 22.80, 60),
('El Principito', 'Antoine de Saint-Exupéry', 'Cuento', 12.99, 150),
('1984', 'George Orwell', 'Novela', 17.95, 80),
('Los Miserables', 'Victor Hugo', 'Novela', 29.90, 40),
('Orgullo y Prejuicio', 'Jane Austen', 'Romance', 16.50, 55),
('El Señor de los Anillos', 'J.R.R. Tolkien', 'Fantasía', 39.99, 30),
('Donde los Árboles Cantan', 'Laura Gallego', 'Fantasía', 21.75, 90),
('La Metamorfosis', 'Franz Kafka', 'Novela', 14.60, 120),
('Ulises', 'James Joyce', 'Novela', 33.00, 15),
('El Gran Gatsby', 'F. Scott Fitzgerald', 'Novela', 15.95, 45),
('Matar a un Ruiseñor', 'Harper Lee', 'Novela', 18.30, 70),
('Rayuela', 'Julio Cortázar', 'Novela', 22.50, 60),
('Fahrenheit 451', 'Ray Bradbury', 'Ciencia ficción', 13.80, 95),
('La Divina Comedia', 'Dante Alighieri', 'Poesía', 24.99, 85),
('La Iliada', 'Homero', 'Poesía', 20.99, 110),
('Drácula', 'Bram Stoker', 'Terror', 19.25, 30),
('Frankenstein', 'Mary Shelley', 'Terror', 17.50, 40),
('El Amor en los Tiempos del Cólera', 'Gabriel García Márquez', 'Novela', 23.70, 65),
('Las Aventuras de Sherlock Holmes', 'Arthur Conan Doyle', 'Misterio', 15.20, 120),
('Los Pilares de la Tierra', 'Ken Follett', 'Histórica', 35.00, 25),
('La Sombra del Viento', 'Carlos Ruiz Zafón', 'Misterio', 22.90, 75),
('El Alquimista', 'Paulo Coelho', 'Filosofía', 18.60, 130),
('Juego de Tronos', 'George R.R. Martin', 'Fantasía', 32.00, 50),
('Harry Potter y la Piedra Filosofal', 'J.K. Rowling', 'Fantasía', 27.90, 90),
('Cumbres Borrascosas', 'Emily Brontë', 'Romance', 16.80, 40),
('La Casa de los Espíritus', 'Isabel Allende', 'Novela', 21.30, 85),
('Memorias de una Geisha', 'Arthur Golden', 'Histórica', 17.45, 60),
('El Código Da Vinci', 'Dan Brown', 'Misterio', 22.00, 70),
('Ángeles y Demonios', 'Dan Brown', 'Misterio', 19.80, 80),
('El Juego del Ángel', 'Carlos Ruiz Zafón', 'Misterio', 24.00, 55),
('La Ladrona de Libros', 'Markus Zusak', 'Histórica', 19.50, 60),
('El Niño con el Pijama de Rayas', 'John Boyne', 'Histórica', 15.75, 100),
('La Chica del Tren', 'Paula Hawkins', 'Misterio', 18.90, 40),
('El Silmarillion', 'J.R.R. Tolkien', 'Fantasía', 29.99, 20),
('La Historia Interminable', 'Michael Ende', 'Fantasía', 24.50, 35),
('Moby Dick', 'Herman Melville', 'Aventura', 21.10, 55),
('El Viejo y el Mar', 'Ernest Hemingway', 'Aventura', 14.75, 90),
('Los Juegos del Hambre', 'Suzanne Collins', 'Ciencia ficción', 19.99, 70),
('Divergente', 'Veronica Roth', 'Ciencia ficción', 17.25, 100),
('El Nombre del Viento', 'Patrick Rothfuss', 'Fantasía', 25.50, 45),
('La Chica del Abrigo Azul', 'Monica Hesse', 'Histórica', 14.99, 85),
('El Último Jurado', 'John Grisham', 'Misterio', 16.50, 70),
('El Retrato de Dorian Gray', 'Oscar Wilde', 'Novela', 12.99, 65),
('Las Crónicas de Narnia', 'C.S. Lewis', 'Fantasía', 27.00, 40),
('La Milla Verde', 'Stephen King', 'Terror', 21.80, 50),
('Carrie', 'Stephen King', 'Terror', 18.75, 60),
('La Catedral del Mar', 'Ildefonso Falcones', 'Histórica', 22.99, 40);

-- Carga de datos para la tabla empleados
INSERT INTO empleados (nombre, apellido, cargo, fecha_contratacion, salario)
VALUES
('Carlos', 'Gómez', 'Gerente', '2020-05-01', 5000.00),
('Ana', 'Pérez', 'Asistente', '2019-08-15', 3200.00),
('Jorge', 'Martínez', 'Desarrollador', '2021-02-20', 4500.00),
('María', 'Hernández', 'Diseñadora', '2018-11-10', 3800.00),
('Luis', 'Rodríguez', 'Administrador', '2020-07-25', 4200.00),
('Sofía', 'Ramírez', 'Contadora', '2019-09-05', 3900.00),
('David', 'López', 'Desarrollador', '2021-06-13', 4600.00),
('Elena', 'García', 'Gerente', '2017-12-01', 5100.00),
('Miguel', 'Torres', 'Desarrollador', '2020-04-10', 4400.00),
('Laura', 'Fernández', 'Analista', '2021-01-08', 3700.00),
('Ricardo', 'Sánchez', 'Administrador', '2018-06-30', 4100.00),
('Patricia', 'Cruz', 'Diseñadora', '2019-11-25', 3800.00),
('Sergio', 'Flores', 'Desarrollador', '2021-07-15', 4500.00),
('Carmen', 'Morales', 'Asistente', '2020-09-20', 3300.00),
('Juan', 'Núñez', 'Analista', '2020-03-17', 3700.00),
('Isabel', 'Vargas', 'Contadora', '2018-08-14', 4000.00),
('Alberto', 'Ortiz', 'Administrador', '2019-12-05', 4200.00),
('Rosa', 'Mendoza', 'Gerente', '2021-05-21', 5100.00),
('Daniel', 'Jiménez', 'Asistente', '2018-10-10', 3100.00),
('Lucía', 'Paredes', 'Diseñadora', '2020-12-23', 3800.00),
('Javier', 'Silva', 'Desarrollador', '2019-02-11', 4600.00),
('Teresa', 'Castro', 'Analista', '2020-11-18', 3600.00),
('Eduardo', 'Ruiz', 'Gerente', '2017-04-06', 5000.00),
('Marta', 'Reyes', 'Contadora', '2019-01-30', 4000.00),
('Roberto', 'Guzmán', 'Desarrollador', '2021-08-25', 4400.00),
('Paula', 'Rojas', 'Asistente', '2020-02-12', 3200.00),
('Andrés', 'Mora', 'Administrador', '2018-09-07', 4200.00),
('Sonia', 'Muñoz', 'Diseñadora', '2019-03-03', 3700.00),
('Gabriel', 'Castillo', 'Analista', '2020-10-01', 3600.00),
('Carla', 'Acosta', 'Contadora', '2021-03-19', 3900.00),
('Fernando', 'Vega', 'Gerente', '2018-05-20', 5100.00),
('Natalia', 'Cabrera', 'Asistente', '2019-06-12', 3300.00),
('Diego', 'Suárez', 'Desarrollador', '2020-01-22', 4500.00),
('Monica', 'Peña', 'Analista', '2021-02-08', 3700.00),
('Esteban', 'Santos', 'Administrador', '2018-12-27', 4100.00),
('Valeria', 'Rivas', 'Diseñadora', '2019-07-29', 3800.00),
('Héctor', 'Lara', 'Asistente', '2020-08-30', 3200.00),
('Álvaro', 'Navarro', 'Gerente', '2017-03-05', 5000.00),
('Adriana', 'Durán', 'Contadora', '2019-04-18', 3900.00),
('Ramón', 'Córdoba', 'Desarrollador', '2021-09-14', 4600.00),
('Verónica', 'Gómez', 'Asistente', '2020-11-04', 3200.00),
('Pedro', 'Solís', 'Administrador', '2018-01-09', 4200.00),
('Inés', 'Bravo', 'Diseñadora', '2019-08-11', 3700.00),
('Jaime', 'Montalvo', 'Analista', '2021-03-31', 3600.00),
('Alicia', 'Luna', 'Contadora', '2020-06-19', 4000.00),
('Iván', 'Franco', 'Gerente', '2018-11-23', 5100.00),
('Susana', 'Espinosa', 'Desarrolladora', '2019-12-14', 4400.00),
('Cristina', 'Blanco', 'Asistente', '2021-07-07', 3100.00),
('Emanuel', 'Benítez', 'Desarrollador', '2020-04-15', 4500.00),
('Emilia', 'Quintana', 'Contadora', '2021-08-12', 4000.00);

--Carga de datos para la tabla clientes
INSERT INTO clientes (nombre, apellido, correo_electronico, telefono)
VALUES
('Carlos', 'Gómez', 'carlos.gomez@example.com', '555-1234'),
('Ana', 'Pérez', 'ana.perez@example.com', '555-5678'),
('Jorge', 'Martínez', 'jorge.martinez@example.com', '555-9876'),
('María', 'Hernández', 'maria.hernandez@example.com', '555-5432'),
('Luis', 'Rodríguez', 'luis.rodriguez@example.com', '555-6789'),
('Sofía', 'Ramírez', 'sofia.ramirez@example.com', '555-2345'),
('David', 'López', 'david.lopez@example.com', '555-8765'),
('Elena', 'García', 'elena.garcia@example.com', '555-4321'),
('Miguel', 'Torres', 'miguel.torres@example.com', '555-7654'),
('Laura', 'Fernández', 'laura.fernandez@example.com', '555-3210'),
('Ricardo', 'Sánchez', 'ricardo.sanchez@example.com', '555-6543'),
('Patricia', 'Cruz', 'patricia.cruz@example.com', '555-2109'),
('Sergio', 'Flores', 'sergio.flores@example.com', '555-7653'),
('Carmen', 'Morales', 'carmen.morales@example.com', '555-9087'),
('Juan', 'Núñez', 'juan.nunez@example.com', '555-6780'),
('Isabel', 'Vargas', 'isabel.vargas@example.com', '555-4325'),
('Alberto', 'Ortiz', 'alberto.ortiz@example.com', '555-9873'),
('Rosa', 'Mendoza', 'rosa.mendoza@example.com', '555-5437'),
('Daniel', 'Jiménez', 'daniel.jimenez@example.com', '555-8760'),
('Lucía', 'Paredes', 'lucia.paredes@example.com', '555-2108'),
('Javier', 'Silva', 'javier.silva@example.com', '555-7652'),
('Teresa', 'Castro', 'teresa.castro@example.com', '555-5438'),
('Eduardo', 'Ruiz', 'eduardo.ruiz@example.com', '555-9872'),
('Marta', 'Reyes', 'marta.reyes@example.com', '555-4324'),
('Roberto', 'Guzmán', 'roberto.guzman@example.com', '555-8761'),
('Paula', 'Rojas', 'paula.rojas@example.com', '555-6782'),
('Andrés', 'Mora', 'andres.mora@example.com', '555-2107'),
('Sonia', 'Muñoz', 'sonia.munoz@example.com', '555-5431'),
('Gabriel', 'Castillo', 'gabriel.castillo@example.com', '555-4326'),
('Carla', 'Acosta', 'carla.acosta@example.com', '555-8762'),
('Fernando', 'Vega', 'fernando.vega@example.com', '555-7651'),
('Natalia', 'Cabrera', 'natalia.cabrera@example.com', '555-6783'),
('Diego', 'Suárez', 'diego.suarez@example.com', '555-2106'),
('Monica', 'Peña', 'monica.pena@example.com', '555-5430'),
('Esteban', 'Santos', 'esteban.santos@example.com', '555-4323'),
('Valeria', 'Rivas', 'valeria.rivas@example.com', '555-8763'),
('Héctor', 'Lara', 'hector.lara@example.com', '555-7650'),
('Álvaro', 'Navarro', 'alvaro.navarro@example.com', '555-9871'),
('Adriana', 'Durán', 'adriana.duran@example.com', '555-6784'),
('Ramón', 'Córdoba', 'ramon.cordoba@example.com', '555-2105'),
('Verónica', 'Gómez', 'veronica.gomez@example.com', '555-4322'),
('Pedro', 'Solís', 'pedro.solis@example.com', '555-8764'),
('Inés', 'Bravo', 'ines.bravo@example.com', '555-7656'),
('Jaime', 'Montalvo', 'jaime.montalvo@example.com', '555-9870'),
('Alicia', 'Luna', 'alicia.luna@example.com', '555-6785'),
('Iván', 'Franco', 'ivan.franco@example.com', '555-2104'),
('Susana', 'Espinosa', 'susana.espinosa@example.com', '555-4327'),
('Cristina', 'Blanco', 'cristina.blanco@example.com', '555-8766'),
('Emanuel', 'Benítez', 'emanuel.benitez@example.com', '555-7655'),
('Emilia', 'Quintana', 'emilia.quintana@example.com', '555-2103');


-- CONSULTA PARA LA TABLA LIBROS
-- 1 Consulta todos los libros disponibles en la tienda
SELECT *
FROM libros l 
WHERE stock_disponible > 0;
-- 2 Obten los titulos de los libros con categoria novela
SELECT titulo 
FROM	libros l 
WHERE categoria LIKE 'Novela';
-- 3 Consulta los libros que tengan un precio mayor a $20
SELECT *
FROM libros l 
WHERE precio >= 20;
-- 4 Mostrar el titulo y stock los libros que tienen menos de 50 unidades en stock
SELECT titulo , stock_disponible 
FROM libros l 
WHERE stock_disponible >= 50;
-- 5 Mostrar los libros que esten entre los precios $10 y $25
SELECT *
FROM libros l 
WHERE precio >= 10 AND precio <= 25;
-- 6 Muestra el libro mas caro de la tienda.
-- Forma 1
SELECT *
FROM libros
ORDER BY precio DESC -- Ordena los registros por el campo precio en orden descendente, de modo que el precio más alto esté al principio.
LIMIT 1; -- Limita la salida a solo una fila, que será la del libro con el precio más alto.
-- Forma 2
SELECT *
FROM libros
WHERE precio = (SELECT  max(precio) FROM libros);



-- CONSULTA PARA LA TABLA EMPLEADOS
-- 1 Consulta todos los empleados de la tienda
SELECT *
FROM empleados e ;
-- 2 Obten nombres y apellidos de empleados contratados despues del 1 de enero de 2020
SELECT nombre, apellido
FROM empleados e 
WHERE fecha_contratacion > '2020-01-01';
-- 3 Obten nombre, apellido y cargo de empleado que gane mas de $1500
SELECT nombre, apellido, cargo
FROM empleados e 
WHERE salario >= 1500;
-- 4 Mostrar empleados ordenados por fecha de contratacion del mas reciente al mas antiguo
SELECT *
FROM empleados e 
ORDER BY fecha_contratacion DESC; 
-- 5 Encuentra al empleado con el salario mas alto
-- Forma 1
SELECT *
FROM empleados e
ORDER BY salario DESC -- Ordena los registros por el campo precio en orden descendente, de modo que el precio más alto esté al principio.
LIMIT 10;
-- Forma 2
SELECT *
FROM empleados e 
WHERE salario = (SELECT max(salario) FROM empleados);
-- Cuenta la cantidad de empleados que hay en la tienda
SELECT count(*) AS total_empleados
FROM empleados e ;

-- CONSULTA PARA LA TABLA CLIENTES
-- 1 Consulta todos los clientes registrados de la tienda
SELECT *
FROM clientes c ;
-- 2 Obten nombre, apellido y email de clientes con apellido Lopez
SELECT nombre, apellido, correo_electronico 
FROM clientes c 
WHERE apellido LIKE 'López';
--3 Mostrar nombre, apellido y telefono de clientes que tengan en su telefono los numero 555
SELECT nombre, apellido, telefono
FROM clientes c 
WHERE telefono LIKE '%555%';
-- 4 Mostrar todos los clientes cuyo nombre empiece con la letra P
SELECT *
FROM clientes c 
WHERE nombre LIKE 'P%';
-- 5 Mostrar cuantos clientes tiene registrado numero de telefono
SELECT *
FROM clientes c 
WHERE telefono IS NOT NULL AND telefono <> '';
-- 6 Muestra los nombres y correos electronicos de todos los clientes con apellidos ordenados alfabeticamente

SELECT nombre, correo_electronico
FROM clientes c 
ORDER BY apellido ASC ;





