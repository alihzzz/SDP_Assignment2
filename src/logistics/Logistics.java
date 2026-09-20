package logistics;

public abstract class Logistics {
    protected abstract iTransport createTransport();
    public void planDelivery(String cargo, String destination) {
        iTransport transport = createTransport();
        transport.deliver(cargo, destination);
    }
}