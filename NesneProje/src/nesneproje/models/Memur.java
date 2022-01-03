package nesneproje.models;

public class Memur extends Calisan {

    private String adSoyad;
    private int maas;

    public Memur() {
        super();
    }

    public Memur(String adSoyad, int maas) {
        super(adSoyad, maas);
    }

    @Override
    public String toString() {
        return ("Memur Adı ve Soyadi: " + super.getAdSoyad() + " Maaşı: " + super.getMaas());
    }

    /*
    * Bir memurun maliyeti altında kimse olmadığı için kendi maliyeti kadardır.
     */
    @Override
    public double maliyetHesapla() {
        return maas;
    }

    /*
    * Once kendini yaz ve altında kimse olmadığını belirten bir String yaz.
     */
    @Override
    public void altindakileriListele() {
        toString();
        System.out.println("Altında kimse yok.");
    }
}
