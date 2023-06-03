/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Order;
import Model.OrderLine;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends DBContext {

    public List<Order> getOrderByAccount(int id) {

        try {

            List<Order> listO = new ArrayList<Order>();

            String sql = "SELECT [id]\n"
                    + "      ,[price]\n"
                    + "      ,[status]\n"
                    + "      ,[createDate]\n"
                    + "      ,[firstName]\n"
                    + "      ,[lastName]\n"
                    + "      ,[email]\n"
                    + "      ,[address]\n"
                    + "      ,[phone]\n"
                    + "      ,[note]\n"
                    + "      ,[aid]\n"
                    + "  FROM [dbo].[Order]";

            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int oid = rs.getInt(1);

                String sql1 = "SELECT [olid]\n"
                        + "      ,[pid]\n"
                        + "      ,[quantity]\n"
                        + "      ,[price]\n"
                        + "      ,[size]\n"
                        + "      ,[color]\n"
                        + "  FROM [dbo].[OrderLine]\n"
                        + "  WHERE oid = ?";

                PreparedStatement st1 = connection.prepareStatement(sql1);
                st1.setInt(1, oid);

                ResultSet rs1 = st1.executeQuery();
                List<OrderLine> listOL = new ArrayList<>();

                while (rs1.next()) {
                    OrderLine ol = new OrderLine(rs1.getInt("olid"), oid, rs1.getInt("pid"), rs.getInt("quantity"), rs.getDouble("price"), rs.getString("size"), rs.getString("color"));
                    listOL.add(ol);
                }

                Order o = new Order(oid, rs.getDouble("price"), rs.getInt("status"), rs.getDate("createDate"), rs.getString("firstName")
                        , rs.getString("lastName"), rs.getString("email"), rs.getString("address"), rs.getString("phone"), rs.getString("note"), rs.getInt("aid"), listOL);
            
                listO.add(o);
            }

            return listO;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
