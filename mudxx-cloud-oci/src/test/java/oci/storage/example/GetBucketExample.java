package oci.storage.example;
/**
 * This is an automatically generated code sample.
 * To make this code sample work in your Oracle Cloud tenancy,
 * please replace the values for any parameters whose current values do not fit
 * your use case (such as resource IDs, strings containing ‘EXAMPLE’ or ‘unique_id’, and
 * boolean, number, and enum parameters with values not fitting your use case).
 */

import cn.hutool.json.JSONUtil;
import com.mudxx.cloud.oci.common.api.OCIApiException;
import com.mudxx.cloud.oci.services.builder.OCIStorageBucketBuilder;
import com.mudxx.cloud.oci.model.entity.OCIStorageBucketModel;
import com.mudxx.cloud.oci.services.client.OCIStorageClient;
import com.oracle.bmc.objectstorage.model.Bucket;
import com.oracle.bmc.objectstorage.requests.GetBucketRequest;
import oci.storage.OCIStorageBuilder;


public class GetBucketExample {

    public static void main(String[] args) throws OCIApiException {

        OCIStorageClient client = OCIStorageBuilder.buildClient();

        OCIStorageBucketModel bucketModel = new OCIStorageBucketModel.Builder()
                .compartmentId("")
                .namespaceName("")
                .bucketName("agile-dev-bucket-20230818-1711")
                .build();

        GetBucketRequest request = OCIStorageBucketBuilder.buildGetBucketRequest(bucketModel);

        /* Send request to the Client */
        Bucket response = client.getBucket(request);
        System.out.println(JSONUtil.toJsonStr(response));
    }


}

