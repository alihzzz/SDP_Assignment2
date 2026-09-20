package ui;

public class MacOSFactory implements iGUIFactory{

    @Override
    public iButton createButton() {
        return new MacOSButton();
    }

    @Override
    public iCheckBox createCheckbox() {
        return new MacOSCheckBox();
    }
}
