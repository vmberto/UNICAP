public class ClosedHashing {

    private NodeInterno[] table;
    private NodeInterno[] synonims;
    private int size;
    private int synonimSize;

    ClosedHashing(int size) {
        this.synonimSize = 5;
        if (size < 2) {
            this.size = 11;
        } else {
            this.size = size;
        }
        this.synonims = new NodeInterno[synonimSize];
        this.table = new NodeInterno[this.size];
    }

    public int h(int value) {
        return value % this.size;
    }

    public boolean insert(int value) {
        int originalPosition;
        originalPosition = h(value);

        if (this.table[originalPosition] == null) {
            this.table[originalPosition] = new NodeInterno(originalPosition, value);
            return true;
        }

        int synonimPosition = 0;

        while (synonimPosition < this.synonimSize) {
            if (this.synonims[synonimPosition] == null) {

                NodeInterno previousNode = this.table[originalPosition];
                while (previousNode.getPointer() != null) {
                    previousNode = previousNode.getPointer();
                }

                this.synonims[synonimPosition] = new NodeInterno(synonimPosition + this.size, value);
                previousNode.setPointer(this.synonims[synonimPosition]);

                return true;

            } else {
                synonimPosition++;
            }
        }

        return false;

    }

    public void print() {

        System.out.println("--------Tabela--------");
        for (int i = 0; i < this.size; i++) {
            if (this.table[i] == null) {
                System.out.println(i + "  |        |       ");
            } else {
                System.out.println(i + "  | " + this.table[i].getInfo() + "     | " + (this.table[i].getPointer() == null ? "-1" : this.table[i].getPointer().getPosition()));
            }
        }

        System.out.println("--------Sinônimos--------");
        for (int i = 0; i < this.synonimSize; i++) {
            if (this.synonims[i] == null) {
                System.out.println(i + this.size + "  |        |       ");
            } else {
                System.out.println(i + this.size + "  | " + this.synonims[i].getInfo() + "     | " + (this.synonims[i].getPointer() == null ? "-1" : this.synonims[i].getPointer().getPosition()));
            }
        }

    }


}

