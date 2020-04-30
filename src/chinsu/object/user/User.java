/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chinsu.object.user;

import java.sql.ResultSet;

/**
 *
 * @author Windows 10
 */
public interface User {
    //Các chức năng cập nhật
	public boolean addUser (UserObject item);
	public boolean editUser (UserObject item);
	public boolean delUser (UserObject item);
	
	//Các chức năng lấy dữ liệu
	public ResultSet getUser (int id);
	public ResultSet getUser (String username, String userpass);
        public ResultSet getUsers ();
}
