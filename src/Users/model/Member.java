package Users.model;

public class Member extends Users{

    private String name;
    private String email;
    private String address;
    private int phone;


    public Member(int id, String user, String password, String name, String email, String address, int phone) {
        super("Member", id, user, password);
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public Member(String text){
        super(text);
        String[] tokens = text.split(",");
        this.name = tokens[4];
        this.email = tokens[5];
        this.address = tokens[6];
        this.phone= Integer.parseInt(tokens[7]);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String descriere(){
        String text = super.descriere();
        text += "Name: "+ this.name + "\n";
        text += "Email: " + this.email + "\n";
        text += "Address: " + this.email+ "\n";
        text += "Phone: "+ this.phone + "\n";
        return text;


    }

    @Override

    public String toString(){
        return super.toString() + "," + name + "," + email +"," + address +"," + phone;
    }
}
