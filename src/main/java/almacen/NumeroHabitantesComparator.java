package almacen;

import java.util.Comparator;
import paa.provincias.IPoblacion;

public class NumeroHabitantesComparator implements Comparator<IPoblacion> {
    public int compare(IPoblacion p1, IPoblacion p2) {
        int nHabitantes1 = p1.getHabitantes();
        int nHabitantes2 = p2.getHabitantes();

        return nHabitantes1 - nHabitantes2;
    }
}
