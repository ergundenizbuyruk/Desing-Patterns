package nesneproje.Classes;

import nesneproje.Classes.Direktor;

/**
 *
 * @author Ergun Deniz Buyruk
 */

/*
* Root direktorumuz bir tane olmalıdır. Ve diğer tüm calısanlar bu rootun altında
* olacagi icin istedigimz zaman root nesnesine erisebilmeliyiz. O sebeple root
* olan direktor nesnesini Singleton dizayni ile olustur.
*/
public class Singleton {
    
    // İçerisinde sadece bir tane Direktor tut.
    private static Direktor rootDirektor;
    
    // Constructora disaridan erisilemesin.
    private Singleton() { }
    
    /*
    * Eger daha once root olusturulmamis ise olustur. 
    * Olusturulmussa bir sey yapma, sonra root'u donder.
    */
    public static Direktor getInstance(String adSoyad, int maas) {
        if(rootDirektor == null) {
            rootDirektor = new Direktor(adSoyad, maas);
        }
        return rootDirektor;
    }
    
}
