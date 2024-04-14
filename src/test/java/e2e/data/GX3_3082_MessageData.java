package e2e.data;

import com.google.common.base.Supplier;

public class GX3_3082_MessageData {

    private String messageSuccess = "Successfully Saved";

    public Supplier<String> getMessageSuccess = () -> messageSuccess;
}
