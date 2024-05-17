package View;

import ActiveMemberships.model.ActiveMemberships;
import ActiveMemberships.service.ActiveMembershipService;
import Memberships.model.*;
import Memberships.service.MembershipService;
import Payments.service.PaymentService;
import Users.model.Admin;
import Users.model.Member;
import Users.service.UserService;

import java.util.Scanner;

public class AdminView {

    private Admin admin;
    private ActiveMembershipService activeMembershipService;
    private MembershipService membershipService;
    private PaymentService paymentService;
    private UserService userService;
    private Scanner scanner;

    public AdminView(Admin admin){

        this.admin = admin;
        this.activeMembershipService = new ActiveMembershipService();
        this.membershipService = new MembershipService();
        this.paymentService = new PaymentService();
        this.userService = new UserService();
        this.scanner = new Scanner(System.in);

        this.play();

    }


    private void meniu(){

        System.out.println("Memberships:" );
        System.out.println("1. Afiseaza membership-urile");
        System.out.println("2. Sterge");
        System.out.println("3. Adauga");
        System.out.println("4. Editeaza");

        System.out.println("\n");

        System.out.println("Members: ");
        System.out.println("5. Afiseaza membrii");
        System.out.println("6. Sterge un membru");

        System.out.println("\n");

        System.out.println("Active memberships: ");
        System.out.println("7. Afiseaza active memberships");
        System.out.println("8. Sterge un membership activ");

        System.out.println("\n");

        System.out.println("Admini: ");
        System.out.println("9. Adauga un admin");

        System.out.println("\n");
        System.out.println("10. Iesi din cont");

    }

    private void play() {

        boolean running = true;

        while (running) {
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1:
                    membershipService.afisare();
                    break;
                case 2:
                    stergeMembership();
                    break;
                case 3:
                    adaugaMembership();
                    break;
                case 4:
                    editeazaMembership();
                    break;
                case 5:
                    userService.afisareMembers();
                    break;
                case 6:
                    stergeMemberu();
                    break;
                case 7:
                    activeMembershipService.afisare();
                    break;
                case 8:
                    stergeMembershipActiv();
                    break;
                case 9:
                    adaugareAdmin();
                    break;
                case 10:
                    running = false;
                    break;

            }

        }

    }
    private void stergeMembership(){
        System.out.println("Introduceti id-ul: ");
        int id = Integer.parseInt(scanner.nextLine());

        Membership membership = membershipService.findById(id);

        if(membership!= null){
            membershipService.delete(membership);
            membershipService.saveData();

            System.out.println("Membership-ul a fost sters!");
        }
        else{
            System.out.println("Nu a fost gasit");
        }
    }

    private void adaugaMembership(){

        System.out.println("Ce tip de membership este?");
        String type = scanner.nextLine();
        System.out.println("Introduceti numele: ");
        String nume = scanner.nextLine();
        System.out.println("Introduceti pretul: ");
        double pret =Double.parseDouble(scanner.nextLine());
        System.out.println("Introduceti descrierea: ");
        String d = scanner.nextLine();

        switch (type){
            case "Dentist":
                System.out.println("Introduceti numarul de vizite pe luna");
                int nr = Integer.parseInt(scanner.nextLine());
                Dentist membership = new Dentist(membershipService.generateId(), nume, pret, d, nr);
                if(membershipService.add(membership)){
                    System.out.println("A fost adaugat!");
                }
                else{
                    System.out.println("Exista deja cu acest nume");
                }
                break;
            case "Gym":
                System.out.println("Introduceti nr de sali la care aveti acces:");
                int nrS = Integer.parseInt(scanner.nextLine());
                Gym gym = new Gym(membershipService.generateId(), nume,pret,d,nrS);
                if(membershipService.add(gym)){
                    System.out.println("A fost adaugat!");
                }
                else{
                    System.out.println("Exista deja cu acest nume");
                }
                break;
            case "Netflix":
                System.out.println("Introduceti pachetul: ");
                String pack = scanner.nextLine();
                Netflix netflix = new Netflix(membershipService.generateId(), nume,pret,d,pack);
                if(membershipService.add(netflix)){
                    System.out.println("A fost adaugat!");
                }
                else{
                    System.out.println("Exista deja cu acest nume");
                }
                break;
            case "Retail":
                System.out.println("Introduceti reducerea: ");
                int proc = Integer.parseInt(scanner.nextLine());
                Retail retail = new Retail(membershipService.generateId(), nume, pret ,d, proc);
                if(membershipService.add(retail)){
                    System.out.println("A fost adaugat!");
                }
                else{
                    System.out.println("Exista deja cu acest nume");
                }
                break;
        }
        membershipService.saveData();

    }

    private void editeazaMembership(){
        System.out.println("Introduceti id-ul membership-ului care doriti sa il editati ");
        int id = Integer.parseInt(scanner.nextLine());

        Membership membership = membershipService.findById(id);

        if(membership!= null){

            System.out.println("Ce doriti sa editati? ");
            System.out.println("1. Nume");
            System.out.println("2. Pret");

            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere){
                case 1:
                    System.out.println("Introduceti noul nume: ");
                    String nume = scanner.nextLine();
                    membership.setName(nume);
                    break;
                case 2:
                    System.out.println("Introduceti noul pret: ");
                    double pret = Double.parseDouble(scanner.nextLine());
                    membership.setPrice(pret);
                    break;
            }

        }else{
            System.out.println("Nu a fost gasit");
        }
    }

    private void stergeMemberu(){

        System.out.println("Introduceti id-ul membrului: ");
        int id = Integer.parseInt(scanner.nextLine());

        Member member = userService.findById(id);

        if(member!= null){
            userService.stergeCont(member);
            userService.saveData();
            System.out.println("Membrul a fost sters");
        }else{
            System.out.println("Membrul nu a fost gasit");
        }
    }

    private void adaugareAdmin(){

        System.out.println("Introduceti user-ul: ");
        String username = scanner.nextLine();
        System.out.println("Introduceti password: ");
        String password = scanner.nextLine();
        System.out.println("Introduceti gradul(Moderator/Viewer): ");
        String grad = scanner.nextLine();

        Admin admin = new Admin(userService.generateId(), username, password, grad);

        if(userService.adaugareAdmin(admin)){
            System.out.println("Adminul a fost adaugat!");
        }else{
            System.out.println("Usernamul este deja folosit");
        }
        userService.saveData();
    }

    private void stergeMembershipActiv(){

        System.out.println("Introduceti id-ul: ");
        int id = Integer.parseInt(scanner.nextLine());

        ActiveMemberships activeMemberships = activeMembershipService.findById(id);

        if(activeMemberships!= null){
            activeMembershipService.delete(activeMemberships);
            activeMembershipService.saveData();
            System.out.println("A fost sters!");
        }else{
            System.out.println("Nu a fost gasit");
        }

    }
}
