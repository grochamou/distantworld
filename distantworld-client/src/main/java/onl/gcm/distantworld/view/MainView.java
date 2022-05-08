package onl.gcm.distantworld.view;

import javax.annotation.PostConstruct;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClientException;

import onl.gcm.hermes.client.DistantWorldClient;
import onl.gcm.hermes.client.HermesClient;

@Route("")
public class MainView extends Div {

    private static final String GREEN_COLOR = "green";
    private static final String RED_COLOR = "red";

    @Autowired
    private transient DistantWorldClient distantWorldClient;

    @PostConstruct
    @SuppressWarnings("java:S1854")
    private void init() {
        String s;
        boolean ok;

        s = String.valueOf(distantWorldClient.isHermesServerAlive());
        add(DivBuilder.create().setText("Hermes isAlive: " + s).build());

        s = String.valueOf(distantWorldClient.isAlive());
        add(DivBuilder.create().setText("DistantWorld isAlive: " + s).build());

        try {
            s = null;
            for (int i = 0; i < 10; i++) { // Loop to test cache.
                s = distantWorldClient.getTest("1").getData();
            }
            ok = true;
        } catch (RestClientException e) {
            ok = false;
            s = HermesClient.getErrorMessage(e);
        }
        add(DivBuilder.create().setText("DistantWorld getTest: " + s).setColor(ok ? GREEN_COLOR : RED_COLOR).build());

        try {
            s = null; // Unused assignments should be removed.
            for (int i = 0; i < 10; i++) { // Loop to test cache.
                distantWorldClient.getNoContent();
            }
            s = "✅";
            ok = true;
        } catch (RestClientException e) {
            ok = false;
            s = HermesClient.getErrorMessage(e);
        }
        add(DivBuilder.create().setText("DistantWorld getNoContent: " + s).setColor(ok ? GREEN_COLOR : RED_COLOR)
                .build());

        try {
            s = null; // Unused assignments should be removed.
            distantWorldClient.getNotFound();
            s = "❌";
            ok = true;
        } catch (RestClientException e) {
            ok = false;
            s = HermesClient.getErrorMessage(e);
        }
        add(DivBuilder.create().setText("DistantWorld getNotFound: " + s).setColor(ok ? GREEN_COLOR : RED_COLOR)
                .build());

        try {
            s = null;
            distantWorldClient.getCrash();
            ok = true;
        } catch (RestClientException e) {
            ok = false;
            s = HermesClient.getErrorMessage(e);
        }
        add(DivBuilder.create().setText("DistantWorld getCrash: " + s).setColor(ok ? GREEN_COLOR : RED_COLOR).build());
    }

}
