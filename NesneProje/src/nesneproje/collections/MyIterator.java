/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesneproje.collections;

import nesneproje.Classes.Calisan;

/**
 *
 * @author Ergun Deniz Buyruk
 */
public interface MyIterator {

    public void restart();
    
    public boolean hasNext();
    
    public Calisan peek();
    
    public void next();
    
    public boolean bulVeEkle(Calisan eklenecekCalisan, 
                String ustDirektorAdi);
}
