package com.group4.repository;

import com.group4.entity.UserReview;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.group4.constants.UserConstants.*;

public class UserReviewRepository {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public UserReviewRepository() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        conn = DriverManager.getConnection(connection, username, password);
        stmt = conn.createStatement();
    }

    public void closeConnections() throws SQLException {
        conn.close();
        stmt.close();
        rs.close();
    }

    public UserReview getUserReview(int userReviewId)
    {
        UserReview userReview = null;
        String query = "select * from UserReview where ReviewId = '"+userReviewId+"';";
        try {
            rs = stmt.executeQuery(query);
            userReview = new UserReview();
            userReview.setReviewId(userReviewId);
            userReview.setUserId(rs.getInt("UserId"));
            userReview.setContent(rs.getString("Content"));
            userReview.settConst(rs.getString("Tconst"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userReview;
    }

    public List<UserReview> getUserReviews(int userId)
    {
        List<UserReview> userReviewList = new ArrayList<>();
        String query = "select * from UserReview where UserId = '"+userId+"';";
        try {
            rs = stmt.executeQuery(query);
            while(rs.next()){
                UserReview userReview = new UserReview();
                userReview.setReviewId(rs.getInt("ReviewId"));
                userReview.setUserId(rs.getInt("UserId"));
                userReview.setContent(rs.getString("Content"));
                userReview.settConst(rs.getString("Tconst"));
                userReviewList.add(userReview);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userReviewList;
    }

    public void addReview(String content, int userId, String tConst){
        UserReview userReview = new UserReview();
        userReview.setUserId(userId);
        userReview.setContent(content);
        userReview.setCreatedTime(new Timestamp(System.currentTimeMillis()));
        userReview.settConst(tConst);
        String query = "insert into UserReview('UserId', 'Content', 'CreatedTime', 'Tconst') values("+userReview.getUserId()+","+userReview.getContent()+","+userReview.getCreatedTime()+","+userReview.gettConst()+");";
        try {
            stmt.executeQuery(query);
            System.out.println("record inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeReview(int reviewId){
        String query = "select * from UserReview where ReviewId = '"+reviewId+"';";
        try {
            rs = stmt.executeQuery(query);
            if(rs.next()){
                query = "delete from UserReview where ReviewId = '"+reviewId+"';";
                stmt.executeQuery(query);
                System.out.println("record removed successfully");
            }else{
                System.err.println("record not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateReview(int reviewId, String content){
        String query = "select * from UserReview where ReviewId = '"+reviewId+"';";
        try {
            rs = stmt.executeQuery(query);
            if(rs.next()){
                query = "update UserReview set Content = '"+content+"' where ReviewId = '"+reviewId+"';";
                stmt.executeQuery(query);
                System.out.println("record updated successfully");
            }else{
                System.err.println("record not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
