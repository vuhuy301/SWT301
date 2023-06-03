package Model;

import java.sql.Date;

public class Role {

    private int id;
    private String title;
    private Date createDate;

    public Role() {
    }

    public Role(int id, String title, Date createDate) {
        this.id = id;
        this.title = title;
        this.createDate = createDate;
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
    
    

}
