package almacen;

import paa.provincias.IPoblacion;

class Poblacion implements IPoblacion {
    private String nombre;
    private String provincia;
    private int habitantes;

    public String getNombre() {
        return this.nombre;
    }

    public String getProvincia() {
        return this.provincia;
    }

    public int getHabitantes() {
        return this.habitantes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }
}
