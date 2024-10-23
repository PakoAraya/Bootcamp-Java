
create table libros(
	id_libro		int primary key,
	titulo			varchar(100),
	autor				varchar(100),
	precio			decimal(10,2)
);

insert into libros (id_libro, titulo, autor, precio)
	values(1, 'Papelucho', 'Marcela Paz', 9.90);

-- Seleccion con algunos atributos
select titulo, autor, precio from libros; 

insert into libros (id_libro, titulo, autor, precio)
	values(2, '1984', 'George Orwell', 10.90);

-- Vamos a eliminar la tabla libro para hacerla con id autoincremental
drop table libros ;

-- se cambia el id de int a serial y con eso el valor es autoincremental automatico por postgres
create table libros(
	id_libro		serial primary key,
	titulo			varchar(100),
	autor				varchar(100),
	precio			decimal(10,2)
);
-- Hacemos un ingreso sin ingresarle el valor de la PK
-- y se saca la declaracion de los atributos
insert into libros (titulo, autor, precio)
	values('Papelucho', 'Marcela Paz', 9.90);

insert into libros (titulo, autor, precio)
	values('1984', 'George Orwell', 10.90);

-- Actualizacion de datos
update libros 
	set precio = 16.90 
	where id_libro = 1;
-- Tambien se puede hacer la actualizacion preguntando por otro atributo
update libros 
	set precio = 10.90 
	where titulo = 'Papelucho';
-- Podemos hacer actualiazaciones en base a comparacion matematica
update libros 
	set precio = 9.90 
	where precio > 14;

-- Revisamos ahora la clausula para eliminar registros
delete  from libros 
	where precio > 10;

-- Formas de hacer consultas
select * from libros l ;

select  * from libros l 
where precio < 10;

