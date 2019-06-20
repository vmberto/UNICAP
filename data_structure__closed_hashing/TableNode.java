public class TableNode {

    private int info;
    private boolean deleted;

    TableNode(int info) {
        this.info = info;
    }

    public int getInfo() {
        return info;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
