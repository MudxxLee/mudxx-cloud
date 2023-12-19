package oci.storage;

import com.mudxx.cloud.oci.common.util.JsonUtil;
import com.oracle.bmc.objectstorage.requests.CreateBucketRequest;

/**
 * @author laiw
 * @date 2023/11/7 11:59
 */
public class Test {

    public static void main(String[] args) {

        System.out.println(JsonUtil.toJsonStrPinyinOrder(new CreateBucketRequest()));
    }
}
