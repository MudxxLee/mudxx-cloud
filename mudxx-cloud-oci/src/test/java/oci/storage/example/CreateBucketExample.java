package oci.storage.example;

import cn.hutool.json.JSONUtil;
import com.mudxx.cloud.oci.common.api.OCIApiException;
import com.mudxx.cloud.oci.services.builder.OCIStorageBucketBuilder;
import com.mudxx.cloud.oci.model.entity.OCIStorageBucketModel;
import com.mudxx.cloud.oci.services.client.OCIStorageClient;
import com.oracle.bmc.objectstorage.model.Bucket;
import com.oracle.bmc.objectstorage.model.CreateBucketDetails;
import com.oracle.bmc.objectstorage.requests.CreateBucketRequest;
import oci.storage.OCIStorageBuilder;

public class CreateBucketExample {

    public static void main(String[] args) throws OCIApiException {

        OCIStorageClient client = OCIStorageBuilder.buildClient();

        OCIStorageBucketModel bucketModel = new OCIStorageBucketModel.Builder()
                .compartmentId("")
                .namespaceName("")
                .bucketName("agile-dev-bucket-20230818-1711")
                .build();

        CreateBucketRequest request = OCIStorageBucketBuilder.buildCreateBucketRequest(
                bucketModel,
                CreateBucketDetails.PublicAccessType.ObjectReadWithoutList,
                null,
                null
        );

        Bucket bucket = client.createBucket(request);
        System.out.println(JSONUtil.toJsonStr(bucket));

    }


}

