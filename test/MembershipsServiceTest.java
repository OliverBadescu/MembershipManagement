import Memberships.model.Membership;
import Memberships.service.MembershipService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MembershipsServiceTest {

    private MembershipService membershipService;

    @Test

    public void voids(){

        membershipService = new MembershipService();

        membershipService.afisare();
        membershipService.afisareRetail();
        membershipService.afisareNetflix();
        membershipService.afisareDentist();
        membershipService.afisareGym();

        membershipService.saveData();
        int id = membershipService.generateId();
        membershipService.sortareDupaPretDescrescator();
        membershipService.sortareDupaPretCrescator();
        membershipService.delete(membershipService.findById(1));

    }

    @Test

    public void GivenAvailableNameCheckIfGetsFound(){


        membershipService = new MembershipService();

        Membership membership = membershipService.findByName("Gym membership");
        Membership f = membershipService.findByName("");

        assertEquals("Gym membership", membership.getName());
        assertEquals(null, f);
    }

    @Test

    public void GivenAvailableIdCheckIfGetsFound(){

        membershipService = new MembershipService();

        Membership membership = membershipService.findById(1);
        Membership t = membershipService.findById(10);

        assertEquals(1, membership.getId());
        assertEquals(null, t);

    }

    @Test

    public void GivenAvailableMemberShipCheckIfGetsAdded(){

        membershipService = new MembershipService();

        Membership membership = new Membership("", 1,"",22,"");
        Membership membership1 = new Membership("", 99,"Gym membership",22,"");
        membershipService.add(membership);
        membershipService.add(membership1);

        assertEquals("", membershipService.findByName("").getName());
        assertEquals(null, membershipService.findById(99));
    }
}
