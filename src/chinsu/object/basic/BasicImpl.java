/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.object.basic;

import chinsu.ConnectionDB;
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
public class BasicImpl implements Basic {

    protected Connection con = ConnectionDB.getConnection();

    private boolean exe(PreparedStatement pre) {

        if(pre != null) {
            try {
                int result = pre.executeUpdate();
                if(result == 0) {
                    return false;
                }
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(BasicImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                pre = null;
            }
        }
        return false;
    }

    @Override
    public boolean add(PreparedStatement pre) {
        return this.exe(pre);
    }

    @Override
    public boolean edit(PreparedStatement pre) {
        return this.exe(pre);
    }

    @Override
    public boolean del(PreparedStatement pre) {
        return this.exe(pre);
    }

    @Override
    public ResultSet get(String sql, int value) {
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            if (value > 0) {
                pre.setInt(1, value);
            }
            return pre.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(BasicImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ResultSet get(String sql, String name, String pass) {
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setString(1, name);
            pre.setString(2, pass);

            return pre.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(BasicImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ResultSet gets(String sql) {
        return this.get(sql, 0);
    }

}
