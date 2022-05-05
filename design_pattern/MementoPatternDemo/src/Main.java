public class Main {
    public static void main(String[] args) {
        GitEngine gitEngine = new GitEngine();
        Git ver1 = new Git("save1", "content");
        Git ver2 = new Git("save2", "context");

        gitEngine.saveToHistory(ver1.push(), "save1");

        gitEngine.saveToHistory(ver2.push(), ver2.getCommit());

        System.out.println(gitEngine.getCommit("save1").getContent());

        gitEngine.clear();

        System.out.println(gitEngine.getCommit("save1").getContent());

    }
}
