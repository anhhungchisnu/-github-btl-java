/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.object.user;

import chinsu.ConnectionDB;
import chinsu.object.basic.BasicImpl;
import com.sun.org.apache.regexp.internal.REUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10
 */
public class UserImpl extends BasicImpl implements User {

    Connection con = ConnectionDB.getConnection();

    private boolean isExisting(UserObject item) {
        boolean flag = false;
        String sql = "SELECT * FROM tbluser WHERE user_name='" + item.getUser_name() + "' ";
        ResultSet rs = this.gets(sql);
        if (rs != null) {
            try {
                if (rs.next()) {
                    flag = true;
                }
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return flag;
    }private boolean isExistingid(UserObject item) {
        boolean flag = false;
        String sql = "SELECT * FROM tbluser WHERE user_id='" + item.getUser_id() + "' ";
        ResultSet rs = this.gets(sql);
        if (rs != null) {
            try {
                if (rs.next()) {
                    flag = true;
                }
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public boolean addUser(UserObject item) {
        try {
            if(isExisting(item)) {
                return false;
            }
            
            String sql = "INSERT INTO tbluser(user_name, user_pass, user_permission) VALUES(?, ?, ?)";
            
            PreparedStatement pre = this.con.prepareStatement(sql); //Mẫu
            
            pre.setString(1, item.getUser_name());
            pre.setString(2, item.getUser_pass());
            pre.setInt(3, item.getUser_permission());
            return this.add(pre);
        } catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean editUser(UserObject item) {
        try {
            if(!isExistingid(item)){
                return false;
            }
            String sql = "UPDATE tbluser SET ";
            sql += "user_name=?, user_pass=?, user_permission=? ";
            sql += "WHERE user_id=?";
            
            PreparedStatement pre = this.con.prepareStatement(sql);
            
            pre.setString(1, item.getUser_name());
            pre.setString(2, item.getUser_pass());
            pre.setInt(3, item.getUser_permission());
            pre.setInt(4, item.getUser_id());
            return this.edit(pre);
        } catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delUser(UserObject item) {
        try {
            if(!isExistingid(item)){
                return false;
            }
            String sql = "DELETE FROM tbluser WHERE user_id=?";
            
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setInt(1, item.getUser_id());
            return this.del(pre);
        } catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ResultSet getUser(int id) { //Lấy theo id
        String sql = "SELECT * FROM tbluser WHERE user_id=?";
        return this.get(sql, id);
    }

    @Override
    public ResultSet getUser(String username, String userpass) {
        String sql = "SELECT * FROM tbluser WHERE (user_name=?) AND (user_pass=?)";
        return this.get(sql, username, userpass);
    }

    @Override
    public ResultSet getUsers() {
        String sql = "SELECT * FROM tbluser ";
        sql += "ORDER BY user_name ASC ";
        return this.gets(sql);
    }

    public static void main(String[] args) {
        try {
            User u = new UserImpl();
            
            UserObject user = new UserObject();
            user.setUser_id(2);
            user.setUser_name("lancuto123w");
            user.setUser_pass("123456789123");
            user.setUser_permission(1);
            boolean result= u.delUser(user);
            if(!result) {
                System.out.println("ad");
            }
            
            ResultSet rs = u.getUsers();
            String row;
            while (rs.next()) {
                row = "\nID: " + rs.getInt("user_id");
                row += "\nname: " + rs.getString("user_name");
                row += "\npass: " + rs.getString("user_pass");
                row += "\nper: " + rs.getInt("user_permission");
                System.out.println(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
