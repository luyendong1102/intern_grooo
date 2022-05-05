public class OldIntern implements Observer{

    private String newIName;

    public OldIntern(String newIName) {
        this.newIName = newIName;
    }

    public void setNewIName(String newIName) {
        this.newIName = newIName;
    }

    @Override
    public void update(Subject subject) {
        System.out.println("Hello " + subject.getSubject());
    }
}
