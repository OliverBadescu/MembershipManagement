package Memberships.service;

import Memberships.model.*;
import Users.model.Member;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MembershipService {

    private ArrayList<Membership> memberships;

    public MembershipService(){
        this.memberships = new ArrayList<>();
        this.loadData();

    }

    private void loadData() {


        try{
            String filePath="C:\\mycode\\java\\mostenire\\MembershipManagement\\src\\Memberships\\data\\memberships.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                switch (line.split(",")[0]){

                    case "Dentist":
                        Dentist dentist = new Dentist(line);
                        this.memberships.add(dentist);
                        break;
                    case "Gym":
                        Gym gym = new Gym(line);
                        this.memberships.add(gym);
                        break;
                    case "Netflix":
                        Netflix netflix = new Netflix(line);
                        this.memberships.add(netflix);
                        break;
                    case "Retail":
                        Retail retail = new Retail(line);
                        this.memberships.add(retail);
                        break;
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public void saveData(){
        String filePath="C:\\mycode\\java\\mostenire\\MembershipManagement\\src\\Memberships\\data\\memberships.txt";
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
        for(i=0;i<this.memberships.size()-1;i++){
            text+=this.memberships.get(i)+"\n";
        }
        text+=this.memberships.get(i);

        return text;
    }


    public void afisare(){
        for(int i=0; i < memberships.size();i++){
            System.out.println(memberships.get(i).descriere());
        }
    }

    public Membership findByName(String nume){

        for(int i=0; i < memberships.size();i++){
            if(memberships.get(i).getName().equals(nume)){
                return memberships.get(i);
            }
        }
        return null;
    }

    public Membership findById(int id){
        for(int i =0 ; i < memberships.size();i++){
            if(memberships.get(i).getId() == id){
                return memberships.get(i);
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

    public void sortareDupaPretCrescator(){

        boolean sortat = false;

        do {

            sortat = true;

            for (int i = 0; i < memberships.size()-1; i++) {

                if (memberships.get(i).getPrice() < memberships.get(i+1).getPrice()) {
                    Membership temp = memberships.get(i);
                    memberships.set(i, memberships.get(i+1));
                    memberships.set(i+1, temp);
                    sortat = false;
                }

            }

        } while (!sortat);

    }
    public void sortareDupaPretDescrescator(){

        boolean sortat = false;

        do {

            sortat = true;

            for (int i = 0; i < memberships.size()-1; i++) {

                if (memberships.get(i).getPrice() > memberships.get(i+1).getPrice()) {
                    Membership temp = memberships.get(i);
                    memberships.set(i, memberships.get(i+1));
                    memberships.set(i+1, temp);
                    sortat = false;
                }

            }

        } while (!sortat);

    }
    public void afisareDentist(){

        for(int i =0; i < memberships.size();i++){
            if(memberships.get(i) instanceof Dentist d){
                System.out.println(d.descriere());
            }
        }
    }
    public void afisareGym(){
        for(int i =0; i < memberships.size();i++){
            if(memberships.get(i) instanceof Gym g){
                System.out.println(g.descriere());;
            }
        }
    }
    public void afisareNetflix(){
        for(int i =0 ; i < memberships.size();i++){
            if(memberships.get(i) instanceof Netflix n){
                System.out.println(n.descriere());
            }
        }
    }
    public void afisareRetail(){
        for(int i =0 ; i < memberships.size();i++){
            if(memberships.get(i) instanceof Retail r){
                System.out.println(r.descriere());
            }
        }
    }

    public void delete(Membership membership){
        this.memberships.remove(membership);
    }

    public boolean add(Membership membership){

        for(int i =0 ;i< memberships.size();i++){
            if(memberships.get(i).getName().equals(membership.getName())){
                return false;
            }
        }
        this.memberships.add(membership);
        return true;

    }


}
