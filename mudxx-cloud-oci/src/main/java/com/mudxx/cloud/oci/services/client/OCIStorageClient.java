package com.mudxx.cloud.oci.services.client;

import com.mudxx.cloud.oci.common.api.OCIApiClient;
import com.mudxx.cloud.oci.common.api.OCIApiException;
import com.mudxx.cloud.oci.common.generator.OCIGenerator;
import com.mudxx.cloud.oci.model.entity.OCIAuthenticationModel;
import com.mudxx.cloud.oci.services.auth.OCIAuthProvider;
import com.oracle.bmc.Region;
import com.oracle.bmc.auth.AuthenticationDetailsProvider;
import com.oracle.bmc.objectstorage.ObjectStorageClient;
import com.oracle.bmc.objectstorage.model.Bucket;
import com.oracle.bmc.objectstorage.model.ListObjects;
import com.oracle.bmc.objectstorage.model.PreauthenticatedRequest;
import com.oracle.bmc.objectstorage.requests.*;
import com.oracle.bmc.objectstorage.responses.*;

/**
 * @author laiw
 * @date 2023/8/18 11:18
 */
public class OCIStorageClient {

    private final OCIApiClient apiClient;

    private final ObjectStorageClient objectStorageClient;

    public OCIStorageClient(AuthenticationDetailsProvider provider) {
        this.apiClient = new OCIApiClient();
        this.objectStorageClient = ObjectStorageClient.builder().build(provider);
    }

    public OCIStorageClient(OCIAuthenticationModel providerModel, Region region) {
        this(OCIAuthProvider.buildProvider(providerModel, region));
    }

    /**
     * 获取名称空间
     */
    public String getNamespace(String compartmentId) throws OCIApiException {
        GetNamespaceRequest request = GetNamespaceRequest.builder()
                .opcClientRequestId(OCIGenerator.opcClientRequestId())
                .compartmentId(compartmentId)
                .build();
        String logName = "OCI-OSS-getNamespace-" + System.currentTimeMillis();
        GetNamespaceResponse response = (GetNamespaceResponse) this.apiClient.doExecute(
                this.objectStorageClient::getNamespace,
                request,
                logName
        );
        return response.getValue();
    }

    /**
     * 创建存储桶
     */
    public Bucket createBucket(CreateBucketRequest request) throws OCIApiException {
        String logName = "OCI-OSS-createBucket-" + System.currentTimeMillis();
        CreateBucketResponse response = (CreateBucketResponse) this.apiClient.doExecute(
                this.objectStorageClient::createBucket,
                request,
                logName
        );
        return response.getBucket();
    }

    /**
     * 获取存储桶信息
     */
    public Bucket getBucket(GetBucketRequest request) throws OCIApiException {
        String logName = "OCI-OSS-getBucket-" + System.currentTimeMillis();
        GetBucketResponse response = (GetBucketResponse) this.apiClient.doExecute(
                this.objectStorageClient::getBucket,
                request,
                logName
        );
        return response.getBucket();
    }

    /**
     * 列出存储桶列表
     */
    public ListBucketsResponse listBuckets(ListBucketsRequest request) throws OCIApiException {
        String logName = "OCI-OSS-listBuckets-" + System.currentTimeMillis();
        return (ListBucketsResponse) this.apiClient.doExecute(
                this.objectStorageClient::listBuckets,
                request,
                logName
        );
    }

    /**
     * 删除存储桶
     */
    public DeleteBucketResponse deleteBucket(DeleteBucketRequest request) throws OCIApiException {
        String logName = "OCI-OSS-deleteBucket-" + System.currentTimeMillis();
        return (DeleteBucketResponse) this.apiClient.doExecute(
                this.objectStorageClient::deleteBucket,
                request,
                logName
        );
    }

    /**
     * 创建预认证请求
     */
    public PreauthenticatedRequest createPreauthenticatedRequest(CreatePreauthenticatedRequestRequest request) throws OCIApiException {
        String logName = "OCI-OSS-createPreauthenticatedRequest-" + System.currentTimeMillis();
        CreatePreauthenticatedRequestResponse response = (CreatePreauthenticatedRequestResponse) this.apiClient.doExecute(
                this.objectStorageClient::createPreauthenticatedRequest,
                request,
                logName
        );
        return response.getPreauthenticatedRequest();
    }

    /**
     * 获取存储对象
     */
    public GetObjectResponse getObject(GetObjectRequest request) throws OCIApiException {
        String logName = "OCI-OSS-getObject-" + System.currentTimeMillis();
        return (GetObjectResponse) this.apiClient.doExecute(
                this.objectStorageClient::getObject,
                request,
                logName
        );
    }

    /**
     * 列出存储对象列表
     */
    public ListObjects listObjects(ListObjectsRequest request) throws OCIApiException {
        String logName = "OCI-OSS-listObjects-" + System.currentTimeMillis();
        ListObjectsResponse response = (ListObjectsResponse) this.apiClient.doExecute(
                this.objectStorageClient::listObjects,
                request,
                logName
        );
        return response.getListObjects();
    }

    /**
     * 删除存储对象
     */
    public DeleteObjectResponse deleteObject(DeleteObjectRequest request) throws OCIApiException {
        String logName = "OCI-OSS-deleteObject-" + System.currentTimeMillis();
        return (DeleteObjectResponse) this.apiClient.doExecute(
                this.objectStorageClient::deleteObject,
                request,
                logName
        );
    }

}
