
/*********************************************************
SCRIPT EJERCICIO FINAL N°2 | MODULO 3
ALUMNO			: Francisco Javier Araya Hernandez
FECHA				: 12/09/2024

*********************************************************/

/*********************************************************
SCRIPT CREACION DE ENTIDADES DE LA BASE DE DATOS
*********************************************************/
-- Tabla Maquinaria
CREATE TABLE maquinaria(
	id_maquinaria					serial PRIMARY KEY,
	nombre								varchar(120)
);

-- Tabla Empresa
CREATE TABLE empresa(
	rut										varchar(10) PRIMARY KEY,
	nombre 								varchar(120)
);

-- Tabla Bodega
CREATE TABLE bodega(
	id_bodega							numeric(12,0) PRIMARY KEY,
	nombre 								varchar(120)
);

-- Tabla Receta
CREATE TABLE receta(
	id_receta							numeric(12,0) PRIMARY KEY,
	nombre 								varchar(120)
);

-- Tabla Inventario
CREATE TABLE inventario(
	id_inventario					numeric(12,0) PRIMARY KEY,
	nombre 								varchar(120),
	stock									numeric(8,0)
);

-- Tabla Proveedor
CREATE TABLE proveedor(
	rut 									varchar(10) PRIMARY KEY,
	nombre 								varchar(120)
);

-- Tabla TipoCecina
CREATE TABLE tipo_cecina(
	id_tipo_cecina				numeric(12,0) PRIMARY KEY,
	nombre 								varchar(120)
);

-- Tabla Cliente
CREATE TABLE cliente(
	rut 									varchar(10) PRIMARY KEY,
	nombre 								varchar(120),
	giro									varchar(120),
	direccion							varchar(120),
	ciudad								varchar(40),
	fono									varchar(15)
);

-- Tabla Planta Produccion
CREATE TABLE planta_prod(
	id_planta_prod				numeric(12,0) PRIMARY KEY,
	nombre 								varchar(120),
	id_maquinaria 				integer,
	
	CONSTRAINT plantaprod_maquinaria_fk FOREIGN KEY (id_maquinaria) REFERENCES maquinaria(id_maquinaria) 
);

-- Tabla Produccion
CREATE TABLE produccion(
	id_produccion					numeric(12,0) PRIMARY KEY,
	fecha_inicio					date,
	fecha_termino					date,
	id_planta_prod 				numeric(12,0),
	
	CONSTRAINT produccion_plantaprod_fk FOREIGN KEY (id_planta_prod) REFERENCES planta_prod (id_planta_prod)
);

-- Tabla Detalles de Produccion
CREATE TABLE det_produccion(
	id_det_produccion			numeric(12,0) PRIMARY KEY,
	cantidad_esperada			numeric(12,0),
	cantidad_obtenida			numeric(12,0),
	fecha_inicio 					date,
	fecha_termino 				date,
	id_produccion 				numeric(12,0),
	id_receta 						numeric(12,0),
	id_bodega 						numeric(12,0),
	
	CONSTRAINT detproduccion_produccion_fk FOREIGN KEY (id_produccion) REFERENCES produccion (id_produccion),
	CONSTRAINT detproduccion_receta_fk FOREIGN KEY (id_receta) REFERENCES receta (id_receta),
	CONSTRAINT detproduccion_bodega_fk FOREIGN KEY (id_bodega) REFERENCES bodega (id_bodega)
);

-- Tabla Venta
CREATE TABLE venta(
	numero_factura				numeric(12,0) PRIMARY KEY,
	fecha_venta						date,
	total									numeric(12,0),
	cliente_rut						varchar(10),
	
	CONSTRAINT venta_cliente_fk FOREIGN KEY (cliente_rut) REFERENCES cliente (rut)
);

-- Tabla Compra
CREATE TABLE compra(
	numero_factura 				NUMERIC(12,0) PRIMARY KEY,
	fecha_venta 					date,
	total 								numeric(12,0),
	proveedor_rut					varchar(10),
	
	CONSTRAINT compra_proveedor_fk FOREIGN KEY (proveedor_rut) REFERENCES proveedor (rut)
);

-- Tabla Detalle Compra
CREATE TABLE det_compra(
	id_det_compra					numeric(12,0) PRIMARY KEY,
	cantidad 							numeric(12,0),
	descripcion						varchar(120),
	unitario							numeric(12,0),
	id_inventario 				numeric(12,0),
	numero_factura 				numeric(12,0),
	
	CONSTRAINT detcompra_inventario_fk FOREIGN KEY (id_inventario) REFERENCES inventario (id_inventario),
	CONSTRAINT detcompra_compra_fk FOREIGN KEY (numero_factura) REFERENCES compra (numero_factura)
);

-- Tabla Cecina
CREATE TABLE cecina(
	id_cecina						 	numeric(12,0) PRIMARY KEY,
	nombre 								varchar(120),
	stock 								numeric(8,0),
	precio								numeric(12,0),
	id_tipo_cecina 				numeric(12,0),
	
	CONSTRAINT cecina_tipocecina_fk FOREIGN KEY (id_tipo_cecina) REFERENCES tipo_cecina (id_tipo_cecina)
);

-- Tabla Detalle Venta
CREATE TABLE det_venta(
	id_det_venta					numeric(12,0) PRIMARY KEY,
	cantidad 							numeric(8,0),
	descripcion 					varchar(120),
	unitario 							numeric(12,0),
	id_cecina 						numeric(12,0),
	venta_numero_factura	numeric(12,0),
	
	CONSTRAINT detventa_cecina_fk FOREIGN KEY (id_cecina) REFERENCES cecina (id_cecina),
	CONSTRAINT detventa_venta_fk FOREIGN KEY (venta_numero_factura) REFERENCES venta (numero_factura)
);

-- Tabla Detalle Receta
CREATE TABLE det_receta(
	id_det_receta serial PRIMARY KEY,
	receta_id							numeric(12,0),
	cantidad 							numeric(8,0),
	inventario_id					numeric(12,0),
	cecina_id							numeric(12,0),
	
	CONSTRAINT detreceta_receta_fk FOREIGN KEY (receta_id) REFERENCES receta (id_receta),
	CONSTRAINT detreceta_inventario_fk FOREIGN KEY (inventario_id) REFERENCES inventario (id_inventario),
	CONSTRAINT detreceta_cecina_fk FOREIGN KEY (cecina_id) REFERENCES cecina (id_cecina)
);

/*********************************************************
SCRIPT DE CARGA DE DATA A LA BASE DE DATOS
*********************************************************/
-- Tabla Maquinaria (50 registros)
INSERT INTO maquinaria (nombre) VALUES
('Molino de Carne Modelo X1'),
('Picadora de Carne HP-2000'),
('Mezcladora de Carne ProMix'),
('Prensa de Cecina MS-500'),
('Trituradora de Huesos TX-700'),
('Máquina de Embutido CE-100'),
('Cortadora de Cecina CS-300'),
('Secadora de Cecina DX-800'),
('Refrigerador de Carne FR-600'),
('Estufadora de Cecina ES-400'),
('Batidora de Carne BM-1500'),
('Envasadora de Cecina EV-250'),
('Desinfectadora de Equipos DE-500'),
('Calentador de Carne HC-350'),
('Deshidratadora de Cecina DC-700'),
('Afiladora de Cuchillos AC-600'),
('Cámara de Maduración CM-900'),
('Mezcladora de Especias ME-200'),
('Máquina de Etiquetado ET-150'),
('Trituradora de Vísceras TV-100'),
('Enfriadora de Cecina EC-350'),
('Embutidora de Tripas ET-250'),
('Aparato de Control de Temperatura AT-500'),
('Cortadora de Jamón CJ-800'),
('Lavadora de Equipos LE-1000'),
('Secadora de Tripas ST-400'),
('Máquina de Cortar Hielo MC-200'),
('Generador de Vapor GV-500'),
('Cámara de Frío CF-700'),
('Desengrasadora DG-300'),
('Máquina de Emulsión ME-800'),
('Cortadora de Fiambres CF-250'),
('Homogeneizadora de Carne HC-350'),
('Pulverizadora de Especias PE-100'),
('Cámara de Curado CC-600'),
('Generador de Nitrógeno GN-150'),
('Recicladora de Agua RA-700'),
('Máquina de Taponado MT-300'),
('Sistema de Filtración SF-900'),
('Cortadora de Pieles CP-250'),
('Moldeadora de Cecina MC-500'),
('Cámara de Secado CS-800'),
('Desinfectadora de Tripas DT-150'),
('Mezcladora de Ingredientes MI-200'),
('Cortadora de Carne Precisa CP-700'),
('Refrigerador de Ingredientes RI-400'),
('Cámara de Maduración Especial CME-900'),
('Trituradora de Pieles TP-350'),
('Estación de Control EC-500'),
('Deshidratadora de Tripas DT-300');

