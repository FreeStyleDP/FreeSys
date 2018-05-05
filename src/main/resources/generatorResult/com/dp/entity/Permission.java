package com.dp.entity;

public class Permission {
    /**
     * 权限id
     */
    private String id;

    /**
     * 权限描述
     */
    private String desc;

    /**
     * 权限id
     * @return id 权限id
     */
    public String getId() {
        return id;
    }

    /**
     * 权限id
     * @param id 权限id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 权限描述
     * @return desc 权限描述
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 权限描述
     * @param desc 权限描述
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}