import java.util.function.Function;

class M_Trapezow extends Thread {
    private double wynik;
    private double poczatek;
    private double koniec;
    private double liczbaPodzialow;
    private int i;
    private Function<Double, Double> f;

    public M_Trapezow(double poczatek, double koniec, double liczbaPodzialow, int i, Function<Double, Double> f) {
        this.poczatek = poczatek;
        this.koniec = koniec;
        this.liczbaPodzialow = liczbaPodzialow;
        this.i = i;
        this.f = f;
    }

    @Override
    public void run() {
        double dx = (koniec - poczatek) / liczbaPodzialow;
        double xi = poczatek + i * dx;
        double y = f.apply(xi);
        if (i == 0 || i == liczbaPodzialow)
            wynik = y / 2 * dx;
        else
            wynik = y * dx;
    }

    public double getWynik() {
        return wynik;
    }
}