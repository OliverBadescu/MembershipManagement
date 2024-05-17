import Payments.model.Payment;
import Payments.service.PaymentService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PaymentsServiceTest {

    private PaymentService paymentService;

    @Test

    public void voids(){

        paymentService = new PaymentService();

        paymentService.saveData();
        int id = paymentService.generateId();
        paymentService.newPayment(1,1);

    }

    @Test

    public void GivenAvailableIdCheckIfGetsFound(){

        paymentService = new PaymentService();

        Payment payment = paymentService.findById(1);
        Payment payment1 = paymentService.findById(99);

        assertEquals(1,payment.getId());
        assertNull(payment1);

    }
}
