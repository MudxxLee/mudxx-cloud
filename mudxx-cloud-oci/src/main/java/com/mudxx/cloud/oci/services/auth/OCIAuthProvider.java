package com.mudxx.cloud.oci.services.auth;

import com.mudxx.cloud.oci.model.entity.OCIAuthenticationModel;
import com.oracle.bmc.Region;
import com.oracle.bmc.auth.AuthenticationDetailsProvider;
import com.oracle.bmc.auth.SimpleAuthenticationDetailsProvider;
import com.oracle.bmc.auth.SimplePrivateKeySupplier;
import com.oracle.bmc.auth.StringPrivateKeySupplier;

import java.io.InputStream;
import java.util.function.Supplier;

/**
 * @author laiw
 * @date 2023/8/18 11:18
 */
public class OCIAuthProvider {

    /**
     * Create Authentication provider
     *
     * @param model  身份认证信息
     * @param region 地域
     * @return AuthenticationDetailsProvider
     */
    public static AuthenticationDetailsProvider buildProvider(OCIAuthenticationModel model, Region region) {
        return SimpleAuthenticationDetailsProvider.builder()
                .userId(model.getUserId())
                .tenantId(model.getTenantId())
                .fingerprint(model.getFingerprint())
                .region(region)
                .privateKeySupplier(getPrivateKeySupplier(model))
                .build();
    }

    private static Supplier<InputStream> getPrivateKeySupplier(OCIAuthenticationModel model) {
        Supplier<InputStream> privateKeySupplier;
        if (model.getPrivateKeyPath() != null) {
            privateKeySupplier = new SimplePrivateKeySupplier(model.getPrivateKeyPath());
        } else {
            privateKeySupplier = new StringPrivateKeySupplier(model.getPrivateKey());
        }
        return privateKeySupplier;
    }

}