-- Tabla Empresa (50 registros)
INSERT INTO empresa (rut, nombre) VALUES
('7612345678', 'Cecinas del Valle S.A.'),
('7623456789', 'Delicias de Carne Ltda.'),
('7634567890', 'Cecinas Premium S.A.'),
('7645678901', 'Sabor a Cecina Ltda.'),
('7656789012', 'Carnes del Norte S.A.'),
('7667890123', 'Cecinas Artesanales S.A.'),
('7678901234', 'Cecinas del Sur Ltda.'),
('7689012345', 'Cecinas El Gran Sabor S.A.'),
('7690123456', 'Cecinas del Centro Ltda.'),
('7601234567', 'Carnes del Este S.A.'),
('7613456789', 'Cecinas Finas Ltda.'),
('7624567890', 'Sabor y Carne S.A.'),
('7635678901', 'Delicias y Carnes Ltda.'),
('7646789012', 'Cecinas Gourmet S.A.'),
('7657890123', 'Cecinas del Pacífico Ltda.'),
('7668901234', 'Cecinas Naturales S.A.'),
('7679012345', 'Cecinas del Campo Ltda.'),
('7680123456', 'Cecinas Tradicionales S.A.'),
('7691234567', 'Carnes del Altiplano Ltda.'),
('7602345678', 'Cecinas del Mundo S.A.'),
('7614567890', 'Cecinas del Buen Gusto Ltda.'),
('7625678901', 'Cecinas y Embutidos S.A.'),
('7636789012', 'Cecinas del Río Ltda.'),
('7647890123', 'Delicias del Norte S.A.'),
('7658901234', 'Cecinas del Altiplano Ltda.'),
('7669012345', 'Cecinas del Bosque S.A.'),
('7670123456', 'Cecinas del Lago Ltda.'),
('7681234567', 'Cecinas del Mar S.A.'),
('7692345678', 'Carnes de la Tierra Ltda.'),
('7603456789', 'Cecinas del Sol S.A.'),
('7615678901', 'Cecinas del Valle S.A.'),
('7626789012', 'Cecinas del Futuro Ltda.'),
('7637890123', 'Delicias y Cecinas S.A.'),
('7648901234', 'Cecinas de la Costa Ltda.'),
('7659012345', 'Cecinas y Carnes del Bosque S.A.'),
('7660123456', 'Cecinas del Campo Ltda.'),
('7671234567', 'Cecinas Tradicionales S.A.'),
('7682345678', 'Cecinas del Valle Ltda.'),
('7693456789', 'Cecinas del Desierto S.A.'),
('7604567890', 'Cecinas Premium Ltda.'),
('7616789013', 'Cecinas del Mar Ltda.'),
('7627890124', 'Cecinas del Pacífico S.A.'),
('7638901235', 'Cecinas del Río Ltda.'),
('7649012346', 'Delicias y Embutidos S.A.'),
('7650123457', 'Cecinas del Valle Ltda.'),
('7661234568', 'Cecinas del Sur S.A.'),
('7672345679', 'Cecinas Gourmet Ltda.'),
('7683456780', 'Cecinas Naturales S.A.'),
('7694567891', 'Cecinas del Altiplano Ltda.'),
('7605678902', 'Cecinas del Campo S.A.'),
('7617890123', 'Cecinas del Norte Ltda.'),
('7628901234', 'Cecinas del Este S.A.'),
('7639012345', 'Cecinas del Bosque Ltda.');

-- Tabla Bodega
INSERT INTO bodega (id_bodega, nombre) VALUES
(100000000001, 'Bodega Central'),
(100000000002, 'Bodega Norte'),
(100000000003, 'Bodega Sur'),
(100000000004, 'Bodega Este'),
(100000000005, 'Bodega Oeste'),
(100000000006, 'Bodega Principal'),
(100000000007, 'Bodega Secundaria'),
(100000000008, 'Bodega de Embalaje'),
(100000000009, 'Bodega de Insumos'),
(100000000010, 'Bodega de Producto Terminado'),
(100000000011, 'Bodega de Carnes'),
(100000000012, 'Bodega de Frigorífico'),
(100000000013, 'Bodega de Lácteos'),
(100000000014, 'Bodega de Congelados'),
(100000000015, 'Bodega de Conservas'),
(100000000016, 'Bodega de Abarrotes'),
(100000000017, 'Bodega de Vegetales'),
(100000000018, 'Bodega de Frutas'),
(100000000019, 'Bodega de Pescados'),
(100000000020, 'Bodega de Control de Calidad'),
(100000000021, 'Bodega de Exportación'),
(100000000022, 'Bodega de Logística'),
(100000000023, 'Bodega de Recepción'),
(100000000024, 'Bodega de Distribución'),
(100000000025, 'Bodega de Transporte'),
(100000000026, 'Bodega de Seguridad'),
(100000000027, 'Bodega de Procesos'),
(100000000028, 'Bodega de Almacén General'),
(100000000029, 'Bodega de Envasado'),
(100000000030, 'Bodega de Etiquetado'),
(100000000031, 'Bodega de Despacho'),
(100000000032, 'Bodega de Inspección'),
(100000000033, 'Bodega de Productos Frescos'),
(100000000034, 'Bodega de Empaquetado'),
(100000000035, 'Bodega de Secado'),
(100000000036, 'Bodega de Producción'),
(100000000037, 'Bodega de Control de Inventario'),
(100000000038, 'Bodega de Almacenamiento Temporal'),
(100000000039, 'Bodega de Repuestos'),
(100000000040, 'Bodega de Mantenimiento'),
(100000000041, 'Bodega de Control Ambiental'),
(100000000042, 'Bodega de Exportación Especial'),
(100000000043, 'Bodega de Tratamiento Térmico'),
(100000000044, 'Bodega de Productos Derivados'),
(100000000045, 'Bodega de Productos Terminados'),
(100000000046, 'Bodega de Productos en Proceso'),
(100000000047, 'Bodega de Reciclaje'),
(100000000048, 'Bodega de Retornos'),
(100000000049, 'Bodega de Inspección Final'),
(100000000050, 'Bodega de Control de Stock');

-- Tabla Receta
INSERT INTO receta (id_receta, nombre) VALUES
(200000000001, 'Receta Tradicional de Longaniza'),
(200000000002, 'Receta de Jamón Artesanal'),
(200000000003, 'Receta de Chorizo Picante'),
(200000000004, 'Receta de Salchichón Español'),
(200000000005, 'Receta de Mortadela con Aceitunas'),
(200000000006, 'Receta de Salame Italiano'),
(200000000007, 'Receta de Jamón Cocido'),
(200000000008, 'Receta de Cecina Ahumada'),
(200000000009, 'Receta de Fuet Catalán'),
(200000000010, 'Receta de Jamón Serrano'),
(200000000011, 'Receta de Chorizo Criollo'),
(200000000012, 'Receta de Lomo Ahumado'),
(200000000013, 'Receta de Pechuga de Pavo Curada'),
(200000000014, 'Receta de Embutido de Pollo'),
(200000000015, 'Receta de Butifarra Blanca'),
(200000000016, 'Receta de Salchicha Alemana'),
(200000000017, 'Receta de Jamón Ahumado'),
(200000000018, 'Receta de Chistorra Vasca'),
(200000000019, 'Receta de Panceta Curada'),
(200000000020, 'Receta de Chorizo a la Sidra'),
(200000000021, 'Receta de Chorizo con Pimentón'),
(200000000022, 'Receta de Salchichas Vienesas'),
(200000000023, 'Receta de Longaniza de Huaso'),
(200000000024, 'Receta de Jamón de Pavo'),
(200000000025, 'Receta de Cecina Curada'),
(200000000026, 'Receta de Morcilla Tradicional'),
(200000000027, 'Receta de Embutido de Ternera'),
(200000000028, 'Receta de Paté de Campaña'),
(200000000029, 'Receta de Sobrasada Mallorquina'),
(200000000030, 'Receta de Jamón Ibérico'),
(200000000031, 'Receta de Longaniza Ahumada'),
(200000000032, 'Receta de Mortadela Tradicional'),
(200000000033, 'Receta de Jamón de Cerdo Ahumado'),
(200000000034, 'Receta de Salchicha Blanca Alemana'),
(200000000035, 'Receta de Chorizo de Res'),
(200000000036, 'Receta de Salchichón Ahumado'),
(200000000037, 'Receta de Cecina a las Hierbas'),
(200000000038, 'Receta de Longaniza Picante'),
(200000000039, 'Receta de Jamón con Especias'),
(200000000040, 'Receta de Chorizo Mexicano'),
(200000000041, 'Receta de Lomo Curado'),
(200000000042, 'Receta de Salchichas con Queso'),
(200000000043, 'Receta de Cecina de Res'),
(200000000044, 'Receta de Chorizo Ahumado'),
(200000000045, 'Receta de Salchichas con Ajo'),
(200000000046, 'Receta de Jamón Curado Artesanal'),
(200000000047, 'Receta de Chorizo Extremeño'),
(200000000048, 'Receta de Chorizo con Ajo'),
(200000000049, 'Receta de Longaniza Curada'),
(200000000050, 'Receta de Jamón Dulce Ahumado');

-- Tabla Inventario
INSERT INTO inventario (id_inventario, nombre, stock) VALUES
(300000000001, 'Tripas Naturales', 1200),
(300000000002, 'Sal Refinada', 800),
(300000000003, 'Pimienta Negra Molida', 450),
(300000000004, 'Ajo en Polvo', 600),
(300000000005, 'Pimentón Dulce', 500),
(300000000006, 'Grasa de Cerdo', 750),
(300000000007, 'Carne de Res', 300),
(300000000008, 'Carne de Cerdo', 900),
(300000000009, 'Carne de Pavo', 400),
(300000000010, 'Pimienta Roja', 350),
(300000000011, 'Emulsionante Cárnico', 500),
(300000000012, 'Conservador de Alimentos', 700),
(300000000013, 'Antioxidantes Naturales', 600),
(300000000014, 'Nitrato de Sodio', 200),
(300000000015, 'Leche en Polvo', 250),
(300000000016, 'Perejil Deshidratado', 300),
(300000000017, 'Hielo Triturado', 1500),
(300000000018, 'Salchichón en Curado', 600),
(300000000019, 'Chorizo en Curado', 700),
(300000000020, 'Tripas Sintéticas', 800),
(300000000021, 'Salchichas Frescas', 300),
(300000000022, 'Tocino Ahumado', 900),
(300000000023, 'Paprika', 500),
(300000000024, 'Jalapeños', 400),
(300000000025, 'Cilantro Molido', 300),
(300000000026, 'Salchichas Cocidas', 700),
(300000000027, 'Longanizas Frescas', 850),
(300000000028, 'Morcilla Tradicional', 500),
(300000000029, 'Pimientos Picantes', 400),
(300000000030, 'Carne de Pollo', 350),
(300000000031, 'Cebolla en Polvo', 450),
(300000000032, 'Aditivo Colorante Natural', 700),
(300000000033, 'Agua Potable', 2000),
(300000000034, 'Jamón Serrano', 800),
(300000000035, 'Carne Curada', 600),
(300000000036, 'Almidón de Maíz', 500),
(300000000037, 'Manteca de Cerdo', 550),
(300000000038, 'Tripas de Colágeno', 400),
(300000000039, 'Salchichas en Conserva', 450),
(300000000040, 'Longaniza Ahumada', 700),
(300000000041, 'Tripas para Longaniza', 300),
(300000000042, 'Jamón Cocido', 900),
(300000000043, 'Cecina de Res', 500),
(300000000044, 'Salchichas Ahumadas', 600),
(300000000045, 'Cecina Curada', 700),
(300000000046, 'Conservante para Cecina', 450),
(300000000047, 'Acondicionador de Masa', 350),
(300000000048, 'Ajo Fresco', 800),
(300000000049, 'Hierbas Finas', 400),
(300000000050, 'Orégano Molido', 500);

