package model;

import database.*;
import entity.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class VueloModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDb.openConnection();
        Vuelo objVuelo = (Vuelo) obj;

        try {
            String sql = "INSERT INTO vuelo (destino, fecha_salida, hora_salida, fk_id_avion) VALUES (?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1,objVuelo.getDestino());
            objPrepare.setString(2,objVuelo.getFecha_salida());
            objPrepare.setString(3,objVuelo.getHora_salida());
            objPrepare.setInt(4,objVuelo.getFk_id_avion());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()){
                objVuelo.setId_vuelo(objResult.getInt(1));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }
        return objVuelo;
    }

    @Override
    public List<Object> findAll() {
        Connection objConnection = ConfigDb.openConnection();
        List<Object> listVuelos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM vuelo" +
                    " INNER JOIN avion ON vuelo.fk_id_avion = avion.id_avion;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Avion objAvion = new Avion(objResult.getInt("avion.id_avion"),
                        objResult.getString("avion.modelo"),
                        objResult.getInt("avion.capacidad"));

                Vuelo objVuelo = new Vuelo(objResult.getInt("vuelo.id_vuelo"),
                        objResult.getString("vuelo.destino"),
                        objResult.getString("vuelo.fecha_salida"),
                        objResult.getString("vuelo.hora_salida"),
                        objResult.getInt("vuelo.fk_id_avion"),objAvion);

                listVuelos.add(objVuelo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }
        return listVuelos;
    }

    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDb.openConnection();
        Vuelo objVuelo = (Vuelo) obj;
        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM vuelo WHERE id_vuelo = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,objVuelo.getId_vuelo());

            int totalRowsAffected = objPrepare.executeUpdate();

            if (totalRowsAffected > 0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null, "Fly delete finished");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }
        return isDeleted;
    }

    public static Vuelo instanceOf(Object obj){
        return (Vuelo) obj;
    }
    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDb.openConnection();
        boolean isUpdate = false;
        try {
            String sql = "UPDATE vuelo SET destino = ?, fecha_salida = ?, hora_salida = ?, fk_id_avion = ? WHERE id_vuelo = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,instanceOf(obj).getDestino());
            objPrepare.setString(2,instanceOf(obj).getFecha_salida());
            objPrepare.setString(3,instanceOf(obj).getHora_salida());
            objPrepare.setInt(4,instanceOf(obj).getFk_id_avion());
            objPrepare.setInt(5,instanceOf(obj).getId_vuelo());

            int totalRowsAffected = objPrepare.executeUpdate();

            if (totalRowsAffected > 0){
                isUpdate = true;
                JOptionPane.showMessageDialog(null,"Fly update finished");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }
        return isUpdate;
    }
}
