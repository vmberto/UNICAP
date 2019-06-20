public class OpenHashing {

    private LinkedList[] table;
    private int size;

    OpenHashing(int size) {
        if (size < 2) {
            this.size = 11;
        } else {
            this.size = size;
        }
        this.table = new LinkedList[this.size];
        for (int i = 0; i < this.size; i++) {
            this.table[i] = new LinkedList();
        }
    }

    public int h(int value) {
        return value % this.size;
    }

    public void insert(int value) {
        this.table[h(value)].insert(value);
    }

    public void remove(int value) {
        this.table[h(value)].remove(value);
    }

    public Node find(int value) {
        return this.table[h(value)].find(value);
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.print("\n");
            this.table[i].print();

        }
    }


}