-- Tabla Proveedor
INSERT INTO proveedor (rut, nombre) VALUES
('7612345678', 'Carnes del Sur S.A.'),
('7613456789', 'Embutidos Premium Ltda.'),
('7614567890', 'Proveedores Alimenticios SPA'),
('7615678901', 'Cecinas del Norte Ltda.'),
('7616789012', 'La Fábrica de Jamones'),
('7617890123', 'Tripas y Embutidos Chile'),
('7618901234', 'Especias y Condimentos Gourmet'),
('7619012345', 'Distribuidora de Carnes Finas'),
('7620123456', 'Productos Cárnicos Frescos SPA'),
('7621234567', 'Provisiones Gourmet S.A.'),
('7622345678', 'Abastecimientos Cárnicos Ltda.'),
('7623456789', 'Embutidos del Campo SPA'),
('7624567890', 'Cárnicos Premium Internacional'),
('7625678901', 'Ahumados del Sur Ltda.'),
('7626789012', 'Suministros Cárnicos SPA'),
('7627890123', 'Proveedores de Jamón Serrano'),
('7628901234', 'El Palacio del Embutido Ltda.'),
('7629012345', 'Carnes Curadas y Ahumadas'),
('7630123456', 'Condimentos del Chef SPA'),
('7631234567', 'Cecinas Artesanales del Norte'),
('7632345678', 'Proveedores Gourmet Internacional'),
('7633456789', 'Distribuidora de Especias Ltda.'),
('7634567890', 'Carnes Selectas SPA'),
('7635678901', 'Tripas Naturales y Sintéticas Ltda.'),
('7636789012', 'Conservadores y Aditivos S.A.'),
('7637890123', 'El Sabor del Campo Ltda.'),
('7638901234', 'Embutidos Tradicionales SPA'),
('7639012345', 'Proveedores de Embutidos y Cecinas'),
('7640123456', 'Ahumados Premium Internacional'),
('7641234567', 'Cecinas Gourmet del Sur SPA'),
('7642345678', 'Suministros del Gourmet Ltda.'),
('7643456789', 'Carnes Ahumadas del Norte SPA'),
('7644567890', 'Distribuidora Cárnica Internacional'),
('7645678901', 'Productos de Campo Ltda.'),
('7646789012', 'Tripas y Embutidos Gourmet SPA'),
('7647890123', 'Abastecedores Cárnicos del Sur'),
('7648901234', 'Cecinas y Jamones Tradicionales SPA'),
('7649012345', 'Proveedores de Embutidos Finos'),
('7650123456', 'Aditivos y Conservantes Naturales Ltda.'),
('7651234567', 'El Gourmet de las Cecinas Ltda.'),
('7652345678', 'Suministros Cárnicos Selectos SPA'),
('7653456789', 'Carnes del Chef Internacional'),
('7654567890', 'Distribuidora de Jamones SPA'),
('7655678901', 'Especias Finas del Norte'),
('7656789012', 'Carnes Premium Artesanales Ltda.'),
('7657890123', 'Suministros de Embutidos SPA'),
('7658901234', 'El Ahumadero Artesanal SPA'),
('7659012345', 'Carnes y Embutidos Gourmet SPA'),
('7660123456', 'Proveedores Selectos Ltda.'),
('7661234567', 'El Artesano de las Cecinas Ltda.');

-- Tabla TipoCecina
INSERT INTO tipo_cecina (id_tipo_cecina, nombre) VALUES
(500000000001, 'Salchichón Ahumado'),
(500000000002, 'Chorizo Picante'),
(500000000003, 'Longaniza Tradicional'),
(500000000004, 'Jamón Serrano'),
(500000000005, 'Cecina de Res'),
(500000000006, 'Chistorra'),
(500000000007, 'Morcilla'),
(500000000008, 'Salami Italiano'),
(500000000009, 'Chorizo Blanco'),
(500000000010, 'Salchicha Vienesa'),
(500000000011, 'Cecina de Cerdo'),
(500000000012, 'Salchicha Alemana'),
(500000000013, 'Fuet Catalán'),
(500000000014, 'Jamón Cocido'),
(500000000015, 'Mortadela Italiana'),
(500000000016, 'Salchichón de Pavo'),
(500000000017, 'Salchichón de Pollo'),
(500000000018, 'Tocino Ahumado'),
(500000000019, 'Jamón Ahumado'),
(500000000020, 'Lomo Embuchado'),
(500000000021, 'Cecina de Caballo'),
(500000000022, 'Cecina de Pato'),
(500000000023, 'Chorizo Criollo'),
(500000000024, 'Pastrami'),
(500000000025, 'Jamón de Pavo'),
(500000000026, 'Salchicha de Pollo'),
(500000000027, 'Longaniza Ahumada'),
(500000000028, 'Chorizo Cantimpalo'),
(500000000029, 'Jamón York'),
(500000000030, 'Chorizo Parrillero'),
(500000000031, 'Butifarra'),
(500000000032, 'Lomo Canadiense'),
(500000000033, 'Morcón Ibérico'),
(500000000034, 'Cecina de Jabalí'),
(500000000035, 'Chorizo de Ciervo'),
(500000000036, 'Salchichón Ibérico'),
(500000000037, 'Lomo Ahumado'),
(500000000038, 'Jamón de Pavo Ahumado'),
(500000000039, 'Chorizo Ahumado'),
(500000000040, 'Mortadela Ahumada'),
(500000000041, 'Salchicha de Ternera'),
(500000000042, 'Cecina de Venao'),
(500000000043, 'Salchichón Ahumado con Ajo'),
(500000000044, 'Cecina de Cordero'),
(500000000045, 'Chorizo a la Sidra'),
(500000000046, 'Cecina Vegana'),
(500000000047, 'Jamón Curado'),
(500000000048, 'Cecina Artesanal'),
(500000000049, 'Chorizo de Pollo Picante'),
(500000000050, 'Salchichón Extra');

