package Modelo;
// @author samaelhg
public class Persona{

    private String nombreCompleto;
    private Integer edad;
    private Character sexo;
    private String cedula;
    private Double ganancias;

  
    public Persona(String nombreCompleto, Integer edad, Character sexo, String cedula, Double ganancias) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.sexo = sexo;
        this.cedula = cedula;
        this.ganancias = ganancias;
    }


    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    public Double getGanancias() {
        return ganancias;
    }

    public void setGanancias(Double ganancias) {
        this.ganancias = ganancias;
    }

    public String mostrarInfo() {
        return  "NombresCompletos: "+nombreCompleto + 
                "\nEdad: "+ edad+
                "\nSexo: "+sexo+
                "\nCedula: "+cedula+
                "\nGanancias: "+ganancias+ "$";
    } 
}
