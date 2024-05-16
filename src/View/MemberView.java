package View;

import ActiveMemberships.model.ActiveMemberships;
import ActiveMemberships.service.ActiveMembershipService;
import Memberships.model.Membership;
import Memberships.service.MembershipService;
import Payments.service.PaymentService;
import Users.model.Member;
import Users.service.UserService;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberView {

    private Member member;
    private MembershipService membershipService;
    private ActiveMembershipService activeMembershipService;
    private PaymentService paymentService;
    private UserService userService;
    private Scanner scanner;

    public MemberView(Member member){

        this.member = member;
        this.membershipService = new MembershipService();
        this.activeMembershipService = new ActiveMembershipService();
        this.paymentService = new PaymentService();
        this.userService = new UserService();
        this.scanner = new Scanner(System.in);

        this.play();

    }

    private void meniu(){

        System.out.println("Memberships");
        System.out.println("1. Afisati membership-urile");
        System.out.println("2. Cumparati un membership");
        System.out.println("3. Afisati membership-ruile active");
        System.out.println("4. Anulati un membership");

        System.out.println("\n");

        System.out.println("Sortare: ");
        System.out.println("5. Pret crescator");
        System.out.println("6. Pret descrescator");

        System.out.println("\n");

        System.out.println("Filtrare: ");
        System.out.println("7. Afisati gym memberships");
        System.out.println("8. Afisati dentist memberships");
        System.out.println("9. Afisati netflix memberships");
        System.out.println("10. Afisati retail memberships");

        System.out.println("\n");

        System.out.println("Cont: ");
        System.out.println("11. Afisati datele dvs.");
        System.out.println("12. Editati datele dvs.");
        System.out.println("13. Stergeti contul dvs.");

        System.out.println("\n");
        System.out.println("14.Cel mai popular membership");

        System.out.println("\n");
        System.out.println("Apasati tasta 20 pentru a iesi din cont");

    }

    private void play(){

        boolean running = true;

        while(running ) {
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere){
                case 1:
                    membershipService.afisare();
                    break;
                case 2:
                    cumparaMembership();
                    break;
                case 3:
                    afisareMembershipsActive();
                    break;
                case 4:
                    anulareMembership();
                    break;
                case 5:
                    membershipService.sortareDupaPretCrescator();
                    break;
                case 6:
                    membershipService.sortareDupaPretDescrescator();
                    break;
                case 7:
                    membershipService.afisareGym();
                    break;
                case 8:
                    membershipService.afisareDentist();
                    break;
                case 9:
                    membershipService.afisareNetflix();
                    break;
                case 10:
                    membershipService.afisareRetail();
                    break;
                case 11:
                    this.member.descriere();
                    break;
                case 12:
                    editareDate();
                    break;
                case 13:
                    stergereCont();
                    break;
                case 14:
                    celMaiPopular();
                    break;
                case 20:
                    running = false;
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }

    }

    private void cumparaMembership(){


        System.out.println("Introduceti numele membershipului: ");
        String nume = scanner.nextLine();

        Membership membership = membershipService.findByName(nume);

        if(membership!= null){
            if(activeMembershipService.hasActiveMembership(this.member.getId(), membership.getId())){
                activeMembershipService.addMembership(membership, this.member.getId());
                System.out.println("Membershipul a fost activat!");
            }else{
                System.out.println("Membership este deja activat");
            }
        }else{
            System.out.println("Membershipul nu a fost gasit");
        }

        activeMembershipService.saveData();

    }

    private void afisareMembershipsActive(){

        ArrayList<Integer> lista = activeMembershipService.afisareMembershipActive(this.member.getId());

        if(lista!=null) {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(membershipService.findById(lista.get(i)).descriere());
            }
        }else{
            System.out.println("Nu aveti niciun membership activ");
        }

    }

    private void anulareMembership(){

        System.out.println("Introduceti numele membershipului: ");
        String nume = scanner.nextLine();

        Membership membership = membershipService.findByName(nume);

        if(membership!=null){

            if(activeMembershipService.anulareMembership(membership.getId(), this.member.getId())){
                System.out.println("Membershipul a fost anulat");
            }else{
                System.out.println("Nu sunteti abonat la acest membership");
            }

        }else{
            System.out.println("Membershipul nu a fost gasit");
        }

        activeMembershipService.saveData();
    }

    public void editareDate(){

        System.out.println("Ce doriti sa editati? ");
        System.out.println("1. Email");
        System.out.println("2. Password");
        System.out.println("3. Full name");
        System.out.println("4. Billing adress");
        System.out.println("5. Phone");

        int alegere = Integer.parseInt(scanner.nextLine());

        switch (alegere){
            case 1:
                System.out.println("Introduceti noul email: ");
                String email = scanner.nextLine();
                this.member.setEmail(email);
                break;
            case 2:
                System.out.println("Introduceti noul password: ");
                String password = scanner.nextLine();
                this.member.setPassword(password);
                break;
            case 3:
                System.out.println("Introduceti noul full name: ");
                String fullName = scanner.nextLine();
                this.member.setName(fullName);
                break;
            case 4:
                System.out.println("Introduceti noul billing adress: ");
                String billingAdress = scanner.nextLine();
                this.member.setAddress(billingAdress);
                break;
            case 5:
                System.out.println("Introduceti noul phone: ");
                int phone = Integer.parseInt(scanner.nextLine());
                this.member.setPhone(phone);
                break;
            default:
                System.out.println("Tasta incorecta");
        }


    }

    public void stergereCont(){

        System.out.println("Sunteti siguri ca doriti sa va stergeti contul?(y/n)");
        String alegere = scanner.nextLine();

        if(alegere.equals("y")){
            userService.stergeCont(this.member);
            userService.saveData();
        }


    }

    public void celMaiPopular(){
        Membership membership = membershipService.findById(activeMembershipService.celMaiPopularMembership());

        System.out.println(membership.descriere());
    }
}
