package minimarket.dto;

/**
 *
 * @author sebastian
 * @version 0.2.2
 * Ultima modificacion 27/07/2022
 */
public class Vendedor extends Usuario {

    public Vendedor(int id, String nombre, String username, String password) {
        super(id, nombre, username, password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
}
