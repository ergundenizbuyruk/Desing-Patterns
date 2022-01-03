package nesneproje.collections;

import nesneproje.models.Direktor;
import nesneproje.models.Calisan;
import nesneproje.models.Memur;
import nesneproje.models.Singleton;

public class MyCalisanList {

    private Calisan[] calisanListesi;
    private int size;

    public MyCalisanList() {
        size = 0;
        calisanListesi = new Calisan[size];
    }

    public void addCalisan(Calisan calisan) {
        Calisan[] newCalisanListesi = new Calisan[++size];
        for (int i = 0; i < calisanListesi.length; i++) {
            newCalisanListesi[i] = calisanListesi[i];
        }
        newCalisanListesi[size - 1] = calisan;
        calisanListesi = newCalisanListesi;
    }

    public Calisan[] getCalisanlarListesi() {
        return calisanListesi;
    }

    // Iteratoru başlatan metot.
    public Iterator iterator() {
        return new Iterator();
    }

    /* Sadece MyCalisanList üzerinde açılabilen ve roottan başlayarak 
    * tum listeyi gezmeyi sağlayan Iterator classı.
     */
    public class Iterator implements MyIterator {

        private int head;

        // Iterotor ilk oluşturduğunda root olan direktörü referans göstersin.
        public Iterator() {
            head = 0;
        }

        /*
        * Her restart atıldığında root direktöre donsun.
         */
        @Override
        public void restart() {
            head = 0;
        }

        /*
        * Emri altında bir çalışan olup olmadıgina bakan metot.
         */
        @Override
        public boolean hasNext() {
            if (size == 0) {
                return false;
            } else {
                return (head < size - 1);
            }
        }

        // O anki çalışanın referansını dondersin.
        @Override
        public Calisan peek() {
            return calisanListesi[head];
        }

        /*
        * Bir sonraki Çalışana giden next metodu.
         */
        @Override
        public void next() {
            if (hasNext()) {
                head++;
            }
        }

        /*
         * Kendisine parametre olarak verilen ad-Soyad ile 
        * Istenen calisanı bulup donderen metot.
         */
        @Override
        public Calisan calisaniBul(String calisanAdSoyad) {
            // Eger aranan root ise direkt root direktorunu donder.
            if (calisanAdSoyad.equalsIgnoreCase(Singleton.
                    getInstance("", 0).getAdSoyad())) {
                return Singleton.getInstance("", 0);
            } else {
                /* Eger Root degilse Cagrılan listeden tum elemanlar tek tek
                * gezilmesi gerekir. 
                 */
                for (Calisan calisan : getCalisanlarListesi()) {
                    // Eger calisan aradığımız calisan ise donder.
                    if (calisanAdSoyad.equalsIgnoreCase(calisan.getAdSoyad())) {
                        return calisan;
                    }
                    // Eger calisan Direktor ise onun da altindaki calisanlari gez.
                    else if (calisan.getClass() == Direktor.class) {
                        Direktor alttakiCalisan = (Direktor) calisan;
                        return alttakiCalisan.getEmrindekilerListesi()
                                .iterator().calisaniBul(calisanAdSoyad);
                    }
                }
                return null;
            }
        }

        /*
        * Olustulan bir nesneyi hangi direktorun altında çalıştigini bulup
        * o direktorun listesine ekleyen metot.
         */
        @Override
        public boolean bulVeEkle(Calisan eklenecekCalisan,
                String ustDirektorAdi) {
            boolean bulunupEklendiMi = false;

            // Eger root geldiyse bir yere ekleme.
            if (ustDirektorAdi.equalsIgnoreCase("root")) {
                bulunupEklendiMi = true;

                // Eger Roota eklenecekse Roota ekle.    
            } else if (ustDirektorAdi.equalsIgnoreCase(Singleton.getInstance("", 0).getAd())) {
                Singleton.getInstance("", 0).emrindekiListeyeEkle(eklenecekCalisan);
                bulunupEklendiMi = true;
            } else {
                // Eger Root degil ve roota eklenmeyecekse roottan baslayarak
                // her direktoru bul ve uygun olan direktorun altina ekle.
                for (Calisan calisan : getCalisanlarListesi()) {
                    if (calisan != null && calisan.getClass() == Direktor.class) {
                        Direktor altindakiCalisan = (Direktor) calisan;
                        if (altindakiCalisan.getAd().equalsIgnoreCase(ustDirektorAdi)) {
                            altindakiCalisan.emrindekiListeyeEkle(eklenecekCalisan);
                            bulunupEklendiMi = true;
                        } else {
                            altindakiCalisan.getEmrindekilerListesi()
                                    .iterator()
                                    .bulVeEkle(eklenecekCalisan, ustDirektorAdi);
                        }
                    }
                }
            }
            return bulunupEklendiMi;
        }
    }
}
