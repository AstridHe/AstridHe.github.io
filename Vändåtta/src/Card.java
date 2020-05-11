import java.io.Serializable;

public class Card implements Serializable {
     int colour;
     int value;

    private static final String[] NAMN = {"Klöver", "Ruter", "Hjärter", "Spader"};
    private static final String[] NR = {"två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess"};

    /**
     * En toString-metod som skriver ut Card på ett lämpligt sätt
     * @return utskrift
     */
    @Override
    public String toString() {
          return NAMN[colour] + " " + NR[value - 2];
    }

}
