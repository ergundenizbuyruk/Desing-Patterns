package nesneproje;

import nesneproje.Classes.Singleton;
import nesneproje.factories.MetinFactory;
import nesneproje.factories.FactoryProvider;
import nesneproje.Classes.Direktor;
import java.io.IOException;

/**
 *
 * @author Ergun Deniz Buyruk
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FactoryProvider factoryProvider = new FactoryProvider();
        
        MetinFactory metinFactory = 
                (MetinFactory) factoryProvider.getFactory("metinFactory");
        
        /*
        * metindenCalisanOlustur metodu IOException veya FileNotFoundException
        * fırlatabilir. Bu sebeple try catch icinde yazildi.
        * FileNotFoundException icin ayrica catch blogu yazilmadi cunku
        * IOException zaten onu kapsiyor.
        */
        try{
            metinFactory.metindenCalisanOlustur("girdi.txt");
        } catch (IOException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        Direktor rootDirektor = Singleton.getInstance("", 0);
        
        
        System.out.println(rootDirektor.maliyetHesapla());
       
        
        rootDirektor.altindakileriListele();
        
        
    }
    
}
