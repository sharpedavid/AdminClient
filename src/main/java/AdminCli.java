import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

public class AdminCli {

    public static void main(String[] args) {

        Keycloak keycloak = Keycloak.getInstance(
                "https://common-logon-dev.hlth.gov.bc.ca/auth",
                "moh_applications",
                "bulk-upload",
                System.getenv("bulk-upload-password"),
                "admin-cli");
        System.out.println(keycloak.serverInfo().getInfo());
        List<UserRepresentation> users = keycloak.realm("moh_applications").users().list();

        for (UserRepresentation user : users) {
            System.out.println("User: " + user.getId() + ", " + user.getUsername());
        }
    }
}