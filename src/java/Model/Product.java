package Model;

import java.sql.Date;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Product {

    private int id;
    private String sku;
    private String name;
    private double price;
    private int quantity;
    private Date createDate;
    private Date updateDate;
    private Boolean active;
    private Category category;
    private Brand brand;
    private Description description;
    private List<Size> size;
    private List<Color> color;
    private List<Image> image;

    public Product() {
    }

    public Product(int id, String sku, String name, double price, int quantity, Date createDate, Date updateDate, Boolean active, Category category, Brand brand, Description description, List<Size> size, List<Color> color, List<Image> image) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.active = active;
        this.category = category;
        this.brand = brand;
        this.description = description;
        this.size = size;
        this.color = color;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public List<Size> getSize() {
        return size;
    }

    public void setSize(List<Size> size) {
        this.size = size;
    }

    public List<Color> getColor() {
        return color;
    }

    public void setColor(List<Color> color) {
        this.color = color;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    public String getFormatPrice() {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localeVN);
        return vn.format(this.price);
    }
    
    public String getFormatPriceFake() {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localeVN);
        return vn.format(this.price * 1.3);
    }

}
