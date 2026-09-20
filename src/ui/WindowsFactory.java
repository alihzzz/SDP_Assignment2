package ui;

public class WindowsFactory implements iGUIFactory {

    @Override
    public iButton createButton() {
        return new WindowsButton();
    }

    @Override
    public iCheckBox createCheckbox() {
        return new WindowsCheckBox();
    }
}

