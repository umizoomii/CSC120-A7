import java.util.ArrayList;

public class House extends Building {
  
  ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
  boolean hasDiningRoom;
  boolean hasElevator;

    /*default constructor */
    public House() {
        this("<Name Unknown>", "<Address Unknown>", 1, false, false);
        residents = new ArrayList<String>();
        this.residents = residents;
    }

    /* Overloaded constructor with address only */
    public House(String address) {
        this(); // Call default constructor
        this.address = address; // Override address
        residents = new ArrayList<String>();
        this.residents = residents;
    }

    /* Overloaded constructor with name, address */
    public House(String name, String address) {
        this(name, address, 1, false, false); // Call full constructor with hard-coded # floors
        residents = new ArrayList<String>();
        this.residents = residents;
    }

    /* Full constructor */
    public House(String name, String address, int nFloors, boolean hasElevator, boolean hasDiningRoom) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
        this.hasElevator = hasElevator;
        this.hasDiningRoom = hasDiningRoom;
        residents = new ArrayList<String>();
        this.residents = residents;
    }

  /**
   * Accessor for if a house has a dining room
   * @return true if the house has a dining room, false if it doesn't
   */
  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  /**
   * Accessor for if a house has an elevator
   * @return true if the house has an elevator, false if it doesn't
   */
  public boolean hasElevator() {
    return hasElevator;
  }

  /**
   * Accessor for number of residents in house
   * @return the number of residents
   */
  public int nResidents() {
    return residents.size();
  }

  /**
   * adds a person to a house
   * @param name: the person moving in
   */
  public void moveIn(String name){
    if (residents.contains(name)) {
      System.out.println("Error: resident already in house");
    }
    else {
      residents.add(name);
    }
  }

  /**
   * removes a person from the house
   * @param name: person being removed
   * @return String: a message that the person moved out
   */
  public String moveOut(String name){
    if (residents.contains(name)) {
      residents.remove(name);
      return name + " moved out!";
    }
    else {
      return "Error: the resident doesn't live here!";
    }
  }

  /**
   * Indicates whether a person is a resident of the house
   * @param person: the person in question
   * @return boolean: true if resident, false if not
   */
  public boolean isResident(String person) {
    if (residents.contains(person)) {
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * toString method for Building class
   */
  public String toString() {
    return this.name + " is a " + this.nFloors + " floor residence hall located at " + this.address;
  }

  /**
   * Show options for house
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n ");
}

  public static void main(String[] args) {
    House myHouse = new House("Emerson", "1 Paradise Road", 4, true, true);
    myHouse.residents.add("Uma");
    myHouse.residents.add("Sofia");
    myHouse.residents.add("Zoe");
    myHouse.residents.add("Kate");
    myHouse.residents.add("Sarah");
    myHouse.residents.add("Delia");

    myHouse.showOptions();
    System.out.println("Residents: ");
    System.out.println(myHouse.residents);
    System.out.println(myHouse.moveOut("Delia"));
    System.out.println(myHouse.isResident("Delia"));

    myHouse.enter();
  }

}