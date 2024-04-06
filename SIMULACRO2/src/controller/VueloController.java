package controller;

import Utils.Utils;
import entity.Avion;
import entity.Vuelo;

import javax.swing.*;
import static Utils.Utils.*;

public class VueloController {
    public static void create(){
        Object[] opcionA = Utils.fromListToArray(instanceOfModelAvion().findAll());
        String destino = JOptionPane.showInputDialog(null,"Ingresa el destino");
        String fecha_salida = JOptionPane.showInputDialog(null,"Ingresa fecha de salida en el formato YYYY-MM-DD");
        String hora_salida = JOptionPane.showInputDialog(null,"Ingresa la hora de salida en el formato HH:MM:SS");
        Avion objAvion = (Avion) JOptionPane.showInputDialog(null,
                "Selecciona el avion",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionA,
                opcionA[0]);
        int fk_id_avion = objAvion.getId_avion();

        Vuelo objVuelo = new Vuelo();
        objVuelo.setDestino(destino);
        objVuelo.setFecha_salida(fecha_salida);
        objVuelo.setHora_salida(hora_salida);
        objVuelo.setFk_id_avion(fk_id_avion);
        objVuelo.setAvion(objAvion);

        instanceOfModelVuelo().insert(objVuelo);
        JOptionPane.showMessageDialog(null,objVuelo.toString());
    }

    public static void findAll(){
        String listVuelos = "FLY LIST\n";
        for (Object iterator: instanceOfModelVuelo().findAll()){
            Vuelo objVuelo = (Vuelo) iterator;
            listVuelos += objVuelo.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null,listVuelos);
    }

    public static String findAllString(){
        String listVuelos = "FLY LIST\n";
        for (Object iterator: instanceOfModelVuelo().findAll()){
            Vuelo objVuelo = (Vuelo) iterator;
            listVuelos += objVuelo.toString() + "\n";
        }
        return listVuelos;
    }

    public static void delete(){
        Object[] optionV = Utils.fromListToArray(instanceOfModelAvion().findAll());
        int isDeleted = 1;
        Vuelo objVuelo = (Vuelo) JOptionPane.showInputDialog(null,
                "Selecciona el vuelo a eliminar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionV,
                optionV[0]);

        isDeleted = JOptionPane.showConfirmDialog(null,"Are you sure to delete this fly?\n" + objVuelo.toString());
        if (isDeleted == 0){
            instanceOfModelVuelo().delete(objVuelo);
        }
    }

    public static void update(){
        Object[] optionV = Utils.fromListToArray(instanceOfModelAvion().findAll());
        Object[] opcionA = Utils.fromListToArray(instanceOfModelAvion().findAll());
        Vuelo objVuelo = (Vuelo) JOptionPane.showInputDialog(null,
                "Choose the fly to update",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionV,
                optionV[0]);


        String destino = JOptionPane.showInputDialog(null,"Ingresa el destino",objVuelo.getDestino());
        String fecha_salida = JOptionPane.showInputDialog(null,"Ingresa fecha de salida en el formato YYYY-MM-DD",objVuelo.getFecha_salida());
        String hora_salida = JOptionPane.showInputDialog(null,"Ingresa la hora de salida en el formato HH:MM:SS",objVuelo.getHora_salida());
        Avion objAvion = (Avion) JOptionPane.showInputDialog(null,
                "Selecciona el avion",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionA,
                objVuelo.getAvion());
        int fk_id_avion = objAvion.getId_avion();


        objVuelo.setDestino(destino);
        objVuelo.setFecha_salida(fecha_salida);
        objVuelo.setHora_salida(hora_salida);
        objVuelo.setFk_id_avion(fk_id_avion);
        objVuelo.setAvion(objAvion);

        instanceOfModelVuelo().update(objVuelo);
    }
}
