package com.group4.entity;

public class UserFavoritePrinciple {

    private int userFavPrincipleId;
    private int userId;
    String nConst;

    public UserFavoritePrinciple() {
    }

    public UserFavoritePrinciple(int userFavPrincipleId, int userId, String nConst) {
        this.userFavPrincipleId = userFavPrincipleId;
        this.userId = userId;
        this.nConst = nConst;
    }

    public int getUserFavPrincipleId() {
        return userFavPrincipleId;
    }

    public void setUserFavPrincipleId(int userFavPrincipleId) {
        this.userFavPrincipleId = userFavPrincipleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getnConst() {
        return nConst;
    }

    public void setnConst(String nConst) {
        this.nConst = nConst;
    }
}
