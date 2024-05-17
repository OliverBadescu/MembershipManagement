import ActiveMemberships.model.ActiveMemberships;
import ActiveMemberships.service.ActiveMembershipService;
import Memberships.model.Membership;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ActiveMembershipsTest {

    private ActiveMembershipService activeMembershipService;

    @Test

    public void voids(){

        activeMembershipService = new ActiveMembershipService();
        Membership membership = new Membership("",1,"",22,"");
        activeMembershipService.saveData();
        activeMembershipService.afisare();
        activeMembershipService.addMembership(membership,1);
        int id = activeMembershipService.generateId();
        ArrayList<Integer> list = activeMembershipService.afisareMembershipActive(1);
        int d = activeMembershipService.celMaiPopularMembership();

    }

    @Test

    public void GivenAvailableCustomerIdAndMembershipIdCheckIfHasActiveMembership(){

        activeMembershipService = new ActiveMembershipService();

        boolean t = activeMembershipService.hasActiveMembership(1,1);
        boolean f = activeMembershipService.hasActiveMembership(5,6);


        assertEquals(true, t);
        assertEquals(false, f);

    }

    @Test

    public void GivenAvailableCustomerIdCheckIfGetsFound(){

        activeMembershipService = new ActiveMembershipService();

        ActiveMemberships activeMemberships = activeMembershipService.findById(1);
        ActiveMemberships activeMemberships1 = activeMembershipService.findById(2);


        assertEquals(1, activeMemberships.getId());
        assertEquals(null, activeMemberships1);

    }

    @Test

    public void GivenAvailableActiveMembershipCheckIfGetsCanceled(){

        activeMembershipService = new ActiveMembershipService();

        boolean t = activeMembershipService.anulareMembership(1,1);
        boolean f = activeMembershipService.anulareMembership(24,3);

        assertEquals(true, t);
        assertEquals(false, f);

    }

    @Test

    public void GivenAvailableActiveMembershipCheckIfGetsDeleted(){

        activeMembershipService = new ActiveMembershipService();

        ActiveMemberships activeMemberships = activeMembershipService.findById(1);

        activeMembershipService.delete(activeMemberships);


        assertEquals(null, activeMembershipService.findById(1));
    }

}
