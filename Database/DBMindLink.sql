 
/*
Drop database dbMindLink
go 

*/

Create database dbMindLink
go

Use dbMindLink
go


Create table TbArticulos(
IDArticulo int identity(1,1) primary key,
Titulo varchar(70) not null,
Descripcion varchar(400),
Imagen image,
Fecha date,
IDTerapeuta int
);

Create Table TbTerapeutas(
IDTerapeuta int identity(1,1) primary key,
Nombre varchar(90),
Apellido varchar(90),
Salario varbinary(max),
FNacimiento date,
DUI varchar(20),
IDTipoUsuario int,
IDActividadLaboral int,
IDGenero int,
IDClinica varchar(5),
IDUsuario int
);
create table TbCantidadArticulo(
IDCantArticulo int identity (1,1) primary key,
cantArticulo int,
IDTerapeuta INT,
IDArticulo int
);
Create table TbAnuncio(
IDAnuncio int identity(1,1) primary key,
Titulo nvarchar(70),
Descripcion varchar(400),
Imagen image,
Fecha date,
IDSecretaria int,
IDAdministrador int
);
ALTER TABLE TbAnuncio
DROP COLUMN Imagen;

SELECT * FROM TbAnuncio;

ALTER TABLE TbAnuncio 
ADD Imagen varbinary(max);
Create table TbIncapacidades(
IDIncapacidad int identity(1,1) primary key,
Fecha date,
Mensaje varchar(1000),
IDTerapeuta int,
IDSecretaria int,
IDAdministrador int
);
Create table TbEstadisticas(
IDEstadistica int identity(1,1) primary key,
IDCita int,
IDClinica varchar(5)
);
Create table TbPruebas(
IDPrueba int identity(1,1) primary key,
Titulo nvarchar(100)not null,
Descripcion varchar(800),
Precio money not null,
NumPruebas int,
IDTerapeuta int,
IDSecretaria int,
IDAdministrador int
);
Create table TbRespuestas(
IDRespuesta int identity(1,1) primary key,
IDOpcion int,
IDPregunta int
);
Create table TbPreguntas(
IDPregunta int identity(1,1) primary key,
Pregunta varchar(300) not null,
IDPrueba int
);
Create table TbOpciones(
IDOpcion int identity(1,1) primary key,
Opcion varchar(30),
ValorOpcion int,
IDPregunta int
);
Create table TbLlaves(
IDLlave int identity(1,1) primary key,
Llave nvarchar(10) unique,
Fecha Date,
IDPrueba int
);
Create table TbResultados(
IDResultados int identity(1,1) primary key,
Resultados varchar(400),
IDPrueba int
);
Create table TbCitas(
IDCitas int identity(1,1) primary key,
Fecha date not null,
IDTerapeuta int,
IDSecretaria int,
IDPaciente int
);
Alter Table TbCitas
ADD Hora VARCHAR(8);

Create table TbClinicas(
IDClinica Varchar(5) primary key,
NombreClinica varchar(300),
Ubicacion Varchar(1000), 
Dueño nvarchar(100),
Descripcion varchar(400),
Logo image
);
Create table TbUsuarios(
IDUsuario int identity(1,1) primary key,
UserName varchar(50) unique,
Contraseña varbinary(64),
FotoPerfil image,
IDContacto int
);
UPDATE TbUsuarios SET FotoPerfil = ? WHERE IDUsuario = ?
CREATE table TbContactos(
IDContacto int identity(1,1) primary key,
Correo varchar(300),
NumTelefonico varchar(14)
);
Create table TbGenero(
IDGenero int identity(1,1) primary key,
Genero int
);
Create table TbActividadesLaborales(
IDActividadLaboral int identity(1,1) primary key,
NombreDeActividad varchar(50)
);
Create Table TbTerapeutas(
IDTerapeuta int identity(1,1) primary key,
Nombre varchar(90),
Apellido varchar(90),
Salario varbinary(max),
FNacimiento date,
DUI varchar(20),
IDTipoUsuario int,
IDActividadLaboral int,
IDGenero int,
IDClinica varchar(5),
IDUsuario int
);
Create Table TbSecretaria(
IDSecretaria int identity(1,1) primary key,
Nombre varchar(90),
Apellido varchar(90),
Salario varbinary(max),
FNacimiento date,
DUI varchar(20),
IDTipoUsuario int,
IDActividadLaboral int,
IDGenero int,
IDClinica varchar(5),
IDUsuario int
);
Create Table TbAdministrador(
IDAdministrador int identity(1,1) primary key,
Nombre varchar(90),
Apellido varchar(90),
FNacimiento date,
DUI varchar(20),
IDTipoUsuario int,
IDGenero int,
IDClinica varchar(5),
IDUsuario int
);

Create Table TbPacientes(
IDPaciente int identity(1,1) primary key,
Nombre varchar(90),
Apellido varchar(90),
FNacimiento date,
DUI varchar(20),
IDTipoUsuario int,
IDGenero int,
IDClinica Varchar(5),
IDUsuario int
);

Create Table TbTipoUsuarios(
IDTipoUsuario int identity(1,1) primary key,
Cargo varchar(60),
);
Create Table TbAgendasPersonales(
IDAgendaPersonal int identity(1,1) primary key,
Contenido varchar(max),
Fecha date,
IDPaciente int
);

Create Table TbExpedientes(
IDExpediente int identity(1,1) primary key,
Contenido varchar(max),
Fecha date,
IDPaciente int,
IDTerapeuta int
);
Create Table TbComentarios(
IDComentario int identity(1,1) primary key,
Mensaje varchar(1000),
Fecha date,
IDPaciente int
);
Create Table TbRecetasMedicas(
IDReceta int identity(1,1) primary key,
Padecimiento varchar(200),
Descripcion varchar(900),
NombreMedicamento varchar(500),
IDPaciente int,
IDClinica Varchar(5),
IDMedicamento int
);

Create Table TbPermisos(
IDPermiso int identity(1,1) primary key,
Asunto VARCHAR(100), 
Contenido VARCHAR(900),
aceptado int, 
IDClinica int, 
IDSecretaria int, 
IDTerpeuta int
);

create table TbContPermisos(
IDContPermiso int identity (1,1) primary key,
nombre varchar(50),
contAceptado int,
IDPermiso int,
IDUsuario int
);	
ALTER TABLE TbContPermisos
ADD IDUsuario int;


SELECT * FROM TbContPermisos;
--Aqui elimino o agrego campos que necesito
ALTER TABLE TbCantidadArticulo
ADD IDSecretaria int;

ALTER TABLE TbArticulos
DROP COLUMN Imagen;

ALTER TABLE TbArticulos 
ADD Imagen varbinary(max);

ALTER TABLE TbArticulos
DROP COLUMN Descripcion;

ALTER TABLE TbArticulos 
ADD Descripcion VARCHAR(max);

ALTER TABLE TbPermisos
ALTER COLUMN IDClinica VARCHAR(5);
ALTER TABLE TbAdministrador

add IDActividadLaboral int;
ALTER TABLE TbPacientes
add MensajesDeCariño VARCHAR(300);

ALTER TABLE TbUsuarios
ADD Primeruso int;

ALTER TABLE TbUsuarios
DROP COLUMN FotoPerfil;

ALTER TABLE TbUsuarios 
ADD FotoPerfil varbinary(max);
Insert into TbContPermisos (nombre, contAceptado)
values
	('Exequiel',4),
	('Chris',3),
	('Rebeca',10),
	('Juan',12),
	('Dios',14);


SELECT * FROM TbUsuarios;
SELECT * FROM TbAdministrador;
--Datos --
Insert into TbRecetasMedicas (Padecimiento, Descripcion, NombreMedicamento)
Values
	('Trastornos de ansiedad', 'Cada 8 hora', 'Sertralina y Escitalopram'),
	('Depresión', 'Cada 8 horas','Escitalopram'),
	('Trastornos bipolares', 'Cada 8 hora','Litio'),
	('Trastornos alimentarios', 'Cada 8 hora','Fluoxetina'),
	('Trastorno del espectro autista ', 'Cada 12 horas','Risperidona'),
	('Trastornos de personalidad', 'Cada 8 hora','Sertralina y Escitalopram'),
	('Trastornos del sueño', 'Antes de dormir','Zolpidem'),
	('Trastorno por déficit de atención e hiperactividad', 'Cada 12 horas','Metilfenidato  y Haloperidol '),
	('Trastorno de estrés postraumático', 'Cada 12 horas','Paroxetina '),
	('Trastorno de ansiedad social', 'Cada 12 horas','Paroxetina '),
	('Problemas de sueño', 'Antes de dormir','Eszopiclona y Trazodona ');
	

--Datos --
INSERT INTO TbTerapeutas (Nombre, Apellido, FNacimiento, DUI)
VALUES
    ('Juan', 'Pérez', '1990-01-15', '12345678-9'),
    ('María', 'Gómez', '1985-05-20', '98765432-1'),
    ('Carlos', 'López', '1988-09-10', '87654321-0'),
    ('Ana', 'Martínez', '1992-03-25', '76543210-2'),
    ('Luis', 'Hernández', '1980-07-12', '65432109-3'),
    ('Laura', 'Ramírez', '1995-11-30', '54321098-4'),
    ('Pedro', 'Sánchez', '1987-04-05', '43210987-5'),
    ('Rosa', 'Torres', '1993-08-08', '32109876-6'),
    ('Manuel', 'García', '1986-02-18', '21098765-7'),
    ('Sofía', 'Díaz', '1998-12-03', '10987654-8');

--Datos--
INSERT INTO TbSecretaria (Nombre, Apellido, FNacimiento, DUI)
VALUES
    ('Isabel', 'Gutiérrez', '1991-06-14', '13579246-0'),
    ('Andrés', 'Fernández', '1984-02-27', '98765432-1'),
    ('Lucía', 'Rodríguez', '1989-09-05', '56789012-3'),
    ('Diego', 'Pérez', '1994-03-10', '43210987-6'),
    ('Valentina', 'López', '1987-07-22', '87654321-5'),
    ('Mariano', 'Martínez', '1990-12-18', '76543210-4'),
    ('Catalina', 'Hernández', '1983-11-28', '21098765-9'),
    ('Eduardo', 'Ramírez', '1996-08-07', '65432109-2'),
    ('Fernanda', 'Sánchez', '1993-04-09', '34567890-7'),
    ('Joaquín', 'García', '1988-01-03', '98712345-1');



--DATOS--
INSERT INTO TbPruebas (Titulo, Descripcion, Precio, NumPruebas)
VALUES
	('Prueba de Estrés','Ver niveles de estrés',55.00,7),
	('Prueba de Autoestima','Evaluación de la autoestima del paciente',40.00,16),
	('Evaluación de Trauma','Análisis de experiencias traumáticas',65.00, 5),
	('Habilidades Sociales','Evaluación de habilidades de comunicación',50.00,20),
	('Evaluación de Parejas','Análisis de relaciones de pareja',80.00, 12),
	('Prueba de TDAH','Evaluación de TDH',70.00,15),
	('Estrategias de Afrontamiento','Afrontamiento al estrés',70.00,8),
	('Prueba de Ansiedad Social','Evaluación de ansiedad social',55.00,4),
	('Habilidades Cognitivas','Análisis de habilidades cognitivas',60.00,10),
	('Prueba de Sueño','Evaluación de patrones de sueño',75.00,13);


-- Aquí empiezan los unique's para que existan valores nulos repeditos en caso que el usuario no llene una de las preguntas de algun formulario
CREATE UNIQUE INDEX TbCont_Correo1 ON TbContactos (Correo)
WHERE Correo IS NOT NULL AND Correo != '';

CREATE UNIQUE INDEX TbCont_NumTelefonico1 ON TbContactos (NumTelefonico)
WHERE NumTelefonico IS NOT NULL AND NumTelefonico != '';

CREATE UNIQUE INDEX TbAdministrador_DUI1 ON TbAdministrador (DUI)
WHERE DUI IS NOT NULL AND DUI != '';

CREATE UNIQUE INDEX TbPacientes_DUI1 ON TbPacientes (DUI)
WHERE DUI IS NOT NULL AND DUI != '';

