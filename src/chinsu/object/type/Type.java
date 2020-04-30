/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.object.type;

import java.sql.ResultSet;

/**
 *
 * @author kieun
 */
public interface Type {
    //cac chuc nag cap nhat
    public boolean addType (TypeObject item);
    public boolean editType (TypeObject item);
    public boolean delType (TypeObject item);
    
    //cac chuc nang lay du lieu
    public ResultSet getType(int id);
    public ResultSet getTypes();
}
