package fr.wildcodeschool.githubtracker.dao;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@ApplicationScoped
public class JDBCHelperWithDataSource {
    @Resource(lookup = "jdbc/githuber")
    private DataSource dataSource;

    public Connection makeConnection() {
        try {
            Connection connection = dataSource.getConnection();
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("connection non établie",e);
        }
    }
    public  void closeConnection( Connection con ) throws SQLException
    {
        if ( con != null )
        {
            con.close();
        }
    }

    public  void closePrepaerdStatement( PreparedStatement stmt ) throws SQLException
    {
        if ( stmt != null )
        {
            stmt.close();
        }
    }

    public  void closeResultSet( ResultSet rs ) throws SQLException
    {
        if ( rs != null )
        {
            rs.close();
        }
    }
}
