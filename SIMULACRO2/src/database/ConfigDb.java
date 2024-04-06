package database;

import javax.swing.*;
import java.sql.*;

public class ConfigDb {

    public static Connection objConnection = null;

    public static Connection openConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String sql = "jdbc://bi82fbwai2upwwb9zqqc-mysql.services.clever-cloud.com:3306/bi82fbwai2upwwb9zqqc";
            String user = "uvlp1pwzdicqkmyd";
            String password = "TfgAnSv7fk1syLypOzJ1";

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
