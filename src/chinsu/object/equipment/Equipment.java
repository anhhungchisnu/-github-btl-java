/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.object.equipment;

import chinsu.object.user.UserObject;
import java.sql.ResultSet;

/**
 *
 * @author kieun
 */
public interface Equipment {
      //Các chức năng cập nhật
	public boolean addEquipment (EquipmentObject item);
	public boolean editEquipment (EquipmentObject item);
	public boolean delEquipment (EquipmentObject item);
	
	//Các chức năng lấy dữ liệu
	public ResultSet getEquipment (int id);
        public ResultSet getEquipments ();
}
