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
        Scanner scanner = new Scanner(System.in);
        try {
            String deliveryMode = prompt(scanner, "Delivery mode (ROAD or SEA): ");
            String uiPlatform = prompt(scanner, "UI platform (WINDOWS or MACOS): ");

            // Validate BOTH choices before creating anything.
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

    private static String prompt(Scanner scanner, String message) throws InvalidChoiceException {
        System.out.print(message);
        if (!scanner.hasNextLine()) {
            throw new InvalidChoiceException("Input is missing.");
        }
        return scanner.nextLine().trim();
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