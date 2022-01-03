package nesneproje;

import java.io.IOException;
import nesneproje.factories.FactoryProvider;
import nesneproje.factories.MetinFactory;
import nesneproje.models.*;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/*
* Bu test classinda MyCalisanList icerisinde yazmıs oldugumuz bulVeEkle 
* metodunu test ettik.
 */
public class DenemeTest {

    Direktor rootDirektor;

    // Her deneme sonucu root direktorunu null yap.
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

        /* Sonucun 24000 olması gerekiyor. Eger metodumuz dogru calisiyorsa
         * testimizin successfly vermesi gerekir.
         */
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

        /* Farklı bir girdi ile test et. Sonucun 25000 olması gerekiyor. 
         * Eger metodumuz dogru calisiyorsa testimizin successfly vermesi gerekir.
         */
        assertEquals(10950, myRootDirektor.maliyetHesapla(), 0);

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

        /* Farklı bir girdi ile test et. Sonucun 26000 olması gerekiyor. 
        * Eger metodumuz dogru calisiyorsa testimizin successfly vermesi gerekir.
         */
        assertEquals(26800, myRootDirektor.maliyetHesapla(), 0);
    }
}
