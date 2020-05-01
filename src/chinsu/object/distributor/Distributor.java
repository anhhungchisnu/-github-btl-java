/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.object.distributor;

import java.sql.ResultSet;

/**
 *
 * @author kieun
 */
public interface Distributor {
    public boolean addDistributor (DistributorObject item);
    public boolean editDistributor (DistributorObject item);
    public boolean delDistributor (DistributorObject item);
    
    public ResultSet getDistributor (int id);
    public ResultSet getDistributors();
}
