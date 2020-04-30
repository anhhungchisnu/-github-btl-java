/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.object.export;

/**
 *
 * @author kieun
 */
public class ExportObject {
    private int export_id;
    private int export_examount;
    private int customer_id;
    private int equipment_id;
    private String export_date;
    public ExportObject() {
    }
    public ExportObject(int export_id, int export_examount, int customer_id, int equipment_id, String export_date) {
        this.export_id = export_id;
        this.export_examount = export_examount;
        this.customer_id = customer_id;
        this.equipment_id = equipment_id;
        this.export_date = export_date;
    }  
    public int getExport_id() {
        return export_id;
    }
    public void setExport_id(int export_id) {
        this.export_id = export_id;
    }
    public int getExport_examount() {
        return export_examount;
    }
    public void setExport_examount(int export_examount) {
        this.export_examount = export_examount;
    }
    public int getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
    public int getEquipment_id() {
        return equipment_id;
    }
    public void setEquipment_id(int equipment_id) {
        this.equipment_id = equipment_id;
    }
    public String getExport_date() {
        return export_date;
    }
    public void setExport_date(String export_date) {
        this.export_date = export_date;
    }
}
