package minimarket.negocio;

import minimarket.conexion.ConexionSQL;
import minimarket.dto.Administrador;

/**
 *
 * @author sebastian
 * @version 0.1.0
 */
public class NegocioAdministrador {
    
    private ConexionSQL conexionSQL;

    public ConexionSQL getConexionSQL() {
        return conexionSQL;
    }

    public void setConexionSQL(ConexionSQL conexionSQL) {
        this.conexionSQL = conexionSQL;
    }
    
    public void configurarConexion() {
        this.getConexionSQL().setNombreBaseDatos("");
        
    }
    
    
   
    
    
    
    
    

}
