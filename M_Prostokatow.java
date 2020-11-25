import java.util.function.Function;

class M_Prostokatow extends Thread {
    private double wynik;
    private double poczatek;
    private double koniec;
    private double liczbaPodzialow;
    private int i;
    private Function<Double, Double> f;

    public M_Prostokatow(double poczatek, double koniec, double liczbaPodzialow, int i, Function<Double, Double> f) {
        this.poczatek = poczatek;
        this.koniec = koniec;
        this.liczbaPodzialow = liczbaPodzialow;
        this.i = i;
        this.f = f;
    }

    @Override
    public void run() {
        double dx = (koniec - poczatek) / liczbaPodzialow;
        double xi = dx * (i + 1);
        double y = f.apply(xi);
        wynik = y * dx;
    }

    public double getWynik() {
        return wynik;
    }
}