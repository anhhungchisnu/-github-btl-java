/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.object.equipment;

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
public class EquipmentImpl extends BasicImpl implements Equipment{
    Connection con = ConnectionDB.getConnection();
    
    private boolean isExisting(EquipmentObject item){
        boolean flag = false;
        String sql = "SELECT * FROM tblequipment WHERE equipment_name = '" + item.getEquipment_name() + "'";
        ResultSet rs = this.gets(sql);
        if(rs !=null){
            try{
                if(rs.next()){
                    flag=true;
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
    public boolean addEquipment(EquipmentObject item) {
        try{
            if(isExisting(item)){
                return false;
            }
            String sql = "INSERT INTO tblequipment(equipment_name,equipment_amount,distributor_id,type_id) VALUES (?,?,?,?)";
            
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setString(1, item.getEquipment_name());
            pre.setInt(2,item.getEquipment_amount());
            pre.setInt(3, item.getDistributor_id());
            pre.setInt(4, item.getType_id());
            return this.add(pre);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean editEquipment(EquipmentObject item) {
        try{
            String sql = "UPDATE tblequipment SET ";
            sql+="equipment_name=?,equipment_amount=?,distributor_id=?,type_id=? ";
            sql+="WHERE equipment_id=?";
            
            PreparedStatement pre = this.con.prepareStatement(sql);
            
            pre.setString(1, item.getEquipment_name());
            pre.setInt(2, item.getEquipment_amount());
            pre.setInt(3, item.getDistributor_id());
            pre.setInt(4, item.getType_id());
            pre.setInt(5, item.getEquipment_id());
            return this.edit(pre);
        }
        catch(SQLException ex){
            Logger.getLogger(EquipmentImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return false;
    }

    @Override
    public boolean delEquipment(EquipmentObject item) {
        try {
            String sql = "DELETE FROM tblequipment WHERE equipment_id = ?";     
            PreparedStatement pre = this.con.prepareCall(sql);
            pre.setInt(1,item.getEquipment_id());
            return this.del(pre);
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ResultSet getEquipment(int id) {
        String sql = "SELECT * FROM tblequipment WHERE equipment_id=?";
        return this.get(sql, id);
    }

    @Override
    public ResultSet getEquipments() {
        String sql = "SELECT * FROM tblequipment ORDER BY equipment_id ASC";
        return this.gets(sql);
    }
    public static void main(String[] args) {
        Equipment e = new EquipmentImpl();
        
        EquipmentObject obj = new EquipmentObject();
        obj.setEquipment_id(2);
        obj.setEquipment_amount(4);
        e.editEquipment(obj);

        
        ResultSet rs = e.getEquipments();
        String row;
        try {
            while(rs.next()){
                row = "\nID: " + rs.getInt("equipment_id");
                row += "\nName: " + rs.getString("equipment_name");
                row += "\nAmount: " + rs.getInt("equipment_amount");
                row += "\nDistributor ID: " + rs.getInt("distributor_id");
                row += "\nType ID: " + rs.getInt("type_id");
                System.out.println(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
