package e2e.data;

import java.util.function.Supplier;

public class GX3_3082_DataForTest {

    private String endpointAddUserCredential = "/admin/saveSystemUser";

    public Supplier<String> getEndpointUserCredential = () -> endpointAddUserCredential;

}
