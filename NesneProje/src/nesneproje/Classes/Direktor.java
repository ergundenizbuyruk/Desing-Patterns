package nesneproje.Classes;

import nesneproje.collections.MyCalisanList;

/**
 *
 * @author Ergun Deniz Buyruk
 */
public class Direktor extends Calisan {

    private MyCalisanList emrindekilerListesi;

    public Direktor() {
        super();
        emrindekilerListesi = new MyCalisanList();
    }

    public Direktor(String adSoyad, int maas) {
        super(adSoyad, maas);
        this.emrindekilerListesi = new MyCalisanList();
    }

    /**
     * @return the emrindekilerListesi
     */
    public MyCalisanList getEmrindekilerListesi() {
        return emrindekilerListesi;
    }

    public String getAdSoyad() {
        return super.getAdSoyad();
    }

    public int getMaas() {
        return super.getMaas();
    }

    public void emrindekiListeyeEkle(Calisan eklenecekCalisan) {
        emrindekilerListesi.addCalisan(eklenecekCalisan);
    }

    @Override
    public String toString() {
        return ("Direktorun Adı ve Soyadı: " + super.getAdSoyad()
                + " maasi: " + super.getMaas());
    }

    /*
    * Bir direktörün maliyeti kendi maaşı ve altındaki çalışanların tum
    * maaşları toplamıdır. O sebeple once kendi maaşını toplam maliyete atadım.
    * Daha sonra kendisin altındaki diğer çalışanları tutan listeyi tek tek gezdim.
    * Her elemanın maaliyetini hesaplayip toplam Maliyete ekledim. 
    * En son toplam maliyeti donderdim.
    *
    * Eğer altındaki de Direktorse onun altındakileri de gezip 
    * maaşlarını toplayıp geri donecektir. Ama eğer altındaki memur ise
    * memurun maliyetHesapla metodu çalışacaktır. 
    *
    * Memurun maliyeti sadece kendi maaşıdır.
     */
    @Override
    public double maliyetHesapla() {
        int toplamMaliyet = super.getMaas();
        for (Calisan altindakiCalisan : emrindekilerListesi.getCalisanlarListesi()) {
            if (altindakiCalisan != null) {
                toplamMaliyet += altindakiCalisan.maliyetHesapla();
            }
        }
        return toplamMaliyet;
    }

    /*
    * ALtındakileri listelemek için once direktorun kendi bilgilerini
    * yazdım. Daha sonra altındakiler için tutmuş olduğu listeyi tek tek
    * gezdim. Eğer altındaki memursa onun altında başka kimse olmayacağı için 
    * direkt olarak kendi bilgilerini yazdirdim.
    * 
    * Ama eğer altındaki de bir Direktör ise onun için de aynı metodu tekrar
    * çağırdım. Bu metot da once direktorun kendi adını sonra altındakileri yazacak.
    * Böylelikle Bir direktorun kendi adi ve altındaki tüm çalışanlar
    * ekrana yazılmış olacaktır.
     */
    @Override
    public void altindakileriListele() {
        System.out.println(toString());
        for (Calisan altindakiCalisan : emrindekilerListesi.getCalisanlarListesi()) {
            if (altindakiCalisan != null) {
                if (altindakiCalisan.getClass() == Direktor.class) {
                    Direktor direktorCalisan = (Direktor) altindakiCalisan;
                    if (direktorCalisan.getEmrindekilerListesi().getCalisanlarListesi().length == 0) {
                        System.out.println(direktorCalisan);
                    } else {
                        direktorCalisan.altindakileriListele();
                    }
                } else {// altindakiCalisan Memur Demektir.
                    System.out.println(altindakiCalisan.toString());
                }
            }
        }
    }
}
