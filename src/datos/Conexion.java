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
    public int insertAlumno(Alumno alumno)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call INSERTalumno (?,?,?,?,?,?,?,?,?,?)} ");
            cst.setString(1, alumno.getRut());
            cst.setString(2,alumno.getNombre_apellido());
            cst.setDate(3, alumno.getFecha_nacimiento());
            cst.setInt(4, alumno.getEdad());
            cst.setInt(5, alumno.getTelefono_fijo());
            cst.setInt(6, alumno.getTelefono_movil());
            cst.setString(7, alumno.getEmail());
            cst.setString(8, alumno.getVigencia());
            cst.setInt(9, alumno.getId_comuna());
            cst.setInt(10,alumno.getId_usuario());                     
            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
     
    public int updateAlumno(Alumno alumno)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call UPDATEalumno (?,?,?,?,?,?,?,?,?,?)} ");
            cst.setString(1, alumno.getRut());
            cst.setString(2,alumno.getNombre_apellido());
            cst.setDate(3, alumno.getFecha_nacimiento());
            cst.setInt(4, alumno.getEdad());
            cst.setInt(5, alumno.getTelefono_fijo());
            cst.setInt(6, alumno.getTelefono_movil());
            cst.setString(7, alumno.getEmail());
            cst.setString(8, alumno.getVigencia());
            cst.setInt(9, alumno.getId_comuna());
            cst.setInt(10,alumno.getId_usuario());                     
            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }

    
    
    public boolean verificarUsuario(String usuario, String contrasena)
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
    public int insertAsignatura(Asignatura asignatura)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call INSERTasignatura (?,?,?)} ");
            cst.setInt(1, asignatura.getId_asignatura());
            cst.setString(2,asignatura.getAsignatura());
            cst.setString(3, asignatura.getAlumno_rut());                        
            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
     
    public int updateAsignatura(Asignatura asignatura)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call UPDATEasignatura (?,?,?)} ");
            cst.setInt(1, asignatura.getId_asignatura());
            cst.setString(2,asignatura.getAsignatura());
            cst.setString(3, asignatura.getAlumno_rut());                
            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
    //Cel
    public int insertCel(Cel cel)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call INSERTcel (?,?,?,?,?,?,?)} ");
            cst.setInt(1, cel.getCel());
            cst.setString(2,cel.getNombre_cel());
            cst.setString(3, cel.getDireccion());        
            cst.setInt(4, cel.getTelefono());            
            cst.setString(5, cel.getEmail_contacto());        
            cst.setInt(6, cel.getId_programa());        
            cst.setInt(7, cel.getId_familia());        
            
            
            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
     
    public int updateCel(Cel cel)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call UPDATEcel (?,?,?,?,?,?,?)} ");
            cst.setInt(1, cel.getCel());
            cst.setString(2,cel.getNombre_cel());
            cst.setString(3, cel.getDireccion());        
            cst.setInt(4, cel.getTelefono());            
            cst.setString(5, cel.getEmail_contacto());        
            cst.setInt(6, cel.getId_programa());        
            cst.setInt(7, cel.getId_familia());        
            
            flag= cst.executeUpdate();
        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
    
    //Comuna
    public int insertComuna(Comuna comuna)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call INSERTcomuna (?,?)} ");
            cst.setInt(1, comuna.getId_comuna());
            cst.setString(2,comuna.getComuna());

            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
     
    public int updateComuna(Comuna comuna)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call UPDATEcomuna (?,?)} ");
            cst.setInt(1, comuna.getId_comuna());
            cst.setString(2,comuna.getComuna());      
            
            flag= cst.executeUpdate();
        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
    //Curso
    public int insertCurso(Curso curso)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call INSERTcurso (?,?,?,?)} ");
            cst.setInt(1, curso.getId_curso());
            cst.setString(2,curso.getNombre_curso());
            cst.setInt(3, curso.getId_programa());
            cst.setInt(4, curso.getSituacion_curso_id_estado());

            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
     
    public int updateCurso(Curso curso)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call UPDATEcurso (?,?,?,?)} ");
            cst.setInt(1, curso.getId_curso());
            cst.setString(2,curso.getNombre_curso());
            cst.setInt(3, curso.getId_programa());
            cst.setInt(4, curso.getSituacion_curso_id_estado());    
            
            flag= cst.executeUpdate();
        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
    //Documentos
    public int insertDocumento(Documento documento)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call INSERTdocumento (?,?,?)} ");
            cst.setInt(1, documento.getId_documentos());
            cst.setString(2,documento.getDesc_familia());
            cst.setInt(3, documento.getId_familia());

            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
     
    public int updateDocumento(Documento documento)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call UPDATEdocumento (?,?,?)} ");
            cst.setInt(1, documento.getId_documentos());
            cst.setString(2,documento.getDesc_familia());
            cst.setInt(3, documento.getId_familia()); 
            flag= cst.executeUpdate();
            
        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
    
    //Familia 
        public int insertFamilia(Familia familia)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call INSERTfamilia (?,?,?,?,?,?,?)} ");
            cst.setInt(1, familia.getId_familia());
            cst.setInt(2, familia.getId_usuario());
            cst.setString(3,familia.getNombre_familia());
            cst.setString(4,familia.getDireccion_familia());
            cst.setString(5,familia.getEmail_familia());
            cst.setInt(6, familia.getTelefono_fijo());
            cst.setInt(7, familia.getTelefono_movil());

            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
     
    public int updateFamilia(Familia familia)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call UPDATEfamilia (?,?,?,?,?,?,?)} ");
            cst.setInt(1, familia.getId_familia());
            cst.setInt(2, familia.getId_usuario());
            cst.setString(3,familia.getNombre_familia());
            cst.setString(4,familia.getDireccion_familia());
            cst.setString(5,familia.getEmail_familia());
            cst.setInt(6, familia.getTelefono_fijo());
            cst.setInt(7, familia.getTelefono_movil()); 
            flag= cst.executeUpdate();
            
        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
    //NotasCurso
    public int insertNotasCurso(NotasCurso notasCurso)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call INSERTnotas_curso (?,?,?)} ");
            cst.setInt(1, notasCurso.getId_nota());
            cst.setInt(2, notasCurso.getNota());
            cst.setInt(3, notasCurso.getId_curso());


            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
     
    public int updateNotasCurso(NotasCurso notasCurso)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call UPDATEnotas_curso (?,?,?)} ");
            cst.setInt(1, notasCurso.getId_nota());
            cst.setInt(2, notasCurso.getNota());
            cst.setInt(3, notasCurso.getId_curso());
            
            flag= cst.executeUpdate();
        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
    
    //NotasHistoricas   
    public int insertNotasHistoricas(NotasHistoricas notasHistoricas)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call INSERTnotas_historicas (?,?,?)} ");
            cst.setInt(1, notasHistoricas.getId_calificacion());
            cst.setInt(2, notasHistoricas.getNota());
            cst.setInt(3, notasHistoricas.getId_asignatura());


            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
     
    public int updateNotasHistoricas(NotasHistoricas notasHistoricas)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call UPDATEnotas_historicas (?,?,?)} ");
            cst.setInt(1, notasHistoricas.getId_calificacion());
            cst.setInt(2, notasHistoricas.getNota());
            cst.setInt(3, notasHistoricas.getId_asignatura());
            
            flag= cst.executeUpdate();
            
        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
    //Pais
    public int insertPais(Pais pais)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call INSERTpais (?,?)} ");
            cst.setInt(1, pais.getId_pais());
            cst.setString(2, pais.getPais());
            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
     
    public int updatePais(Pais pais)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call UPDATEpais (?,?)} ");
            cst.setInt(1, pais.getId_pais());
            cst.setString(2, pais.getPais());
            flag= cst.executeUpdate();
            
        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
    
    //Postulacion
    public int insertPostulacion(Postulacion postulacion)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call INSERTpostulacion (?,?,?,?)} ");
            
            cst.setInt(1, postulacion.getId_postulacion());
            cst.setDate(2, postulacion.getMarca_temporal());
            cst.setString(3, postulacion.getAlumno_rut());
            cst.setInt(4, postulacion.getId_programa());
            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
     
    public int updatePostulacion(Postulacion postulacion)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call UPDATEpostulacion (?,?,?,?)} ");
            cst.setInt(1, postulacion.getId_postulacion());
            cst.setDate(2, postulacion.getMarca_temporal());
            cst.setString(3, postulacion.getAlumno_rut());
            cst.setInt(4, postulacion.getId_programa());
            flag= cst.executeUpdate();
            
            
        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
    
    // Programas
    public int insertPrograma(Programa programa)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call INSERTprograma (?,?,?,?,?)} ");
            
            cst.setInt(1, programa.getId_programa());
            cst.setString(2, programa.getNombre_programa());
            cst.setInt(3, programa.getDuracion_programa());
            cst.setInt(4, programa.getId_pais());
            cst.setString(5, programa.getAlumno_rut());
            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
     
    public int updatePrograma(Programa programa)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call UPDATEprograma (?,?,?,?,?)} ");
            cst.setInt(1, programa.getId_programa());
            cst.setString(2, programa.getNombre_programa());
            cst.setInt(3, programa.getDuracion_programa());
            cst.setInt(4, programa.getId_pais());
            cst.setString(5, programa.getAlumno_rut());
            flag= cst.executeUpdate();
            
            
        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
    
    //Rol
        public int insertRol(Rol rol)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call INSERTrol (?,?)} ");
            
            cst.setInt(1, rol.getId_rol());
            cst.setString(2, rol.getNombre_rol());
            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
     
    public int updateRol(Rol rol)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call UPDATErol (?,?)} ");
            cst.setInt(1, rol.getId_rol());
            cst.setString(2, rol.getNombre_rol());
            flag= cst.executeUpdate();
            
            
        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
    
    //Usuario
    public int insertUsuario(Usuario usuario)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call INSERTusuario (?,?,?,?)} ");
            
            cst.setInt(1, usuario.getId_usuario());
            cst.setString(2, usuario.getUsuario());
            cst.setString(3, usuario.getContrasena());
            cst.setInt(4, usuario.getId_rol());
            
            flag= cst.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
     
    public int updateUsuario(Usuario usuario)
    {
        int flag = 0;
        try {
            CallableStatement cst = cn.prepareCall("{call UPDATEusuario (?,?)} ");
            cst.setInt(1, usuario.getId_usuario());
            cst.setString(2, usuario.getUsuario());
            cst.setString(3, usuario.getContrasena());
            cst.setInt(4, usuario.getId_rol());
            
            flag= cst.executeUpdate();         
            
        } catch (Exception ex) {
            return 0;
        }
        return flag;
    }
    
}
   
