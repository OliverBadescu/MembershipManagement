package Memberships.model;

import Users.model.Member;

public class Membership {

    private String type;
    private int id;
    private String name;
    private double price;
    private String description;

    public Membership(String type, int id, String name,double price, String description ) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Membership(String text){
        String[] tokens = text.split(",");
        this.type = tokens[0];
        this.id = Integer.parseInt(tokens[1]);
        this.name = tokens[2];
        this.price = Double.parseDouble(tokens[3]);
        this.description = tokens[4];
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String descriere(){

        String text = "";
        text+= "Id: " + this.id + "\n";
        text+="Name: " + this.name + "\n";
        text+="Price: " + this.price + "/month" + "\n";
        text+="Description: " + this.description +"\n";
        return text;

    }

    @Override
    public String toString(){
        return type + "," + id +"," +name +"," + price +"," +description;
    }
}
