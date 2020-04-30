/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chinsu.object.basic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Windows 10
 */
public interface Basic {
    public boolean add(PreparedStatement pre);
    public boolean edit(PreparedStatement pre);
    public boolean del(PreparedStatement pre);
	
    public ResultSet get(String sql, int value);
    public ResultSet get(String sql, String name, String pass);
    public ResultSet gets(String sql);

}
