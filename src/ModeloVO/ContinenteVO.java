/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author Estudiante
 */
public class ContinenteVO {
    
    private int id;
    private String nombre;

    public ContinenteVO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public ContinenteVO() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return "Continente{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
    
}
