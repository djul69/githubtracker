package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@InJdbc
@Dependent


public class JDBCGithuberDAO implements GithuberDAO  {

    @Override
    public List<Githuber> getGithubers() throws SQLException {
        {
            Connection connection = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            List<Githuber> myList = new ArrayList<>();
            try {
                connection = JDBCHelper.getConnection();
                if (connection == null) {
                    System.out.println("Error getting the connection. Please check if the DB server is running");
                    return myList;
                }
                ps = connection.prepareStatement("SELECT github_id,name,login,url,email,bio,location,avatar_url FROM githuber;");
                rs = ps.executeQuery();

                while (rs.next()) {
                    Githuber githuber = new Githuber();
                    githuber.setId(rs.getInt("github_id"));
                    githuber.setName(rs.getString("name"));
                    githuber.setLogin(rs.getString("login"));
                    githuber.setUrl(rs.getString("url"));
                    githuber.setEmail(rs.getString("email"));
                    githuber.setBio(rs.getString("bio"));
                    githuber.setLocation(rs.getString("location"));
                    githuber.setAvatar(rs.getString("avatar_url"));
                    myList.add(githuber);
                }
            } catch (SQLException e) {
                throw e;
            } finally {
                try {
                    JDBCHelper.closeResultSet(rs);
                    JDBCHelper.closePrepaerdStatement(ps);
                    JDBCHelper.closeConnection(connection);
                } catch (SQLException e) {
                    throw e;
                }
            }
            return myList;
        }

        }

        @Override
        public void saveGithuber(Githuber githuber) throws SQLException {
            Connection connection = null;
            PreparedStatement ps = null;
            try {
                connection = JDBCHelper.getConnection();
                if (connection == null) {
                    System.out.println("Error getting the connection. Please check if the DB server is running");
                    return;
                }
                connection.setAutoCommit(false);
                ps = connection.prepareStatement("INSERT INTO githuber(github_id,name,login,url,email,bio,location,avatar_url) VALUES(?,?,?,?,?,?,?,?)");
                ps.setInt(1, githuber.getId());
                ps.setString(2, githuber.getName());
                ps.setString(3, githuber.getLogin());
                ps.setString(4, githuber.getUrl());
                ps.setString(5, githuber.getEmail());
                ps.setString(6, githuber.getBio());
                ps.setString(7, githuber.getLocation());
                ps.setString(8, githuber.getAvatar());

                ps.execute();
                connection.commit();

            } catch (SQLException e) {
                try {
                    if (connection != null) {
                        connection.rollback();
                    }
                } catch (SQLException e1) {
                    throw e1;
                }
                throw e;
            } finally {
                try {
                    JDBCHelper.closePrepaerdStatement(ps);
                    JDBCHelper.closeConnection(connection);
                } catch (SQLException e) {
                    throw e;
                }
            }

        }
        @Override
        public void deleteGithuber(int id_githuber) throws SQLException {
            Connection connection = null;
            PreparedStatement ps = null;
            PreparedStatement ps1 = null;
            ResultSet rs = null;

            try
            {
                connection = JDBCHelper.getConnection();
                String SQL = "select * from gihuber where github_id="+id_githuber+"/'";
                ps1 = connection.prepareStatement(SQL);
                rs = ps1.executeQuery();
                if(rs!=null) {
                    ps = connection.prepareStatement("DELETE FROM githuber WHERE github_id=?;");
                    ps.setLong(1, id_githuber);
                    ps.execute();
                }else{}

            }
            catch ( SQLException e )
            {
                throw e;
            }

            finally
            {
                try
                {
                    JDBCHelper.closePrepaerdStatement( ps );
                    JDBCHelper.closeConnection( connection );
                }
                catch ( SQLException e )
                {
                    throw e;
                }
            }
        }
}


