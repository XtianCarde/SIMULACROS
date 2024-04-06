package database;

import javax.swing.*;
import java.sql.*;

public class ConfigDb {

    public static Connection objConnection = null;

    public static Connection openConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String sql = "jdbc:mysql://localhost:3306/simulacro2";
            String user = "root";
            String password = "MySQLDataBase*77";

            objConnection = DriverManager.getConnection(sql,user,password);

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return objConnection;
    }

    public static void closeConnection(){
        try {
            if (objConnection != null){
                objConnection.close();
            }else {
                JOptionPane.showMessageDialog(null,"NO HAY BASES DE DATOS ABIERTAS");
            }

        } catch (SQLException e){
            e.getMessage();
        }
    }
}
