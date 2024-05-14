package Users.model;

public class Admin extends Users{

    private String rol;

    public Admin(int id, String user, String password, String rol) {
        super("Admin", id, user, password);
        this.rol = rol;
    }

    public Admin(String text){
        super(text);
        String[] tokens = text.split(",");
        this.rol = tokens[4];
    }

    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String descriere(){

        String text = super.descriere();
        text+= "Rol: " +this.rol + "\n";
        return text;

    }

    @Override

    public String toString(){
        return super.toString() +"," + rol;
    }
}
