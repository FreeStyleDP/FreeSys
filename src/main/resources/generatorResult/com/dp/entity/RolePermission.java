package com.dp.entity;

public class RolePermission {
    /**
     * 角色id
     */
    private String roleId;

    /**
     * 权限id
     */
    private String permissionId;

    /**
     * 角色id
     * @return role_id 角色id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 角色id
     * @param roleId 角色id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * 权限id
     * @return permission_id 权限id
     */
    public String getPermissionId() {
        return permissionId;
    }

    /**
     * 权限id
     * @param permissionId 权限id
     */
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }
}