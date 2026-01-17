public class User {

    // Variables
    private String name;
    private Entity[] contained;

    public User(String name, Entity[] contained) {
        this.name = name;
        this.contained = contained;
    }

    public String getName() {
        return this.name;
    }

    public void listContained() {
        System.out.println("Contained Entities: ");
        for (Entity e : contained) {
            System.out.println(e.getID() + " : " + e.getName());
        }
    }
}