public interface Subject {

    void attach (Observer observer);
    void detach (Observer observer);
    void notifyAllObserver();
    String getSubject();

}
