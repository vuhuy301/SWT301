package Model;

import java.sql.Date;

public class Category {

    private int id;
    private String title;
    private Date createDate;
    private Date updateDate;
    private Boolean active;

    public Category() {
    }

    public Category(int id, String title, Date createDate, Date updateDate, Boolean active) {
        this.id = id;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Boolean getIsActive() {
        return active;
    }

    public void setIsActive(Boolean active) {
        this.active = active;
    }

}
