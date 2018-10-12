package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@InJdbc
@Dependent
public class JDBCGithuberDAO implements GithuberDAO  {
    @Inject
    private JDBCHelperWithDataSource jdbcHelperWithDataSource;

    @Override
    public List<Githuber> getGithubers()  {
        {
            //Connection connection = null; plus d'actualité avec le DATAPOOL
            PreparedStatement ps = null;
            ResultSet rs = null;
            List<Githuber> myList = new ArrayList<>();
            try {
                //connection = JDBCHelper.getConnection(); plus d'actualité avec le DATAPOOL
                ps = jdbcHelperWithDataSource.makeConnection().prepareStatement("SELECT github_id,name,login,url,email,bio,location,avatar_url FROM githuber;");
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
                throw new RuntimeException("pas de donnée dans la liste",e);
            }
            finally {
                try {
                    jdbcHelperWithDataSource.closeResultSet(rs);
                    jdbcHelperWithDataSource.closePrepaerdStatement(ps);
                    jdbcHelperWithDataSource.closeConnection(jdbcHelperWithDataSource.makeConnection());
                } catch (SQLException e) {
                    throw new RuntimeException("probléme de fermeture des instances",e);
                }
            }
            return myList;
        }

    }

    @Override
    public void saveGithuber(Githuber githuber) {
        //Connection connection = null;
        PreparedStatement ps = null;
        try {
            //connection = JDBCHelper.getConnection();
            ps = jdbcHelperWithDataSource.makeConnection().prepareStatement("INSERT INTO githuber(github_id,name,login,url,email,bio,location,avatar_url) VALUES(?,?,?,?,?,?,?,?)");
            ps.setInt(1, githuber.getId());
            ps.setString(2, githuber.getName());
            ps.setString(3, githuber.getLogin());
            ps.setString(4, githuber.getUrl());
            ps.setString(5, githuber.getEmail());
            ps.setString(6, githuber.getBio());
            ps.setString(7, githuber.getLocation());
            ps.setString(8, githuber.getAvatar());

            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException("utilisateur déjà dans la base",e);
        }
        finally {
            try {
                jdbcHelperWithDataSource.closePrepaerdStatement(ps);
                jdbcHelperWithDataSource.closeConnection(jdbcHelperWithDataSource.makeConnection());
            }catch (SQLException e) {
                throw new RuntimeException("probléme de fermeture des instances",e);
            }
        }

    }

    @Override
    public void deleteGithuber(int id_githuber) {
        //Connection connection = null;
        PreparedStatement ps = null;
        PreparedStatement ps1=null;
        ResultSet rs=null;

        try
        {
            //connection = JDBCHelper.getConnection();
            String SQL = "DELETE FROM githuber WHERE github_id=?;";
            String SQL2="SELECT * FROM githuber WHERE github_id="+id_githuber+";";
            ps1 = jdbcHelperWithDataSource.makeConnection().prepareStatement(SQL2);
            rs = ps1.executeQuery();
            if (rs!=null) {
                ps = jdbcHelperWithDataSource.makeConnection().prepareStatement(SQL);
                ps.setLong(1, id_githuber);
                ps.execute();
            }
        }
        catch ( SQLException e )
        {
            throw new RuntimeException("utilsateur inexistant",e);
        }
        finally
        {
            try
            {
                jdbcHelperWithDataSource.closePrepaerdStatement( ps );
                jdbcHelperWithDataSource.closePrepaerdStatement( ps1 );
                jdbcHelperWithDataSource.closeResultSet(rs);
                JDBCHelper.closeConnection(jdbcHelperWithDataSource.makeConnection() );
            }
            catch ( SQLException e ) {
                throw new RuntimeException("probléme de fermeture des instances",e);
            }
        }
    }
}



