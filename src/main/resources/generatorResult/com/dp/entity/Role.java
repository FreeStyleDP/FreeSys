package com.dp.entity;

public class Role {
    /**
     * 角色id
     */
    private String id;

    /**
     * 角色描述
     */
    private String desc;

    /**
     * 角色id
     * @return id 角色id
     */
    public String getId() {
        return id;
    }

    /**
     * 角色id
     * @param id 角色id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 角色描述
     * @return desc 角色描述
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 角色描述
     * @param desc 角色描述
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}