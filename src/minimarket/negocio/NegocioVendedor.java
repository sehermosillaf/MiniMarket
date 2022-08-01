package minimarket.negocio;

import java.util.ArrayList;
import minimarket.conexion.ConexionSQL;
import minimarket.dto.Vendedor;

/**
 *
 * @author sebastian
 * @version 0.2.0
 * Ultima modificacion 27/07/2022
 * 
 * Clase donde se implementara el negocio de Vendedor, metodos C.R.U.D 
 * 
 * 
 */
public class NegocioVendedor {
    
    private ConexionSQL conexionSQL;

    public NegocioVendedor() {
        ;
    }

    public ConexionSQL getConexionSQL() {
        return conexionSQL;
    }

    public void setConexionSQL(ConexionSQL conexionSQL) {
        this.conexionSQL = conexionSQL;
    }
    
    public void configurarConexion(){
        this.setConexionSQL(new ConexionSQL());
        this.conexionSQL.setNombreBaseDatos("jdbc:mysql://localhost:3307/minimarket");
        this.conexionSQL.setNombreTabla("vendedor");
        this.conexionSQL.setNombreDriver("com.mysql.cj.jdbc.Driver");
        this.conexionSQL.setUsuario("root");
        this.conexionSQL.setPass("");
    } // invocar
    
    public void crearVendedor(Vendedor vendedor) {
        this.configurarConexion();
        this.conexionSQL.setCadenaSQL("INSERT INTO vendedor (id,rut,nombre) "
                                    + "VALUES ('" + vendedor.getId() + "',"  
                                    + "'" + vendedor.getRut() + "'," 
                                    + "'" + vendedor.getNombre() + "');");
        this.conexionSQL.setEsSelect(false);
        this.conexionSQL.conectar();
    }
    
    public void eliminarVendedor(Vendedor vendedor) {
        this.configurarConexion();
        this.conexionSQL.setEsSelect(false);
        this.conexionSQL.setCadenaSQL("DELETE FROM vendedor WHERE id = '" + vendedor.getRut() +"';");
    }
    
    public void actualizarVendedor(Vendedor vendedor) {
    
        this.configurarConexion();
        this.conexionSQL.setEsSelect(false);
        this.conexionSQL.setCadenaSQL("UPDATE vendedor set  rut = '" + vendedor.getRut() + "',"
                                                        + " nombre = '" + vendedor.getNombre() + "'"
                                     + "WHERE id = '" + vendedor.getId() + "';");
    }
    
    // SELECT * FROM vendedor
    public ArrayList<Vendedor> obtenerVendedores(){
        
        
        return null;
             
    }
    
    public ArrayList<Vendedor> obtenerVendedorPorVentas(){

        return null;
    }
}
