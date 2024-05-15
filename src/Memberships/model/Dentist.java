package Memberships.model;

import Users.model.Member;

public class Dentist extends Membership {

    private int nrAppointmentsPerMonth;

    public Dentist(String type, int id, String name, double price, String description, int nrAppointmentsPerMonth) {
        super(type, id, name, price, description);
        this.nrAppointmentsPerMonth = nrAppointmentsPerMonth;
    }

    public Dentist(String text) {
        super(text);
        String[] tokens = text.split(",");
        this.nrAppointmentsPerMonth = Integer.parseInt(tokens[5]);
    }

    public int getNrAppointmentsPerMonth() {
        return nrAppointmentsPerMonth;
    }
    public void setNrAppointmentsPerMonth(int nrAppointmentsPerMonth) {
        this.nrAppointmentsPerMonth = nrAppointmentsPerMonth;
    }

    @Override

    public String descriere() {
        String text = super.descriere();
        text += "Nr appointments per month: " + this.nrAppointmentsPerMonth + "\n";
        return text;
    }

    @Override

    public String toString(){
        return super.toString() + "," + nrAppointmentsPerMonth;
    }
}
