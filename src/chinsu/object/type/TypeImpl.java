/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.object.type;

import chinsu.ConnectionDB;
import chinsu.object.basic.BasicImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kieun
 */
public class TypeImpl extends BasicImpl implements Type{
    Connection con = ConnectionDB.getConnection();
    private boolean isExistingname(TypeObject item){
        boolean flag = false;
        String sql = "SELECT * FROM tbltype WHERE type_name = '" + item.getType_name() + "'";
        ResultSet rs = this.gets(sql);
        if(rs != null){
            try{
                if(rs.next()){
                    flag = true;
                }
                rs.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        return flag;
    }
    private boolean isExistingid(TypeObject item){
        boolean flag = false;
        String sql = "SELECT * FROM tbltype WHERE type_id = '" + item.getType_id() + "'";
        ResultSet rs = this.gets(sql);
        if(rs != null){
            try{
                if(rs.next()){
                    flag = true;
                }
                rs.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        return flag;
    }
    @Override
    public boolean addType(TypeObject item) {
        try {
            if(isExistingname(item)){
                return false;
            }
            String sql = "INSERT INTO tbltype(type_name) ";
            sql += "values(?)";
            
            PreparedStatement pre;
            pre = this.con.prepareStatement(sql);
            pre.setString(1, item.getType_name());
            return this.add(pre);
              } catch (SQLException ex) {
                              Logger.getLogger(TypeImpl.class.getName()).log(Level.SEVERE, null, ex);
              }
        return false;
    }

    @Override
    public boolean editType(TypeObject item) {
        try {
            if(!isExistingid(item)){
                return false;
            }
            String sql = "UPDATE tbltype SET ";
            sql += "type_name=? WHERE type_id = ?";
            PreparedStatement pre = this.con.prepareStatement(sql);
            
            pre.setString(1, item.getType_name());
            pre.setInt(2, item.getType_id());
            return this.edit(pre);
        } catch (SQLException ex) {
            Logger.getLogger(TypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delType(TypeObject item) {
        try {
            if(!isExistingid(item)){
                return false;
            }
            String sql = "DELETE FROM tbltype WHERE type_id =?";
            PreparedStatement pre = this.con.prepareCall(sql);
            pre.setInt(1, item.getType_id());
            return this.del(pre);
        } catch (SQLException ex) {
            Logger.getLogger(TypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    @Override
    public ResultSet getType(int id) {
        String sql = "SELECT * FROM tbltype WHERE type_id = ?";
        return this.get(sql, id);
    }

    @Override
    public ResultSet getTypes() {
        String sql = "SELECT * FROM tbltype ORDER BY type_id ASC";
        return this.gets(sql);
    }
    public static void main(String[] args) {
        Type t = new TypeImpl();
        
        TypeObject obj = new TypeObject();
        //obj.setType_id(3);
        obj.setType_id(2);
        obj.setType_name("sung");
        t.delType(obj);
        
        ResultSet rs = t.getTypes();
        String row;
        try{
            while(rs.next()){
                row = "\nID: " + rs.getInt("type_id");
                row += "\nID: " + rs.getString("type_name");
                System.out.println(row);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(TypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
