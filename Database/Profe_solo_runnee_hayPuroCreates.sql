
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
Create table TbAnuncio(
IDAnuncio int identity(1,1) primary key,
Titulo nvarchar(70),
Descripcion varchar(400),
Imagen image,
Fecha date,
IDSecretaria int,
IDAdministrador int
);
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
Create table TbClinicas(
IDClinica Varchar(5) primary key,
NombreClinica varchar(300),
Ubicacion Varchar(1000), 
Due�o nvarchar(100),
Descripcion varchar(400),
Logo image
);
Create table TbUsuarios(
IDUsuario int identity(1,1) primary key,
UserName varchar(50) unique,
Contrase�a varbinary(64),
FotoPerfil image,
IDContacto int
);
ALTER table TbContactos(
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
Fecha date,
Descripcion varchar(900),
IDPaciente int,
IDClinica Varchar(5),
IDMedicamento int
);
Create table TbMedicamentos(
IDMedicamento int identity(1,1) primary key,
NombreMedicamento varchar(500)
);

-- Aqu� empiezan los unique's para que existan valores nulos repeditos en caso que el usuario no llene una de las preguntas de algun formulario
CREATE UNIQUE INDEX TbCont_Correo ON TbContactos (Correo)
WHERE Correo IS NOT NULL

CREATE UNIQUE INDEX TbCont_NumTelefonico ON TbContactos (NumTelefonico)
WHERE NumTelefonico IS NOT NULL

CREATE UNIQUE INDEX TbAdministrador_DUI ON TbAdministrador (DUI)
WHERE DUI IS NOT NULL

CREATE UNIQUE INDEX TbPacientes_DUI ON TbPacientes (DUI)
WHERE DUI IS NOT NULL

CREATE UNIQUE INDEX TbSecretaria_DUI ON TbSecretaria (DUI)
WHERE DUI IS NOT NULL

CREATE UNIQUE INDEX TbTerapeutas_DUI ON TbTerapeutas (DUI)
WHERE DUI IS NOT NULL
--Insert into TbAdministrador 
--Select * from TbMedicamentos


ALTER table TbArticulos Add constraint fk_IDTerapeuta_TBArt
Foreign key (IDTerapeuta) References TbTerapeutas(IDTerapeuta);

Alter table TbAnuncio Add constraint fk_IDSecretaria_TbAnun
Foreign key (IDSecretaria) References TbSecretaria(IDSecretaria);


/*
Hasta aqu� va bien (ya lo probe)
*/
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
Hasta aqu� good
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
/*
Ya esta bien aaaa
*/

/*
Desde aqu� comienzan los procesos almacenados
*/
CREATE PROCEDURE PDRegistrarAdmin
    @nombreTbA VARCHAR(90),
    @UsernameTbU VARCHAR(50),
    @Contrase�aTbU VARCHAR(90),
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
		DECLARE @HashContrase�aTbU VARBINARY (64);
		DECLARE @newHash VARBINARY(64);
		SET @HashContrase�aTbU = HASHBYTES('SHA2_256', @Contrase�aTbU);
		SET @newHash = HASHBYTES('SHA2_256', @HashContrase�aTbU);
    -- Con las dos lineas de abajo mandamos a almacenar el Username y la contrase�a con Hash
		INSERT INTO TbUsuarios (Username, Contrase�a)
        VALUES (@UsernameTbU, @newHash)
    END
	-- Obtener el IDUsuario basado en el Username
    DECLARE @IDUsuario INT
    SET @IDUsuario = (SELECT IDUsuario FROM TbUsuarios WHERE Username = @UsernameTbU)
	-- Insertar datos en la tabla TbAdministrador
    INSERT INTO TbAdministrador (Nombre, IDClinica, IDUsuario)
    VALUES (@nombreTbA, @IdTbCli, @IDUsuario)

END


