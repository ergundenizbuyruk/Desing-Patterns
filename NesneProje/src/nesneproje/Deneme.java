package nesneproje;

import nesneproje.models.Singleton;
import nesneproje.factories.MetinFactory;
import nesneproje.factories.FactoryProvider;
import nesneproje.models.Direktor;
import java.io.IOException;
import nesneproje.collections.MyIterator;
import nesneproje.models.Calisan;

public class Deneme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        FactoryProvider factoryProvider = new FactoryProvider();

        MetinFactory metinFactory
                = (MetinFactory) factoryProvider.getFactory("metinFactory");

        /*
        * metindenCalisanOlustur metodu IOException veya FileNotFoundException
        * fırlatabilir. Bu sebeple try catch icinde yazildi.
        * FileNotFoundException icin ayrica catch blogu yazilmadi cunku
        * IOException zaten onu kapsiyor.
        *
        * NOT: girdi.txt dosyası projeyle aynı klasorde oldugundan
        * direkt adi yazilmistir. Baska bir dosya ile denenecekse
        * dosya yolu olarak bildirilmelidir.
         */
        try {
            metinFactory.metindenCalisanOlustur("girdi.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* 
        * Once Root direktorumuzu cagiralim ve onun uzerinde iteratorumuzu
        * cagiralim.
        */
        Direktor rootDirektor = Singleton.getInstance("", 0);
        MyIterator iterator = rootDirektor.getEmrindekilerListesi().iterator();
        
        /*
        * Dokumanda belirtildigi gibi Mustafa Turksever adli calisan olusturulup
        * bu calisanin maliyeti ve altindakiler listelenmistir.
        */
        Calisan MustafaTurksever = iterator.calisaniBul("Mustafa Turksever");
        System.out.println(MustafaTurksever.maliyetHesapla());
        MustafaTurksever.altindakileriListele();
        
        System.out.println("\n-----------------------------------------\n");
        
        /*
        * Dokumanda belirtildigi gibi Oguz Demir adli calisan olusturulup
        * bu calisanin maliyeti ve altindakiler listelenmistir.
        */
        Calisan OguzDemir = iterator.calisaniBul("Oguz Demir");
        System.out.println(OguzDemir.maliyetHesapla());
        OguzDemir.altindakileriListele();
        
        System.out.println("\n-----------------------------------------\n");
        
        /*
        * Dokumanda belirtildigi gibi Ahmet Egeli adli calisan olusturulup
        * bu calisanin maliyeti ve altindakiler listelenmistir.
        */
        Calisan AhmetEgeli = iterator.calisaniBul("Ahmet Egeli");
        System.out.println(AhmetEgeli.maliyetHesapla());
        AhmetEgeli.altindakileriListele();
    }
}
