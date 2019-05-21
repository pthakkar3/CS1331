public class Person {

    private String name;
    private String homeTown;

    public Person(String name, String homeTown) {
        this.name = name;
        this.homeTown = homeTown;
    }

    public String toString() {
        return name + " from " + homeTown;
    }

    public String getName() {
        return name;
    }

    public String getHometown() {
        return homeTown;
    }
}
