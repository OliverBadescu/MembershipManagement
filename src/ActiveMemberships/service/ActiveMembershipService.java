package ActiveMemberships.service;

import ActiveMemberships.model.ActiveMemberships;
import Memberships.model.Membership;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ActiveMembershipService {

    private ArrayList<ActiveMemberships> list;

    public ActiveMembershipService(){
        this.list = new ArrayList<>();

        this.loadData();
    }

    private void loadData() {
        try{
            String filePath="C:\\mycode\\java\\mostenire\\MembershipManagement\\src\\ActiveMemberships\\data\\activememberships.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                ActiveMemberships activeMemberships = new ActiveMemberships(line);

                this.list.add(activeMemberships);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {

        String text="";
        int i=0;
        for(i=0;i<this.list.size()-1;i++){
            text+=this.list.get(i)+"\n";
        }
        return text+=this.list.get(i);
    }

    public void saveData(){
        String filePath="C:\\mycode\\java\\mostenire\\MembershipManagement\\src\\ActiveMemberships\\data\\activememberships.txt";
        try{
            FileWriter fileWriter = new FileWriter(filePath);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(this);
            printWriter.close();
        }catch (Exception e){

            System.out.println(e);
        }

    }

    public void afisare(){
        for(int i =0 ; i < list.size();i++){
            System.out.println(list.get(i).descriere());
        }
    }


    public boolean hasActiveMembership(int customerId, int membershipId){

        for(int i =0; i < list.size(); i++){
            if(list.get(i).getMembershipId() == membershipId && list.get(i).getCustomerId() == customerId){
                return false;
            }
        }
        return true;

    }

    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    public ActiveMemberships findById(int id){
        for (int i =0; i < list.size();i++){
            if(list.get(i).getId() == id){
                return list.get(i);
            }
        }
        return null;
    }

    public void addMembership(Membership membership, int customerId){
        ActiveMemberships activeMemberships = new ActiveMemberships(generateId(), membership.getId(), customerId);
        this.list.add(activeMemberships);
    }

    public ArrayList<Integer> afisareMembershipActive(int customerId){

        ArrayList<Integer> memberships = new ArrayList<>();

        for(int i =0 ; i < list.size();i++){
            if(list.get(i).getCustomerId() == customerId){
                memberships.add(list.get(i).getMembershipId());
            }
        }
        return memberships;
    }

    public boolean anulareMembership(int membershipId, int customerId){

        for(int i =0 ; i < list.size();i++){
            if(list.get(i).getMembershipId() == membershipId && list.get(i).getCustomerId() == customerId){
                list.remove(list.get(i));
                return true;
            }
        }
        return false;
    }

    public int celMaiPopularMembership(){
        int[] frec = new int[100];

        for(int i =0; i < list.size(); i++){
            frec[list.get(i).getMembershipId()]++;
        }

        int max =0;
        int m = 0;
        for(int i = 0; i < frec.length; i++){
            if(frec[i] > max){
                max = frec[i];
                m = i;
            }
        }
        return m;
    }

    public void delete(ActiveMemberships activeMemberships){
        this.list.remove(activeMemberships);
    }
}
