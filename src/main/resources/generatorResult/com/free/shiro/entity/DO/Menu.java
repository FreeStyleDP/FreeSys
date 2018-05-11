package com.free.shiro.entity.DO;

public class Menu {
    /**
     * 
     */
    private String id;

    /**
     * 菜单显示名字
     */
    private String name;

    /**
     * 父菜单
     */
    private String parentname;

    /**
     * 排列序号
     */
    private Integer order;

    /**
     * 图标地址
     */
    private String icon;

    /**
     * 父菜单排序
     */
    private Integer parentorder;

    /**
     * 
     * @return id 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 菜单显示名字
     * @return name 菜单显示名字
     */
    public String getName() {
        return name;
    }

    /**
     * 菜单显示名字
     * @param name 菜单显示名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 父菜单
     * @return parentName 父菜单
     */
    public String getParentname() {
        return parentname;
    }

    /**
     * 父菜单
     * @param parentname 父菜单
     */
    public void setParentname(String parentname) {
        this.parentname = parentname == null ? null : parentname.trim();
    }

    /**
     * 排列序号
     * @return order 排列序号
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * 排列序号
     * @param order 排列序号
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * 图标地址
     * @return icon 图标地址
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 图标地址
     * @param icon 图标地址
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 父菜单排序
     * @return parentOrder 父菜单排序
     */
    public Integer getParentorder() {
        return parentorder;
    }

    /**
     * 父菜单排序
     * @param parentorder 父菜单排序
     */
    public void setParentorder(Integer parentorder) {
        this.parentorder = parentorder;
    }
}