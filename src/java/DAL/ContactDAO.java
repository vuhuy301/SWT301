/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Contact;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO extends DBContext {

    public List<Contact> getAll() {

        List<Contact> list = new ArrayList<>();

        try {

            String sql = "SELECT [id]\n"
                    + "      ,[images]\n"
                    + "      ,[storeName]\n"
                    + "      ,[stoerAddress]\n"
                    + "      ,[storePhone]\n"
                    + "      ,[startWorking]\n"
                    + "      ,[endWorking]\n"
                    + "      ,[createDate]\n"
                    + "      ,[isActive]\n"
                    + "  FROM [dbo].[Contact]\n"
                    + "  WHERE [isActive] = 1";

            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                list.add(new Contact(rs.getInt("id"), rs.getString("images"), rs.getString("storeName"), rs.getString("stoerAddress")
                        , rs.getString("storePhone"), rs.getTime("startWorking"), rs.getTime("endWorking"), rs.getDate("createDate")
                        , rs.getBoolean("isActive")));

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
}
