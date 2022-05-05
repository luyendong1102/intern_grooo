public class Git {

    private String commit;
    private String content;

    public Git(String commit, String content) {
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

    public Commit push() {
        return new Commit(this.commit, this.content);
    }

    public void reverse(Commit cmit) {
        this.commit = cmit.getCommit();
        this.content = cmit.getContent();
    }

}
