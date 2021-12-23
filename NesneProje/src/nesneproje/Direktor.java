package nesneproje;

/**
 *
 * @author Ergun Deniz Buyruk
 */
public class Direktor implements Calisan {

    private String adSoyad;
    private int maas;
    private Calisan[] emrindekilerListesi;
    
    public Direktor() {
        adSoyad = "";
        maas = 0;
        emrindekilerListesi = new Calisan[50];
    }
    
    public Direktor(String adSoyad, int maas, Calisan[] emrindekilerListesi) {
        this.adSoyad = adSoyad;
        this.maas = maas;
        this.emrindekilerListesi = emrindekilerListesi;
    }
    
    public Direktor(String adSoyad, int maas) {
        this.adSoyad = adSoyad;
        this.maas = maas;
        this.emrindekilerListesi = new Calisan[50];
    }

    /**
     * @return the adSoyad
     */
    public String getAdSoyad() {
        return adSoyad;
    }

    /**
     * @param adSoyad the adSoyad to set
     */
    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    /**
     * @return the maas
     */
    public int getMaas() {
        return maas;
    }

    /**
     * @param maas the maas to set
     */
    public void setMaas(int maas) {
        this.maas = maas;
    }

    /**
     * @return the emrindekilerListesi
     */
    public Calisan[] getEmrindekilerListesi() {
        return emrindekilerListesi;
    }

    /**
     * @param emrindekilerListesi the emrindekilerListesi to set
     */
    public void setEmrindekilerListesi(Calisan[] emrindekilerListesi) {
        this.emrindekilerListesi = emrindekilerListesi;
    }
    
    @Override
    public String toString() {
        return ("Direktorun Adı ve Soyadı: " + adSoyad + " maasi: " + maas);
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
        int toplamMaliyet = maas;
        for (Calisan altindakiCalisan : emrindekilerListesi) {
            toplamMaliyet += altindakiCalisan.maliyetHesapla();
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
        toString();
        for (Calisan altindakiCalisan : emrindekilerListesi) {
            if (altindakiCalisan.getClass() == Direktor.class) {
                altindakiCalisan.altindakileriListele();
            } else{
                System.out.println(altindakiCalisan.toString());
            }
        }
    }
    
    // Iteratoru başlatan metot.
    public Iterator iterator() {
        return new Iterator();
    }
    
    /* Sadece Direktor üzerinde açılabilen ve roottan başlayarak tum listeyi
    * gezmeyi sağlayan Iterator classı.
    */
    public class Iterator {
        private Calisan position;
        
        // Iterotor ilk oluşturduğunda root olan direktörü referans göstersin.
        public Iterator() {
            position = Singleton.getInstance(adSoyad, maas);
        }
        
        /*
        * Her restart atıldığında root direktöre donsun.
        */
        public void restart() {
            position = Singleton.getInstance(adSoyad, maas);
        }
        
        /*
        * .
        */
        public boolean hasNext() {
            if (position.getClass() == Memur.class) {
                return false;
            } 
            else{
                Direktor positionDirektor = (Direktor) position;
                if (positionDirektor.getEmrindekilerListesi() == null) {
                    return false;
                }
                return true;
            }
        }
        
        // O anki çalışanın referansını dondersin.
        public Calisan peek() {
            return position;
        }
        
        /*
        * Bir sonraki Çalışana giden next metodu.
        */
        public void next() {
            
        }
        
    }
    
}
