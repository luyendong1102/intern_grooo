public class LangAdapter {
    private Translator translator;

    public void translator (String msg, Employee author) {

        if (author.getClass().getName().equals("EnglishHR")) {
            translator = new EngTrans();
            translator.toVN(msg);
        }

        if (author.getClass().getName().equals("ZimabweanDev")) {
            translator = new ZmbTrans();
            translator.toVN(msg);
        }

    }

}
