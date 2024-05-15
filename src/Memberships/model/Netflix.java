package Memberships.model;

public class Netflix extends Membership{

    private String pachet;


    public Netflix(String type, int id, String name, double price, String description, String pachet) {
        super(type, id, name, price, description);
        this.pachet = pachet;
    }

    public Netflix(String text) {
        super(text);
        String[] tokens = text.split(",");
        this.pachet = tokens[5];
    }

    public String getPachet() {
        return pachet;
    }
    public void setPachet(String pachet) {
        this.pachet = pachet;
    }

    @Override
    public String descriere(){
        String text= super.descriere();
        text+="Pachet: " + this.pachet +"\n";
        return text;
    }

    @Override
    public String toString(){

        return super.toString()+"," +  pachet;

    }
}
