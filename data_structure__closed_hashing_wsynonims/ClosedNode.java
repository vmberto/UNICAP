public class NodeInterno {

    private int position;
    private int info;
    private NodeInterno pointer;

    public NodeInterno(int position, int info) {
        this.position = position;
        this.info = info;
    }

    public int getInfo() {
        return info;
    }

    public NodeInterno getPointer() {
        return pointer;
    }

    public void setPointer(NodeInterno pointer) {
        this.pointer = pointer;
    }

    public int getPosition() {
        return position;
    }
}
