import java.util.function.Function;

class M_Simpsona extends Thread {
    private double wynik;
    private double poczatek;
    private double koniec;
    private double liczbaPodzialow;
    private int i;
    private Rodzaj rodzaj;
    private Function<Double, Double> f;

    public enum Rodzaj {
        Zwykly, Xi, Ti
    }

    public M_Simpsona(double poczatek, double koniec, double liczbaPodzialow, int i, Rodzaj rodzaj,
                      Function<Double, Double> f) {
        this.poczatek = poczatek;
        this.koniec = koniec;
        this.liczbaPodzialow = liczbaPodzialow;
        this.i = i;
        this.rodzaj = rodzaj;
        this.f = f;
    }

    @Override
    public void run() {
        switch (rodzaj) {
            case Zwykly:
                policzZwykly();
                break;
            case Xi:
                policzXi();
                break;
            case Ti:
                policzTi();
                break;
        }
    }

    private void policzZwykly() {
        double dx = (koniec - poczatek) / liczbaPodzialow;
        if (i == 0)
            wynik = f.apply(poczatek) * dx / 6;
        else if (i == 1)
            wynik = f.apply(koniec) * dx / 6;
    }

    private void policzXi() {
        double dx = (koniec - poczatek) / liczbaPodzialow;
        double xi = poczatek + i * dx;
        wynik = f.apply(xi) * dx / 6 * 2;
    }

    private void policzTi() {
        double dx = (koniec - poczatek) / liczbaPodzialow;
        double ti = (poczatek + (i - 1) * dx + poczatek + (i + 1) * dx) / 2;
        wynik = f.apply(ti) * dx / 6 * 4;
    }

    public double getWynik() {
        return wynik;
    }
}