CREATE UNIQUE INDEX TbSecretaria_DUI1 ON TbSecretaria (DUI)
WHERE DUI IS NOT NULL AND DUI != '';

CREATE UNIQUE INDEX TbTerapeutas_DUI1 ON TbTerapeutas (DUI)
WHERE DUI IS NOT NULL AND DUI != '';
--Insert into TbAdministrador 
--Select * from TbMedicamentos

Alter table TbArticulos Add constraint fk_IDTerapeuta_TBArt
Foreign key (IDTerapeuta) References TbTerapeutas(IDTerapeuta);

Alter table TbAnuncio Add constraint fk_IDSecretaria_TbAnun
Foreign key (IDSecretaria) References TbSecretaria(IDSecretaria);

Alter table TbCantidadArticulo Add constraint fk_IDTerapeuta_TBCantArt
Foreign key (IDTerapeuta) References TbTerapeutas(IDTerapeuta);

Alter table TbCantidadArticulo Add constraint fk_IDArticulo_TBCantArt
Foreign key (IDArticulo) References TbArticulos(IDArticulo);

alter table TbContPermisos add constraint fk_idpermiso_contpermi
foreign key (IDPermiso) references TbPermisos(IDPermiso);

Alter table TbAnuncio Add constraint fk_IDAdministrador_TbAnun
Foreign key (IDAdministrador) References TbAdministrador(IDAdministrador);

Alter table TbIncapacidades Add constraint fk_IDTerapeuta_TbIncap
Foreign key (IDTerapeuta) References TbTerapeutas(IDTerapeuta);

Alter table TbIncapacidades Add constraint fk_IDSecretaria_TbIncap
Foreign key (IDSecretaria) References TbSecretaria(IDSecretaria);

Alter table TbIncapacidades Add constraint fk_IDAdministrador_TbIncap
Foreign key (IDAdministrador) References TbAdministrador(IDAdministrador);

Alter table TbEstadisticas Add constraint fk_IDCita_TbEstad
Foreign key (IDCita) References TbCitas(IDCitas);

Alter table TbEstadisticas Add constraint fk_IDClinica_TbClin
Foreign key (IDClinica) References TbClinicas(IDClinica);

Alter table TbPruebas Add constraint fk_IDTerapeuta_TbPrue
Foreign key (IDTerapeuta) References TbTerapeutas(IDTerapeuta);

Alter table TbPruebas Add constraint fk_IDSecretaria_TbPrue
Foreign key (IDSecretaria) References TbSecretaria(IDSecretaria);

Alter table TbPruebas Add constraint fk_IDAdministrador_TbPrue
Foreign key (IDAdministrador) References TbAdministrador(IDAdministrador);

Alter table TbRespuestas Add constraint fk_IDOpcion_TbResp
Foreign key (IDOpcion) References TbOpciones(IDOpcion);

Alter table TbRespuestas Add constraint fk_IDPregunta_TbResp
Foreign key (IDPregunta) References TbPreguntas(IDPregunta);

Alter table TbPreguntas Add constraint fk_IDPregunta_TbPreg
Foreign key (IDPrueba) References TbPruebas(IDPrueba);

Alter table TbOpciones Add constraint fk_IDPregunta_TbOpci
Foreign key (IDPregunta) References TbPreguntas(IDPregunta);

Alter table TbLlaves Add constraint fk_IDPrueba_TBLlav
Foreign key (IDPrueba) References TbPruebas(IDPrueba);
/*
Hasta aquí good
*/
Alter table TbResultados Add constraint fk_IDPrueba_TbResul
Foreign key (IDPrueba) References TbPruebas(IDPrueba);

Alter table TbCitas Add constraint fk_IDSecretaria_TbCit
Foreign key (IDSecretaria) References TbSecretaria(IDSecretaria);

Alter table TbCitas Add constraint fk_IDTerapeuta_TbCit
Foreign key (IDTerapeuta) References TbTerapeutas(IDTerapeuta);

Alter table TbCitas Add constraint fk_IDPaciente_TbCit
Foreign key (IDPaciente) References TbPacientes(IDPaciente);

Alter table TbUsuarios Add constraint fk_IDContacto_TbUsuar
Foreign key (IDContacto) References TbContactos(IDContacto);
/*
Hasta aqui good
*/
Alter table TbTerapeutas Add constraint fk_IDTipoUsuarios_TbTerape
Foreign key (IDTipoUsuario) References TbTipoUsuarios(IDTipoUsuario);

Alter table TbTerapeutas Add constraint fk_IDActividadLaboral_TbTerape
Foreign key (IDActividadLaboral) References TbActividadesLaborales(IDActividadLaboral);

Alter table TbTerapeutas Add constraint fk_IDGenero_TbTerape
Foreign key (IDGenero) References TbGenero(IDGenero);

Alter table TbTerapeutas Add constraint fk_IDClinica_TbTerape
Foreign key (IDClinica) References TbClinicas(IDClinica);

Alter table TbTerapeutas Add constraint fk_IDUsuario_TbTerape
Foreign key (IDUsuario) References TbUsuarios(IDUsuario);

Alter table TbSecretaria Add constraint fk_IDTipoUsuarios_TbSecret
Foreign key (IDTipoUsuario) References TbTipoUsuarios(IDTipoUsuario);

Alter table TbSecretaria Add constraint fk_IDActividadLaboral_TbSecret
Foreign key (IDActividadLaboral) References TbActividadesLaborales(IDActividadLaboral);

Alter table TbSecretaria Add constraint fk_IDGenero_TbSecret
Foreign key (IDGenero) References TbGenero(IDGenero);

Alter table TbSecretaria Add constraint fk_IDSecretaria_TbSecret
Foreign key (IDClinica) References TbClinicas(IDClinica);

Alter table TbSecretaria Add constraint fk_IDUsuario_TbSecret
Foreign key (IDUsuario) References TbUsuarios(IDUsuario);

Alter table TbAdministrador Add constraint fk_IDTipoUsuario_TbAdmin
Foreign key (IDTipoUsuario) References TbTipoUsuarios(IDTipoUsuario);

Alter table TbAdministrador Add constraint fk_IDGenero_TbAdmin
Foreign key (IDGenero) References TbGenero(IDGenero);

Alter table TbAdministrador Add constraint fk_IDClinica_TbAdmin
Foreign key (IDClinica) References TbClinicas(IDClinica);

Alter table TbAdministrador Add constraint fk_IDUsuario_TbAdmin
Foreign key (IDUsuario) References TbUsuarios(IDUsuario);

Alter table TbAdministrador Add constraint fk_IDActividadLaboral_TbAdmin
Foreign key (IDActividadLaboral) References TbActividadesLaborales(IDActividadLaboral);

Alter table TbPacientes Add constraint fk_IDTipoUsuario_TbPacie
Foreign key (IDTipoUsuario) References TbTipoUsuarios(IDTipoUsuario);

Alter table TbPacientes Add constraint fk_IDGenero_TbPacie
Foreign key (IDGenero) References TbGenero(IDGenero);

Alter table TbPacientes Add constraint fk_IDClinica_TbPacie
Foreign key (IDClinica) References TbClinicas(IDClinica);

Alter table TbPacientes Add constraint fk_IDUsuario_TbPacie
Foreign key (IDUsuario) References TbUsuarios(IDUsuario);

Alter table TbAgendasPersonales Add constraint fk_IDPaciente_TbAgen
Foreign key (IDPaciente) References TbPacientes(IDPaciente);

Alter table TbExpedientes Add constraint fk_IDPaciente_TbExpe
Foreign key (IDPaciente) References TbPacientes(IDPaciente);

Alter table TbExpedientes Add constraint fk_IDTerapeuta_TbExpe
Foreign key (IDTerapeuta) References TbTerapeutas(IDTerapeuta);

Alter table TbComentarios Add constraint fk_IDPaciente_TBComen
Foreign key (IDPaciente) References TbPacientes(IDPaciente);

Alter table TbRecetasMedicas Add constraint fk_IDPaciente_TBRecet
Foreign key (IDPaciente) References TbPacientes(IDPaciente);

Alter table TbRecetasMedicas Add constraint fk_IDClinica_TbRecet
Foreign key (IDClinica) References TbClinicas(IDClinica);

Alter table TbRecetasMedicas Add constraint fk_IDMedicamentos_Medica
Foreign key (IDMedicamento) References TbMedicamentos(IDMedicamento);

SELECT * FROM TbClinicas;
/*
Ya esta bien aaaa
Lo de abajo lo agregué jejeje para los foreignkey
*/

ALTER TABLE TbPermisos Add constraint fk_IDclinica_Permisos
Foreign key (IDClinica) references TbClinicas(IDClinica);

ALTER TABLE TbPermisos Add constraint fk_IDSecretaria_Permiso
Foreign key (IDSecretaria) references TbSecretaria(IDSecretaria);

ALTER TABLE TbPermisos Add constraint fk_IDTerpeuta_Permiso
Foreign key (IDTerpeuta) references TbTerapeutas(IDTerapeuta);

alter table TbContPermisos add constraint fk_idpermiso_contpermi
foreign key (IDPermiso) references TbPermisos(IDPermiso);

alter table TbContPermisos add constraint fk_iduser_contpermi
foreign key (IDUsuario) references TbUsuarios(IDUsuario);
/*
Aqui empieza lo de cascade on delete
*/

ALTER TABLE TbIncapacidades
ADD CONSTRAINT fk_IDTerapeuta_TbIncap1
FOREIGN KEY (IDTerapeuta)
REFERENCES TbTerapeutas(IDTerapeuta)
ON DELETE CASCADE;

-- Para la restricción fk_IDSecretaria_TbIncap
ALTER TABLE TbIncapacidades
ADD CONSTRAINT fk_IDSecretaria_TbIncap1
FOREIGN KEY (IDSecretaria)
REFERENCES TbSecretaria(IDSecretaria)
ON DELETE CASCADE;

-- Para la restricción fk_IDAdministrador_TbIncap
ALTER TABLE TbIncapacidades
ADD CONSTRAINT fk_IDAdministrador_TbIncap1
FOREIGN KEY (IDAdministrador)
REFERENCES TbAdministrador(IDAdministrador)
ON DELETE CASCADE;


-- Para la restricción fk_IDSecretaria_TbAnun
ALTER TABLE TbAnuncio
ADD CONSTRAINT fk_IDSecretaria_TbAnun1
FOREIGN KEY (IDSecretaria)
REFERENCES TbSecretaria(IDSecretaria)
ON DELETE CASCADE;

-- Para la restricción fk_IDAdministrador_TbAnun
ALTER TABLE TbAnuncio
ADD CONSTRAINT fk_IDAdministrador_TbAnun1
FOREIGN KEY (IDAdministrador)
REFERENCES TbAdministrador(IDAdministrador)
ON DELETE CASCADE;

ALTER TABLE TbPermisos
ADD CONSTRAINT fk_IDClinica_Permisos1
FOREIGN KEY (IDClinica)
REFERENCES TbClinicas(IDClinica)
ON DELETE CASCADE;

ALTER TABLE TbPreguntas
ADD CONSTRAINT fk_IDPrueba_TbPreg1
FOREIGN KEY (IDPrueba)
REFERENCES TbPruebas(IDPrueba)
ON DELETE CASCADE;

ALTER TABLE TbCantidadArticulo
ADD CONSTRAINT FK_TbCantidadArticulo_TbArticulos
FOREIGN KEY (IDArticulo)
REFERENCES TbArticulos (IDArticulo);

Alter table TbCantidadArticulo Add constraint fk_IDTerapeuta_TBCantArt
Foreign key (IDTerapeuta) References [dbo].[TbTerapeutas](IDTerapeuta);

Alter table TbCantidadArticulo Add constraint fk_IDScretaria_TBCantArt
Foreign key (IDSecretaria) References [dbo].TbSecretaria(IDSecretaria);
/*
Desde aquí comienzan los procesos almacenados
*/
CREATE PROCEDURE PDRegistrarAdmin
    @nombreTbA VARCHAR(90),
    @UsernameTbU VARCHAR(50),
    @ContraseñaTbU VARCHAR(90),
	@IdTbCli VARCHAR(5)
