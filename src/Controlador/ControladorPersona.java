package Controlador;

import Modelo.Persona;
import controlador.tda.lista.ListaEnlazadaServices;
import controlador.tda.lista.exception.PosicionException;
import controlador.utiles.TipoOrdenacion;

public class ControladorPersona {

    private ListaEnlazadaServices<Persona> listaPersona = new ListaEnlazadaServices<>();
    
    public void crearPersona(String nombreCompleto, Integer edad, Character sexo, String cedula, Double ganancias){
        listaPersona.insertarAlFinal(new Persona(nombreCompleto, edad, sexo, cedula, ganancias));
    }
    
    public void ordenar(String atributo, String metodo, String tipoOrd) throws Exception{
        
        TipoOrdenacion tipoOrdenacion = TipoOrdenacion.valueOf(tipoOrd);
        if (metodo.equals("METODO SHELL")) {       
            listaPersona.getLista().metodoShell(atributo, tipoOrdenacion);           
            System.out.println("Se realizo bien la ordenacion por el metodo shell");
            
        }else if (metodo.equals("QUICK SORT")) {
            listaPersona.quickSort(atributo, tipoOrdenacion);
            System.out.println("Se realizo bien la ordenacion por quickSort");
        }
    }

    public String [][] mostrarLista() throws PosicionException{
        
        String [][] list = new String[listaPersona.getSize()][5];
        for (int i = 0; i < listaPersona.getSize(); i++) {
            list[i][0] = "" + listaPersona.getLista().obtenerDato(i).getNombreCompleto();
            list[i][1] = "" + listaPersona.getLista().obtenerDato(i).getEdad();
            list[i][2] = "" + listaPersona.getLista().obtenerDato(i).getSexo();
            list[i][3] = "" + listaPersona.getLista().obtenerDato(i).getCedula();
            list[i][4] = "" + listaPersona.getLista().obtenerDato(i).getGanancias();
        }
        return list; 
    }
    
    public ListaEnlazadaServices<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(ListaEnlazadaServices<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }
}
