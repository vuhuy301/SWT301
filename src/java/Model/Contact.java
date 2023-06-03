/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import java.sql.Time;

public class Contact {

    private int id;
    private String images;
    private String storeName;
    private String storeAddress;
    private String storePhone;
    private Time startWorking;
    private Time endWorking;
    private Date createDate;
    private boolean active;

    public Contact() {
    }

    public Contact(int id, String images, String storeName, String storeAddress, String storePhone, Time startWorking, Time endWorking, Date createDate, boolean active) {
        this.id = id;
        this.images = images;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storePhone = storePhone;
        this.startWorking = startWorking;
        this.endWorking = endWorking;
        this.createDate = createDate;
        this.active = active;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public Time getStartWorking() {
        return startWorking;
    }

    public void setStartWorking(Time startWorking) {
        this.startWorking = startWorking;
    }

    public Time getEndWorking() {
        return endWorking;
    }

    public void setEndWorking(Time endWorking) {
        this.endWorking = endWorking;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
