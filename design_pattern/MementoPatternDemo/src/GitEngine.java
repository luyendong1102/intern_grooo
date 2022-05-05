import java.util.HashMap;

public class GitEngine {
    private HashMap<String, Commit> history = new HashMap<>();

    public void saveToHistory (Commit commit, String name) {
        System.out.println("Saving state " + name);
        this.history.put(name, commit);
    }

    public Commit getCommit(String name) {
        System.out.println("Fetching state " + name);
        return this.history.get(name);
    }

    public void clear() {
        this.history.clear();
    }

}
