public class Peoplebase {
    private Person[] persons;

    public Peoplebase(Person ... persons) {
        this.persons = persons;
    }

    public Person findByName(String name) {
        for (int i = 0; i < persons.length; i++) {
            if(persons[i].getName().equals(name)) {
                return persons[i];
            }
        }
        return null;
    }

    public Person findByHomeTown(String homeTown) {
        for (int i = 0; i < persons.length; i++) {
            if(persons[i].getHometown().equals(homeTown)) {
                return persons[i];
            }
        }
        return null;
    }
}
