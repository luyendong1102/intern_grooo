public class IteratorDemo {
    public static void main(String[] args) {
        HuamnResouces hr = new HuamnResouces();
        hr.add(new Human("dasdasd","ASDASFA"));
        hr.add(new Human("dsafasdasd","ASDASasfFA"));
        hr.add(new Human("dasdasfasd","ASDAsfSFA"));
        hr.add(new Human("dasdasasfd","ASDASFAasf"));
        hr.add(new Human("daasdsdasd","12414DASFA"));
        hr.add(new Human("asdasfdasdasd","12415ASDASFA"));

        Iterator<Human> iterator = hr.getIterator();

        while (iterator.hasNext()) {
            System.out.println(
                    iterator.next().getName()
            );
        }
    }
}
