
/*********************************************************
CREACION SCRIPT BASE DE DATOS SESION 7 | MODULO 3
ALUMNO			: Francisco Javier Araya Hernandez
FECHA				: 11/09/2024
TEMATICA		: SUBCONSULTAS
*********************************************************/

/*********************************************************
SCRIPT PARA TRABAJAR
*********************************************************/
CREATE TABLE Departamentos (
    id_departamento SERIAL PRIMARY KEY,
    nombre_departamento VARCHAR(100) NOT NULL
);
CREATE TABLE Empleados (
    id_empleado SERIAL PRIMARY KEY,
    nombre_empleado VARCHAR(100) NOT NULL,
    salario DECIMAL(10, 2),
    id_departamento INT,
    FOREIGN KEY (id_departamento) REFERENCES Departamentos(id_departamento)
);
 
CREATE TABLE Proyectos (
    id_proyecto SERIAL PRIMARY KEY,
    nombre_proyecto VARCHAR(100) NOT NULL,
    id_departamento INT,
    id_empleado INT,
    FOREIGN KEY (id_departamento) REFERENCES Departamentos(id_departamento),
    FOREIGN KEY (id_empleado) REFERENCES Empleados(id_empleado)
);
 
INSERT INTO Departamentos (nombre_departamento) 
VALUES 
('Recursos Humanos'),
('Tecnología'),
('Finanzas');
INSERT INTO Empleados (nombre_empleado, salario, id_departamento) 
VALUES 
('Juan Pérez', 3500, 1),
('Ana García', 4500, 2),
('Carlos López', 5500, 3),
('María Torres', 4000, 2),
('Jorge Martínez', 5000, 1);
 
INSERT INTO Proyectos (nombre_proyecto, id_departamento, id_empleado)
VALUES
('Desarrollo Web', 2, 1),
('Reducción de Costos', 3, 2),
('Capacitación Interna', 1, 4),
('Automatización de Procesos', 2, 5),
('Expansión Financiera', 3,5);

-- Encontrar el salario mas alto de los empleados que trabajan en el 
-- departamento de tecnologia (Usando subconsultas).

-- Las subconsultas son una query, seguida de la otra
-- Query 1 Obtenemos el departamento de tecnologia
SELECT id_departamento FROM departamentos d WHERE nombre_departamento = 'Tecnología';
-- 2 Query 2 obtenemos el salario maximo
SELECT max(salario)
FROM empleados e;
-- Y asi se anida
SELECT max(salario)
FROM empleados e 
WHERE id_departamento = (
			SELECT id_departamento
			FROM departamentos d
			WHERE nombre_departamento = 'Tecnología');

-- Mostrar el nombre de los empleados cuyo salario es mayor que el promedio de todos los empleados
SELECT nombre_empleado 
FROM empleados e 
WHERE salario > (
			SELECT avg(salario)
			FROM	empleados e2
);
		
-- Mostrar los proyectos gestionados por empleados que ganan mas de 4500
SELECT * FROM empleados e WHERE salario >4500;

SELECT *, nombre_proyecto FROM proyectos p ;

SELECT nombre_proyecto FROM proyectos p 
WHERE id_empleado = 8 AND id_empleado =10;

-- Cuando tenemos el where podemos ir comparando atributro por atributo, pero cuando
-- se tiene mas de un atributo, empleado en este caso, se debe usar el WHERE IN.
-- Que trabaja con atributos o lista de atributos
-- Consultar por una lista en base a un mismo atributo

SELECT nombre_proyecto 
FROM proyectos p 
WHERE id_empleado IN (SELECT id_empleado 
											FROM empleados e
											WHERE salario >4500);

										
										
										
--Encontrar el salario más alto de los empleados OK | que trabajan en departamento Tecnología OK

--obtenemos el departamento tecnologia
select id_departamento FROM departamentos where nombre_departamento ='Tecnología';

--obtenemos el salario max
select MAX(salario) 
    FROM empleados

