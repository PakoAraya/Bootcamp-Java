

/**********
 * Clase viernes 13 de Septiembre 2024
*********/
-- Crear la tabla 'departamentos'
CREATE TABLE departamentos (
    id_departamento INT PRIMARY KEY,
    nombre_departamento VARCHAR(50) NOT NULL
);

-- Crear la tabla 'empleados'
CREATE TABLE empleados (
    id_empleado INT PRIMARY KEY,
    nombre_empleado VARCHAR(50) NOT NULL,
    id_departamento INT,
    FOREIGN KEY (id_departamento) REFERENCES departamentos(id_departamento)
);

-- Crear la tabla 'proyectos'
CREATE TABLE proyectos (
    id_proyecto INT PRIMARY KEY,
    nombre_proyecto VARCHAR(50) NOT NULL,
    id_departamento INT,
    FOREIGN KEY (id_departamento) REFERENCES departamentos(id_departamento)
);

-- Crear la tabla 'asignaciones'
CREATE TABLE asignaciones (
    id_empleado INT,
    id_proyecto INT,
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado),
    FOREIGN KEY (id_proyecto) REFERENCES proyectos(id_proyecto),
    PRIMARY KEY (id_empleado, id_proyecto)
);

-- Insertar datos en 'departamentos'
INSERT INTO departamentos (id_departamento, nombre_departamento) VALUES
(1, 'Recursos Humanos'),
(2, 'Finanzas'),
(3, 'Desarrollo');

-- Insertar datos en 'empleados'
INSERT INTO empleados (id_empleado, nombre_empleado, id_departamento) VALUES
(1, 'Juan', 1),
(2, 'Ana', 2),
(3, 'Luis', 1),
(4, 'Carlos', 3),
(5, 'Maria', 2);

-- Insertar datos en 'proyectos'
INSERT INTO proyectos (id_proyecto, nombre_proyecto, id_departamento) VALUES
(1, 'Sistema de Nóminas', 1),
(2, 'Revisión de Presupuesto', 2),
(3, 'Desarrollo de Software', 3),
(4, 'Capacitación Interna', 1);

-- Insertar datos en 'asignaciones'
INSERT INTO asignaciones (id_empleado, id_proyecto) VALUES
(1, 1),
(1, 4),
(2, 2),
(3, 1),
(4, 3),
(5, 2);

/*************
 * Desarrollo de ejercicios * 
 */
-- JOINS
-- Ejercicio 1. Consulta los nombres de los empleados y los nombres de los departamentos a los que
--pertenecen.
SELECT e.nombre_empleado, d.nombre_departamento 
FROM empleados e 
INNER JOIN departamentos d ON e.id_departamento = d.id_departamento ;
-- Esto entrega el mismo resultado, pero es menos eficiente
SELECT e.nombre_empleado, d.nombre_departamento
FROM empleados e, departamentos d 
WHERE e.id_departamento = d.id_departamento ;

-- Ejercicio N2. Lista los nombres de los proyectos junto con los nombres de los departamentos que
--los gestionan.
SELECT p.nombre_proyecto, d.nombre_departamento 
FROM proyectos p 
INNER JOIN departamentos d ON p.id_departamento = d.id_departamento ;
-- Aplicando Where
select proyectos.nombre_proyecto, departamentos.nombre_departamento
from proyectos, departamentos
where proyectos.id_departamento = departamentos.id_departamento;

-- Ejercicio N3. Muestra los empleados y los proyectos en los que están asignados.
SELECT e.nombre_empleado, p.nombre_proyecto 
FROM empleados e 
INNER JOIN asignaciones a ON e.id_empleado = a.id_empleado 
INNER JOIN proyectos p ON a.id_proyecto = p.id_proyecto 
GROUP BY e.nombre_empleado, p.nombre_proyecto 
ORDER BY e.nombre_empleado ASC, p.nombre_proyecto ASC;
-- Aplicando Where
SELECT empleados.nombre_empleado, proyectos.nombre_proyecto
FROM empleados, asignaciones, proyectos
WHERE empleados.id_empleado = asignaciones.id_empleado 
AND asignaciones .id_proyecto = proyectos.id_proyecto;
 
-- Ejercicio N4. Encuentra los empleados que están asignados a proyectos del departamento de
-- Finanzas.
SELECT e.nombre_empleado, p.nombre_proyecto 
FROM empleados e 
INNER JOIN asignaciones a ON e.id_empleado = a.id_empleado 
INNER JOIN proyectos p ON a.id_proyecto = p.id_proyecto 
INNER JOIN departamentos d ON p.id_departamento = d.id_departamento 
-- WHERE d.id_departamento = 2;
WHERE d.nombre_departamento LIKE 'Finanzas';

