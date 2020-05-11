import java.io.Serializable;

 class Player implements Serializable{

    private String name;
    Deck hand;
    private final int MEMBER_NUMBER;
    private static int nextNumber=1;
// TODO: 2019-12-09 lägg till antal spel och vinster 

    public Player(String name){
        if(name==null || name.equals("")) //tillagt efter inl.
             this.name= "Guest";
        else
            this.name=name;
       MEMBER_NUMBER=getNextNumber();
    }


    /**
     * Metod som hämtar namn
     * @return String
     */
    public String getName(){
        return name;
    }

    /**
     * Metod som hämtar medlemsnummer
     * @return int
     */
    public int getMEMBER_NUMBER(){
    return MEMBER_NUMBER;
    }

    /**
     * Metod som sätter medlemsnummer
     * @return int
     */
    private static int getNextNumber(){
        int id=nextNumber;
        nextNumber++;
        return id;

    }

}

