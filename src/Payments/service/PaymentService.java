package Payments.service;

import Payments.model.Payment;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PaymentService {

    private ArrayList<Payment> payments;
    public PaymentService(){
        this.payments = new ArrayList<>();
        this.loadData();
    }

    private void loadData(){
        try{
            String filePath="C:\\mycode\\java\\mostenire\\MembershipManagement\\src\\Payments\\data\\payments.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                Payment payment = new Payment(line);

                this.payments.add(payment);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void saveData(){
        String filePath="C:\\mycode\\java\\mostenire\\MembershipManagement\\src\\Payments\\data\\payments.txt";
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
        for(i=0;i<this.payments.size()-1;i++){
            text+=this.payments.get(i)+"\n";
        }
        return text+=this.payments.get(i);
    }
}
