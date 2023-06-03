package Model;

import java.sql.Date;

public class Specification {

    private int id;
    private String somethings;
    private Date createDate;
    private Date updateDate;
    private Boolean active;
    private int pid;

    public Specification() {
    }

    public Specification(int id, String somethings, Date createDate, Date updateDate, Boolean active, int pid) {
        this.id = id;
        this.somethings = somethings;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.active = active;
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSomethings() {
        return somethings;
    }

    public void setSomethings(String somethings) {
        this.somethings = somethings;
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

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

}
