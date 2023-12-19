package com.mudxx.cloud.oci.common.generator;

import cn.hutool.core.util.IdUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author laiw
 * @date 2023/8/22 15:52
 */
public class OCIGenerator {

    private static final SimpleDateFormat FORMAT_ = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
    private static final String PREFIX_NAME = "pre-authenticated-request-";

    public static String opcClientRequestId() {
        return IdUtil.simpleUUID();
    }

    public static String preAuthenticatedRequestName() {
        try {
            return PREFIX_NAME + FORMAT_.format(new Date());
        } catch (Exception e) {
            return PREFIX_NAME + System.currentTimeMillis();
        }
    }

}