-- Tabla Cliente
INSERT INTO cliente (rut, nombre, giro, direccion, ciudad, fono) VALUES
('7612345678', 'Supermercado Central', 'Venta de Alimentos', 'Av. Independencia 1234', 'Santiago', '221234567'),
('7613456789', 'Distribuidora Los Robles', 'Distribución de Alimentos', 'Calle Los Álamos 567', 'Concepción', '412345678'),
('7614567890', 'Carnicería El Buen Corte', 'Carnicería', 'Calle San Martín 789', 'Valparaíso', '322345678'),
('7615678901', 'Mercado Gourmet', 'Venta de Alimentos', 'Av. Las Flores 234', 'Viña del Mar', '322987654'),
('7616789012', 'Restaurante Delicias del Campo', 'Restaurante', 'Calle Las Palmeras 123', 'Rancagua', '722345678'),
('7617890123', 'Cecinas Premium', 'Venta de Cecinas', 'Av. La Paz 456', 'Osorno', '642345678'),
('7618901234', 'Distribuidora La Esperanza', 'Distribución de Carnes', 'Calle Libertad 890', 'Chillán', '422345678'),
('7619012345', 'Supermercado La Familia', 'Venta de Alimentos', 'Av. Siempreviva 567', 'Temuco', '452345678'),
('7620123456', 'Carnes del Sur', 'Distribución de Alimentos', 'Calle del Río 789', 'Puerto Montt', '652345678'),
('7621234567', 'Supermercado El Ahorro', 'Venta de Alimentos', 'Calle Falsa 123', 'Antofagasta', '552345678'),
('7622345678', 'Fiambrería Los Andes', 'Venta de Fiambrería', 'Av. Las Torres 456', 'La Serena', '512345678'),
('7623456789', 'Restaurante El Gaucho', 'Restaurante', 'Av. Los Leones 789', 'Punta Arenas', '612345678'),
('7624567890', 'Carnicería Don Pedro', 'Carnicería', 'Calle Esmeralda 123', 'Iquique', '572345678'),
('7625678901', 'Supermercado Las Brisas', 'Venta de Alimentos', 'Av. Italia 456', 'Arica', '582345678'),
('7626789012', 'Cecinas La Tradición', 'Venta de Cecinas', 'Calle del Lago 789', 'Talca', '712345678'),
('7627890123', 'Fiambrería Santa Isabel', 'Venta de Fiambrería', 'Av. San Diego 123', 'Copiapó', '522345678'),
('7628901234', 'Restaurante El Asador', 'Restaurante', 'Av. Providencia 456', 'Calama', '552987654'),
('7629012345', 'Distribuidora de Carnes Frescas', 'Distribución de Carnes', 'Calle Larga 789', 'La Calera', '332345678'),
('7630123456', 'Mercado La Granja', 'Venta de Alimentos', 'Av. Los Pinos 123', 'Coyhaique', '672345678'),
('7631234567', 'Supermercado Norte', 'Venta de Alimentos', 'Av. Cordillera 456', 'Quillota', '332987654'),
('7632345678', 'Carnicería Los Alerces', 'Carnicería', 'Calle del Bosque 789', 'Curicó', '752345678'),
('7633456789', 'Supermercado Todo Fresco', 'Venta de Alimentos', 'Av. Colón 123', 'La Unión', '642987654'),
('7634567890', 'Restaurante La Parrilla', 'Restaurante', 'Calle Las Rosas 456', 'Linares', '732345678'),
('7635678901', 'Distribuidora El Rancho', 'Distribución de Alimentos', 'Calle Las Higueras 789', 'Los Ángeles', '432345678'),
('7636789012', 'Supermercado San Jorge', 'Venta de Alimentos', 'Av. San Juan 123', 'Angol', '452345678'),
('7637890123', 'Carnicería La Estancia', 'Carnicería', 'Calle Las Acacias 456', 'Pucón', '452987654'),
('7638901234', 'Mercado La Paloma', 'Venta de Alimentos', 'Av. La Estrella 789', 'Cochrane', '672987654'),
('7639012345', 'Restaurante El Pionero', 'Restaurante', 'Av. Los Aromos 123', 'Chaitén', '652987654'),
('7640123456', 'Supermercado La Vega', 'Venta de Alimentos', 'Calle Las Lilas 456', 'Puerto Natales', '612987654'),
('7641234567', 'Carnicería El Gran Cortes', 'Carnicería', 'Av. El Bosque 789', 'Rengo', '722987654'),
('7642345678', 'Distribuidora La Patagonia', 'Distribución de Carnes', 'Calle del Cóndor 123', 'Aysén', '672345123'),
('7643456789', 'Supermercado Norte Chico', 'Venta de Alimentos', 'Av. San Antonio 456', 'Vallenar', '512987654'),
('7644567890', 'Restaurante Los Parrilleros', 'Restaurante', 'Calle de la Parra 789', 'San Fernando', '722345123'),
('7645678901', 'Distribuidora Los Maquis', 'Distribución de Alimentos', 'Av. Las Encinas 123', 'San Felipe', '332345123'),
('7646789012', 'Carnicería El Ganado', 'Carnicería', 'Calle del Rodeo 456', 'Illapel', '532345678'),
('7647890123', 'Supermercado Económico', 'Venta de Alimentos', 'Av. Los Álamos 789', 'Quilpué', '322345789'),
('7648901234', 'Fiambrería La Villa', 'Venta de Fiambrería', 'Calle del Sauce 123', 'Ovalle', '532987654'),
('7649012345', 'Restaurante La Cabaña', 'Restaurante', 'Av. El Olivar 456', 'Calbuco', '652345789'),
('7650123456', 'Carnicería El Roble', 'Carnicería', 'Calle Los Canelos 789', 'Castro', '652987123'),
('7651234567', 'Distribuidora La Cumbre', 'Distribución de Carnes', 'Av. El Roble 123', 'San Antonio', '352345678'),
('7652345678', 'Supermercado Los Lagos', 'Venta de Alimentos', 'Calle El Volcán 456', 'Valdivia', '632345123'),
('7653456789', 'Carnicería Del Sur', 'Carnicería', 'Calle Las Rocas 789', 'Puerto Varas', '652345123'),
('7654567890', 'Supermercado El Bosque', 'Venta de Alimentos', 'Av. El Cerro 123', 'Talca', '712345123'),
('7655678901', 'Fiambrería Los Ríos', 'Venta de Fiambrería', 'Calle del Árbol 456', 'Valparaíso', '322345123'),
('7656789012', 'Distribuidora de Carnes Naturales', 'Distribución de Carnes', 'Av. Las Aguas 789', 'Viña del Mar', '322987123'),
('7657890123', 'Restaurante Los Leñadores', 'Restaurante', 'Calle El Trigal 123', 'Temuco', '452345123'),
('7658901234', 'Supermercado El Mercado', 'Venta de Alimentos', 'Calle del Comercio 456', 'Chillán', '422987123'),
('7659012345', 'Carnicería Las Pampas', 'Carnicería', 'Calle del Estero 789', 'Quirihue', '422345789');

-- Tabla Planta Produccion
INSERT INTO planta_prod (id_planta_prod, nombre, id_maquinaria) VALUES
(1, 'Planta Norte', 1),
(2, 'Planta Sur', 2),
(3, 'Planta Este', 3),
(4, 'Planta Oeste', 4),
(5, 'Planta Central', 5),
(6, 'Planta Costa', 1),
(7, 'Planta Sierra', 2),
(8, 'Planta Frontera', 3),
(9, 'Planta Insular', 4),
(10, 'Planta Altiplano', 5),
(11, 'Planta Llanura', 1),
(12, 'Planta Montaña', 2),
(13, 'Planta Selva', 3),
(14, 'Planta Desierto', 4),
(15, 'Planta Pampa', 5),
(16, 'Planta Bosque', 1),
(17, 'Planta Valle', 2),
(18, 'Planta Río', 3),
(19, 'Planta Laguna', 4),
(20, 'Planta Delta', 5),
(21, 'Planta Capital', 1),
(22, 'Planta Isla Grande', 2),
(23, 'Planta Península', 3),
(24, 'Planta Altura', 4),
(25, 'Planta Litoral', 5),
(26, 'Planta Volcán', 1),
(27, 'Planta Roca', 2),
(28, 'Planta Caverna', 3),
(29, 'Planta Glaciar', 4),
(30, 'Planta Oasis', 5),
(31, 'Planta Tundra', 1),
(32, 'Planta Ciénaga', 2),
(33, 'Planta Sabana', 3),
(34, 'Planta Finca', 4),
(35, 'Planta Costa Sur', 5),
(36, 'Planta Páramo', 1),
(37, 'Planta Fuerte', 2),
(38, 'Planta Bahía', 3),
(39, 'Planta Marisma', 4),
(40, 'Planta Fábrica Principal', 5),
(41, 'Planta Mirador', 1),
(42, 'Planta Resguardo', 2),
(43, 'Planta Fortaleza', 3),
(44, 'Planta Barrera', 4),
(45, 'Planta Retiro', 5),
(46, 'Planta Refugio', 1),
(47, 'Planta Laguna Alta', 2),
(48, 'Planta Cordillera', 3),
(49, 'Planta Puerto', 4),
(50, 'Planta Arena', 5);

-- Tabla Produccion
INSERT INTO produccion (id_produccion, fecha_inicio, fecha_termino, id_planta_prod) VALUES
(1, '2024-01-01', '2024-01-15', 1),
(2, '2024-01-16', '2024-01-30', 2),
(3, '2024-02-01', '2024-02-15', 3),
(4, '2024-02-16', '2024-03-01', 4),
(5, '2024-03-02', '2024-03-16', 5),
(6, '2024-03-17', '2024-03-31', 6),
(7, '2024-04-01', '2024-04-15', 7),
(8, '2024-04-16', '2024-04-30', 8),
(9, '2024-05-01', '2024-05-15', 9),
(10, '2024-05-16', '2024-05-31', 10),
(11, '2024-06-01', '2024-06-15', 11),
(12, '2024-06-16', '2024-06-30', 12),
(13, '2024-07-01', '2024-07-15', 13),
(14, '2024-07-16', '2024-07-31', 14),
(15, '2024-08-01', '2024-08-15', 15),
(16, '2024-08-16', '2024-08-31', 16),
(17, '2024-09-01', '2024-09-15', 17),
(18, '2024-09-16', '2024-09-30', 18),
(19, '2024-10-01', '2024-10-15', 19),
(20, '2024-10-16', '2024-10-31', 20),
(21, '2024-11-01', '2024-11-15', 21),
(22, '2024-11-16', '2024-11-30', 22),
(23, '2024-12-01', '2024-12-15', 23),
(24, '2024-12-16', '2024-12-31', 24),
(25, '2025-01-01', '2025-01-15', 25),
(26, '2025-01-16', '2025-01-31', 26),
(27, '2025-02-01', '2025-02-15', 27),
(28, '2025-02-16', '2025-03-01', 28),
(29, '2025-03-02', '2025-03-16', 29),
(30, '2025-03-17', '2025-03-31', 30),
(31, '2025-04-01', '2025-04-15', 31),
(32, '2025-04-16', '2025-04-30', 32),
(33, '2025-05-01', '2025-05-15', 33),
(34, '2025-05-16', '2025-05-31', 34),
(35, '2025-06-01', '2025-06-15', 35),
(36, '2025-06-16', '2025-06-30', 36),
(37, '2025-07-01', '2025-07-15', 37),
(38, '2025-07-16', '2025-07-31', 38),
(39, '2025-08-01', '2025-08-15', 39),
(40, '2025-08-16', '2025-08-31', 40),
(41, '2025-09-01', '2025-09-15', 41),
(42, '2025-09-16', '2025-09-30', 42),
(43, '2025-10-01', '2025-10-15', 43),
(44, '2025-10-16', '2025-10-31', 44),
(45, '2025-11-01', '2025-11-15', 45),
(46, '2025-11-16', '2025-11-30', 46),
(47, '2025-12-01', '2025-12-15', 47),
(48, '2025-12-16', '2025-12-31', 48),
(49, '2026-01-01', '2026-01-15', 49),
(50, '2026-01-16', '2026-01-31', 50);

