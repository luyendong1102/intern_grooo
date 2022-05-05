public class Main {

    public static void main(String[] args) {

        NewIntern newI = new NewIntern("ludo");

        Observer oldI = new OldIntern(newI.getName());
        Observer oldInstructor = new Instructor(newI.getName());

        newI.attach(oldI);
        newI.attach(oldInstructor);

        newI.setName("asd");

    }

}
