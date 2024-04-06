package model;

import database.*;
import entity.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
public class PasajeroModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDb.openConnection();
        Pasajero objPasajero = (Pasajero) obj;

        try {
            String sql = "INSERT INTO pasajero (nombre,apellido,doc_ide) VALUES (?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1,objPasajero.getNombre());
            objPrepare.setString(2,objPasajero.getApellido());
            objPrepare.setString(3,objPasajero.getDoc_iden());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()){
                objPasajero.setId_pasajero(objResult.getInt(1));
            }

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }
        return objPasajero;
    }

    @Override
    public List<Object> findAll() {
        Connection objConnection = ConfigDb.openConnection();
        List<Object> listPasajeros = new ArrayList<>();

        try {
            String sql = "SELECT * FROM pasajero;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Pasajero objPasajero = new Pasajero(objResult.getInt("id_pasajero"),
                        objResult.getString("nombre"),
                        objResult.getString("apellido"),
                        objResult.getString("doc_ide"));

                listPasajeros.add(objPasajero);
            }

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }
        return listPasajeros;
    }

    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDb.openConnection();
        Pasajero objPasajero = (Pasajero) obj;
        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM pasajero WHERE id_pasajero = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,objPasajero.getId_pasajero());

            int totalRowsAffected = objPrepare.executeUpdate();

            if (totalRowsAffected > 0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null,"Passenger delete finished ");
            }

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }

        return isDeleted;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDb.openConnection();
        Pasajero objPasajero = (Pasajero) obj;
        boolean isUpdated = false;
        try {
            String sql = "UPDATE pasajero SET nombre = ?, apellido = ?, doc_ide = ? WHERE  id_pasajero = ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objPasajero.getNombre());
            objPrepare.setString(2,objPasajero.getApellido());
            objPrepare.setString(3,objPasajero.getDoc_iden());
            objPrepare.setInt(4,objPasajero.getId_pasajero());

            int totalRowsAffected = objPrepare.executeUpdate();

            if (totalRowsAffected > 0) {
                isUpdated = true;
                JOptionPane.showMessageDialog(null,"Passenger update finished ");
            }

        }  catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }
        return isUpdated;
    }
}
