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
public class SeleccionVO {
    
    private int id;
    private String nombre;
    private int continente_id;
    private String tecnico;
    private int goles_favor;
    private int goles_contra;
    private int partidos_ganados;
    private int partidos_perdidos;
    private int partidos_jugados;

    public SeleccionVO(int id, String nombre, int continente_id, String tecnico, int goles_favor, int goles_contra, int partidos_ganados, int partidos_perdidos, int partidos_jugados) {
        this.id = id;
        this.nombre = nombre;
        this.continente_id = continente_id;
        this.tecnico = tecnico;
        this.goles_favor = goles_favor;
        this.goles_contra = goles_contra;
        this.partidos_ganados = partidos_ganados;
        this.partidos_perdidos = partidos_perdidos;
        this.partidos_jugados = partidos_jugados;
    }

    public SeleccionVO() {
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

    public int getContinente_id() {
        return continente_id;
    }

    public void setContinente_id(int continente_id) {
        this.continente_id = continente_id;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public int getGoles_favor() {
        return goles_favor;
    }

    public void setGoles_favor(int goles_favor) {
        this.goles_favor = goles_favor;
    }

    public int getGoles_contra() {
        return goles_contra;
    }

    public void setGoles_contra(int goles_contra) {
        this.goles_contra = goles_contra;
    }

    public int getPartidos_ganados() {
        return partidos_ganados;
    }

    public void setPartidos_ganados(int partidos_ganados) {
        this.partidos_ganados = partidos_ganados;
    }

    public int getPartidos_perdidos() {
        return partidos_perdidos;
    }

    public void setPartidos_perdidos(int partidos_perdidos) {
        this.partidos_perdidos = partidos_perdidos;
    }

    public int getPartidos_jugados() {
        return partidos_jugados;
    }

    public void setPartidos_jugados(int partidos_jugados) {
        this.partidos_jugados = partidos_jugados;
    }

    
    

    
    @Override
    public String toString() {
        return "ID: " + getId() + ", Nombre: " + getNombre() + ", Tecnico: " + getTecnico() + 
               ", (" + getGoles_favor()+ " Goles a favor y " + getGoles_contra()+ " en contra: "  +
               "), (" + getPartidos_ganados()+ " Partidos ganados, " + getPartidos_perdidos()+ " perdidos, y " + getPartidos_jugados()+ " jugados)";
    }
  
    
    
}
