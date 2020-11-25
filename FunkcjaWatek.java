
import java.util.function.Function;

class FunkcjaWatek extends Thread
{
    private double wynik;
    private double x;
    private Function<Double, Double> f;

    public FunkcjaWatek(double x, Function<Double, Double> f)
    {
        this.x = x;
        this.f = f;
    }
    public void run()
    {
        wynik = f.apply(x);
    }
    public double getWynik()
    {
        return wynik;
    }
}