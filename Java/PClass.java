public class PClass {

    private String name;
    private int age;
    private boolean legal;
    private String[] names = {"Alice", "Benjamin", "Chloe", "Daniel", "Elena", "Franklin", "Grace", "Henry", "Isabella", "Jack", "Katherine", "Liam", "Mia", "Noah", "Olivia", "Penelope", "Quinn", "Ryan", "Sophia", "Thomas", "Uma", "Victor", "Willow", "Xavier", "Yasmine", "Zachary"};

    // Constructor
    public PClass() {
        this.name = names[((int)(Math.random()*26))];
        this.age = (int)(Math.random()*100);
        this.legal = (this.age >= 21);
    }

    // Getters
    public void getName() {
        System.out.println(this.name);
    }
    
    public void getAge() {
        System.out.println(this.age);
    }
    public void getLegal() {
        System.out.println(this.legal);
    }
}