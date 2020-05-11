import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class MedlemmarBas {

    public static void main(String[] args) throws IOException {
        skriv();
    }
        public static void skriv() throws IOException {
            Player p0 = new Player("Astrid");
            Player p1 = new Player("Batman");
            Player p2 = new Player("Johan");
            Player p3 = new Player("Iris");
            ObjectOutputStream ut = new ObjectOutputStream(new FileOutputStream("register.data"));
            ut.writeObject(p0);
            ut.writeObject(p1);
            ut.writeObject(p2);
            ut.writeObject(p3);
            ut.close();
        }

    }
