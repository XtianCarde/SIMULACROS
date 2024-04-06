import controller.*;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String optionMain = "";
        do {
            optionMain = JOptionPane.showInputDialog("""
                    Choose the option to admin.
                    1. Passenger.
                    2. Fly.
                    3. Flight.
                    4. Book.
                    5. Exit.
                    """);
            switch (optionMain){

                case "1" -> {
                    String optionP = "";
                    do {
                        optionP = JOptionPane.showInputDialog("""
                                        1. create.
                                        2. Find.
                                        3. Delete.
                                        4. Update.
                                        5. Exit.
                                        """);
                        switch (optionP){
                            case "1" -> PasajeroController.create();
                            case "2" -> PasajeroController.getAll();
                            case "3" -> PasajeroController.delete();
                            case "4" -> PasajeroController.update();
                        }
                    } while (!optionP.equals("5"));
                }

                case "2" -> {
                    String optionFly = "";
                    do {
                        optionFly = JOptionPane.showInputDialog("""
                                        1. create.
                                        2. Find.
                                        3. Delete.
                                        4. Update.
                                        5. Exit.
                                        """);

                        switch (optionFly){
                            case "1" -> VueloController.create();
                            case "2" -> VueloController.findAll();
                            case "3" -> VueloController.delete();
                            case "4" -> VueloController.update();
                        }
                    }while (!optionFly.equals("5"));
                }

                case "3" -> {
                    String optionF = "";
                    do {
                        optionF = JOptionPane.showInputDialog("""
                                        1. create.
                                        2. Find.
                                        3. Delete.
                                        4. Update.
                                        5. Exit.
                                        """);

                        switch (optionF){
                            case "1" -> AvionController.create();
                            case "2" -> AvionController.getAll();
                            case "3" -> AvionController.delete();
                            case "4" -> AvionController.update();
                        }
                    } while (!optionF.equals("5"));
                }

                case "4" -> {
                    String optionBook = "";
                    do {
                        optionBook = JOptionPane.showInputDialog("""
                                            1. create.
                                            2. Find.
                                            3. Delete.
                                            4. Update.
                                            5. Exit.
                                            """);

                        switch (optionBook){
                            case "1" -> ReservaController.create();
                            case "2" -> ReservaController.getAll();
                            case "3" -> ReservaController.delete();
                            case "4" -> ReservaController.update();
                        }
                    } while (!optionBook.equals("5"));
                }
            }
        }while (!optionMain.equals("5"));
    }
}