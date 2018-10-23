/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
    cargarDatos c = new cargarDatos();


    public Conexion() throws SQLException{
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "portafolio", "admin");
    }
    //ALUMNO
    public void MostrarAlumnos(DefaultTableModel model,JTable tabla){
        
        try{
            PreparedStatement sentencia = cn.prepareStatement("SELECT RUT,NOMBRE,APELLIDO_PATERNO,APELLIDO_MATERNO,TO_CHAR(FECHA_NACIMIENTO, 'DD/MM/YYYY'),(CASE WHEN EXISTS (SELECT * FROM DOCUMENTO T2 WHERE PERSONA_RUT = T1.RUT) THEN 'FAMILIA' ELSE 'ALUMNO' END) AS TIPO FROM PERSONA T1 ORDER BY RUT");
            ResultSet resultado = sentencia.executeQuery();
            c.cargarTabla(6, resultado, model, tabla);
        }catch(Exception ex){
            System.out.println("Error al ejecutar consulta"+ex);
           
        }
       
    }
    
    //MOSTRAR USUARIO
    public void MostrarUsuario(DefaultTableModel model,JTable tabla){
        
        try{
            PreparedStatement sentencia = cn.prepareStatement("SELECT ID_USUARIO,USUARIO,PERSONA_RUT,ROL_ID_ROL,VIGENCIA FROM  USUARIO ORDER BY ID_USUARIO");
            ResultSet resultado = sentencia.executeQuery();
            c.cargarTabla(5, resultado, model, tabla);
        }catch(Exception ex){
            System.out.println("Error al ejecutar consulta"+ex);
           
        }
    //Buscar Usuario
    }
    public Usuario selectUsuario(int id_usuario) throws SQLException
    {
        Usuario datosUsuario = null;
        
        try {
            CallableStatement cst = cn.prepareCall("{call TRAERUSUARIO (?,?,?,?,?,?)} ");
            cst.setInt(1, id_usuario);
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);
            cst.registerOutParameter(4, java.sql.Types.VARCHAR);
            cst.registerOutParameter(5, java.sql.Types.INTEGER);
            cst.registerOutParameter(6, java.sql.Types.INTEGER);
            cst.execute();
            datosUsuario = new Usuario(id_usuario,cst.getString(2), cst.getString(3), cst.getString(4),cst.getInt(5), cst.getInt(6));
        }
        catch(SQLException ex)
        {
            System.out.println("Error al buscar usuario id: "+ id_usuario);
        }
        return datosUsuario;
    }
    
    
     public void BuscarAlumnos(DefaultTableModel model,JTable tabla,String dato){
        
        try{
            PreparedStatement sentencia = cn.prepareStatement("SELECT RUT,NOMBRE,APELLIDO_PATERNO,APELLIDO_MATERNO,FECHA_NACIMIENTO FROM PERSONA WHERE (NOMBRE LIKE '%"+dato+"%' OR APELLIDO_PATERNO LIKE '%"+dato+"%') ORDER BY RUT");
            ResultSet resultado = sentencia.executeQuery();
            c.cargarTabla(5, resultado, model, tabla);
        }catch(Exception ex){
            System.out.println("Error al ejecutar consulta"+ex);
           
        }
       
    }
     public Object[] consultarRut(String rut){
        Object[] datos = new Object[11];
        try {
            PreparedStatement sentencia = cn.prepareStatement("SELECT RUT,NOMBRE,APELLIDO_PATERNO,APELLIDO_MATERNO,FECHA_NACIMIENTO,EMAIL,EDAD,TELEFONO_MOVIL,TELEFONO_FIJO,(CASE WHEN EXISTS (SELECT * FROM DOCUMENTO T2 WHERE PERSONA_RUT = T1.RUT) THEN 'FAMILIA' ELSE 'ALUMNO' END) AS TIPO,NVL((CASE\n" +
" WHEN NOT EXISTS (SELECT * FROM DOCUMENTO T4 WHERE PERSONA_RUT = T1.RUT) THEN\n" +
" (SELECT NACIONALIDAD FROM ALUMNO T3 WHERE T3.RUT = T1.RUT)\n" +
" ELSE\n" +
" (SELECT DIRECCION FROM FAMILIA T5 WHERE T5.RUT = T1.RUT)\n" +
" END),'SIN DATOS') AS DATO FROM PERSONA T1 WHERE RUT = ?");
            sentencia.setString(1,rut);
            ResultSet rs = sentencia.executeQuery();
            while(rs.next()){
                datos[0] = rs.getInt(1);//rut
                datos[1] = rs.getString(2);//nombre
                datos[2] = rs.getString(3);//apellido1
                datos[3] = rs.getString(4);//apellido 2
                datos[4] = rs.getDate(5);//fecha
                datos[5] = rs.getString(6);//email
                datos[6] = rs.getInt(7);//edad
                datos[7] = rs.getInt(8);//telefono 1
                datos[8] = rs.getInt(9);//telefono 2
                datos[9] = rs.getString(10);//tipo
                datos[10] = rs.getString(11);//DATO
            }
        } catch (Exception e) {
            System.out.println("Error al consultar"+e);
        }
        return datos;
    }
     public int verificarRut(String rut){
       int value = 0;
        try {
            PreparedStatement sentencia = cn.prepareStatement("SELECT COUNT(*) FROM USUARIO WHERE PERSONA_RUT =?");
            sentencia.setString(1,rut);
            ResultSet rs = sentencia.executeQuery();
            while(rs.next()){
                value = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar"+e);
        }
        return value;
    }
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
    
    public int insertAlumno(Alumno a){
        int flag = 0;
        double nota = 0;
        Random r = new Random();
        double rangeMin = 4.0;
        double rangeMax = 7.0;
        double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
         nota = (double)Math.round(randomValue*10)/10;                
        try {
            CallableStatement cst = cn.prepareCall("{call SP_DO_ALUMNO (?,?,?)} ");
            cst.setString("P_RUT", a.getRut());
            cst.setString("P_NACIONALIDAD", a.getNacionalidad());
            cst.setDouble("P_NOTA",nota);
                                  
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
   
