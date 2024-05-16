package Memberships.model;

import Memberships.service.MembershipService;
import Users.model.Member;

public class Gym extends Membership {

    private int nrSaliAccess;

    public Gym( int id, String name, double price, String description, int nrSaliAccess) {
        super("Gym", id, name, price, description);
        this.nrSaliAccess = nrSaliAccess;
    }

    public Gym(String text) {
        super(text);
        String[] tokens = text.split(",");
        this.nrSaliAccess = Integer.parseInt(tokens[5]);

    }

    public int getNrSaliAccess() {
        return nrSaliAccess;
    }
    public void setNrSaliAccess(int nrSaliAccess) {
        this.nrSaliAccess = nrSaliAccess;
    }

    @Override
    public String descriere(){
        String text = super.descriere();
        text+= "Nr sali access: " + this.nrSaliAccess + "\n";
        return text;
    }

    @Override
    public String toString(){
        return super.toString() +"," + nrSaliAccess;
    }
}
