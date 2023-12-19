package oci.storage.example;

import com.mudxx.cloud.oci.common.api.OCIApiException;
import com.mudxx.cloud.oci.services.client.OCIStorageClient;
import oci.storage.OCIStorageBuilder;

public class GetNamespaceExample {

    public static void main(String[] args) throws OCIApiException {

        OCIStorageClient client = OCIStorageBuilder.buildClient();

        /* Send request to the Client */
        String response = client.getNamespace("ocid1.compartment.oc1..aaaaaaaat6fed7rgdhs6cgfjuzll2wwgk3keaiq5io3ktqlpjchrvpsjuezq");
        System.out.println(response);

    }


}

