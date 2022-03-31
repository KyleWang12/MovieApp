package movieApp.repository;

import movieApp.entity.UserFavoritePrinciple;

import java.sql.*;

import static movieApp.constants.UserConstants.*;

public class UserFavoritePrincipleRepository {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public UserFavoritePrincipleRepository() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        conn = DriverManager.getConnection(connection, username, password);
        stmt = conn.createStatement();
    }

    public UserFavoritePrinciple getUserFavoriteMoviePrinciple(int userFavPrincipleId )
    {
        UserFavoritePrinciple userFavoritePrinciple = null;
        String query = "select * from UserFavoritePrinciple where UserFavPrincipleId = '"+userFavPrincipleId+"';";
        try {
            rs = stmt.executeQuery(query);
            userFavoritePrinciple = new UserFavoritePrinciple();
            userFavoritePrinciple.setUserFavPrincipleId(userFavPrincipleId);
            userFavoritePrinciple.setUserId(rs.getInt("UserId"));
            userFavoritePrinciple.setnConst(rs.getString("Nconst"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userFavoritePrinciple;
    }

    public void addUserFavoritePrinciple(int userId, String nConst){
        UserFavoritePrinciple userFavoritePrinciple = new UserFavoritePrinciple();
        userFavoritePrinciple.setUserId(userId);
        userFavoritePrinciple.setnConst(nConst);
        String query = "insert into UserFavoritePrinciple('UserId', 'Nconst') values("+userId+","+nConst+");";
        try {
            stmt.executeQuery(query);
            System.out.println("record inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserFavoritePrinciple(int userFavPrincipleId){
        String query = "select * from UserFavoritePrinciple where UserFavPrincipleId = '"+userFavPrincipleId+"';";
        try {
            rs = stmt.executeQuery(query);
            if(rs.next()){
                query = "delete from UserFavoritePrinciple where UserFavPrincipleId = '"+userFavPrincipleId+"';";
                stmt.executeQuery(query);
                System.out.println("record removed successfully");
            }else{
                System.err.println("record not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserFavoritePrinciple(int userFavPrincipleId, String nConst){
        String query = "select * from UserFavoritePrinciple where UserFavPrincipleId = '"+userFavPrincipleId+"';";
        try {
            rs = stmt.executeQuery(query);
            if(rs.next()){
                query = "update UserFavoritePrinciple set Nconst = '"+nConst+"' where UserFavPrincipleId = '"+userFavPrincipleId+"';";
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
