package com.volkswagen.events.entity;



public class User implements IUser {
    
    private Long userID; // 用户账号ID
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String name; // 用户账号ID


    private int state; // 该用户的企业认证是否通过

    private transient String params; // 扩展数据（json字符串, 此值不需要序列化,只用于数据库存储


    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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

    @Override
    public long getId() {
        // TODO Auto-generated method stub
        return 0;
    }

}
