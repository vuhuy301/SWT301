package Model;

import java.sql.Date;

public class Image {

    private int id;
    private String title;
    private String url;
    private Date createDate;
    private Date updateDate;
    private Boolean active;
    private int pid;

    public Image() {
    }

    public Image(int id, String title, String url, Date createDate, Date updateDate, Boolean active, int pid) {
        this.id = id;
        this.title = title;
        this.url = url;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
