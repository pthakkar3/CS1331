public class Dog extends Animal {

    private String name;

    public Dog(String name) {
        super(5);
        this.name = name;
    }

    @Override
    public String speak() {
        return "WOOF";
    }

    public String speak(int num) {
        String response = "";
        for (int i = 0; i < num; i++) {
            response += "WOOF! ";
        }
        return response;
    }
}
