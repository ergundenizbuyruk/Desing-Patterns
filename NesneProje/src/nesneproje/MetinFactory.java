/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nesneproje;

import java.util.Scanner;

/**
 *
 * @author Ergun Deniz Buyruk
 */
public class MetinFactory implements AbstractFactory {
    
    // daha sonra alacağı metni tutacak olan field.
    private Scanner girdiMetni;

    public MetinFactory() {}
    
    // Fabrika oluştuktan sonra metni verebileceğimiz metot.
    public void setMetin(Scanner girdiMetni) {
        this.girdiMetni = girdiMetni;
    }
    /*
    * Metnin her satırını tek tek okuyup ilgili nesneyi nesneOlustur metodu
    * ile olusturan metot.
    */
    private void metniOku() {
        // pass
    }
    
    public Calisan nesneOlustur(String calisanTipi, String adSoyad, int maas) {
        if ("D".equalsIgnoreCase(calisanTipi) 
                || "Root".equalsIgnoreCase(calisanTipi)){
            return new Direktor(adSoyad, maas);
        } else if ("M".equalsIgnoreCase(calisanTipi)) {
            return new Memur(adSoyad, maas);
        }
        return null;
    }
    
}
