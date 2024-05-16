package Users.service;

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
}
