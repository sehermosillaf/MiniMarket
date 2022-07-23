package minimarket.dto;

/**
 *
 * @author sebastian
 * @version 
 */
public class Cliente {

    private String rut;
    private String nombre;
    private String direccion;
    private String estado;

    public Cliente(String rut, String nombre, String direccion, String estado) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.estado = estado;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
