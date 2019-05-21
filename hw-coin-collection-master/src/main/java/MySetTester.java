import java.util.Arrays;
/**
 * Tester to test MySet
 * @author pthakkar7
 */
public class MySetTester {

    /**
     * Main method to test all methods in MySet
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        /*
         * Test MySet
         */
        MySet<String> set = new MySet<>();

        System.out.println("Testing add, contains, and size:");

        // test add and contains and size
        set.add("That");
        set.add("aint");
        set.add("Falco!");
        set.add("Falco!");
        set.add("That");
        System.out.printf("Your set has %d elements, and \"Falco!\" %s"
                        + " in the set.  PASS? %b\n",
                set.size(),
                set.contains("Falco!") ? "is" : "is not",
                set.size() == 3 && set.contains("Falco!"));

        System.out.println("Testing remove:");

        // test remove
        set.remove("Falco!");
        System.out.printf("Your set has %d elements, and \"Falco!\" %s"
                        + " in the set.  PASS? %b\n",
                set.size(),
                set.contains("Falco!") ? "is" : "is not",
                set.size() == 2 && !set.contains("Falco!"));

        System.out.println("Testing addAll:");

        // test addAll
        set.addAll(Arrays.asList("Happy", "Feet"));
        System.out.printf("Your set has %d elements, and \"Feet\" %s"
                        + " in the set.  PASS? %b\n",
                set.size(),
                set.contains("Feet") ? "is" : "is not",
                set.size() == 4 && set.contains("Feet"));

        System.out.println("Testing removeAll:");

        // test removeAll
        set.removeAll(Arrays.asList("Happy", "That"));
        System.out.printf("Your set has %d elements, and \"That\" %s"
                        + " in the set.  PASS? %b\n",
                set.size(),
                set.contains("That") ? "is" : "is not",
                set.size() == 2 && !set.contains("That"));

        System.out.println("Testing containsAll");

        //test containsAll
        set.add("Blaziken");
        set.add("Swampert");
        set.add("Grovyle");
        System.out.printf("Your set has %d elements, and \"Hoenn Starters\" %s"
                        + " in the set.  PASS? %b\n",
                set.size(),
                set.containsAll(Arrays.asList("Blaziken", "Swampert",
                                              "Grovyle")) ? "are" : "are not",
                set.size() == 5 && set.containsAll(Arrays.asList("Blaziken",
                                                      "Swampert", "Grovyle")));

        System.out.println("Testing retainAll:");

        //test retainAll
        set.retainAll(Arrays.asList("Blaziken", "Swampert"));
        System.out.printf("Your set has %d elements, and \"Grovyle\" %s"
                        + " in the set.  PASS? %b\n",
                set.size(),
                set.contains("Grovyle") ? "is" : "is not",
                set.size() == 2 && !set.contains("Grovyle"));

        System.out.println("Testing equals:");

        //test equals
        MySet<String> set2 = new MySet<>();
        set2.add("Blaziken");
        set2.add("Swampert");
        System.out.printf("Set1 has %d elements, Set2 has %d elements, and"
                          + " they are equal.  PASS? %b\n", set.size(),
                          set2.size(), set.equals(set2));

        System.out.println("Testing toArray:");

        //test toArray
        System.out.print("The elements of the array are: ");
        for (Object item : set.toArray()) {
            System.out.print(item + " ");
        }
        System.out.println();

        System.out.println("Testing clear and isEmpty:");

        //test clear and isEmpty
        set.clear();
        System.out.printf("Your set has %d elements, \"Blaziken\" %s"
                        + " in the set, and the set is empty.  PASS? %b\n",
                set.size(),
                set.contains("Blaziken") ? "is" : "is not",
                set.size() == 0 && set.isEmpty() && !set.contains("Blaziken"));
    }
}
