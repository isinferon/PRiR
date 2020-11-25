import java.util.ArrayList;
import java.util.function.Function;

class MetodaSimpsona implements CalkowanieNumeryczne {
    public static double oblicz(double poczatek, double koniec, int liczbaPodzialow, Function<Double, Double> f) {
        ArrayList<M_Simpsona> watki = new ArrayList<M_Simpsona>();

        for (int i = 0; i < 2; i++) {
            M_Simpsona watek = new M_Simpsona(poczatek, koniec, liczbaPodzialow, i, M_Simpsona.Rodzaj.Zwykly, f);
            watek.start();
            watki.add(watek);
        }

        for (int i = 1; i <= liczbaPodzialow - 1; i++) {
            M_Simpsona watek = new M_Simpsona(poczatek, koniec, liczbaPodzialow, i, M_Simpsona.Rodzaj.Xi, f);
            watek.start();
            watki.add(watek);
        }

        for (int i = 1; i <= liczbaPodzialow; i++) {
            M_Simpsona watek = new M_Simpsona(poczatek, koniec, liczbaPodzialow, i, M_Simpsona.Rodzaj.Ti, f);
            watek.start();
            watki.add(watek);
        }

        double wynik = 0;
        try {
            for (M_Simpsona watek : watki) {
                watek.join();
                wynik += watek.getWynik();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return wynik;
    }
}