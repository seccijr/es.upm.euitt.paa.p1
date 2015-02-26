package almacen;

import org.junit.Test;
import static org.junit.Assert.*;

public class PoblacionTest {

    @Test
    public void testSetGetNombre() {
        Poblacion p = new Poblacion();
        String tp = "TestPoblacion";
        p.setNombre(tp);
        String result = p.getNombre();

        assertEquals(tp, result);
    }

    @Test
    public void testSetGetProvincia() {
        Poblacion p = new Poblacion();
        String tp = "TestProvincia";
        p.setProvincia(tp);
        String result = p.getProvincia();

        assertEquals(tp, result);
    }

    @Test
    public void testSetGetHabitantes() {
        Poblacion p = new Poblacion();
        int th = 99;
        p.setHabitantes(th);
        int result = p.getHabitantes();

        assertEquals(th, result);
    }
}
