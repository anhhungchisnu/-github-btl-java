/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.object.customer;

/**
 *
 * @author kieun
 */
public class CustomerObject {
    private int customer_id;
    private String customer_name;
    private int customer_age;
    private String customer_address;
    private String customer_phone;
    public CustomerObject() {
    }
    public CustomerObject(int customer_id, String customer_name, int customer_age, String customer_address, String customer_phone) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_age = customer_age;
        this.customer_address = customer_address;
        this.customer_phone = customer_phone;
    }  
    public int getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
    public String getCustomer_name() {
        return customer_name;
    }
    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }
    public int getCustomer_age() {
        return customer_age;
    }
    public void setCustomer_age(int customer_age) {
        this.customer_age = customer_age;
    }
    public String getCustomer_address() {
        return customer_address;
    }
    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }
    public String getCustomer_phone() {
        return customer_phone;
    }
    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }
}
