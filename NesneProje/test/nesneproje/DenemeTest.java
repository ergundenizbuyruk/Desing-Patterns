package nesneproje;

import java.io.IOException;
import nesneproje.factories.FactoryProvider;
import nesneproje.factories.MetinFactory;
import nesneproje.models.*;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class DenemeTest {

    Direktor rootDirektor;

    @After
    public void after() {
        Singleton.setRootDirektor(null);
    }

    @Test
    public void test() throws Exception {
        try {
            FactoryProvider factoryProvider = new FactoryProvider();

            MetinFactory metinFactory
                    = (MetinFactory) factoryProvider.getFactory("metinFactory");
            metinFactory.metindenCalisanOlustur("girdi.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Direktor myRootDirektor = Singleton.getInstance("", 0);

        assertEquals(24000, myRootDirektor.maliyetHesapla(), 0);

    }

    @Test
    public void deneme2() throws Exception {
        try {
            FactoryProvider factoryProvider = new FactoryProvider();

            MetinFactory metinFactory
                    = (MetinFactory) factoryProvider.getFactory("metinFactory");
            metinFactory.metindenCalisanOlustur("girdi1.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Direktor myRootDirektor = Singleton.getInstance("", 0);

        assertEquals(25000, myRootDirektor.maliyetHesapla(), 0);

    }

    @Test
    public void deneme3() throws Exception {
        try {
            FactoryProvider factoryProvider = new FactoryProvider();

            MetinFactory metinFactory
                    = (MetinFactory) factoryProvider.getFactory("metinFactory");
            metinFactory.metindenCalisanOlustur("girdi2.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Direktor myRootDirektor = Singleton.getInstance("", 0);

        assertEquals(26000, myRootDirektor.maliyetHesapla(), 0);
    }
}
