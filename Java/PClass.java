public class PClass {

    private char name;
    private int age;
    private boolean legal;

    // Constructor
    public PClass() {
        this.name = (char) ((int)(Math.random()*26));
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