/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import modelo.*;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.driver.*;




/**
 *
 * @author Duoc
 */
public class Conexion {
    
    BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    int id = -1;
    Connection cn = null;



    public Conexion() throws SQLException{
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "portafolio", "admin");
    }
    //ALUMNO
    public int insertUpdatePersona(Persona persona, String tipo)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call SP_DO_SET_DEL_PERSONA (?,?,?,?,?,?,?,?,?,?)} ");
            cst.setString("TIPO", tipo);
            cst.setString("P_RUT", persona.getRut());
            cst.setString("P_NOMBRE", persona.getNombre());
            cst.setString("P_APELLIDO_PATERNO",persona.getApellido_paterno());
            cst.setString("P_APELLIDO_MATERNO",persona.getApellido_materno());
            cst.setDate("P_FECHA_NACIMIENTO", persona.getFecha_nacimiento());
            cst.setString("P_EMAIL", persona.getEmail());
            cst.setInt("P_EDAD", persona.getEdad());
            cst.setInt("P_TELEFONO_MOVIL", persona.getTelefono_movil());
            cst.setInt("P_TELEFONO_FIJO", persona.getTelefono_fijo());
            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
     
    public boolean verificarUsuario(String usuario, String contrasena, String tipo)
    {
        try {
            CallableStatement cst = cn.prepareCall("{call VERIFICARLOGINAPP (?,?)} ");
            cst.setString(1, usuario);
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.execute();
            String basecontrasena = cst.getString(2);
            return contrasena.equals(basecontrasena);
        }
        catch(Exception ex)
        {
            return false;
        }
    }
    
    //Asignatura
    public int insertUpdateAsignatura(Asignatura asignatura, String tipo)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call SP_DO_SET_DEL_ASIGNATURA (?,?,?,?)} ");
            cst.setString("TIPO", tipo);
            cst.setInt("p_ID_ASIGNATURA", asignatura.getId_asignatura());
            cst.setString("p_ASIGNATURA",asignatura.getAsignatura());
            cst.setInt("p_CURSO_ID_CURSO", asignatura.getId_curso());                        
            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
    //Cel
    public int insertUpdateCel(Cel cel, String tipo)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call SP_DO_SET_DEL_CEL (?,?,?,?,?,?,?)} ");
            cst.setString("TIPO", tipo);
            cst.setInt("p_ID_CEL", cel.getCel());
            cst.setString("p_NOMBRE_CEL",cel.getNombre_cel());
            cst.setString("p_DIRECCION", cel.getDireccion());        
            cst.setInt("p_TELEFONO", cel.getTelefono());            
            cst.setString("p_EMAIL_CONTACTO", cel.getEmail_contacto());        
            cst.setInt("p_PAIS_ID_PAIS", cel.getPais());              
            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }

    //Curso
    public int insertCurso(Curso curso, String tipo)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call SP_DO_SET_DEL_CURSO (?,?,?,?,?)} ");
            cst.setString("TIPO", tipo);
            cst.setInt("p_ID_CURSO", curso.getId_curso());
            cst.setString("p_NOMBRE_CURSO",curso.getNombre_curso());
            cst.setInt("p_ESTADO_CURSO_ID_ESTADO", curso.getEstado_curso());
            cst.setInt("p_PROGRAMA_ESTUDIO_ID_PROGRAMA", curso.getId_programa());


            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }

    //Documentos
    public int insertUpdateDocumento(Documento documento, String tipo)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call SP_DO_SET_DEL_DOCUMENTO (?,?,?,?,?)} ");
            cst.setString("TIPO", tipo);
            cst.setInt("p_ID_DOCUMENTO", documento.getId_doc());
            cst.setString("p_NOMBRE_DOCUMENTO",documento.getNombre_documento());
            cst.setString("p_RUTA_DOCUMENTO", documento.getRuta_documento());
            cst.setString("p_PERSONA_RUT", documento.getPersona_rut());

            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }

    //EstadoCurso
    
    public int insertUpdateEstadoCurso(EstadoCurso estadoCurso, String tipo)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call SP_DO_SET_DEL_ESTADO_CURSO (?,?,?)} ");
            cst.setString("TIPO", tipo);
            cst.setInt("p_ID_ESTADO", estadoCurso.getId_estado());
            cst.setString("p_NOMBRE_ESTADO",estadoCurso.getNombre_estado());
            flag= cst.executeUpdate();
            
        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }

    
    //Familia 
    public int insertUpdateFamilia(Familia familia, String tipo)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call SP_DO_SET_DEL_FAMILIA (?,?,?)} ");
            cst.setString("TIPO", tipo);
            cst.setString("p_RUT", familia.getRut());
            cst.setString("p_direccion", familia.getDireccion());

            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
     
    //NotasCurso
    public int insertUpdateNotasCurso(Nota nota, String tipo)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call SP_DO_SET_DEL_NOTA (?,?,?,?)} ");
            cst.setString("TIPO", tipo);
            cst.setInt("p_ID_NOTA", nota.getId_nota());
            cst.setInt("p_NOTA", nota.getNota());
            cst.setInt("p_ASIGNATURA_ID_ASIGNATURA", nota.getId_asig());


            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }

    
    //Pais
    public int insertUpdatePais(Pais pais, String tipo)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call SP_DO_SET_DEL_PAIS (?,?,?)} ");
            cst.setString("TIPO", tipo);
            cst.setInt("p_ID_PAIS", pais.getId_pais());
            cst.setString("p_NOMBRE", pais.getPais());
            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }

    //Postulacion
    public int insertUpdatePostulacion(Postulacion postulacion, String tipo)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call SP_DO_SET_DEL_POSTULACION (?,?,?,?,?)} ");
            cst.setString("TIPO", tipo);
            cst.setInt("p_ID_POSTULACION", postulacion.getId_postulacion());
            cst.setDate("p_FECHA_POSTULACION", postulacion.getFecha_postulacion());
            cst.setString("p_PERSONA_RUT", postulacion.getPersona_rut());
            cst.setInt("p_PROGRAMA_ESTUDIO_ID_PROGRAMA", postulacion.getId_programa());
            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }

    // Programas
    public int insertUpdatePrograma(Programa programa, String tipo)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call SP_DO_SET_DEL_PROGRAMA_ESTUDIO (?,?,?,?,?)} ");
            cst.setString("TIPO", tipo);
            cst.setInt("p_ID_PROGRAMA", programa.getId_programa());
            cst.setString("p_NOMBRE_PROGRAMA", programa.getNombre_programa());
            cst.setInt("p_DURACION_PROGRAMA", programa.getDuracion_programa());
            cst.setInt("p_CEL_ID_CEL", programa.getId_cel());

            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
     
    //Rol
        public int insertUpdateRol(Rol rol, String tipo)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call SP_DO_SET_DEL_ROL (?,?,?)} ");
            cst.setString("TIPO",tipo);
            cst.setInt("p_ID_ROL",rol.getId_rol());
            cst.setString("p_NOMBRE_ROL",rol.getNombre_rol());            
            flag = cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }

    
    //Usuario
    public int insertUpdateUsuario(Usuario usuario, String tipo)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call SP_DO_SET_DEL_USUARIO (?,?,?,?,?,?,?)} ");
            cst.setString("TIPO", tipo);
            cst.setInt("p_ID_USUARIO", usuario.getId_usuario());
            cst.setString("p_USUARIO", usuario.getUsuario());
            cst.setString("p_PASSWORD", usuario.getContrasena());
            cst.setString("p_PERSONA_RUT", usuario.getPersona_rut());
            cst.setInt("p_ROL_ID_ROL", usuario.getId_rol());
            cst.setInt("p_VIGENCIA", usuario.getVigencia());
            
            
            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
    
    
}
   
