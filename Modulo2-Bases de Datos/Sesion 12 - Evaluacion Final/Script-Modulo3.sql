
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

SELECT c.id_cecina, c.nombre, v.fecha_venta, SUM(dv.cantidad) AS total_vendida
FROM det_venta dv
JOIN cecina c ON dv.id_cecina = c.id_cecina
JOIN venta v ON dv.venta_numero_factura = v.numero_factura
WHERE v.fecha_venta >= '2024-01-01' AND v.fecha_venta < '2025-01-01'
GROUP BY c.id_cecina, c.nombre, v.fecha_venta
ORDER BY total_vendida DESC;

-- Obtén las 5 cecinas más vendidas en 2024
SELECT c.id_cecina, c.nombre, SUM(dv.cantidad) AS total_vendida
FROM det_venta dv
JOIN cecina c ON dv.id_cecina = c.id_cecina
JOIN venta v ON dv.venta_numero_factura = v.numero_factura
WHERE v.fecha_venta >= '2024-01-01' AND v.fecha_venta < '2025-01-01'
GROUP BY c.id_cecina, c.nombre
ORDER BY total_vendida DESC
LIMIT 5;

SELECT c.id_cecina, c.nombre, SUM(dv.cantidad) AS total_vendida
FROM det_venta dv
JOIN cecina c ON dv.id_cecina = c.id_cecina
JOIN venta v ON dv.venta_numero_factura = v.numero_factura
WHERE v.fecha_venta BETWEEN '2024-01-01' AND '2025-01-01'
GROUP BY c.id_cecina, c.nombre
ORDER BY total_vendida DESC
LIMIT 5;

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

-- Respuesta oficial
SELECT c.id_cecina, c.nombre, MIN(v.fecha_venta) AS primera_fecha_venta, SUM(dv.cantidad) AS total_vendida
FROM det_venta dv
JOIN cecina c ON dv.id_cecina = c.id_cecina
JOIN venta v ON dv.venta_numero_factura = v.numero_factura
WHERE v.fecha_venta BETWEEN '2024-01-01' AND '2025-01-01'
GROUP BY c.id_cecina, c.nombre
ORDER BY total_vendida DESC
LIMIT 5;


SELECT c.id_cecina, c.nombre, v.fecha_venta, SUM(dv.cantidad) AS total_vendida
FROM det_venta dv
JOIN cecina c ON dv.id_cecina = c.id_cecina
JOIN venta v ON dv.venta_numero_factura = v.numero_factura
WHERE v.fecha_venta BETWEEN '2024-01-01' AND '2025-01-01'
GROUP BY c.id_cecina, c.nombre, v.fecha_venta 
ORDER BY total_vendida DESC
LIMIT 5;

-- Forma mas optimizada que solo muestra el Anio

SELECT c.id_cecina, c.nombre, TO_CHAR(MIN(v.fecha_venta), 'YYYY') AS año_venta, SUM(dv.cantidad) AS total_vendida
FROM det_venta dv
JOIN cecina c ON dv.id_cecina = c.id_cecina
JOIN venta v ON dv.venta_numero_factura = v.numero_factura
WHERE v.fecha_venta BETWEEN '2024-01-01' AND '2025-01-01'
GROUP BY c.id_cecina, c.nombre
ORDER BY total_vendida DESC
LIMIT 5;



SELECT p.id_produccion, p.fecha_inicio, p.fecha_termino, c.nombre AS nombre_cecina, SUM(dv.cantidad) AS cantidad_vendida
FROM produccion p
JOIN det_produccion dp ON p.id_produccion = dp.id_produccion
JOIN det_receta dr ON dp.id_receta = dr.receta_id
JOIN cecina c ON dr.cecina_id = c.id_cecina
JOIN (
    SELECT id_cecina
    FROM det_venta
    GROUP BY id_cecina
    ORDER BY SUM(cantidad) DESC
    LIMIT 5
) top_cecinas ON c.id_cecina = top_cecinas.id_cecina
JOIN det_venta dv ON c.id_cecina = dv.id_cecina
WHERE EXTRACT(YEAR FROM p.fecha_inicio) = 2024
GROUP BY p.id_produccion, p.fecha_inicio, p.fecha_termino, c.nombre;


-- Mostrar las 5 cecinas más vendidas en 2024 con la fecha de venta
SELECT c.nombre, v.fecha_venta, SUM(dv.cantidad) AS cantidad_vendida
FROM det_venta dv
JOIN cecina c ON dv.id_cecina = c.id_cecina
JOIN venta v ON dv.venta_numero_factura = v.numero_factura
WHERE v.fecha_venta BETWEEN '2024-01-01' AND '2024-12-31'
GROUP BY c.nombre, v.fecha_venta
HAVING c.nombre IN (
    SELECT c.nombre
    FROM det_venta dv
    JOIN cecina c ON dv.id_cecina = c.id_cecina
    JOIN venta v ON dv.venta_numero_factura = v.numero_factura
    WHERE v.fecha_venta BETWEEN '2024-01-01' AND '2024-12-31'
    GROUP BY c.nombre
    ORDER BY SUM(dv.cantidad) DESC
    LIMIT 5
)
ORDER BY c.nombre, v.fecha_venta;




 
 /***********************************
  * prompt de carga
  * te voy a entregar el siguiente script de base de datos.
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
Quiero que me digas la cantidad de tablas que tiene el script
Quiero que me ayudes a ingresarle data a cada una de las tablas.
Quiero que la data sea integra, es decir que se refleje la data de una tabla en la otra, por ejemplo que el numero de factura sea el mismo en las tablas de ventas, compra y det_compra.
Quiero datos reales tanto en las primary key, como nombres de proveedores o en maquinaria.
Por ejemplo en maquinaria que aparezca un nombre real Molino de Carne Modelo X1.

Datos de empresas que sean reales por ejemplo.
('7612345678', 'Cecinas del Valle S.A.')

Quiero que generes 50 registros por cada tabla.
Me daras la data tabla una a la vez y para darme la siguiente esperaras que yo te diga ok o te avise de otra forma.

Quiero que en el encabezado me indiques en comentarios el numero de la tabla y la cantidad de registros que tendra.
  * 
  * 
  */
 

/*******************************************
 * 
 * Carga de Script 2
 ***********************************************/
-- Tabla 1 Maquinaria (50 registros)
INSERT INTO maquinaria (nombre) VALUES 
('Molino de Carne Modelo X1'),
('Cutter de Carne Elite 3000'),
('Picadora de Carne PowerCut 500'),
('Prensa de Embutidos MaxPress'),
('Afiladora de Cuchillos SharpPro'),
('Batidora de Carne MixMaster 200'),
('Sierra de Banda HeavyCut 400'),
('Horno de Cocción RapidCook'),
('Deshidratador de Carne DryMaster 100'),
('Trituradora de Huesos BoneCrush 150'),
('Cámara de Frío ColdStore 600'),
('Extrusora de Cecinas EliteExtrude'),
('Hidrolavadora WashPro 300'),
('Máquina de Envasado PackMaster 500'),
('Fumadora SmokeMaster 250'),
('Compactadora de Carnes MeatPress 350'),
('Amasadora MixerPro 400'),
('Balanza Digital ScaleMaster 1000'),
('Desinfectadora CleanPro 200'),
('Enfriadora de Rápido CoolingUnit 500'),
('Trituradora de Granos GrainCrush 800'),
('Mezcladora de Ingredientes MixBlend 600'),
('Cernidora FineSieve 150'),
('Cocedor de Cecinas CookMaster 350'),
('Lavadora de Envases WashIt 300'),
('Laminadora RollMaster 500'),
('Envasadora al Vacío VacuSeal 200'),
('Tritura Huesos BoneBreak 300'),
('Hidrolavadora CleanJet 400'),
('Mezclador de Polvos PowMix 150'),
('Sello de Calidad QualitySeal 600'),
('Secadora de Cecinas DryPro 200'),
('Piedra de Afilar SharpStone 100'),
('Calentador de Salchichas HeatPack 300'),
('Molino de Granos GrainMill 250'),
('Barra de Metal Polisher MetalPolish 200'),
('Tostadora de Granos ToastMaster 500'),
('Cortadora de Carne SliceMaster 800'),
('Prensa de Salchichas SausagePress 350'),
('Generador de Niebla FogGen 300'),
('Pulverizador de Condimentos SpiceSpray 200'),
('Esterilizador SteriPro 400'),
('Frigorífico CoolKeeper 500'),
('Horno para Cecinas CecinaCook 600'),
('Soplador de Aire AirBlower 150'),
('Refrigerador de Carne MeatCool 700'),
('Batidora Industrial MixMaster 400'),
('Cámara de Maduración AgingRoom 800'),
('Extrusora Industrial BigExtrude 1000'),
('Deshidratador de Frutas FruitDry 150'),
('Envasadora en Lata CanPack 300'),
('Trituradora de Carne MeatGrinder 600');

