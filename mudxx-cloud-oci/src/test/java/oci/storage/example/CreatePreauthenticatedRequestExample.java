package oci.storage.example;

/**
 * This is an automatically generated code sample.
 * To make this code sample work in your Oracle Cloud tenancy,
 * please replace the values for any parameters whose current values do not fit
 * your use case (such as resource IDs, strings containing ‘EXAMPLE’ or ‘unique_id’, and
 * boolean, number, and enum parameters with values not fitting your use case).
 */

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.mudxx.cloud.oci.common.api.OCIApiException;
import com.mudxx.cloud.oci.services.builder.OCIStorageObjectBuilder;
import com.mudxx.cloud.oci.model.entity.OCIStorageObjectModel;
import com.mudxx.cloud.oci.services.client.OCIStorageClient;
import com.oracle.bmc.objectstorage.model.CreatePreauthenticatedRequestDetails;
import com.oracle.bmc.objectstorage.model.PreauthenticatedRequest;
import com.oracle.bmc.objectstorage.requests.CreatePreauthenticatedRequestRequest;
import oci.storage.OCIStorageBuilder;

import java.util.Date;

public class CreatePreauthenticatedRequestExample {

    public static void main(String[] args) throws OCIApiException {

        OCIStorageClient client = OCIStorageBuilder.buildClient();

        OCIStorageObjectModel objectModel = new OCIStorageObjectModel.Builder()
                .compartmentId("")
                .namespaceName("")
                .bucketName("agile-dev-bucket-20230818-1711")
                .objectName("agile-dev-object-20230823-1556.png")
                .build();

        CreatePreauthenticatedRequestRequest request = OCIStorageObjectBuilder.buildPreRequest(
                objectModel,
                CreatePreauthenticatedRequestDetails.AccessType.ObjectReadWrite,
                PreauthenticatedRequest.BucketListingAction.ListObjects,
                DateUtil.offsetMinute(new Date(), 150)
        );

        /* Send request to the Client */
        PreauthenticatedRequest response = client.createPreauthenticatedRequest(request);
        System.out.println(JSONUtil.toJsonStr(response));
        System.out.println(JSONUtil.toJsonStr(response.getFullPath()));

    }
}