--anidar
select MAX(salario) 
    FROM empleados
        where id_departamento =(select id_departamento 
                                    FROM departamentos where nombre_departamento ='Tecnología');
 
--Muestrar el nombre de los empleados cuyo salario es mayor que el , promedio de todos los empleados

    SELECT AVG(salario) FROM empleados; --promedio

    SELECT nombre_empleado FROM empleados
            

    SELECT nombre_empleado 
        FROM empleados
            where salario > (SELECT AVG(salario) FROM empleados)
--Muestrar los proyectos gestionados por .... empleados que ganan más de 4500

SELECT * FROM empleados WHERE salario>4500;

SELECT *,nombre_proyecto FROM proyectos
    
    --WHERE IN 
SELECT nombre_proyecto FROM proyectos
            WHERE id_empleado IN (SELECT id_empleado FROM empleados WHERE salario>4500);

		
/************************************************************************
 * EJERCICIOS EN CLASES 
 ***********************************************************************/		
-- Ejercicio 1 Encuentra el nombre del empleado con el salario más alto de cada departamento.
SELECT e.nombre_empleado, e.salario, d.nombre_departamento
FROM Empleados e
JOIN Departamentos d ON e.id_departamento = d.id_departamento
WHERE e.salario = (
    SELECT MAX(salario)
    FROM Empleados
    WHERE id_departamento = e.id_departamento
);


SELECT e.nombre_empleado, e.salario, d.nombre_departamento
FROM empleados e
JOIN departamentos d ON e.id_departamento = d.id_departamento
WHERE (e.id_departamento, e.salario) IN (
  SELECT id_departamento, MAX(salario)
  FROM empleados
  GROUP BY id_departamento
);

-- Ejercicio 2 Muestra los departamentos que tienen empleados con un salario
--superior al promedio de todos los empleados.
SElECT e.nombre_empleado, e.salario, d.nombre_departamento
FROM Empleados e
JOIN Departamentos d ON e.id_departamento = d.id_departamento
WHERE e.salario > ( SELECT AVG(salario) 
										FROM empleados);

-- Otra forma		
SELECT d.nombre_departamento
FROM Empleados e
JOIN Departamentos d ON e.id_departamento = d.id_departamento
GROUP BY d.nombre_departamento
HAVING MAX(e.salario) > (
    SELECT AVG(salario) 
    FROM Empleados
);		

-- Ejercicio 3 Muestra el nombre de los empleados que gestionan un proyecto y que
-- pertenecen al departamento de "Finanzas".
SELECT e.nombre_empleado
FROM Empleados e
JOIN Proyectos p ON e.id_empleado = p.id_empleado
WHERE p.id_departamento = (
    SELECT d.id_departamento
    FROM Departamentos d
    WHERE nombre_departamento = 'Finanzas'
);
-- Otra forma
SELECT e.nombre_empleado
FROM Empleados e
WHERE e.id_empleado IN (
    SELECT p.id_empleado
    FROM Proyectos p
    JOIN Departamentos d ON p.id_departamento = d.id_departamento
    WHERE d.nombre_departamento = 'Finanzas'
);


-- Ejercicio 4 Encuentra el nombre de los proyectos cuyo responsable tiene un salario
--superior al salario promedio de su propio departamento.
SELECT p.nombre_proyecto
FROM Proyectos p
JOIN Empleados e ON p.id_empleado = e.id_empleado
WHERE e.salario > (
    SELECT AVG(e2.salario)
    FROM Empleados e2
    WHERE e2.id_departamento = e.id_departamento
);

-- Corregir esta query, el ultimo join no es por departamentos es por empleados
SELECT p.nombre_proyecto 
FROM proyectos p
JOIN empleados e ON p.id_empleado = e.id_empleado 
WHERE e.salario > (SELECT avg(e.salario)
									 FROM departamentos d 
									 JOIN empleados e ON d.id_departamento = e.id_departamento);