AS
BEGIN

    -- Insertar datos en la tabla TbClinicas si no existe
    IF NOT EXISTS (SELECT 1 FROM TbClinicas WHERE IDClinica = @IdTbCli)
    BEGIN
        INSERT INTO TbClinicas (IDClinica)
        VALUES (@IdTbCli)
    END

    -- Insertar datos en la tabla TbUsuarios si no existe
    IF NOT EXISTS (SELECT 1 FROM TbUsuarios WHERE UserName = @UsernameTbU)
    BEGIN
	-- Con esto declaramos la variable que contendra el Hash
		DECLARE @HashContraseñaTbU VARBINARY (64);
		DECLARE @newHash VARBINARY(64);
		SET @HashContraseñaTbU = HASHBYTES('SHA2_256', @ContraseñaTbU);
		SET @newHash = HASHBYTES('SHA2_256', @HashContraseñaTbU);
    -- Con las dos lineas de abajo mandamos a almacenar el Username y la contraseña con Hash
		INSERT INTO TbUsuarios (Username, Contraseña, Primeruso)
        VALUES (@UsernameTbU, @newHash, 1)
    END
	-- Obtener el IDUsuario basado en el Username
    DECLARE @IDUsuario INT
    SET @IDUsuario = (SELECT IDUsuario FROM TbUsuarios WHERE Username = @UsernameTbU)
	-- Insertar datos en la tabla TbAdministrador
    INSERT INTO TbAdministrador (Nombre, IDClinica, IDUsuario)
    VALUES (@nombreTbA, @IdTbCli, @IDUsuario)

END

EXEC PDRegistrarAdmin 'Eduardo René', 'Guayito', 'Contraseña', '52281'
EXEC PDRegistrarAdmin 'Orlando', 'Pepito', 'Contraseña', '52281'
EXEC PDRegistrarAdmin 'Brian', 'Bryan', 'Contraseña', '001291'
EXEC PDRegistrarAdmin 'Juanpepe', 'dios', 'Contraseña', '98389'
/* esto es para comprobar que el PDResgistrarAdmin funciona jejeje
Drop Procedure PDRegistrarAdmin

INSERT INTO TbContactos Values ('Guayito.palom0@gmail.com', '69839847')
SELECT * FRom TbContactos
SELECT * FROM TbUsuarios
SELECT * FROM TbAdministrador;
INSERT INTO TbUsuarios IDContacto(1)
Delete TbAdministrador
Delete TbUsuarios
Delete TbClinicas
 
	esto es para reiniciar los PK en 0
DBCC CHECKIDENT ('TbUsuarios', RESEED, 0);
DBCC CHECKIDENT ('TbAdministrador', RESEED, 0);
DBCC CHECKIDENT ('TbClinicas', RESEED, 0);

Create table TbUsuarios(
IDUsuario int identity(1,1) primary key,
UserName varchar(50),
Contraseña varbinary(64),
FotoPerfil image,
IDContacto int
);
Select * from TbAdministrador
Select * from TbClinicas
Select * from TbUsuarios
Select * from TbSecretaria
Insert into TbUsuarios values ('JuanaGalindo', '');
Insert into TbSecretaria values ('Juana','','','','','');
*/

--Aqui empieza el proceso para logear todo tipo de usuario, admin, empleado, usuario

CREATE PROCEDURE PDLogear
    @UsernameIngresado VARCHAR(50),
    @ContraseñaIngresado VARCHAR(90),
    @abrirventana INT OUTPUT,
    @acceso INT OUTPUT
AS
BEGIN
    -- Agrega la declaración de la variable @resultado y @ventana aquí
	 DECLARE @ventana INT;
    DECLARE @resultado INT;
   

    -- Con esto declaramos las variables para el control del nivel de usuario
    DECLARE @IDUsuario INT;
    DECLARE @username VARCHAR(50);
    DECLARE @AdminExist INT;
    DECLARE @SecretExist INT;
    DECLARE @TerapeExist INT;

    -- Con esto seleccionamos de cada tabla de cada nivel de usuario si existe un ID como el ingresado
    SET @IDUsuario = (SELECT TOP 1 IDUsuario FROM TbUsuarios WHERE Username = @UsernameIngresado);
	SET @username = (SELECT TOP 1 UserName FROM TbUsuarios WHERE IDUsuario = @IDUsuario);
	SET @AdminExist = (SELECT TOP 1 IDUsuario FROM TbAdministrador WHERE IDUsuario = @IDUsuario);
	SET @SecretExist = (SELECT TOP 1 IDUsuario FROM TbSecretaria WHERE IDUsuario = @IDUsuario);
	SET @TerapeExist = (SELECT TOP 1 IDUsuario FROM TbTerapeutas WHERE IDUsuario = @IDUsuario);


    IF (@username = @UsernameIngresado)
    BEGIN
	--SET @acceso = 1;
        -- Con esto declaramos la variable que contendrá el Hash
        DECLARE @Contraseñareal VARBINARY(64);
		DECLARE @HashContraseñaTbU VARBINARY(64);
		DECLARE @newHash VARBINARY(64);

        SET @HashContraseñaTbU = HASHBYTES('SHA2_256', @ContraseñaIngresado);
		SET @newHash = HASHBYTES('SHA2_256', @HashContraseñaTbU);
        SET @Contraseñareal = (SELECT Contraseña FROM TbUsuarios WHERE IDUsuario = @IDUsuario);
	--	PRINT @HashContraseñaTbU
		--PRINT @Contraseñareal
        -- Con las líneas de abajo, veremos si la contraseña mandada ya hasheada coincide con la registrada
        IF (@newHash = @Contraseñareal)
        BEGIN
		
            IF (@IDUsuario = @AdminExist)
            BEGIN
                SET @ventana = 1;
            END
            ELSE IF (@IDUsuario = @SecretExist)
            BEGIN
                SET @ventana = 2;
            END
            ELSE IF (@IDUsuario = @TerapeExist)
            BEGIN
                SET @ventana = 3;
            END
            ELSE
            BEGIN
                SET @ventana = 4;
            END
            SET @resultado = 1;
        END
        ELSE
        BEGIN
            SET @resultado = 0;
        END
    END
    ELSE
    BEGIN
        SET @resultado = 0;
        SET @ventana = 0; -- Asignación para el caso en que el username no coincida
    END

    SET @abrirventana = @ventana;
    SET @acceso = @resultado;
END




DECLARE @resultado INT;
DECLARE @ventana INT;
EXEC PDLogear 'Katelin', 'Contraseña', @ventana OUTPUT, @resultado OUTPUT;
SELECT @resultado AS acceso;
SELECT @ventana AS abrirventana;



select* from TbUsuarios
SELECT * FROM TbClinicas
select * from TbAdministrador

PRINT @resultado;

---Aqui comienza otro proceso, este es para registrar pacientes
/*
Esto es namas para comprobar que funciona el proceso
DECLARE @resultado INT;


*/

--Esto borra el proceso jejejeje
--DROP Procedure PDLogear
---
--- Aqui empieza el proceso de registrar pacientes

CREATE PROCEDURE PDRegistrarpaciente
    @nombreTbP VARCHAR(90),
	@apellidoTbp VARCHAR(90),
	@fechadenaci DATE,
	@IdTbCli VARCHAR(5),
    @UsernameTbU VARCHAR(50),
    @ContraseñaTbU VARCHAR(90),
	@Correo varchar(300)
AS
BEGIN
	DECLARE @clinica Varchar(5);
	SET @clinica = (SELECT IDClinica FROM TbClinicas WHERE IDClinica = @IdTbCli);
    -- Insertar datos en la tabla TbClinicas si existe
    IF (@clinica = @IdTbCli)
    BEGIN
         -- Insertar datos en la tabla TbUsuarios si no existe
		 IF NOT EXISTS (SELECT 1 FROM TbUsuarios WHERE UserName = @UsernameTbU)
			BEGIN
			-- Con esto declaramos la variable que contendra el Hash
			DECLARE @HashContraseñaTbU VARBINARY (64);
			DECLARE @newHash VARBINARY (64);
			SET @HashContraseñaTbU = HASHBYTES('SHA2_256', @ContraseñaTbU);
			SET @newHash = HASHBYTES('SHA2_256', @HashContraseñaTbU);
			INSERT INTO TbContactos (Correo)
			VALUES (@Correo)
			DECLARE @CorreoEle VARCHAR
			SET @CorreoEle = (SELECT IDContacto FROM TbContactos WHERE Correo = @Correo)
			-- Con las dos lineas de abajo mandamos a almacenar el Username y la contraseña con Hash
			INSERT INTO TbUsuarios (Username, Contraseña, IDContacto)
			VALUES (@UsernameTbU, @newHash, @CorreoEle)
		END
	-- Obtener el IDUsuario basado en el Username
		DECLARE @IDUsuario INT
		SET @IDUsuario = (SELECT IDUsuario FROM TbUsuarios WHERE Username = @UsernameTbU)
	-- Insertar datos en la tabla TbAdministrador
		
		INSERT INTO TbPacientes (Nombre, Apellido, FNacimiento, IDClinica, IDUsuario)
		VALUES (@nombreTbP, @apellidoTbp,@fechadenaci,@IdTbCli, @IDUsuario)
		END
		
END


EXEC PDRegistrarpaciente 'prueba','prueba1','9-10-2001','52281','pruba2','contraseña', 'JuanPabloFlamenco@gmail.com';
--Select * from TbContactos;
--Select * from TbUsuarios;
--Select * from TbClinicas;
--Select * from TbPacientes;
--DROP Procedure PDRegistrarpaciente

/*
Aqui empieza el proceso para Crear o actualizar un usuario de tipo empleado:
*/
CREATE PROCEDURE PDCrearActualizarUsuario
    @nombreUsuario VARCHAR(50),
    @contraseña VARCHAR(50)
AS
BEGIN
			DECLARE @HashContraseñaTbU VARBINARY (64);
			DECLARE @newHash VARBINARY (64);
			SET @HashContraseñaTbU = HASHBYTES('SHA2_256', @contraseña);
			SET @newHash = HASHBYTES('SHA2_256', @HashContraseñaTbU);
    -- Verificar si el usuario ya existe en la tabla
    IF EXISTS (SELECT 1 FROM dbo.TbUsuarios WHERE UserName = @nombreUsuario)
    BEGIN
        -- Actualizar la contraseña existente
        UPDATE dbo.TbUsuarios
        SET Contraseña = @newHash
        WHERE UserName = @nombreUsuario
    END
    ELSE
    BEGIN
        -- Insertar un nuevo registro
        INSERT INTO dbo.TbUsuarios (UserName, Contraseña)
        VALUES (@nombreUsuario, @newHash)
    END
END
/*
Esto nada más lo hice pa entender cómo se conecta un Foreign key a una registro existente
INSERT INTO TbContactos Values ('guayito.palom0@gmail.com','69839847')
INSERT INTO TbContactos Values ('juanpflapi@gmail.com', '8328932')
Select * from TbContactos
UPDATE TbUsuarios SET IDContacto = 3 WHERE UserName = 'Pepito'
SELECT * FROM TbUsuarios where UserName = 'Pepito'
SELECT * FROM TbPacientes 
SELECT * FROM TbUsuarios where UserName = 'Guayito'
use DbMindLink
EXEC PDCrearActualizarUsuario 'Guayito', 'Contraseña';
--- DROP Procedure PDCrearActualizarUsuario
*/

/*
El siguiente proceso es para solo ACTUALIZAR la contraseña de los usuarios basandonos en su correo electronico, más no crear usuarios, solo actualizar
Basicamente esta hecho para recuperacion de contraseña por medio del correo electronico
*/
CREATE PROCEDURE PDActualizarContraGmail
    @Correo VARCHAR(300),
    @contraseña VARCHAR(50)
