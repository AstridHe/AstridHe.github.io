public class Registration {

 public Player[] data=new Player[20];
 private int number=0;

    /**
     * Bestämmer nummer
     * @param nr
     */
 public void setNumber (int nr) {
     if (nr >= 0)
         number = nr;
     else {
         throw new IllegalArgumentException();
     }
 }

    /**
     * Hämtar nummer
     * @return int
     */
     public int getNumber(){
     return number;
 }

    @Override
    public String toString() {
         String s="";
        for (int i=0; i<number; i++)
            s+="Medlemsnr: "+data[i].getMEMBER_NUMBER()+". "+data[i].getName()+"\n";
        return s;
    }
}

