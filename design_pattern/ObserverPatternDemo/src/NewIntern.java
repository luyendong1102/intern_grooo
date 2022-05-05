import java.util.ArrayList;
import java.util.List;

public class NewIntern implements Subject{

    private String name;

    public NewIntern(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.notifyAllObserver();
    }

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyAllObserver() {
        this.observers.forEach(
                observer -> {
                    observer.update(this);
                }
        );
    }

    @Override
    public String getSubject() {
        return this.name;
    }
}
