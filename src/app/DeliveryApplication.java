package app;

import logistics.Logistics;
import ui.iButton;
import ui.iCheckBox;
import ui.iGUIFactory;

public class DeliveryApplication {

    private final iGUIFactory guiFactory;
    private final Logistics logistics;

    public DeliveryApplication(iGUIFactory guiFactory, Logistics logistics) {
        this.guiFactory = guiFactory;
        this.logistics = logistics;
    }

    public void run(String cargo, String destination) {
        renderUserInterface();
        logistics.planDelivery(cargo, destination);
    }

    private void renderUserInterface() {
        iButton button = guiFactory.createButton();
        iCheckBox checkbox = guiFactory.createCheckbox();
        button.paint();
        checkbox.paint();
    }
}