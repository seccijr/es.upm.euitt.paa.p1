package almacen;

import paa.provincias.IPoblacion;
import java.util.SortedSet;
import java.util.TreeSet;

@SuppressWarnings("serial")
class PoblacionSet extends TreeSet<IPoblacion> implements SortedSet<IPoblacion> {
    public IPoblacion find(String name) {
        IPoblacion result = null;
        for(IPoblacion p: this) {
            if (p.getNombre().equals(name)) {
                result = p;
                break;
            }
        }

        return result;
    }

    public IPoblacion find(int index) {
        IPoblacion[] pArray = this.toArray(new Poblacion[this.size()]);

        return pArray[index];
    }
}
