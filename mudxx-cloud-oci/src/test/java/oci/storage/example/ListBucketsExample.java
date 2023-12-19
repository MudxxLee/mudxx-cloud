package oci.storage.example;

/**
 * This is an automatically generated code sample.
 * To make this code sample work in your Oracle Cloud tenancy,
 * please replace the values for any parameters whose current values do not fit
 * your use case (such as resource IDs, strings containing ‘EXAMPLE’ or ‘unique_id’, and
 * boolean, number, and enum parameters with values not fitting your use case).
 */

import com.mudxx.cloud.oci.common.api.OCIApiException;
import com.mudxx.cloud.oci.services.builder.OCIStorageBucketBuilder;
import com.mudxx.cloud.oci.model.entity.OCIStorageBaseModel;
import com.mudxx.cloud.oci.services.client.OCIStorageClient;
import com.mudxx.cloud.oci.common.util.JsonUtil;
import com.oracle.bmc.objectstorage.requests.ListBucketsRequest;
import com.oracle.bmc.objectstorage.responses.ListBucketsResponse;
import oci.storage.OCIStorageBuilder;


public class ListBucketsExample {

    public static void main(String[] args) throws OCIApiException {

        OCIStorageClient client = OCIStorageBuilder.buildClient();

        OCIStorageBaseModel baseModel = new OCIStorageBaseModel();
        baseModel.setCompartmentId("ocid1.compartment.oc1..aaaaaaaat6fed7rgdhs6cgfjuzll2wwgk3keaiq5io3ktqlpjchrvpsjuezq");
        baseModel.setNamespaceName("cn8hmkndgud5");

        ListBucketsRequest request = OCIStorageBucketBuilder.buildListBucketsRequest(
                baseModel,
                2,
                null
        );

        /* Send request to the Client */
        ListBucketsResponse response = client.listBuckets(request);
        System.out.println(JsonUtil.toJsonStrMelody(response));
    }


}

