use dbMindLink;
go

EXEC PDRegistrarAdmin 'Eduardo René', 'Guayito', 'Contraseña', '52281'
EXEC PDRegistrarAdmin 'Orlando', 'Pepito', 'Contraseña', '52281'


DECLARE @resultado INT;
DECLARE @ventana INT;
EXEC PDLogear 'Guayito', 'Melocoton', @ventana OUTPUT, @resultado OUTPUT;
SELECT @resultado AS acceso;
SELECT @ventana AS abrirventana;

EXEC PDRegistrarpaciente 'Luis','CagaLindo','9-10-2001','52281','Pepito','contraseña', ' 7689 6281';

Exec PDActualizarContraGmail 'guayito.palom0@gmail.com', 'Melocoton';
SELECT * from TbUsuarios

EXEC PDActualizarContraNum '69839847','Papitaaaaa'

DECLARE @CorreoExis INT;
EXEC PdBuscarCorreo 'guayito.palom0@gmail.com', @CorreoExis OUTPUT;
SELECT @CorreoExis AS Correoexistente;

DECLARE @NumeroExis INT;
EXEC PdBuscarNum '69839847', @NumeroExis OUTPUT;
SELECT @NumeroExis AS NumeroExistente;

EXEC PDInsertarAgendaPersonal 'Contenido de la agenda', 'Pepito';

EXEC PDGuardarComentario 'Este es un comentario de ejemplo', 'Pepito';

EXEC PDPrimerUso 'Guayito', 'Correo.FUCK@gmail.com', 'Guapeton', '1023-09-24', '0174 2525', '9657-4343', 2

EXEC PDPrimerUso 'Pepito123', 'cs,dmns@ricaldone.edu.sv', 'Inteligente', '2023-08-30', '0328 3462', '3226-4343', 1

SELECT * FROM TbUsuarios;
SELECT * FROM TbAdministrador;
SELECT * FROM TbContactos;