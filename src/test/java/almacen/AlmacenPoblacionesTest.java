package almacen;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import paa.provincias.IPoblacion;
import paa.provincias.IAlmacenPoblaciones;
import java.util.Set;
import java.util.SortedSet;

public class AlmacenPoblacionesTest {

    @Test
    public void addGetProvinciaPass() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        Set<String> provincias = ap.getProvincias();

        assertThat(provincias, hasItem("TEST_PROVINCIA"));
    }

    @Test
    public void addGetPoblacionNombrePass() {
        IPoblacion p;
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", p = new Poblacion("TEST_POBLACION"));
        IPoblacion pt = ap.getPoblacion("TEST_PROVINCIA", "TEST_POBLACION");

        assertThat(p, equalTo(pt));
    }

    @Test
    public void containsProvinciaPass() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        boolean result = ap.containsProvincia("TEST_PROVINCIA");

        assertThat(result, is(true));
    }

    @Test
    public void containsProvinciaFails() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        boolean result = ap.containsProvincia("TEST_OTRA_PROVINCIA");

        assertThat(result, is(false));
    }

    @Test
    public void containsPoblacionNombrePass() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION"));
        boolean result = ap.containsPoblacion("TEST_PROVINCIA", "TEST_POBLACION");

        assertThat(result, is(true));
    }

    @Test
    public void containsPoblacionNombreFails() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION"));
        boolean result = ap.containsPoblacion("TEST_PROVINCIA", "TEST_OTRA_POBLACION");

        assertThat(result, is(false));
    }

    @Test
    public void containsPoblacionInstanciaPass() {
        IPoblacion p;
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", p = new Poblacion("TEST_POBLACION"));
        boolean result = ap.containsPoblacion("TEST_PROVINCIA", p);

        assertThat(result, is(true));
    }

    @Test
    public void containsPoblacionInstanciaFails() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION"));
        boolean result = ap.containsPoblacion("TEST_PROVINCIA",  new Poblacion("TEST_OTRA_POBLACION"));

        assertThat(result, is(false));
    }

    @Test
    public void delProvinciaPass() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        boolean result = ap.delProvincia("TEST_PROVINCIA");

        assertThat(result, is(true));
    }

    @Test
    public void delProvinciaFails() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        boolean result = ap.delProvincia("TEST_OTRA_PROVINCIA");

        assertThat(result, is(false));
    }

    @Test
    public void delPoblacionIntPass() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION"));
        boolean result = ap.delPoblacion("TEST_PROVINCIA", 0);

        assertThat(result, is(true));
    }

    @Test
    public void delPoblacionIntFails() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION"));
        boolean result = ap.delPoblacion("TEST_OTRA_PROVINCIA", 0);

        assertThat(result, is(false));
    }

    @Test
    public void delPoblacionNamePass() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION"));
        boolean result = ap.delPoblacion("TEST_PROVINCIA", "TEST_POBLACION");

        assertThat(result, is(true));
    }

    @Test
    public void delPoblacionNameFails() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION"));
        boolean result = ap.delPoblacion("TEST_OTRA_PROVINCIA", "TEST_POBLACION");

        assertThat(result, is(false));
    }

    @Test
    public void delPoblacionInstancePass() {
        IPoblacion p;
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", p = new Poblacion("TEST_POBLACION"));
        boolean result = ap.delPoblacion("TEST_PROVINCIA", p);

        assertThat(result, is(true));
    }

    @Test
    public void delPoblacionInstanceFails() {
        IPoblacion p = new Poblacion("TEST_OTRA_POBLACION");
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION"));
        boolean result = ap.delPoblacion("TEST_OTRA_PROVINCIA", p);

        assertThat(result, is(false));
    }

    @Test
    public void getPoblacionIntPass() {
        IPoblacion p;
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", p = new Poblacion("TEST_POBLACION"));
        IPoblacion pt = ap.getPoblacion("TEST_PROVINCIA", 0);

        assertThat(p, equalTo(pt));
    }

    @Test
    public void getPoblacionIntFails() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION"));
        IPoblacion pt = ap.getPoblacion("TEST_PROVINCIA", 1);

        assertThat(pt, nullValue());
    }

    @Test
    public void getPoblacionesPass() {
        IPoblacion p1;
        IPoblacion p2;
        SortedSet<IPoblacion> poblaciones = new PoblacionSet();
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", p1 = new Poblacion("TEST_POBLACION_I"));
        ap.addPoblacion("TEST_PROVINCIA", p2 = new Poblacion("TEST_POBLACION_II"));
        SortedSet<IPoblacion> result = ap.getPoblaciones("TEST_PROVINCIA");
        poblaciones.add(p1);
        poblaciones.add(p2);

        assertThat(result, equalTo(poblaciones));
    }

    @Test
    public void getPoblacionesFails() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION_I"));
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION_II"));
        SortedSet<IPoblacion> result = ap.getPoblaciones("TEST_OTRA_PROVINCIA");

        assertThat(result, nullValue());
    }

    @Test
    public void getNumPoblacionesPass() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION_I"));
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION_II"));
        int result = ap.getNumPoblaciones("TEST_PROVINCIA");

        assertThat(result, is(2));
    }

    @Test
    public void getNumPoblacionesFails() {
        IAlmacenPoblaciones ap = new AlmacenPoblaciones();
        ap.addProvincia("TEST_PROVINCIA");
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION_I"));
        ap.addPoblacion("TEST_PROVINCIA", new Poblacion("TEST_POBLACION_II"));
        int result = ap.getNumPoblaciones("TEST_OTRA_PROVINCIA");

        assertThat(result, is(Integer.MIN_VALUE));
    }
}
