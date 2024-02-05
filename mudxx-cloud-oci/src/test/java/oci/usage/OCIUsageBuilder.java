package oci.usage;

import com.oracle.bmc.usageapi.UsageapiClient;
import oci.auth.OCIAuthBuilder;

/**
 * @author laiw
 * @date 2023/11/7 10:22
 */
public class OCIUsageBuilder {

    public static UsageapiClient buildClient() {
        return UsageapiClient.builder().build(OCIAuthBuilder.getProvider());
    }

}
