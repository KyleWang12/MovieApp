package movieApp.entity;

public class UserFavoriteMovie {

    private int userFavId;
    private int userId;
    String tConst;

    public UserFavoriteMovie() {

    }

    public UserFavoriteMovie(int userFavId, int userId, String tConst) {
        this.userFavId = userFavId;
        this.userId = userId;
        this.tConst = tConst;
    }

    public int getUserFavId() {
        return userFavId;
    }

    public void setUserFavId(int userFavId) {
        this.userFavId = userFavId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String gettConst() {
        return tConst;
    }

    public void settConst(String tConst) {
        this.tConst = tConst;
    }
}
