/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Brand;
import Model.Category;
import Model.Color;
import Model.Description;
import Model.Image;
import Model.Product;
import Model.Size;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends DBContext {

    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        try {

            String sql = "SELECT p.[id]\n"
                    + "      ,p.[sku]\n"
                    + "      ,p.[name] as 'productName' \n"
                    + "      ,p.[price]\n"
                    + "      ,p.[quantity]\n"
                    + "      ,p.[createDate]\n"
                    + "      ,p.[updateDate]\n"
                    + "      ,p.[isActive]\n"
                    + "      ,p.[cid]\n"
                    + "      ,p.[bid]\n"
                    + "	  ,c.[title] as 'category'\n"
                    + "      ,c.[createDate] as 'createDateCatogory'\n"
                    + "      ,c.[updateDate] as 'updateDateCatogory'\n"
                    + "      ,c.[isActive] as 'activeCategory'\n"
                    + "	  ,b.[name] as 'brandName' \n"
                    + "      ,b.[location]\n"
                    + "      ,b.[createDate] as 'createDateBrand'\n"
                    + "      ,b.[updateDate] as 'updateDateBrand'\n"
                    + "      ,b.[isActive] as 'activeBrand'\n"
                    + "	  ,d.[id] as 'did'\n"
                    + "      ,d.[content] as 'description'\n"
                    + "      ,d.[createDate] as 'createDateDescription'\n"
                    + "      ,d.[updateDate] as 'updateDateDescription'\n"
                    + "      ,d.[isActive] as 'activeDescription'\n"
                    + "  FROM [dbo].[Product] p inner join [dbo].[Category] c\n"
                    + "  on p.cid = c.id inner join [dbo].[Brand] b\n"
                    + "  on p.bid = b.id left join [dbo].[Description] d\n"
                    + "  on p.id = d.pid ";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");

                String sql1 = "SELECT [id]\n"
                        + "      ,[title]\n"
                        + "      ,[createDate]\n"
                        + "      ,[updateDate]\n"
                        + "      ,[isActive]\n"
                        + "  FROM [dbo].[Size] inner join [dbo].[Product_Size] ps\n"
                        + "  on ps.sid = id\n"
                        + "  WHERE ps.pid = ?";

                PreparedStatement ps1 = connection.prepareStatement(sql1);
                ps1.setInt(1, id);
                ResultSet rs1 = ps1.executeQuery();
                List<Size> size = new ArrayList<>();
//
                while (rs1.next()) {
                    size.add(new Size(rs1.getInt("id"), rs1.getString("title"), rs1.getDate("createDate"), rs1.getDate("updateDate"),
                            rs1.getBoolean("isActive")));
                }

                String sql2 = "SELECT [id]\n"
                        + "      ,[title]\n"
                        + "      ,[createDate]\n"
                        + "      ,[updateDate]\n"
                        + "      ,[isActive]\n"
                        + "  FROM [dbo].[Color] inner join [dbo].[Product_Color] pc\n"
                        + "  on pc.cid = id\n"
                        + "  WHERE pc.pid = ?";

                PreparedStatement ps2 = connection.prepareStatement(sql2);
                ps2.setInt(1, id);
                ResultSet rs2 = ps2.executeQuery();
                List<Color> color = new ArrayList<>();

                while (rs2.next()) {
                    color.add(new Color(rs2.getInt("id"), rs2.getString("title"), rs2.getDate("createDate"), rs2.getDate("updateDate"),
                            rs2.getBoolean("isActive")));
                }

                String sql3 = "SELECT [id]\n"
                        + "      ,[title]\n"
                        + "      ,[url]\n"
                        + "      ,[pid]\n"
                        + "      ,[createDate]\n"
                        + "      ,[updateDate]\n"
                        + "      ,[isActive]\n"
                        + "  FROM [dbo].[Product_Image]\n"
                        + "  WHERE pid = ?";

                PreparedStatement ps3 = connection.prepareStatement(sql3);
                ps3.setInt(1, id);
                ResultSet rs3 = ps3.executeQuery();
                List<Image> image = new ArrayList<>();

                while (rs3.next()) {
                    image.add(new Image(rs3.getInt("id"), rs3.getString("title"), rs3.getString("url"), rs3.getDate("createDate"),
                            rs3.getDate("updateDate"), rs3.getBoolean("isActive"), id));
                }

                Category category = new Category(rs.getInt("cid"), rs.getString("category"), rs.getDate("createDateCatogory"),
                        rs.getDate("updateDateCatogory"), rs.getBoolean("activeCategory"));

                Brand brand = new Brand(rs.getInt("bid"), rs.getString("brandName"), rs.getString("location"), rs.getDate("createDateBrand"),
                        rs.getDate("updateDateBrand"), rs.getBoolean("activeBrand"));

                Description description = new Description(rs.getInt("did"), rs.getString("description"), rs.getDate("updateDateBrand"),
                        rs.getDate("updateDateBrand"), rs.getBoolean("activeBrand"), id);

                list.add(new Product(id, rs.getString("sku"), rs.getString("productName"), rs.getDouble("price"), rs.getInt("quantity"),
                        rs.getDate("createDate"), rs.getDate("updateDate"), rs.getBoolean("isActive"), category, brand,
                        description, size, color, image));

            }
            return list;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Product getProductByID(int id) {
        try {

            String sql = "SELECT p.[id]\n"
                    + "      ,p.[sku]\n"
                    + "      ,p.[name] as 'productName' \n"
                    + "      ,p.[price]\n"
                    + "      ,p.[quantity]\n"
                    + "      ,p.[createDate]\n"
                    + "      ,p.[updateDate]\n"
                    + "      ,p.[isActive]\n"
                    + "      ,p.[cid]\n"
                    + "      ,p.[bid]\n"
                    + "	  ,c.[title] as 'category'\n"
                    + "      ,c.[createDate] as 'createDateCatogory'\n"
                    + "      ,c.[updateDate] as 'updateDateCatogory'\n"
                    + "      ,c.[isActive] as 'activeCategory'\n"
                    + "	  ,b.[name] as 'brandName' \n"
                    + "      ,b.[location]\n"
                    + "      ,b.[createDate] as 'createDateBrand'\n"
                    + "      ,b.[updateDate] as 'updateDateBrand'\n"
                    + "      ,b.[isActive] as 'activeBrand'\n"
                    + "	  ,d.[id] as 'did'\n"
                    + "      ,d.[content] as 'description'\n"
                    + "      ,d.[createDate] as 'createDateDescription'\n"
                    + "      ,d.[updateDate] as 'updateDateDescription'\n"
                    + "      ,d.[isActive] as 'activeDescription'\n"
                    + "  FROM [dbo].[Product] p inner join [dbo].[Category] c\n"
                    + "  on p.cid = c.id inner join [dbo].[Brand] b\n"
                    + "  on p.bid = b.id left join [dbo].[Description] d\n"
                    + "  on p.id = d.pid\n"
                    + "  WHERE p.id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String sql1 = "SELECT [id]\n"
                        + "      ,[title]\n"
                        + "      ,[createDate]\n"
                        + "      ,[updateDate]\n"
                        + "      ,[isActive]\n"
                        + "  FROM [dbo].[Size] inner join [dbo].[Product_Size] ps\n"
                        + "  on ps.sid = id\n"
                        + "  WHERE ps.pid = ?";

                PreparedStatement ps1 = connection.prepareStatement(sql1);
                ps1.setInt(1, id);
                ResultSet rs1 = ps1.executeQuery();
                List<Size> size = new ArrayList<>();
//
                while (rs1.next()) {
                    size.add(new Size(rs1.getInt("id"), rs1.getString("title"), rs1.getDate("createDate"), rs1.getDate("updateDate"),
                            rs1.getBoolean("isActive")));
                }

                String sql2 = "SELECT [id]\n"
                        + "      ,[title]\n"
                        + "      ,[createDate]\n"
                        + "      ,[updateDate]\n"
                        + "      ,[isActive]\n"
                        + "  FROM [dbo].[Color] inner join [dbo].[Product_Color] pc\n"
                        + "  on pc.cid = id\n"
                        + "  WHERE pc.pid = ?";

                PreparedStatement ps2 = connection.prepareStatement(sql2);
                ps2.setInt(1, id);
                ResultSet rs2 = ps2.executeQuery();
                List<Color> color = new ArrayList<>();

                while (rs2.next()) {
                    color.add(new Color(rs2.getInt("id"), rs2.getString("title"), rs2.getDate("createDate"), rs2.getDate("updateDate"),
                            rs2.getBoolean("isActive")));
                }

                String sql3 = "SELECT [id]\n"
                        + "      ,[title]\n"
                        + "      ,[url]\n"
                        + "      ,[pid]\n"
                        + "      ,[createDate]\n"
                        + "      ,[updateDate]\n"
                        + "      ,[isActive]\n"
                        + "  FROM [dbo].[Product_Image]\n"
                        + "  WHERE pid = ?";

                PreparedStatement ps3 = connection.prepareStatement(sql3);
                ps3.setInt(1, id);
                ResultSet rs3 = ps3.executeQuery();
                List<Image> image = new ArrayList<>();

                while (rs3.next()) {
                    image.add(new Image(rs3.getInt("id"), rs3.getString("title"), rs3.getString("url"), rs3.getDate("createDate"),
                            rs3.getDate("updateDate"), rs3.getBoolean("isActive"), id));
                }

                Category category = new Category(rs.getInt("cid"), rs.getString("category"), rs.getDate("createDateCatogory"),
                        rs.getDate("updateDateCatogory"), rs.getBoolean("activeCategory"));

                Brand brand = new Brand(rs.getInt("bid"), rs.getString("brandName"), rs.getString("location"), rs.getDate("createDateBrand"),
                        rs.getDate("updateDateBrand"), rs.getBoolean("activeBrand"));

                Description description = new Description(rs.getInt("did"), rs.getString("description"), rs.getDate("updateDateBrand"),
                        rs.getDate("updateDateBrand"), rs.getBoolean("activeBrand"), id);

                Product p = new Product(id, rs.getString("sku"), rs.getString("productName"), rs.getDouble("price"), rs.getInt("quantity"),
                        rs.getDate("createDate"), rs.getDate("updateDate"), rs.getBoolean("isActive"),
                         category, brand, description, size, color, image);

                return p;

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Product> getProductByCid(int[] cid) {
        List<Product> list = new ArrayList<>();
        try {

            String sql = "SELECT p.[id]\n"
                    + "      ,p.[sku]\n"
                    + "      ,p.[name] as 'productName' \n"
                    + "      ,p.[price]\n"
                    + "      ,p.[quantity]\n"
                    + "      ,p.[createDate]\n"
                    + "      ,p.[updateDate]\n"
                    + "      ,p.[isActive]\n"
                    + "      ,p.[cid]\n"
                    + "      ,p.[bid]\n"
                    + "	  ,c.[title] as 'category'\n"
                    + "      ,c.[createDate] as 'createDateCatogory'\n"
                    + "      ,c.[updateDate] as 'updateDateCatogory'\n"
                    + "      ,c.[isActive] as 'activeCategory'\n"
                    + "	  ,b.[name] as 'brandName' \n"
                    + "      ,b.[location]\n"
                    + "      ,b.[createDate] as 'createDateBrand'\n"
                    + "      ,b.[updateDate] as 'updateDateBrand'\n"
                    + "      ,b.[isActive] as 'activeBrand'\n"
                    + "	  ,d.[id] as 'did'\n"
                    + "      ,d.[content] as 'description'\n"
                    + "      ,d.[createDate] as 'createDateDescription'\n"
                    + "      ,d.[updateDate] as 'updateDateDescription'\n"
                    + "      ,d.[isActive] as 'activeDescription'\n"
                    + "  FROM [dbo].[Product] p inner join [dbo].[Category] c\n"
                    + "  on p.cid = c.id inner join [dbo].[Brand] b\n"
                    + "  on p.bid = b.id left join [dbo].[Description] d\n"
                    + "  on p.id = d.pid\n"
                    + "  WHERE 1 = 1 ";

            if (cid.length != 0) {
                sql += " AND p.cid IN (";
                for (int i = 0; i < cid.length; i++) {
                    if (i < cid.length - 1) {
                        sql += cid[i] + ", ";
                    } else {
                        sql += cid[i] + ")";
                    }
                }
            }

            System.out.println(sql);
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");

                String sql1 = "SELECT [id]\n"
                        + "      ,[title]\n"
                        + "      ,[createDate]\n"
                        + "      ,[updateDate]\n"
                        + "      ,[isActive]\n"
                        + "  FROM [dbo].[Size] inner join [dbo].[Product_Size] ps\n"
                        + "  on ps.sid = id\n"
                        + "  WHERE ps.pid = ?";

                PreparedStatement ps1 = connection.prepareStatement(sql1);
                ps1.setInt(1, id);
                ResultSet rs1 = ps1.executeQuery();
                List<Size> size = new ArrayList<>();
//
                while (rs1.next()) {
                    size.add(new Size(rs1.getInt("id"), rs1.getString("title"), rs1.getDate("createDate"), rs1.getDate("updateDate"),
                            rs1.getBoolean("isActive")));
                }

                String sql2 = "SELECT [id]\n"
                        + "      ,[title]\n"
                        + "      ,[createDate]\n"
                        + "      ,[updateDate]\n"
                        + "      ,[isActive]\n"
                        + "  FROM [dbo].[Color] inner join [dbo].[Product_Color] pc\n"
                        + "  on pc.cid = id\n"
                        + "  WHERE pc.pid = ?";

                PreparedStatement ps2 = connection.prepareStatement(sql2);
                ps2.setInt(1, id);
                ResultSet rs2 = ps2.executeQuery();
                List<Color> color = new ArrayList<>();

                while (rs2.next()) {
                    color.add(new Color(rs2.getInt("id"), rs2.getString("title"), rs2.getDate("createDate"), rs2.getDate("updateDate"),
                            rs2.getBoolean("isActive")));
                }

                String sql3 = "SELECT [id]\n"
                        + "      ,[title]\n"
                        + "      ,[url]\n"
                        + "      ,[pid]\n"
                        + "      ,[createDate]\n"
                        + "      ,[updateDate]\n"
                        + "      ,[isActive]\n"
                        + "  FROM [dbo].[Product_Image]\n"
                        + "  WHERE pid = ?";

                PreparedStatement ps3 = connection.prepareStatement(sql3);
                ps3.setInt(1, id);
                ResultSet rs3 = ps3.executeQuery();
                List<Image> image = new ArrayList<>();

                while (rs3.next()) {
                    image.add(new Image(rs3.getInt("id"), rs3.getString("title"), rs3.getString("url"), rs3.getDate("createDate"),
                            rs3.getDate("updateDate"), rs3.getBoolean("isActive"), id));
                }

                Category category = new Category(rs.getInt("cid"), rs.getString("category"), rs.getDate("createDateCatogory"),
                        rs.getDate("updateDateCatogory"), rs.getBoolean("activeCategory"));

                Brand brand = new Brand(rs.getInt("bid"), rs.getString("brandName"), rs.getString("location"), rs.getDate("createDateBrand"),
                        rs.getDate("updateDateBrand"), rs.getBoolean("activeBrand"));

                Description description = new Description(rs.getInt("did"), rs.getString("description"), rs.getDate("updateDateBrand"),
                        rs.getDate("updateDateBrand"), rs.getBoolean("activeBrand"), id);

                list.add(new Product(id, rs.getString("sku"), rs.getString("productName"), rs.getDouble("price"), rs.getInt("quantity"),
                        rs.getDate("createDate"), rs.getDate("updateDate"), rs.getBoolean("isActive"), category, brand,
                        description, size, color, image));

            }
            return list;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Product> getListByPage(List<Product> list,
            int start, int end) {
        List<Product> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }
}
