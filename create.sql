CREATE TABLE IF NOT EXISTS odontologo(
    numero_matricula INT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50)
);



DELETE FROM odontologo;

INSERT INTO odontologo(numero_matricula, nombre, apellido) VALUES(1, 'Dr', 'Muelas');
INSERT INTO odontologo(numero_matricula, nombre, apellido) VALUES(2, 'Dr', 'Ogas');