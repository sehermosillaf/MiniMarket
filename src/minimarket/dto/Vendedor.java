package minimarket.dto;

/**
 *
 * @author sebastian
 * @version 0.2.2 Ultima modificacion 27/07/2022
 */
public class Vendedor {

    private int id;
    private String rut;
    private String nombre;

    public Vendedor(int id, String rut, String nombre) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
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