-- Tabla Detalles de Produccion
INSERT INTO det_produccion (id_det_produccion, cantidad_esperada, cantidad_obtenida, fecha_inicio, fecha_termino, id_produccion, id_receta, id_bodega) VALUES
(1, 100, 95, '2024-01-01', '2024-01-07', 1, 200000000001, 100000000001),
(2, 120, 115, '2024-01-08', '2024-01-14', 2, 200000000002, 100000000002),
(3, 140, 135, '2024-01-15', '2024-01-21', 3, 200000000003, 100000000003),
(4, 160, 155, '2024-01-22', '2024-01-28', 4, 200000000004, 100000000004),
(5, 180, 175, '2024-01-29', '2024-02-04', 5, 200000000005, 100000000005),
(6, 200, 195, '2024-02-05', '2024-02-11', 6, 200000000006, 100000000006),
(7, 220, 210, '2024-02-12', '2024-02-18', 7, 200000000007, 100000000007),
(8, 240, 225, '2024-02-19', '2024-02-25', 8, 200000000008, 100000000008),
(9, 260, 240, '2024-02-26', '2024-03-03', 9, 200000000009, 100000000009),
(10, 280, 260, '2024-03-04', '2024-03-10', 10, 200000000010, 100000000010),
(11, 300, 290, '2024-03-11', '2024-03-17', 11, 200000000011, 100000000011),
(12, 320, 310, '2024-03-18', '2024-03-24', 12, 200000000012, 100000000012),
(13, 340, 330, '2024-03-25', '2024-03-31', 13, 200000000013, 100000000013),
(14, 360, 345, '2024-04-01', '2024-04-07', 14, 200000000014, 100000000014),
(15, 380, 365, '2024-04-08', '2024-04-14', 15, 200000000015, 100000000015),
(16, 400, 385, '2024-04-15', '2024-04-21', 16, 200000000016, 100000000016),
(17, 420, 405, '2024-04-22', '2024-04-28', 17, 200000000017, 100000000017),
(18, 440, 425, '2024-04-29', '2024-05-05', 18, 200000000018, 100000000018),
(19, 460, 445, '2024-05-06', '2024-05-12', 19, 200000000019, 100000000019),
(20, 480, 465, '2024-05-13', '2024-05-19', 20, 200000000020, 100000000020),
(21, 500, 485, '2024-05-20', '2024-05-26', 21, 200000000021, 100000000021),
(22, 520, 505, '2024-05-27', '2024-06-02', 22, 200000000022, 100000000022),
(23, 540, 525, '2024-06-03', '2024-06-09', 23, 200000000023, 100000000023),
(24, 560, 545, '2024-06-10', '2024-06-16', 24, 200000000024, 100000000024),
(25, 580, 565, '2024-06-17', '2024-06-23', 25, 200000000025, 100000000025),
(26, 600, 585, '2024-06-24', '2024-06-30', 26, 200000000026, 100000000026),
(27, 620, 605, '2024-07-01', '2024-07-07', 27, 200000000027, 100000000027),
(28, 640, 625, '2024-07-08', '2024-07-14', 28, 200000000028, 100000000028),
(29, 660, 645, '2024-07-15', '2024-07-21', 29, 200000000029, 100000000029),
(30, 680, 665, '2024-07-22', '2024-07-28', 30, 200000000030, 100000000030),
(31, 700, 685, '2024-07-29', '2024-08-04', 31, 200000000031, 100000000031),
(32, 720, 705, '2024-08-05', '2024-08-11', 32, 200000000032, 100000000032),
(33, 740, 725, '2024-08-12', '2024-08-18', 33, 200000000033, 100000000033),
(34, 760, 745, '2024-08-19', '2024-08-25', 34, 200000000034, 100000000034),
(35, 780, 765, '2024-08-26', '2024-09-01', 35, 200000000035, 100000000035),
(36, 800, 785, '2024-09-02', '2024-09-08', 36, 200000000036, 100000000036),
(37, 820, 805, '2024-09-09', '2024-09-15', 37, 200000000037, 100000000037),
(38, 840, 825, '2024-09-16', '2024-09-22', 38, 200000000038, 100000000038),
(39, 860, 845, '2024-09-23', '2024-09-29', 39, 200000000039, 100000000039),
(40, 880, 865, '2024-09-30', '2024-10-06', 40, 200000000040, 100000000040),
(41, 900, 885, '2024-10-07', '2024-10-13', 41, 200000000041, 100000000041),
(42, 920, 905, '2024-10-14', '2024-10-20', 42, 200000000042, 100000000042),
(43, 940, 925, '2024-10-21', '2024-10-27', 43, 200000000043, 100000000043),
(44, 960, 945, '2024-10-28', '2024-11-03', 44, 200000000044, 100000000044),
(45, 980, 965, '2024-11-04', '2024-11-10', 45, 200000000045, 100000000045),
(46, 1000, 985, '2024-11-11', '2024-11-17', 46, 200000000046, 100000000046),
(47, 1020, 1005, '2024-11-18', '2024-11-24', 47, 200000000047, 100000000047),
(48, 1040, 1025, '2024-11-25', '2024-12-01', 48, 200000000048, 100000000048),
(49, 1060, 1045, '2024-12-02', '2024-12-08', 49, 200000000049, 100000000049),
(50, 1080, 1065, '2024-12-09', '2024-12-15', 50, 200000000050, 100000000050);

-- Tabla Venta
INSERT INTO venta (numero_factura, fecha_venta, total, cliente_rut) VALUES
(100000000001, '2024-08-01', 50000, '7612345678'),
(100000000002, '2024-08-02', 75000, '7613456789'),
(100000000003, '2024-08-03', 60000, '7614567890'),
(100000000004, '2024-08-04', 55000, '7615678901'),
(100000000005, '2024-08-05', 80000, '7616789012'),
(100000000006, '2024-08-06', 70000, '7617890123'),
(100000000007, '2024-08-07', 62000, '7618901234'),
(100000000008, '2024-08-08', 68000, '7619012345'),
(100000000009, '2024-08-09', 56000, '7620123456'),
(100000000010, '2024-08-10', 53000, '7621234567'),
(100000000011, '2024-08-11', 74000, '7622345678'),
(100000000012, '2024-08-12', 62000, '7623456789'),
(100000000013, '2024-08-13', 69000, '7624567890'),
(100000000014, '2024-08-14', 67000, '7625678901'),
(100000000015, '2024-08-15', 75000, '7626789012'),
(100000000016, '2024-08-16', 60000, '7627890123'),
(100000000017, '2024-08-17', 74000, '7628901234'),
(100000000018, '2024-08-18', 67000, '7629012345'),
(100000000019, '2024-08-19', 71000, '7630123456'),
(100000000020, '2024-08-20', 75000, '7631234567'),
(100000000021, '2024-08-21', 63000, '7632345678'),
(100000000022, '2024-08-22', 72000, '7633456789'),
(100000000023, '2024-08-23', 56000, '7634567890'),
(100000000024, '2024-08-24', 69000, '7635678901'),
(100000000025, '2024-08-25', 71000, '7636789012'),
(100000000026, '2024-08-26', 68000, '7637890123'),
(100000000027, '2024-08-27', 73000, '7638901234'),
(100000000028, '2024-08-28', 64000, '7640123456'),
(100000000029, '2024-08-29', 69000, '7641234567'),
(100000000030, '2024-08-30', 70000, '7642345678'),
(100000000031, '2024-08-31', 65000, '7643456789'),
(100000000032, '2024-09-01', 74000, '7644567890'),
(100000000033, '2024-09-02', 67000, '7645678901'),
(100000000034, '2024-09-03', 69000, '7646789012'),
(100000000035, '2024-09-04', 73000, '7647890123'),
(100000000036, '2024-09-05', 75000, '7650123456'),
(100000000037, '2024-09-06', 71000, '7651234567'),
(100000000038, '2024-09-07', 72000, '7652345678'),
(100000000039, '2024-09-08', 64000, '7653456789'),
(100000000040, '2024-09-09', 68000, '7654567890'),
(100000000041, '2024-09-10', 66000, '7655678901'),
(100000000042, '2024-09-11', 69000, '7656789012'),
(100000000043, '2024-09-12', 74000, '7657890123'),
(100000000044, '2024-09-13', 71000, '7648901234'),
(100000000045, '2024-09-14', 72000, '7649012345'),
(100000000046, '2024-09-15', 68000, '7650123456'),
(100000000047, '2024-09-16', 65000, '7651234567'),
(100000000048, '2024-09-17', 70000, '7652345678'),
(100000000049, '2024-09-18', 67000, '7653456789'),
(100000000050, '2024-09-19', 75000, '7654567890');

-- Tabla Compra
INSERT INTO compra (numero_factura, fecha_venta, total, proveedor_rut) VALUES
(200000000001, '2024-08-01', 50000, '7612345678'),
(200000000002, '2024-08-02', 75000, '7613456789'),
(200000000003, '2024-08-03', 60000, '7614567890'),
(200000000004, '2024-08-04', 55000, '7615678901'),
(200000000005, '2024-08-05', 80000, '7616789012'),
(200000000006, '2024-08-06', 70000, '7617890123'),
(200000000007, '2024-08-07', 62000, '7618901234'),
(200000000008, '2024-08-08', 68000, '7619012345'),
(200000000009, '2024-08-09', 56000, '7620123456'),
(200000000010, '2024-08-10', 53000, '7621234567'),
(200000000011, '2024-08-11', 74000, '7622345678'),
(200000000012, '2024-08-12', 62000, '7623456789'),
(200000000013, '2024-08-13', 69000, '7624567890'),
(200000000014, '2024-08-14', 67000, '7625678901'),
(200000000015, '2024-08-15', 75000, '7626789012'),
(200000000016, '2024-08-16', 60000, '7627890123'),
(200000000017, '2024-08-17', 74000, '7628901234'),
(200000000018, '2024-08-18', 67000, '7629012345'),
(200000000019, '2024-08-19', 71000, '7630123456'),
(200000000020, '2024-08-20', 75000, '7631234567'),
(200000000021, '2024-08-21', 63000, '7632345678'),
(200000000022, '2024-08-22', 72000, '7633456789'),
(200000000023, '2024-08-23', 56000, '7634567890'),
(200000000024, '2024-08-24', 69000, '7635678901'),
(200000000025, '2024-08-25', 71000, '7636789012'),
(200000000026, '2024-08-26', 68000, '7637890123'),
(200000000027, '2024-08-27', 73000, '7638901234'),
(200000000028, '2024-08-28', 64000, '7640123456'),
(200000000029, '2024-08-29', 69000, '7641234567'),
(200000000030, '2024-08-30', 70000, '7642345678'),
(200000000031, '2024-08-31', 65000, '7643456789'),
(200000000032, '2024-09-01', 74000, '7644567890'),
(200000000033, '2024-09-02', 67000, '7645678901'),
(200000000034, '2024-09-03', 69000, '7646789012'),
(200000000035, '2024-09-04', 73000, '7647890123'),
(200000000036, '2024-09-05', 75000, '7650123456'),
(200000000037, '2024-09-06', 71000, '7651234567'),
(200000000038, '2024-09-07', 72000, '7652345678'),
(200000000039, '2024-09-08', 64000, '7653456789'),
(200000000040, '2024-09-09', 68000, '7654567890'),
(200000000041, '2024-09-10', 66000, '7655678901'),
(200000000042, '2024-09-11', 69000, '7656789012'),
(200000000043, '2024-09-12', 74000, '7657890123'),
(200000000044, '2024-09-13', 71000, '7648901234'),
(200000000045, '2024-09-14', 72000, '7649012345'),
(200000000046, '2024-09-15', 68000, '7650123456'),
(200000000047, '2024-09-16', 65000, '7651234567'),
(200000000048, '2024-09-17', 70000, '7652345678'),
(200000000049, '2024-09-18', 67000, '7653456789'),
(200000000050, '2024-09-19', 75000, '7654567890');