-- Ejercicio N5. Lista todos los proyectos y los empleados asignados, incluyendo los proyectos sin
-- asignación. 
SELECT p.nombre_proyecto, e.nombre_empleado 
FROM proyectos p 
LEFT JOIN asignaciones a ON p.id_proyecto = a.id_proyecto 
LEFT JOIN empleados e ON a.id_empleado = e.id_empleado; 

SELECT p.nombre_proyecto 
FROM proyectos p 
LEFT JOIN asignaciones a ON p.id_proyecto = a.id_empleado 
WHERE a.id_proyecto IS NULL;

-- Ejercicio N6. Lista los empleados sin asignación a ningún proyecto. 
SELECT e.nombre_empleado, p.nombre_proyecto 
FROM proyectos p 
RIGHT JOIN asignaciones a ON p.id_proyecto = a.id_proyecto 
RIGHT JOIN empleados e ON a.id_empleado = e.id_empleado 
WHERE e.id_empleado IS NULL;

-- Ejercicio N7. Encuentra los departamentos que no tienen proyectos asociados.
-- Insertar datos en 'proyectos'
INSERT INTO proyectos (id_proyecto, nombre_proyecto, id_departamento) VALUES
(5, 'Auditoria Extrema', NULL);
-- Por alguna razon esta query no entrega nada
SELECT d.nombre_departamento 
FROM departamentos d 
LEFT JOIN proyectos p ON d.id_departamento = p.id_departamento 
WHERE p.id_departamento IS NULL;
-- Sin embargo esta query encuentra el resultado.
SELECT p.id_proyecto, p.nombre_proyecto, d.nombre_departamento
FROM proyectos p 
LEFT JOIN departamentos d ON d.id_departamento = p.id_departamento 
WHERE p.id_departamento IS NULL;
-- Y esta query entrega todo.
SELECT p.id_proyecto, p.nombre_proyecto, d.nombre_departamento
FROM proyectos p
LEFT JOIN departamentos d ON p.id_departamento = d.id_departamento;

 
-- Ejercicio N8
SELECT p.id_proyecto, p.nombre_proyecto
FROM proyectos p
WHERE (
    SELECT COUNT(*)
    FROM asignaciones a
    WHERE a.id_proyecto = p.id_proyecto
) > 1;


-- Ejercicio N9. Encuentra los empleados que trabajan en proyectos del departamento de Desarrollo.
SELECT e.nombre_empleado 
FROM empleados e 
JOIN asignaciones a ON e.id_empleado = a.id_empleado 
JOIN proyectos p ON a.id_proyecto = p.id_proyecto 
WHERE p.id_proyecto = (
			SELECT id_departamento
		  FROM departamentos d
		  WHERE nombre_departamento = 'Desarrollo');

-- Ejercicio N10. Consulta los departamentos que tienen más de un proyecto asignado.
SELECT d.nombre_departamento , count(p.id_proyecto) AS proyectos_asignados 
FROM departamentos d 
INNER JOIN proyectos p ON d.id_departamento = p.id_departamento
GROUP BY d.nombre_departamento 
HAVING COUNT(p.id_proyecto) > 1; 

/**********************************************************************************
 * CONSULTAS ANIDADAS
**********************************************************************************/
-- Ejercicio N1. Encuentra los nombres de los empleados que trabajan en proyectos del departamento
-- de Recursos Humanos.
SELECT e.nombre_empleado 
FROM empleados e 
WHERE id_empleado IN (
			SELECT a.id_empleado
			FROM asignaciones a 
			WHERE a.id_proyecto IN (
							SELECT p.id_proyecto 
							FROM proyectos p 
							WHERE p.id_departamento = 1)
);

-- Ejercicio N2. Encuentra los proyectos en los que trabaja un empleado llamado 'Juan'.
SELECT p.nombre_proyecto
FROM proyectos p 
WHERE p.id_proyecto IN (
				SELECT a.id_empleado
				FROM asignaciones a 
				WHERE a.id_empleado = (
							SELECT e.id_empleado 
							from empleados e 
							WHERE e.nombre_empleado LIKE 'Juan' 
				)
);

/**********************************************************************************
 * Respuestas
**********************************************************************************/
-- Ejercicio 1: Consulta los nombres de los empleados y los nombres de los departamentos a los que pertenecen
SELECT empleados.nombre_empleado, departamentos.nombre_departamento
FROM empleados
INNER JOIN departamentos ON empleados.id_departamento = departamentos.id_departamento;

-- Ejercicio 2: Lista los nombres de los proyectos junto con los nombres de los departamentos que los gestionan
SELECT proyectos.nombre_proyecto, departamentos.nombre_departamento
FROM proyectos
INNER JOIN departamentos ON proyectos.id_departamento = departamentos.id_departamento;

