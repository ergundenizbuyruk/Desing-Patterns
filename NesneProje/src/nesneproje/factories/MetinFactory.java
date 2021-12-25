package nesneproje.factories;

import nesneproje.Classes.Memur;
import nesneproje.Classes.Direktor;
import nesneproje.Classes.Calisan;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import nesneproje.collections.MyIterator;
import nesneproje.Classes.Singleton;

/**
 *
 * @author Ergun Deniz Buyruk
 */
public class MetinFactory extends AbstractFactory {
    
    // daha sonra alacağı metni tutacak olan field.
    private BufferedReader reader;
    private String[] calisanParcalari;
    private MyIterator iterator;

    public MetinFactory() {
        calisanParcalari = new String[4];
    }
    
    /*
    * Fabrika olustulduktan sonra aldigi metin dosyasi yolu ile tum nesneleri
    * olusturan ve ilgili Direktorun altina ekleyen metot.
    * Metnin her satırını tek tek okuyup ilgili nesneyi calisanOlustur metodu
    * ile olusturuyor. Bu metot IOException ve  FileNotFoundException
    * firlatabilir. Main icerisinde bu Exception kontrol altinda tutulmalidir.
    */
    public void metindenCalisanOlustur(String dosyaYolu) 
            throws IOException, FileNotFoundException{
        
        reader = new BufferedReader(new FileReader(dosyaYolu));
        String satir;
        
        /*
        * Verilen metnin satirin alip once ilgili nesne olustur. Daha sonra 
        * iterator ile nesneyi uygun olan Direktorun altına ekle.
        */
        while ((satir = reader.readLine()) != null) {
            
            // Her satiri parcalara ayir.
            calisanParcalari = satir.split(",");
            
            // Singleton ile root olup olmadigini kontrol et. Yoksa olustur.
            Direktor rootDirektor = Singleton.getInstance(calisanParcalari[1], 
                    Integer.parseInt(calisanParcalari[2]));
            
            // Calisan nesnesini olustur.
            Calisan calisan = calisanOlustur(calisanParcalari[0], 
                    calisanParcalari[1], Integer.parseInt(calisanParcalari[2]));
            
            // Iteratoru yarat.
            iterator = rootDirektor.getEmrindekilerListesi().iterator();
            
            // Iterator sayesinde olusturulan metni Uygun Direktorun altina ekle.
            iterator.bulVeEkle(calisan, calisanParcalari[3]);
        }
    }
    
    private Calisan calisanOlustur(String calisanTipi, String adSoyad, int maas) {
        if ("D".equalsIgnoreCase(calisanTipi)) {
            return new Direktor(adSoyad, maas);
        } else if ("M".equalsIgnoreCase(calisanTipi)) {
            return new Memur(adSoyad, maas);
        }
        return null;
    }
    
}
