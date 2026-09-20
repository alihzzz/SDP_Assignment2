package logistics;

public class Ship implements iTransport {

    @Override
    public void deliver(String cargo, String destination) {
        System.out.println("Ship sails with " + cargo + " to " + destination + " by sea");
    }
}