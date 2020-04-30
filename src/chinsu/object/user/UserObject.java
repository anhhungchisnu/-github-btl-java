/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chinsu.object.user;

/**
 *
 * @author Windows 10
 */
public class UserObject {
    private int user_id;
    private String user_name;
    private String user_pass;
    private int user_permission;

    public UserObject() {
    }

    public UserObject(int user_id, String user_name, String user_pass, byte user_permission) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_pass = user_pass;
        this.user_permission = user_permission;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public int getUser_permission() {
        return user_permission;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public void setUser_permission(int user_permission) {
        this.user_permission = user_permission;
    }
    
}
