/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import correo.Correo;
import datos.Conexion;
import datos.ControladorCorreo;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Cel;
import modelo.Familia;
import modelo.Pais;
import modelo.Persona;
import modelo.Postulacion;
import modelo.Programa;
import modelo.Rol;
import modelo.Usuario;

/**
 *
 * @author Prueba 2 Seba prueba 1
 *
 * Cambio 3
 *
 * Martin prueba 1 Martin prueba
 *
 *
 * fin
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    Conexion cnn = null;
    FileInputStream fis;
    DefaultTableModel dtm, dtmUsuario, dtmRol, dtmPais, dtmCentros;
    Correo c = new Correo();

    public Main() {
        initComponents();
        txtError.setVisible(false);
        setVisibleOff();

        try {
            cnn = new Conexion();
        } catch (SQLException ex) {
            txtError.setText("Error Conexión SQL");
            txtError.setVisible(true);
        }
        btnModificarPersona.setEnabled(false);
        btnEliminarPersona.setEnabled(false);
        jPanel3.setVisible(false);
        pPanelCrearUsuario.setVisible(false);
        pPanelRol.setVisible(false);
        pPanelCentros.setVisible(false);
        pPanelPersona.setVisible(false);
        pPanelAdminUsuario.setVisible(false);
        pPanelPais.setVisible(false);
        pPanelPrograma.setVisible(false);
        pPanelUsuario.setVisible(false);
        pPanelPostulacion.setVisible(false);


    }

    public void volverMenu() {
        pPanelCrearUsuario.setVisible(false);
        pPanelRol.setVisible(false);
        pPanelCentros.setVisible(false);
        pPanelPersona.setVisible(false);
        pPanelAdminUsuario.setVisible(false);
        pPanelPais.setVisible(false);
        pPanelPrograma.setVisible(false);
        jPanel3.setVisible(true);
        pPanelUsuario.setVisible(false);
        pPanelPostulacion.setVisible(false);

    }

    private void setVisibleOff() {
        pPanelCrearUsuario.setVisible(false);
        pPanelRol.setVisible(false);
        pPanelCentros.setVisible(false);
        pPanelPrograma.setVisible(false);
        pPanelPersona.setVisible(false);
        pPanelUsuario.setVisible(false);
        pPanelPostulacion.setVisible(false);
    }

    public void actualizarTabla() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        cnn.MostrarAlumnos(dtm, tblPersonas);
    }
    public void actualizarTablaUsuario() {
        while (dtmUsuario.getRowCount() > 0) {
            dtmUsuario.removeRow(0);
        }
        cnn.MostrarUsuario(dtmUsuario, tblUsuario);
    }

    public void actualizarTablaRol() {
        while (dtmRol.getRowCount() > 0) {
            dtmRol.removeRow(0);
        }
        cnn.MostrarRol(dtmRol, tblRoles);
    }

    public void actualizarTablaPais() {
        while (dtmPais.getRowCount() > 0) {
            dtmPais.removeRow(0);
        }
        cnn.MostrarPais(dtmPais, tblPaises);
    }
    public void actualizarTablaCentro() {
        while (dtmCentros.getRowCount() > 0) {
            dtmCentros.removeRow(0);
        }
        cnn.MostrarCentros(dtmCentros, tblCentros);
    }

    public void buscarPersona() {
        String dato = txtBuscarPersona.getText();
        if (dato.isEmpty()) {
            actualizarTabla();
        } else {
            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);
            }
            cnn.BuscarAlumnos(dtm, tblPersonas, dato);
        }
    }

    public void buscarUsuario() {
        String dato = txtBuscarUsuario.getText();
        if (dato.isEmpty()) {
            actualizarTablaUsuario();
        } else {
            while (dtmUsuario.getRowCount() > 0) {
                dtmUsuario.removeRow(0);
            }
            cnn.BuscarUsuarios(dtmUsuario, tblUsuario, dato);
        }
    }

    public void limpiarCampos() {
        txtRut.setText(null);
        txtNombre.setText(null);
        txtApellidoPaterno.setText(null);
        txtApellidoMaterno.setText(null);
        dFechaNacimiento.setDate(null);
        txtEmail.setText(null);
        txtEdad.setText(null);
        txtTelefonoMovil.setText(null);
        txtTelefonoFijo.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        btnGroupPersona = new javax.swing.ButtonGroup();
        btnGroupVigencia = new javax.swing.ButtonGroup();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pPanelLogin = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblContrasena = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        txtError = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnRoles = new javax.swing.JButton();
        btnAdministrarCentros = new javax.swing.JButton();
        txtAdministrarPersona = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnPrograma = new javax.swing.JButton();
        btnPaises = new javax.swing.JButton();
        btnPostulaciones = new javax.swing.JButton();
        pPanelRol = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        tabRoles = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblRoles = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtRol = new javax.swing.JTextField();
        btnCrearRol = new javax.swing.JButton();
        btnModificarRol = new javax.swing.JButton();
        pPanelCentros = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btnVolver1 = new javax.swing.JButton();
        tabCentros = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCentros = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtBuscarCentro = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        txtNombreCentro = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtDireccionCentro = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtTelefonoCentro = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtEmailCentro = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        btnCrearCentro = new javax.swing.JButton();
        btnModificarCentro = new javax.swing.JButton();
        cmbPaisCentro = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        cmbEncargado = new javax.swing.JComboBox<>();
        pPanelPersona = new javax.swing.JPanel();
        TabPersona = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPersonas = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtBuscarPersona = new javax.swing.JTextField();
        btnVolverMenuPersona = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        rbtnAlumno = new javax.swing.JRadioButton();
        rbtnFamilia = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtApellidoPaterno = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        dFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtTelefonoMovil = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtTelefonoFijo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtNacionalidad = new javax.swing.JTextField();
        txtNuevaPersona = new javax.swing.JButton();
        btnArchivos = new javax.swing.JButton();
        btnEliminarPersona = new javax.swing.JButton();
        btnModificarPersona = new javax.swing.JButton();
        pPanelAsignarFamilia = new javax.swing.JPanel();
        btnAsignarFamilia = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbAlumnoAsignar = new javax.swing.JComboBox<>();
        cbFamiliaAsignar = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        lblFamiliaActual = new javax.swing.JLabel();
        lblErrorAsignar = new javax.swing.JLabel();
        btnVolverPersona = new javax.swing.JButton();
        pPanelPais = new javax.swing.JPanel();
        tabPais = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPaises = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        btnCrearPais = new javax.swing.JButton();
        btnModificarPais = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        pPanelUsuario = new javax.swing.JPanel();
        tabUsuarios = new javax.swing.JTabbedPane();
        pPanelCrearUsuario = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNuevoUsuario = new javax.swing.JTextField();
        txtNuevaPassword = new javax.swing.JTextField();
        cbRutPersona = new javax.swing.JComboBox<>();
        cbRol = new javax.swing.JComboBox<>();
        btnCrearUsuario = new javax.swing.JButton();
        lblErrorCrearUsuario = new javax.swing.JLabel();
        pPanelAdminUsuario = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        lblBuscarUsuario = new javax.swing.JLabel();
        txtBuscarUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rbActiva = new javax.swing.JRadioButton();
        rbInactiva = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        btnCambiarVigencia = new javax.swing.JButton();
        lblErrorVigencia = new javax.swing.JLabel();
        btnCambiarClave = new javax.swing.JButton();
        txtIdVigencia = new javax.swing.JTextField();
        btnVolverUsuario = new javax.swing.JButton();
        pPanelPrograma = new javax.swing.JPanel();
        tabPrograma = new javax.swing.JTabbedPane();
        pPanelCrearPrograma = new javax.swing.JPanel();
        btnCrearPrograma = new javax.swing.JButton();
        txtNombreCrearPrograma = new java.awt.TextField();
        txtDuracionCrearPrograma = new java.awt.TextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        cbCelPrograma = new javax.swing.JComboBox<>();
        lblErrorCrearPrograma = new javax.swing.JLabel();
        pPanelAsignar = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        cbProgramas = new javax.swing.JComboBox<>();
        cbCelPublicar = new javax.swing.JComboBox<>();
        btnAsignar = new javax.swing.JButton();
        lblErrorPublicar = new java.awt.Label();
        btnPublicar = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        btnVolverPrograma = new javax.swing.JButton();
        pPanelPostulacion = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        cbAlumnoPost = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        cbProgramaPost = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        btnPostular = new javax.swing.JButton();
        btnVolverPost = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        pPanelLogin.setBackground(new java.awt.Color(255, 255, 255));
        pPanelLogin.setMinimumSize(new java.awt.Dimension(800, 600));
        pPanelLogin.setPreferredSize(new java.awt.Dimension(800, 600));

        lblUsuario.setText("Usuario");

        lblContrasena.setText("Contraseña");

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });

        btnLogin.setText("Entrar");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLoginKeyPressed(evt);
            }
        });

        txtError.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtError.setForeground(new java.awt.Color(255, 0, 51));
        txtError.setText("Mensaje Error");

        javax.swing.GroupLayout pPanelLoginLayout = new javax.swing.GroupLayout(pPanelLogin);
        pPanelLogin.setLayout(pPanelLoginLayout);
        pPanelLoginLayout.setHorizontalGroup(
            pPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelLoginLayout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addGroup(pPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario)
                    .addComponent(lblContrasena)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(pPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtError, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pPanelLoginLayout.setVerticalGroup(
            pPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelLoginLayout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addGroup(pPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContrasena))
                .addGap(36, 36, 36)
                .addGroup(pPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtError, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(348, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Centro de Estudios Montreal");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Generar Certificados");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 342, -1, -1));

        btnRoles.setText("Administrar Roles");
        btnRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRolesActionPerformed(evt);
            }
        });
        jPanel2.add(btnRoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 220, -1));

        btnAdministrarCentros.setText("Administrar Centros");
        btnAdministrarCentros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarCentrosActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdministrarCentros, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 59, 220, -1));

        txtAdministrarPersona.setText("Administrar Persona");
        txtAdministrarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdministrarPersonaActionPerformed(evt);
            }
        });
        jPanel2.add(txtAdministrarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 137, 220, -1));

        btnUsuarios.setText("Administrar Usuarios");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        jPanel2.add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 96, 220, -1));

        btnPrograma.setText("Administrar Programa");
        btnPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProgramaActionPerformed(evt);
            }
        });
        jPanel2.add(btnPrograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 18, 220, -1));

        btnPaises.setText("Administrar Paises");
        btnPaises.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaisesActionPerformed(evt);
            }
        });
        jPanel2.add(btnPaises, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 220, -1));

        btnPostulaciones.setText("Administrar Postulaciones");
        btnPostulaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostulacionesActionPerformed(evt);
            }
        });
        jPanel2.add(btnPostulaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 220, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(472, 472, 472)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addGap(50, 50, 50)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pPanelRol.setMinimumSize(new java.awt.Dimension(800, 600));
        pPanelRol.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel14.setText("Administrar Roles");

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblRoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblRoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRolesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblRoles);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 660, 350));

        tabRoles.addTab("Buscar Rol", jPanel1);

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setText("Nombre del Rol");
        jPanel10.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 150, 70));

        jLabel16.setText("Rol");
        jPanel10.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 150, 70));
        jPanel10.add(txtRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 330, -1));

        btnCrearRol.setText("Nuevo");
        btnCrearRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearRolActionPerformed(evt);
            }
        });
        jPanel10.add(btnCrearRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 130, 60));

        btnModificarRol.setText("Modificar");
        btnModificarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarRolActionPerformed(evt);
            }
        });
        jPanel10.add(btnModificarRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 150, 60));

        tabRoles.addTab("Crear Rol", jPanel10);

        javax.swing.GroupLayout pPanelRolLayout = new javax.swing.GroupLayout(pPanelRol);
        pPanelRol.setLayout(pPanelRolLayout);
        pPanelRolLayout.setHorizontalGroup(
            pPanelRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelRolLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(btnVolver)
                .addGap(94, 94, 94)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pPanelRolLayout.createSequentialGroup()
                .addComponent(tabRoles)
                .addContainerGap())
        );
        pPanelRolLayout.setVerticalGroup(
            pPanelRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelRolLayout.createSequentialGroup()
                .addGroup(pPanelRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPanelRolLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pPanelRolLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnVolver)))
                .addGap(8, 8, 8)
                .addComponent(tabRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pPanelCentros.setMinimumSize(new java.awt.Dimension(800, 600));
        pPanelCentros.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel15.setText("Administrar Centros");

        btnVolver1.setText("Volver");
        btnVolver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolver1ActionPerformed(evt);
            }
        });

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblCentros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCentros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCentrosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCentros);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 700, 310));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Buscar");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 70, 30));
        jPanel5.add(txtBuscarCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 540, -1));

        tabCentros.addTab("Centros", jPanel5);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setText("Nombre Centro de estudio");
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 51, -1, -1));
        jPanel6.add(txtNombreCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 48, 145, -1));

        jLabel33.setText("Dirección");
        jPanel6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 51, -1, -1));
        jPanel6.add(txtDireccionCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 48, 215, -1));

        jLabel34.setText("Teléfono");
        jPanel6.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 101, -1, -1));
        jPanel6.add(txtTelefonoCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 86, 145, -1));

        jLabel35.setText("Email");
        jPanel6.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 101, -1, -1));
        jPanel6.add(txtEmailCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 98, 215, -1));

        jLabel36.setText("Pais");
        jPanel6.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        btnCrearCentro.setText("Nuevo");
        btnCrearCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCentroActionPerformed(evt);
            }
        });
        jPanel6.add(btnCrearCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 150, 40));

        btnModificarCentro.setText("Modificar");
        btnModificarCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCentroActionPerformed(evt);
            }
        });
        jPanel6.add(btnModificarCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 160, 40));

        jPanel6.add(cmbPaisCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 160, -1));

        jLabel37.setText("Encargado CEL");
        jPanel6.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));

        jPanel6.add(cmbEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 210, -1));

        tabCentros.addTab("Crear Centro", jPanel6);

        javax.swing.GroupLayout pPanelCentrosLayout = new javax.swing.GroupLayout(pPanelCentros);
        pPanelCentros.setLayout(pPanelCentrosLayout);
        pPanelCentrosLayout.setHorizontalGroup(
            pPanelCentrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPanelCentrosLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(btnVolver1)
                .addGap(128, 128, 128)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(239, 239, 239))
            .addGroup(pPanelCentrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabCentros, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pPanelCentrosLayout.setVerticalGroup(
            pPanelCentrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelCentrosLayout.createSequentialGroup()
                .addGroup(pPanelCentrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPanelCentrosLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnVolver1))
                    .addGroup(pPanelCentrosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(tabCentros, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
        );

        pPanelPersona.setMaximumSize(new java.awt.Dimension(800, 600));
        pPanelPersona.setMinimumSize(new java.awt.Dimension(800, 600));
        pPanelPersona.setPreferredSize(new java.awt.Dimension(800, 600));
        pPanelPersona.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPersonasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPersonas);

        jPanel8.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 121, 760, 390));

        jLabel13.setText("Buscar");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        txtBuscarPersona.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtBuscarPersonaCaretUpdate(evt);
            }
        });
        txtBuscarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarPersonaActionPerformed(evt);
            }
        });
        jPanel8.add(txtBuscarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 540, -1));

        btnVolverMenuPersona.setText("Volver");
        btnVolverMenuPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverMenuPersonaActionPerformed(evt);
            }
        });
        jPanel8.add(btnVolverMenuPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        TabPersona.addTab("Modificar Persona", jPanel8);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGroupPersona.add(rbtnAlumno);
        rbtnAlumno.setText("Alumno");
        rbtnAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnAlumnoActionPerformed(evt);
            }
        });
        jPanel7.add(rbtnAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        btnGroupPersona.add(rbtnFamilia);
        rbtnFamilia.setText("Familia");
        rbtnFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFamiliaActionPerformed(evt);
            }
        });
        jPanel7.add(rbtnFamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));

        jLabel18.setText("Tipo de Persona");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 11, 123, 28));

        jLabel19.setText("Rut");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 70, -1));
        jPanel7.add(txtRut, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 175, -1));

        jLabel20.setText("Nombre");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, -1, -1));
        jPanel7.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 175, -1));

        jLabel21.setText("Apellido Paterno");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
        jPanel7.add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 170, -1));

        jLabel22.setText("Apellido Materno");
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, -1));
        jPanel7.add(txtApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 180, -1));

        jLabel23.setText("Fecha de Nacimiento");
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, 10));
        jPanel7.add(dFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 170, -1));

        jLabel24.setText("Email");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, -1, -1));
        jPanel7.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 180, -1));

        jLabel25.setText("Edad");
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));
        jPanel7.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 40, -1));

        jLabel26.setText("Teléfono Móvil");
        jPanel7.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, -1, -1));
        jPanel7.add(txtTelefonoMovil, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 180, -1));

        jLabel27.setText("Teléfono Fijo");
        jPanel7.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, -1, -1));
        jPanel7.add(txtTelefonoFijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 180, -1));
        jPanel7.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 800, 10));

        jLabel28.setText("Dirección");
        jPanel7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));
        jPanel7.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 230, -1));

        jLabel29.setText("Nacionalidad");
        jPanel7.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, -1, -1));
        jPanel7.add(txtNacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 190, -1));

        txtNuevaPersona.setText("Nuevo");
        txtNuevaPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNuevaPersonaActionPerformed(evt);
            }
        });
        jPanel7.add(txtNuevaPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 110, 30));

        btnArchivos.setText("Subir Antecedentes");
        btnArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivosActionPerformed(evt);
            }
        });
        jPanel7.add(btnArchivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 140, 30));

        btnEliminarPersona.setText("Eliminar");
        jPanel7.add(btnEliminarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, 110, 30));

        btnModificarPersona.setText("Modificar");
        btnModificarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPersonaActionPerformed(evt);
            }
        });
        jPanel7.add(btnModificarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 470, 120, 40));

        TabPersona.addTab("Crear Persona", jPanel7);

        pPanelAsignarFamilia.setMinimumSize(new java.awt.Dimension(800, 600));
        pPanelAsignarFamilia.setPreferredSize(new java.awt.Dimension(800, 600));

        btnAsignarFamilia.setText("Asignar");
        btnAsignarFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarFamiliaActionPerformed(evt);
            }
        });

        jLabel9.setText("Alumno:");

        jLabel10.setText("Familia:");

        cbAlumnoAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlumnoAsignarActionPerformed(evt);
            }
        });

        jLabel46.setText("Familia Actual:");

        lblErrorAsignar.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout pPanelAsignarFamiliaLayout = new javax.swing.GroupLayout(pPanelAsignarFamilia);
        pPanelAsignarFamilia.setLayout(pPanelAsignarFamiliaLayout);
        pPanelAsignarFamiliaLayout.setHorizontalGroup(
            pPanelAsignarFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelAsignarFamiliaLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(pPanelAsignarFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrorAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAsignarFamilia)
                    .addGroup(pPanelAsignarFamiliaLayout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(180, 180, 180)
                        .addComponent(lblFamiliaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pPanelAsignarFamiliaLayout.createSequentialGroup()
                        .addGroup(pPanelAsignarFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(181, 181, 181)
                        .addGroup(pPanelAsignarFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbAlumnoAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbFamiliaAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(335, Short.MAX_VALUE))
        );
        pPanelAsignarFamiliaLayout.setVerticalGroup(
            pPanelAsignarFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelAsignarFamiliaLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(pPanelAsignarFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbAlumnoAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pPanelAsignarFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel46)
                    .addComponent(lblFamiliaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(pPanelAsignarFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbFamiliaAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(btnAsignarFamilia)
                .addGap(18, 18, 18)
                .addComponent(lblErrorAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(330, Short.MAX_VALUE))
        );

        TabPersona.addTab("Asignar Familia", pPanelAsignarFamilia);

        pPanelPersona.add(TabPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 790, 560));

        btnVolverPersona.setText("Volver");
        btnVolverPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverPersonaActionPerformed(evt);
            }
        });
        pPanelPersona.add(btnVolverPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        pPanelPais.setMaximumSize(new java.awt.Dimension(800, 600));
        pPanelPais.setMinimumSize(new java.awt.Dimension(800, 600));
        pPanelPais.setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPaises.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPaises.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPaisesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPaises);

        jPanel11.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 575, 344));

        tabPais.addTab("Pais", jPanel11);

        jLabel30.setText("Pais");

        jLabel31.setText("Nombre del pais");

        btnCrearPais.setText("Nuevo");
        btnCrearPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPaisActionPerformed(evt);
            }
        });

        btnModificarPais.setText("Modificar");
        btnModificarPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPaisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(btnCrearPais, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)
                        .addComponent(btnModificarPais, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel30)
                .addGap(98, 98, 98)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(125, 125, 125)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificarPais, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(btnCrearPais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        tabPais.addTab("Crear Pais", jPanel12);

        jButton3.setText("Volver");

        jLabel17.setText("Paises");

        javax.swing.GroupLayout pPanelPaisLayout = new javax.swing.GroupLayout(pPanelPais);
        pPanelPais.setLayout(pPanelPaisLayout);
        pPanelPaisLayout.setHorizontalGroup(
            pPanelPaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelPaisLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pPanelPaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPanelPaisLayout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(206, 206, 206)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tabPais, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        pPanelPaisLayout.setVerticalGroup(
            pPanelPaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPanelPaisLayout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(pPanelPaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabPais, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pPanelUsuario.setMaximumSize(new java.awt.Dimension(800, 600));
        pPanelUsuario.setMinimumSize(new java.awt.Dimension(800, 600));
        pPanelUsuario.setPreferredSize(new java.awt.Dimension(800, 600));

        pPanelCrearUsuario.setBackground(new java.awt.Color(255, 255, 255));
        pPanelCrearUsuario.setMaximumSize(new java.awt.Dimension(800, 550));
        pPanelCrearUsuario.setMinimumSize(new java.awt.Dimension(800, 550));
        pPanelCrearUsuario.setPreferredSize(new java.awt.Dimension(800, 550));
        pPanelCrearUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Usuario");
        pPanelCrearUsuario.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel6.setText("Contraseña");
        pPanelCrearUsuario.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel7.setText("Rut Persona");
        pPanelCrearUsuario.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, -1, -1));

        jLabel8.setText("Rol");
        pPanelCrearUsuario.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, -1));
        pPanelCrearUsuario.add(txtNuevoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 110, -1));
        pPanelCrearUsuario.add(txtNuevaPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 110, -1));

        cbRutPersona.setMaximumRowCount(999);
        pPanelCrearUsuario.add(cbRutPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, -1, -1));

        cbRol.setMaximumRowCount(10);
        pPanelCrearUsuario.add(cbRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));

        btnCrearUsuario.setText("Crear Usuario");
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });
        pPanelCrearUsuario.add(btnCrearUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));
        pPanelCrearUsuario.add(lblErrorCrearUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        tabUsuarios.addTab("Crear Usuario", pPanelCrearUsuario);

        pPanelAdminUsuario.setMaximumSize(new java.awt.Dimension(800, 550));
        pPanelAdminUsuario.setMinimumSize(new java.awt.Dimension(800, 550));
        pPanelAdminUsuario.setPreferredSize(new java.awt.Dimension(800, 550));
        pPanelAdminUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuarioMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblUsuario);

        jPanel9.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 730, 200));

        lblBuscarUsuario.setText("Buscar");
        jPanel9.add(lblBuscarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        txtBuscarUsuario.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtBuscarUsuarioCaretUpdate(evt);
            }
        });
        jPanel9.add(txtBuscarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 540, -1));

        pPanelAdminUsuario.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 280));

        jLabel1.setText("Cambiar Vigencia");
        pPanelAdminUsuario.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, -1, -1));

        btnGroupVigencia.add(rbActiva);
        rbActiva.setSelected(true);
        rbActiva.setText("Activa");
        pPanelAdminUsuario.add(rbActiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, -1, -1));

        btnGroupVigencia.add(rbInactiva);
        rbInactiva.setText("Inactiva");
        pPanelAdminUsuario.add(rbInactiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, -1, -1));

        jLabel2.setText("ID Usuario:");
        pPanelAdminUsuario.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, 20));

        btnCambiarVigencia.setText("Cambiar Vigencia");
        btnCambiarVigencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarVigenciaActionPerformed(evt);
            }
        });
        pPanelAdminUsuario.add(btnCambiarVigencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, 130, -1));

        lblErrorVigencia.setForeground(new java.awt.Color(204, 0, 51));
        lblErrorVigencia.setText("jLabel6");
        pPanelAdminUsuario.add(lblErrorVigencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 60, 20));

        btnCambiarClave.setText("Resetear Contraseña");
        btnCambiarClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarClaveActionPerformed(evt);
            }
        });
        pPanelAdminUsuario.add(btnCambiarClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, -1, -1));
        pPanelAdminUsuario.add(txtIdVigencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 120, -1));

        tabUsuarios.addTab("Administrar Usuario", pPanelAdminUsuario);

        btnVolverUsuario.setText("Volver");
        btnVolverUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pPanelUsuarioLayout = new javax.swing.GroupLayout(pPanelUsuario);
        pPanelUsuario.setLayout(pPanelUsuarioLayout);
        pPanelUsuarioLayout.setHorizontalGroup(
            pPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabUsuarios, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pPanelUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolverUsuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pPanelUsuarioLayout.setVerticalGroup(
            pPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPanelUsuarioLayout.createSequentialGroup()
                .addComponent(btnVolverUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pPanelPrograma.setMaximumSize(new java.awt.Dimension(800, 600));
        pPanelPrograma.setMinimumSize(new java.awt.Dimension(800, 600));
        pPanelPrograma.setPreferredSize(new java.awt.Dimension(800, 600));

        pPanelCrearPrograma.setMaximumSize(new java.awt.Dimension(800, 600));
        pPanelCrearPrograma.setMinimumSize(new java.awt.Dimension(800, 600));
        pPanelCrearPrograma.setName(""); // NOI18N
        pPanelCrearPrograma.setPreferredSize(new java.awt.Dimension(800, 600));

        btnCrearPrograma.setText("Crear Programa");
        btnCrearPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearProgramaActionPerformed(evt);
            }
        });

        jLabel38.setText("Nombre Programa:");

        jLabel39.setText("Duración Programa (Horas):");

        jLabel40.setText("Centro de Estudios (CEL):");

        lblErrorCrearPrograma.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout pPanelCrearProgramaLayout = new javax.swing.GroupLayout(pPanelCrearPrograma);
        pPanelCrearPrograma.setLayout(pPanelCrearProgramaLayout);
        pPanelCrearProgramaLayout.setHorizontalGroup(
            pPanelCrearProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelCrearProgramaLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(pPanelCrearProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(btnCrearPrograma)
                    .addComponent(jLabel40))
                .addGap(57, 57, 57)
                .addGroup(pPanelCrearProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombreCrearPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDuracionCrearPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblErrorCrearPrograma)
                    .addComponent(cbCelPrograma, 0, 130, Short.MAX_VALUE))
                .addContainerGap(413, Short.MAX_VALUE))
        );
        pPanelCrearProgramaLayout.setVerticalGroup(
            pPanelCrearProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelCrearProgramaLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(pPanelCrearProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPanelCrearProgramaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel38))
                    .addComponent(txtNombreCrearPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(pPanelCrearProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDuracionCrearPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addGap(27, 27, 27)
                .addGroup(pPanelCrearProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(cbCelPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(pPanelCrearProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCrearPrograma)
                    .addComponent(lblErrorCrearPrograma))
                .addContainerGap(335, Short.MAX_VALUE))
        );

        tabPrograma.addTab("Crear Programa", pPanelCrearPrograma);

        label1.setText("Programa");

        label2.setText("Centro de Estudios Asignado");

        cbProgramas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProgramasActionPerformed(evt);
            }
        });

        btnAsignar.setText("Asignar");
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });

        lblErrorPublicar.setForeground(new java.awt.Color(255, 51, 51));

        btnPublicar.setText("Publicar");
        btnPublicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicarActionPerformed(evt);
            }
        });

        jLabel45.setText("Estado:");

        javax.swing.GroupLayout pPanelAsignarLayout = new javax.swing.GroupLayout(pPanelAsignar);
        pPanelAsignar.setLayout(pPanelAsignarLayout);
        pPanelAsignarLayout.setHorizontalGroup(
            pPanelAsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelAsignarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pPanelAsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrorPublicar, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pPanelAsignarLayout.createSequentialGroup()
                        .addGroup(pPanelAsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPublicar))
                        .addGap(65, 65, 65)
                        .addGroup(pPanelAsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCelPublicar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAsignar)
                            .addGroup(pPanelAsignarLayout.createSequentialGroup()
                                .addComponent(cbProgramas, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(jLabel45)
                                .addGap(18, 18, 18)
                                .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        pPanelAsignarLayout.setVerticalGroup(
            pPanelAsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelAsignarLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(pPanelAsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pPanelAsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbProgramas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel45)
                        .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(pPanelAsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCelPublicar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(pPanelAsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAsignar)
                    .addComponent(btnPublicar))
                .addGap(24, 24, 24)
                .addComponent(lblErrorPublicar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(292, Short.MAX_VALUE))
        );

        tabPrograma.addTab("Publicar/Asignar", pPanelAsignar);

        btnVolverPrograma.setText("Volver");
        btnVolverPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverProgramaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pPanelProgramaLayout = new javax.swing.GroupLayout(pPanelPrograma);
        pPanelPrograma.setLayout(pPanelProgramaLayout);
        pPanelProgramaLayout.setHorizontalGroup(
            pPanelProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPrograma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 800, Short.MAX_VALUE)
            .addGroup(pPanelProgramaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolverPrograma)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pPanelProgramaLayout.setVerticalGroup(
            pPanelProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPanelProgramaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolverPrograma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pPanelPostulacion.setMaximumSize(new java.awt.Dimension(800, 600));
        pPanelPostulacion.setMinimumSize(new java.awt.Dimension(800, 600));
        pPanelPostulacion.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel42.setText("Alumno");

        jLabel43.setText("Programa de Estudio");

        jLabel44.setForeground(new java.awt.Color(255, 51, 51));

        btnPostular.setText("Generar Postulación");
        btnPostular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostularActionPerformed(evt);
            }
        });

        btnVolverPost.setText("Volver");
        btnVolverPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverPostActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pPanelPostulacionLayout = new javax.swing.GroupLayout(pPanelPostulacion);
        pPanelPostulacion.setLayout(pPanelPostulacionLayout);
        pPanelPostulacionLayout.setHorizontalGroup(
            pPanelPostulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelPostulacionLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pPanelPostulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVolverPost)
                    .addGroup(pPanelPostulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnPostular)
                        .addGroup(pPanelPostulacionLayout.createSequentialGroup()
                            .addGroup(pPanelPostulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel42)
                                .addComponent(jLabel43))
                            .addGap(64, 64, 64)
                            .addGroup(pPanelPostulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbAlumnoPost, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbProgramaPost, 0, 215, Short.MAX_VALUE)))
                        .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(402, Short.MAX_VALUE))
        );
        pPanelPostulacionLayout.setVerticalGroup(
            pPanelPostulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelPostulacionLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnVolverPost)
                .addGap(30, 30, 30)
                .addGroup(pPanelPostulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(cbAlumnoPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(pPanelPostulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(cbProgramaPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jLabel44)
                .addGap(35, 35, 35)
                .addComponent(btnPostular)
                .addContainerGap(342, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pPanelRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 36, Short.MAX_VALUE)
                    .addComponent(pPanelCentros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 36, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pPanelPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pPanelPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pPanelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pPanelPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pPanelPostulacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 505, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(606, 606, 606)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pPanelRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pPanelCentros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pPanelPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 606, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pPanelPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pPanelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pPanelPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pPanelPostulacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pPanelLogin.getAccessibleContext().setAccessibleName("");
        pPanelLogin.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        char[] arraypass = txtPass.getPassword();
        String pass = new String(arraypass);
        boolean conectar = cnn.verificarUsuario(txtUser.getText(), pass);
        if (conectar) {
            pPanelLogin.setVisible(false);
            jPanel3.setVisible(true);
        } else {
            txtError.setText("Error de Datos");
            txtError.setVisible(true);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void btnRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRolesActionPerformed

        jPanel3.setVisible(false);
        pPanelRol.setVisible(true);

        dtmRol = new DefaultTableModel() {
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        tblRoles.setModel(dtmRol);
        dtmRol.addColumn("ID Rol");
        dtmRol.addColumn("Nombre Rol");

        cnn.MostrarRol(dtmRol, tblRoles);
        tblRoles.getTableHeader().setReorderingAllowed(false);
    }//GEN-LAST:event_btnRolesActionPerformed

    private void btnAdministrarCentrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarCentrosActionPerformed
        // TODO add your handling code here:
        jPanel3.setVisible(false);
        pPanelCentros.setVisible(true);
        resetearComboBox(cmbPaisCentro);
        resetearComboBox(cmbEncargado);
        cnn.comboBoxPais(cmbPaisCentro);
        cnn.comboBoxEncargadoCel(cmbEncargado);
        dtmCentros = new DefaultTableModel() {
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        tblCentros.setModel(dtmCentros);
        dtmCentros.addColumn("ID Centro");
        dtmCentros.addColumn("Nombre Centro");
        dtmCentros.addColumn("Dirección");
        dtmCentros.addColumn("País");
        dtmCentros.addColumn("Encargado");
        cnn.MostrarCentros(dtmCentros, tblCentros);
        tblCentros.getTableHeader().setReorderingAllowed(false);
    }//GEN-LAST:event_btnAdministrarCentrosActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        volverMenu();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnVolver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolver1ActionPerformed
        volverMenu();
    }//GEN-LAST:event_btnVolver1ActionPerformed

    private void rbtnAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnAlumnoActionPerformed
        // TODO add your handling code here:
        txtNacionalidad.setEnabled(true);
        txtDireccion.setEnabled(false);
        btnArchivos.setEnabled(false);
    }//GEN-LAST:event_rbtnAlumnoActionPerformed

    private void txtAdministrarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdministrarPersonaActionPerformed
        // TODO add your handling code here:
        jPanel3.setVisible(false);
        pPanelPersona.setVisible(true);
        dtm = new DefaultTableModel() {
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        tblPersonas.setModel(dtm);
        dtm.addColumn("Rut");
        dtm.addColumn("Nombre");
        dtm.addColumn("Apellido Paterno");
        dtm.addColumn("Apellido Materno");
        dtm.addColumn("Fecha de nacimiento");
        dtm.addColumn("Tipo Persona");
        cnn.MostrarAlumnos(dtm, tblPersonas);
        tblPersonas.getTableHeader().setReorderingAllowed(false);
        resetearComboBox(cbAlumnoAsignar);
        resetearComboBox(cbFamiliaAsignar);
        cnn.comboBoxAlumno(cbAlumnoAsignar);
        cnn.comboBoxFamilia(cbFamiliaAsignar);
    }//GEN-LAST:event_txtAdministrarPersonaActionPerformed

    private void rbtnFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFamiliaActionPerformed
        // TODO add your handling code here:
        txtDireccion.setEnabled(true);
        btnArchivos.setEnabled(true);
        txtNacionalidad.setEnabled(false);
    }//GEN-LAST:event_rbtnFamiliaActionPerformed

    private void txtBuscarPersonaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscarPersonaCaretUpdate
        // TODO add your handling code here:
        buscarPersona();
    }//GEN-LAST:event_txtBuscarPersonaCaretUpdate

    private void tblPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPersonasMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            limpiarCampos();
            boolean consultar = true;
            int fila = tblPersonas.getSelectedRow();
            String rut = tblPersonas.getValueAt(fila, 0).toString();
            Object[] datos = cnn.consultarRut(rut);
            txtRut.setText(datos[0].toString());
            txtNombre.setText(datos[1].toString());
            txtApellidoPaterno.setText(datos[2].toString());
            txtApellidoMaterno.setText(datos[3].toString());
            dFechaNacimiento.setDate((Date) datos[4]);
            txtEmail.setText(datos[5].toString());
            txtEdad.setText(datos[6].toString());
            txtTelefonoMovil.setText(datos[7].toString());
            txtTelefonoFijo.setText(datos[8].toString());
            String tipo = datos[9].toString();
            if (tipo.equals("ALUMNO")) {
                txtNacionalidad.setEnabled(true);
                txtNacionalidad.setText(datos[10].toString());
                txtDireccion.setText(null);
                txtDireccion.setEnabled(false);
                btnArchivos.setEnabled(false);
                rbtnAlumno.setSelected(true);
            } else {

                rbtnFamilia.setSelected(true);
                txtNacionalidad.setText(null);
                txtDireccion.setEnabled(true);
                btnArchivos.setEnabled(true);
                txtDireccion.setText(datos[10].toString());
                txtNacionalidad.setEnabled(false);

            }
            TabPersona.setSelectedIndex(1);
            btnModificarPersona.setEnabled(true);
            btnEliminarPersona.setEnabled(true);
        }
    }//GEN-LAST:event_tblPersonasMouseClicked

    private void txtNuevaPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNuevaPersonaActionPerformed
        // TODO add your handling code here:
        if (rbtnAlumno.isSelected() || rbtnFamilia.isSelected()) {
            String rut = txtRut.getText();
            if (cnn.verificarRut(rut) == 0) {
                String nombre = txtNombre.getText();
                String apellido_p = txtApellidoPaterno.getText();
                String apellido_m = txtApellidoMaterno.getText();
                java.util.Date fecha_nacimiento = dFechaNacimiento.getDate();
                java.sql.Date fecha_final = new java.sql.Date(fecha_nacimiento.getTime());
                String email = txtEmail.getText();
                int edad = Integer.parseInt(txtEdad.getText());
                int telefono_m = Integer.parseInt(txtTelefonoMovil.getText());
                int telefono_f = Integer.parseInt(txtTelefonoFijo.getText());
                Persona p = new Persona(rut, nombre, apellido_p, apellido_m, fecha_final, email, edad, telefono_m, telefono_f);

                int res = cnn.insertUpdatePersona(p, "do");
                if (res > 0) {
                    limpiarCampos();
                    actualizarTabla();
                    if (rbtnAlumno.isSelected()) {
                        String nacionalidad = txtNacionalidad.getText();
                        Alumno a = new Alumno(rut, nacionalidad);
                        int resp = cnn.insertAlumno(a);
                    } else {
                        String direccion = txtDireccion.getText();
                        Familia f = new Familia(rut, direccion);
                        int resp = cnn.insertUpdateFamilia(f, "do");
                    }
                    JOptionPane.showMessageDialog(null, "Se ha creado la persona correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un error al crear la persona");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El rut ingresado ya posee un usuario");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar el tipo de Persona a crear");
        }

    }//GEN-LAST:event_txtNuevaPersonaActionPerformed

    private void btnModificarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPersonaActionPerformed

        if (rbtnAlumno.isSelected() || rbtnFamilia.isSelected()) {
            String rut = txtRut.getText();
            String nombre = txtNombre.getText();
            String apellido_p = txtApellidoPaterno.getText();
            String apellido_m = txtApellidoMaterno.getText();
            java.util.Date fecha_nacimiento = dFechaNacimiento.getDate();
            java.sql.Date fecha_final = new java.sql.Date(fecha_nacimiento.getTime());
            String email = txtEmail.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            int telefono_m = Integer.parseInt(txtTelefonoMovil.getText());
            int telefono_f = Integer.parseInt(txtTelefonoFijo.getText());
            Persona p = new Persona(rut, nombre, apellido_p, apellido_m, fecha_final, email, edad, telefono_m, telefono_f);
            int res = cnn.insertUpdatePersona(p, "set");
            if (res > 0) {
                limpiarCampos();
                actualizarTabla();
                JOptionPane.showMessageDialog(null, "Se ha modificado la persona correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al modificar la persona");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar el tipo de Persona a modificar");
        }
    }//GEN-LAST:event_btnModificarPersonaActionPerformed

    private void btnArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivosActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(null);
        fileChooser.setMultiSelectionEnabled(true);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            rsdragdropfiles.RSDragDropFiles.setCopiar(fileChooser.getSelectedFile().toString(), "src/documentos/imagen.png");
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            DataInputStream dis = null;
            try {
                fis = new FileInputStream(file);

            } catch (Exception e) {
            }
        }

    }//GEN-LAST:event_btnArchivosActionPerformed
    private void limpiarTablaUsuario() {
        dtmUsuario.setRowCount(0);
    }
    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        dtmUsuario = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
        };
        tblUsuario.setModel(dtmUsuario);
        dtmUsuario.addColumn("ID Usuario");
        dtmUsuario.addColumn("Usuario");
        dtmUsuario.addColumn("RUT Persona");
        dtmUsuario.addColumn("ID Rol");
        dtmUsuario.addColumn("Vigencia");
        cnn.MostrarUsuario(dtmUsuario, tblUsuario);
        tblUsuario.getTableHeader().setReorderingAllowed(false);
        jPanel3.setVisible(false);
        pPanelUsuario.setVisible(true);
        lblErrorVigencia.setVisible(false);
        lblErrorCrearUsuario.setVisible(false);
        resetearComboBox(cbRutPersona);
        resetearComboBox(cbRol);
        cnn.comboBoxPersona(cbRutPersona);
        cnn.comboBoxRol(cbRol);

    }//GEN-LAST:event_btnUsuariosActionPerformed
    private void limpiarCamposUsuario()
    {
        txtIdVigencia.setText("");    
    }
    private void tblUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuarioMouseClicked
        if (evt.getClickCount() == 2) {
            limpiarCamposUsuario();
            int fila = tblUsuario.getSelectedRow();
            String rut = tblUsuario.getValueAt(fila, 0).toString();
            System.out.println(rut);
            Object[] datos = cnn.traerUsuario(rut);
            txtIdVigencia.setText(datos[0].toString());         
            String vigencia = datos[1].toString();
            if (vigencia.equals("0")) {
                rbInactiva.setSelected(true);
            }
            else
            {
                rbActiva.setSelected(true);
            }
        }
    }//GEN-LAST:event_tblUsuarioMouseClicked

    private void txtBuscarUsuarioCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscarUsuarioCaretUpdate
        buscarUsuario();
    }//GEN-LAST:event_txtBuscarUsuarioCaretUpdate

    private void txtBuscarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarPersonaActionPerformed

    private void btnVolverUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverUsuarioActionPerformed
        volverMenu();

    }//GEN-LAST:event_btnVolverUsuarioActionPerformed

    private void btnCambiarVigenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarVigenciaActionPerformed
        int cuentaActiva = 0;
        Usuario user = null;
        lblErrorVigencia.setVisible(false);
        if (rbActiva.isSelected()) {
            cuentaActiva = 1;
        } else {
            cuentaActiva = 0;
        }
        if (txtIdVigencia.getText().equals("")) {
            lblErrorVigencia.setText("Debe ingresar un ID de usuario");
        }
        else
        {
            try
            {
                int id = Integer.parseInt(txtIdVigencia.getText());
               
                try {
                    user = cnn.selectUsuario(id);
                } catch (SQLException ex) {
                    lblErrorVigencia.setText("Error SQL: " + ex.getMessage());
                    lblErrorVigencia.setVisible(true);

                }

                lblErrorVigencia.setVisible(false);
                user.setVigencia(cuentaActiva);
                int res = cnn.insertUpdateUsuario(user, "set");
                if (res > 0) {
                    limpiarTablaUsuario();
                    actualizarTablaUsuario();
                    JOptionPane.showMessageDialog(null, "Se ha actualizado la vigencia correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al actualizar la vigencia");
                    
                }

            }
            catch (Exception ex)
            {
                lblErrorVigencia.setText("ID de usuario debe ser un número");
            }
        }
        
        


    }//GEN-LAST:event_btnCambiarVigenciaActionPerformed

    private void btnVolverMenuPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverMenuPersonaActionPerformed
        // TODO add your handling code here:
        volverMenu();
    }//GEN-LAST:event_btnVolverMenuPersonaActionPerformed

    private void btnLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginKeyPressed
        if (evt.getKeyCode() == 10) {
            char[] arraypass = txtPass.getPassword();
            String pass = new String(arraypass);
            boolean conectar = cnn.verificarUsuario(txtUser.getText(), pass);
            if (conectar) {
                pPanelLogin.setVisible(false);
                jPanel3.setVisible(true);
            } else {
                txtError.setText("Error de Datos");
                txtError.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnLoginKeyPressed

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        if (evt.getKeyCode() == 10) {
            char[] arraypass = txtPass.getPassword();
            String pass = new String(arraypass);
            boolean conectar = cnn.verificarUsuario(txtUser.getText(), pass);
            if (conectar) {
                pPanelLogin.setVisible(false);
                jPanel3.setVisible(true);
            } else {
                txtError.setText("Error de Datos");
                txtError.setVisible(true);
            }
        }
    }//GEN-LAST:event_txtPassKeyPressed

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        String nombreUsuario = String.valueOf(cbRutPersona.getSelectedItem());
        String[] nombreFinal = nombreUsuario.split("-");
        String rol = String.valueOf(cbRol.getSelectedItem());
        String[] rolFinal = rol.split("-");
        int idRol = Integer.parseInt(rolFinal[0]);
        Usuario usuario = new Usuario(txtNuevoUsuario.getText(), txtNuevaPassword.getText(), nombreFinal[0], idRol);
        if (cnn.insertUpdateUsuario(usuario, "do") == 1) {
            lblErrorCrearUsuario.setText("Agregado Correctamente");
            lblErrorCrearUsuario.setVisible(true);
        } else {
            lblErrorCrearUsuario.setText("No se pudo agregar usuario");
            lblErrorCrearUsuario.setVisible(true);
        }

    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    private void tblRolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRolesMouseClicked
        if (evt.getClickCount() == 2) {
            int fila = tblRoles.getSelectedRow();
            String NombreRol = tblRoles.getValueAt(fila, 1).toString();
            txtRol.setText(NombreRol);
            btnCrearRol.setEnabled(false);
            tabRoles.setSelectedIndex(1);
        }
    }//GEN-LAST:event_tblRolesMouseClicked

    private void btnModificarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarRolActionPerformed
        int fila = tblRoles.getSelectedRow();
        int idRol = Integer.parseInt(tblRoles.getValueAt(fila, 0).toString());
        String NombreRol = txtRol.getText();
        Rol r = new Rol(idRol, NombreRol);
        if (cnn.insertUpdateRol(r, "set") == 1) {
            txtRol.setText(null);
            actualizarTablaRol();
            JOptionPane.showMessageDialog(null, "Se ha actualizado el Rol correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar el rol");
        }
    }//GEN-LAST:event_btnModificarRolActionPerformed

    private void btnPaisesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaisesActionPerformed
        jPanel3.setVisible(false);
        pPanelPais.setVisible(true);

        dtmPais = new DefaultTableModel() {
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        tblPaises.setModel(dtmPais);
        dtmPais.addColumn("ID Pais");
        dtmPais.addColumn("Nombre Pais");
        cnn.MostrarPais(dtmPais, tblPaises);
        tblPaises.getTableHeader().setReorderingAllowed(false);
    }//GEN-LAST:event_btnPaisesActionPerformed

    private void btnCrearPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPaisActionPerformed
        String nombrePais = txtPais.getText();
        Pais p = new Pais(nombrePais);
        if (cnn.insertUpdatePais(p, "do") == 1) {
            actualizarTablaPais();
            txtPais.setText(null);
            JOptionPane.showMessageDialog(null, "Se agregó un pais correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Hubo un problema al crear el pais");
        }
    }//GEN-LAST:event_btnCrearPaisActionPerformed

    private void tblPaisesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPaisesMouseClicked
        if (evt.getClickCount() == 2) {
            int fila = tblPaises.getSelectedRow();
            txtPais.setText(tblPaises.getValueAt(fila, 1).toString());
            tabPais.setSelectedIndex(1);
        }
    }//GEN-LAST:event_tblPaisesMouseClicked

    private void btnModificarPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPaisActionPerformed
        int fila = tblPaises.getSelectedRow();
        int idPais = Integer.parseInt(tblPaises.getValueAt(fila, 0).toString());
        String pais = txtPais.getText();
        Pais p = new Pais(idPais, pais);
        if (cnn.insertUpdatePais(p, "set") == 1) {
            actualizarTablaPais();
            txtPais.setText(null);
            JOptionPane.showMessageDialog(null, "Se modificó un pais correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Hubo un problema al modificar el pais");
        }
    }//GEN-LAST:event_btnModificarPaisActionPerformed

    private void btnCrearRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearRolActionPerformed
        // TODO add your handling code here:
        String nombreRol = txtRol.getText();
        Rol r = new Rol(nombreRol);
        if (cnn.insertUpdateRol(r, "do") == 1) {
            JOptionPane.showMessageDialog(null, "Se creó correctamente el Rol");
        } else {
            JOptionPane.showMessageDialog(null, "Hubo un problema al crear el rol");
        }
    }//GEN-LAST:event_btnCrearRolActionPerformed

    private void btnCrearCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCentroActionPerformed
        String nombreCel = txtNombreCentro.getText();
        String direccion = txtDireccionCentro.getText();
        int telefono = Integer.parseInt(txtTelefonoCentro.getText());
        String email = txtEmailCentro.getText();
        String pais = String.valueOf(cmbPaisCentro.getSelectedItem());
        String[] paisID = pais.split("-");
        String usuario = String.valueOf(cmbEncargado.getSelectedItem());
        String[] usuId = usuario.split("-");
        Cel c = new Cel(nombreCel, direccion, telefono, email, Integer.parseInt(paisID[0]), Integer.parseInt(usuId[0]));
        if (cnn.insertUpdateCel(c, "do") == 1) {
            actualizarTablaCentro();
            txtNombreCentro.setText(null);
            txtDireccionCentro.setText(null);
            txtTelefonoCentro.setText(null);
            txtEmailCentro.setText(null);
            JOptionPane.showMessageDialog(null, "Se creó correctamente el Centro de estudio");
        } else {
            JOptionPane.showMessageDialog(null, "Hubo un problema al crear el centro de estudio");
        }
    }//GEN-LAST:event_btnCrearCentroActionPerformed

    private void tblCentrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCentrosMouseClicked
        if (evt.getClickCount() == 2) {
            int fila = tblCentros.getSelectedRow();
            int id = Integer.parseInt(tblCentros.getValueAt(fila, 0).toString());
            Object[] res = cnn.consultarCentro(id);
            txtNombreCentro.setText(res[0].toString());
            txtDireccionCentro.setText(res[1].toString());
            txtTelefonoCentro.setText(res[2].toString());
            txtEmailCentro.setText(res[3].toString());
            cmbPaisCentro.setSelectedItem(res[4].toString());
            cmbEncargado.setSelectedItem(res[5].toString());
            tabCentros.setSelectedIndex(1);
        }
    }//GEN-LAST:event_tblCentrosMouseClicked

    private void btnModificarCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarCentroActionPerformed
        int fila = tblCentros.getSelectedRow();
        int id = Integer.parseInt(tblCentros.getValueAt(fila, 0).toString());
        String nombreCel = txtNombreCentro.getText();
        String direccion = txtDireccionCentro.getText();
        int telefono = Integer.parseInt(txtTelefonoCentro.getText());
        String email = txtEmailCentro.getText();
        String pais = String.valueOf(cmbPaisCentro.getSelectedItem());
        String[] paisID = pais.split("-");
        String usuario = String.valueOf(cmbEncargado.getSelectedItem());
        String[] usuId = usuario.split("-");
        Cel c = new Cel(id,nombreCel, direccion, telefono, email, Integer.parseInt(paisID[0]), Integer.parseInt(usuId[0]));
        if (cnn.insertUpdateCel(c, "set") == 1) {
            txtNombreCentro.setText(null);
            txtDireccionCentro.setText(null);
            txtTelefonoCentro.setText(null);
            txtEmailCentro.setText(null);
            actualizarTablaCentro();
            JOptionPane.showMessageDialog(null, "Se modifico correctamente el Centro de estudio");
        } else {
            JOptionPane.showMessageDialog(null, "Hubo un problema al modificar el centro de estudio");
        }
    }//GEN-LAST:event_btnModificarCentroActionPerformed
    private void resetearComboBox(javax.swing.JComboBox combo)
    {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        combo.setModel(modelo);
    }
    private void btnProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgramaActionPerformed
        jPanel3.setVisible(false);
        pPanelPrograma.setVisible(true);
        resetearComboBox(cbCelPrograma);
        resetearComboBox(cbProgramas);
        resetearComboBox(cbCelPublicar);
        cnn.comboBoxCel(cbCelPrograma); 
        cnn.comboBoxPrograma(cbProgramas);
        cnn.comboBoxCel(cbCelPublicar);
    }//GEN-LAST:event_btnProgramaActionPerformed

    private void btnCrearProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearProgramaActionPerformed
        if (txtNombreCrearPrograma.getText().equals("")) {
            lblErrorCrearPrograma.setText("Ingrese un nombre para el Programa");
        }
        else
        {
            if (txtNombreCrearPrograma.getText().length() > 2) {
                if (txtDuracionCrearPrograma.getText().equals("")) 
                {
                lblErrorCrearPrograma.setText("Ingrese una duración para el Programa");
                }                
                else
                {
                   try
                   {
                       int duracionPrograma = Integer.parseInt(txtDuracionCrearPrograma.getText());
                       if (duracionPrograma > 0) {
                            String nombreCel = String.valueOf(cbCelPrograma.getSelectedItem());
                            String[] separarCel = nombreCel.split("-");
                            int idCel = Integer.parseInt(separarCel[0]);
                            int idPrograma = 0;
                            Programa programa = new Programa(idPrograma, txtNombreCrearPrograma.getText(),duracionPrograma , idCel,0);
                            if (cnn.insertUpdatePrograma(programa, "do") == 1) {
                                lblErrorCrearPrograma.setText("Agregado Correctamente");
                                lblErrorCrearPrograma.setVisible(true);
                                resetearComboBox(cbProgramas);
                                cnn.comboBoxPrograma(cbProgramas);

                            } else {
                                lblErrorCrearPrograma.setText("No se pudo agregar programa");
                                lblErrorCrearPrograma.setVisible(true);
                            }
                        }
                       else
                       {
                           
                           lblErrorCrearPrograma.setText("La duración del programa debe ser mayor a 0");
                       }
                   }
                   catch(Exception ex)
                   {
                       System.out.println(ex.getMessage());
                      lblErrorCrearPrograma.setText("Ingrese un número valido para la duración del programa"); 
                   }
                }          
            }
            else
            {
                lblErrorCrearPrograma.setText("El nombre del programa debe tener largo mayor a 2");
            }
        }
        
    }//GEN-LAST:event_btnCrearProgramaActionPerformed

    private void btnCambiarClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarClaveActionPerformed
        if(!txtIdVigencia.getText().equals(""))
        {
             int id = Integer.parseInt(txtIdVigencia.getText());
        Usuario user = null;
        String contrasenia = "default"+id;
        c.setContrasenia("zuxtuezhmzzvillc");
        c.setUsuarioCorreo("seba.32@gmail.com");
        c.setAsunto("Reinicio Contraseña");
        c.setMensaje("Su contraseña fue inicializada, la nueva contraseña es: "+ contrasenia);
        c.setDestino("seba.32@gmail.com");
        ControladorCorreo controlador = new ControladorCorreo();
        if(controlador.enviarCorreo(c))
        {
            JOptionPane.showMessageDialog(null, "Correo con contraseña enviado");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No se pudo enviar correo");
        }
        
        
        try {
            user = cnn.selectUsuario(id);
        } catch (SQLException ex) {
            lblErrorVigencia.setText("Error SQL: " + ex.getMessage());
            lblErrorVigencia.setVisible(true);
        }
        
        if (user != null) {
            lblErrorVigencia.setVisible(false);
            user.setContrasena(contrasenia);
            int res = cnn.insertUpdateUsuario(user, "set");
            if (res > 0) {
                limpiarTablaUsuario();
                actualizarTablaUsuario();
                JOptionPane.showMessageDialog(null, "Contraseña actualizada");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar la Contraseña");
            }
        } else {
            lblErrorVigencia.setText("ID no existente");
            lblErrorVigencia.setVisible(true);
        }
        }
       
    }//GEN-LAST:event_btnCambiarClaveActionPerformed

    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
        if (lblEstado.getText().equals("Publicado")) {
            String cel = String.valueOf(cbCelPublicar.getSelectedItem());
            String[] celFinal = cel.split("-");
            int idCel = Integer.parseInt(celFinal[0]);
            String programa = String.valueOf(cbProgramas.getSelectedItem());
            String[] programaFinal = programa.split("-");
            int idPrograma = Integer.parseInt(programaFinal[0]);
            int duracion = cnn.traerDuracionPrograma(idPrograma);
            Programa publicar = new Programa(idPrograma, programaFinal[1], duracion,idCel,0);

            if(cnn.insertUpdatePrograma(publicar, "set") > 0)
            {
                lblErrorPublicar.setText("Programa "+programaFinal[1]+" publicado correctamente");
            }
            else
            {
                lblErrorPublicar.setText("Error al publicar programa" );
            }
        }
        else
        {
            lblErrorPublicar.setText("Primero debe publicarse el Programa");
        }
        
        
    }//GEN-LAST:event_btnAsignarActionPerformed

    private void btnVolverProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverProgramaActionPerformed
        volverMenu();
    }//GEN-LAST:event_btnVolverProgramaActionPerformed

    private void btnPostulacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostulacionesActionPerformed
        jPanel3.setVisible(false);
        pPanelPostulacion.setVisible(true);
        cnn.comboBoxAlumno(cbAlumnoPost);
        cnn.comboBoxPrograma(cbProgramaPost);
        
    }//GEN-LAST:event_btnPostulacionesActionPerformed

    private void btnPostularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostularActionPerformed
        String rut = String.valueOf(cbAlumnoPost.getSelectedItem());
        String[] rutFinal = rut.split("-");
        int estado = 0;
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        java.util.Date fechaHoy = today.getTime();
        java.sql.Date fecha_postulacion = new java.sql.Date(fechaHoy.getTime());
        String programa = String.valueOf(cbProgramaPost.getSelectedItem());
        String[] programaFinal = programa.split("-");
        int idPrograma = Integer.parseInt(programaFinal[0]);
        Postulacion postulacion = new Postulacion(0,fecha_postulacion,estado,rutFinal[0],idPrograma);
        cnn.insertUpdatePostulacion(postulacion, "do");
    }//GEN-LAST:event_btnPostularActionPerformed

    private void btnPublicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicarActionPerformed
        String programa = String.valueOf(cbProgramas.getSelectedItem());
        String[] programa2 = programa.split("-");
        int idPrograma = Integer.parseInt(programa2[0]);
        if(cnn.cambiarEstado(idPrograma) == 0)
        {
            lblErrorPublicar.setText("No se pudo realizar la publicación");
        }
        else
        {
            lblErrorPublicar.setText("Publicación Realizada");
        }      
    }//GEN-LAST:event_btnPublicarActionPerformed

    private void btnVolverPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverPostActionPerformed
        volverMenu(); 
    }//GEN-LAST:event_btnVolverPostActionPerformed

    private void cbProgramasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProgramasActionPerformed
        // TODO add your handling code here:
        String programa = String.valueOf(cbProgramas.getSelectedItem());
        String[] programa2 = programa.split("-");
        int idPrograma = Integer.parseInt(programa2[0]);
        int estado = cnn.traerEstadoPrograma(idPrograma);
        if (estado == 1 ) {
            lblEstado.setText("Publicado");
        }
        else
        {
            lblEstado.setText("Sin Publicar");
        }
    }//GEN-LAST:event_cbProgramasActionPerformed

    private void cbAlumnoAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlumnoAsignarActionPerformed
        String alumno = String.valueOf(cbAlumnoAsignar.getSelectedItem());
        String[] rut_alumno = alumno.split("-");      
        String rut_familia = cnn.traerRutFamiliaAsignada(rut_alumno[0]);
        System.out.println(rut_familia);
        if (rut_familia != null) {
            String datosFamilia = cnn.traerFamiliaActual(rut_familia);
            System.out.println(datosFamilia);
            if (datosFamilia != null) {
                lblFamiliaActual.setText(datosFamilia);
            }
            else
            {
                lblFamiliaActual.setText("Familia Asignada no tiene Datos");
            }
        }
        else
        {
            System.out.println("alo");
            lblFamiliaActual.setText("Sin Familia Asignada");
        }


    }//GEN-LAST:event_cbAlumnoAsignarActionPerformed

    private void btnVolverPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverPersonaActionPerformed
        volverMenu();
    }//GEN-LAST:event_btnVolverPersonaActionPerformed

    private void btnAsignarFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarFamiliaActionPerformed
        String alumno = String.valueOf(cbAlumnoAsignar.getSelectedItem());
        String[] rut_alumno = alumno.split("-");     
        String familia = String.valueOf(cbFamiliaAsignar.getSelectedItem());
        String[] rut_familia = familia.split("-");
        Alumno a = cnn.traerAlumno(rut_alumno[0]);
        a.setNota(5);
        a.setRut_familia(rut_familia[0]);
        if (cnn.insertUpdateAlumno(a, "set") != 0) {
            lblErrorAsignar.setText("Alumno Asignado a familia con exito");
        }
        else
        {
            lblErrorAsignar.setText("No se pudo Asignar alumno");
        }

    }//GEN-LAST:event_btnAsignarFamiliaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabPersona;
    private javax.swing.JButton btnAdministrarCentros;
    private javax.swing.JButton btnArchivos;
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnAsignarFamilia;
    private javax.swing.JButton btnCambiarClave;
    private javax.swing.JButton btnCambiarVigencia;
    private javax.swing.JButton btnCrearCentro;
    private javax.swing.JButton btnCrearPais;
    private javax.swing.JButton btnCrearPrograma;
    private javax.swing.JButton btnCrearRol;
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JButton btnEliminarPersona;
    private javax.swing.ButtonGroup btnGroupPersona;
    private javax.swing.ButtonGroup btnGroupVigencia;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnModificarCentro;
    private javax.swing.JButton btnModificarPais;
    private javax.swing.JButton btnModificarPersona;
    private javax.swing.JButton btnModificarRol;
    private javax.swing.JButton btnPaises;
    private javax.swing.JButton btnPostulaciones;
    private javax.swing.JButton btnPostular;
    private javax.swing.JButton btnPrograma;
    private javax.swing.JButton btnPublicar;
    private javax.swing.JButton btnRoles;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btnVolver1;
    private javax.swing.JButton btnVolverMenuPersona;
    private javax.swing.JButton btnVolverPersona;
    private javax.swing.JButton btnVolverPost;
    private javax.swing.JButton btnVolverPrograma;
    private javax.swing.JButton btnVolverUsuario;
    private javax.swing.JComboBox<String> cbAlumnoAsignar;
    private javax.swing.JComboBox<String> cbAlumnoPost;
    private javax.swing.JComboBox<String> cbCelPrograma;
    private javax.swing.JComboBox<String> cbCelPublicar;
    private javax.swing.JComboBox<String> cbFamiliaAsignar;
    private javax.swing.JComboBox<String> cbProgramaPost;
    private javax.swing.JComboBox<String> cbProgramas;
    private javax.swing.JComboBox<String> cbRol;
    private javax.swing.JComboBox<String> cbRutPersona;
    private javax.swing.JComboBox<String> cmbEncargado;
    private javax.swing.JComboBox<String> cmbPaisCentro;
    private com.toedter.calendar.JDateChooser dFechaNacimiento;
    private javax.swing.JButton jButton3;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JLabel lblBuscarUsuario;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblErrorAsignar;
    private javax.swing.JLabel lblErrorCrearPrograma;
    private javax.swing.JLabel lblErrorCrearUsuario;
    private java.awt.Label lblErrorPublicar;
    private javax.swing.JLabel lblErrorVigencia;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFamiliaActual;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pPanelAdminUsuario;
    private javax.swing.JPanel pPanelAsignar;
    private javax.swing.JPanel pPanelAsignarFamilia;
    private javax.swing.JPanel pPanelCentros;
    private javax.swing.JPanel pPanelCrearPrograma;
    private javax.swing.JPanel pPanelCrearUsuario;
    private javax.swing.JPanel pPanelLogin;
    private javax.swing.JPanel pPanelPais;
    private javax.swing.JPanel pPanelPersona;
    private javax.swing.JPanel pPanelPostulacion;
    private javax.swing.JPanel pPanelPrograma;
    private javax.swing.JPanel pPanelRol;
    private javax.swing.JPanel pPanelUsuario;
    private javax.swing.JRadioButton rbActiva;
    private javax.swing.JRadioButton rbInactiva;
    private javax.swing.JRadioButton rbtnAlumno;
    private javax.swing.JRadioButton rbtnFamilia;
    private javax.swing.JTabbedPane tabCentros;
    private javax.swing.JTabbedPane tabPais;
    private javax.swing.JTabbedPane tabPrograma;
    private javax.swing.JTabbedPane tabRoles;
    private javax.swing.JTabbedPane tabUsuarios;
    private javax.swing.JTable tblCentros;
    private javax.swing.JTable tblPaises;
    private javax.swing.JTable tblPersonas;
    private javax.swing.JTable tblRoles;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JButton txtAdministrarPersona;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtBuscarCentro;
    private javax.swing.JTextField txtBuscarPersona;
    private javax.swing.JTextField txtBuscarUsuario;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionCentro;
    private java.awt.TextField txtDuracionCrearPrograma;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmailCentro;
    private javax.swing.JLabel txtError;
    private javax.swing.JTextField txtIdVigencia;
    private javax.swing.JTextField txtNacionalidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreCentro;
    private java.awt.TextField txtNombreCrearPrograma;
    private javax.swing.JTextField txtNuevaPassword;
    private javax.swing.JButton txtNuevaPersona;
    private javax.swing.JTextField txtNuevoUsuario;
    private javax.swing.JTextField txtPais;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtRol;
    private javax.swing.JTextField txtRut;
    private javax.swing.JTextField txtTelefonoCentro;
    private javax.swing.JTextField txtTelefonoFijo;
    private javax.swing.JTextField txtTelefonoMovil;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