-- Tabla 2 Empresa (50 registros)
INSERT INTO empresa (rut, nombre) VALUES 
('7612345678', 'Cecinas del Valle S.A.'),
('7623456789', 'Cecinas del Norte Ltda.'),
('7634567890', 'Carnes del Sur S.A.'),
('7645678901', 'Embutidos Central S.A.'),
('7656789012', 'Distribuidora de Carnes El Sol'),
('7667890123', 'Productos Cárnicos del Oeste'),
('7678901234', 'Fabrica de Cecinas La Estrella'),
('7689012345', 'Carnes y Embutidos Los Andes'),
('7690123456', 'Cecinas Gourmet S.A.'),
('7601234567', 'Carnes del Centro Ltda.'),
('7612345679', 'Distribuciones Cárnicas del Este'),
('7623456790', 'Cecinas Premium S.A.'),
('7634567801', 'Embutidos del Campo Ltda.'),
('7645678912', 'Carnes del Valle Ltda.'),
('7656789023', 'Cecinas El Granero'),
('7667890134', 'Productos Cárnicos de la Patagonia'),
('7678901245', 'Cecinas del Pueblo S.A.'),
('7689012356', 'Fábrica de Embutidos La Fortuna'),
('7690123467', 'Carnes y Cecinas del Pacífico'),
('7601234578', 'Distribuidora de Carnes El Desierto'),
('7612345689', 'Cecinas La Familia Ltda.'),
('7623456791', 'Embutidos del Norte S.A.'),
('7634567802', 'Carnes del Sur Ltda.'),
('7645678913', 'Productos Cárnicos La Tierra'),
('7656789024', 'Cecinas El Progreso'),
('7667890135', 'Distribuciones Cárnicas La Luna'),
('7678901246', 'Fabrica de Carnes del Norte'),
('7689012357', 'Cecinas del Bosque S.A.'),
('7690123468', 'Embutidos del Mar Ltda.'),
('7601234579', 'Carnes y Cecinas del Valle'),
('7612345690', 'Distribuidora de Carnes El Valle'),
('7623456792', 'Cecinas del Centro S.A.'),
('7634567803', 'Embutidos La Cima Ltda.'),
('7645678914', 'Productos Cárnicos La Alta'),
('7656789025', 'Cecinas El Río'),
('7667890136', 'Carnes del Pacífico Ltda.'),
('7678901247', 'Cecinas La Esperanza'),
('7689012358', 'Embutidos del Bosque S.A.'),
('7690123469', 'Distribuidora de Carnes La Cumbre'),
('7601234580', 'Carnes y Cecinas La Costa'),
('7612345691', 'Cecinas El Campo Ltda.'),
('7623456793', 'Productos Cárnicos del Valle'),
('7634567804', 'Embutidos La Victoria S.A.'),
('7645678915', 'Cecinas del Cielo'),
('7656789026', 'Carnes del Norte Ltda.'),
('7667890137', 'Fábrica de Embutidos El Trébol'),
('7678901248', 'Cecinas del Mar S.A.'),
('7689012359', 'Embutidos y Carnes La Sierra'),
('7690123470', 'Cecinas La Unión Ltda.');

-- Tabla 3 Bodega (50 registros)
INSERT INTO bodega (id_bodega, nombre) VALUES 
(1001, 'Bodega Central Norte'),
(1002, 'Bodega del Valle'),
(1003, 'Bodega del Sur'),
(1004, 'Bodega El Río'),
(1005, 'Bodega La Estrella'),
(1006, 'Bodega El Progreso'),
(1007, 'Bodega del Pacífico'),
(1008, 'Bodega La Fortuna'),
(1009, 'Bodega del Campo'),
(1010, 'Bodega La Cima'),
(1011, 'Bodega del Norte'),
(1012, 'Bodega El Granero'),
(1013, 'Bodega del Centro'),
(1014, 'Bodega La Esperanza'),
(1015, 'Bodega de la Patagonia'),
(1016, 'Bodega La Alta'),
(1017, 'Bodega El Sol'),
(1018, 'Bodega del Bosque'),
(1019, 'Bodega La Luna'),
(1020, 'Bodega La Sierra'),
(1021, 'Bodega del Mar'),
(1022, 'Bodega El Valle'),
(1023, 'Bodega La Costa'),
(1024, 'Bodega La Unión'),
(1025, 'Bodega de la Alta Montaña'),
(1026, 'Bodega La Victoria'),
(1027, 'Bodega del Este'),
(1028, 'Bodega El Desierto'),
(1029, 'Bodega del Norte Grande'),
(1030, 'Bodega La Familia'),
(1031, 'Bodega de los Andes'),
(1032, 'Bodega El Pinar'),
(1033, 'Bodega del Horizonte'),
(1034, 'Bodega del Lago'),
(1035, 'Bodega La Selva'),
(1036, 'Bodega del Río Grande'),
(1037, 'Bodega El Águila'),
(1038, 'Bodega La Roca'),
(1039, 'Bodega de los Cedros'),
(1040, 'Bodega del Altiplano'),
(1041, 'Bodega La Cumbre'),
(1042, 'Bodega El Oasis'),
(1043, 'Bodega del Valle de la Luna'),
(1044, 'Bodega del Jardín'),
(1045, 'Bodega La Esperanza Grande'),
(1046, 'Bodega del Valle Central'),
(1047, 'Bodega La Piedra'),
(1048, 'Bodega del Océano'),
(1049, 'Bodega del Parque'),
(1050, 'Bodega La Colina');

-- Tabla 4 Receta (50 registros)
INSERT INTO receta (id_receta, nombre) VALUES 
(2001, 'Receta Clásica de Chorizo'),
(2002, 'Receta de Salchichón Ibérico'),
(2003, 'Receta de Cecina de León'),
(2004, 'Receta de Longaniza de Aragón'),
(2005, 'Receta de Morcilla de Burgos'),
(2006, 'Receta de Salchicha Vienesa'),
(2007, 'Receta de Chorizo Picante'),
(2008, 'Receta de Salchichón de Cerdo'),
(2009, 'Receta de Cecina de Vacuno'),
(2010, 'Receta de Longaniza de Cerdo'),
(2011, 'Receta de Morcilla de Cebolla'),
(2012, 'Receta de Chorizo de Pavo'),
(2013, 'Receta de Salchicha Ahumada'),
(2014, 'Receta de Cecina Curada'),
(2015, 'Receta de Longaniza de Cordero'),
(2016, 'Receta de Morcilla de Arroz'),
(2017, 'Receta de Chorizo Casero'),
(2018, 'Receta de Salchichón Extra'),
(2019, 'Receta de Cecina al Vino'),
(2020, 'Receta de Longaniza de Pavo'),
(2021, 'Receta de Morcilla de Marisco'),
(2022, 'Receta de Chorizo Español'),
(2023, 'Receta de Salchicha de Ternera'),
(2024, 'Receta de Cecina de Cerdo'),
(2025, 'Receta de Longaniza de Marisco'),
(2026, 'Receta de Morcilla de Vino'),
(2027, 'Receta de Chorizo de Cerdo'),
(2028, 'Receta de Salchichón de Ternera'),
(2029, 'Receta de Cecina Picante'),
(2030, 'Receta de Longaniza de Cerdo Picante'),
(2031, 'Receta de Morcilla de Ternera'),
(2032, 'Receta de Chorizo de Marisco'),
(2033, 'Receta de Salchicha de Pavo'),
(2034, 'Receta de Cecina en Aceite'),
(2035, 'Receta de Longaniza de Vino'),
(2036, 'Receta de Morcilla de Cerdo'),
(2037, 'Receta de Chorizo Ahumado'),
(2038, 'Receta de Salchichón de Pavo'),
(2039, 'Receta de Cecina con Pimientos'),
(2040, 'Receta de Longaniza de Vino Tinto'),
(2041, 'Receta de Morcilla Picante'),
(2042, 'Receta de Chorizo Gourmet'),
(2043, 'Receta de Salchicha Gourmet'),
(2044, 'Receta de Cecina al Romero'),
(2045, 'Receta de Longaniza a la Parrilla'),
(2046, 'Receta de Morcilla de Cebolla y Vino'),
(2047, 'Receta de Chorizo de Pimiento'),
(2048, 'Receta de Salchichón de Cerdo y Pavo'),
(2049, 'Receta de Cecina con Especias'),
(2050, 'Receta de Longaniza de Pimientos');

