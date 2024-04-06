package controller;

import entity.Avion;

import javax.swing.*;
import static Utils.Utils.*;
import Utils.Utils;

public class AvionController {
    public static void create(){
        Avion objAvion = new Avion();
        try {
            String modelo = JOptionPane.showInputDialog("Insert model of flight");
            int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Insert capacity"));

            objAvion.setModelo(modelo);
            objAvion.setCapacidad(capacidad);

            instanceOfModelAvion().insert(objAvion);
            JOptionPane.showMessageDialog(null,objAvion.toString());
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public static void getAll(){
        String listAvion = "LIST FLIGHT\n";
        for (Object iterator:instanceOfModelAvion().findAll()){
            Avion objAvion = (Avion) iterator;
            listAvion += objAvion.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null,listAvion);
    }

    public static String getAllString(){
        String listAvion = "LIST FLIGHT\n";
        for (Object iterator:instanceOfModelAvion().findAll()){
            Avion objAvion = (Avion) iterator;
            listAvion += objAvion.toString() + "\n";
        }
        return listAvion;
    }

    public static void delete(){
        Object[] opcionesA = Utils.fromListToArray(instanceOfModelAvion().findAll());
        int isDelete = 1;
        Avion objAvion = (Avion) JOptionPane.showInputDialog(null,
                "Choose the flight to delete",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesA,
                opcionesA[0]);

        isDelete = JOptionPane.showConfirmDialog(null,"Are you sure to delete this flight?\n" + objAvion.toString());
        if (isDelete == 0){
            instanceOfModelAvion().delete(objAvion);
        }
    }

    public static void update(){
        Object[] opcionesA = Utils.fromListToArray(instanceOfModelAvion().findAll());
        Avion objAvion = (Avion) JOptionPane.showInputDialog(null,
                "Choose the flight to delete",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesA,
                opcionesA[0]);

        String modelo = JOptionPane.showInputDialog(null,"Insert model of flight",objAvion.getModelo());
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog(null,"Insert capacity",objAvion.getCapacidad()));

        objAvion.setModelo(modelo);
        objAvion.setCapacidad(capacidad);

        instanceOfModelAvion().update(objAvion);
    }
}
