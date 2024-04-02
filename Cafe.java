public class Cafe extends Building {

    private int nCoffeeOunces; 
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /* default constructor */
    public Cafe() {
        this("<Name Unknown>", "<Address Unknown>", 1, false);
    }

    /* Overloaded constructor with address only */
    public Cafe(String address) {
        this(); // Call default constructor
        this.address = address; // Override address
    }

    /* Overloaded constructor with name, address */
    public Cafe(String name, String address) {
        this(name, address, 1, false); // Call full constructor with hard-coded # floors
    }

    /* Full constructor */
    public Cafe(String name, String address, int nFloors, boolean hasElevator) {
        if (name != null) { 
            this.name = name; 
        }
        if (address != null) { 
            this.address = address; 
        } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
        this.hasElevator = hasElevator;
    }

    /**
     * Restocks the cafe's ingredients
     * @param addCoffeeOunces
     * @param addSugarPackets
     * @param addCreams
     * @param addCups
     */
    private void restock(int addCoffeeOunces, int addSugarPackets, int addCreams, int addCups) {
        nCoffeeOunces += addCoffeeOunces;
        nSugarPackets += addSugarPackets;
        nCreams += addCreams;
        nCups += addCups;
        System.out.println("Inventory restocked!");
    }

    /**
     * Removes ingredients from the inventory to "sell coffee"
     * @param size
     * @param sugars
     * @param creams
     */
    public void sellCoffee(int size, int sugars, int creams) {
        if (nCoffeeOunces >= size && nSugarPackets >= sugars && nCreams >= creams && nCups >= 1)  {
            nCoffeeOunces -= size;
            nSugarPackets -= sugars;
            nCreams -= creams;
            nCups -= 1;
            System.out.println(size + " ounce coffee with " + sugars + " sugars and " + creams + " creams " + "sold!");
        }
        else {
        restock(size, sugars, creams, 50);
        nCoffeeOunces -= size;
        nSugarPackets -= sugars;
        nCreams -= creams;
        nCups -= 1;
        System.out.println(size + " ounce coffee with " + sugars + " sugars and " + creams + " creams " + "sold!");
        }
    }

    /**
     * toString method for Cafe class
     */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story cafe located at " + this.address;
    }

    /**
     * Overriding the showOptions method from Building
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() ");
    }
    
    public static void main(String[] args) {
        Cafe compassCafe = new Cafe("Compass Cafe", "Smith campus", 1, false);
        compassCafe.sellCoffee(8, 2, 1);
        compassCafe.sellCoffee(8, 0, 0);
        compassCafe.sellCoffee(1000, 1002, 1000);
        System.out.println(compassCafe);
        compassCafe.showOptions();
        compassCafe.enter();

    }
    
}