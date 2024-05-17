package Users.service;

import Memberships.model.Membership;
import Users.model.Admin;
import Users.model.Member;
import Users.model.Users;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    private ArrayList<Users> users;

    public UserService(){

        this.users = new ArrayList<>();

        this.loadData();


    }


    private void loadData(){

        try{
            String filePath="C:\\mycode\\java\\mostenire\\MembershipManagement\\src\\Users\\data\\users.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                switch (line.split(",")[0]){

                    case "Admin":
                        Admin admin = new Admin(line);
                        this.users.add(admin);
                        break;
                    case "Member":
                        Member member = new Member(line);
                        this.users.add(member);
                        break;
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void saveData(){
        String filePath="C:\\mycode\\java\\mostenire\\MembershipManagement\\src\\Users\\data\\users.txt";
        try{
            FileWriter fileWriter = new FileWriter(filePath);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(this);
            printWriter.close();
        }catch (Exception e){

            System.out.println(e);
        }

    }

    @Override
    public String toString() {
        String text="";
        int i=0;
        for(i=0;i<this.users.size()-1;i++){
            text+=this.users.get(i)+"\n";
        }
        text+=this.users.get(i);

        return text;
    }

    public void stergeCont(Member member){

        this.users.remove(member);

    }

    public Member findById(int id){
        for (int i =0; i < users.size();i++){
            if(users.get(i) instanceof Member m){
                if(m.getId() == id){
                    return m;
                }
            }
        }
        return null;
    }

    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    public boolean adaugareAdmin(Admin admin){

        for(int i= 0 ; i < users.size();i++){
            if(users.get(i) instanceof Admin a){
                if(a.getUsername().equals(admin.getUsername())){
                    return false;
                }
            }
        }
        users.add(admin);
        return true;

    }

    public void afisareMembers(){
        for(int i =0; i < users.size();i++){
            if(users.get(i) instanceof Member m){
                System.out.println(m.descriere());
            }
        }
    }

    public Member loginMember(String user, String parola){
        for(int i =0; i < users.size();i++){
            if(users.get(i) instanceof Member m){
                if(m.getUsername().equals(user) && m.getPassword().equals(parola)){
                    return m;
                }
            }
        }
        return null;
    }

    public Admin loginAdmin(String user,String parola){

        for(int i =0; i < users.size();i++){
            if(users.get(i) instanceof Admin a){
                if(a.getUsername().equals(user) && a.getPassword().equals(parola)){
                    return a;
                }
            }
        }
        return null;

    }

    public boolean inregistrareCustomer(Member member){
        for(int i =0 ; i < users.size();i++){
            if(users.get(i) instanceof Member m){
                if(m.getUsername().equals(member.getUsername())){
                    return false;
                }
            }
        }
        users.add(member);
        return true;
    }
}
