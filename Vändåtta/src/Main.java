import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

// TODO: 2019-12-09 felhantering
// TODO: 2019-12-09 snygga till med färger mm.
// TODO: 2019-12-09 Kör analys
public class Main {
    /**
     * Main-metoden för kortspelet, med huvuduppgift att anropa spelets metoder.
     * @param args används ej
     * @throws IOException
     * @throws NoSuchElementException
     */
    public static void main(String[] args) throws IOException, NoSuchElementException {

        Registration lista = List.read("register.data");
        Player player = Start.welcome(lista);
        System.out.println(lista);
        Game.startGame(player);

        while (true) {
            System.out.println("Du ger genom att skriva in siffran på det kort du vill lägga, \n" +
                    "eller skriver 'ta upp' om du inte kan. Spelarna får ta upp maximalt 3 kort på ett drag,\n " +
                    "sedan går turen över till motståndaren.\n" +
                    "Regler: Den som blir av med sina kort först vinner. Du får lägga valfritt kort i samma färg, " +
                    "eller ett kort av samma valör som det senast utlagda.");
            Deck kort = new Deck();                                 //Skapar och blandar en kortlek
            kort = kort.createFullDeck();
            kort.shuffle();

            player.hand = Deck.deal(kort);                      //Delar ut kort till spelarna
            Deck computer = Deck.deal(kort);

            Card topCard = kort.pickCard();                     //Lägger ut ett första kort
            System.out.println();
            System.out.println("Startkortet är: " + topCard);
            int turer = 0;
            int rep=0;
            while (player.hand.getAntal() > 0 && computer.getAntal() > 0) { //Spelet börjar
                if (rep>4) // om människa + dator inte kunnat lägga på 2 omgångar avslutas spelet - annars oändlig loop
                    break;
                // // TODO: 2020-05-11 GÖr datorn sämre

                System.out.print("Vad lägger du? Dina kort är:");
                Deck.print(player.hand);
                System.out.println();
                Card temp;
                temp = topCard;
                topCard = Game.playersMove(player.hand, topCard, kort);
                if (temp.equals(topCard)) {
                    rep++;
                    System.out.println("Datorns tur igen.");

                } else {
                    System.out.print("Du har lagt: ");
                    System.out.println(topCard);
                    turer++;
                    rep=0;
                }
                //Datorns tur
                temp = topCard;
                topCard = Game.computerMove(computer, topCard, kort);
                if (temp.equals(topCard)) {
                    System.out.println("Datorn kan inte lägga!");
                    rep++;
                }
                System.out.println("Senast lagt: ");
                System.out.println(topCard);
                if (temp != topCard) {
                    turer++;
                    rep = 0;
                }
            }
            Game.winner(player, computer);

            System.out.println("Skriv 1 för att spela igen, 2 för att avsluta");
            Scanner scanner = new Scanner(System.in);
            int i;
            try {
                i = scanner.nextInt();
                if (i != 1) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                break;
            }

        }

        List.skriv(lista);
        //Registration t = List.read("register.data");
        //for (Player p:t.data) {
        //System.out.println("Medlemsnr: "+p.getMEMBER_NUMBER()+". "+p.getName());}
    }
}
