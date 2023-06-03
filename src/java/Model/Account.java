package Model;

import java.sql.Date;

public class Account {

    private int id;
    private String userName;
    private String password;
    private String email;
    private String address;
    private String firstName;
    private String lastName;
    private String phone;
    private Date birthday;
    private Date createDate;
    private Boolean block;
    private Boolean verify;
    private Role role;

    public Account() {
    }

    public Account(int id, String userName, String password, String email, String address, String firstName, String lastName, String phone, Date birthday, Date createDate, Boolean block, Boolean verify, Role role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.birthday = birthday;
        this.createDate = createDate;
        this.block = block;
        this.verify = verify;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getBlock() {
        return block;
    }

    public void setBlock(Boolean block) {
        this.block = block;
    }

    public Boolean getVerify() {
        return verify;
    }

    public void setVerify(Boolean verify) {
        this.verify = verify;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getIsBlock() {
        return block;
    }

    public void setIsBlock(Boolean block) {
        this.block = block;
    }

    public Boolean getIsVerify() {
        return verify;
    }

    public void setIsVerify(Boolean verify) {
        this.verify = verify;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    public String getFullName(){
        return firstName + " " + lastName;
    }
    

}
