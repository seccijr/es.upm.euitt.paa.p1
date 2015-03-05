package almacen;

import paa.provincias.IPoblacion;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;

@SuppressWarnings("serial")
class PoblacionSet extends TreeSet<IPoblacion> implements SortedSet<IPoblacion> {
    public PoblacionSet() {
        super();
    }

    public PoblacionSet(Comparator<IPoblacion> c) {
        super(c);
    }

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
        IPoblacion p;
        IPoblacion[] pArray = this.toArray(new Poblacion[this.size()]);

        try {
            p = pArray[index];
        }
        catch(ArrayIndexOutOfBoundsException e) {
            p = null;
        }

        return p;
    }
}