-- Tabla 5 Inventario (50 registros)
INSERT INTO inventario (id_inventario, nombre, stock) VALUES 
(3001, 'Carne de Res', 150),
(3002, 'Carne de Cerdo', 200),
(3003, 'Carne de Pollo', 180),
(3004, 'Carne de Cordero', 120),
(3005, 'Carne de Pavo', 160),
(3006, 'Chorizo', 140),
(3007, 'Salchichón', 130),
(3008, 'Longaniza', 110),
(3009, 'Morcilla', 90),
(3010, 'Cecina', 70),
(3011, 'Carne Ahumada', 85),
(3012, 'Salchicha', 95),
(3013, 'Cecina Curada', 60),
(3014, 'Longaniza de Cerdo', 75),
(3015, 'Morcilla de Arroz', 55),
(3016, 'Carne de Ternera', 140),
(3017, 'Cecina al Vino', 50),
(3018, 'Longaniza de Pavo', 45),
(3019, 'Morcilla de Vino', 35),
(3020, 'Salchichón Extra', 50),
(3021, 'Carne de Res Ahumada', 80),
(3022, 'Salchicha de Pavo', 70),
(3023, 'Cecina con Pimientos', 40),
(3024, 'Longaniza de Vino Tinto', 30),
(3025, 'Morcilla Picante', 25),
(3026, 'Chorizo Gourmet', 45),
(3027, 'Salchicha Gourmet', 50),
(3028, 'Cecina al Romero', 20),
(3029, 'Longaniza a la Parrilla', 15),
(3030, 'Morcilla de Cebolla y Vino', 10),
(3031, 'Chorizo Picante', 60),
(3032, 'Salchichón de Cerdo', 65),
(3033, 'Carne de Cerdo Ahumada', 70),
(3034, 'Longaniza de Marisco', 25),
(3035, 'Morcilla de Cerdo', 30),
(3036, 'Cecina de León', 20),
(3037, 'Carne de Pollo Fresca', 90),
(3038, 'Salchicha Ahumada', 40),
(3039, 'Cecina con Especias', 25),
(3040, 'Longaniza de Cerdo Picante', 20),
(3041, 'Morcilla de Pimiento', 15),
(3042, 'Chorizo de Marisco', 10),
(3043, 'Carne de Cordero Ahumada', 35),
(3044, 'Salchichón de Pavo', 50),
(3045, 'Cecina al Aceite', 25),
(3046, 'Longaniza de Vino', 30),
(3047, 'Morcilla de Ternera', 20),
(3048, 'Chorizo de Cerdo', 15),
(3049, 'Carne de Ternera Fresca', 60),
(3050, 'Salchicha de Cerdo', 40);

-- Tabla 6 Proveedor (50 registros)
INSERT INTO proveedor (rut, nombre) VALUES 
('7612345678', 'Cecinas del Valle S.A.'),
('7623456789', 'Carnes Premium Ltda.'),
('7634567890', 'Distribuidora de Carnes ABC'),
('7645678901', 'Proveedor Nacional de Cecinas'),
('7656789012', 'Cárnicos del Norte S.A.'),
('7667890123', 'Salchichonería El Buen Gusto'),
('7678901234', 'Cecinas y Chacinados S.A.'),
('7689012345', 'Carnes Finas del Sur'),
('7690123456', 'Distribuciones Cárnicas Rápidas'),
('7701234567', 'Cecinas del Centro'),
('7712345678', 'Proveedor de Salchichas y Chorizos'),
('7723456789', 'Carnes del Valle S.A.'),
('7734567890', 'Cárnicos Premium Ltda.'),
('7745678901', 'Distribuidora de Morcillas'),
('7756789012', 'Salchichones y Longanizas ABC'),
('7767890123', 'Cecinas y Embutidos del Sur'),
('7778901234', 'Carnes y Cecinas Nacionales'),
('7789012345', 'Distribuciones del Norte'),
('7790123456', 'Proveedor de Cecinas y Chorizos'),
('7801234567', 'Carnes y Salchichas Premium'),
('7812345678', 'Distribuidora de Chacinados S.A.'),
('7823456789', 'Cárnicos del Sur Ltda.'),
('7834567890', 'Salchichas y Cecinas del Valle'),
('7845678901', 'Carnes y Embutidos S.A.'),
('7856789012', 'Distribuidora de Salchichas'),
('7867890123', 'Cecinas del Pacífico'),
('7878901234', 'Carnes y Morcillas Premium'),
('7889012345', 'Proveedor Nacional de Chorizos'),
('7890123456', 'Distribuciones del Centro'),
('7901234567', 'Cárnicos del Valle'),
('7912345678', 'Salchichonería del Norte'),
('7923456789', 'Cecinas y Carnes Finas'),
('7934567890', 'Distribuidora de Chorizos y Morcillas'),
('7945678901', 'Proveedor de Cecinas del Norte'),
('7956789012', 'Carnes y Salchichones S.A.'),
('7967890123', 'Cecinas y Chacinados Premium'),
('7978901234', 'Distribuidora de Salchichas y Cecinas'),
('7989012345', 'Cárnicos del Centro'),
('7990123456', 'Proveedor de Carnes y Chorizos'),
('8001234567', 'Cecinas y Carnes del Valle'),
('8012345678', 'Salchichas y Longanizas S.A.'),
('8023456789', 'Distribuidora de Morcillas y Cecinas'),
('8034567890', 'Cárnicos Premium del Sur'),
('8045678901', 'Proveedor Nacional de Salchichas'),
('8056789012', 'Distribuciones Cárnicas del Centro'),
('8067890123', 'Cecinas del Valle y Norte'),
('8078901234', 'Carnes Finas y Chacinados'),
('8089012345', 'Proveedor de Cecinas y Salchichas'),
('8090123456', 'Distribuidora de Chorizos del Sur'),
('8101234567', 'Cárnicos del Pacífico S.A.');

