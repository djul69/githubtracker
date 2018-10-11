package fr.wildcodeschool.githubtracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe pour ouvrir et fermer le
 */
public class JDBCHelper
{
   private static Connection connection;

 /*  static      Plus d'actualité avec le DATAPOOL
   {
      try
      {
         Class.forName( JDBCConstants.DRIVER_NAME );
      }
      catch ( ClassNotFoundException e )
      {
         System.out.println( "Driver class not found" );
      }
   }

   public static Connection getConnection() throws SQLException
   {
      connection = DriverManager.getConnection( JDBCConstants.URL, JDBCConstants.USER, JDBCConstants.PASS );
      return connection;
   }*/

   public static void closeConnection( Connection con ) throws SQLException
   {
      if ( con != null )
      {
         con.close();
      }
   }

   public static void closePrepaerdStatement( PreparedStatement stmt ) throws SQLException
   {
      if ( stmt != null )
      {
         stmt.close();
      }
   }

   public static void closeResultSet( ResultSet rs ) throws SQLException
   {
      if ( rs != null )
      {
         rs.close();
      }
   }

}
