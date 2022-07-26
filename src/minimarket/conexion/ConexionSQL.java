package minimarket.conexion;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author sebastian
 * @version 0.1.0 
 * Ultima modificacion 23/07/2022
 */

/*
 * Clase para generar conexion con bases de datos 
 * siguiendo la documentacion JDBC PostgreSQL                               https://jdbc.postgresql.org/documentation/81/use.html
 * utiliza metodos de interface Conecction                                  https://docs.oracle.com/javase/7/docs/api/java/sql/Connection.html
 * metodos de inteface Statement                                            https://docs.oracle.com/javase/7/docs/api/java/sql/Statement.html
 * Al realizar una consulta a la base de datos devuelve un objeto ResultSet https://docs.oracle.com/javase/7/docs/api/java/sql/ResultSet.html
 */
public class ConexionSQL {

    private String nombreBaseDatos;
    private String nombreTabla;
    private String nombreDriver;
    private String cadenaSQL;
    private boolean esSelect;
    private Connection dbConnection;
    private ResultSet dbResultSet;
    private String usuario;
    private String pass;

    public String getNombreBaseDatos() {
        return nombreBaseDatos;
    }

    public void setNombreBaseDatos(String nombreBaseDatos) {
        this.nombreBaseDatos = nombreBaseDatos;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getNombreDriver() {
        return nombreDriver;
    }

    public void setNombreDriver(String nombreDriver) {
        this.nombreDriver = nombreDriver;
    }

    public String getCadenaSQL() {
        return cadenaSQL;
    }

    public void setCadenaSQL(String cadenaSQL) {
        this.cadenaSQL = cadenaSQL;
    }

    public boolean isEsSelect() {
        return esSelect;
    }

    public void setEsSelect(boolean esSelect) {
        this.esSelect = esSelect;
    }

    public Connection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public ResultSet getDbResultSet() {
        return dbResultSet;
    }

    public void setDbResultSet(ResultSet dbResultSet) {
        this.dbResultSet = dbResultSet;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    //Cierra la conexion con la base de datos
    public void cerrarConexion() {
        try {
            this.getDbConnection().close();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "La conexion esta cerrada");
        }
    }

    public void conectar() {
        // instancia statement para ejecutar sentencias SQL
        Statement sentenciaSQL = null;

        //validaciones para conectar con base de datos
        if (this.getNombreBaseDatos().length() == 0) {
            JOptionPane.showMessageDialog(null, "Problemas de conexion");
            System.out.println("No existe base de datos");
        }
        if (this.getNombreTabla().length() == 0) {
            JOptionPane.showMessageDialog(null, "Problemas de conexion");
            System.out.println("No existe el nombre de la tabla");
        }
      
        if (this.getUsuario().length() == 0) {
            JOptionPane.showMessageDialog(null, "Problemas de conexion");
            System.out.println("No existe usuario en base datos");
        }

        if (this.getNombreDriver().length() == 0) {
            JOptionPane.showMessageDialog(null, "Problemas de conexion");
            System.out.println("Problemas al cargar el driver postgresql");

        }
        

        try {
            //Carga el driver antes de conectar a la base de datos
            Class.forName(this.nombreDriver);
            // Fija los datos de conexion 
            this.setDbConnection(DriverManager.getConnection(this.getNombreBaseDatos(), this.getUsuario(), this.getPass()));

            sentenciaSQL = this.getDbConnection().createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }

        /*
         * executeQuery se utiliza para recuperar datos de la base de datos (SELECT).
         * devuelve un objecto ResultSet
        
         * updateQuery se utiliza para instrucciones DML (Insertar, Actualizar y Eliminar)
         * devuelve un valor int que es el recuento de filas afectadas.
         */
        // SELECT
        if (this.isEsSelect()) {
            try {
                this.setDbResultSet(sentenciaSQL.executeQuery(this.getCadenaSQL()));

            } catch (Exception e) {
                System.out.println(e);

            }
        } else { // UPDATE - INSERT - DELETE
            try {
                int filasAfectadas = sentenciaSQL.executeUpdate(this.getCadenaSQL());

            } catch (Exception e) {
                System.out.println(e);
                
            }
        }
        this.cerrarConexion();
    }

}