AS
BEGIN
    -- Verificar si el usuario ya existe en la tabla
	
    IF EXISTS (SELECT 1 FROM dbo.TbContactos WHERE Correo = @Correo)
    BEGIN
	DECLARE @IDContacto INT;
	SET @IDContacto =  (SELECT IDContacto FROM TbContactos WHERE Correo = @Correo)
	DECLARE @IDUsuario INT;
	SET @IDUsuario = (SELECT IDUsuario FROM TbUsuarios WHERE IDContacto = @IDContacto)
        -- Actualizar la contraseña existente
		DECLARE @HashContraseñaTbU VARBINARY (64);
		DECLARE @newHash VARBINARY (64);
		SET @HashContraseñaTbU = HASHBYTES('SHA2_256', @contraseña);
		SET @newHash = HASHBYTES('SHA2_256', @HashContraseñaTbU);

        UPDATE dbo.TbUsuarios
		SET Contraseña = @newHash
        WHERE IDUsuario = @IDUsuario
    END
	ELSE 
	BEGIN
		PRINT 'ta equivocado'
	END
END

Exec PDActualizarContraGmail 'guayito.palom0@gmail.com', 'Melocoton';

SELECT * FROM TbContactos
print('0x6022F22F6F3B6F0DD4E78D178312CD14DB0DC43A0C6F30F188E1D5DC5BC62709');

/*
El siguiente ploceso es para cambiar la contraseña con el numero de telefono
*/
CREATE PROCEDURE PDActualizarContraNum
    @Num VARCHAR(50),
    @contraseña VARCHAR(50)
AS
BEGIN
    -- Verificar si el usuario ya existe en la tabla
	
    IF EXISTS (SELECT 1 FROM dbo.TbContactos WHERE NumTelefonico = @Num)
    BEGIN
	DECLARE @IDContacto INT;
	SET @IDContacto =  (SELECT IDContacto FROM TbContactos WHERE NumTelefonico = @Num)
	DECLARE @IDUsuario INT;
	SET @IDUsuario = (SELECT IDUsuario FROM TbUsuarios WHERE IDContacto = @IDContacto)
        -- Actualizar la contraseña existente
		DECLARE @HashContraseñaTbU VARBINARY (64);
		DECLARE @newHash VARBINARY (64);
		SET @HashContraseñaTbU = HASHBYTES('SHA2_256', @contraseña);
		SET @newHash = HASHBYTES('SHA2_256', @HashContraseñaTbU);

        UPDATE dbo.TbUsuarios
		SET Contraseña = @newHash
        WHERE IDUsuario = @IDUsuario
    END
	ELSE 
	BEGIN
		PRINT 'ta equivocado'
	END
END

EXEC PDActualizarContraNum '69839847','Papitaaaaa'

/*Este proceso es para devolver un valor 1 en caso de que el correo sea encontrado en la db
*/

CREATE PROCEDURE PdBuscarCorreo
	@Correo VARCHAR(300),
	@Correoexistente INT OUTPUT
	AS
	BEGIN
		DECLARE @CorreoExis INT;
		SET @CorreoExis = 0;
		IF EXISTS (SELECT 1 FROM dbo.TbContactos WHERE Correo = @Correo)
		BEGIN
			SET @CorreoExis = 1;
		END
	SET @Correoexistente = @CorreoExis

END

DECLARE @CorreoExis INT;
EXEC PdBuscarCorreo 'guayito.palom0@gmail.com', @CorreoExis OUTPUT;
SELECT @CorreoExis AS Correoexistente;

/*Este proceso es para devolver un valor 1 en caso de que el correo sea encontrado en la db
*/

CREATE PROCEDURE PdBuscarNum
	@Numero VARCHAR(300),
	@NumeroExistente INT OUTPUT
	AS
	BEGIN
		DECLARE @NumeroExis INT;
		SET @NumeroExis= 0;
		IF EXISTS (SELECT 1 FROM dbo.TbContactos WHERE NumTelefonico= @Numero)
		BEGIN
			SET @NumeroExis = 1;
		END
	SET @NumeroExistente = @NumeroExis

END

DECLARE @NumeroExis INT;
EXEC PdBuscarNum '69839847', @NumeroExis OUTPUT;
SELECT @NumeroExis AS NumeroExistente;

/*
Desde aquí comienzan las vistas

*/

/*
Procesos de Chris para Android:
*/
/*
Pantalla de notas:
Un proceso que almacene los datos 
ingresados en notas y una vista que muestre la 
nota que el usuario recien acaba de ingresar  
para que este se muestre en el sector de notas.
*/

/*
Creamos el procedimiento
*/

CREATE PROCEDURE PDInsertarAgendaPersonal(
    @Contenido varchar(100),  
	@username1 varchar(50)
)
AS
BEGIN
    SET NOCOUNT ON;
    DECLARE @FechaActual date = GETDATE();
	DECLARE @username VARCHAR(50);
	DECLARE @IDUsuario INT;
	DECLARE @PacienteExit INT;


	SET @IDUsuario = (SELECT IDUsuario FROM TbUsuarios WHERE Username = @username1);
	SET @PacienteExit = (SELECT IDPaciente FROM TbPacientes WHERE IDUsuario = @IDUsuario);

    INSERT INTO TbAgendasPersonales (Contenido, Fecha, IDPaciente )
    VALUES (@Contenido, @FechaActual, @PacienteExit);
END;


EXEC PDInsertarAgendaPersonal 'Contenido de la agenda', 'Pepito';


/*
Un proceso donde se pueda enviar datos a la base de datos
en la tabla correspondiente y hacer una vista donde se pueda
ver los comentarios que otros usarios ya habian mandado 
a la base de datos y tambien muestre el comentario que 
acaba de ingresar el usuario.
*/

CREATE PROCEDURE PDGuardarComentario
    @mensaje varchar(1000),
	@Username varchar (50)
AS
BEGIN
    DECLARE @fechaActual datetime
	DECLARE @IDUsuario INT;
	DECLARE @PacienteExit INT;

    SET @fechaActual = GETDATE()
	SET @IDUsuario = (SELECT IDUsuario FROM TbUsuarios WHERE Username = @Username);
	SET @PacienteExit = (SELECT IDPaciente FROM TbPacientes WHERE IDUsuario = @IDUsuario);
    INSERT INTO TbComentarios (Mensaje, Fecha, IDPaciente)
    VALUES (@mensaje, @fechaActual, @PacienteExit)
END

EXEC PDGuardarComentario 'Este es un comentario de ejemplo', 'Pepito';
--Se generaron 30 comentarios, investigar por qué

/*
Un proceso donde almacena los datos ingresados por 
el usuario y quede guardado en la base de datos en
la tabla correspondiente.
*/

--Creamos el procedimiento que guarde los datos

-- Crear el procedimiento almacenado para insertar datos del paciente
CREATE PROCEDURE PDInsertarAcercademi
(
    @username varchar(200),
    @Nombre varchar(90),
    @Apellido varchar(90),
    @FNacimiento date,
    @DUI varchar(20),
    @Correo varchar(300)
)
AS
BEGIN
    DECLARE @IDContacto int
    DECLARE @IDUsuario int

    -- Insertar en la tabla TbContactos y obtener el IDContacto
    INSERT INTO TbContactos (Correo)
    VALUES (@Correo)

    SET @IDContacto = SCOPE_IDENTITY();  -- Obtener el ID generado

    -- Verificar si el usuario existe
    SET @IDUsuario = (SELECT IDUsuario FROM TbUsuarios WHERE Username = @username);

    -- Insertar en la tabla TbPacientes utilizando el IDContacto obtenido
    INSERT INTO TbPacientes (Nombre, Apellido, FNacimiento, DUI, IDContacto)
    VALUES (@Nombre, @Apellido, @FNacimiento, @DUI, @IDContacto);

    -- Actualizar TbPacientes donde IDUsuario coincide con @IDUsuario
    UPDATE TbPacientes
    SET IDContacto = @IDContacto
    WHERE IDContacto IS NULL AND IDUsuario = @IDUsuario;

    -- Actualizar TbUsuarios donde IDUsuario coincide con @IDUsuario
    UPDATE TbUsuarios
    SET IDContacto = @IDContacto
    WHERE IDUsuario = @IDUsuario;
END

-- Ejecutar el procedimiento para insertar un paciente de ejemplo
EXEC PDInsertarAcercademi 'Pepito', 'Jose', 'Perez','2023-08-30', '1234-5677','correo@yajuuu.com';


----Creamos procedimiento alamcenado para acercademi Java---
CREATE PROCEDURE PDPrimerUso
    @username VARCHAR(200),
    @Correo VARCHAR(100),
    @ActividadLabor VARCHAR(90),
    @fechadeNaci DATE,
    @Numerotel VARCHAR(9),
    @DUI VARCHAR(20),
    @Genero INT
AS
BEGIN
    DECLARE @IDUsuario INT;
    DECLARE @IDContactos INT;
    DECLARE @IDActividad INT;
    DECLARE @IDGenero INT;

    -- Verificar si el usuario existe
    SET @IDUsuario = (SELECT IDUsuario FROM TbUsuarios WHERE Username = @username);

    -- Obtener el último valor de la clave primaria de TbContactos en base a IDUsuario si existe
    SET @IDContactos = (SELECT IDContacto FROM TbUsuarios WHERE IDUsuario = @IDUsuario);

    -- Si @IDContactos es NULL, entonces no existe un registro previo, insertar datos en la tabla TbContactos
    IF @IDContactos IS NULL
    BEGIN
        INSERT INTO TbContactos (Correo, NumTelefonico)
        VALUES (@Correo, @Numerotel);

        -- Obtener el último valor de la clave primaria de TbContactos
        SET @IDContactos = SCOPE_IDENTITY();

		UPDATE TbUsuarios SET IDContacto = @IDContactos WHERE IDUsuario = @IDUsuario;
    END
    ELSE
    BEGIN
        -- Si @IDContactos no es NULL, entonces actualizar los datos en la tabla TbContactos en función de @IDContactos
        UPDATE TbContactos
        SET Correo = @Correo,
            NumTelefonico = @Numerotel
        WHERE IDContacto = @IDContactos;
    END

    -- Insertar datos en la tabla TbActividadesLaborales
    INSERT INTO TbActividadesLaborales (NombreDeActividad)
    VALUES (@ActividadLabor);

    -- Obtener el último valor de la clave primaria de TbActividadesLaborales
    SET @IDActividad = SCOPE_IDENTITY();

    -- Insertar datos en la tabla TbGenero
    INSERT INTO TbGenero (Genero)
    VALUES (@Genero);

    -- Obtener el último valor de la clave primaria de TbGenero
    SET @IDGenero = SCOPE_IDENTITY();

    -- Verificar si el usuario existe en TbAdministrador
    IF EXISTS (SELECT 1 FROM TbAdministrador WHERE IDUsuario = @IDUsuario)
    BEGIN
        DECLARE @IDAdministrador INT;
        SET @IDAdministrador = (SELECT TOP 1 IDAdministrador FROM TbAdministrador WHERE IDUsuario = @IDUsuario);
        

        -- Actualizar datos en la tabla TbAdministrador
        UPDATE TbAdministrador
        SET FNacimiento = @fechadeNaci,
            DUI = @DUI,
            IDGenero = @IDGenero,
            IDActividadLaboral = @IDActividad
        WHERE IDAdministrador = @IDAdministrador;
    END

    -- Verificar si el usuario existe en TbSecretaria
    ELSE IF EXISTS (SELECT 1 FROM TbSecretaria WHERE IDUsuario = @IDUsuario)
    BEGIN
        DECLARE @IDSecretaria INT;
        SET @IDSecretaria = (SELECT TOP 1 IDSecretaria FROM TbSecretaria WHERE IDUsuario = @IDUsuario);

        -- Actualizar datos en la tabla TbSecretaria
        UPDATE TbSecretaria
        SET FNacimiento = @fechadeNaci,
            DUI = @DUI,
            IDGenero = @IDGenero,
            IDActividadLaboral = @IDActividad
        WHERE IDSecretaria = @IDSecretaria;
    END

    -- Verificar si el usuario existe en TbTerapeutas
    ELSE IF EXISTS (SELECT 1 FROM TbTerapeutas WHERE IDUsuario = @IDUsuario)
    BEGIN
        DECLARE @IDTerapeuta INT;
        SET @IDTerapeuta = (SELECT TOP 1 IDTerapeuta FROM TbTerapeutas WHERE IDUsuario = @IDUsuario);

        -- Actualizar datos en la tabla TbTerapeutas
        UPDATE TbTerapeutas
        SET FNacimiento = @fechadeNaci,
            DUI = @DUI,
            IDGenero = @IDGenero,
            IDActividadLaboral = @IDActividad
        WHERE IDTerapeuta = @IDTerapeuta;
    END
