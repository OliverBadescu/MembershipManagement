package Users.model;

public class Users {

    private String type;
    private int id;
    private String username;
    private String password;

    public Users(String type,int id,String user, String password) {
        this.type = type;
        this.password = password;
        this.id = id;
        this.username = user;
    }

    public Users(String text){
        String[] tokens =text.split(",");
        this.type = tokens[0];
        this.id = Integer.parseInt(tokens[1]);
        this.username = tokens[2];
        this.password = tokens[3];
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
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String descriere(){

        String text = "";
        text+= "Id: " + this.id + "\n";
        text+= "Username: " + this.username + "\n";
        text += "Password: " + this.password + "\n";
        return text;
    }

    @Override

    public String toString(){
        return type +"," + id + "," +username +"," +password;
    }
}
