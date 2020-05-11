import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Start {
    /**
     * Metod som med hjälp av login, newUser, oldUser och findPlayer låter spelaren logga in eller registrera namn.
     * @param lista array med registrerade användare
     * @return användare
     */
    public static Player welcome(Registration lista) {
        Player player = null;
        System.out.println("Välkommen!\nVad vill du göra?");
        System.out.println("1.Spela!\n" +
                "2. Avsluta programmet");
        Scanner scanner = new Scanner(System.in);
        try {
            int nr = scanner.nextInt();
            if (nr == 1)
                player = login(lista);
            else if (nr == 2)
                System.exit(0);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return player;
    }

    /**
     * Hjälpmetod till welcome
     * @param lista
     * @return Player
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws IllegalArgumentException
     */
    private static Player login(Registration lista) throws IOException, ClassNotFoundException, IllegalArgumentException {
        Player player = null;
        System.out.println("För att logga in med användarnamn, tryck 1,\n" +
                "För att registrera nytt, tryck 2");
        Scanner sc = new Scanner(System.in);
       try{ int nr = sc.nextInt();
        if (nr == 1)
            player = oldUser();
        if (nr == 2) {
            player = newUser();
            lista.data[lista.getNumber()]=player;
            lista.setNumber(lista.getNumber()+1);}
       }catch (InputMismatchException e){
           System.out.println("Skriv 1 eller 2!");
       }
        return player;

    }

    /**
     * Hjälpmetod till welcome
     * @return Player
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static Player oldUser() throws IOException, ClassNotFoundException {
        System.out.println("Välkommen! Skriv in ditt användarnamn:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        return findPlayer(s);

    }

    /**
     * Hjälpmetod till welcome
     * @return Player
     */
    static Player newUser() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv in önskat användarnamn:");
        String s = scanner.nextLine().trim();
        return new Player(s);
    }

    /**
     * Hjälpmetod till welcome
     * @param name spelarens namn
     * @return Player
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Player findPlayer(String name) throws IOException, ClassNotFoundException {
        ObjectInputStream objIn = new ObjectInputStream(
                new FileInputStream("register.data"));
        Player player=null;
        while (true) {
            try {
                player = (Player) objIn.readObject();
            } catch (EOFException e) {
                break;
            }
            if (player.getName().equals(name)){
                break;
            }
        }
        objIn.close();
        return player;
    }

}

