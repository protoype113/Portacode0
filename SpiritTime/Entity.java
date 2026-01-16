public class Entity {

    // Variables
    private String name;
    private String id;

    // Workhorse Constructor 
    public Entity(String name, String id) {
        this.name = name;
        this.id = id;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getID() {
        return this.id;
    }
}