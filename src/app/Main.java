package app;

import java.util.Scanner;

import logistics.Logistics;
import logistics.RoadLogistics;
import logistics.SeaLogistics;
import ui.iGUIFactory;
import ui.MacOSFactory;
import ui.WindowsFactory;

public class Main {

    private static final String CARGO = "laboratory equipment";
    private static final String DESTINATION = "Aktau warehouse";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String deliveryMode = prompt(sc, "Delivery mode (ROAD or SEA): ");
            String uiPlatform = prompt(sc, "UI platform (WINDOWS or MACOS): ");

            Logistics logistics = selectLogistics(deliveryMode);
            iGUIFactory guiFactory = selectGuiFactory(uiPlatform);

            System.out.println("Delivery mode: " + deliveryMode);
            System.out.println("UI platform: " + uiPlatform);
            new DeliveryApplication(guiFactory, logistics).run(CARGO, DESTINATION);
        } catch (InvalidChoiceException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

    private static String prompt(Scanner sc, String message) throws InvalidChoiceException {
        System.out.print(message);
        if (!sc.hasNextLine()) {
            throw new InvalidChoiceException("Input is missing.");
        }
        return sc.nextLine().trim();
    }

    private static Logistics selectLogistics(String deliveryMode) throws InvalidChoiceException {
        switch (deliveryMode) {
            case "ROAD":
                return new RoadLogistics();
            case "SEA":
                return new SeaLogistics();
            case "":
                throw new InvalidChoiceException("Delivery mode is missing. Use ROAD or SEA.");
            default:
                throw new InvalidChoiceException(
                        "Unsupported delivery mode '" + deliveryMode + "'. Use ROAD or SEA.");
        }
    }

    private static iGUIFactory selectGuiFactory(String uiPlatform) throws InvalidChoiceException {
        switch (uiPlatform) {
            case "WINDOWS":
                return new WindowsFactory();
            case "MACOS":
                return new MacOSFactory();
            case "":
                throw new InvalidChoiceException("UI platform is missing. Use WINDOWS or MACOS.");
            default:
                throw new InvalidChoiceException(
                        "Unsupported UI platform '" + uiPlatform + "'. Use WINDOWS or MACOS.");
        }
    }
}