
package minimarket.dto;

/**
 *
 * @author sebastian
 * @version 0.1.0
 * "Ultima modificacion 23/07/2022"
 * 
 * Esta superclase heredara a Administrador, Vendedor.
 */
public abstract class Usuario {
    
    protected int id;
    protected String rut;
    protected String nombre;
    protected String username;
    protected String password;

    public Usuario(int id, String nombre, String username, String password) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.password = password;
    }
    
    
             
    
    
    
    
}
