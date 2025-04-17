CREATE TABLE usuarios 
(
    id VARCHAR(50) PRIMARY KEY,
    nombre_completo VARCHAR(50) NOT NULL,
    correo VARCHAR(50) UNIQUE NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    rol TEXT CHECK (rol IN ('estudiante', 'profesor', 'administrador')) NOT NULL
);

CREATE TABLE grupos_semestrales 
(
    id VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    profesor_id VARCHAR(50) NOT NULL,
    materia VARCHAR(255) NOT NULL,
    descripcion VARCHAR(1000),
    semestre VARCHAR(10) NOT NULL,
    FOREIGN KEY (profesor_id) REFERENCES usuarios(id)
);

CREATE TABLE proyectos 
(
    id VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(1000) NOT NULL,
    creado_por VARCHAR(50) NOT NULL,
    FOREIGN KEY (creado_por) REFERENCES usuarios(id)
);

CREATE TABLE proyectos_grupos 
(
    proyecto_id VARCHAR(50) NOT NULL,
    grupo_id VARCHAR(50) NOT NULL,
    PRIMARY KEY (proyecto_id, grupo_id),
    FOREIGN KEY (proyecto_id) REFERENCES proyectos(id), 
    FOREIGN KEY (grupo_id) REFERENCES grupos_semestrales(id) 
);

CREATE TABLE epicas 
(
    id VARCHAR(50) PRIMARY KEY,
    proyecto_id VARCHAR(50) NOT NULL,
    descripcion VARCHAR(1000) NOT NULL,
    FOREIGN KEY (proyecto_id) REFERENCES proyectos(id)
);

CREATE TABLE features 
(
    id VARCHAR(50) PRIMARY KEY,
    epica_id VARCHAR(50) NOT NULL,
    descripcion VARCHAR(1000) NOT NULL,
    FOREIGN KEY (epica_id) REFERENCES epicas(id) 
);

CREATE TABLE backlog_items
(
    id VARCHAR(50) PRIMARY KEY,
    feature_id VARCHAR(50) NOT NULL,
    descripcion VARCHAR(1000) NOT NULL,
    puntos_esfuerzo INT NOT NULL CHECK (puntos_esfuerzo >= 0),
    FOREIGN KEY (feature_id) REFERENCES features(id) 
);

CREATE TABLE calificaciones_proyectos 
(
    id VARCHAR(50) PRIMARY KEY,
    estudiante_id VARCHAR(50) NOT NULL,
    proyecto_id VARCHAR(50) NOT NULL,
    calificacion DECIMAL(5,2) NOT NULL CHECK (calificacion >= 0 AND calificacion <= 5),
    comentario VARCHAR(1000),
    fecha_calificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (estudiante_id) REFERENCES usuarios(id),
    FOREIGN KEY (proyecto_id) REFERENCES proyectos(id)
);

INSERT INTO usuarios (id, nombre_completo, correo, username, password, rol)
VALUES ('E001', 'Ana Martínez', 'ana.martinez@example.com', 'ana_est', '12345', 'estudiante');

INSERT INTO usuarios (id, nombre_completo, correo, username, password, rol)
VALUES ('P001', 'Carlos Pérez', 'carlos.perez@example.com', 'carlos_prof', '12345', 'profesor');

INSERT INTO usuarios (id, nombre_completo, correo, username, password, rol)
VALUES ('A001', 'Laura Gómez', 'laura.gomez@example.com', 'laura_admin', '12345', 'administrador');

SELECT * FROM usuarios;

INSERT INTO proyectos (id, nombre, descripcion, creado_por)
VALUES ('PR001', 'Sistema de Gestión Escolar', 'Desarrollar un sistema para gestionar estudiantes, profesores y calificaciones usando SCRUM.', 'P001');

SELECT * FROM proyectos;



INSERT INTO grupos_semestrales (id, nombre, profesor_id, materia, descripcion, semestre)
VALUES 
('GS001', 'Grupo Ingeniería Software I', 'P001', 'Ingeniería de Software', 'Grupo enfocado en fundamentos de ingeniería de software.', '2025-1');

INSERT INTO grupos_semestrales (id, nombre, profesor_id, materia, descripcion, semestre)
VALUES 
('GS002', 'Grupo Redes Avanzadas', 'E001', 'Redes de Computadoras', 'Estudio avanzado sobre redes y protocolos.', '2025-1');

INSERT INTO grupos_semestrales (id, nombre, profesor_id, materia, descripcion, semestre)
VALUES 
('GS003', 'Grupo Seguridad Informática', '230221012', 'Ciberseguridad', 'Grupo centrado en prácticas de seguridad y hacking ético.', '2025-2');

SELECT * FROM grupos_semestrales;


