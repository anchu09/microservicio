package DroolTest;

import org.drools.DroolsDemo.PaymentOffer;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolTest {
    public static void main(String[] args) {
        DroolTest mydrool_test = new DroolTest();
        mydrool_test.executeBusinessRule();
    }
    public void executeBusinessRule(){
        try{
            KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();

            KieSession ksession = kc.newKieSession("hola");
            ksession.insert( new PaymentOffer("phonepe") );
            ksession.fireAllRules();
            ksession.dispose(); // Stateful rule session must always be disposed when finished
            //System.out.println("The cashback for this payment channel VIA KIE"+my_payment_offer.getChannel());

        } catch (Exception e){
        e.printStackTrace ();}

    }
}