END


CREATE PROCEDURE PDprimerusoinfo
	@username VARCHAR(200),
	@Correo VARCHAR(100) OUTPUT,
    @ActividadLabor VARCHAR(90) OUTPUT,
	@fechadeNaci DATE OUTPUT,
    @Numerotel VARCHAR(9) OUTPUT,
	@DUI VARCHAR(9) OUTPUT,
	@Genero INT OUTPUT
AS
BEGIN
	DECLARE @IDUsuario INT;
	DECLARE @Gmail VARCHAR (100);
	DECLARE @Numero VARCHAR(9);
	DECLARE @IDGenero INT;
	DECLARE @IDActividadlab INT;
	DECLARE @IDContacto INT;
	DECLARE @FNaci DATE;
	DECLARE @Duii VARCHAR(9);
	DECLARE @Generoo INT;
	DECLARE @Actividadlabolal VARCHAR (100);

	SET @IDUsuario = (SELECT TOP 1 IDUsuario FROM TbUsuarios WHERE Username = @username);
	SET @IDContacto = (SELECT TOP 1 IDContacto FROM TbUsuarios WHERE IDUsuario = @IDUsuario);
	SET @Gmail = (SELECT TOP 1 Correo FROM TbContactos WHERE IDContacto = @IDContacto);
	SET @Numero = (SELECT TOP 1 NumTelefonico FROM TbContactos WHERE IDContacto = @IDContacto);

	IF EXISTS (SELECT TOP 1 IDAdministrador FROM TbAdministrador WHERE IDUsuario = @IDUsuario)
    BEGIN
		SET @FNaci = (SELECT TOP 1 FNacimiento FROM TbAdministrador WHERE IDUsuario = @IDUsuario);
		SET @Duii = (SELECT TOP 1 DUI FROM TbAdministrador WHERE IDUsuario = @IDUsuario);
		SET @IDGenero =(SELECT TOP 1 IDGenero FROM TbAdministrador WHERE IDUsuario = @IDUsuario);
		SET @IDActividadlab = (SELECT TOP 1 IDActividadLaboral FROM TbAdministrador WHERE IDUsuario = @IDUsuario);
	END
    -- Verificar si el usuario existe en TbSecretaria
    ELSE IF EXISTS (SELECT TOP 1 IDSecretaria FROM TbSecretaria WHERE IDUsuario = @IDUsuario)
    BEGIN
		SET @FNaci = (SELECT TOP 1 FNacimiento FROM TbSecretaria WHERE IDUsuario = @IDUsuario);
		SET @Duii = (SELECT TOP 1 DUI FROM TbSecretaria WHERE IDUsuario = @IDUsuario);
		SET @IDGenero =(SELECT TOP 1 IDGenero FROM TbSecretaria WHERE IDUsuario = @IDUsuario);
		SET @IDActividadlab = (SELECT TOP 1 IDActividadLaboral FROM TbSecretaria WHERE IDUsuario = @IDUsuario);
    END
    -- Verificar si el usuario existe en TbTerapeutas
    ELSE IF EXISTS (SELECT TOP 1 IDTerapeuta FROM TbTerapeutas WHERE IDUsuario = @IDUsuario)
    BEGIN
		SET @FNaci = (SELECT TOP 1 FNacimiento FROM TbTerapeutas WHERE IDUsuario = @IDUsuario);
		SET @Duii = (SELECT TOP 1 DUI FROM TbTerapeutas WHERE IDUsuario = @IDUsuario);
		SET @IDGenero =(SELECT TOP 1 IDGenero FROM TbTerapeutas WHERE IDUsuario = @IDUsuario);
		SET @IDActividadlab = (SELECT TOP 1 IDActividadLaboral FROM TbTerapeutas WHERE IDUsuario = @IDUsuario);
	END

	-- Establecer los valores de salida
	SET @Correo = @Gmail;
	SET @Numerotel = @Numero;
	SET @fechadeNaci = @FNaci;
	SET @DUI = @Duii;
	SET @Genero = (SELECT TOP 1 Genero FROM TbGenero WHERE IDGenero = @IDGenero);
	SET @ActividadLabor = (SELECT TOP 1 NombreDeActividad FROM TbActividadesLaborales WHERE IDActividadLaboral = @IDActividadlab);
END

DECLARE @Correo VARCHAR(100);
DECLARE @ActividadLabor VARCHAR(90);
DECLARE @fechadeNaci DATE;
DECLARE @Numerotel VARCHAR(9);
DECLARE @DUI VARCHAR(9);
DECLARE @Genero INT;
-- Ejecutar el procedimiento almacenado PDprimerusoinfo
EXEC PDprimerusoinfo 
  'Pepito123',@Correo OUTPUT, @ActividadLabor OUTPUT, @fechadeNaci OUTPUT,  @Numerotel OUTPUT, @DUI OUTPUT,
  @Genero OUTPUT;

CREATE PROCEDURE PDRegistrarEmpleado
    @UsernameTbT VARCHAR(90),
    @ContraseñaTbTs VARCHAR(90),
    @Correo VARCHAR(300),
    @UsernameTbU VARCHAR(50),
    @Nivel INT
AS
BEGIN
    BEGIN TRY
        DECLARE @clinica VARCHAR(5);
        DECLARE @IDAdministrador INT;
        DECLARE @IDUsuarioT INT;
        DECLARE @CorreoEle VARCHAR(300);
        DECLARE @IDUsuarioEmple INT;

        -- Obtener el IDUsuario basado en el Username
        SET @IDUsuarioT = (SELECT TOP 1 IDUsuario FROM TbUsuarios WHERE UserName = @UsernameTbU);
        SET @IDAdministrador = (SELECT TOP 1 IDAdministrador FROM TbAdministrador WHERE IDUsuario = @IDUsuarioT);
        SET @clinica = (SELECT TOP 1 IDClinica FROM TbAdministrador WHERE IDAdministrador = @IDAdministrador);

        -- Insertar datos en la tabla TbClinicas si existe
        IF @clinica IS NOT NULL
        BEGIN
            -- Insertar datos en la tabla TbUsuarios si no existe
            IF NOT EXISTS (SELECT 1 FROM TbUsuarios WHERE UserName = @UsernameTbT)
            BEGIN
                -- Con esto declaramos la variable que contendrá el Hash
                DECLARE @HashContraseñaTbU VARBINARY(64);
                DECLARE @newHash VARBINARY(64);

                SET @HashContraseñaTbU = HASHBYTES('SHA2_256', @ContraseñaTbTs);
                SET @newHash = HASHBYTES('SHA2_256', @HashContraseñaTbU);

                INSERT INTO TbContactos (Correo)
                VALUES (@Correo);

                SET @CorreoEle = (SELECT TOP 1 IDContacto FROM TbContactos WHERE Correo = @Correo);

                INSERT INTO TbUsuarios (Username, Contraseña, IDContacto, Primeruso)
                VALUES (@UsernameTbT, @newHash, @CorreoEle, 1);

                SET @IDUsuarioEmple = (SELECT TOP 1 IDUsuario FROM TbUsuarios WHERE UserName = @UsernameTbT);
            END

            -- Insertar datos en la tabla correspondiente (Secretaria o Terapeutas) según el nivel
            IF @Nivel = 1
            BEGIN
                INSERT INTO TbSecretaria(IDClinica, IDUsuario) VALUES (@clinica, @IDUsuarioEmple);
            END
            ELSE IF @Nivel = 2
            BEGIN 
                INSERT INTO TbTerapeutas(IDClinica, IDUsuario) VALUES (@clinica, @IDUsuarioEmple);
            END
        END
    END TRY
    BEGIN CATCH
        -- Manejo de errores: Puedes realizar acciones específicas de manejo de errores aquí
        -- Ejemplo: INSERT INTO TbLogs (MensajeError) VALUES (ERROR_MESSAGE());
        -- ROLLBACK TRANSACTION; -- Deshacer la transacción en caso de error
        PRINT('Error: ' + ERROR_MESSAGE());
    END CATCH
END

EXEC PDRegistrarEmpleado 'pipi', 'Contraseña', 'djfhskdjhf@gmail.com', 'Bryan', 1;
-- Mostrar los valores de salida
SELECT 
  @Correo AS 'Correo',
  @ActividadLabor AS 'ActividadLabor',
  @fechadeNaci AS 'FechaNacimiento',
  @Numerotel AS 'NumeroTelefonico',
  @DUI AS 'DUI',
  @Genero AS 'Genero';

SELECT * FROM TbUsuarios;
SELECT * FROM TbAdministrador;

/*
Creamos la vista
*/
ALTER PROCEDURE PDinforPacienteview
	@IDPaciente INT,
	@nombre VARCHAR(100) OUTPUT,
	@Edad INT OUTPUT,  -- Cambiar el tipo de dato de @Fnacimiento a INT
	@Correo Varchar(100) OUTPUT,
	@imagen varbinary(max) OUTPUT,
	@MsjApoyo VARCHAR(300)
AS
BEGIN
	DECLARE @IDUsuario INT;
	DECLARE @Gmail VARCHAR(100);
	DECLARE @IDContacto INT;
	DECLARE @FechaNacimiento DATE;

	SET @IDUsuario = (SELECT TOP 1 IDUsuario FROM TbPacientes WHERE IDPaciente = @IDPaciente);
	SET @IDContacto = (SELECT TOP 1 IDContacto FROM TbUsuarios WHERE IDUsuario = @IDUsuario);
	
	---Declaramos el correo ya real del usuario
	SET @Gmail = (SELECT TOP 1 Correo FROM TbContactos WHERE IDContacto = @IDContacto);

	---Obtenemos la fecha de nacimiento
	SET @FechaNacimiento = (SELECT TOP 1 FNacimiento FROM TbPacientes WHERE IDPaciente = @IDPaciente);
	
	---Calculamos la edad en años
	SET @Edad = DATEDIFF(YEAR, @FechaNacimiento, GETDATE());

	---Le damos valores a los parametros de salida que son: el nombre, Correo y de último insertamos el mensaje de cariño y la imagen
	SET @nombre = (SELECT TOP 1 Nombre FROM TbPacientes WHERE IDPaciente = @IDPaciente);
	SET @Correo = @Gmail;
	SET @imagen = (SELECT TOP 1 FotoPerfil FROM TbUsuarios WHERE IDUsuario = @IDUsuario);
	
	---Actualizamos el mensaje de cariño hacia el usuario
	IF @MsjApoyo IS NOT NULL AND @MsjApoyo != '' AND @MsjApoyo != ' '
	BEGIN
		UPDATE TbPacientes SET MensajesDeCariño = @MsjApoyo WHERE IDPaciente = @IDPaciente;
	END
END

/*
CREATE PROCEDURE PDinforPacienteview
	@IDPaciente INT,
	@nombre VARCHAR(100) OUTPUT,
    @Fnacimiento DATE OUTPUT,
	@Correo Varchar(100) OUTPUT,
	@imagen varbinary(max) OUTPUT,
	@MsjApoyo VARCHAR(300)
AS
BEGIN
	DECLARE @IDUsuario INT;
	DECLARE @Gmail VARCHAR (100);
	DECLARE @IDContacto INT;

	SET @IDUsuario = (SELECT TOP 1 IDUsuario FROM TbPacientes WHERE IDPaciente = @IDPaciente);
	SET @IDContacto = (SELECT TOP 1 IDContacto FROM TbUsuarios WHERE IDUsuario = @IDUsuario);
	
	---Declaramos el correo ya real del usuario
	SET @Gmail = (SELECT TOP 1 Correo FROM TbContactos WHERE IDContacto = @IDContacto);
	
	---Le damos valores a los parametros de salida que son: la fecha de naci, Nombre, Correo y de último isertamos el mensaje de cariño y la imagen
	SET @Fnacimiento = (SELECT TOP 1 FNacimiento FROM TbPacientes WHERE IDPaciente = @IDPaciente);
	SET @nombre = (SELECT TOP 1 Nombre FROM TbPacientes WHERE IDPaciente = @IDPaciente);
	SET @Correo = @Gmail;
	SET @imagen = (SELECT TOP 1 FotoPerfil FROM TbUsuarios WHERE IDUsuario = @IDUsuario);
	---Actualizamos el mensaje de cariño hacia el usuario
	IF @MsjApoyo IS NOT NULL AND @MsjApoyo != '' AND @MsjApoyo != ' '
	BEGIN
		UPDATE TbPacientes SET MensajesDeCariño = @MsjApoyo WHERE IDPaciente = @IDPaciente;
	END

END
*/
ALTER PROCEDURE PDenviarmensajedeCariño
		@IDPaciente INT,
	@MsjApoyo VARCHAR(300)
