package logistics;

public class SeaLogistics extends Logistics {

    @Override
    protected iTransport createTransport() {
        return new Ship();
    }
}