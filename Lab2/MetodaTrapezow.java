import java.util.function.Function;

class MetodaTrapezow implements CalkowanieNumeryczne {
    public static double oblicz(double poczatek, double koniec, int liczbaPodzialow, Function<Double, Double> f) {
        M_Trapezow[] watki = new M_Trapezow[liczbaPodzialow + 1];
        for (int i = 0; i < watki.length; i++) {
            watki[i] = new M_Trapezow(poczatek, koniec, liczbaPodzialow, i, f);
            watki[i].start();
        }

        double wynik = 0;
        for (int i = 0; i < watki.length; i++) {
            try {
                watki[i].join();
                wynik += watki[i].getWynik();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        return wynik;
    }
}