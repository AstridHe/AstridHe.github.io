import java.util.NoSuchElementException;
import java.util.Scanner;

public class Game {
    /**
     * Metod som Välkomnar spelaren
     * @param player Player, spelaren
     */
    public static void startGame(Player player) {
        if(player!=null)
        System.out.println("Välkommen " + player.getName());
        else{
            System.out.println("Ditt navändarnamn kunde inte hittas, vänligen registrera dig:");
            player=Start.newUser();
        System.out.println("Välkommen " + player.getName());}


    }

    /**
     * Metod som bestämmer vinnare
     * @param player Player
     * @param computer Deck
     */
       public static void winner(Player player, Deck computer) {
           if (player.hand.getAntal() == 0 && computer.getAntal() == 0)
               System.out.println("Ni kom lika!");
           else if (player.hand.getAntal() == 0) {
               System.out.println("Grattis, du vann!");
           } else if(computer.getAntal()==0){
               System.out.println("Vinst till datorn!");
           }
           else
               System.out.println("Oavgjort, spelet går inte ut!");
       }

    /**
     * Metod som sköter spelarens handlingar
     * @param d Deck, spelarens hand
     * @param topCard Card, översta kortet
     * @param kortlek Deck kortleken
     * @return Card
     */
    static Card playersMove(Deck d, Card topCard, Deck kortlek) throws NoSuchElementException {
        for (int i = 0; i < 3; i++) {
            Scanner sc = new Scanner(System.in);
            String input=null;
            try{input = sc.nextLine();}
            catch( NoSuchElementException e){ System.exit(0);}
            try {
                int in = Integer.parseInt(input);
                if (in <= d.getAntal() && in > 0) {
                    Card fromPlayer = d.getDeck()[in - 1];
                    if (fromPlayer.colour != topCard.colour && fromPlayer.value != topCard.value) {
                        System.out.println("Du fuskar! Prova med ett annat kort, eller ta upp kort från högen!");
                    } else {
                        for (i = in - 1; i < d.getAntal(); i++)
                            d.getDeck()[i] = d.getDeck()[i + 1];
                        d.minusAntal();
                        return fromPlayer;
                    }
                } else
                    System.out.println("Ogiltig siffra, försök igen!");
            } catch (IllegalArgumentException e) {
                if (input.equalsIgnoreCase("Ta upp")) {
                    if (kortlek.getAntal()>0){
                    d.getDeck()[d.getAntal()] = kortlek.pickCard();
                    d.plusAntal();
                    Deck.print(d);
                    System.out.println();}
                    else {
                        i=3;
                        System.out.println("Kortleken är slut.");
                    }
                } else
                    System.out.println("Ogiltig input!");

            }
        }
        return topCard;
    }

    /**
     * Metod som sköter datorns drag
     * @param computer Deck, datorns hand
     * @param topCard Card, översta kortet
     * @param kortlek Deck
     * @return Card
     * @throws NullPointerException
     */
    static Card computerMove(Deck computer, Card topCard, Deck kortlek) throws NullPointerException {

        for (int i = 0; i < computer.getAntal(); i++) {
            if (computer.getDeck()[i].colour == topCard.colour || computer.getDeck()[i].value == topCard.value) {
                Card fromComputer = computer.getDeck()[i];
                for (int j = i; j < computer.getAntal(); j++) {
                    computer.getDeck()[j] = computer.getDeck()[j + 1];
                }
                computer.minusAntal();
                return fromComputer;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (kortlek.getAntal() > 0) {
                Card kort = kortlek.pickCard();
                    if (kort.colour == topCard.colour || kort.value == topCard.value) {
                        return kort;
                    } else {
                        computer.getDeck()[computer.getAntal()] = kort;
                        computer.plusAntal();
                    }
                }else{
                    i=3;
                    System.out.println("Högen är slut!");
                }

        }return topCard; //Returnerar det senast lagda kortet om inget nytt lagts
    }
}