-- Tabla 7 TipoCecina (50 registros)
INSERT INTO tipo_cecina (id_tipo_cecina, nombre) VALUES 
(4001, 'Chorizo'),
(4002, 'Salchichón'),
(4003, 'Longaniza'),
(4004, 'Morcilla'),
(4005, 'Cecina'),
(4006, 'Carne Ahumada'),
(4007, 'Salchicha'),
(4008, 'Cecina Curada'),
(4009, 'Longaniza de Cerdo'),
(4010, 'Morcilla de Arroz'),
(4011, 'Carne de Res'),
(4012, 'Cecina al Vino'),
(4013, 'Longaniza de Pavo'),
(4014, 'Morcilla de Vino'),
(4015, 'Salchichón Extra'),
(4016, 'Carne de Pollo'),
(4017, 'Cecina con Pimientos'),
(4018, 'Longaniza de Vino Tinto'),
(4019, 'Morcilla Picante'),
(4020, 'Chorizo Gourmet'),
(4021, 'Salchicha Gourmet'),
(4022, 'Cecina al Romero'),
(4023, 'Longaniza a la Parrilla'),
(4024, 'Morcilla de Cebolla y Vino'),
(4025, 'Chorizo Picante'),
(4026, 'Salchichón de Cerdo'),
(4027, 'Carne de Ternera'),
(4028, 'Cecina con Especias'),
(4029, 'Longaniza de Cerdo Picante'),
(4030, 'Morcilla de Ternera'),
(4031, 'Chorizo de Marisco'),
(4032, 'Salchicha de Pavo'),
(4033, 'Cecina en Aceite'),
(4034, 'Longaniza de Vino'),
(4035, 'Morcilla de Cerdo'),
(4036, 'Cecina de León'),
(4037, 'Carne de Cordero'),
(4038, 'Salchicha Ahumada'),
(4039, 'Cecina con Pimientos'),
(4040, 'Longaniza de Pimientos'),
(4041, 'Morcilla de Vino Tinto'),
(4042, 'Chorizo de Cerdo'),
(4043, 'Salchicha de Cerdo'),
(4044, 'Cecina del Valle'),
(4045, 'Longaniza de Pavo'),
(4046, 'Morcilla de Arroz'),
(4047, 'Chorizo de Pavo'),
(4048, 'Salchichón de Pavo'),
(4049, 'Cecina al Vino'),
(4050, 'Longaniza de Marisco');

-- Tabla 8 Cliente (50 registros)
INSERT INTO cliente (rut, nombre, giro, direccion, ciudad, fono) VALUES 
('7690123467', 'Carnes y Cecinas del Pacífico', 'Cecinas', 'Av. del Pacífico 123', 'Santiago', '+56 2 2345 6789'),
('7623456789', 'Alimentos y Carnes del Valle', 'Alimentos', 'Calle del Valle 456', 'Valparaíso', '+56 32 2345 6789'),
('7834567890', 'Distribuciones del Sur', 'Distribución', 'Paseo del Sur 789', 'Concepción', '+56 41 2345 6789'),
('7654321098', 'Cecinas del Norte Ltda.', 'Cecinas', 'Avenida del Norte 101', 'Antofagasta', '+56 55 2345 6789'),
('7650987654', 'Chorizos y Embutidos Ltda.', 'Embutidos', 'Calle de los Embutidos 202', 'La Serena', '+56 51 2345 6789'),
('7865432109', 'Productos del Campo S.A.', 'Carnes', 'Ruta del Campo 303', 'Temuco', '+56 45 2345 6789'),
('7678901234', 'Cecinas Premium Ltda.', 'Cecinas', 'Avenida Premium 404', 'Puerto Montt', '+56 65 2345 6789'),
('7543210987', 'Proveeduría del Norte', 'Distribución', 'Calle Norte 505', 'Iquique', '+56 57 2345 6789'),
('7632109876', 'Salchichonería del Sur', 'Embutidos', 'Avenida del Sur 606', 'Osorno', '+56 64 2345 6789'),
('7654321098', 'Carnes Finas Ltda.', 'Carnes', 'Paseo de las Carnes 707', 'Rancagua', '+56 72 2345 6789'),
('7543987654', 'Cecinas del Pacífico', 'Cecinas', 'Av. Pacífico 808', 'Chillán', '+56 42 2345 6789'),
('7623456789', 'Distribuidora ABC', 'Distribución', 'Calle ABC 909', 'Valdivia', '+56 63 2345 6789'),
('7694321098', 'Carnes del Centro', 'Carnes', 'Calle del Centro 1010', 'Arica', '+56 58 2345 6789'),
('7654908765', 'Cecinas de Calidad', 'Cecinas', 'Avenida de Calidad 1111', 'Calama', '+56 55 2345 6789'),
('7643210987', 'Salchichonería El Buen Gusto', 'Embutidos', 'Calle del Buen Gusto 1212', 'Santiago', '+56 2 3456 7890'),
('7532109876', 'Carnes y Chacinados', 'Carnes', 'Paseo Chacinados 1313', 'Viña del Mar', '+56 32 3456 7890'),
('7621098765', 'Distribuidora del Sur', 'Distribución', 'Av. del Sur 1414', 'Los Ángeles', '+56 43 3456 7890'),
('7643210987', 'Cecinas y Más Ltda.', 'Cecinas', 'Calle de las Cecinas 1515', 'Temuco', '+56 45 3456 7890'),
('7598765432', 'Chorizos y Embutidos', 'Embutidos', 'Avenida de los Embutidos 1616', 'Coquimbo', '+56 51 3456 7890'),
('7623456789', 'Cárnicos del Valle', 'Carnes', 'Paseo del Valle 1717', 'Rancagua', '+56 72 3456 7890'),
('7543210987', 'Cecinas del Sur', 'Cecinas', 'Calle del Sur 1818', 'Chillán', '+56 42 3456 7890'),
('7654321098', 'Distribuciones Premium', 'Distribución', 'Av. Premium 1919', 'Osorno', '+56 64 3456 7890'),
('7698765432', 'Salchichonería Gourmet', 'Embutidos', 'Calle Gourmet 2020', 'Santiago', '+56 2 4567 8901'),
('7623456789', 'Carnes y Cecinas S.A.', 'Carnes', 'Paseo Cecinas 2121', 'Valparaíso', '+56 32 4567 8901'),
('7543210987', 'Cecinas del Centro Ltda.', 'Cecinas', 'Avenida del Centro 2222', 'Concepción', '+56 41 4567 8901'),
('7690321098', 'Distribuidora de Chorizos', 'Distribución', 'Calle de los Chorizos 2323', 'Antofagasta', '+56 55 4567 8901'),
('7623456789', 'Carnes del Norte Ltda.', 'Carnes', 'Av. del Norte 2424', 'La Serena', '+56 51 4567 8901'),
('7543210987', 'Cecinas y Embutidos', 'Cecinas', 'Calle de los Embutidos 2525', 'Temuco', '+56 45 4567 8901'),
('7698765432', 'Chorizos y Salchichas del Sur', 'Embutidos', 'Avenida del Sur 2626', 'Puerto Montt', '+56 65 4567 8901'),
('7623456789', 'Cárnicos Premium', 'Carnes', 'Calle Premium 2727', 'Iquique', '+56 57 4567 8901'),
('7543210987', 'Cecinas del Norte Ltda.', 'Cecinas', 'Av. del Norte 2828', 'Osorno', '+56 64 4567 8901'),
('7632109876', 'Distribuidora Nacional', 'Distribución', 'Calle Nacional 2929', 'Arica', '+56 58 4567 8901'),
('7623456789', 'Salchichonería del Valle', 'Embutidos', 'Avenida del Valle 3030', 'Calama', '+56 55 4567 8901'),
('7654321098', 'Carnes y Cecinas Premium', 'Carnes', 'Paseo Premium 3131', 'Valdivia', '+56 63 4567 8901'),
('7543210987', 'Cecinas y Más S.A.', 'Cecinas', 'Calle del Cecino 3232', 'Coquimbo', '+56 51 4567 8901'),
('7694321098', 'Chorizos y Morcillas', 'Embutidos', 'Avenida Morcillas 3333', 'Santiago', '+56 2 5678 9012'),
('7623456789', 'Distribuidora de Cecinas', 'Distribución', 'Calle Cecinas 3434', 'Rancagua', '+56 72 5678 9012'),
('7543210987', 'Cárnicos del Sur Ltda.', 'Carnes', 'Avenida del Sur 3535', 'Chillán', '+56 42 5678 9012'),
('7650987654', 'Cecinas y Chorizos S.A.', 'Cecinas', 'Paseo Chorizos 3636', 'Los Ángeles', '+56 43 5678 9012'),
('7698765432', 'Salchichonería del Norte Ltda.', 'Embutidos', 'Calle del Norte 3737', 'Temuco', '+56 45 5678 9012'),
('7543210987', 'Carnes y Salchichones Ltda.', 'Carnes', 'Av. Salchichones 3838', 'Coquimbo', '+56 51 5678 9012'),
('7623456789', 'Distribuidora de Chacinados', 'Distribución', 'Avenida Chacinados 3939', 'Valparaíso', '+56 32 5678 9012'),
('7654321098', 'Cecinas y Morcillas Ltda.', 'Cecinas', 'Calle Morcillas 4040', 'Santiago', '+56 2 6789 0123'),
('7623456789', 'Chorizos y Carne Premium', 'Embutidos', 'Paseo Carne 4141', 'Puerto Montt', '+56 65 6789 0123');

