/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.object.distributor;

/**
 *
 * @author kieun
 */
public class DistributorObject {
    private int distributor_id;
    private String distributor_name;
    private String distributor_address;
    private String distributor_phone;
    private int distributor_imamount;
    public DistributorObject() {
    }
    public DistributorObject(int distributor_id, String distributor_name, String distributor_address, String distributor_phone,int distributor_imamount) {
        this.distributor_id = distributor_id;
        this.distributor_name = distributor_name;
        this.distributor_address = distributor_address;
        this.distributor_phone = distributor_phone;
        this.distributor_imamount = distributor_imamount;
    }
    public int getDistributor_id() {
        return distributor_id;
    }
    public void setDistributor_id(int distributor_id) {
        this.distributor_id = distributor_id;
    }
    public String getDistributor_name() {
        return distributor_name;
    }
    public void setDistributor_name(String distributor_name) {
        this.distributor_name = distributor_name;
    }
    public String getDistributor_address() {
        return distributor_address;
    }
    public void setDistributor_address(String distributor_address) {
        this.distributor_address = distributor_address;
    }
    public String getDistributor_phone() {
        return distributor_phone;
    }
    public void setDistributor_phone(String distributor_phone) {
        this.distributor_phone = distributor_phone;
    }
    public int getDistributor_imamount() {
        return distributor_imamount;
    }
    public void setDistributor_imamount(int distributor_imamount) {
        this.distributor_imamount = distributor_imamount;
    }
}
