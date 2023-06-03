/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Account;
import Model.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO extends DBContext {

    public Account login(String userName, String password) {
        try {

            String sql = "SELECT a.[id]\n"
                    + "      ,a.[userName]\n"
                    + "      ,a.[password]\n"
                    + "      ,a.[email]\n"
                    + "      ,a.[address]\n"
                    + "      ,a.[firstName]\n"
                    + "      ,a.[lastName]\n"
                    + "      ,a.[phone]\n"
                    + "      ,a.[birthday]\n"
                    + "      ,a.[createDate]\n"
                    + "      ,a.[isBlock]\n"
                    + "      ,a.[isVerify]\n"
                    + "      ,a.[rid]\n"
                    + "	     ,r.[title] as 'role'\n"
                    + "      ,r.[createDate] as 'createDate_Role'\n"
                    + "  FROM [dbo].[Account] a inner join [dbo].[Role] r\n"
                    + "  ON a.rid = r.id\n"
                    + "  WHERE a.userName = ? and a.password = ?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, userName);
            st.setString(2, Common.convertPassToMD5(password));

            ResultSet rs = st.executeQuery();

            if (rs.next()) {

                Role role = new Role(rs.getInt("rid"), rs.getString("role"), rs.getDate("createDate_Role"));

                return new Account(rs.getInt("id"), rs.getString("userName"), rs.getString("password"), rs.getString("email"), rs.getString("address"),
                        rs.getString("firstName"), rs.getString("lastName"), rs.getString("phone"), rs.getDate("birthday"), rs.getDate("createDate"),
                        rs.getBoolean("isBlock"), rs.getBoolean("isVerify"),
                        role);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean update(Account a) {
        try {

            String sql = "UPDATE [dbo].[Account]\n"
                    + "   SET [firstName] = ?\n"
                    + "      ,[lastName] = ?\n"
                    + "      ,[address] = ?\n"
                    + "      ,[phone] = ?\n"
                    + "      ,[birthday] = ?\n"
                    + " WHERE [id] = ?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getFirstName());
            st.setString(2, a.getLastName());
            st.setString(3, a.getAddress());
            st.setString(4, a.getPhone());
            st.setDate(5, a.getBirthday());
            st.setInt(6, a.getId());

            st.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    public boolean changePass(Account a) {
        try {

            String sql = "UPDATE [dbo].[Account]\n"
                    + "   SET [password] = ?\n"
                    + " WHERE [id] = ?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, Common.convertPassToMD5(a.getPassword()));
            st.setInt(2, a.getId());

            st.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    public boolean checkExist(String userName) {
        try {

            String sql = "SELECT a.[userName]\n"
                    + "    FROM [dbo].[Account] a\n"
                    + "     WHERE a.userName = ?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, userName);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean checkEmailExit(String email) {
        try {

            String sql = "SELECT a.[email]\n"
                    + "    FROM [dbo].[Account] a\n"
                    + "     WHERE a.email = ?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean register(Account a) {
        try {

            String sql = "INSERT INTO [dbo].[Account] ([userName], [password] , [email] , [firstName] , [lastName] , [address] , [phone] , [birthday] , [createDate] , [isBlock] , [isVerify] , [rid])\n"
                    + "VALUES\n"
                    + "		(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getUserName());
            st.setString(2, Common.convertPassToMD5(a.getPassword()));
            st.setString(3, a.getEmail());
            st.setString(4, a.getFirstName());
            st.setString(5, a.getLastName());
            st.setString(6, a.getAddress());
            st.setString(7, a.getPhone());
            st.setDate(8, a.getBirthday());
            st.setDate(9, a.getCreateDate());
            st.setBoolean(10, false);
            st.setBoolean(11, false);
            st.setInt(12, 2);

            st.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println(e + "hihi");
        }
        return false;
    }

    public boolean saveOTP(String code, String type, String email) {
        try {

            String sql = "INSERT INTO [dbo].[OTP] ([code] ,[type] ,[email] ,[createDate] ,[isActive])\n"
                    + "VALUES	(? ,? ,? ,? ,?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, code);
            ps.setString(2, type);
            ps.setString(3, email);
            ps.setDate(4, Common.getCurrentDate());
            ps.setBoolean(5, true);

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public void deActiveCodeLast(int id) {
        try {

            String sql = "UPDATE [dbo].[OTP] SET [isActive] = 0\n"
                    + " WHERE id = ?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int getLastOTPByEmail(String email) {
        try {

            String sql = "SELECT TOP(1) [id] FROM [dbo].[OTP] WHERE email = ? ORDER BY id DESC";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return -1;
    }

    public String getLastOTPCodeByEmail(String email) {
        try {

            String sql = "SELECT TOP(1) [code] FROM [dbo].[OTP] WHERE email = ? and isActive = 1 ORDER BY id DESC";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return rs.getString(1);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return "";
    }

    public boolean verifyAccount(String email) {
        try {

            String sql = "UPDATE [dbo].[Account]\n"
                    + "   SET [isVerify] = 1\n"
                    + " WHERE [email] = ?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);

            st.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    public Account getAccountByEmail(String email) {
        try {

            String sql = "SELECT a.[id]\n"
                    + "      ,a.[userName]\n"
                    + "      ,a.[password]\n"
                    + "      ,a.[email]\n"
                    + "      ,a.[address]\n"
                    + "      ,a.[firstName]\n"
                    + "      ,a.[lastName]\n"
                    + "      ,a.[phone]\n"
                    + "      ,a.[birthday]\n"
                    + "      ,a.[createDate]\n"
                    + "      ,a.[isBlock]\n"
                    + "      ,a.[isVerify]\n"
                    + "      ,a.[rid]\n"
                    + "	     ,r.[title] as 'role'\n"
                    + "      ,r.[createDate] as 'createDate_Role'\n"
                    + "  FROM [dbo].[Account] a inner join [dbo].[Role] r\n"
                    + "  ON a.rid = r.id\n"
                    + "  WHERE a.email = ?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {

                Role role = new Role(rs.getInt("rid"), rs.getString("role"), rs.getDate("createDate_Role"));

                return new Account(rs.getInt("id"), rs.getString("userName"), rs.getString("password"), rs.getString("email"), rs.getString("address"),
                        rs.getString("firstName"), rs.getString("lastName"), rs.getString("phone"), rs.getDate("birthday"), rs.getDate("createDate"),
                        rs.getBoolean("isBlock"), rs.getBoolean("isVerify"),
                        role);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Account getAccountByID(int id) {
        try {

            String sql = "SELECT a.[id]\n"
                    + "      ,a.[userName]\n"
                    + "      ,a.[password]\n"
                    + "      ,a.[email]\n"
                    + "      ,a.[address]\n"
                    + "      ,a.[firstName]\n"
                    + "      ,a.[lastName]\n"
                    + "      ,a.[phone]\n"
                    + "      ,a.[birthday]\n"
                    + "      ,a.[createDate]\n"
                    + "      ,a.[isBlock]\n"
                    + "      ,a.[isVerify]\n"
                    + "      ,a.[rid]\n"
                    + "	     ,r.[title] as 'role'\n"
                    + "      ,r.[createDate] as 'createDate_Role'\n"
                    + "  FROM [dbo].[Account] a inner join [dbo].[Role] r\n"
                    + "  ON a.rid = r.id\n"
                    + "  WHERE a.id = ?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {

                Role role = new Role(rs.getInt("rid"), rs.getString("role"), rs.getDate("createDate_Role"));

                return new Account(rs.getInt("id"), rs.getString("userName"), rs.getString("password"), rs.getString("email"), rs.getString("address"),
                        rs.getString("firstName"), rs.getString("lastName"), rs.getString("phone"), rs.getDate("birthday"), rs.getDate("createDate"),
                        rs.getBoolean("isBlock"), rs.getBoolean("isVerify"),
                        role);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

}
