public class Commit {
    private String commit;
    private String content;

    public Commit(String commit, String content) {
        this.commit = commit;
        this.content = content;
    }

    public String getCommit() {
        return commit;
    }

    public void setCommit(String commit) {
        this.commit = commit;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