AS
BEGIN
	DECLARE @IDUsuario INT;
	SET @IDUsuario = (SELECT TOP 1 IDUsuario FROM TbPacientes WHERE IDPaciente = @IDPaciente);
	IF @MsjApoyo IS NOT NULL AND @MsjApoyo != '' AND @MsjApoyo != ' '
	BEGIN
		UPDATE TbPacientes SET MensajesDeCariño = @MsjApoyo WHERE IDPaciente = @IDPaciente;
	END
END


CREATE PROCEDURE PDDetallesperfil
    @Descripcion VARCHAR(350),
    @Username VARCHAR(100)
AS
BEGIN
    DECLARE @IDUser INT;

    -- Obtener el IDUsuario correspondiente al UserName
    SET @IDUser = (SELECT TOP 1 IDUsuario FROM TbUsuarios WHERE UserName = @Username);

    -- Verificar si @Descripcion no es nulo ni una cadena vacía antes de realizar la actualización
    IF @Descripcion IS NOT NULL AND LTRIM(RTRIM(@Descripcion)) != ''
    BEGIN
        -- Actualizar la descripción del usuario
        UPDATE TbUsuarios SET Descripcion = @Descripcion WHERE IDUsuario = @IDUser;
    END
END


CREATE PROCEDURE PDCambiarContraseña
    @Username VARCHAR(50),
    @contraseña VARCHAR(90),
    @nueva_contraseña VARCHAR(90)
AS
BEGIN
    DECLARE @IDUsuario INT;
    DECLARE @ContraseñaActual VARBINARY(64);

    -- Obtener el IDUsuario basado en el Username
    SET @IDUsuario = (SELECT TOP 1 IDUsuario FROM TbUsuarios WHERE UserName = @Username);

    -- Obtener la contraseña actual almacenada en la base de datos para el usuario
    SET @ContraseñaActual = (SELECT TOP 1 Contraseña FROM TbUsuarios WHERE IDUsuario = @IDUsuario);

    -- Validar si la contraseña actual coincide con la contraseña ingresada
    IF HASHBYTES('SHA2_256', HASHBYTES('SHA2_256', @contraseña)) = @ContraseñaActual
    BEGIN
        -- Encriptar la nueva contraseña dos veces
        DECLARE @HashNuevaContraseña VARBINARY(64);
        SET @HashNuevaContraseña = HASHBYTES('SHA2_256', HASHBYTES('SHA2_256', @nueva_contraseña));

        -- Actualizar la contraseña del usuario en la base de datos
        UPDATE TbUsuarios
        SET Contraseña = @HashNuevaContraseña
        WHERE IDUsuario = @IDUsuario;

        PRINT 'Contraseña actualizada con éxito.';
    END
    ELSE
    BEGIN
        PRINT 'Contraseña actual incorrecta. No se pudo actualizar la contraseña.';
    END
END

EXEC PDCambiarContraseña 'dikei', '12345', 'Contraseña'

SELECT Contraseña, UserName FROM TbUsuarios;
ALTER TABLE TbUsuarios
ADD Descripcion VARCHAR(350);

CREATE PROCEDURE PDClinicainfo
	@Username VArchar(300),
	@Descripcion VARCHAR(300),
	@nombre VARCHAR (100),
	@ubicacion VARCHAR(max)
AS
BEGIN
	DECLARE @IDUsuario INT;
	DECLARE @IDClinica VARCHAR(5);
	DECLARE @IDAdmin INT;
	 SET @IDUsuario = (SELECT TOP 1 IDUsuario FROM TbUsuarios WHERE UserName = @Username);
	 SET @IDAdmin = (SELECT TOP 1 IDAdministrador FROM TbAdministrador WHERE IDUsuario = @IDUsuario);
	 SET @IDClinica =(SELECT TOP 1  IDClinica FROM TbAdministrador WHERE IDAdministrador = @IDAdmin);

	 IF @Descripcion IS NOT NULL AND @Descripcion!= '' AND @Descripcion!= ' '
    BEGIN
       UPDATE TbClinicas SET Descripcion = @Descripcion WHERE IDClinica = @IDClinica;
    END
	IF @nombre IS NOT NULL AND @nombre!= '' AND @nombre!= ' '
    BEGIN
       UPDATE TbClinicas SET NombreClinica = @nombre WHERE IDClinica = @IDClinica;
    END
	IF @ubicacion IS NOT NULL AND @ubicacion!= '' AND @ubicacion!= ' '
    BEGIN
       UPDATE TbClinicas SET Ubicacion= @ubicacion WHERE IDClinica = @IDClinica;
    END
END

EXEC PDClinicainfo 'Guayito', 'Clinica bien genial y suoper sabrosa', 'Michelines', 'Calle mistral';



---
---MostrarAnuncios---
----Descripción del proceso: Este nada más es un, se manda a llamar tanto en EliminarAnuncio como
---- Agregar anuncio: SELECT IDAnuncio, Titulo, Imagen, Fecha FROM TbAnuncios where IDAdministrador = ?;
/*
El trigger de abajo es para obtener la fecha actual y que se inserte cuando se haga un insert a la tabla TbAnuncios
*/

CREATE TRIGGER TriggerInsertarFecha
ON TbAnuncio
AFTER INSERT
AS
BEGIN
    -- Actualizar la columna 'Fecha' con la fecha actual
    UPDATE TbAnuncio
    SET Fecha = GETDATE()
    FROM TbAnuncio
    INNER JOIN INSERTED ON TbAnuncio.IDAnuncio = INSERTED.IDAnuncio;
END;


---AgregarRegistro---
----Descripción del proceso: Este nada más es un INSERT INTO TbAnuncio (Titulo, Imagen, IDAdministrador) VALUES (?,?,?);

---EliminarAnunciosActuales---
----Descripción del proceso: DELETE FROM TbAnuncio WHERE IDAnuncio = ?;


---VisualizarNotas---
---Descripción: Es un select Contenido y ya SELECT TOP 1 Contenido FROM TbAgendasPersonales where IDPaciente = 1;
---Información adicional: He creado un trigger que obtiene la fecha actual al hacer un insert en la tabla y la agrega al inicio del contenido.
---Posterior ha eso también cree un trigger igual pero updates.

-- Trigger del insert a agenda personal

CREATE TRIGGER TriggerInsertarFechaEnContenido
ON TbAgendasPersonales
AFTER INSERT
AS
BEGIN
    UPDATE A
    SET A.Contenido = CONVERT(varchar(max), GETDATE(), 120) + ' - ' + ISNULL(I.Contenido, '')
    FROM TbAgendasPersonales A
    INNER JOIN INSERTED I ON A.IDAgendaPersonal = I.IDAgendaPersonal;
END;

-- Trigger del update a agenda personal
CREATE TRIGGER TriggerActualizarFechaAlFinal
ON TbAgendasPersonales
AFTER UPDATE
AS
BEGIN
    UPDATE A
    SET A.Contenido = ISNULL(A.Contenido + ' Escrito el día: ', '') + CONVERT(varchar(max), GETDATE(), 120)
    FROM TbAgendasPersonales A
    INNER JOIN INSERTED I ON A.IDAgendaPersonal = I.IDAgendaPersonal;
END;

---EscribirEnTuExpediente---
---Descripción: Es proceso almacenado que inserte o actualice un EXEC InsertarActualizarExpediente ?, ?, ?;
---Información adicional: He creado un trigger que obtiene la fecha actual al hacer un insert en la tabla y la agrega al inicio del contenido.
---Posterior ha eso también cree un trigger igual pero updates.

-- Trigger del insert a expediente
CREATE TRIGGER TriggerInsertarFechaEnContenidoExpediente
ON TbExpedientes
AFTER INSERT
AS
BEGIN
    UPDATE A
    SET A.Contenido = CONVERT(varchar(max), GETDATE(), 120) + ' - ' + ISNULL(I.Contenido, '')
    FROM TbExpedientes A
    INNER JOIN INSERTED I ON A.IDExpediente = I.IDExpediente;
END;

-- Trigger del update a expediente
CREATE TRIGGER TriggerActualizarFechaAlFinalExpediente
ON TbExpedientes
AFTER UPDATE
AS
BEGIN
    UPDATE A
    SET A.Contenido = ISNULL(A.Contenido + ' Escrito el día: ', '') + CONVERT(varchar(max), GETDATE(), 120)
    FROM TbExpedientes A
    INNER JOIN INSERTED I ON A.IDExpediente = I.IDExpediente;
END;


-- Crear un procedimiento almacenado para insertar o actualizar un expediente
CREATE PROCEDURE InsertarActualizarExpediente
    @IDPaciente int,
    @Contenido varchar(max),
    @IDTerapeuta int
AS
BEGIN
    -- Verificar si existe un expediente para el IDPaciente dado
    IF EXISTS (SELECT 1 FROM TbExpedientes WHERE IDPaciente = @IDPaciente)
    BEGIN
        -- Si existe, realizar una actualización (UPDATE) para el primer registro encontrado (TOP 1)
        UPDATE TOP (1) TbExpedientes
        SET Contenido = @Contenido,
            IDTerapeuta = @IDTerapeuta
        WHERE IDPaciente = @IDPaciente;
    END
    ELSE
    BEGIN
        -- Si no existe, realizar una inserción (INSERT)
        INSERT INTO TbExpedientes (Contenido, IDPaciente, IDTerapeuta)
        VALUES (@Contenido, @IDPaciente, @IDTerapeuta);
    END
END;


---AgregarAritculo---
---Descripción: Es un INSERT INTO TbArticulos(Titulo, Descripcion, Imagen, IDTerapeuta) values (?,?,?,?);
---Información adicional: He creado un trigger que obtiene la fecha actual al hacer un insert en la tabla y la agrega al final del contenido

CREATE TRIGGER TriggerActualizarFechaAlFinalArticulo
ON TbArticulos
AFTER INSERT
AS
BEGIN
    UPDATE A
    SET A.Descripcion = ISNULL(A.Descripcion + ' Escrito el día: ', '') + CONVERT(varchar(400), GETDATE(), 120)
    FROM TbArticulos A
    INNER JOIN INSERTED I ON A.IDArticulo = I.IDArticulo;
END;

---ActualizarAritculo---
---Descripción: Es un Procedemiento almacenado que primero verirfica que el articulo pertenece al IDterapeuta que quiere hacer los cambios: EXEC InsertarActualizarArticulo ?, ?, ?, ?, ?

use dbMindLink;
go

SELECT * FROM TbArticulos;

ALTER PROCEDURE PDArticulosInsertOupdate
    @IDTerapeuta INT,
    @Titulo VARCHAR(70),
    @Contenido VARCHAR(MAX),
    @Imagen VARBINARY(MAX),
    @IDArticulo INT OUTPUT
AS
BEGIN
    DECLARE @Nombre VARCHAR(30);
    DECLARE @newcontenido VARCHAR(MAX);

    -- Verificar si el terapeuta ya tiene un artículo
    IF EXISTS (SELECT 1 FROM TbArticulos WHERE IDTerapeuta = @IDTerapeuta)
    BEGIN
        PRINT 'El terapeuta ya tiene un artículo. Realizando una actualización.';
        -- Actualizar el artículo existente
        UPDATE TbArticulos
        SET Titulo = @Titulo, Descripcion = @Contenido, Imagen = @Imagen
        WHERE IDTerapeuta = @IDTerapeuta;
        SET @IDArticulo = (SELECT IDArticulo FROM TbArticulos WHERE IDTerapeuta = @IDTerapeuta);
    END
    ELSE
    BEGIN
        PRINT 'El terapeuta no tiene ningún artículo. Realizando una inserción.';
        SET @Nombre = (SELECT Nombre FROM TbTerapeutas WHERE IDTerapeuta = @IDTerapeuta);
        SET @newcontenido = (@Contenido + ' Escrito por: ' + @Nombre);
        -- Insertar un nuevo artículo
        INSERT INTO TbArticulos (Titulo, Descripcion, Imagen, IDTerapeuta)
        VALUES (@Titulo, @newcontenido, @Imagen, @IDTerapeuta);
        SET @IDArticulo = SCOPE_IDENTITY(); -- Obtener el ID del artículo insertado
    END;
