package almacen;

import paa.provincias.IPoblacion;
import paa.provincias.IAlmacenPoblaciones;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.HashMap;

class AlmacenPoblaciones implements IAlmacenPoblaciones {
    private HashMap<String, SortedSet<IPoblacion>> almacenPoblaciones = null;

    /**
     * Class constructor for AlmacenPoblaciones
     *
     * @return      an instance of AlmacenPoblaciones
     */
    public AlmacenPoblaciones() {
        this.almacenPoblaciones = new HashMap<String, SortedSet<IPoblacion>>();
    }

    /**
     * Class constructor for AlmacenPoblaciones
     *
     * @param almacenPoblaciones    Hashmap<String, SortedSet<IPoblacion>>
     *                              with the prefilled almacen
     * @return                      an instance of AlmacenPoblaciones
     */
    public AlmacenPoblaciones(HashMap<String, SortedSet<IPoblacion>> almacenPoblaciones) {
        this.almacenPoblaciones = almacenPoblaciones;
    }

    /**
     * Método auxiliar para añadir provincias al almacen
     * de provincias instanciado
     *
     * @param provincia String con el nombre de la provincia
     * @return          Boolean que verifica si se ha añadido
     *                  correctamente la provincia
     */
    public boolean addProvincia(String provincia) {
        if (!almacenPoblaciones.containsKey(provincia)) {
            almacenPoblaciones.put(provincia, new PoblacionSet());
            return true;
        }

        return false;
    }

    /**
     * Método auxiliar para una población al la provincia
     * especificada como primer parámetro
     *
     * @param provincia String con el nombre de la provincia
     * @param poblacion IPoblacion la instancia de la población
                        a añadir
     * @return          Boolean que verifica si se ha añadido
     *                  correctamente la población al contenedor
     */
    public boolean addPoblacion(String provincia, IPoblacion poblacion) {
        if (this.almacenPoblaciones.containsKey(provincia)) {
            PoblacionSet poblaciones = (PoblacionSet)this.almacenPoblaciones.get(provincia);
            poblaciones.add(poblacion);
            this.almacenPoblaciones.put(provincia, poblaciones);

            return true;
        }

        return false;
    }

    /**
     * Método auxiliar para detectar si una provincia existe
     * dentro del almacen
     *
     * @param provincia String con el nombre de la provincia
     * @return          Boolean que verifica si existe la
     *                  provincia
     */
    public boolean containsProvincia(String provincia) {
        return this.almacenPoblaciones.containsKey(provincia);
    }

    /**
     * Método auxiliar para detectar si una poblacion existe
     * dentro del almacen para una provincia dada
     *
     * @param provincia String con el nombre de la provincia
     * @param poblacion String con el nombre de la población
     * @return          Boolean que verifica si existe la
     *                  población dentro de la provincia
     */
    public boolean containsPoblacion(String provincia, String nombre) {
        if (this.almacenPoblaciones.containsKey(provincia)) {
            PoblacionSet poblaciones = (PoblacionSet)this.almacenPoblaciones.get(provincia);

            return poblaciones.contains(new Poblacion(nombre));
        }

        return false;
    }

    /**
     * Método auxiliar para detectar si una poblacion existe
     * dentro del almacen para una provincia dada
     *
     * @param provincia String con el nombre de la provincia
     * @param poblacion IPoblacion con la instancia de la población
     * @return          Boolean que verifica si existe la
     *                  población dentro de la provincia
     */
    public boolean containsPoblacion(String provincia, IPoblacion poblacion) {
        if (this.almacenPoblaciones.containsKey(provincia)) {
            PoblacionSet poblaciones = (PoblacionSet)this.almacenPoblaciones.get(provincia);

            return poblaciones.contains(poblacion);
        }

        return false;
    }

    /**
     * Método auxiliar para borrar si una provincia
     * dentro del almacen
     *
     * @param provincia String con el nombre de la provincia
     * @return          Boolean que verifica si se ha borrado
     *                  la provincia
     */
    public boolean delProvincia(String provincia) {
        if (this.almacenPoblaciones.containsKey(provincia)) {
            SortedSet<IPoblacion> result = this.almacenPoblaciones.remove(provincia);

            return result != null;
        }

        return false;
    }

    /**
     * Método auxiliar para borrar si una provincia
     * dentro del almacen
     *
     * @param provincia String con el nombre de la provincia
     * @return          Boolean que verifica si se ha borrado
     *                  la provincia
     */
    public boolean delPoblacion(String provincia, int posicion) {
        if (this.almacenPoblaciones.containsKey(provincia)) {
            PoblacionSet poblaciones = (PoblacionSet)this.almacenPoblaciones.get(provincia);
            IPoblacion poblacion = poblaciones.find(posicion);
            boolean result = poblaciones.remove(poblacion);
            this.almacenPoblaciones.put(provincia, poblaciones);

            return result;
        }

        return false;
    }

    public boolean delPoblacion(String provincia, String nombre) {
        return false;
    }

    public boolean delPoblacion(String provincia, IPoblacion poblacion) {
        return false;
    }

    public Set<String> getProvincias() {
        if (this.almacenPoblaciones != null) {
            return this.almacenPoblaciones.keySet();
        }

        return null;
    }

    public IPoblacion getPoblacion(String provincia, int posicion) {
        return null;
    }

    public IPoblacion getPoblacion(String provincia, String nombre) {
        IPoblacion p = null;
        if (this.almacenPoblaciones.containsKey(provincia)) {
            PoblacionSet poblaciones = (PoblacionSet)this.almacenPoblaciones.get(provincia);
            p = poblaciones.find(nombre);
        }

        return p;
    }

    public SortedSet<IPoblacion> getPoblaciones(String provincia) {
        return null;
    }

    public int getNumPoblaciones(String provincia) {
        return Integer.MIN_VALUE;
    }

    public boolean ordenarPor(String provincia, int ordenarPor) {
        return false;
    }

    public boolean guardar(String nombreFichero) {
        return false;
    }

    public boolean recuperar(String nombreFichero) {
        return false;
    }
}
