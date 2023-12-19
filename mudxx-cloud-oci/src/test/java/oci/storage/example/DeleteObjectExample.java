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
import com.mudxx.cloud.oci.services.builder.OCIStorageObjectBuilder;
import com.mudxx.cloud.oci.model.entity.OCIStorageObjectModel;
import com.mudxx.cloud.oci.services.client.OCIStorageClient;
import com.oracle.bmc.objectstorage.requests.DeleteObjectRequest;
import com.oracle.bmc.objectstorage.responses.DeleteObjectResponse;
import oci.storage.OCIStorageBuilder;


public class DeleteObjectExample {

    public static void main(String[] args) throws OCIApiException {

        OCIStorageClient client = OCIStorageBuilder.buildClient();

        OCIStorageObjectModel objectModel = new OCIStorageObjectModel.Builder()
                .compartmentId("")
                .namespaceName("")
                .bucketName("agile-dev-bucket-20230818-1711")
                .objectName("agile-dev-object-20230823-1556.png")
                .build();

        DeleteObjectRequest request = OCIStorageObjectBuilder.buildDeleteObjectRequest(objectModel);

        /* Send request to the Client */
        DeleteObjectResponse response = client.deleteObject(request);
        System.out.println(JSONUtil.toJsonStr(response));
    }


}