-- Tabla 9 Planta Producción (50 registros)
INSERT INTO planta_prod (id_planta_prod, nombre, id_maquinaria) VALUES 
(1, 'Planta Centro Norte', 1),
(2, 'Planta Sur', 2),
(3, 'Planta Los Andes', 3),
(4, 'Planta Valle', 4),
(5, 'Planta Norte Grande', 5),
(6, 'Planta Norte Chico', 6),
(7, 'Planta Costa', 7),
(8, 'Planta Andes', 8),
(9, 'Planta Pacífico', 9),
(10, 'Planta Región Metropolitana', 10),
(11, 'Planta Centro Sur', 11),
(12, 'Planta Del Mar', 12),
(13, 'Planta Del Valle', 13),
(14, 'Planta Patagonia', 14),
(15, 'Planta Sur Chico', 15),
(16, 'Planta Sur Grande', 16),
(17, 'Planta Zona Norte', 17),
(18, 'Planta Zona Sur', 18),
(19, 'Planta Centro Oeste', 19),
(20, 'Planta Región del Libertador', 20),
(21, 'Planta Norte Sur', 21),
(22, 'Planta Región de los Lagos', 22),
(23, 'Planta Alto Andino', 23),
(24, 'Planta Bajo Andino', 24),
(25, 'Planta Valle Central', 25),
(26, 'Planta Centro Norte Chico', 26),
(27, 'Planta Región del Bío Bío', 27),
(28, 'Planta Del Este', 28),
(29, 'Planta Del Oeste', 29),
(30, 'Planta Región de Arica', 30),
(31, 'Planta Zona Centro', 31),
(32, 'Planta Norte y Centro', 32),
(33, 'Planta Sur y Costa', 33),
(34, 'Planta Central Norte', 34),
(35, 'Planta Central Sur', 35),
(36, 'Planta Región de la Araucanía', 36),
(37, 'Planta Región de Atacama', 37),
(38, 'Planta Región de Maule', 38),
(39, 'Planta Región de Ñuble', 39),
(40, 'Planta Región de O’Higgins', 40),
(41, 'Planta Región del Libertador General Bernardo O’Higgins', 41),
(42, 'Planta Región de la Región Metropolitana de Santiago', 42),
(43, 'Planta Región de Los Ríos', 43),
(44, 'Planta Región de Los Lagos', 44),
(45, 'Planta Región de Magallanes', 45),
(46, 'Planta Región del Maule', 46),
(47, 'Planta Región de Ñuble', 47),
(48, 'Planta Región de Arica y Parinacota', 48),
(49, 'Planta Región de Valparaíso', 49),
(50, 'Planta Región Metropolitana Norte', 50);

-- Tabla 10 Producción (50 registros)
INSERT INTO produccion (id_produccion, fecha_inicio, fecha_termino, id_planta_prod) VALUES 
(1, '2024-01-01', '2024-01-31', 1),
(2, '2024-02-01', '2024-02-28', 2),
(3, '2024-03-01', '2024-03-31', 3),
(4, '2024-04-01', '2024-04-30', 4),
(5, '2024-05-01', '2024-05-31', 5),
(6, '2024-06-01', '2024-06-30', 6),
(7, '2024-07-01', '2024-07-31', 7),
(8, '2024-08-01', '2024-08-31', 8),
(9, '2024-09-01', '2024-09-30', 9),
(10, '2024-10-01', '2024-10-31', 10),
(11, '2024-11-01', '2024-11-30', 11),
(12, '2024-12-01', '2024-12-31', 12),
(13, '2024-01-15', '2024-02-15', 13),
(14, '2024-02-15', '2024-03-15', 14),
(15, '2024-03-15', '2024-04-15', 15),
(16, '2024-04-15', '2024-05-15', 16),
(17, '2024-05-15', '2024-06-15', 17),
(18, '2024-06-15', '2024-07-15', 18),
(19, '2024-07-15', '2024-08-15', 19),
(20, '2024-08-15', '2024-09-15', 20),
(21, '2024-09-15', '2024-10-15', 21),
(22, '2024-10-15', '2024-11-15', 22),
(23, '2024-11-15', '2024-12-15', 23),
(24, '2024-12-15', '2025-01-15', 24),
(25, '2025-01-15', '2025-02-15', 25),
(26, '2025-02-15', '2025-03-15', 26),
(27, '2025-03-15', '2025-04-15', 27),
(28, '2025-04-15', '2025-05-15', 28),
(29, '2025-05-15', '2025-06-15', 29),
(30, '2025-06-15', '2025-07-15', 30),
(31, '2025-07-15', '2025-08-15', 31),
(32, '2025-08-15', '2025-09-15', 32),
(33, '2025-09-15', '2025-10-15', 33),
(34, '2025-10-15', '2025-11-15', 34),
(35, '2025-11-15', '2025-12-15', 35),
(36, '2025-12-15', '2026-01-15', 36),
(37, '2026-01-15', '2026-02-15', 37),
(38, '2026-02-15', '2026-03-15', 38),
(39, '2026-03-15', '2026-04-15', 39),
(40, '2026-04-15', '2026-05-15', 40),
(41, '2026-05-15', '2026-06-15', 41),
(42, '2026-06-15', '2026-07-15', 42),
(43, '2026-07-15', '2026-08-15', 43),
(44, '2026-08-15', '2026-09-15', 44),
(45, '2026-09-15', '2026-10-15', 45),
(46, '2026-10-15', '2026-11-15', 46),
(47, '2026-11-15', '2026-12-15', 47),
(48, '2026-12-15', '2027-01-15', 48),
(49, '2027-01-15', '2027-02-15', 49),
(50, '2027-02-15', '2027-03-15', 50);