END;

select * from TbTerapeutas;
DECLARE @IDArticulo INT;


SELECT @IDArticulo AS 'ID del Artículo';
SELECT * FROM TbArticulos;
DELETE FROM TbArticulos WHERE IDArticulo = 19;
-- Eliminar registros de TbCantidadArticulo que hacen referencia al registro en TbArticulos
DELETE FROM TbCantidadArticulo WHERE IDArticulo = 19;

-- Luego, eliminar el registro en TbArticulos
DELETE FROM TbArticulos WHERE IDArticulo = 19;

---EliminarArticulo---
---Descripción: Es nada más un DELETE FROM TbArticulos WHERE IDArticulos = ?;


---DocumentosDeapoyo---
----Descripción: SELECT	IDArticulo, Titulo, Descripcion, Imagen FROM TbArticulos;


---CrearCitas---
---Descripción: INSERT INTO TbCitas(Hora, Fecha, IDPaciente, IDTerapeuta) Values (?, ?, ?, ?);
---Información adicional: Primero debe cargarse el nombre de los terapeutas en un combobox, por medio de un select TOP 1 IDTerapeuta FROM TbTerapeutas Where Nombre = ? and IDClinica = ? 

---PruebasDP---
---Descripción: Lo haré el domingo lol
---Información adicional:


---SolicitudesDeEmpleado---
---Descripción: Primero se debe llenar una tabla por medio de un SELECT primeros50, Asunto FROM VistaTbPermisos WHERE IDClinica = ?;
---Información adicional: Se seleccionarán todas los registros sin importar si estan en 0 en aceptados

CREATE VIEW VistaTbPermisos
AS
SELECT
    CASE 
        WHEN LEN(Contenido) > 40 THEN LEFT(Contenido, 37) + '...'
        ELSE Contenido
    END AS primeros50,
    Asunto,
    IDClinica,
    aceptado
FROM TbPermisos;


---SolicitudesDeEmpleado---
---Descripción: Primero se debe llenar una tabla por medio de un SELECT primeros50, Asunto FROM VistaTbPermisos WHERE IDClinica = ? AND aceptado = 1;

---Información adicional: 


---RedactarMensaje(Permiso)---
---Descripción: Se hace un EXEC PDPermiso ?,?,?
---Información adicional: 

/*
.
*/
ALTER PROCEDURE PDPermiso
	@Asunto VARCHAR(100),
	@Contenido VARCHAR(900),
	@IDUsuario INT
AS
BEGIN
	DECLARE @SecretExist INT;
	DECLARE @TerapeExist INT;
	DECLARE @IDSecretaria INT;
	DECLARE @IDTerapeuta INT;
	DECLARE @IDPermisoT INT;
	DECLARE @IDPermisoS INT;
	DECLARE @IDClinica VARCHAR(5);

	SET @SecretExist = (SELECT TOP 1 IDUsuario FROM TbSecretaria WHERE IDUsuario = @IDUsuario);
	SET @TerapeExist = (SELECT TOP 1 IDUsuario FROM TbTerapeutas WHERE IDUsuario = @IDUsuario);
	SET @IDTerapeuta = (SELECT TOP 1 IDTerapeuta FROM TbTerapeutas WHERE IDUsuario = @IDUsuario);
	SET @IDSecretaria = (SELECT TOP 1 IDSecretaria FROM TbSecretaria WHERE IDUsuario = @IDUsuario); 
	SET @IDPermisoT = (SELECT TOP 1 IDPermiso FROM TbPermisos WHERE IDTerpeuta = @IDTerapeuta);
	SET @IDPermisoS = (SELECT TOP 1 IDPermiso FROM TbPermisos WHERE IDSecretaria = @IDSecretaria);

	IF (@SecretExist IS NOT NULL)
	BEGIN
		SET @IDClinica = (SELECT IDClinica FROM TbSecretaria WHERE IDUsuario = @SecretExist);
		
		IF (@IDPermisoS IS NULL)
		BEGIN
			-- Insertar un nuevo permiso si no existe uno
			INSERT INTO TbPermisos(Asunto, Contenido, aceptado, IDClinica, IDSecretaria) 
			VALUES (@Asunto, @Contenido, 0, @IDClinica, @IDSecretaria);
		END
		ELSE
		BEGIN
			-- Actualizar el permiso existente
			UPDATE TbPermisos
			SET Asunto = @Asunto,
				Contenido = @Contenido,
				aceptado = 0
			WHERE IDPermiso = @IDPermisoS;
		END
	END
	ELSE IF (@TerapeExist IS NOT NULL)
	BEGIN
		SET @IDClinica = (SELECT IDClinica FROM TbTerapeutas WHERE IDUsuario = @TerapeExist);
		
		IF (@IDPermisoT IS NULL)
		BEGIN
			-- Insertar un nuevo permiso si no existe uno
			INSERT INTO TbPermisos(Asunto, Contenido, aceptado, IDClinica, IDTerpeuta) 
			VALUES (@Asunto, @Contenido, 0, @IDClinica, @IDTerapeuta);
		END
		ELSE
		BEGIN
			-- Actualizar el permiso existente
			UPDATE TbPermisos
			SET Asunto = @Asunto,
				Contenido = @Contenido,
				aceptado = 0
			WHERE IDPermiso = @IDPermisoT;
		END
	END
END;

---SolicitudesAprobadas2--- ---VerSolicitudAprobada
---Descripción: El botón de rechazar solicitud Solo actualizará el campo aceptado a "2" en base a un IDUsuario y el de aceptar se actualizará a 1
---Información adicional: Este proceso es usado en 3 ventanas diferentes, cuando ve el mensaje desde recibidos y cuando ve el mensaje desde aceptados

ALTER PROCEDURE ActualizarAceptado
	@IDUsuario INT,
	@case INT
AS
BEGIN
	DECLARE @IDSecretaria INT;
	DECLARE @IDTerapeuta INT;
	DECLARE @IDPermisoT INT;
	DECLARE @IDPermisoS INT;

	SET @IDTerapeuta = (SELECT TOP 1 IDTerapeuta FROM TbTerapeutas WHERE IDUsuario = @IDUsuario);
	SET @IDSecretaria = (SELECT TOP 1 IDSecretaria FROM TbSecretaria WHERE IDUsuario = @IDUsuario); 
	SET @IDPermisoT = (SELECT TOP 1 IDPermiso FROM TbPermisos WHERE IDTerpeuta = @IDTerapeuta);
	SET @IDPermisoS = (SELECT TOP 1 IDPermiso FROM TbPermisos WHERE IDSecretaria = @IDSecretaria);
	IF (@IDPermisoS IS not null)
	BEGIN
		-- Actualizar permisos de secretaria
		UPDATE TbPermisos
		SET aceptado = CASE 
			WHEN @case = 1 THEN 1
			WHEN @case = 2 THEN 2
			ELSE aceptado -- Mantener el valor actual si @case no es 1 ni 2
		END
		WHERE IDPermiso = @IDPermisoS;
	END
	-- Verificar si el usuario es un terapeuta
	ELSE IF (@IDPermisoT IS NOT NULL)
	BEGIN
		-- Actualizar permisos de terapeuta
		UPDATE TbPermisos
		SET aceptado = CASE 
			WHEN @case = 1 THEN 1
			WHEN @case = 2 THEN 2
			ELSE aceptado -- Mantener el valor actual si @case no es 1 ni 2
		END
		WHERE IDPermiso = @IDPermisoT;
	END
END;

---BuscadorEmpleado---
---Descripción: esta vista busca en tres tablas para mostrar el ID y el nombre, debido a que ActividadLaboral es de otra tabla hace la union tambien
---Información adicional: esta es la consulta para hacaer uso de la vista:  SELECT ID, Nombre, DUI, NombreDeActividad, IDUsuarioEm, Edad, FotoPerfil  FROM VistaEmpleadosConActividad WHERE Nombre LIKE '%Peña%';
SELECT * FROM TbTerapeutas;
SELECT * FROM TbUsuarios;
ALTER VIEW VistaEmpleadosConActividad AS
SELECT
    S.IDSecretaria AS ID,
    S.Nombre AS Nombre,
    S.DUI AS DUI,
    A.NombreDeActividad AS NombreDeActividad,
    S.IDUsuario AS IDUsuarioEm,
    DATEDIFF(YEAR, S.FNacimiento, GETDATE()) AS Edad,
    U.FotoPerfil AS FotoPerfil 
FROM
    TbSecretaria S
INNER JOIN
    TbActividadesLaborales A
ON
    S.IDActividadLaboral = A.IDActividadLaboral
INNER JOIN
    TbUsuarios U  -- Unirse a la tabla TbUsuarios para obtener la FotoPerfil
ON
    S.IDUsuario = U.IDUsuario
UNION ALL
SELECT
    T.IDTerapeuta AS ID,
    T.Nombre AS Nombre,
    T.DUI AS DUI,
    A.NombreDeActividad AS NombreDeActividad,
    T.IDUsuario AS IDUsuarioEm,
    DATEDIFF(YEAR, T.FNacimiento, GETDATE()) AS Edad,
    U.FotoPerfil AS FotoPerfil  
FROM
    TbTerapeutas T
INNER JOIN
    TbActividadesLaborales A
ON
    T.IDActividadLaboral = A.IDActividadLaboral
INNER JOIN
    TbUsuarios U  -- Unirse a la tabla TbUsuarios para obtener la FotoPerfil
ON
    T.IDUsuario = U.IDUsuario;






CREATE VIEW VistaTerapeutasEdad AS
SELECT
    IDTerapeuta,
    DATEDIFF(YEAR, FNacimiento, GETDATE()) AS Edad
FROM
    TbTerapeutas;

CREATE VIEW VistaSecreatariaEdad AS
SELECT
    IDSecretaria,
    DATEDIFF(YEAR, FNacimiento, GETDATE()) AS Edad
FROM
    TbSecretaria;

CREATE VIEW VistaPacienteEdad AS
SELECT
    IDPaciente,
    DATEDIFF(YEAR, FNacimiento, GETDATE()) AS Edad
FROM
    TbPacientes;

	-- Eliminar el trigger TriggerInsertarFechaEnContenidoAgenda
DROP TRIGGER TriggerInsertarFechaEnContenidoAgenda
ON TbAgendasPersonales;

-- Eliminar el trigger TriggerActualizarFechaAlFinalAgenda
DROP TRIGGER TriggerActualizarFechaAlFinalAgenda
ON TbAgendasPersonales;

CREATE VIEW VistaClinicaUsuario AS
	SELECT IDUsuario, IDClinica FROM TbTerapeutas
	UNION ALL
	SELECT IDUsuario, IDClinica FROM TbSecretaria
	UNION ALL
	SELECT IDUsuario, IDClinica FROM TbAdministrador;
--Para realizar la query es así: SELECT IDClinica FROM VistaClinicaUsuario WHERE IDUsuario = 18;


CREATE PROCEDURE InsertarActualizarExpediente
    @IDPaciente int,
    @Contenido varchar(max),
    @IDTerapeuta int
AS
BEGIN
    -- Verificar si existe un expediente para el IDPaciente dado
    IF EXISTS (SELECT 1 FROM TbExpedientes WHERE IDPaciente = @IDPaciente)
    BEGIN
        -- Si existe, realizar una actualización (UPDATE) para el primer registro encontrado (TOP 1)
        UPDATE TOP (1) TbExpedientes
        SET Contenido = @Contenido,
            IDTerapeuta = @IDTerapeuta
        WHERE IDPaciente = @IDPaciente;
    END
    ELSE
    BEGIN
        -- Si no existe, realizar una inserción (INSERT)
        INSERT INTO TbExpedientes (Contenido, IDPaciente, IDTerapeuta)
        VALUES (@Contenido, @IDPaciente, @IDTerapeuta);
    END
