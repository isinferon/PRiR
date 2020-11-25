
public class DiabelskiMlyn {
    private int iloscMiejsc;
    private int cena;

    DiabelskiMlyn(int iloscMiejsc, int cena) {
        this.iloscMiejsc = iloscMiejsc;
        this.cena = cena;
    }

    public synchronized boolean mamyMiejsce() {
        if (iloscMiejsc > 0) {
            iloscMiejsc--;
            return true;
        }

        return false;
    }

    public synchronized void wyjdz() {
        iloscMiejsc++;
    }

    public int cenaWejscia() {
        return cena;
    }
}