-- Tabla 11 Detalles de Producción (50 registros)
INSERT INTO det_produccion (id_det_produccion, cantidad_esperada, cantidad_obtenida, fecha_inicio, fecha_termino, id_produccion, id_receta, id_bodega) VALUES 
(1, 1000, 950, '2024-01-01', '2024-01-31', 1, 1, 1),
(2, 1200, 1150, '2024-02-01', '2024-02-28', 2, 2, 2),
(3, 1100, 1080, '2024-03-01', '2024-03-31', 3, 3, 3),
(4, 1300, 1250, '2024-04-01', '2024-04-30', 4, 4, 4),
(5, 1400, 1380, '2024-05-01', '2024-05-31', 5, 5, 5),
(6, 1500, 1480, '2024-06-01', '2024-06-30', 6, 6, 6),
(7, 1600, 1550, '2024-07-01', '2024-07-31', 7, 7, 7),
(8, 1700, 1680, '2024-08-01', '2024-08-31', 8, 8, 8),
(9, 1800, 1750, '2024-09-01', '2024-09-30', 9, 9, 9),
(10, 1900, 1850, '2024-10-01', '2024-10-31', 10, 10, 10),
(11, 2000, 1950, '2024-11-01', '2024-11-30', 11, 11, 11),
(12, 2100, 2050, '2024-12-01', '2024-12-31', 12, 12, 12),
(13, 2200, 2150, '2024-01-15', '2024-02-15', 13, 13, 13),
(14, 2300, 2250, '2024-02-15', '2024-03-15', 14, 14, 14),
(15, 2400, 2350, '2024-03-15', '2024-04-15', 15, 15, 15),
(16, 2500, 2450, '2024-04-15', '2024-05-15', 16, 16, 16),
(17, 2600, 2550, '2024-05-15', '2024-06-15', 17, 17, 17),
(18, 2700, 2650, '2024-06-15', '2024-07-15', 18, 18, 18),
(19, 2800, 2750, '2024-07-15', '2024-08-15', 19, 19, 19),
(20, 2900, 2850, '2024-08-15', '2024-09-15', 20, 20, 20),
(21, 3000, 2950, '2024-09-15', '2024-10-15', 21, 21, 21),
(22, 3100, 3050, '2024-10-15', '2024-11-15', 22, 22, 22),
(23, 3200, 3150, '2024-11-15', '2024-12-15', 23, 23, 23),
(24, 3300, 3250, '2024-12-15', '2025-01-15', 24, 24, 24),
(25, 3400, 3350, '2025-01-15', '2025-02-15', 25, 25, 25),
(26, 3500, 3450, '2025-02-15', '2025-03-15', 26, 26, 26),
(27, 3600, 3550, '2025-03-15', '2025-04-15', 27, 27, 27),
(28, 3700, 3650, '2025-04-15', '2025-05-15', 28, 28, 28),
(29, 3800, 3750, '2025-05-15', '2025-06-15', 29, 29, 29),
(30, 3900, 3850, '2025-06-15', '2025-07-15', 30, 30, 30),
(31, 4000, 3950, '2025-07-15', '2025-08-15', 31, 31, 31),
(32, 4100, 4050, '2025-08-15', '2025-09-15', 32, 32, 32),
(33, 4200, 4150, '2025-09-15', '2025-10-15', 33, 33, 33),
(34, 4300, 4250, '2025-10-15', '2025-11-15', 34, 34, 34),
(35, 4400, 4350, '2025-11-15', '2025-12-15', 35, 35, 35),
(36, 4500, 4450, '2025-12-15', '2026-01-15', 36, 36, 36),
(37, 4600, 4550, '2026-01-15', '2026-02-15', 37, 37, 37),
(38, 4700, 4650, '2026-02-15', '2026-03-15', 38, 38, 38),
(39, 4800, 4750, '2026-03-15', '2026-04-15', 39, 39, 39),
(40, 4900, 4850, '2026-04-15', '2026-05-15', 40, 40, 40),
(41, 5000, 4950, '2026-05-15', '2026-06-15', 41, 41, 41),
(42, 5100, 5050, '2026-06-15', '2026-07-15', 42, 42, 42),
(43, 5200, 5150, '2026-07-15', '2026-08-15', 43, 43, 43),
(44, 5300, 5250, '2026-08-15', '2026-09-15', 44, 44, 44),
(45, 5400, 5350, '2026-09-15', '2026-10-15', 45, 45, 45),
(46, 5500, 5450, '2026-10-15', '2026-11-15', 46, 46, 46),
(47, 5600, 5550, '2026-11-15', '2026-12-15', 47, 47, 47),
(48, 5700, 5650, '2026-12-15', '2027-01-15', 48, 48, 48),
(49, 5800, 5750, '2027-01-15', '2027-02-15', 49, 49, 49),
(50, 5900, 5850, '2027-02-15', '2027-03-15', 50, 50, 50);

-- Tabla 12 Venta (50 registros)
INSERT INTO venta (numero_factura, fecha_venta, total, cliente_rut) VALUES
(1001, '2024-01-10', 120000, '7690123467'),
(1002, '2024-01-15', 150000, '7612345678'),
(1003, '2024-01-20', 175000, '7601234567'),
(1004, '2024-01-25', 200000, '7698765432'),
(1005, '2024-02-05', 225000, '7654321098'),
(1006, '2024-02-10', 250000, '7643210987'),
(1007, '2024-02-15', 275000, '7694321098'),
(1008, '2024-02-20', 300000, '7623456789'),
(1009, '2024-03-01', 325000, '7654321098'),
(1010, '2024-03-05', 350000, '7612345678'),
(1011, '2024-03-10', 375000, '7690123467'),
(1012, '2024-03-15', 400000, '7601234567'),
(1013, '2024-03-20', 425000, '7654321098'),
(1014, '2024-04-01', 450000, '7643210987'),
(1015, '2024-04-05', 475000, '7698765432'),
(1016, '2024-04-10', 500000, '7623456789'),
(1017, '2024-04-15', 525000, '7612345678'),
(1018, '2024-05-01', 550000, '7654321098'),
(1019, '2024-05-05', 575000, '7690123467'),
(1020, '2024-05-10', 600000, '7698765432'),
(1021, '2024-05-15', 625000, '7601234567'),
(1022, '2024-06-01', 650000, '7643210987'),
(1023, '2024-06-05', 675000, '7654321098'),
(1024, '2024-06-10', 700000, '7623456789'),
(1025, '2024-06-15', 725000, '7612345678'),
(1026, '2024-07-01', 750000, '7690123467'),
(1027, '2024-07-05', 775000, '7654321098'),
(1028, '2024-07-10', 800000, '7643210987'),
(1029, '2024-07-15', 825000, '7698765432'),
(1030, '2024-08-01', 850000, '7601234567'),
(1031, '2024-08-05', 875000, '7623456789'),
(1032, '2024-08-10', 900000, '7612345678'),
(1033, '2024-08-15', 925000, '7690123467'),
(1034, '2024-09-01', 950000, '7654321098'),
(1035, '2024-09-05', 975000, '7601234567'),
(1036, '2024-09-10', 1000000, '7643210987'),
(1037, '2024-09-15', 1025000, '7698765432'),
(1038, '2024-10-01', 1050000, '7623456789'),
(1039, '2024-10-05', 1075000, '7690123467'),
(1040, '2024-10-10', 1100000, '7654321098'),
(1041, '2024-10-15', 1125000, '7601234567'),
(1042, '2024-11-01', 1150000, '7698765432'),
(1043, '2024-11-05', 1175000, '7623456789'),
(1044, '2024-11-10', 1200000, '7612345678'),
(1045, '2024-11-15', 1225000, '7690123467'),
(1046, '2024-12-01', 1250000, '7643210987'),
(1047, '2024-12-05', 1275000, '7601234567'),
(1048, '2024-12-10', 1300000, '7623456789'),
(1049, '2024-12-15', 1325000, '7654321098'),
(1050, '2024-12-20', 1350000, '7698765432');

-- Tabla 13 Compra (50 registros)
INSERT INTO compra (numero_factura, fecha_venta, total, proveedor_rut) VALUES
(2001, '2024-01-10', 120000, '7690123467'),
(2002, '2024-01-15', 150000, '7612345678'),
(2003, '2024-01-20', 175000, '7601234567'),
(2004, '2024-01-25', 200000, '7698765432'),
(2005, '2024-02-05', 225000, '7654321098'),
(2006, '2024-02-10', 250000, '7643210987'),
(2007, '2024-02-15', 275000, '7694321098'),
(2008, '2024-02-20', 300000, '7623456789'),
(2009, '2024-03-01', 325000, '7654321098'),
(2010, '2024-03-05', 350000, '7612345678'),
(2011, '2024-03-10', 375000, '7690123467'),
(2012, '2024-03-15', 400000, '7601234567'),
(2013, '2024-03-20', 425000, '7654321098'),
(2014, '2024-04-01', 450000, '7643210987'),
(2015, '2024-04-05', 475000, '7698765432'),
(2016, '2024-04-10', 500000, '7623456789'),
(2017, '2024-04-15', 525000, '7612345678'),
(2018, '2024-05-01', 550000, '7654321098'),
(2019, '2024-05-05', 575000, '7690123467'),
(2020, '2024-05-10', 600000, '7698765432'),
(2021, '2024-05-15', 625000, '7601234567'),
(2022, '2024-06-01', 650000, '7643210987'),
(2023, '2024-06-05', 675000, '7654321098'),
(2024, '2024-06-10', 700000, '7623456789'),
(2025, '2024-06-15', 725000, '7612345678'),
(2026, '2024-07-01', 750000, '7690123467'),
(2027, '2024-07-05', 775000, '7654321098'),
(2028, '2024-07-10', 800000, '7643210987'),
(2029, '2024-07-15', 825000, '7698765432'),
(2030, '2024-08-01', 850000, '7601234567'),
(2031, '2024-08-05', 875000, '7623456789'),
(2032, '2024-08-10', 900000, '7612345678'),
(2033, '2024-08-15', 925000, '7690123467'),
(2034, '2024-09-01', 950000, '7654321098'),
(2035, '2024-09-05', 975000, '7601234567'),
(2036, '2024-09-10', 1000000, '7643210987'),
(2037, '2024-09-15', 1025000, '7698765432'),
(2038, '2024-10-01', 1050000, '7623456789'),
(2039, '2024-10-05', 1075000, '7690123467'),
(2040, '2024-10-10', 1100000, '7654321098'),
(2041, '2024-10-15', 1125000, '7601234567'),
(2042, '2024-11-01', 1150000, '7698765432'),
(2043, '2024-11-05', 1175000, '7623456789'),
(2044, '2024-11-10', 1200000, '7612345678'),
(2045, '2024-11-15', 1225000, '7690123467'),
(2046, '2024-12-01', 1250000, '7643210987'),
(2047, '2024-12-05', 1275000, '7601234567'),
(2048, '2024-12-10', 1300000, '7623456789'),
(2049, '2024-12-15', 1325000, '7654321098'),
(2050, '2024-12-20', 1350000, '7698765432');

