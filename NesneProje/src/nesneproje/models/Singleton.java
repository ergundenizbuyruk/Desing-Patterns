package nesneproje.models;

/*
* Root direktorumuz bir tane olmalıdır. Ve diğer tüm calısanlar bu rootun altında
* olacagi icin istedigimz zaman root nesnesine erisebilmeliyiz. O sebeple root
* olan direktor nesnesini Singleton dizayni ile olustur.
 */
public class Singleton {

    // İçerisinde sadece bir tane Direktor tut.
    private static Direktor rootDirektor;

    // Constructora disaridan erisilemesin.
    private Singleton() {
    }

    // Test icerisinde root direktoru degistirecegimizden set metodu ekle.
    public static void setRootDirektor(Direktor rootDirektor) {
        Singleton.rootDirektor = rootDirektor;
    }

    /*
    * Eger daha once root olusturulmamis ise olustur. 
    * Olusturulmussa bir sey yapma, sonra root'u donder.
     */
    public static Direktor getInstance(String adSoyad, int maas) {
        if (rootDirektor == null) {
            rootDirektor = new Direktor(adSoyad, maas);
        }
        return rootDirektor;
    }

}
