public class Entity {

    // Variables
    private String name;
    private String id;
    private Entity prev;
    private Entity next;

    // Workhorse Constructor 
    public Entity(String name, String id) {
        this.name = name;
        this.id = id;
        prev = null;
        next = null;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getID() {
        return this.id;
    }

    // Setters
    public void setPrev(Entity ent) {
        this. prev = ent;
    }

    public void setNext(Entity ent) {
        this.next = ent;
    }
}