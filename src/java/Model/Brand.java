package Model;

import java.sql.Date;

public class Brand {

    private int id;
    private String name;
    private String location;
    private Date createDate;
    private Date updateDate;
    private Boolean active;

    public Brand() {
    }

    public Brand(int id, String name, String location, Date createDate, Date updateDate, Boolean active) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    
    


}
