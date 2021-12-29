package nesneproje.collections;

import nesneproje.models.Calisan;

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
