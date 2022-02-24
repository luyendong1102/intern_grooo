public class MainClass {
    public static void main(String[] args) {
        EnglishHR eng = new EnglishHR();

        LangAdapter lA = new LangAdapter();

        lA.translator(eng.talk(), eng);

    }
}
