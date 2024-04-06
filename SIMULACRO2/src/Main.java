import controller.ReservaController;

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
                case "4" -> {
                    String optionBook = "";
                    do {
                        optionBook = JOptionPane.showInputDialog("""
                                1. create.
                                2. Find.
                                3. Delete.
                                4. Update.
                                """);

                        switch (optionBook){
                            case "1" -> ReservaController.create();
                        }
                    } while (!optionBook.equals("5"));
                }
            }
        }while (!optionMain.equals("5"));
    }
}