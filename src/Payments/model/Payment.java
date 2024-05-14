package Payments.model;

public class Payment {

    private int id;
    private int customerId;
    private int amount;
    private String description;

    public Payment(int id, int amount, String description, int customerId) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.customerId = customerId;
    }

    public Payment(String text){
        String[] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[0]);
        this.customerId = Integer.parseInt(tokens[1]);
        this.amount = Integer.parseInt(tokens[2]);
        this.description = tokens[3];
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String description(){

        String text = "";
        text +="Id: " + this.id+"\n";
        text+= "Customer Id: " + this.customerId + "\n";
        text+="Amount: " + this.amount + "\n";
        text+="Description: " + this.description +"\n";
        return text;

    }

    @Override
    public String toString(){
        return id +"," +customerId +"," +amount+"," +description;
    }
}
