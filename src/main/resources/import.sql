INSERT INTO clientes (id, nombre, apellido, forma_pago, creado_en, modificado_en) VALUES (1, 'Diego', 'luna', 'debito', NULL, NULL), (2, 'John ', 'Doe', 'credito', NULL, NULL),(3, 'Carlos', 'luna', 'paypal', NULL, NULL),(4, 'Paola', 'Meza', 'debito', NULL, NULL),(5, 'Rosy', 'luna', 'debito', NULL, NULL),(6, 'Luis', 'carbajal', 'credito', NULL, NULL),(8, 'Laura', 'Mena', 'paypal', NULL, NULL),(11, 'Diego', 'Rios', 'paypal', NULL, NULL),(12, 'Luz', 'Martinez', 'debito', NULL, NULL),(13, 'Omar', 'Valdez', 'debito', '2024-07-31 16:02:20', '2024-07-31 16:02:41');
INSERT INTO alumnos (id,nombre,apellido) VALUES (1,'Diego', 'Luna'),(2,'Jair', 'Luna');
INSERT INTO cursos (id,titulo,profesor) VALUES (1,'Python','Diego'),(2,'Java','Alex');
INSERT INTO direcciones (calle,numero) VALUES ('vaticano',123), ('carl',1233);
INSERT INTO tbl_clientes_direcciones (id_cliente,id_direccion) VALUES (1,1), (2,2);
INSERT INTO clientes_detalles (prime, puntos_acumulados, cliente_detalle_id) VALUES (1,5000,1);
INSERT INTO tbl_alumnos_cursos (alumno_id,curso_id) VALUES (1,1), (1,2);
