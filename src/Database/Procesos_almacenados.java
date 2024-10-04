/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.CallableStatement;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import microsoft.sql.Types;
import ux.AnunciosActuales;
import ux.DocumentosDeApoyo;
import ux.EliminarAnunciosActuales;
import ux.Resultado;

/**
 *
 * @author 50369
 */
public class Procesos_almacenados {

    private Resultado resultado;
    int CorreoVal = 0;

    public boolean In_admin_clinica_users(Administrador modeloadmin, Usuarios modelousuarios, Clinica modeloclinica) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = (Connection) ConnectionSQL.getConexion();
            ps = conn.prepareStatement("EXEC PDRegistrarAdmin ?, ?, ?, ?");
            ps.setString(1, modeloadmin.getNombre());
            ps.setString(2, modelousuarios.getUserName());
            ps.setString(3, modelousuarios.getContraseña());
            ps.setString(4, modeloclinica.getIDClinica());
            System.out.println("Exitooo");
            System.out.println(modeloadmin.getNombre());
            ps.executeUpdate();
            System.out.println("Lo lograste");
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error J001GU, el usuario ya existe", "Error al crear el usuario", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e.toString());
            return false;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void SaberID(Usuarios modelusuarios, Administrador modelAdmin) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = ConnectionSQL.getConexion();
            cs = conn.prepareCall("{CALL ObtenerIDAdministrador(?, ?)}");

            cs.setString(1, modelusuarios.getUserName());
            cs.registerOutParameter(2, java.sql.Types.INTEGER);

            cs.execute();

