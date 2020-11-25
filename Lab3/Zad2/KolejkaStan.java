import java.util.Random;

interface Stan {
    public Stan cosRobi();
}

class KolejkaStan implements Stan {
    private Mlynowicz mlynowicz;

    public KolejkaStan(Mlynowicz mlynowicz) {
        this.mlynowicz = mlynowicz;
    }

    @Override
    public Stan cosRobi() {
        if (!mlynowicz.maPieniadzeNaBilet()) {
            System.out.println("Mlynowicz " + this.mlynowicz + " musi miec trochę wiecej pieniędzy. Czas isc do bankomatu.");
            return new IdzieDoBankomatuStan(this.mlynowicz);
        }
        if (udaloSieWepchac() && mlynowicz.znalazlMiejsce()) {
            mlynowicz.kupujeBilet();
            return new JedzieStan(this.mlynowicz);
        } else {
            System.out.println("Mlynowicz " + this.mlynowicz + " walczy o miejsce w kolejce");
            return this;
        }
    }

    private boolean udaloSieWepchac() {
        Random random = new Random();
        return random.nextBoolean();
    }

    class JedzieStan implements Stan {
        private Mlynowicz mlynowicz;
        private int iloscOkrazen;

        public JedzieStan(Mlynowicz mlynowicz) {
            this.mlynowicz = mlynowicz;
            Random random = new Random();
            this.iloscOkrazen = random.nextInt(5) + 1;
        }

        @Override
        public Stan cosRobi() {
            if (iloscOkrazen == 0) {
                this.mlynowicz.wysiada();
                System.out.println("Koniec jazdy dla Mlynowicza " + this.mlynowicz);
                return new KolejkaStan(this.mlynowicz);
            } else {
                this.iloscOkrazen--;
                System.out.println("Mlynowicz " + this.mlynowicz + " mówi, że świetnie się bawi.");
                return this;
            }
        }
    }

    class IdzieDoBankomatuStan implements Stan {
        private Mlynowicz mlynowicz;

        public IdzieDoBankomatuStan(Mlynowicz mlynowicz) {
            this.mlynowicz = mlynowicz;
        }

        @Override
        public Stan cosRobi() {
            System.out.println("Mlynowicz " + this.mlynowicz + " biegnie szybko po wiecej pieniedzy.");
            return new WyplacaPieniadzeStan(this.mlynowicz);
        }
    }

    class WyplacaPieniadzeStan implements Stan {
        private Mlynowicz mlynowicz;

        public WyplacaPieniadzeStan(Mlynowicz mlynowicz) {
            this.mlynowicz = mlynowicz;
        }

        @Override
        public Stan cosRobi() {
            Random random = new Random();
            int wyplaconePieniadze = random.nextInt(300) + 50;
            this.mlynowicz.dodajPieniadze(wyplaconePieniadze);
            System.out.println("Mlynowicz " + this.mlynowicz + " wyplacił dużo pieniedzy. Przybyło mu "
                    + wyplaconePieniadze + "zł.");
            return new KolejkaStan(this.mlynowicz);
        }
    }
}
