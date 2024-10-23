
-- Database: bootcamp


-- Crear tabla con datos
create table alumnos(
	id_alumnos		int primary key,	
	nombre				varchar(50),
	edad					int
);

-- Eliminar tabla
drop table alumnos;


-- Modificacion de tabla
alter table alumnos
	add apellido varchar(50);


-- Eliminando una columna
alter table alumnos
	drop COLUMN edad;

-- Modificar tipo de columnas
alter table alumnos
	alter COLUMN apellido type varchar(40);

