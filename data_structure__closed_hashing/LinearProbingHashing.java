public class LinearProbingHashing {

    private TableNode[] table;
    private int size;

    LinearProbingHashing(int size) {
        if (size < 2) {
            this.size = 11;
        } else {
            this.size = size;
        }
        this.table = new TableNode[this.size];
    }

    public int h(int value) {
        return value % this.size;
    }

    public int rh (int value, int i) {
        return (i + 1) % this.size;
    }

    public boolean insert(int value) {
        int originalPosition, nextPosition;
        originalPosition = nextPosition = h(value);

        if (this.table[originalPosition] == null || this.table[originalPosition].isDeleted()) {
            this.table[originalPosition] = new TableNode(value);
            return true;
        }
        nextPosition = rh(value, nextPosition);

        while (originalPosition != nextPosition && this.table[nextPosition] != null && !this.table[nextPosition].isDeleted()) {
            nextPosition = rh(value, nextPosition);
        }

        if (originalPosition == nextPosition) {
            return false;
        }

        this.table[nextPosition] = new TableNode(value);
        return true;

    }

    public boolean delete(int value) {
        int originalPosition, nextPosition;
        originalPosition = nextPosition = h(value);

        if (this.table[originalPosition].getInfo() == value && !this.table[originalPosition].isDeleted()) {
            this.table[originalPosition].setDeleted(true);
            return true;
        }
        nextPosition = rh(value, nextPosition);

        while (originalPosition != nextPosition
                && this.table[nextPosition] != null
                && ( this.table[nextPosition].getInfo() != value
                || this.table[nextPosition].isDeleted())) {
            nextPosition = rh(value, nextPosition);
        }

        if (originalPosition == nextPosition || this.table[nextPosition] == null) {
            return false;
        }

        this.table[nextPosition].setDeleted(true);
        return true;
    }

    public TableNode find(int value) {
        int originalPosition, nextPosition;
        originalPosition = nextPosition = h(value);

        if (this.table[originalPosition].getInfo() == value && !this.table[originalPosition].isDeleted()) {
            return this.table[originalPosition];
        }

        nextPosition = rh(value, nextPosition);

        while (originalPosition != nextPosition
                && this.table[nextPosition] != null
                && ( this.table[nextPosition].getInfo() != value
                || this.table[nextPosition].isDeleted())) {
            nextPosition = rh(value, nextPosition);
        }

        if (originalPosition == nextPosition || this.table[nextPosition] == null) {
            return null;
        }

        return this.table[nextPosition];
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            if (i == this.size / 2) System.out.println("\n");
            if (this.table[i] == null) {
                System.out.print(" -- [   ] ");
            } else if (this.table[i].isDeleted()) {
                System.out.print(" -- [ deleted ] ");
            } else {
                System.out.print(" -- [" + this.table[i].getInfo() + "] ");
            }
        }
    }

}
