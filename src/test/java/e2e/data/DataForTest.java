package e2e.data;

import java.util.function.Supplier;

public class DataForTest {

    private String endpointAddUserCredential = "/admin/saveSystemUser";

    public Supplier<String> getEndpointUserCredential = () -> endpointAddUserCredential;

}
