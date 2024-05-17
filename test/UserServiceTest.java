import Users.model.Admin;
import Users.model.Member;
import Users.service.UserService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UserServiceTest {

    private UserService userService;

    @Test

    public void voids(){

        userService = new UserService();

        userService.saveData();
        userService.afisareMembers();
        int id = userService.generateId();
        userService.stergeCont(userService.findById(1));



    }

    @Test

    public void GivenAvailableMemberIdCheckIfGetsFound(){

        userService = new UserService();

        Member m = userService.findById(1);
        Member n = userService.findById(3);

        assertEquals(3, n.getId());
        assertNull(m);
    }


    @Test

    public void GivenAvailableCustomerDataCheckIfGetsLogedIn(){

        userService= new UserService();

        Member none = userService.loginMember("asff", "1231");
        Member member = userService.loginMember("john","pass");

        assertEquals(4, member.getId());
        assertNull(none);

    }

    @Test

    public void GivenAvailableAdminDataCheckIfGetsLogedIn(){

        userService= new UserService();

        Admin none = userService.loginAdmin("asff", "1231");
        Admin admin = userService.loginAdmin("admin","123");

        assertEquals(1, admin.getId());
        assertNull(none);

    }

    @Test

    public void GivenAvailableCustomerCheckIfGetsRegistred(){

        userService = new UserService();
        Member m1 = new Member(6, "test", "test", "name", "email","address", 2333);
        Member m2 = new Member(7, "ahmed", "test", "name", "email","address", 2333);


        userService.inregistrareCustomer(m1);
        userService.inregistrareCustomer(m2);


        assertNull(userService.findById(6));
        assertEquals(m2, userService.findById(7));

    }

    @Test

    public void GivenAvailableAdminCheckIfGetsRegistred(){

        userService = new UserService();
        Admin n1 = new Admin(2, "test", "123", "t");
        Admin n2= new Admin(3, "admin", "123", "t");

        userService.adaugareAdmin(n1);
        userService.adaugareAdmin(n2);



    }
}