            // Obtener el resultado del parámetro de salida
            int IDAdministrador = cs.getInt(2);
            modelAdmin.setIDUsuario(IDAdministrador);
            System.out.println("Este es el ID " + (IDAdministrador));
        } catch (Exception e) {
            System.out.println("Error #J00DA");
            JOptionPane.showMessageDialog(null, "Error: J000DA", "Credenciales incorrectas", JOptionPane.INFORMATION_MESSAGE);

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    public void SaberIDTer(Usuarios modelusuarios, Terapeutas modelTerapeuta) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = ConnectionSQL.getConexion();
            cs = conn.prepareCall("{CALL ObtenerIDTerapeuta(?, ?)}");

            cs.setString(1, modelusuarios.getUserName());
            cs.registerOutParameter(2, java.sql.Types.INTEGER);

            cs.execute();

            // Obtener el resultado del parámetro de salida
            int IDAdministrador = cs.getInt(2);
            modelTerapeuta.setIDTerapeuta(IDAdministrador);
            System.out.println("Este es el ID de la terpeuta " + (IDAdministrador));
        } catch (Exception e) {
            System.out.println("Error #J00DA");
            JOptionPane.showMessageDialog(null, "Error: J000DA", "Credenciales incorrectas", JOptionPane.INFORMATION_MESSAGE);

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    public void SaberIDSecre(Usuarios modelusuarios, Secretarias ModelSecret) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = ConnectionSQL.getConexion();
            cs = conn.prepareCall("{CALL ObtenerIDSecretaria(?, ?)}");

            cs.setString(1, modelusuarios.getUserName());
            cs.registerOutParameter(2, java.sql.Types.INTEGER);

            cs.execute();

            // Obtener el resultado del parámetro de salida
            int IDAdministrador = cs.getInt(2);
            ModelSecret.setIDSecretaria(IDAdministrador);
            System.out.println("Este es el ID de la secretaria" + (IDAdministrador));
        } catch (Exception e) {
            System.out.println("Error #J00DA");
            JOptionPane.showMessageDialog(null, "Error: J000DA", "Credenciales incorrectas", JOptionPane.INFORMATION_MESSAGE);

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    public void Logear(Usuarios modelousuarios) {
        int acceso = 0;
        int nivelusuario = 0;
        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = ConnectionSQL.getConexion();
            cs = conn.prepareCall("{CALL PDLogear(?, ?, ?, ?)}");
            cs.setString(1, modelousuarios.getUserName()); // aqui se manda el username para db
            cs.setString(2, modelousuarios.getContraseña()); // aqui se manda la contraseña para db
            cs.registerOutParameter(3, java.sql.Types.INTEGER);  // Para @resultado
            cs.registerOutParameter(4, java.sql.Types.INTEGER);  // Para @ventana

            cs.execute();

            // Obtener los valores de los parámetros de salida
            int resultado = cs.getInt(3);  // Obtener el valor de salida @resultado, resultado puede devolver 0 y 1. 1 si existe el usuario y 0 si no existe
            int ventana = cs.getInt(4);    // Obtener el valor de salida @ventana, resultado puede devolver 1, 2, 3, 4, es para diferenciar el nivel de usuario

            modelousuarios.setAcceso(ventana);
            modelousuarios.setResultado(resultado);
            System.out.println(resultado);
            System.out.println(ventana);
        } catch (Exception e) {
            System.out.println("Error #J00DA");
            JOptionPane.showMessageDialog(null, "Error: J000DA", "Credenciales incorrectas", JOptionPane.INFORMATION_MESSAGE);

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean RecCorreo(Usuarios modelUsers, Contactos ModelContactos) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = (Connection) ConnectionSQL.getConexion();
            ps = conn.prepareStatement("Exec PDActualizarContraGmail ?, ?;");
            ps.setString(1, ModelContactos.getCorreo());
            ps.setString(2, modelUsers.getContraseña());
            System.out.println("Exitooo en el cambio de contraseña");
            ps.executeUpdate();
            System.out.println("Lo lograste");
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "J001GU", "Error al actualizar contraseña", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e.toString());
            return false;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean RecTelefono(Usuarios ModelUsers, Contactos ModelContactos) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = (Connection) ConnectionSQL.getConexion();
            ps = conn.prepareStatement("Exec PDActualizarContraNum ?, ?;");
            ps.setString(1, ModelUsers.getContraseña());
            ps.setString(2, ModelContactos.getNumTelefonico());
            System.out.println("Exitooo");
            ps.executeUpdate();
            System.out.println("Lo lograste");
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "J001DA ", "Error al enviar mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e.toString());
            return false;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean ValCorreo(Contactos ModelContactos) {

        PreparedStatement ps;
        Connection conn;
        try {
            conn = ConnectionSQL.getConexion();
            ps = conn.prepareStatement("DECLARE @CorreoExis INT; EXEC PdBuscarCorreo ?, @CorreoExis OUTPUT; SELECT @CorreoExis AS Correoexistente;");
            ps.setString(1, ModelContactos.getCorreoVal());

            //ResultSet rs = ps.executeQuery("SELECT @resultado AS acceso");
            //ResultSet rs1 = ps.executeQuery("SELECT @ventana AS abrirventana");
            ResultSet rs = ps.executeQuery();

            System.out.println(ModelContactos.getCorreoVal());
            System.out.println(ModelContactos.getCorreo());
            while (rs.next()) {
                int Correo1 = rs.getInt("Correoexistente");

                if (Correo1 == 1) {
                    ModelContactos.setCorreo(ModelContactos.getCorreoVal());
                    System.out.println("O sea que si existe pues");
                } else {
                    System.out.println("Erroraso en modelo");

                    JOptionPane.showMessageDialog(null, "J022DA ", "Error al enviar correo ee", JOptionPane.INFORMATION_MESSAGE);
                }
                System.out.println(ModelContactos.getCorreoVal());
                System.out.println(ModelContactos.getCorreo());
            }
            /*
            while(rs1.next()){
                nivelusuario = rs1.getInt(1);
                modelousuarios.setResultado(nivelusuario);
                System.out.println(nivelusuario);
            }*/

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "J00DA ", "Error con la base de datos", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }
        return false;
    }

    public boolean valTelefono(Contactos ModelContactos) {
        int TelefonoVal = 0;
        PreparedStatement ps;
        Connection conn;
        try {
            conn = ConnectionSQL.getConexion();
            ps = conn.prepareStatement("DECLARE @CorreoExis INT; EXEC PdBuscarCorreo ?, @CorreoExis OUTPUT; SELECT @CorreoExis AS Correoexistente;");
            ps.setString(1, ModelContactos.getNumTelefonicoVal());

            //ResultSet rs = ps.executeQuery("SELECT @resultado AS acceso");
            //ResultSet rs1 = ps.executeQuery("SELECT @ventana AS abrirventana");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // acceso = rs.getInt(1); // Obtener el valor de la variable de salida @resultado
                // modelousuarios.setAcceso(acceso);
                //System.out.println(acceso);
                if (TelefonoVal == 1) {
                    ModelContactos.setNumTelefonico(ModelContactos.getNumTelefonicoVal());
                } else {
                    JOptionPane.showMessageDialog(null, "J022DA ", "Error al enviar mensaje", JOptionPane.INFORMATION_MESSAGE);
                }

            }
            /*
            while(rs1.next()){
                nivelusuario = rs1.getInt(1);
                modelousuarios.setResultado(nivelusuario);
                System.out.println(nivelusuario);
            }*/

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "J00DA ", "Error con la base de datos", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }
        return false;
    }

    public int PrimerUso(Usuarios modelousuarios, int operacion) {
        int resultado = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConnectionSQL.getConexion();

            switch (operacion) {
                case 1: // 1 para update
                    // Realizar la actualización
                    ps = conn.prepareStatement("UPDATE TbUsuarios SET Primeruso = ? WHERE Username = ?");
                    ps.setInt(1, modelousuarios.getPrimerUso());
                    ps.setString(2, modelousuarios.getUserName());
                    resultado = ps.executeUpdate();
                    break;

                case 2: // 2 para select
                    // Realizar la consulta
                    ps = conn.prepareStatement("SELECT Primeruso FROM TbUsuarios WHERE Username = ?");
                    ps.setString(1, modelousuarios.getUserName());
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        modelousuarios.setPrimerUso(rs.getInt("Primeruso"));
                    }
                    break;

                default:
                    // Manejar un caso no válido
                    JOptionPane.showMessageDialog(null, "Operación no válida: " + operacion, "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: J009UI", "Error inesperado, cierre sesión y vuelva a abrir sesión", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultado;
    }

    public void CRUDprimeruso(Usuarios modelousuarios, Contactos modelContactos, ActividadesLaborales modelActivity,
            Genero modelGenero, int operacion, Administrador modelAdministrador) {

        Connection conn = null;
        CallableStatement cs = null;

        switch (operacion) {
            case 1:
                //Case 1 sirve para ver los datos existentes
        try {
                conn = ConnectionSQL.getConexion();
                cs = conn.prepareCall("{CALL PDprimerusoinfo(?, ?, ?, ?, ?, ?, ?)}");
                cs.setString(1, modelousuarios.getUserName()); // aqui se manda el username para db
                cs.registerOutParameter(2, java.sql.Types.VARCHAR);  // Para @Correo
                cs.registerOutParameter(3, java.sql.Types.VARCHAR);  // Para @ActividadLab
                cs.registerOutParameter(4, java.sql.Types.DATE);  // Para @fechadenaci
                cs.registerOutParameter(5, java.sql.Types.VARCHAR);  // Para @Numerodetel
                cs.registerOutParameter(6, java.sql.Types.VARCHAR);  // Para @DUI
                cs.registerOutParameter(7, java.sql.Types.INTEGER);  // Para @Genero

                cs.execute();

                // Obtener los valores de los parámetros de salida
                String Correo = cs.getString(2);  // Obtener correo de tipo Varchar
                String AcividadLab = cs.getString(3);    // Obtener correo de tipo Varchar
                java.sql.Date fechaNacimient = cs.getDate(4);    // Obtener correo de tipo DATE
                String Numerodetel = cs.getString(5);    // Obtener correo de tipo Varchar
                String DUI = cs.getString(6);    // Obtener correo de tipo Varchar
                int genero = cs.getInt(7);    // Obtener genero que es de tipo INT

                modelContactos.setCorreo(Correo);
                modelContactos.setNumTelefonico(Numerodetel);
                modelGenero.setGenero(genero);
                modelActivity.setActiviadadLaboral(AcividadLab);
                modelAdministrador.setDUI(DUI);
                modelAdministrador.setFNacimiento(fechaNacimient);

            } catch (Exception e) {
                System.out.println("Error #J00DA");
                JOptionPane.showMessageDialog(null, "Error innesperado al cargar datos, reinicie su aplicación", "Error: J000DA", JOptionPane.INFORMATION_MESSAGE);

                e.printStackTrace();
            } finally {
                try {
                    if (cs != null) {
                        cs.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            break;
            case 2:
            try {
                conn = ConnectionSQL.getConexion();
                cs = conn.prepareCall("{CALL PDPrimerUso(?, ?, ?, ?, ?, ?, ?)}");
                cs.setString(1, modelousuarios.getUserName()); // aqui se manda el username para db
                cs.setString(2, modelContactos.getCorreo()); // aqui se manda el correo para db
                cs.setString(3, modelActivity.getActiviadadLaboral()); // aqui se manda el correo para db
                cs.setDate(4, (Date) modelAdministrador.getFNacimiento()); // aqui se manda el correo para db
                cs.setString(5, modelContactos.getNumTelefonico()); // aqui se manda el correo para db
                cs.setString(6, modelAdministrador.getDUI()); // aqui se manda el username para db
                cs.setInt(7, modelGenero.getGenero()); // aqui se manda el username para db

                cs.execute();

            } catch (Exception e) {
                System.out.println("Error #J00DA");
                JOptionPane.showMessageDialog(null, "Tiene datos ya registrados en el sistema anteriormente", "Error: J015UI", JOptionPane.INFORMATION_MESSAGE);

                e.printStackTrace();
            } finally {
                try {
                    if (cs != null) {
                        cs.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            break;
        }

    }

    public List<Resultado> Pacientes(Pacientes modelPaciente, int operacion, String textoBusqueda) {
        {
            Connection conn = null;
            PreparedStatement ps = null;
            List<Resultado> resultados = new ArrayList<>();

            try {
                conn = ConnectionSQL.getConexion();

                switch (operacion) {
                    case 1:
                        ps = conn.prepareStatement("SELECT IdPaciente, nombre, apellido FROM TbPacientes WHERE nombre LIKE ?;");
                        ps.setString(1, "%" + textoBusqueda + "%");
                        ResultSet rs = ps.executeQuery();
                        System.out.println("%" + textoBusqueda + "%");
                        while (rs.next()) {
                            int id = rs.getInt("IdPaciente");
                            String nombre = rs.getString("nombre");
                            String apellido = rs.getString("apellido");

                            // Crea un objeto Resultado y agrégalo a la lista de resultados
                            Resultado resultado = new Resultado(id, nombre, apellido);
                            resultados.add(resultado);
                        }

                        break;

                    case 2: // 2 para select

                        break;

                    default:
                        // Manejar un caso no válido
                        JOptionPane.showMessageDialog(null, "Operación no válida: " + operacion, "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: J009UI", "Error inesperado, cierre sesión y vuelva a abrir sesión", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return resultados;
        }

    }

    public int viewpaciente(Pacientes modelpaciente, Usuarios modelousuarios, Contactos modelContactos, int operacion) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConnectionSQL.getConexion();

            switch (operacion) {
                case 1: // 1 para recibir
                    try (
                            CallableStatement cs = conn.prepareCall("{CALL PDinforPacienteview(?, ?, ?, ?, ?, ?)}")) {

                        cs.setInt(1, modelpaciente.getIDpaciente());
                        cs.registerOutParameter(2, java.sql.Types.VARCHAR);
                        cs.registerOutParameter(3, java.sql.Types.INTEGER);
                        cs.registerOutParameter(4, java.sql.Types.VARCHAR);
                        cs.registerOutParameter(5, java.sql.Types.VARBINARY);
                        cs.setString(6, modelpaciente.getMensajito()); // Valor para el último parámetro

                        cs.execute();

                        String nombre = cs.getString(2);
                        int fechaNacimiento = cs.getInt(3);
                        String correo = cs.getString(4);
                        byte[] imagen = cs.getBytes(5);

                        // Haz lo que necesites con los valores obtenidos, como mostrarlos o asignarlos a objetos.
                        modelpaciente.setNombre(nombre);
                        modelpaciente.setFnacimiento(fechaNacimiento);
                        modelContactos.setCorreo(correo);
                        modelousuarios.setFPerfil(imagen);

                        // La variable 'imagen' contiene la imagen en formato byte[] que puedes usar según tus necesidades.
                    } catch (Exception e) {
                        System.out.println("Error #J00DA");
                        JOptionPane.showMessageDialog(null, "Error inesperado al cargar datos, reinicie su aplicación", "Error: J000DA", JOptionPane.WARNING_MESSAGE);

                    }
                    break;

                case 2: // 2 para enviar mensajes
                    // Realizar la consulta
                    System.out.println("No sé que pasa, estamos en el modelo Procesos " + modelpaciente.getIDpaciente() + modelpaciente.getMensajito());
                    ps = conn.prepareStatement("EXEC PDenviarmensajedeCariño ?, ?");
                    ps.setInt(1, modelpaciente.getIDpaciente());
                    ps.setString(2, modelpaciente.getMensajito());
                    ps.executeUpdate();
                    break;

                default:
                    // Manejar un caso no válido
                    JOptionPane.showMessageDialog(null, "Operación no válida", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: J009UI", "Error inesperado, cierre sesión y vuelva a abrir sesión", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public void agregarecetas(RecetasMedicas recetas) {

        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = ConnectionSQL.getConexion();
            cs = conn.prepareCall("INSERT INTO TbRecetasMedicas(Padecimiento, Descripcion, NombreMedicamento) VALUES (?,?,?)");
            cs.setString(1, recetas.getNombrePadecimiento());
            cs.setString(2, recetas.getDescripcion());
            cs.setString(3, recetas.getMwedicamentos());

            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "Receta guardada", "Exito", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            System.out.println("Error #J00DA");
            JOptionPane.showMessageDialog(null, "Error innesperado al cargar datos, reinicie su aplicación", "Error: J000DA", JOptionPane.INFORMATION_MESSAGE);

            e.printStackTrace();
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public int Acercademi(Usuarios modelousuarios, int operacion) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConnectionSQL.getConexion();

            switch (operacion) {
                case 1: // 1 para recibir
                    try (
                            CallableStatement cs = conn.prepareCall("SELECT TOP 1 Descripcion FROM TbUsuarios Where UserName = ?")) {

                        cs.setString(1, modelousuarios.getUserName());
                        cs.registerOutParameter(2, java.sql.Types.VARBINARY);

                        cs.execute();

                        String Descripcion = cs.getString(2);

                        modelousuarios.setDescripcion(Descripcion);

                        // La variable 'imagen' contiene la imagen en formato byte[] que puedes usar según tus necesidades.
                    } catch (Exception e) {
                        System.out.println("Error #J00DA");
                        JOptionPane.showMessageDialog(null, "Error inesperado al cargar datos, reinicie su aplicación", "Error: J000DA", JOptionPane.WARNING_MESSAGE);

                    }
                    break;

                case 2: // 2 para enviar mensajes
                    // Realizar la consulta

                    ps = conn.prepareStatement("EXEC PDCambiarContraseña ?, ?, ?");
                    ps.setString(1, modelousuarios.getUserName());
                    ps.setString(2, modelousuarios.getContraseña());
                    ps.setString(3, modelousuarios.getContrafake());
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Cierra sesión para comprobar tu cambio de contraseña", "Sgurencia", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 3: // 2 para enviar mensajes
                    // Realizar la consulta

                    ps = conn.prepareStatement("EXEC PDDetallesperfil ?, ?");
                    ps.setString(1, modelousuarios.getUserName());
                    ps.setString(2, modelousuarios.getDescripcion());
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Cierra sesión para comprobar tu cambio de contraseña", "Sgurencia", JOptionPane.INFORMATION_MESSAGE);
                    break;

                default:
                    // Manejar un caso no válido
                    JOptionPane.showMessageDialog(null, "Operación no válida", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: J009UI", "Error inesperado, cierre sesión y vuelva a abrir sesión", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public boolean AgregarEmpleado(Administrador modelAdmin, Empleado modelEmpleado, Usuarios modelUsuario, Contactos modelContactos) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = ConnectionSQL.getConexion();
            cs = conn.prepareCall("{CALL PDCrearEmpleado(?, ?, ?, ?, ?, ?, ?)}");

            // Configura los parámetros del procedimiento almacenado
            cs.setInt(1, modelAdmin.getIDUsuario());
            cs.setString(2, modelContactos.getCorreo());
            cs.setString(3, modelEmpleado.getUsername());
            cs.setString(4, modelEmpleado.getContraseña());
            cs.setInt(5, modelEmpleado.getNivel());
            cs.setString(6, modelEmpleado.getNombre());
            cs.setBytes(7, modelEmpleado.getFotoPerfil());
            // Ejecuta el procedimiento almacenado
            cs.execute();

            // Si llega hasta aquí sin excepciones, la inserción se realizó con éxito
            return true;
        } catch (SQLException e) {
            // Manejo de excepciones en caso de error
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<Resultado> Empleados(Empleado modelEmpleado, int operacion, String textoBusqueda) {
        {
            Connection conn = null;
            PreparedStatement ps = null;
            List<Resultado> resultados = new ArrayList<>();

            try {
                conn = ConnectionSQL.getConexion();

                switch (operacion) {
                    case 1:
                        ps = conn.prepareStatement("SELECT ID, Nombre, DUI, NombreDeActividad, IDUsuarioEm, Edad, FotoPerfil \n"
                                + "FROM VistaEmpleadosConActividad\n"
                                + "WHERE Nombre LIKE ?;");
                        ps.setString(1, "%" + textoBusqueda + "%");
                        ResultSet rs = ps.executeQuery();
                        System.out.println("%" + textoBusqueda + "%");
                        while (rs.next()) {
                            int idUsuario = rs.getInt("ID");
                            String Nombre = rs.getString("Nombre");
                            String DUI = rs.getString("DUI");
                            String ActividadLaboral = rs.getString("NombreDeActividad");
                            int IDUsuarioEm = rs.getInt("IDUsuarioEm");
                            int Edad = rs.getInt("Edad");

                            // Obtener la imagen de perfil como un arreglo de bytes
                            byte[] imagenBytes = rs.getBytes("FotoPerfil");

                            // Convierte los bytes en una imagen BufferedImage
                            // Convierte los bytes en una imagen BufferedImage
                            BufferedImage fotoPerfil = null;
                            if (imagenBytes != null && imagenBytes.length > 0) {
                                try {
                                    fotoPerfil = ImageIO.read(new ByteArrayInputStream(imagenBytes));
                                } catch (IOException e) {
                                    System.err.println("Error al leer la imagen de perfil: " + e.getMessage());
                                }
                            }

                            modelEmpleado.setNombre(Nombre);
                            modelEmpleado.setDUI(DUI);
                            modelEmpleado.setIdEmpleado(idUsuario);
                            modelEmpleado.setActividadLab(ActividadLaboral);
                            modelEmpleado.setIDUsuario(IDUsuarioEm);
                            modelEmpleado.setEdad(Edad);

                            // Establecer la imagen de perfil en el modelo
                            modelEmpleado.setFotoPerfil(imagenBytes);

                            System.out.println(modelEmpleado.getNombre() + " " + modelEmpleado.getEdad() + " " + " " + " " + " " + " ");

                            // Crea un objeto Resultado y agrégalo a la lista de resultados
                            Resultado resultado = new Resultado(idUsuario, Nombre, ActividadLaboral);
                            resultados.add(resultado);
                        }
                        break;

                    case 2: // 2 para select a la demas información

                        break;

                    default:
                        // Manejar un caso no válido
                        JOptionPane.showMessageDialog(null, "Operación no válida: " + operacion, "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: J009UI", "Error inesperado, cierre sesión y vuelva a abrir sesión", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return resultados;
        }

    }

    public void VerNotasPac(Pacientes modelPaciente, AgendasPersonales modelAgendas) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConnectionSQL.getConexion();

            ps = conn.prepareStatement("SELECT TOP 1 Contenido FROM TbAgendasPersonales WHERE IDPaciente = ?;");
            ps.setInt(1, modelPaciente.getIDpaciente());
            rs = ps.executeQuery();

            while (rs.next()) {
                String Contenido = rs.getString("Contenido");
                modelAgendas.setContenido(Contenido);
                System.out.println("Llegue hasta aqui " + Contenido);
            }
        } catch (Exception e) {
            System.out.println("Error #J00DA");
            JOptionPane.showMessageDialog(null, "Error: J000DA", "El paciente aún no ha escrito en su agenda", JOptionPane.INFORMATION_MESSAGE);

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean AgregarAnuncio(Anuncios modelAnuncios) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean insercionExitosa = false; // Agregamos una variable para indicar el éxito de la inserción

        try {
            conn = ConnectionSQL.getConexion();

            ps = conn.prepareStatement("INSERT INTO TbAnuncio(Titulo, Imagen) VALUES (?, ?)");
            ps.setString(1, modelAnuncios.getTitulo());
            ps.setBytes(2, modelAnuncios.getImagen());
            int filasAfectadas = ps.executeUpdate();

            // Si una fila o más fueron afectadas, consideramos que la inserción fue exitosa
            if (filasAfectadas > 0) {
                insercionExitosa = true;
            }
        } catch (Exception e) {
            System.out.println("Error #J00DA");
            JOptionPane.showMessageDialog(null, "Error: J000DA", "El paciente aún no ha escrito en su agenda", JOptionPane.INFORMATION_MESSAGE);

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return insercionExitosa; // Devolvemos true si la inserción fue exitosa, de lo contrario, false
    }

    public boolean AgregarArticulo(Articulos modelArt, Terapeutas modelTer, int caso) {
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        boolean insercionExitosa = false;

        try {
            conn = ConnectionSQL.getConexion();
            cs = conn.prepareCall("{CALL PDArticulosInsertOupdate(?, ?, ?, ?, ?)}");

            // Configurar los parámetros de entrada
            System.out.println(modelTer.getIDTerapeuta());
            System.out.println(modelArt.getTitulo());
            System.out.println(modelArt.getDescripcion());
            cs.setInt(1, modelTer.getIDTerapeuta());
            cs.setString(2, modelArt.getTitulo());
            cs.setString(3, modelArt.getDescripcion());
            cs.setBytes(4, modelArt.getImagen());

            cs.registerOutParameter(5, java.sql.Types.INTEGER);

            cs.execute();

            // Obtener el valor del parámetro de salida
            int idArticuloGenerado = cs.getInt(5);

            // Si idArticuloGenerado es mayor que 0, la inserción o actualización fue exitosa
            if (idArticuloGenerado > 0) {
                insercionExitosa = true;
            }
        } catch (Exception e) {
            // Manejo de excepciones
        } finally {
            // Cerrar recursos
        }

        return insercionExitosa;
    }

    public void RedactarPermiso(Incapacidades modelIncap, Usuarios modelUsers) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConnectionSQL.getConexion();

            ps = conn.prepareStatement("EXEC PDPermiso ?, ?, ?");
            ps.setString(2, modelIncap.getMensaje());
            ps.setString(1, modelIncap.getAsunto());
            ps.setInt(3, modelUsers.getIDUsuario());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error #J00DA");
            JOptionPane.showMessageDialog(null, "Error: J000DA", "Error innesperado, reinicie la aplicación", JOptionPane.INFORMATION_MESSAGE);

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void SaberIDUsuario(Usuarios modelUsers) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConnectionSQL.getConexion();

            ps = conn.prepareStatement("SELECT TOP 1 IDUsuario FROM TbUsuarios WHERE UserName = ?");
            ps.setString(1, modelUsers.getUserName());
            rs = ps.executeQuery();
            System.out.println("Este es el username ingresado " + modelUsers.getUserName());
            while (rs.next()) {
                int Contenido = rs.getInt("IDUsuario");
                modelUsers.setIDUsuario(Contenido);
            }
        } catch (Exception e) {
            System.out.println("Error #J00DA");
            JOptionPane.showMessageDialog(null, "Error: J000DA", "Error innesperado, verifique que el username no este vacio", JOptionPane.INFORMATION_MESSAGE);

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void SaberIDClinica(Clinica modelClinica, Usuarios modelUsers) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConnectionSQL.getConexion();

            ps = conn.prepareStatement("SELECT TOP 1 IDClinica FROM VistaClinicaUsuario WHERE IDUsuario = ?;");
            ps.setInt(1, modelUsers.getIDUsuario());
            rs = ps.executeQuery();
            System.out.println("El IDUsuario es: " + modelUsers.getIDUsuario());
            while (rs.next()) {
                String IDclinica = rs.getString("IDClinica");
                modelClinica.setIDClinica(IDclinica);
            }
        } catch (Exception e) {
            System.out.println("Error #J00DA");
            JOptionPane.showMessageDialog(null, "Error: J000DA", "Error innesperado, este usuario no tiene una clinica, crea otra cuenta", JOptionPane.INFORMATION_MESSAGE);

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void VerExpe(Expedientes modelExp, Pacientes modelPaci) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConnectionSQL.getConexion();

            ps = conn.prepareStatement("SELECT TOP 1 Contenido FROM TbExpedientes where IDPaciente = ?");
            ps.setInt(1, modelPaci.getIDpaciente());
            rs = ps.executeQuery();

            while (rs.next()) {
                String Contenido = rs.getString("Contenido");
                modelExp.setContenido(Contenido);
            }
        } catch (Exception e) {
            System.out.println("Error #J00DA");
            JOptionPane.showMessageDialog(null, "Error: J000DA", "Error al cargar los datos del expediente", JOptionPane.INFORMATION_MESSAGE);

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void EscribirExpe(Pacientes modelPacie, Terapeutas modelTerap, Expedientes modelExp) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConnectionSQL.getConexion();

            ps = conn.prepareStatement("EXEC InsertarActualizarExpediente ?, ?, ?");
            ps.setInt(1, modelPacie.getIDpaciente());
            System.out.println("Este es el IDPaciente del expediente: " + modelPacie.getIDpaciente());
            ps.setString(2, modelExp.getContenido());
            ps.setInt(3, modelTerap.getIDTerapeuta());
            System.out.println("Este es el IDTerapeuta: " + modelTerap.getIDTerapeuta());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error #J00DA");
            JOptionPane.showMessageDialog(null, "Error: J000DA", "Error innesperado, Vuelva al menú e intenté más tadre", JOptionPane.INFORMATION_MESSAGE);

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    //SELECT Titulo, Fecha, Imagen FROM TbAnuncio;
    public void GenerarAnuncios(Anuncios modelAnuncios, AnunciosActuales anunciosController) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConnectionSQL.getConexion();
            ps = conn.prepareStatement("SELECT Titulo, Fecha, Imagen FROM TbAnuncio;");
            rs = ps.executeQuery();

            while (rs.next()) {
                String titulo = rs.getString("Titulo");
                Date fecha = rs.getDate("Fecha");
                byte[] imagenData = rs.getBytes("Imagen");
                int i = 0;
                // Llama al método para apilar el componente
                System.out.println("Se ponen datos por: " + i++);
                anunciosController.apilarComponentesEnBoxLayout(fecha, titulo, imagenData);
            }
        } catch (Exception e) {
            System.out.println("Error #J00DA");
            JOptionPane.showMessageDialog(null, "Error: J000DA", "Error inesperado, este usuario no tiene una clínica, crea otra cuenta", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void GenerarAnunciosEli(Anuncios modelAnuncios, EliminarAnunciosActuales anunciosController) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConnectionSQL.getConexion();
            ps = conn.prepareStatement("SELECT IDAnuncio, Titulo, Fecha, Imagen FROM TbAnuncio;");
            rs = ps.executeQuery();

            while (rs.next()) {
                int IDAnuncio = rs.getInt("IDAnuncio");
                String titulo = rs.getString("Titulo");
                Date fecha = rs.getDate("Fecha");
                byte[] imagenData = rs.getBytes("Imagen");
                int i = 0;
                // Llama al método para apilar el componente
                System.out.println("Se ponen datos por: " + i++);
                anunciosController.apilarComponentesEnBoxLayout(IDAnuncio, fecha, titulo, imagenData);
            }
        } catch (Exception e) {
            System.out.println("Error #J00DA");
            JOptionPane.showMessageDialog(null, "Error: J000DA", "Error inesperado, este usuario no tiene una clínica, crea otra cuenta", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void BorrarAnuncio(Anuncios modelAnuncios) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConnectionSQL.getConexion();

            ps = conn.prepareStatement("DELETE TbAnuncio WHERE IDAnuncio = ?");
            ps.setInt(1, modelAnuncios.getIDAnuncio());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error #J00DA");
            JOptionPane.showMessageDialog(null, "Error: J000DA", "Error innesperado, Vuelva al menú e intenté más tadre", JOptionPane.INFORMATION_MESSAGE);

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void GenerarDocumentos(Articulos modelArticulo, DocumentosDeApoyo DocsController) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConnectionSQL.getConexion();
            ps = conn.prepareStatement("SELECT IDArticulo, Titulo, Imagen FROM TbArticulos;");
            rs = ps.executeQuery();

            while (rs.next()) {
                int IDAnuncio = rs.getInt("IDArticulo");
                String titulo = rs.getString("Titulo");
                byte[] imagenData = rs.getBytes("Imagen");

                System.out.println("Se ponen datos por: " + titulo + IDAnuncio);
                DocsController.generarPanelesDeDocumentos(IDAnuncio, titulo, imagenData);
                System.out.println("Esto contiene el IDArticulo: " + IDAnuncio);
            }
        } catch (Exception e) {
            System.out.println("Error #J00DA");
            JOptionPane.showMessageDialog(null, "Error: J000DA", "Error inesperado, este usuario no tiene una clínica, crea otra cuenta", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void BorrarArticulo(Articulos modelArituculos) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConnectionSQL.getConexion();

            // Eliminar de TbCantidadArticulo
            ps = conn.prepareStatement("DELETE FROM TbCantidadArticulo WHERE IDArticulo = ?");
            ps.setInt(1, modelArituculos.getIDArticulo());
            int deletedRows = ps.executeUpdate();

            if (deletedRows > 0) {
                // La eliminación en TbCantidadArticulo tuvo éxito, ahora eliminar de TbArticulos
                ps = conn.prepareStatement("DELETE FROM TbArticulos WHERE IDArticulo = ?");
                ps.setInt(1, modelArituculos.getIDArticulo());
                int deletedRowsArticulos = ps.executeUpdate();

                if (deletedRowsArticulos > 0) {
                    // Ambas eliminaciones tuvieron éxito
                    System.out.println("Eliminación exitosa de ambas tablas.");
                } else {
                    // La eliminación en TbArticulos falló
                    System.out.println("La eliminación en TbArticulos falló.");
                }
            } else {
                // La eliminación en TbCantidadArticulo falló
                System.out.println("La eliminación en TbCantidadArticulo falló.");
            }
        } catch (Exception e) {
            System.out.println("Error #J00DA");
            JOptionPane.showMessageDialog(null, "Error: J000DA", "Error innesperado, Vuelva al menú e intenté más tarde", JOptionPane.INFORMATION_MESSAGE);

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int viewpermiso(Empleado modelempleado, Incapacidades modelincapacidad) {

        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = ConnectionSQL.getConexion();
            cs = conn.prepareCall("{CALL PDVerPermiso(?, ?, ?)}");

            cs.setInt(1, modelempleado.getIDUsuario());
            cs.registerOutParameter(2, java.sql.Types.VARCHAR);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);

            cs.execute();

            // Obtener el resultado del parámetro de salida
            String Asunto = cs.getString(2);
            String Contenido = cs.getString(3);
            modelincapacidad.setAsunto(Asunto);
            modelincapacidad.setMensaje(Contenido);
            System.out.println("Este es el Asuntito " + (Asunto));
            System.out.println("Este es el Mnesaje " + (Contenido));
        } catch (Exception e) {
            System.out.println("Error #J00DA");
            JOptionPane.showMessageDialog(null, "Advertencia: J009UI", "Este empleado envio un permiso vacio", JOptionPane.INFORMATION_MESSAGE);

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

        return 0;
    }

    public boolean ActualizarPermiso(Empleado modelempleado, int caso) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = (Connection) ConnectionSQL.getConexion();
            ps = conn.prepareStatement("Exec ActualizarAceptado ?, ?;");
            ps.setInt(1, modelempleado.getIDUsuario());
            ps.setInt(2, caso);
            System.out.println("Exitooo");
            ps.executeUpdate();
            System.out.println("Caso con numero: "+ caso);
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "J001DA ", "Error al interactuar con este permiso, vuelve ha intentarlo en unos minutos", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e.toString());
            return false;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Resultado> VerSolicitudes(Empleado modelEmpleado, Incapacidades modelPermiso, int Estado) {
        {
            Connection conn = null;
            PreparedStatement ps = null;
            List<Resultado> resultados = new ArrayList<>();

            try {
                conn = ConnectionSQL.getConexion();

                ps = conn.prepareStatement("SELECT *\n"
                        + "FROM VistaPermisos\n"
                        + "WHERE aceptado = ?;");
                ps.setInt(1, Estado);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int idUsuario = rs.getInt("IDUsuario");
                    String Nombre = rs.getString("Nombre");
                    String Asunto = rs.getString("Asunto");

                    modelEmpleado.setNombre(Nombre);
                    modelPermiso.setAsunto(Asunto);
                    modelEmpleado.setIDUsuario(idUsuario);

                    // Establecer la imagen de perfil en el modelo
                    System.out.println(modelEmpleado.getIDUsuario() + " " + modelEmpleado.getNombre() + " " + modelPermiso.getAsunto());

                    // Crea un objeto Resultado y agrégalo a la lista de resultados
                    Resultado resultado = new Resultado(idUsuario, Nombre, Asunto);
                    resultados.add(resultado);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: J009UI", "Error inesperado, cierre sesión y vuelva a abrir sesión", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return resultados;
        }

    }
    public void Crearcita(Citas citas) {

        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = ConnectionSQL.getConexion();
            cs = conn.prepareCall("INSERT INTO TbCitas(Fecha, IDTerapeuta, Hora, IDPaciente) VALUES (?,?,?,?)");
            cs.setDate(1, (Date) citas.getFecha());
            // cs.setDate(4, (Date) modelAdministrador.getFNacimiento()); 
            cs.setInt(2, citas.getIDTerapeuta());
            cs.setString(3, citas.getHora());
            cs.setInt(4, citas.getIDPaciente());

            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "Receta guardada", "Exito", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            System.out.println("Error #J00DA");
            JOptionPane.showMessageDialog(null, "Error innesperado al cargar datos, reinicie su aplicación", "Error: J000DA", JOptionPane.INFORMATION_MESSAGE);

            e.printStackTrace();
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
}