-- Tabla Detalle Compra
INSERT INTO det_compra (id_det_compra, cantidad, descripcion, unitario, id_inventario, numero_factura) VALUES
(100000000001, 10, 'Tripas Naturales', 2000, 300000000001, 200000000001),
(100000000002, 5, 'Sal Refinada', 1500, 300000000002, 200000000002),
(100000000003, 3, 'Pimienta Negra Molida', 1800, 300000000003, 200000000003),
(100000000004, 7, 'Ajo en Polvo', 1200, 300000000004, 200000000004),
(100000000005, 12, 'Pimentón Dulce', 2500, 300000000005, 200000000005),
(100000000006, 8, 'Grasa de Cerdo', 3500, 300000000006, 200000000006),
(100000000007, 6, 'Carne de Res', 5000, 300000000007, 200000000007),
(100000000008, 10, 'Carne de Cerdo', 4500, 300000000008, 200000000008),
(100000000009, 4, 'Carne de Pavo', 4000, 300000000009, 200000000009),
(100000000010, 5, 'Pimienta Roja', 2200, 300000000010, 200000000010),
(100000000011, 7, 'Emulsionante Cárnico', 1600, 300000000011, 200000000011),
(100000000012, 15, 'Conservador de Alimentos', 1200, 300000000012, 200000000012),
(100000000013, 8, 'Antioxidantes Naturales', 1800, 300000000013, 200000000013),
(100000000014, 2, 'Nitrato de Sodio', 2200, 300000000014, 200000000014),
(100000000015, 6, 'Leche en Polvo', 2400, 300000000015, 200000000015),
(100000000016, 10, 'Perejil Deshidratado', 1500, 300000000016, 200000000016),
(100000000017, 20, 'Hielo Triturado', 500, 300000000017, 200000000017),
(100000000018, 10, 'Salchichón en Curado', 3000, 300000000018, 200000000018),
(100000000019, 12, 'Chorizo en Curado', 2800, 300000000019, 200000000019),
(100000000020, 5, 'Tripas Sintéticas', 2600, 300000000020, 200000000020),
(100000000021, 6, 'Salchichas Frescas', 3500, 300000000021, 200000000021),
(100000000022, 15, 'Tocino Ahumado', 4200, 300000000022, 200000000022),
(100000000023, 10, 'Paprika', 1900, 300000000023, 200000000023),
(100000000024, 8, 'Jalapeños', 2500, 300000000024, 200000000024),
(100000000025, 5, 'Cilantro Molido', 1400, 300000000025, 200000000025),
(100000000026, 15, 'Salchichas Cocidas', 2600, 300000000026, 200000000026),
(100000000027, 18, 'Longanizas Frescas', 4000, 300000000027, 200000000027),
(100000000028, 10, 'Morcilla Tradicional', 3000, 300000000028, 200000000028),
(100000000029, 6, 'Pimientos Picantes', 2000, 300000000029, 200000000029),
(100000000030, 8, 'Carne de Pollo', 4600, 300000000030, 200000000030),
(100000000031, 5, 'Cebolla en Polvo', 1800, 300000000031, 200000000031),
(100000000032, 10, 'Aditivo Colorante Natural', 1700, 300000000032, 200000000032),
(100000000033, 25, 'Agua Potable', 200, 300000000033, 200000000033),
(100000000034, 15, 'Jamón Serrano', 4800, 300000000034, 200000000034),
(100000000035, 12, 'Carne Curada', 3500, 300000000035, 200000000035),
(100000000036, 10, 'Almidón de Maíz', 2200, 300000000036, 200000000036),
(100000000037, 7, 'Manteca de Cerdo', 2600, 300000000037, 200000000037),
(100000000038, 8, 'Tripas de Colágeno', 2300, 300000000038, 200000000038),
(100000000039, 12, 'Salchichas en Conserva', 2500, 300000000039, 200000000039),
(100000000040, 9, 'Longaniza Ahumada', 3000, 300000000040, 200000000040),
(100000000041, 10, 'Tripas para Longaniza', 3500, 300000000041, 200000000041),
(100000000042, 14, 'Jamón Cocido', 3800, 300000000042, 200000000042),
(100000000043, 12, 'Cecina de Res', 4200, 300000000043, 200000000043),
(100000000044, 8, 'Salchichas Ahumadas', 2600, 300000000044, 200000000044),
(100000000045, 7, 'Cecina Curada', 3000, 300000000045, 200000000045),
(100000000046, 5, 'Conservante para Cecina', 2200, 300000000046, 200000000046),
(100000000047, 4, 'Acondicionador de Masa', 1800, 300000000047, 200000000047),
(100000000048, 6, 'Ajo Fresco', 1400, 300000000048, 200000000048),
(100000000049, 5, 'Hierbas Finas', 1200, 300000000049, 200000000049),
(100000000050, 10, 'Orégano Molido', 1700, 300000000050, 200000000050);

-- Tabla Cecina
INSERT INTO cecina (id_cecina, nombre, stock, precio, id_tipo_cecina) VALUES
(600000000001, 'Salchichón Ahumado Premium', 150, 5000, 500000000001),
(600000000002, 'Chorizo Picante Español', 120, 4500, 500000000002),
(600000000003, 'Longaniza Tradicional Artesanal', 100, 4000, 500000000003),
(600000000004, 'Jamón Serrano Curado', 80, 7000, 500000000004),
(600000000005, 'Cecina de Res Orgánica', 200, 9000, 500000000005),
(600000000006, 'Chistorra Fresca', 180, 3000, 500000000006),
(600000000007, 'Morcilla de Cebolla', 140, 2500, 500000000007),
(600000000008, 'Salami Italiano Clásico', 130, 3500, 500000000008),
(600000000009, 'Chorizo Blanco Español', 160, 4000, 500000000009),
(600000000010, 'Salchicha Vienesa', 170, 3200, 500000000010),
(600000000011, 'Cecina de Cerdo Ahumada', 110, 8500, 500000000011),
(600000000012, 'Salchicha Alemana Tradicional', 90, 4500, 500000000012),
(600000000013, 'Fuet Catalán Artesanal', 200, 3000, 500000000013),
(600000000014, 'Jamón Cocido al Horno', 210, 6000, 500000000014),
(600000000015, 'Mortadela Italiana con Aceitunas', 180, 2500, 500000000015),
(600000000016, 'Salchichón de Pavo', 190, 3800, 500000000016),
(600000000017, 'Salchichón de Pollo con Especias', 160, 3400, 500000000017),
(600000000018, 'Tocino Ahumado Tradicional', 220, 4200, 500000000018),
(600000000019, 'Jamón Ahumado Artesanal', 140, 5800, 500000000019),
(600000000020, 'Lomo Embuchado Ibérico', 200, 7500, 500000000020),
(600000000021, 'Cecina de Caballo', 110, 9000, 500000000021),
(600000000022, 'Cecina de Pato', 120, 10000, 500000000022),
(600000000023, 'Chorizo Criollo', 160, 3000, 500000000023),
(600000000024, 'Pastrami Ahumado', 140, 6500, 500000000024),
(600000000025, 'Jamón de Pavo Light', 180, 5000, 500000000025),
(600000000026, 'Salchicha de Pollo Picante', 170, 3600, 500000000026),
(600000000027, 'Longaniza Ahumada', 200, 4000, 500000000027),
(600000000028, 'Chorizo Cantimpalo', 150, 4700, 500000000028),
(600000000029, 'Jamón York Cocido', 210, 5400, 500000000029),
(600000000030, 'Chorizo Parrillero Argentino', 190, 3900, 500000000030),
(600000000031, 'Butifarra Tradicional', 180, 4200, 500000000031),
(600000000032, 'Lomo Canadiense Ahumado', 120, 7500, 500000000032),
(600000000033, 'Morcón Ibérico de Bellota', 130, 8800, 500000000033),
(600000000034, 'Cecina de Jabalí Salvaje', 80, 9500, 500000000034),
(600000000035, 'Chorizo de Ciervo Ahumado', 90, 8500, 500000000035),
(600000000036, 'Salchichón Ibérico', 160, 4300, 500000000036),
(600000000037, 'Lomo Ahumado Tradicional', 100, 7800, 500000000037),
(600000000038, 'Jamón de Pavo Ahumado', 170, 5000, 500000000038),
(600000000039, 'Chorizo Ahumado con Pimentón', 150, 4000, 500000000039),
(600000000040, 'Mortadela Ahumada con Pimienta', 180, 2500, 500000000040),
(600000000041, 'Salchicha de Ternera con Ajo', 190, 3500, 500000000041),
(600000000042, 'Cecina de Venao', 110, 10000, 500000000042),
(600000000043, 'Salchichón Ahumado con Ajo', 130, 4500, 500000000043),
(600000000044, 'Cecina de Cordero Ahumada', 140, 9200, 500000000044),
(600000000045, 'Chorizo a la Sidra', 170, 3700, 500000000045),
(600000000046, 'Cecina Vegana Orgánica', 200, 5200, 500000000046),
(600000000047, 'Jamón Curado Ibérico', 110, 7800, 500000000047),
(600000000048, 'Cecina Artesanal de Res', 160, 8500, 500000000048),
(600000000049, 'Chorizo de Pollo Picante con Ajo', 170, 3000, 500000000049),
(600000000050, 'Salchichón Extra con Especias', 200, 4100, 500000000050);