/* esto es para comprobar que el PDResgistrarAdmin funciona jejeje
Drop Procedure PDRegistrarAdmin

INSERT INTO TbContactos Values ('Guayito.palom0@gmail.com', '69839847')
SELECT * FRom TbContactos
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
Contrase�a varbinary(64),
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
    @Contrase�aIngresado VARCHAR(90),
    @abrirventana INT OUTPUT,
    @acceso INT OUTPUT
AS
BEGIN
    -- Agrega la declaraci�n de la variable @resultado y @ventana aqu�
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
        -- Con esto declaramos la variable que contendr� el Hash
        DECLARE @HashContrase�aTbU VARBINARY(64);
        DECLARE @Contrase�areal VARBINARY(64);
		DECLARE @newHash VARBINARY(64);

        SET @HashContrase�aTbU = HASHBYTES('SHA2_256', @Contrase�aIngresado);
		SET @newHash = HASHBYTES('SHA2_256', @HashContrase�aTbU);
        SET @Contrase�areal = (SELECT Contrase�a FROM TbUsuarios WHERE IDUsuario = @IDUsuario);
	--	PRINT @HashContrase�aTbU
		--PRINT @Contrase�areal
        -- Con las l�neas de abajo, veremos si la contrase�a mandada ya hasheada coincide con la registrada
        IF (@newHash = @Contrase�areal)
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
        SET @ventana = 0; -- Asignaci�n para el caso en que el username no coincida
    END

    SET @abrirventana = @ventana;
    SET @acceso = @resultado;
END






select * from TbAdministrador
select* from TbUsuarios

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
    @Contrase�aTbU VARCHAR(90),
	@Numtel nvarchar(14)
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
			DECLARE @HashContrase�aTbU VARBINARY (64);
			DECLARE @newHash VARBINARY (64);
			SET @HashContrase�aTbU = HASHBYTES('SHA2_256', @Contrase�aTbU);
			SET @newHash = HASHBYTES('SHA2_256', @HashContrase�aTbU);
			INSERT INTO TbContactos (NumTelefonico)
			VALUES (@Numtel)
			DECLARE @Numerotel NVARCHAR
			SET @Numerotel = (SELECT IDContacto FROM TbContactos WHERE @NumTel = @Numerotel)
			-- Con las dos lineas de abajo mandamos a almacenar el Username y la contrase�a con Hash
			INSERT INTO TbUsuarios (Username, Contrase�a, IDContacto)
			VALUES (@UsernameTbU, @newHash, @Numerotel)
		END
	-- Obtener el IDUsuario basado en el Username
		DECLARE @IDUsuario INT
		SET @IDUsuario = (SELECT IDUsuario FROM TbUsuarios WHERE Username = @UsernameTbU)
	-- Insertar datos en la tabla TbAdministrador
		
		INSERT INTO TbPacientes (Nombre, Apellido, FNacimiento, IDClinica, IDUsuario)
		VALUES (@nombreTbP, @apellidoTbp,@fechadenaci,@IdTbCli, @IDUsuario)
		END
		
END



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
    @contrase�a VARCHAR(50)
AS
BEGIN
    -- Verificar si el usuario ya existe en la tabla
    IF EXISTS (SELECT 1 FROM dbo.TbUsuarios WHERE UserName = @nombreUsuario)
    BEGIN
        -- Actualizar la contrase�a existente
        UPDATE dbo.TbUsuarios
        SET Contrase�a = CONVERT(VARBINARY(MAX), @contrase�a)
        WHERE UserName = @nombreUsuario
    END
    ELSE
    BEGIN
        -- Insertar un nuevo registro
        INSERT INTO dbo.TbUsuarios (UserName, Contrase�a)
        VALUES (@nombreUsuario, CONVERT(VARBINARY(MAX), @contrase�a))
    END
END
/*
Esto nada m�s lo hice pa entender c�mo se conecta un Foreign key a una registro existente
INSERT INTO TbContactos Values ('guayito.palom0@gmail.com','69839847')
INSERT INTO TbContactos Values ('juanpflapi@gmail.com', '8328932')
Select * from TbContactos
UPDATE TbUsuarios SET IDContacto = 3 WHERE UserName = 'Pepito'
SELECT * FROM TbUsuarios where UserName = 'Pepito'
SELECT * FROM TbPacientes 
SELECT * FROM TbUsuarios where UserName = 'Guayito'
use DbMindLink
EXEC CrearActualizarUsuario @nombreUsuario = 'ejemplo_usuario', @contrase�a = 'ejemplo_contrase�a';
--- DROP Procedure PDCrearActualizarUsuario
*/

/*
El siguiente proceso es para solo ACTUALIZAR la contrase�a de los usuarios basandonos en su correo electronico, m�s no crear usuarios, solo actualizar
Basicamente esta hecho para recuperacion de contrase�a por medio del correo electronico
*/
CREATE PROCEDURE PDActualizarContraGmail
    @Correo VARCHAR(300),
    @contrase�a VARCHAR(50)
AS
BEGIN
    -- Verificar si el usuario ya existe en la tabla
	
    IF EXISTS (SELECT 1 FROM dbo.TbContactos WHERE Correo = @Correo)
    BEGIN
	DECLARE @IDContacto INT;
	SET @IDContacto =  (SELECT IDContacto FROM TbContactos WHERE Correo = @Correo)
	DECLARE @IDUsuario INT;
	SET @IDUsuario = (SELECT IDUsuario FROM TbUsuarios WHERE IDContacto = @IDContacto)
        -- Actualizar la contrase�a existente
		DECLARE @HashContrase�aTbU VARBINARY (64);
		DECLARE @newHash VARBINARY (64);
		SET @HashContrase�aTbU = HASHBYTES('SHA2_256', @contrase�a);
		SET @newHash = HASHBYTES('SHA2_256', @HashContrase�aTbU);

        UPDATE dbo.TbUsuarios
		SET Contrase�a = @newHash
        WHERE IDUsuario = @IDUsuario
    END
	ELSE 
	BEGIN
		PRINT 'ta equivocado'
	END
