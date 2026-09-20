package logistics;

public class RoadLogistics extends Logistics {
    @Override
    protected iTransport createTransport() {
        return new Truck();
    }
}