END;

CREATE PROCEDURE PDInsertarOActualizarNotas
	@IDPaciente int,
	@Contenido VARCHAR(MAX)
AS
BEGIN
    -- Verificar si existe una agenda para el IDPaciente dado
    IF EXISTS (SELECT 1 FROM TbAgendasPersonales WHERE IDPaciente = @IDPaciente)
    BEGIN
        -- Si existe, realizar una actualización (UPDATE) para el primer registro encontrado (TOP 1)
        UPDATE TOP (1) TbAgendasPersonales
        SET Contenido = @Contenido
        WHERE IDPaciente = @IDPaciente;
    END
    ELSE
    BEGIN
        -- Si no existe, realizar una inserción (INSERT)
        INSERT INTO TbAgendasPersonales(Contenido, IDPaciente)
        VALUES (@Contenido, @IDPaciente);
    END
END;



CREATE PROCEDURE PDEliminarSinCascade
	@IDUsuario INT
AS
BEGIN
	DECLARE @IDTerapeuta int;
	DECLARE @IDSecretaria int;
	SET @IDTerapeuta = (SELECT TOP 1 IDTerapeuta FROM TbTerapeutas WHERE IDUsuario = @IDUsuario);
	SET @IDSecretaria = (SELECT TOP 1 IDSecretaria FROM TbSecretaria WHERE IDUsuario = @IDUsuario);

	IF(@IDTerapeuta IS NOT NULL)
	BEGIN
		UPDATE TbArticulos SET IDTerapeuta = null where IDTerapeuta = @IDTerapeuta;
		UPDATE TbPruebas SET IDTerapeuta = NULL where IDTerapeuta = @IDTerapeuta;
		UPDATE TbExpedientes SET IDTerapeuta = null WHERE IDTerapeuta = @IDTerapeuta;
		DELETE FROM TbTerapeutas WHERE IDTerapeuta = @IDTerapeuta; 

	END
		
	ELSE
	BEGIN
		UPDATE TbPruebas SET IDSecretaria = null where IDSecretaria = @IDSecretaria;
		UPDATE TbCitas SET IDSecretaria = null WHERE IDSecretaria = @IDSecretaria
		DELETE FROM TbSecretaria WHERE IDSecretaria = @IDSecretaria;
	END
END;



 ---AgrgarPerfilDeEmpleado---
 ---Descripción: Este procedimiento almacenado crea un usuario e interactúa con 3 tablas TbContactos, TbUsuario y TbTerpaeuta/TbSecretaria, se ejecuta con este exec:
 ---EXEC PDCrearEmpleado 27, 'whats@gmail.com', 'whats', 'Contraseña', 2, 'Doris';
 ALTER PROCEDURE PDCrearEmpleado
	@IDAdministrador INT,
	@Correo varchar(400),
	@Username VARCHAR(100),
	@Contraseña VARCHAR(100),
	@TipoDeEm INT,
	@Nombre VARCHAR(200),
	@imagen VARBINARY(MAX)
 AS
 BEGIN
		DECLARE @HashContraseñaTbU VARBINARY(64);
		DECLARE @newHash VARBINARY(64);
		DECLARE @IDClinica VARCHAR(5);
		DECLARE @IDUsuario INT;
		SET @IDClinica = (SELECT IDClinica FROM TbAdministrador WHERE IDAdministrador = @IDAdministrador);
        SET @HashContraseñaTbU = HASHBYTES('SHA2_256', @Contraseña);
		SET @newHash = HASHBYTES('SHA2_256', @HashContraseñaTbU);

		IF(@Correo is not null)
		BEGIN
		INSERT INTO TbContactos(Correo) VALUES (@Correo);
		DECLARE @IDContacto INT; 
		set @IDContacto = (SELECT IDContacto FROM TbContactos WHERE Correo = @Correo);
			IF (@Username IS NOT NULL AND @Contraseña IS NOT NULL)
			BEGIN
				INSERT INTO TbUsuarios(UserName, Contraseña, IDContacto, Primeruso, FotoPerfil)
				VALUES (@Username, @newHash, @IDContacto, 0, @imagen);
				SET @IDUsuario = (select IDUsuario FROM TbUsuarios WHERE UserName = @Username);
					IF(@TipoDeEm = 1 AND @TipoDeEm IS NOT NULL)
					BEGIN
						INSERT INTO TbTerapeutas(Nombre, IDUsuario, IDClinica) VALUES (@Nombre, @IDUsuario, @IDClinica);
					END
					ELSE IF(@TipoDeEm = 2)
					BEGIN 
						INSERT INTO TbSecretaria(Nombre, IDUsuario, IDClinica) VALUES (@Nombre, @IDUsuario, @IDClinica);
					END
			END
		END

		ELSE
		BEGIN
			IF (@Username IS NOT NULL AND @Contraseña IS NOT NULL)
			BEGIN
				INSERT INTO TbUsuarios(UserName, Contraseña, Primeruso, FotoPerfil)
				VALUES (@Username, @newHash, 1, @imagen);
				SET @IDUsuario = (select IDUsuario FROM TbUsuarios WHERE UserName = @Username);
				IF(@TipoDeEm = 1 AND @TipoDeEm IS NOT NULL)
					BEGIN
						INSERT INTO TbTerapeutas(Nombre, IDUsuario, IDClinica) VALUES (@Nombre, @IDUsuario, @IDClinica);
					END
					ELSE IF(@TipoDeEm = 2)
					BEGIN 
						INSERT INTO TbSecretaria(Nombre, IDUsuario, IDClinica) VALUES (@Nombre, @IDUsuario, @IDClinica);
					END
			END
		END

 END;
 
CREATE PROCEDURE ObtenerIDTerapeuta
    @UserName varchar(50),
    @IDTerapeuta int OUTPUT
AS
BEGIN
    SET NOCOUNT ON;

    SELECT @IDTerapeuta = TT.IDTerapeuta
    FROM TbUsuarios TU
    INNER JOIN TbTerapeutas TT ON TU.IDUsuario = TT.IDUsuario
    WHERE TU.UserName = @UserName;
END;

DECLARE @IDTerapeutaResultado int;


CREATE PROCEDURE ObtenerIDAdministrador
    @UserName varchar(50),
    @IDAdmin int OUTPUT
AS
BEGIN
    SET NOCOUNT ON;

    SELECT @IDAdmin = TT.IDAdministrador
    FROM TbUsuarios TU
    INNER JOIN TbAdministrador TT ON TU.IDUsuario = TT.IDUsuario
    WHERE TU.UserName = @UserName;
END;

CREATE PROCEDURE ObtenerIDSecretaria
    @UserName varchar(50),
    @IDTerapeuta int OUTPUT
AS
BEGIN
    SET NOCOUNT ON;

    SELECT @IDTerapeuta = TT.IDSecretaria
    FROM TbUsuarios TU
    INNER JOIN TbSecretaria TT ON TU.IDUsuario = TT.IDUsuario
    WHERE TU.UserName = @UserName;
END;

create table TbCantidadArticulo(
IDCantArticulo int identity (1,1) primary key,
cantArticulo int,
IDTerapeuta INT,
IDArticulo int
);

create table TbContPermisos(
IDContPermiso int identity (1,1) primary key,
nombre varchar(50),
contAceptado int,
IDPermiso int
);	

---Ver permisos---
 ---Descripción: Este procedimiento almacenado selecciona el Asunto y el Contenido en base a un IDUsuario, lo usan 3 pantallas de ver mensajes, se ejecuta con este exec:
 ---DECLARE @Asunto VARCHAR(100); DECLARE @Contenido VARCHAR(900); EXEC PDVerPermiso 29, @Asunto OUTPUT, @Contenido OUTPUT; SELECT @Asunto AS Asunto, @Contenido AS Contenido;;

CREATE PROCEDURE ObtenerIDPaciente
    @UserName varchar(50),
    @IDPaciente int OUTPUT
AS
BEGIN
    SET NOCOUNT ON;

    SELECT @IDPaciente = TT.IDPaciente
    FROM TbUsuarios TU
    INNER JOIN TbPacientes TT ON TU.IDUsuario = TT.IDUsuario
    WHERE TU.UserName = @UserName;
END;

CREATE PROCEDURE PDVerPermiso
    @IDUsuario INT,
    @Asunto VARCHAR(100) OUTPUT,
    @Contenido VARCHAR(900) OUTPUT
AS
BEGIN
    -- Inicializar los valores en NULL
    SET @Asunto = NULL;
    SET @Contenido = NULL;

    -- Verificar si el usuario es una Secretaria
    IF EXISTS (SELECT 1 FROM TbSecretaria WHERE IDUsuario = @IDUsuario)
    BEGIN
        -- Obtener Asunto y Contenido
        SELECT @Asunto = P.Asunto, @Contenido = P.Contenido
        FROM TbPermisos AS P
        INNER JOIN TbSecretaria AS S ON P.IDSecretaria = S.IDSecretaria
        WHERE S.IDUsuario = @IDUsuario;
    END
    -- Verificar si el usuario es un Terapeuta
    ELSE IF EXISTS (SELECT 1 FROM TbTerapeutas WHERE IDUsuario = @IDUsuario)
    BEGIN
        -- Obtener Asunto y Contenido
        SELECT @Asunto = P.Asunto, @Contenido = P.Contenido
        FROM TbPermisos AS P
        INNER JOIN TbTerapeutas AS T ON P.IDTerpeuta = T.IDTerapeuta
        WHERE T.IDUsuario = @IDUsuario;
    END
END;

---Tablas permisos---
 ---Descripción: Este procedimiento almacenado selecciona el Asunto, IDUsuario y nombre, lo usan 3 tablas de ver permisos, se ejecuta con este exec:
 ---SELECT * FROM VistaPermisos WHERE aceptado = ?;


CREATE VIEW VistaPermisos AS
SELECT
    T.IDUsuario AS IDUsuario,
    T.Nombre AS Nombre,
    TP.Asunto,
	TP.aceptado -- Agregar el campo aceptado
FROM
    TbPermisos TP
LEFT JOIN
    TbTerapeutas T ON TP.IDTerpeuta = T.IDTerapeuta
UNION ALL
SELECT
    S.IDUsuario AS IDUsuario,
    S.Nombre AS Nombre,
    TP.Asunto,
    TP.aceptado -- Agregar el campo aceptado
FROM
    TbPermisos TP
LEFT JOIN
    TbSecretaria S ON TP.IDSecretaria = S.IDSecretaria;

-- Crear el trigger para insertar en TbCantidadArticulo después de insertar en TbArticulos
-- Modificar el trigger para obtener el valor de IDArticulo de TbArticulos
CREATE TRIGGER Tr_InsertarCantidadArticulo
ON TbArticulos
AFTER INSERT
AS
BEGIN
    -- Insertar en TbCantidadArticulo
    INSERT INTO TbCantidadArticulo (cantArticulo, IDTerapeuta, IDArticulo)
    SELECT 1, a.IDTerapeuta, a.IDArticulo
    FROM TbArticulos a
    INNER JOIN inserted i ON a.IDTerapeuta = i.IDTerapeuta;
END;



-- Crear el trigger para actualizar TbCantidadArticulo después de un UPDATE en TbArticulos
CREATE TRIGGER Tr_ActualizarCantidadArticulo
ON TbArticulos
AFTER UPDATE
AS
BEGIN
    -- Actualizar la columna cantArticulo en TbCantidadArticulo solo si hay un IDTerapeuta válido
    UPDATE ca
    SET ca.cantArticulo = ca.cantArticulo + 1
    FROM TbCantidadArticulo ca
    INNER JOIN inserted i ON ca.IDArticulo = i.IDArticulo
    LEFT JOIN TbTerapeutas t ON i.IDTerapeuta = t.IDTerapeuta
    WHERE t.IDTerapeuta IS NOT NULL;
END;

SELECT * FROM TbUsuarios;
SELECT * FROM TbRecetasMedicas;

