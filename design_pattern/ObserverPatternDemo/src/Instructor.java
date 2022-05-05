public class Instructor implements Observer{

    private String subject;

    public Instructor(String subject) {
        this.subject = subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void update(Subject subject) {
        System.out.println("Hello from instructor " + subject.getSubject());
    }
}
