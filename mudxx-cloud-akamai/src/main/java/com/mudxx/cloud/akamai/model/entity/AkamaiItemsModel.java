package com.mudxx.cloud.akamai.model.entity;


import java.io.Serializable;
import java.util.List;

/**
 * 模型-属性
 *
 * @author laiw
 * @date 2023/12/14 13:53
 */
public class AkamaiItemsModel<T> implements Serializable {
    private static final long serialVersionUID = 3788306487263204855L;
    /**
     * 帐户 ID-标识属性所属的帐户
     */
    private List<T> items;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
