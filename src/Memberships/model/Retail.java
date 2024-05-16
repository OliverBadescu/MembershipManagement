package Memberships.model;

public class Retail extends Membership{

    private int reducere;

    public Retail( int id, String name, double price, String description, int reducere) {
        super("Retail", id, name, price, description);
        this.reducere = reducere;
    }

    public Retail(String text) {
        super(text);
        String[] tokens = text.split(",");
        reducere = Integer.parseInt(tokens[5]);

    }

    public int getReducere() {
        return reducere;
    }
    public void setReducere(int reducere) {
        this.reducere = reducere;
    }

    @Override
    public String descriere(){

        String text = super.descriere();
        text+= "Reducere: " + this.reducere + "%" + "\n";
        return text;
    }

    @Override
    public String toString(){
        return super.toString() +"," + reducere;
    }
}
