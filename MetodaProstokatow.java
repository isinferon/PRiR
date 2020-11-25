import java.util.function.Function;

class MetodaProstokatow implements CalkowanieNumeryczne {
    public static double oblicz(double poczatek, double koniec, int liczbaPodzialow, Function<Double, Double> f) {
        M_Prostokatow[] watki = new M_Prostokatow[liczbaPodzialow];
        for (int i = 0; i < liczbaPodzialow; i++) {
            watki[i] = new M_Prostokatow(poczatek, koniec, liczbaPodzialow, i, f);
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