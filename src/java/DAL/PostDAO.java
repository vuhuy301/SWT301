/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Comment;
import Model.Image;
import Model.Post;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDAO extends DBContext {

    public List<Post> getAllPost() {

        List<Post> list = new ArrayList<>();

        try {

            String sql = "SELECT [id]\n"
                    + "      ,[title]\n"
                    + "      ,[detail]\n"
                    + "      ,[link]\n"
                    + "      ,[createDate]\n"
                    + "      ,[updateDate]\n"
                    + "      ,[isPublished]\n"
                    + "      ,[like]\n"
                    + "      ,[view]\n"
                    + "      ,[ownerID]\n"
                    + "  FROM [dbo].[Post]\n"
                    + "  ORDER BY createDate DESC, [like] DESC, [view] DESC";

            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int postID = rs.getInt("id");

                Post p = new Post();
                p.setId(postID);
                p.setTitle(rs.getString("title"));
                p.setDetail(rs.getString("detail"));
                p.setUrl(rs.getString("link"));
                p.setCreateDate(rs.getDate("createDate"));
                p.setUpdateDate(rs.getDate("updateDate"));
                p.setPublished(rs.getBoolean("isPublished"));
                p.setLike(rs.getInt("like"));
                p.setView(rs.getInt("view"));
                p.setOwnerID(rs.getInt("ownerID"));

                List<Image> image = new ArrayList<>();
                String sql1 = "SELECT [id]\n"
                        + "      ,[title]\n"
                        + "      ,[url]\n"
                        + "      ,[createDate]\n"
                        + "      ,[updateDate]\n"
                        + "      ,[isActive]\n"
                        + "  FROM [dbo].[Post_Image]\n"
                        + "  WHERE pid = ?";

                PreparedStatement st1 = connection.prepareStatement(sql1);
                st1.setInt(1, postID);

                ResultSet rs1 = st1.executeQuery();

                while (rs1.next()) {
                    Image i = new Image();
                    i.setId(rs1.getInt("id"));
                    i.setTitle(rs1.getString("title"));
                    i.setUrl(rs1.getString("url"));
                    i.setPid(postID);
                    i.setCreateDate(rs1.getDate("createDate"));
                    i.setUpdateDate(rs1.getDate("updateDate"));
                    i.setActive(rs1.getBoolean("isActive"));

                    image.add(i);
                }

                p.setImage(image);

                list.add(p);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public List<Post> getXNewPost(int x) {

        List<Post> list = new ArrayList<>();

        try {

            String sql = "SELECT TOP(?) [id]\n"
                    + "      ,[title]\n"
                    + "      ,[detail]\n"
                    + "      ,[link]\n"
                    + "      ,[createDate]\n"
                    + "      ,[updateDate]\n"
                    + "      ,[isPublished]\n"
                    + "      ,[like]\n"
                    + "      ,[view]\n"
                    + "      ,[ownerID]\n"
                    + "  FROM [dbo].[Post]\n"
                    + "  ORDER BY createDate DESC, [like] DESC, [view] DESC";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, x);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int postID = rs.getInt("id");

                Post p = new Post();
                p.setId(postID);
                p.setTitle(rs.getString("title"));
                p.setDetail(rs.getString("detail"));
                p.setUrl(rs.getString("link"));
                p.setCreateDate(rs.getDate("createDate"));
                p.setUpdateDate(rs.getDate("updateDate"));
                p.setPublished(rs.getBoolean("isPublished"));
                p.setLike(rs.getInt("like"));
                p.setView(rs.getInt("view"));
                p.setOwnerID(rs.getInt("ownerID"));

                List<Image> image = new ArrayList<>();
                String sql1 = "SELECT [id]\n"
                        + "      ,[title]\n"
                        + "      ,[url]\n"
                        + "      ,[createDate]\n"
                        + "      ,[updateDate]\n"
                        + "      ,[isActive]\n"
                        + "  FROM [dbo].[Post_Image]\n"
                        + "  WHERE pid = ?";

                PreparedStatement st1 = connection.prepareStatement(sql1);
                st1.setInt(1, postID);

                ResultSet rs1 = st1.executeQuery();

                while (rs1.next()) {
                    Image i = new Image();
                    i.setId(rs1.getInt("id"));
                    i.setTitle(rs1.getString("title"));
                    i.setUrl(rs1.getString("url"));
                    i.setPid(postID);
                    i.setCreateDate(rs1.getDate("createDate"));
                    i.setUpdateDate(rs1.getDate("updateDate"));
                    i.setActive(rs1.getBoolean("isActive"));

                    image.add(i);
                }

                p.setImage(image);

                list.add(p);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public List<Post> getTopXPopularPost(int number) {
        List<Post> list = new ArrayList<>();

        try {

            String sql = "SELECT TOP(?) [id]\n"
                    + "      ,[title]\n"
                    + "      ,[detail]\n"
                    + "      ,[link]\n"
                    + "      ,[createDate]\n"
                    + "      ,[updateDate]\n"
                    + "      ,[isPublished]\n"
                    + "      ,[like]\n"
                    + "      ,[view]\n"
                    + "      ,[ownerID]\n"
                    + "  FROM [dbo].[Post]\n"
                    + "  ORDER BY [like] desc, [view] desc";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, number);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int postID = rs.getInt("id");

                Post p = new Post();
                p.setId(postID);
                p.setTitle(rs.getString("title"));
                p.setDetail(rs.getString("detail"));
                p.setUrl(rs.getString("link"));
                p.setCreateDate(rs.getDate("createDate"));
                p.setUpdateDate(rs.getDate("updateDate"));
                p.setPublished(rs.getBoolean("isPublished"));
                p.setLike(rs.getInt("like"));
                p.setView(rs.getInt("view"));
                p.setOwnerID(rs.getInt("ownerID"));

                List<Image> image = new ArrayList<>();
                String sql1 = "SELECT [id]\n"
                        + "      ,[title]\n"
                        + "      ,[url]\n"
                        + "      ,[createDate]\n"
                        + "      ,[updateDate]\n"
                        + "      ,[isActive]\n"
                        + "  FROM [dbo].[Post_Image]\n"
                        + "  WHERE pid = ?";

                PreparedStatement st1 = connection.prepareStatement(sql1);
                st1.setInt(1, postID);

                ResultSet rs1 = st1.executeQuery();

                while (rs1.next()) {
                    Image i = new Image();
                    i.setId(rs1.getInt("id"));
                    i.setTitle(rs1.getString("title"));
                    i.setUrl(rs1.getString("url"));
                    i.setPid(postID);
                    i.setCreateDate(rs1.getDate("createDate"));
                    i.setUpdateDate(rs1.getDate("updateDate"));
                    i.setActive(rs1.getBoolean("isActive"));

                    image.add(i);
                }

                p.setImage(image);

                list.add(p);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public Post getPostByID(int id) {
        try {

            String sql = "SELECT [id]\n"
                    + "      ,[title]\n"
                    + "      ,[detail]\n"
                    + "      ,[link]\n"
                    + "      ,[createDate]\n"
                    + "      ,[updateDate]\n"
                    + "      ,[isPublished]\n"
                    + "      ,[like]\n"
                    + "      ,[view]\n"
                    + "      ,[ownerID]\n"
                    + "  FROM [dbo].[Post]\n"
                    + "  WHERE id = ?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int postID = rs.getInt("id");

                Post p = new Post();
                p.setId(postID);
                p.setTitle(rs.getString("title"));
                p.setDetail(rs.getString("detail"));
                p.setUrl(rs.getString("link"));
                p.setCreateDate(rs.getDate("createDate"));
                p.setUpdateDate(rs.getDate("updateDate"));
                p.setPublished(rs.getBoolean("isPublished"));
                p.setLike(rs.getInt("like"));
                p.setView(rs.getInt("view"));
                p.setOwnerID(rs.getInt("ownerID"));

                List<Image> image = new ArrayList<>();
                String sql1 = "SELECT [id]\n"
                        + "      ,[title]\n"
                        + "      ,[url]\n"
                        + "      ,[createDate]\n"
                        + "      ,[updateDate]\n"
                        + "      ,[isActive]\n"
                        + "  FROM [dbo].[Post_Image]\n"
                        + "  WHERE pid = ?";

                PreparedStatement st1 = connection.prepareStatement(sql1);
                st1.setInt(1, postID);

                ResultSet rs1 = st1.executeQuery();

                while (rs1.next()) {
                    Image i = new Image();
                    i.setId(rs1.getInt("id"));
                    i.setTitle(rs1.getString("title"));
                    i.setUrl(rs1.getString("url"));
                    i.setPid(postID);
                    i.setCreateDate(rs1.getDate("createDate"));
                    i.setUpdateDate(rs1.getDate("updateDate"));
                    i.setActive(rs1.getBoolean("isActive"));

                    image.add(i);
                }

                p.setImage(image);

                return p;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Comment> getCommentByPostID(int id) {

        List<Comment> list = new ArrayList<>();

        try {

            String sql = "SELECT [id]\n"
                    + "      ,[content]\n"
                    + "      ,[createDate]\n"
                    + "      ,[updateDate]\n"
                    + "      ,[isPublished]\n"
                    + "      ,[pid]\n"
                    + "      ,[aid]\n"
                    + "  FROM [dbo].[Comment]\n"
                    + "  WHERE pid = ?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Comment c = new Comment();
                c.setId(rs.getInt("id"));
                c.setContent(rs.getString("content"));
                c.setCreateDate(rs.getDate("createDate"));
                c.setUpdateDate(rs.getDate("updateDate"));
                c.setPublished(rs.getBoolean("isPublished"));
                c.setPid(rs.getInt("pid"));
                c.setAid(rs.getInt("aid"));

                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Comment> getChildCommentByCommentID(int id) {

        List<Comment> list = new ArrayList<>();

        try {

            String sql = "SELECT	[id]\n"
                    + "      ,[content]\n"
                    + "      ,[createDate]\n"
                    + "      ,[updateDate]\n"
                    + "      ,[isPublished]\n"
                    + "      ,[pid]\n"
                    + "      ,[aid]\n"
                    + "  FROM [dbo].[Comment]\n"
                    + "  WHERE [parentID] = ?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Comment c = new Comment();
                c.setId(rs.getInt("id"));
                c.setContent(rs.getString("content"));
                c.setCreateDate(rs.getDate("createDate"));
                c.setUpdateDate(rs.getDate("updateDate"));
                c.setPublished(rs.getBoolean("isPublished"));
                c.setPid(rs.getInt("pid"));
                c.setAid(rs.getInt("aid"));

                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public boolean insertComment(Comment c) {
        try {

            String sql = "INSERT INTO [dbo].[Comment]	([content] ,[createDate] ,[updateDate] ,[isPublished] ,[pid] ,[aid])\n"
                    + "VALUES\n"
                    + "		(? ,? ,? ,? ,? ,?)";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getContent());
            st.setDate(2, c.getCreateDate());
            st.setDate(3, c.getUpdateDate());
            st.setBoolean(4, c.getPublished());
            st.setInt(5, c.getPid());
            st.setInt(6, c.getAid());
            
            st.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;

    }

    public List<Post> getListByPage(List<Post> list,
            int start, int end) {
        List<Post> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

}