-- Ejercicio 5. Encuentra el salario más bajo entre los empleados que no gestionan
-- ningún proyecto. o Pista: Usa una subconsulta con NOT IN para excluir empleados que gestionan
-- proyectos.
SELECT e.nombre_empleado, min(e.salario) AS salario_minimo
FROM empleados e 
WHERE e.id_empleado NOT IN (
				SELECT p.id_empleado
				FROM proyectos p)
GROUP BY e.nombre_empleado ;

							
-- Ejercicio 6. Ejercicio 6: Muestra los departamentos que no tienen empleados ganando más de
-- 5000. o Pista: Usa una subconsulta con NOT EXISTS para verificar la ausencia de
-- empleados con salarios superiores a 5000.
SELECT d.nombre_departamento
FROM Departamentos d
WHERE NOT EXISTS (
    SELECT 1
    FROM Empleados e
    WHERE e.id_departamento = d.id_departamento
    AND e.salario > 5000
);

-- Ejercicio 7: Muestra los nombres de los empleados que ganan más que el salario promedio 
-- del departamento de "Tecnología".
-- Pista: Usa una subconsulta para obtener el salario promedio del departamento de "Tecnología".
SELECT e.nombre_empleado
FROM Empleados e
WHERE e.salario > (
    SELECT AVG(e2.salario)
    FROM Empleados e2
    JOIN Departamentos d ON e2.id_departamento = d.id_departamento
    WHERE d.nombre_departamento = 'Tecnología'
);


-- Ejercicio 8: Muestra los proyectos cuyos responsables pertenecen a un
-- departamento que tiene más de dos proyectos asignados.
-- Pista: Usa una subconsulta para contar los proyectos por departamento.
SELECT p.nombre_proyecto
FROM Proyectos p
JOIN Empleados e ON p.id_empleado = e.id_empleado
WHERE e.id_departamento IN (
    SELECT id_departamento
    FROM Proyectos
    GROUP BY id_departamento
    HAVING COUNT(id_proyecto) > 2
);

-- Otra forma
SELECT p.nombre_proyecto
FROM Proyectos p
WHERE p.id_departamento IN (
    SELECT id_departamento
    FROM Proyectos
    GROUP BY id_departamento
    HAVING COUNT(*) > 2
);

-- Ejercicio 9: Encuentra el nombre de los empleados que no pertenecen a ningún
-- departamento donde el salario promedio es mayor de 4000.
-- Pista: Usa una subconsulta con NOT IN o NOT EXISTS para excluir
-- departamentos con salario promedio mayor a 4000.
SELECT e.nombre_empleado
FROM Empleados e
WHERE NOT EXISTS (
    SELECT 1
    FROM Empleados e2
    WHERE e2.id_departamento = e.id_departamento
    GROUP BY e2.id_departamento
    HAVING AVG(e2.salario) > 4000
);
-- Otra forma
SELECT e.nombre_empleado
FROM Empleados e
WHERE e.id_departamento NOT IN (
    SELECT id_departamento
    FROM Empleados
    GROUP BY id_departamento
    HAVING AVG(salario) > 4000
);

-- Ejercicio 10: Muestra el nombre de los empleados cuyo salario es mayor que el
-- salario promedio de los empleados del departamento de "Recursos Humanos".
-- Pista: Usa una subconsulta que calcule el salario promedio de "Recursos
-- Humanos" y compara con los salarios de los empleados.
SELECT e.nombre_empleado
FROM Empleados e
WHERE e.salario > (
    SELECT AVG(e2.salario)
    FROM Empleados e2
    JOIN Departamentos d ON e2.id_departamento = d.id_departamento
    WHERE d.nombre_departamento = 'Recursos Humanos'
);
-- Otra forma
SELECT e.nombre_empleado
FROM Empleados e, (
    SELECT AVG(salario) AS salario_promedio
    FROM Empleados e2
    JOIN Departamentos d ON e2.id_departamento = d.id_departamento
    WHERE d.nombre_departamento = 'Recursos Humanos'
) avg_salario
WHERE e.salario > avg_salario.salario_promedio;







