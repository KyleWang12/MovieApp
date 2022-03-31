package movieApp.repository;

import static movieApp.constants.UserConstants.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import movieApp.entity.UserFavoriteMovie;

public class UserFavoriteMovieRepository {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public UserFavoriteMovieRepository() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        conn = DriverManager.getConnection(connection, username, password);
        stmt = conn.createStatement();
    }

    public UserFavoriteMovie getUserFavoriteMovie(int userFavId){
        UserFavoriteMovie userFavoriteMovie = null;
        String query = "select * from UserFavoriteMovie where UserFavId = '"+userFavId+"';";
        try {
            rs = stmt.executeQuery(query);
            userFavoriteMovie = new UserFavoriteMovie();
            userFavoriteMovie.setUserFavId(userFavId);
            userFavoriteMovie.setUserId(rs.getInt("UserId"));
            userFavoriteMovie.settConst(rs.getString("Tconst"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userFavoriteMovie;
    }

    public List<UserFavoriteMovie> getUserFavoriteMovies(int userId)
    {
        List<UserFavoriteMovie> userFavoriteMovies = new ArrayList<>();
        String query = "select * from UserFavoriteMovie where UserId = '"+userId+"';";
        try {
            rs = stmt.executeQuery(query);
            while(rs.next()){
                UserFavoriteMovie userFavoriteMovie = new UserFavoriteMovie();
                userFavoriteMovie.setUserId(rs.getInt("UserId"));
                userFavoriteMovie.setUserFavId(rs.getInt("UserFavId"));
                userFavoriteMovie.settConst(rs.getString("Tconst"));
                userFavoriteMovies.add(userFavoriteMovie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userFavoriteMovies;
    }

    public void addUserFavoriteMovie(int userId, String tConst){
        UserFavoriteMovie userFavoriteMovie = new UserFavoriteMovie();
        userFavoriteMovie.setUserId(userId);
        userFavoriteMovie.settConst(tConst);
        String query = "insert into UserFavoriteMovie('UserId', 'Tconst') values("+userFavoriteMovie.getUserId()+","+userFavoriteMovie.gettConst()+");";
        try {
            stmt.executeQuery(query);
            System.out.println("record inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserFavoriteMovie(int userFavId){
        String query = "select * from UserFavoriteMovie where UserFavId = '"+userFavId+"';";
        try {
            rs = stmt.executeQuery(query);
            if(rs.next()){
                query = "delete from UserFavoriteMovie where UserFavId = '"+userFavId+"';";
                stmt.executeQuery(query);
                System.out.println("record removed successfully");
            }else{
                System.err.println("record not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserFavoriteMovie(int userFavId, String tConst){
        String query = "select * from UserFavoriteMovie where UserFavId = '"+userFavId+"';";
        try {
            rs = stmt.executeQuery(query);
            if(rs.next()){
                query = "update UserFavoriteMovie set Tconst = '"+tConst+"' where UserFavId = '"+userFavId+"';";
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
