/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.object.equipment;

/**
 *
 * @author kieun
 */
public class EquipmentObject {
    private int equipment_id;
    private String equipment_name;
    private int equipment_amount;

    public int getDistributor_id() {
        return distributor_id;
    }

    public void setDistributor_id(int distributor_id) {
        this.distributor_id = distributor_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
    private int distributor_id;
    private int type_id;
    public EquipmentObject() {
    }
    public EquipmentObject(int equipment_id, String equipment_name, int equipment_amount, int distributor_id, int type_id) {
        this.equipment_id = equipment_id;
        this.equipment_name = equipment_name;
        this.equipment_amount = equipment_amount;
        this.distributor_id = distributor_id;
        this.type_id = type_id;
    }
    
    public int getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(int equipment_id) {
        this.equipment_id = equipment_id;
    }

    public String getEquipment_name() {
        return equipment_name;
    }

    public void setEquipment_name(String equipment_name) {
        this.equipment_name = equipment_name;
    }

    public int getEquipment_amount() {
        return equipment_amount;
    }

    public void setEquipment_amount(int equipment_amount) {
        this.equipment_amount = equipment_amount;
    }
}
