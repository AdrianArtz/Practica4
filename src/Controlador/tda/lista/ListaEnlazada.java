/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.tda.lista;

import Modelo.Persona;
import controlador.tda.lista.exception.PosicionException;

import controlador.utiles.Utilidades;

import controlador.utiles.TipoOrdenacion;
import static controlador.utiles.Utilidades.getMethod;
import static controlador.utiles.Utilidades.isObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;

    private Integer size;

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    public ListaEnlazada() {
        cabecera = null;
        size = 0;
    }

    public Boolean estaVacia() {
        return cabecera == null;
    }

    private void insertar(E dato) {
        NodoLista<E> nuevo = new NodoLista<>(dato, null);
        if (estaVacia()) {
            cabecera = nuevo;
        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        size++;
    }

    public void insertarCabecera(E dato) {
        if (estaVacia()) {
            insertar(dato);
        } else {
            NodoLista<E> nuevo = new NodoLista<>(dato, null);

            nuevo.setSiguiente(cabecera);
            cabecera = nuevo;
            size++;
        }
    }

    public void insertar(E dato, Integer pos) throws PosicionException {
        //lista size = 1
        if (estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < size) {
            NodoLista<E> nuevo = new NodoLista<>(dato, null);
            if (pos == (size - 1)) {
                insertar(dato);

            } else {

                NodoLista<E> aux = cabecera;
                for (int i = 0; i < pos - 1; i++) {
                    aux = aux.getSiguiente();
                }
                NodoLista<E> siguiente = aux.getSiguiente();
                aux.setSiguiente(nuevo);
                nuevo.setSiguiente(siguiente);
                size++;
            }

        } else {
            throw new PosicionException("Error en insertar: No existe la posicion dada");
        }
    }

    public void imprimir() {
        System.out.println("**************************");
        NodoLista<E> aux = cabecera;
        for (int i = 0; i < getSize(); i++) {
            System.out.print(aux.getDato().toString() + "\t");
            aux = aux.getSiguiente();
        }
        System.out.println("\n" + "**************************");
    }

    public Integer getSize() {
        return size;
    }

    public E obtenerDato(Integer pos) throws PosicionException {
        if (!estaVacia()) {
            if (pos >= 0 && pos < size) {
                E dato = null;
                if (pos == 0) {
                    dato = cabecera.getDato();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                }

                return dato;
            } else {
                throw new PosicionException("Error en obtener dato: No existe la posicion dada");
            }

        } else {
            throw new PosicionException("Error en obtener dato: La lista esta vacia, por endde no hay esa posicion");
        }
    }

    public E eliminarDato(Integer pos) throws PosicionException {
        E auxDato = null;
        if (!estaVacia()) {
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    auxDato = cabecera.getDato();
                    cabecera = cabecera.getSiguiente();
                    size--;
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos - 1; i++) {
                        aux = aux.getSiguiente();
                    }
                    auxDato = aux.getDato();
                    NodoLista<E> proximo = aux.getSiguiente();
                    aux.setSiguiente(proximo.getSiguiente());
                    size--;
                }
                return auxDato;

            } else {
                throw new PosicionException("Error en eliminar dato: No existe la posicion dada");
            }

        } else {
            throw new PosicionException("Error en eliminar dato: La lista esta vacia, por endde no hay esa posicion");
        }
    }

    public void vaciar() {
        cabecera = null;
        size = 0;
    }

    public void modificarDato(Integer pos, E datoM) throws PosicionException {
        if (!estaVacia()) {
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    cabecera.setDato(datoM);
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    aux.setDato(datoM);
                }

            } else {
                throw new PosicionException("Error en obtener dato: No existe la posicion dada");
            }

        } else {
            throw new PosicionException("Error en obtener dato: La lista esta vacia, por endde no hay esa posicion");
        }
    }

    public E[] toArray() {
        E[] matriz = null;
        if (this.size > 0) {
            matriz = (E[]) java.lang.reflect.Array.newInstance(cabecera.getDato().getClass(), this.size);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < this.size; i++) {
                matriz[i] = aux.getDato();

                aux = aux.getSiguiente();
            }
        }

        return matriz;
    }

    public ListaEnlazada<E> toList(E[] matriz) {

        this.vaciar();
        for (int i = 0; i < matriz.length; i++) {
            this.insertar(matriz[i]);
        }
        return this;
    }

    public ListaEnlazada<E> ordenar_seleccion(String atributo, TipoOrdenacion tipoOrdenacion) throws Exception {
        Class<E> clazz = null;
        E[] matriz = null;
        if (size > 0) {
            matriz = toArray();
            E t = null;
            clazz = (Class<E>) cabecera.getDato().getClass();//primitivo, Dato envolvente, Object
            Boolean isObject = Utilidades.isObject(clazz);//si es objeto
            Integer i, j, k = 0;
            Integer n = matriz.length;
            for (i = 0; i < n - 1; i++) {
                k = i;
                t = matriz[i];
                for (j = i + 1; j < n; j++) {
                    if (isObject) {
                        Field field = Utilidades.getField(atributo, clazz);
                        Method method = getMethod("get" + Utilidades.capitalizar(atributo), t.getClass());
                        Method method1 = getMethod("get" + Utilidades.capitalizar(atributo), matriz[j].getClass());
                        Object[] aux = evaluaCambiarDato(field.getType(), t, matriz[j], method, method1, tipoOrdenacion, j);
                        if (aux[0] != null) {
                            t = (E) aux[0];
                            k = (Integer) aux[1];
                        }
                    } else {
                        Object[] aux = evaluaCambiarDatoNoObjeto(clazz, t, matriz[j], tipoOrdenacion, j);
                        if (aux[0] != null) {
                            t = (E) aux[0];
                            k = (Integer) aux[1];
                        }
                    }

                }
                matriz[k] = matriz[i];
                matriz[i] = t;
            }
        }
        if (matriz != null) {
            toList(matriz);
        }
        return this;
    }

    public ListaEnlazada<E> metodoShell(String atributo, TipoOrdenacion tipoOrdenacion) throws PosicionException, Exception {
        Class<E> clazz = null;
        E[] matriz = null;
        if (size > 0) {
            clazz = (Class<E>) cabecera.getDato().getClass();//primitivo, Dato envolvente, Object
            Boolean isObject = Utilidades.isObject(clazz);//si es objeto
            System.out.println("TRANFORMANDO A MATRIZ");
            matriz = toArray();
            int x, salto;
            boolean ordenado;

            for (salto = matriz.length / 2; salto != 0; salto /= 2) {
                ordenado = true;

                while (ordenado) {
                    ordenado = false;

                    for (x = salto; x < matriz.length; x++) {
                        if (isObject) {
                            Field field = Utilidades.getField(atributo, clazz);
                            Method method = getMethod("get" + Utilidades.capitalizar(atributo), matriz[x - salto].getClass());
                            Method method1 = getMethod("get" + Utilidades.capitalizar(atributo), matriz[x].getClass());
                            Object[] aux = evaluaCambiarDato(field.getType(), matriz[x - salto], matriz[x], method, method1, tipoOrdenacion, x - salto);
                            if (aux[0] != null) {
                                E t = matriz[x];
                                matriz[x] = matriz[x - salto];
                                matriz[x - salto] = t;
                                ordenado = true;
                            }
                        } else {
                            Object[] aux = evaluaCambiarDatoNoObjeto(clazz, matriz[x - salto], matriz[x], tipoOrdenacion, x - salto);
                            if (aux[0] != null) {
                                E t = matriz[x];
                                matriz[x] = matriz[x - salto];
                                matriz[x - salto] = t;
                                ordenado = true;
                            }

                        }
                    }
                }
            }

        }
        System.out.println("TRANFORMANDO A LISTA");
        if (matriz != null) {
            toList(matriz);
        }
        return this;

    }

    public ListaEnlazada<E> quickSort(String atributo, TipoOrdenacion tipoOrdenacion) throws PosicionException, Exception {
        Class<E> clazz = null;
        E[] matriz = null;
        if (size > 0) {
            clazz = (Class<E>) cabecera.getDato().getClass();//primitivo, Dato envolvente, Object
            Boolean isObject = Utilidades.isObject(clazz);//si es objeto
            System.out.println("TRANFORMANDO A MATRIZ");
            Field field = Utilidades.getField(atributo, clazz);
            matriz = toArray();
            matriz = quickDatos(matriz, atributo, field.getType(), tipoOrdenacion);
        }
        System.out.println("TRANFORMANDO A LISTA");
        if (matriz != null) {
            toList(matriz);
        }

        return this;

    }

    private E[] quickDatos(E[] matriz, String atributo, Class clazz, TipoOrdenacion tipoOrdenacion) throws Exception {
        E[] mat = matriz;
        quick(mat, 0, mat.length - 1, atributo, clazz, tipoOrdenacion);
        return mat;
    }

    private void quick(E[] arrelo, int inicio, int fin, String atributo, Class clazz, TipoOrdenacion tipoOrdenacion) throws Exception {
        E pivote = arrelo[inicio];
        int i = inicio;
        int j = fin;

        while (i < j) {
            
            Method method = getMethod("get" + Utilidades.capitalizar(atributo), arrelo[i].getClass());
            Method method1 = getMethod("get" + Utilidades.capitalizar(atributo), arrelo[j].getClass());
            Method method2 = getMethod("get" + Utilidades.capitalizar(atributo), pivote.getClass());
            if (Utilidades.isNumber(clazz)) {
                if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {

                    while (((Number) method.invoke(arrelo[i])).doubleValue() <= ((Number) method2.invoke(pivote)).doubleValue() && i < j) {
                        // cambioBurbuja(j, matriz);
                        i++;
                    }
                    while (((Number) method1.invoke(arrelo[j])).doubleValue() > ((Number) method2.invoke(pivote)).doubleValue()) {
                        // cambioBurbuja(j, matriz);
                        j--;
                    }
                } else {
                    while (((Number) method.invoke(arrelo[i])).doubleValue() >= ((Number) method2.invoke(pivote)).doubleValue() && i < j) {
                        // cambioBurbuja(j, matriz);
                        i++;
                    }
                    while (((Number) method1.invoke(arrelo[j])).doubleValue() < ((Number) method2.invoke(pivote)).doubleValue()) {
                        // cambioBurbuja(j, matriz);
                        j--;
                    }
                }
                if (i < j) {
                    E aux = arrelo[i];
                    arrelo[i] = arrelo[j];
                    arrelo[j] = aux;
                    
                }
                
            } else if (Utilidades.isString(clazz)) {

                if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                    while (((String) method.invoke(arrelo[i])).toLowerCase().compareTo(((String) method2.invoke(pivote)).toLowerCase()) <= 0 && i < j) {
                        // cambioBurbuja(j, matriz);
                        i++;
                    }
                    while (((String) method1.invoke(arrelo[j])).toLowerCase().compareTo(((String) method2.invoke(pivote)).toLowerCase()) > 0) {
                        // cambioBurbuja(j, matriz);
                        j--;
                    }
                } else {
                    while (((String) method.invoke(arrelo[i])).toLowerCase().compareTo(((String) method2.invoke(pivote)).toLowerCase()) >= 0 && i < j) {
                        // cambioBurbuja(j, matriz);
                        i++;
                    }
                    while (((String) method1.invoke(arrelo[j])).toLowerCase().compareTo(((String) method2.invoke(pivote)).toLowerCase()) < 0) {
                        // cambioBurbuja(j, matriz);
                        j--;
                    }
                }
                if (i < j) {
                    E aux = arrelo[i];
                    arrelo[i] = arrelo[j];
                    arrelo[j] = aux;
                    
                }

            } else if (Utilidades.isCharacter(clazz)) {
                if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {

                    while (((Character) method.invoke(arrelo[i])) <= ((Character) method2.invoke(pivote)) && i < j) {
                        // cambioBurbuja(j, matriz);
                        i++;
                    }
                    while (((Character) method1.invoke(arrelo[j])) > ((Character) method2.invoke(pivote))) {
                        // cambioBurbuja(j, matriz);
                        j--;
                    }

                } else {
                    while (((Character) method.invoke(arrelo[i])) >= ((Character) method2.invoke(pivote)) && i < j) {
                        // cambioBurbuja(j, matriz);
                        i++;
                    }
                    while (((Character) method1.invoke(arrelo[j])) < ((Character) method2.invoke(pivote))) {
                        // cambioBurbuja(j, matriz);
                        j--;
                    }
                }
                if (i < j) {
                    E aux = arrelo[i];
                    arrelo[i] = arrelo[j];
                    arrelo[j] = aux;
                }

            }

        }
        arrelo[inicio] = arrelo[j];
        arrelo[j] = pivote;

        if (inicio < j - 1) {
            quick(arrelo, inicio, j - 1, atributo, clazz, tipoOrdenacion);
        }

        if (j + 1 < fin) {
            quick(arrelo, j + 1, fin, atributo, clazz, tipoOrdenacion);
        }

    }

    private Object[] evaluaCambiarDatoNoObjeto(Class clazz, E auxJ, E auxJ1, TipoOrdenacion tipoOrdenacion, Integer j) throws Exception {
        Object aux[] = new Object[2];
        if (clazz.getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if ((((Number) auxJ).doubleValue() > ((Number) auxJ1).doubleValue())) {
                    aux[0] = auxJ1;
                    aux[1] = j;

                }
            } else {
                if ((((Number) auxJ).doubleValue() < ((Number) auxJ1).doubleValue())) {
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            }
        } else if (Utilidades.isString(clazz)) {
            String datoJ = (String) auxJ;
            String datoJ1 = (String) auxJ1;
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if ((datoJ.toLowerCase().compareTo(datoJ1.toLowerCase()) > 0)) {

                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            } else {
                if ((datoJ.toLowerCase().compareTo(datoJ1.toLowerCase()) < 0)) {

                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            }

        } else if (Utilidades.isCharacter(clazz)) {
            Character datoJ = (Character) auxJ;
            Character datoJ1 = (Character) auxJ1;
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if (datoJ > datoJ1) {

                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            } else {
                if (datoJ < datoJ1) {

                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            }

        }
        return aux;
    }

    private Object[] evaluaCambiarDato(Class clazz, E auxJ, E auxJ1, Method method, Method method1, TipoOrdenacion tipoOrdenacion, Integer j) throws Exception {
        Object aux[] = new Object[2];
        if (clazz.getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
            Number datoJ = (Number) method.invoke(auxJ);
            Number datoJ1 = (Number) method1.invoke(auxJ1);
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if ((datoJ.doubleValue() > datoJ1.doubleValue())) {
                    // cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            } else {
                if ((datoJ.doubleValue() < datoJ1.doubleValue())) {
                    //    cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            }
        } else if (Utilidades.isString(clazz)) {
            String datoJ = (String) method.invoke(auxJ);
            String datoJ1 = (String) method1.invoke(auxJ1);
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if ((datoJ.toLowerCase().compareTo(datoJ1.toLowerCase()) > 0)) {
                    //   cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            } else {
                if ((datoJ.toLowerCase().compareTo(datoJ1.toLowerCase()) < 0)) {
                    //  cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            }

        } else if (Utilidades.isCharacter(clazz)) {
            Character datoJ = (Character) method.invoke(auxJ);
            Character datoJ1 = (Character) method1.invoke(auxJ1);
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if (datoJ > datoJ1) {
                    // cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            } else {
                if (datoJ < datoJ1) {
                    //  cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            }
        }
        return aux;
    }

//    public static void main(String[] args) throws PosicionException, Exception {
//        ListaEnlazada<Persona> LP = new ListaEnlazada<>();
//
//        LP.insertar(new Persona("Adrián Hernández", 15, 'M', "1106060666", 256.35));
//        LP.insertar(new Persona("Jesús Granda", 12, 'M', "1107896547", 500.12));
//        LP.insertar(new Persona("Zara Romina", 18, 'F', "1103469668", 3256.21));
//        for (int i = 0; i < LP.getSize(); i++) {
//            System.out.println(LP.obtenerDato(i).mostrarInfo());
//        }
//        LP.quickSort("nombreCompleto", TipoOrdenacion.ASCENDENTE);
//        for (int i = 0; i < LP.getSize(); i++) {
//            System.out.println(LP.obtenerDato(i).mostrarInfo());
//        }
//    }
}
