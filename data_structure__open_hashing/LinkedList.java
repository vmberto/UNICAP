public class LinkedList {

    private Node first;
    private int length;

    LinkedList() {
        this.length = 0;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (this.length == 0) {
            this.first = node;
        } else if (this.length == 1) {
            if (this.first.getInfo() < value) {
                this.first.setNext(node);
            } else {
                node.setNext(this.first);
                this.first = node;
            }
        } else {
            Node aux = this.first;
            if (aux.getInfo() > node.getInfo()) {
                node.setNext(this.first);
                this.first = node;
            } else {
                while (aux.getNext() != null && aux.getNext().getInfo() < node.getInfo()) {
                    aux = aux.getNext();
                }
                node.setNext(aux.getNext());
                aux.setNext(node);
            }
        }
        this.length++;
    }

    public Node remove(int value) {
        Node deleted;
        if (this.length == 0) {
            return null;
        } else if (this.length == 1) {
            deleted = this.first;
            this.first = null;
            this.length--;
            return deleted;
        } else {

            if (this.first.getInfo() == value) {
                deleted = this.first;
                this.first = this.first.getNext();
                this.length--;
                return deleted;
            }

            Node aux = this.first;

            while (aux.getNext() != null && aux.getNext().getInfo() != value) {
                aux = aux.getNext();
            }

            if (aux.getNext() == null) {
                return null;

            } else {
                deleted = aux.getNext();
                aux.setNext(aux.getNext().getNext());
                this.length--;
                return deleted;
            }
        }
    }

    public Node find(int value) {
        if (this.length == 0) {
            return null;
        } else if (this.length == 1) {
            return this.first;
        } else {
            Node aux = this.first;
            while (aux != null && aux.getInfo() != value) {
                aux = aux.getNext();
            }

            if (aux == null) {
                return null;
            } else {
                return aux;
            }

        }
    }

    public void print() {
        Node aux = this.first;

        if (this.length == 0) {
            System.out.print("[   ]");
        }

        for (int i = 0; i < this.length; i++) {

            if (i == 0) {
                System.out.print("[ " + this.first.getInfo() + " ] ");
            } else {
                System.out.print("-> [ " + aux.getInfo() + " ] ");
            }
            aux = aux.getNext();
        }
    }

}
