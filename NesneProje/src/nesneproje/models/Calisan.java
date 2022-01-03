package nesneproje.models;

public abstract class Calisan {

    private String adSoyad;
    private double maas;

    public Calisan() {
        adSoyad = "";
        maas = 0;
    }

    public Calisan(String adSoyad, double maas) {
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
    public double getMaas() {
        return maas;
    }

    /**
     * @param maas the maas to set
     */
    public void setMaas(double maas) {
        this.maas = maas;
    }

    public abstract double maliyetHesapla();

    public abstract void altindakileriListele();

    public abstract String toString();

}
