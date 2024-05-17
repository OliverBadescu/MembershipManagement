package ActiveMemberships.model;

public class ActiveMemberships {

    private int id;
    private int membershipId;
    private int customerId;

    public ActiveMemberships(int id, int membershipId, int customerId) {
        this.id = id;
        this.membershipId = membershipId;
        this.customerId = customerId;
    }

    public ActiveMemberships(String text){
        String[] tokens = text.split(",");

        this.id = Integer.parseInt(tokens[0]);
        this.membershipId = Integer.parseInt(tokens[1]);
        this.customerId = Integer.parseInt(tokens[2]);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getMembershipId() {
        return membershipId;
    }
    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String descriere(){

        String text = "";

        text+= "Id: " + this.id + "\n";
        text+="Membership id: "  + this.membershipId + "\n";
        text += "Customer id: "+ this.customerId + "\n";
        return text;

    }

    @Override

    public String toString(){
        return id + "," + membershipId +"," + customerId;
    }
}