END



/*
El siguiente ploceso es para cambiar la contrase�a con el numero de telefono
*/
CREATE PROCEDURE PDActualizarContraNum
    @Num VARCHAR(50),
    @contrase�a VARCHAR(50)
AS
BEGIN
    -- Verificar si el usuario ya existe en la tabla
	
    IF EXISTS (SELECT 1 FROM dbo.TbContactos WHERE NumTelefonico = @Num)
    BEGIN
	DECLARE @IDContacto INT;
	SET @IDContacto =  (SELECT IDContacto FROM TbContactos WHERE NumTelefonico = @Num)
	DECLARE @IDUsuario INT;
	SET @IDUsuario = (SELECT IDUsuario FROM TbUsuarios WHERE IDContacto = @IDContacto)
        -- Actualizar la contrase�a existente
		DECLARE @HashContrase�aTbU VARBINARY (64);
		DECLARE @newHash VARBINARY (64);
		SET @HashContrase�aTbU = HASHBYTES('SHA2_256', @contrase�a);
		SET @newHash = HASHBYTES('SHA2_256', @HashContrase�aTbU);

        UPDATE dbo.TbUsuarios
		SET Contrase�a = @newHash
        WHERE IDUsuario = @IDUsuario
    END
	ELSE 
	BEGIN
		PRINT 'ta equivocado'
	END
END



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



/*
Desde aqu� comienzan las vistas

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


--Se generaron 30 comentarios, investigar por qu�

/*
Un proceso donde almacena los datos ingresados por 
el usuario y quede guardado en la base de datos en
la tabla correspondiente.
*/

--Creamos el procedimiento que guarde los datos

CREATE PROCEDURE PDInsertarAcercademi (
    @Nombre varchar(90),
    @Apellido varchar(90),
    @CorreoElectronico varchar(90),
    @DUI varchar(20)
)
AS
BEGIN
    SET NOCOUNT ON;

    -- Verificar si el paciente ya existe en la tabla
    IF NOT EXISTS (SELECT 1 FROM TbPacientes WHERE DUI = @DUI)
    BEGIN
        INSERT INTO TbPacientes (Nombre, Apellido, CorreoElectronico, FNacimiento, DUI)
        VALUES (@Nombre, @Apellido, @CorreoElectronico, GETDATE(), @DUI);
    END
END;

-- Ejecutar el procedimiento para insertar un paciente de ejemplo
EXEC PDInsertarAcercademi 'Nombre del paciente', 'Apellido del paciente', 'correo@example.com', '123456789';
/*
Creamos la vista
*/

CREATE VIEW VistaNota
AS
SELECT Contenido, Fecha, IDPaciente
FROM TbAgendasPersonales
WHERE Fecha = (SELECT MAX(Fecha) FROM TbAgendasPersonales)

SELECT * FROM VistaNota


--Esta vista es para ver el usuario, la contrase�a y el cargo de un empleado
CREATE VIEW VistaUsuarios
AS
SELECT u.UserName, u.Contrase�a, t.Cargo
FROM TbUsuarios u
INNER JOIN TbTipoUsuarios t ON t.IDTipoUsuario = t.IDTipoUsuario

/*
Vista de anuncio:
Una vista que muestres los anuncios que el Admin 
guardada en la base de datos para que este se muestre en la app de android
*/

--Queda pendiente revisar que solo se muestre un anuncio a la vez
CREATE VIEW VistaAnuncios
AS
SELECT IDAnuncio, Titulo, Descripcion, Imagen, Fecha
FROM TbAnuncio

SELECT * FROM VistaAnuncios

/*Duda: Aqui preguntarle a guayito sobre la magen del anuncio!*/

/*
Vista de calendario de cita:
Una vista ya que el calendario
debe de marcar una cita que el usuario 
debe ir a la clinica entonces supongo que la 
vista debe de buscar en la base de datos la fecha
de la cita que el cliente debe ir.
*/

CREATE VIEW VistaFechaCitaCliente
AS
SELECT Fecha, IDPaciente
FROM TbCitas
--Investigar c�mo poner la vista en base de un idpaciente especifico

SELECT * FROM VistaFechaCitaCliente




CREATE VIEW VistaComentarios
AS
SELECT IDComentario, Mensaje, Fecha, Username
FROM TbComentarios
INNER JOIN TbUsuario

--Fumar mucho weed y pensar c�mo funcionar�

SELECT * FROM VistaComentarios;

CREATE VIEW VistaPacientes AS
SELECT IDPaciente, Nombre, Apellido, CorreoElectronico, FNacimiento, DUI
FROM TbPacientes;

SELECT * FROM VistaPacientes;


--Esto es para seleccionar la vista:
--SELECT * FROM�VistaUsuarios
-- DROP VIEW VistaUsuarios