-- Tabla Detalle Venta
INSERT INTO det_venta (id_det_venta, cantidad, descripcion, unitario, id_cecina, venta_numero_factura) VALUES
(700000000001, 5, 'Salchichón Ahumado Premium', 5000, 600000000001, 100000000001),
(700000000002, 3, 'Chorizo Picante Español', 4500, 600000000002, 100000000002),
(700000000003, 4, 'Longaniza Tradicional Artesanal', 4000, 600000000003, 100000000003),
(700000000004, 2, 'Jamón Serrano Curado', 7000, 600000000004, 100000000004),
(700000000005, 6, 'Cecina de Res Orgánica', 9000, 600000000005, 100000000005),
(700000000006, 7, 'Chistorra Fresca', 3000, 600000000006, 100000000006),
(700000000007, 5, 'Morcilla de Cebolla', 2500, 600000000007, 100000000007),
(700000000008, 4, 'Salami Italiano Clásico', 3500, 600000000008, 100000000008),
(700000000009, 8, 'Chorizo Blanco Español', 4000, 600000000009, 100000000009),
(700000000010, 6, 'Salchicha Vienesa', 3200, 600000000010, 100000000010),
(700000000011, 2, 'Cecina de Cerdo Ahumada', 8500, 600000000011, 100000000011),
(700000000012, 5, 'Salchicha Alemana Tradicional', 4500, 600000000012, 100000000012),
(700000000013, 3, 'Fuet Catalán Artesanal', 3000, 600000000013, 100000000013),
(700000000014, 7, 'Jamón Cocido al Horno', 6000, 600000000014, 100000000014),
(700000000015, 8, 'Mortadela Italiana con Aceitunas', 2500, 600000000015, 100000000015),
(700000000016, 4, 'Salchichón de Pavo', 3800, 600000000016, 100000000016),
(700000000017, 3, 'Salchichón de Pollo con Especias', 3400, 600000000017, 100000000017),
(700000000018, 5, 'Tocino Ahumado Tradicional', 4200, 600000000018, 100000000018),
(700000000019, 6, 'Jamón Ahumado Artesanal', 5800, 600000000019, 100000000019),
(700000000020, 2, 'Lomo Embuchado Ibérico', 7500, 600000000020, 100000000020),
(700000000021, 4, 'Cecina de Caballo', 9000, 600000000021, 100000000021),
(700000000022, 1, 'Cecina de Pato', 10000, 600000000022, 100000000022),
(700000000023, 5, 'Chorizo Criollo', 3000, 600000000023, 100000000023),
(700000000024, 3, 'Pastrami Ahumado', 6500, 600000000024, 100000000024),
(700000000025, 6, 'Jamón de Pavo Light', 5000, 600000000025, 100000000025),
(700000000026, 2, 'Salchicha de Pollo Picante', 3600, 600000000026, 100000000026),
(700000000027, 5, 'Longaniza Ahumada', 4000, 600000000027, 100000000027),
(700000000028, 4, 'Chorizo Cantimpalo', 4700, 600000000028, 100000000028),
(700000000029, 7, 'Jamón York Cocido', 5400, 600000000029, 100000000029),
(700000000030, 6, 'Chorizo Parrillero Argentino', 3900, 600000000030, 100000000030),
(700000000031, 8, 'Butifarra Tradicional', 4200, 600000000031, 100000000031),
(700000000032, 2, 'Lomo Canadiense Ahumado', 7500, 600000000032, 100000000032),
(700000000033, 3, 'Morcón Ibérico de Bellota', 8800, 600000000033, 100000000033),
(700000000034, 5, 'Cecina de Jabalí Salvaje', 9500, 600000000034, 100000000034),
(700000000035, 4, 'Chorizo de Ciervo Ahumado', 8500, 600000000035, 100000000035),
(700000000036, 3, 'Salchichón Ibérico', 4300, 600000000036, 100000000036),
(700000000037, 6, 'Lomo Ahumado Tradicional', 7800, 600000000037, 100000000037),
(700000000038, 4, 'Jamón de Pavo Ahumado', 5000, 600000000038, 100000000038),
(700000000039, 5, 'Chorizo Ahumado con Pimentón', 4000, 600000000039, 100000000039),
(700000000040, 8, 'Mortadela Ahumada con Pimienta', 2500, 600000000040, 100000000040),
(700000000041, 6, 'Salchicha de Ternera con Ajo', 3500, 600000000041, 100000000041),
(700000000042, 3, 'Cecina de Venao', 10000, 600000000042, 100000000042),
(700000000043, 5, 'Salchichón Ahumado con Ajo', 4500, 600000000043, 100000000043),
(700000000044, 4, 'Cecina de Cordero Ahumada', 9200, 600000000044, 100000000044),
(700000000045, 3, 'Chorizo a la Sidra', 3700, 600000000045, 100000000045),
(700000000046, 7, 'Cecina Vegana Orgánica', 5200, 600000000046, 100000000046),
(700000000047, 6, 'Jamón Curado Ibérico', 7800, 600000000047, 100000000047),
(700000000048, 8, 'Cecina Artesanal de Res', 8500, 600000000048, 100000000048),
(700000000049, 4, 'Chorizo de Pollo Picante con Ajo', 3000, 600000000049, 100000000049),
(700000000050, 5, 'Salchichón Extra con Especias', 4100, 600000000050, 100000000050);

-- Tabla Detalle Receta
INSERT INTO det_receta (receta_id, cantidad, inventario_id, cecina_id) VALUES
(200000000001, 100, 300000000001, 600000000001),
(200000000002, 150, 300000000002, 600000000002),
(200000000003, 200, 300000000003, 600000000003),
(200000000004, 250, 300000000004, 600000000004),
(200000000005, 300, 300000000005, 600000000005),
(200000000006, 100, 300000000006, 600000000006),
(200000000007, 150, 300000000007, 600000000007),
(200000000008, 200, 300000000008, 600000000008),
(200000000009, 250, 300000000009, 600000000009),
(200000000010, 300, 300000000010, 600000000010),
(200000000011, 100, 300000000011, 600000000011),
(200000000012, 150, 300000000012, 600000000012),
(200000000013, 200, 300000000013, 600000000013),
(200000000014, 250, 300000000014, 600000000014),
(200000000015, 300, 300000000015, 600000000015),
(200000000016, 100, 300000000016, 600000000016),
(200000000017, 150, 300000000017, 600000000017),
(200000000018, 200, 300000000018, 600000000018),
(200000000019, 250, 300000000019, 600000000019),
(200000000020, 300, 300000000020, 600000000020),
(200000000021, 100, 300000000021, 600000000021),
(200000000022, 150, 300000000022, 600000000022),
(200000000023, 200, 300000000023, 600000000023),
(200000000024, 250, 300000000024, 600000000024),
(200000000025, 300, 300000000025, 600000000025),
(200000000026, 100, 300000000026, 600000000026),
(200000000027, 150, 300000000027, 600000000027),
(200000000028, 200, 300000000028, 600000000028),
(200000000029, 250, 300000000029, 600000000029),
(200000000030, 300, 300000000030, 600000000030),
(200000000031, 100, 300000000031, 600000000031),
(200000000032, 150, 300000000032, 600000000032),
(200000000033, 200, 300000000033, 600000000033),
(200000000034, 250, 300000000034, 600000000034),
(200000000035, 300, 300000000035, 600000000035),
(200000000036, 100, 300000000036, 600000000036),
(200000000037, 150, 300000000037, 600000000037),
(200000000038, 200, 300000000038, 600000000038),
(200000000039, 250, 300000000039, 600000000039),
(200000000040, 300, 300000000040, 600000000040),
(200000000041, 100, 300000000041, 600000000041),
(200000000042, 150, 300000000042, 600000000042),
(200000000043, 200, 300000000043, 600000000043),
(200000000044, 250, 300000000044, 600000000044),
(200000000045, 300, 300000000045, 600000000045),
(200000000046, 100, 300000000046, 600000000046),
(200000000047, 150, 300000000047, 600000000047),
(200000000048, 200, 300000000048, 600000000048),
(200000000049, 250, 300000000049, 600000000049),
(200000000050, 300, 300000000050, 600000000050);

/*********************************************************
SCRIPT DE CONSULTAS A LA BASE DE DATOS
*********************************************************/
/**********************************************************************************
* EJERCICIO N1
Construir las consultas para insertar, modificar y eliminar un Proveedor, compra
y Detalle Compra (DetCompra).
Las consultas para insertar ya estan construidas, vamos generar las de
modificar y eliminar del proveedor.
**********************************************************************************/
-- FORMA 1 => Eliminar proveedor en especifico
-- La tabla proveedor esta relacionada con la tabla compra, primero habria que modificar
-- la data y despues borrar el proveedor, porque si no entrega error.
-- Actualizacion en compra
UPDATE compra 
SET proveedor_rut = NULL 
WHERE proveedor_rut = '7617890123';
-- Con el dato actualizado ahora se puede eliminar de la tabla proveedores
DELETE FROM proveedor 
WHERE rut = '7617890123';
-- Para comprobar
SELECT * FROM proveedor p 
WHERE rut = '7617890123';

