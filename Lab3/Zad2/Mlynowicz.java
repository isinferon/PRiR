import java.util.Random;

public class Mlynowicz extends Thread {
    private int numer;
    private int iloscPieniedzy;
    private Stan stan;
    private DiabelskiMlyn mlyn;
    private Random random;

    public Mlynowicz(int numer, int iloscPieniedzy, DiabelskiMlyn mlyn) {
        this.numer = numer;
        this.iloscPieniedzy = iloscPieniedzy;
        this.stan = new KolejkaStan(this);
        this.mlyn = mlyn;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            czasMija();
            stan = stan.cosRobi();
        }
    }

    public boolean znalazlMiejsce() {
        return this.mlyn.mamyMiejsce();
    }

    public void kupujeBilet() {
        this.iloscPieniedzy -= this.mlyn.cenaWejscia();
    }

    public boolean maPieniadzeNaBilet() {
        return this.iloscPieniedzy > this.mlyn.cenaWejscia();
    }

    public void dodajPieniadze(int wyplata) {
        this.iloscPieniedzy += wyplata;
    }

    public void wysiada() {
        this.mlyn.wyjdz();
    }

    public String toString() {
        return String.valueOf(numer);
    }

    private void czasMija() {
        long czas = random.nextInt(1000) + 1000;

        try {
            Thread.sleep(czas);
        } catch (InterruptedException e) {
        }
    }
}
