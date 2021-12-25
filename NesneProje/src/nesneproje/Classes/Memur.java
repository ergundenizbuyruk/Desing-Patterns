package nesneproje.Classes;

/**
 *
 * @author Ergun Deniz Buyruk
 */
public class Memur extends Calisan{

    private String adSoyad;
    private int maas;
    
    public Memur() {
        adSoyad = "";
        maas = 0;
    }
    
    public Memur(String adSoyad, int maas) {
        this.adSoyad = adSoyad;
        this.maas = maas;
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
    
    @Override
    public String toString() {
        return ("Memur Adı ve Soyadi: " + adSoyad + " Maaşı: " + maas);
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
