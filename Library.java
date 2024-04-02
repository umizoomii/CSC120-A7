import java.util.Hashtable;

public class Library extends Building {

  private Hashtable<String, Boolean> collection;


  //constructor
    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors, hasElevator);
      collection = new Hashtable<String, Boolean>();

      System.out.println("You have built a library: 📖");
      
    }
  
   /**
    * Adds a book to the library
    * @param title: the book's title
    */
    public void addTitle(String title) {
      collection.put(title, true);
    }

    /**
    * Removes a book from the library
    * @param title: the book's title
    */
    public String removeTitle(String title) {
      collection.remove(title);
      return title + "was removed";
    }

    /**
    * Checks out a book from the library
    * @param title: the book's title
    */
    public void checkOut(String title) {
      collection.replace(title, false);
    }

    /**
    * Returns a book to the library
    * @param title: the book's title
    */
    public void returnBook(String title) {
      collection.replace(title, true);
    }

    /**
    * Indicates if the library contains a specific title
    * @param title: the book's title
    * @return boolean: whether or not the library contains this title
    */
    public boolean containsTitle(String title) {
      if (collection.contains(title)) {
        return true;
      }
      else {
      return false;
      }
    }

    /**
    * Indicates if the book is available
    * @param title: the book's title
    * @return boolean: whether or not the book is available
    */
    public boolean isAvailable(String title) {
      if (collection.get(title)) {
        return true;
      }
      return false;
    }

    /**
    * Prints the library's collection and whether or not each book is available
    */
    public void printCollection() {
      System.out.println(collection.toString());
    }

    /**
     * Show options for library
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + checkOut(title)\n + returnBook(title)");
    }



    /**
     * Main method
     * @param args
     */

    public static void main(String[] args) {
      Library nielsonLibrary = new Library("Nielson Library", "Smith Campus", 4, true);
      System.out.println(nielsonLibrary);
      nielsonLibrary.addTitle("Middlemarch by George Eliot");
      nielsonLibrary.addTitle("Earthlings by Sayaka Murata");
      nielsonLibrary.addTitle("Autobiography of Angela Davis");

      nielsonLibrary.checkOut("Earthlings by Sayaka Murata");
      System.out.println(nielsonLibrary.isAvailable("Autobiography of Angela Davis"));
      nielsonLibrary.printCollection();
      nielsonLibrary.enter();
      nielsonLibrary.goToFloor(4);
      nielsonLibrary.showOptions();
    }
  
  }
