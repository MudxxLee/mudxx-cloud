package com.mudxx.cloud.oci.services.builder;

import com.mudxx.cloud.oci.common.generator.OCIGenerator;
import com.mudxx.cloud.oci.model.entity.OCIStorageBucketModel;
import com.mudxx.cloud.oci.model.entity.OCIStorageObjectModel;
import com.oracle.bmc.objectstorage.model.CreatePreauthenticatedRequestDetails;
import com.oracle.bmc.objectstorage.model.PreauthenticatedRequest;
import com.oracle.bmc.objectstorage.requests.CreatePreauthenticatedRequestRequest;
import com.oracle.bmc.objectstorage.requests.DeleteObjectRequest;
import com.oracle.bmc.objectstorage.requests.GetObjectRequest;
import com.oracle.bmc.objectstorage.requests.ListObjectsRequest;

import java.util.Date;

public class OCIStorageObjectBuilder {

    /**
     * 构建请求-创建预认证请求
     *
     * @param objectModel         存储对象信息
     * @param accessType          可对该资源执行的操作枚举
     * @param bucketListingAction 指定访问类型的枚举
     * @param timeExpires         预认证请求的截止日期
     * @return CreatePreauthenticatedRequestRequest
     */
    public static CreatePreauthenticatedRequestRequest buildPreRequest(OCIStorageObjectModel objectModel,
                                                                       CreatePreauthenticatedRequestDetails.AccessType accessType,
                                                                       PreauthenticatedRequest.BucketListingAction bucketListingAction,
                                                                       Date timeExpires) {
        CreatePreauthenticatedRequestDetails createPreauthenticatedRequestDetails =
                CreatePreauthenticatedRequestDetails.builder()
                        .name(OCIGenerator.preAuthenticatedRequestName())
                        .objectName(objectModel.getObjectName())
                        // 可对该资源执行的操作枚举
                        .accessType(accessType)
                        // 指定访问类型为“AnyObjectRead”或“AnyObjectReadWrite”的PAR上是否允许列表操作。Deny:禁止用户执行列表操作。ListObjects:授权用户执行列表操作。
                        .bucketListingAction(bucketListingAction)
                        // 预认证请求的截止日期
                        .timeExpires(timeExpires)
                        .build();

        return CreatePreauthenticatedRequestRequest.builder()
                .opcClientRequestId(OCIGenerator.opcClientRequestId())
                .namespaceName(objectModel.getNamespaceName())
                .bucketName(objectModel.getBucketName())
                .createPreauthenticatedRequestDetails(createPreauthenticatedRequestDetails)
                .build();
    }

    /**
     * 构建请求-获取存储对象信息
     *
     * @param objectModel 存储对象信息
     * @return GetObjectRequest
     */
    public static GetObjectRequest buildGetObjectRequest(OCIStorageObjectModel objectModel) {
        return GetObjectRequest.builder()
                .opcClientRequestId(OCIGenerator.opcClientRequestId())
                .namespaceName(objectModel.getNamespaceName())
                .bucketName(objectModel.getBucketName())
                .objectName(objectModel.getObjectName())
                .versionId(null)
                .ifMatch(null)
                .ifNoneMatch(null)
                .opcSseCustomerAlgorithm(null)
                .opcSseCustomerKey(null)
                .opcSseCustomerKeySha256(null)
                .httpResponseContentDisposition(null)
                .httpResponseCacheControl(null)
                .httpResponseContentType(null)
                .httpResponseContentLanguage(null)
                .httpResponseContentEncoding(null)
                .httpResponseExpires(null)
                .build();
    }

    /**
     * 构建请求-列出存储对象列表
     *
     * @param bucketModel   存储桶信息
     * @param limit         每页的最大结果数
     * @param nextStartWith 下一页查询的开始值
     * @param prefix        用于在列表查询中与对象名称的开头进行匹配的字符串。
     * @return ListObjectsRequest
     */
    public static ListObjectsRequest buildListObjectsRequest(OCIStorageBucketModel bucketModel,
                                                             Integer limit,
                                                             String nextStartWith,
                                                             String prefix) {
        return ListObjectsRequest.builder()
                .opcClientRequestId(OCIGenerator.opcClientRequestId())
                .namespaceName(bucketModel.getNamespaceName())
                .bucketName(bucketModel.getBucketName())
                .limit(limit)
                .start(nextStartWith)
                .end(null)
                .prefix(prefix)
                .delimiter("/")
                .fields("name,size,timeCreated,timeModified")
                .startAfter(null)
                .build();
    }

    /**
     * 构建请求-删除存储对象
     *
     * @param objectModel 存储对象信息
     * @return DeleteObjectRequest
     */
    public static DeleteObjectRequest buildDeleteObjectRequest(OCIStorageObjectModel objectModel) {
        return DeleteObjectRequest.builder()
                .opcClientRequestId(OCIGenerator.opcClientRequestId())
                .namespaceName(objectModel.getNamespaceName())
                .bucketName(objectModel.getBucketName())
                .objectName(objectModel.getObjectName())
                .ifMatch(null)
                .versionId(null)
                .build();
    }

}

