import Users.model.Member;
import View.MemberView;

public class Main {
    public static void main(String[] args) {

        Member member = new Member(1,"test","test","","","",1);

        MemberView memberView = new MemberView(member);

    }
}