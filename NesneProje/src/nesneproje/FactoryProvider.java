/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesneproje;

/**
 *
 * @author Ergun Deniz Buyruk
 */

/*
* Main içerisinde hangi fabrikanın çağrılmasına karar veren Fabrika seçici class.
*/
public class FactoryProvider {
    
    /*
    * Eğer getFactory'nin parametresi metinFactory ise metinden bilgileri
    * alıp uygun nesneleri ureten Fabrikayi çağır. Şimdilik veriyi başka bir 
    * yerden almayacagimiz icin baska fabrika yok.
    */
    public static AbstractFactory getFactory(String factoryName){
        if ("metinFactory".equalsIgnoreCase(factoryName)) {
            return new MetinFactory();
        }
        return null;
    }
    
}
