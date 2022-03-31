package movieApp.entity;

import java.sql.Timestamp;

public class UserReview {

    private int reviewId;
    private int userId;
    private Timestamp createdTime;
    private String content;
    private String  tConst;

    public UserReview() {
    }

    public UserReview(int reviewId, int userId, Timestamp createdTime, String content, String tConst) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.createdTime = createdTime;
        this.content = content;
        this.tConst = tConst;
    }

    public int getReviewId() {
        return reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public String getContent() {
        return content;
    }

    public String gettConst() {
        return tConst;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void settConst(String tConst) {
        this.tConst = tConst;
    }
}
