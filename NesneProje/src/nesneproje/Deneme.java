package nesneproje;

import nesneproje.models.Singleton;
import nesneproje.factories.MetinFactory;
import nesneproje.factories.FactoryProvider;
import nesneproje.models.Direktor;
import java.io.IOException;
import nesneproje.collections.MyIterator;
import nesneproje.models.Memur;

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

        Direktor rootDirektor = Singleton.getInstance("", 0);
        MyIterator iterator = rootDirektor.getEmrindekilerListesi().iterator();
        
        /*
        * Mustafa Turksever adli direktorun maliyetini hesapla ve 
        * altindakileri listele.
        */
        Direktor MustafaTurksever = (Direktor) iterator.calisaniBul("Mustafa Turksever");
        System.out.println("Mustafa Turksever' in maaliyeti : " 
                + MustafaTurksever.maliyetHesapla()); 
        
        MustafaTurksever.altindakileriListele();
        
        /*
        * Oguz Demir adli direktorun maliyetini hesapla ve 
        * altindakileri listele.
        */
        Direktor OguzDemir = (Direktor) iterator.calisaniBul("Oguz Demir");
        System.out.println("Oguz Demir' in maaliyeti : " 
                + OguzDemir.maliyetHesapla()); 
        
        OguzDemir.altindakileriListele();
        
        /*
        * Ahmet Egeli adli memurun maliyetini hesapla.
        */
        Memur AhmetEgeli = (Memur) iterator.calisaniBul("Ahmet Egeli");
        System.out.println("Ahmet Egeli' in maaliyeti : " 
                + AhmetEgeli.maliyetHesapla()); 
    }
}