SELECT * 
FROM compra c 
WHERE proveedor_rut = '7617890123';
-- Eran 50 registros, pero con esta consulta devuelve 49 registros.
SELECT count(*) FROM proveedor p ;

--FORMA 2 => Eliminar varios proveedores.
UPDATE compra
SET proveedor_rut = NULL
WHERE proveedor_rut IN ('7633456789', '7635678901', '7645678901');

DELETE FROM proveedor
WHERE rut IN ('7633456789', '7635678901', '7645678901');
-- Comprobando la eliminacion de los datos
SELECT *
FROM proveedor
WHERE rut IN ('7633456789', '7635678901', '7645678901');

SELECT *
FROM compra
WHERE proveedor_rut IS NULL;
-- De los 50 registros, ahora solo quedan 46.
SELECT count(*) FROM proveedor p ;

-- FORMA 3 => Eliminar proveedor en base a codicion, por ejemplo que inicien con una letra
-- al estar enlazada con otra tabla, debemos dejar los registros en null, usaremos subconsulta.
UPDATE compra
SET proveedor_rut = NULL
WHERE proveedor_rut IN (
    SELECT rut
    FROM proveedor
    WHERE nombre LIKE 'A%'
);
-- Se eliminar a los proveedores que comienzan con A
DELETE FROM proveedor
WHERE nombre LIKE 'A%';
-- Se verifica la informacion de la eliminacion en compra.
SELECT *
FROM compra
WHERE proveedor_rut IS NULL;
-- Se verifica la eliminacion en proveedor
SELECT *
FROM proveedor
WHERE nombre LIKE 'A%';
-- De los 50 registros, ahora solo quedan 41.
SELECT count(*) FROM proveedor p ;

/************************************************************************
 * Modificando det_compra
************************************************************************/
-- Al no haber una dependencia de esta tabla con otras, no hay problemas de integridad 
-- Consultar por un id_det_compra.
SELECT *
FROM det_compra dc 
WHERE id_det_compra = 100000000001;
-- Descripcion "Tripas Naturales" y le agregaremos premium y aumentaremos de 10 a 25 la cantidad
UPDATE det_compra 
SET cantidad = 25,
		descripcion = 'Tripas Naturales Premium'
WHERE id_det_compra = 100000000001;

-- Actualizacion masiva de cantidades por ID.
UPDATE det_compra 
SET cantidad = 15
WHERE id_det_compra IN (100000000002, 100000000003, 100000000004);

-- Actualizacion a cantidad de 35 de productos con descripcion que incluya la palabra "Cerdo"
UPDATE det_compra 
SET cantidad = 35
WHERE descripcion LIKE '%Cerdo%';

/************************************************************************
 * Eliminando det_compra
************************************************************************/
-- Al no haber una dependencia de esta tabla con otras, no hay problemas de integridad 
-- y no se creo la FK con la restriccion de delete on cascade, por lo tanto la eliminacion es sencilla
-- Forma 1 eliminando en base al id de detalle compra
-- Revisamos la data antes de eliminar
SELECT *
FROM det_compra dc;

DELETE FROM det_compra
WHERE id_det_compra = 100000000001;

-- Comprobando eliminacion
SELECT *
FROM det_compra dc 
WHERE id_det_compra = 100000000001;

-- Eliminando en base a otra condicion como numero de factura
-- Revisamos la data antes de eliminar
SELECT *
FROM det_compra dc;

DELETE FROM det_compra
WHERE numero_factura = 200000000039;

-- Comprobando eliminacion
SELECT *
FROM det_compra dc 
WHERE numero_factura = 200000000039;

-- Eliminacion masiva de det_compra
-- Revisamos la data antes de eliminar
SELECT *
FROM det_compra dc;

DELETE FROM det_compra 
WHERE id_det_compra IN (100000000013, 100000000020, 100000000043);

SELECT * FROM det_compra
WHERE id_det_compra IN (100000000013, 100000000020, 100000000043);

-- Eliminacion masiva en base a condicion
-- Revisamos la data antes de eliminar
SELECT *
FROM det_compra dc;
-- Hasta aqui hay 3 filas con datos de tripas

DELETE FROM det_compra 
WHERE descripcion LIKE 'Tripa%';
-- Comprobacion de eliminacion
SELECT *
FROM det_compra dc 
WHERE descripcion LIKE 'Tripa%';


/****************************************************************************
 * EJERCICIO N2
 * Listar todas las ventas con los datos del cliente dado un año y mes.
****************************************************************************/
-- Forma 1
SELECT
    v.numero_factura,
    v.fecha_venta,
    v.total,
    c.rut AS cliente_rut,
    c.nombre AS cliente_nombre,
    c.giro AS cliente_giro,
    c.direccion AS cliente_direccion,
    c.ciudad AS cliente_ciudad,
    c.fono AS cliente_fono
FROM venta v
JOIN cliente c ON v.cliente_rut = c.rut
WHERE v.fecha_venta BETWEEN '2024-08-01' AND '2024-08-31';
    
-- Forma 2
SELECT
    v.numero_factura,
    v.fecha_venta,
    v.total,
    c.rut AS cliente_rut,
    c.nombre AS cliente_nombre,
    c.giro AS cliente_giro,
    c.direccion AS cliente_direccion,
    c.ciudad AS cliente_ciudad,
    c.fono AS cliente_fono
FROM venta v
JOIN cliente c ON v.cliente_rut = c.rut
WHERE EXTRACT(YEAR FROM v.fecha_venta) = 2024
      AND EXTRACT(MONTH FROM v.fecha_venta) = 08;

/****************************************************************************
 * EJERCICIO N3
 * Listar Número de factura, Fecha y Total de todas las compras y ventas.
****************************************************************************/
-- Estructura de la tabla compra
SELECT * FROM compra c ;
-- Estructura de la tabla venta
SELECT * FROM venta v ;

-- Ambas tablas tienen estructura semejante, por lo que se pueden listar juntandolas
-- y se ordena por fecha
SELECT numero_factura, fecha_venta, total
FROM compra
UNION
SELECT numero_factura, fecha_venta, total
FROM venta
ORDER BY fecha_venta ;
     
/****************************************************************************
 * EJERCICIO N4
 * Listar todas las producciones el año 2020 que contengan las 5 cecinas más
vendidas.
****************************************************************************/
-- Primero averiguamos cuales son las cecinas mas vendidas.
SELECT c.id_cecina, c.nombre, SUM(dv.cantidad) AS total_vendida
FROM det_venta dv
JOIN cecina c ON dv.id_cecina = c.id_cecina
GROUP BY c.id_cecina, c.nombre
ORDER BY total_vendida DESC;

-- Se incorpora la fecha en la consulta
SELECT c.id_cecina, c.nombre, v.fecha_venta, SUM(dv.cantidad) AS total_vendida
FROM det_venta dv
JOIN cecina c ON dv.id_cecina = c.id_cecina
JOIN venta v ON dv.venta_numero_factura = v.numero_factura
WHERE v.fecha_venta >= '2024-01-01' AND v.fecha_venta < '2025-01-01'
GROUP BY c.id_cecina, c.nombre, v.fecha_venta
ORDER BY total_vendida DESC;

-- Trae las cecinas, la fecha, pero no discrimina la cantidad
SELECT c.id_cecina, c.nombre, v.fecha_venta, SUM(dv.cantidad) AS cantidad_vendida
FROM det_venta dv
JOIN cecina c ON dv.id_cecina = c.id_cecina
JOIN venta v ON dv.venta_numero_factura = v.numero_factura
WHERE v.fecha_venta >= '2024-01-01' AND v.fecha_venta < '2025-01-01'
GROUP BY c.id_cecina, c.nombre, v.fecha_venta
ORDER BY c.nombre, cantidad_vendida DESC;

-- Trae las mas vendidas pero sin fecha
SELECT c.id_cecina, c.nombre, SUM(dv.cantidad) AS total_vendida
FROM det_venta dv
JOIN cecina c ON dv.id_cecina = c.id_cecina
JOIN venta v ON dv.venta_numero_factura = v.numero_factura
WHERE v.fecha_venta BETWEEN '2024-01-01' AND '2024-12-31'
GROUP BY c.id_cecina, c.nombre
ORDER BY total_vendida DESC
LIMIT 5;

-- Obtén las 5 cecinas más vendidas en 2024
SELECT c.id_cecina, c.nombre, SUM(dv.cantidad) AS total_vendida
FROM det_venta dv
JOIN cecina c ON dv.id_cecina = c.id_cecina
JOIN venta v ON dv.venta_numero_factura = v.numero_factura
WHERE v.fecha_venta >= '2024-01-01' AND v.fecha_venta < '2025-01-01'
GROUP BY c.id_cecina, c.nombre
ORDER BY total_vendida DESC
LIMIT 5;


-- Respuesta Final
SELECT c.id_cecina, c.nombre, v.fecha_venta, SUM(dv.cantidad) AS total_vendida
FROM det_venta dv
JOIN cecina c ON dv.id_cecina = c.id_cecina
JOIN venta v ON dv.venta_numero_factura = v.numero_factura
WHERE v.fecha_venta BETWEEN '2024-01-01' AND '2025-01-01'
GROUP BY c.id_cecina, c.nombre, v.fecha_venta 
ORDER BY total_vendida DESC
LIMIT 5;

-- Respuesta Elegante (Investigando descubri la funcion MIN en fechas trae la primera que tenga registro)
SELECT c.id_cecina, c.nombre, MIN(v.fecha_venta) AS primera_fecha_venta, SUM(dv.cantidad) AS total_vendida
FROM det_venta dv
JOIN cecina c ON dv.id_cecina = c.id_cecina
JOIN venta v ON dv.venta_numero_factura = v.numero_factura
WHERE v.fecha_venta BETWEEN '2024-01-01' AND '2025-01-01'
GROUP BY c.id_cecina, c.nombre
ORDER BY total_vendida DESC
LIMIT 5;


