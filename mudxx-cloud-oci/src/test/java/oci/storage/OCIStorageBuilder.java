package oci.storage;

import com.mudxx.cloud.oci.services.client.OCIStorageClient;
import oci.auth.OCIAuthBuilder;

/**
 * @author laiw
 * @date 2023/11/7 10:22
 */
public class OCIStorageBuilder {

    public static OCIStorageClient buildClient() {
        return new OCIStorageClient(OCIAuthBuilder.getProvider());
    }

}
