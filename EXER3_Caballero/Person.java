public class Person {
    private String name;
    private int age;
    private String personId;

    // Default constructor
    public Person() {
    }

    // Parameterized constructor
    public Person(String name, int age, String personId) {
        this.name = name;
        this.age = age;
        this.personId = personId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter for personId
    public String getPersonId() {
        return personId;
    }

    // Setter for personId
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("John Doe");
        person.setAge(30);
        person.setPersonId("P12345");

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Person ID: " + person.getPersonId());
    }
}
