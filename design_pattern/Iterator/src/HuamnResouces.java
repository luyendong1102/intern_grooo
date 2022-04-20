import java.util.ArrayList;
import java.util.List;

public class HuamnResouces implements Container<Human>{

    protected List<Human> data;

    public HuamnResouces() {
        this.data = new ArrayList<>();
    }

    public void add (Human human) {
        data.add(human);
    }

    @Override
    public Iterator<Human> getIterator() {
        return new HumanIterator();
    }

    private class HumanIterator implements Iterator<Human>{

        private int index = -1;

        @Override
        public boolean hasNext() {
            if (index < data.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Human next() {
            if (index == data.size() - 1) {
                System.out.println("NOTHING LEFT");
                return null;
            }
            index = index + 1;
            System.out.println(index);
            return data.get(index);
        }
    }
}