-- Tabla 14 Detalle Compra (50 registros)
INSERT INTO det_compra (id_det_compra, cantidad, descripcion, unitario, id_inventario, numero_factura) VALUES
(1, 50, 'Harina de trigo', 5000, 1, 2001),
(2, 30, 'Salchichas', 8000, 2, 2002),
(3, 20, 'Papel film', 3000, 3, 2003),
(4, 15, 'Aceite vegetal', 7000, 4, 2004),
(5, 25, 'Especias mixtas', 6000, 5, 2005),
(6, 10, 'Colorante rojo', 9000, 6, 2006),
(7, 40, 'Azúcar', 4000, 7, 2007),
(8, 35, 'Pasta de ajo', 5000, 8, 2008),
(9, 45, 'Vinagre', 3500, 9, 2009),
(10, 50, 'Aditivos cárnicos', 12000, 10, 2010),
(11, 20, 'Sal de cura', 11000, 11, 2011),
(12, 15, 'Pimienta negra', 8000, 12, 2012),
(13, 30, 'Salsa de soya', 6000, 13, 2013),
(14, 25, 'Caldo de carne', 7000, 14, 2014),
(15, 10, 'Cúrcuma', 5500, 15, 2015),
(16, 20, 'Pimienta blanca', 9500, 16, 2016),
(17, 30, 'Nuez moscada', 8500, 17, 2017),
(18, 25, 'Ajo en polvo', 6500, 18, 2018),
(19, 40, 'Pasta de tomate', 5500, 19, 2019),
(20, 10, 'Sulfito', 9000, 20, 2020),
(21, 15, 'Chiles secos', 7000, 21, 2021),
(22, 25, 'Tomillo', 8000, 22, 2022),
(23, 30, 'Cebolla en polvo', 6000, 23, 2023),
(24, 20, 'Glutamato monosódico', 6500, 24, 2024),
(25, 35, 'Especias para embutidos', 7000, 25, 2025),
(26, 45, 'Pasta de mostaza', 7500, 26, 2026),
(27, 30, 'Extracto de carne', 9500, 27, 2027),
(28, 40, 'Hierbas aromáticas', 8500, 28, 2028),
(29, 20, 'Colorante amarillo', 8000, 29, 2029),
(30, 15, 'Sal gruesa', 4000, 30, 2030),
(31, 50, 'Glucosa', 6000, 31, 2031),
(32, 25, 'Aditivo para curado', 7000, 32, 2032),
(33, 35, 'Salsa picante', 5000, 33, 2033),
(34, 10, 'Pimienta verde', 8500, 34, 2034),
(35, 20, 'Condimento para cecina', 9500, 35, 2035),
(36, 15, 'Sal fina', 3000, 36, 2036),
(37, 25, 'Dextrosa', 4000, 37, 2037),
(38, 30, 'Esencia de humo', 7000, 38, 2038),
(39, 40, 'Aceite de oliva', 8000, 39, 2039),
(40, 35, 'Pasta de cebolla', 6000, 40, 2040),
(41, 50, 'Colorante natural', 5000, 41, 2041),
(42, 25, 'Especias para salchichas', 5500, 42, 2042),
(43, 15, 'Ajo fresco', 4000, 43, 2043),
(44, 20, 'Encurtidos', 7000, 44, 2044),
(45, 30, 'Extracto de pimiento', 6000, 45, 2045),
(46, 10, 'Salsa de tomate', 3000, 46, 2046),
(47, 15, 'Eneldo', 5500, 47, 2047),
(48, 25, 'Pimienta roja', 7500, 48, 2048),
(49, 30, 'Polvo de curry', 9000, 49, 2049),
(50, 20, 'Pasta de cebolla', 6500, 50, 2050);

-- Tabla 15 Cecina (50 registros)
INSERT INTO cecina (id_cecina, nombre, stock, precio, id_tipo_cecina) VALUES
(1, 'Cecina de Res Tradicional', 500, 20000, 1),
(2, 'Cecina de Cerdo Ahumada', 300, 22000, 2),
(3, 'Cecina de Pollo Marinado', 200, 18000, 1),
(4, 'Cecina de Pavo Especiada', 450, 25000, 2),
(5, 'Cecina de Res con Pimiento', 600, 24000, 1),
(6, 'Cecina de Cerdo con Ajo', 350, 26000, 2),
(7, 'Cecina de Pollo en Tiras', 400, 21000, 1),
(8, 'Cecina de Pavo con Hierbas', 500, 27000, 2),
(9, 'Cecina de Res con Cebolla', 550, 23000, 1),
(10, 'Cecina de Cerdo con Especias', 300, 25000, 2),
(11, 'Cecina de Pollo Picante', 250, 19000, 1),
(12, 'Cecina de Pavo en Rodajas', 450, 26000, 2),
(13, 'Cecina de Res con Mostaza', 600, 24500, 1),
(14, 'Cecina de Cerdo Dulce', 350, 27000, 2),
(15, 'Cecina de Pollo BBQ', 400, 22000, 1),
(16, 'Cecina de Pavo con Salsa', 500, 28000, 2),
(17, 'Cecina de Res con Piquillos', 550, 23500, 1),
(18, 'Cecina de Cerdo en Tiras', 300, 26000, 2),
(19, 'Cecina de Pollo con Limón', 250, 20000, 1),
(20, 'Cecina de Pavo al Horno', 450, 29000, 2),
(21, 'Cecina de Res con Ajo', 600, 25000, 1),
(22, 'Cecina de Cerdo con Chili', 350, 27000, 2),
(23, 'Cecina de Pollo en Salsa', 400, 23000, 1),
(24, 'Cecina de Pavo con Tomate', 500, 30000, 2),
(25, 'Cecina de Res con Hierbas', 550, 24000, 1),
(26, 'Cecina de Cerdo con Mostaza', 300, 26000, 2),
(27, 'Cecina de Pollo al Curry', 250, 21000, 1),
(28, 'Cecina de Pavo en Tiras', 450, 31000, 2),
(29, 'Cecina de Res con Barbacoa', 600, 25500, 1),
(30, 'Cecina de Cerdo con Limón', 350, 28000, 2),
(31, 'Cecina de Pollo con Salsa BBQ', 400, 24000, 1),
(32, 'Cecina de Pavo con Cebolla', 500, 32000, 2),
(33, 'Cecina de Res con Pimienta', 550, 24500, 1),
(34, 'Cecina de Cerdo en Rodajas', 300, 29000, 2),
(35, 'Cecina de Pollo en Barbacoa', 250, 22000, 1),
(36, 'Cecina de Pavo con Ajo', 450, 33000, 2),
(37, 'Cecina de Res con Salsa de Soja', 600, 26000, 1),
(38, 'Cecina de Cerdo con Ajo y Chile', 350, 30000, 2),
(39, 'Cecina de Pollo al Ajillo', 400, 25000, 1),
(40, 'Cecina de Pavo con Salsa de Miel', 500, 34000, 2),
(41, 'Cecina de Res con Pimientos Asados', 550, 25000, 1),
(42, 'Cecina de Cerdo con Salsa Picante', 300, 31000, 2),
(43, 'Cecina de Pollo con Tomillo', 250, 23000, 1),
(44, 'Cecina de Pavo en Salsa de Soja', 450, 35000, 2),
(45, 'Cecina de Res con Salsa BBQ', 600, 26500, 1),
(46, 'Cecina de Cerdo con Especias', 350, 32000, 2),
(47, 'Cecina de Pollo con Limón y Ajo', 400, 26000, 1),
(48, 'Cecina de Pavo con Mostaza y Miel', 500, 36000, 2),
(49, 'Cecina de Res con Salsa de Tomate', 550, 25500, 1),
(50, 'Cecina de Cerdo con Salsa de Ajo', 300, 33000, 2);

