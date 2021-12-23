package nesneproje;

/**
 *
 * @author Ergun Deniz Buyruk
 */
public class Direktor extends Calisan {

    private Calisan[] emrindekilerListesi;
    
    public Direktor() {
        super();
        emrindekilerListesi = new Calisan[50];
    }
    
    public Direktor(String adSoyad, int maas, Calisan[] emrindekilerListesi) {
        super(adSoyad, maas);
        this.emrindekilerListesi = emrindekilerListesi;
    }
    
    public Direktor(String adSoyad, int maas) {
        super(adSoyad, maas);
        this.emrindekilerListesi = new Calisan[50];
    }
    /**
     * @return the emrindekilerListesi
     */
    public Calisan[] getEmrindekilerListesi() {
        return emrindekilerListesi;
    }
    
    public String getAdSoyad() {
        return super.getAdSoyad();
    }
    
    public int getMaas() {
        return super.getMaas();
    }

    /**
     * @param emrindekilerListesi the emrindekilerListesi to set
     */
    public void setEmrindekilerListesi(Calisan[] emrindekilerListesi) {
        this.emrindekilerListesi = emrindekilerListesi;
    }
    
    public void emrindekiListeyeEkle(Calisan calisan) {
        int elemanSayisi = this.getEmrindekilerListesi().length;
        this.getEmrindekilerListesi()[elemanSayisi] = calisan;
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
    public class Iterator implements MyIterator{
        private Calisan position;
        
        // Iterotor ilk oluşturduğunda root olan direktörü referans göstersin.
        public Iterator() {
            position = Singleton.getInstance(getAdSoyad(), getMaas());
        }
        
        /*
        * Her restart atıldığında root direktöre donsun.
        */
        @Override
        public void restart() {
            position = Singleton.getInstance(getAdSoyad(), getMaas());
        }
        
        /*
        * Emri altında bir çalışan olup olmadıgina bakan metot.
        */
        @Override
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
        @Override
        public Calisan peek() {
            return position;
        }
        
        /*
        * Bir sonraki Çalışana giden next metodu.
        */
        @Override
        public void next() {
            
        }
        
        /*
        * Olustulan bir nesneyi hangi direktorun altında çalıştigini bulup
        * o direktorun listesine ekleyen metot.
        */
        @Override
        public boolean bulVeEkle(Calisan eklenecekCalisan, 
                String ustDirektorAdi) {
            
            boolean bulunupEklendiMi = false;
            
            restart();
            Direktor rootPosition = (Direktor) position;
            for (Calisan calisan : rootPosition.getEmrindekilerListesi()) {
                if (calisan.getClass() == Direktor.class) {
                    Direktor alttakiCalisan = (Direktor) calisan;
                    if(alttakiCalisan.getAdSoyad()
                            .equalsIgnoreCase(ustDirektorAdi)) {
                        alttakiCalisan.emrindekiListeyeEkle(eklenecekCalisan);
                        bulunupEklendiMi = true;
                    } else {
                        alttakiCalisan.iterator()
                                .bulVeEkle(eklenecekCalisan, ustDirektorAdi);
                    }
                }
            }
            return bulunupEklendiMi;
        }
    }
}