-- Ejercicio 3: Muestra los empleados y los proyectos en los que están asignados
SELECT empleados.nombre_empleado, proyectos.nombre_proyecto
FROM asignaciones
INNER JOIN empleados ON asignaciones.id_empleado = empleados.id_empleado
INNER JOIN proyectos ON asignaciones.id_proyecto = proyectos.id_proyecto;

-- Ejercicio 4: Encuentra los empleados que están asignados a proyectos del departamento de Finanzas
SELECT empleados.nombre_empleado
FROM asignaciones
INNER JOIN empleados ON asignaciones.id_empleado = empleados.id_empleado
INNER JOIN proyectos ON asignaciones.id_proyecto = proyectos.id_proyecto
WHERE proyectos.id_departamento = 2;

-- Ejercicio 5: Lista todos los proyectos y los empleados asignados, incluyendo los proyectos sin asignación
SELECT proyectos.nombre_proyecto, empleados.nombre_empleado
FROM proyectos
LEFT JOIN asignaciones ON proyectos.id_proyecto = asignaciones.id_proyecto
LEFT JOIN empleados ON asignaciones.id_empleado = empleados.id_empleado;

-- Ejercicio 6: Lista los empleados sin asignación a ningún proyecto
SELECT empleados.nombre_empleado
FROM empleados
LEFT JOIN asignaciones ON empleados.id_empleado = asignaciones.id_empleado
WHERE asignaciones.id_proyecto IS NULL;

-- Ejercicio 7: Encuentra los departamentos que no tienen proyectos asociados
SELECT departamentos.nombre_departamento
FROM departamentos
LEFT JOIN proyectos ON departamentos.id_departamento = proyectos.id_departamento
WHERE proyectos.id_proyecto IS NULL;

-- Ejercicio 8: Muestra los proyectos que tienen más de un empleado asignado
SELECT proyectos.nombre_proyecto, COUNT(asignaciones.id_empleado) AS empleados_asignados
FROM proyectos
INNER JOIN asignaciones ON proyectos.id_proyecto = asignaciones.id_proyecto
GROUP BY proyectos.nombre_proyecto
HAVING empleados_asignados > 1;

-- Ejercicio 9: Encuentra los empleados que trabajan en proyectos del departamento de Desarrollo
SELECT empleados.nombre_empleado
FROM asignaciones
INNER JOIN empleados ON asignaciones.id_empleado = empleados.id_empleado
INNER JOIN proyectos ON asignaciones.id_proyecto = proyectos.id_proyecto
WHERE proyectos.id_departamento = 3;

-- Ejercicio 10: Consulta los departamentos que tienen más de un proyecto asignado
SELECT departamentos.nombre_departamento, COUNT(proyectos.id_proyecto) AS proyectos_asignados
FROM departamentos
INNER JOIN proyectos ON departamentos.id_departamento = proyectos.id_departamento
GROUP BY departamentos.nombre_departamento
HAVING proyectos_asignados > 1;

-- Consulta Anidada 1: Encuentra los nombres de los empleados que trabajan en proyectos del departamento de Recursos Humanos
SELECT nombre_empleado
FROM empleados
WHERE id_empleado IN (
    SELECT id_empleado
    FROM asignaciones
    WHERE id_proyecto IN (
        SELECT id_proyecto
        FROM proyectos
        WHERE id_departamento = 1
    )
);

-- Consulta Anidada 2: Encuentra los proyectos en los que trabaja un empleado llamado 'Juan'
SELECT nombre_proyecto
FROM proyectos
WHERE id_proyecto IN (
    SELECT id_proyecto
    FROM asignaciones
    WHERE id_empleado = (
        SELECT id_empleado
        FROM empleados
        WHERE nombre_empleado = 'Juan'
    )
);

-- Consulta Anidada 3: Encuentra los empleados que no trabajan en ningún proyecto del departamento de Finanzas
SELECT nombre_empleado
FROM empleados
WHERE id_empleado NOT IN (
    SELECT id_empleado
    FROM asignaciones
    WHERE id_proyecto IN (
        SELECT id_proyecto
        FROM proyectos
        WHERE id_departamento = 2
    )
);

-- Consulta Anidada 4: Lista los nombres de los departamentos que tienen empleados asignados a proyectos
SELECT nombre_departamento
FROM departamentos
WHERE id_departamento IN (
    SELECT id_departamento
    FROM proyectos
    WHERE id_proyecto IN (
        SELECT id_proyecto
        FROM asignaciones
    )
);

-- Consulta Anidada 5: Encuentra el nombre del empleado que trabaja en más proyectos
SELECT nombre_empleado
FROM empleados
WHERE id_empleado = (
    SELECT id_empleado
    FROM asignaciones
    GROUP BY id_empleado
    ORDER BY COUNT(id_proyecto) DESC
    LIMIT 1
);


