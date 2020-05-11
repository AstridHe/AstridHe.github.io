import java.io.*;

public class List {

    /**
     * Metod som skriver en array med objekt till en binärfil
     *
     * @param lista Registration
     * @throws IOException
     */
    public static void skriv(Registration lista) throws IOException {

        ObjectOutputStream ut = new ObjectOutputStream(new FileOutputStream("register.data"));
        for (int i = 0; i < lista.getNumber(); i++) {
            ut.writeObject(lista.data[i]);
        }
        ut.close();
    }

    /**
     * Metod som läser in objekt från en binärfil och sparar i en array
     *
     * @param filename String
     * @return Registration
     * @throws IOException
     */
    public static Registration read(String filename) throws IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        Player p = null;
        Registration lista = new Registration();
        int i = 0;
        while (true) {
            try {
                p = (Player) in.readObject();
            } catch (ClassNotFoundException | EOFException e) {
                break;
            }
            if (p != null) {
                //System.out.println(p.toString(p));
                lista.data[i] = new Player(p.getName());
                i++;
                lista.setNumber(i);
            }
        }
        in.close();
        return lista;
    }
}




