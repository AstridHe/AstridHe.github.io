import java.io.Serializable;

public class Deck implements Serializable {

    private Card[] deck = new Card[52];
    private int antal;

    public Card[] getDeck() {
        return deck;
    }

    public int getAntal() {
        return antal;
    }

    public void plusAntal() {
        antal++;
    }

    public void minusAntal() {
        antal--;
    }

    /**
     * Metod som skapar en kortlek
     * @return Deck
     */
    public Deck createFullDeck() {
        Deck d = new Deck();
        for (int colour = 0, i = 0; colour <= 3; colour++) {
            for (int value = 2; value <= 14; value++, i++) {
                d.deck[i] = new Card();
                d.deck[i].colour=colour;
                d.deck[i].value=value;
                d.antal++;
            }
        }
        return d;
    }

    /**
     * Metod som blandar kort
     */
    public void shuffle() {
        for (int shuffle = 0; shuffle < (antal); shuffle++) {

            int i = (int) (1 + Math.random() * (antal - 1));
            int j = (int) (1 + Math.random() * (antal - 1));
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    /**
     * Metod som tar upp ett kort från en kortlek
     * @return Card
     */
    public Card pickCard() {
        Card card;
        card = deck[antal - 1];
        antal--;
        return card;

    }

    /**
     * Metod som delar ut 7 kort från kortlek
     * @param d Deck
     * @return Deck
     * @throws NullPointerException
     */
    public static Deck deal(Deck d) throws NullPointerException {
        Deck a = new Deck();
        for (int i = 0; i < 7; i++) {
            a.deck[i] = d.deck[d.antal - 1];
            d.antal--;
            a.antal++;
        }
        return a;
    }


    /**
     * Metod som skriver ut en samling kort numrerat
     * @param a
     */
    public static void print(Deck a) {

        for (int i = 0; i < a.antal; i++) {
            System.out.print((i + 1) + ". ");
            System.out.print(a.deck[i] + "\t");
        }
    }
}