-- Tabla 16 Detalle Venta (50 registros)
INSERT INTO det_venta (id_det_venta, cantidad, descripcion, unitario, id_cecina, venta_numero_factura) VALUES
(1, 10, 'Cecina de Res Tradicional', 20000, 1, 3001),
(2, 5, 'Cecina de Cerdo Ahumada', 22000, 2, 3002),
(3, 7, 'Cecina de Pollo Marinado', 18000, 3, 3003),
(4, 4, 'Cecina de Pavo Especiada', 25000, 4, 3004),
(5, 12, 'Cecina de Res con Pimiento', 24000, 5, 3005),
(6, 8, 'Cecina de Cerdo con Ajo', 26000, 6, 3006),
(7, 6, 'Cecina de Pollo en Tiras', 21000, 7, 3007),
(8, 9, 'Cecina de Pavo con Hierbas', 27000, 8, 3008),
(9, 11, 'Cecina de Res con Cebolla', 23000, 9, 3009),
(10, 5, 'Cecina de Cerdo con Especias', 25000, 10, 3010),
(11, 7, 'Cecina de Pollo Picante', 19000, 11, 3011),
(12, 6, 'Cecina de Pavo en Rodajas', 26000, 12, 3012),
(13, 8, 'Cecina de Res con Mostaza', 24500, 13, 3013),
(14, 5, 'Cecina de Cerdo Dulce', 27000, 14, 3014),
(15, 10, 'Cecina de Pollo BBQ', 22000, 15, 3015),
(16, 7, 'Cecina de Pavo con Salsa', 28000, 16, 3016),
(17, 12, 'Cecina de Res con Piquillos', 23500, 17, 3017),
(18, 6, 'Cecina de Cerdo en Tiras', 26000, 18, 3018),
(19, 8, 'Cecina de Pollo con Limón', 20000, 19, 3019),
(20, 10, 'Cecina de Pavo al Horno', 29000, 20, 3020),
(21, 11, 'Cecina de Res con Ajo', 25000, 21, 3021),
(22, 6, 'Cecina de Cerdo con Chili', 27000, 22, 3022),
(23, 9, 'Cecina de Pollo en Salsa', 23000, 23, 3023),
(24, 7, 'Cecina de Pavo con Tomate', 30000, 24, 3024),
(25, 10, 'Cecina de Res con Hierbas', 24000, 25, 3025),
(26, 5, 'Cecina de Cerdo con Mostaza', 26000, 26, 3026),
(27, 8, 'Cecina de Pollo al Curry', 21000, 27, 3027),
(28, 12, 'Cecina de Pavo en Tiras', 31000, 28, 3028),
(29, 11, 'Cecina de Res con Barbacoa', 25500, 29, 3029),
(30, 6, 'Cecina de Cerdo con Limón', 28000, 30, 3030),
(31, 7, 'Cecina de Pollo con Salsa BBQ', 24000, 31, 3031),
(32, 9, 'Cecina de Pavo con Cebolla', 32000, 32, 3032),
(33, 10, 'Cecina de Res con Pimienta', 24500, 33, 3033),
(34, 6, 'Cecina de Cerdo en Rodajas', 29000, 34, 3034),
(35, 8, 'Cecina de Pollo en Barbacoa', 22000, 35, 3035),
(36, 12, 'Cecina de Pavo con Ajo', 33000, 36, 3036),
(37, 10, 'Cecina de Res con Salsa de Soja', 26000, 37, 3037),
(38, 6, 'Cecina de Cerdo con Ajo y Chile', 30000, 38, 3038),
(39, 8, 'Cecina de Pollo al Ajillo', 25000, 39, 3039),
(40, 10, 'Cecina de Pavo con Salsa de Miel', 34000, 40, 3040),
(41, 12, 'Cecina de Res con Pimientos Asados', 25000, 41, 3041),
(42, 7, 'Cecina de Cerdo con Salsa Picante', 31000, 42, 3042),
(43, 10, 'Cecina de Pollo con Tomillo', 23000, 43, 3043),
(44, 8, 'Cecina de Pavo en Salsa de Soja', 35000, 44, 3044),
(45, 11, 'Cecina de Res con Salsa BBQ', 26500, 45, 3045),
(46, 6, 'Cecina de Cerdo con Especias', 32000, 46, 3046),
(47, 9, 'Cecina de Pollo con Limón y Ajo', 26000, 47, 3047),
(48, 12, 'Cecina de Pavo con Mostaza y Miel', 36000, 48, 3048),
(49, 11, 'Cecina de Res con Salsa de Tomate', 25500, 49, 3049),
(50, 7, 'Cecina de Cerdo con Salsa de Ajo', 33000, 50, 3050);

-- Tabla 17 Detalle Receta (50 registros)
INSERT INTO det_receta (id_det_receta, receta_id, cantidad, inventario_id, cecina_id) VALUES
(1, 1, 5, 1, 1),
(2, 1, 3, 2, 2),
(3, 2, 4, 3, 3),
(4, 2, 2, 4, 4),
(5, 3, 6, 5, 5),
(6, 3, 3, 6, 6),
(7, 4, 7, 7, 7),
(8, 4, 4, 8, 8),
(9, 5, 8, 9, 9),
(10, 5, 2, 10, 10),
(11, 6, 5, 1, 2),
(12, 6, 3, 2, 3),
(13, 7, 6, 3, 4),
(14, 7, 4, 4, 5),
(15, 8, 8, 5, 6),
(16, 8, 2, 6, 7),
(17, 9, 7, 7, 8),
(18, 9, 4, 8, 9),
(19, 10, 5, 9, 10),
(20, 10, 3, 10, 1),
(21, 11, 6, 1, 2),
(22, 11, 4, 2, 3),
(23, 12, 8, 3, 4),
(24, 12, 2, 4, 5),
(25, 13, 5, 5, 6),
(26, 13, 3, 6, 7),
(27, 14, 6, 7, 8),
(28, 14, 4, 8, 9),
(29, 15, 7, 9, 10),
(30, 15, 3, 10, 1),
(31, 16, 8, 1, 2),
(32, 16, 2, 2, 3),
(33, 17, 5, 3, 4),
(34, 17, 4, 4, 5),
(35, 18, 6, 5, 6),
(36, 18, 3, 6, 7),
(37, 19, 7, 7, 8),
(38, 19, 2, 8, 9),
(39, 20, 8, 9, 10),
(40, 20, 5, 10, 1),
(41, 21, 6, 1, 2),
(42, 21, 4, 2, 3),
(43, 22, 7, 3, 4),
(44, 22, 2, 4, 5),
(45, 23, 5, 5, 6),
(46, 23, 3, 6, 7),
(47, 24, 6, 7, 8),
(48, 24, 4, 8, 9),
(49, 25, 7, 9, 10),
(50, 25, 2, 10, 1);



    




