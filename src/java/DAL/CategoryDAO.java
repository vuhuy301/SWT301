/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends DBContext {

    public List<Category> getAll() {

        List<Category> list = new ArrayList<>();
        try {

            String sql = "SELECT [id]\n"
                    + "      ,[title]\n"
                    + "      ,[createDate]\n"
                    + "      ,[updateDate]\n"
                    + "      ,[isActive]\n"
                    + "  FROM [dbo].[Category]";

            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                list.add(new Category(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getBoolean(5)));

            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
