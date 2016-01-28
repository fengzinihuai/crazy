package com.volkswagen.events.entity;

import java.util.Hashtable;


public class User implements IUser {
    
    private Long userID; // 用户账号ID

    private Long enterpriseID; // 所对应的企业ID

    private int state; // 该用户的企业认证是否通过

    private transient String params; // 扩展数据（json字符串, 此值不需要序列化,只用于数据库存储

    private Hashtable<String, String> paraMap; // 扩展数据（集合）

    private Long ExtendID;

    private Long SortID;

    private Integer ProductID;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getEnterpriseID() {
        return enterpriseID;
    }

    public void setEnterpriseID(Long enterpriseID) {
        this.enterpriseID = enterpriseID;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        /*
         * if(params!=null && params.length()>1){ jsonToParaList(params); }
         */
        this.params = params;
    }

    public Hashtable<String, String> getParaMap() {
        return paraMap;
    }

    public void setParaMap(Hashtable<String, String> paraMap) {
        this.paraMap = paraMap;
    }

    public void validate() throws Exception {
        if (getEnterpriseID() == null) throw new RuntimeException("EnterpriseID不能为空");
    }

    public void setPara(String name, Integer cateID, String value) {
        if (name == null || name.length() == 0 || cateID == null || value == null) return;
        if (paraMap == null) paraMap = new Hashtable<String, String>();
        paraMap.put(name + "_" + cateID, value);
    }

    public String getPara(String name, Integer cateID) {
        if (paraMap != null)
            return paraMap.get(name + "_" + cateID);
        else
            return null;
    }


    public void setExtendID(Long extendID) {
        this.ExtendID = extendID;
    }

    public Long getExtendID() {
        return ExtendID;
    }

    public void setSortID(Long sortID) {
        SortID = sortID;
    }

    public Long getSortID() {
        return SortID;
    }

    public void setProductID(Integer productID) {
        ProductID = productID;
    }

    public Integer getProductID() {
        return ProductID;
    }

    @Override
    public long getId() {
        // TODO Auto-generated method stub
        return 0;
    }

}
