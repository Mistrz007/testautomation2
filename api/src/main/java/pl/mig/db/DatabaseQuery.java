package pl.mig.db;

import pl.mig.db.model.UserDbTest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQuery {

    public UserDbTest getUserById(int id){
        String sql = "Select id,name,surname FROM usertest where id =  "+ id;
        UserDbTest u = null;
        try {
            Statement statement = DatabaseConnector.getConnection().createStatement();
            ResultSet s = statement.executeQuery(sql);
            while(s.next()){
                u = new UserDbTest(s.getInt("id"),s.getString("name"),s.getString("surname"));
            }
            s.close();
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return u;
    }

    public List<UserDbTest> getUserList(){
        String sql = "Select id,name,surname FROM usertest";
        List<UserDbTest> uL = new ArrayList<>();
        try {
            Statement statement = DatabaseConnector.getConnection().createStatement();
            ResultSet s = statement.executeQuery(sql);
            while(s.next()){
                UserDbTest u = new UserDbTest(s.getInt("id"),s.getString("name"),s.getString("surname"));
                uL.add(u);
            }
            s.close();
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return uL;
    }

    public void saveOne(UserDbTest testUser) {
        String sql = "insert into usertest (id, name, surname) values (" + testUser.getId() + ", '" + testUser.getName() + "', '" + testUser.getSurname() + "')";
        try {
            DatabaseConnector.getConnection().createStatement().executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(UserDbTest testUser, int id) {
        String sql = "update usertest set id = " + testUser.getId() + ", name = '"
                + testUser.getName() + "', surname = '" + testUser.getSurname() + "' where id = " + id;
        try {
            DatabaseConnector.getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "delete usertest where id = " + id;
        try {
            DatabaseConnector.getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
