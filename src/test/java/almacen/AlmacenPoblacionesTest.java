package almacen;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import paa.provincias.IPoblacion;
import paa.provincias.IAlmacenPoblaciones;
import java.util.Set;

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
}
