package com.company;

public class FirstLetterList {

    private MainNode first;
    private MainNode last;
    private int length;

    FirstLetterList() {
        this.length = 0;
    }

    public void sortedInsert(char firstLetter) {
        if (verifyIfExists(firstLetter)) {
            return;
        }
        MainNode newNode = new MainNode(firstLetter);

        if (getLength() <= 0) {
            this.first = newNode;
            this.last = newNode;
        } else if (getLength() == 1) {
            if (this.first.getFirstLetter() > Character.toUpperCase(firstLetter)) {
                newNode.setNext(this.first);
                this.first = newNode;
                this.last = this.first.getNext();
                this.last.setPrevious(this.first);

            } else {
                newNode.setPrevious(this.first);
                this.last = newNode;
                this.first.setNext(this.last);

            }
        } else {
            MainNode aux = this.first;
            do {
                if (aux.getFirstLetter() > Character.toUpperCase(firstLetter)) {
                    if (aux == this.first) {
                        this.first.setPrevious(newNode);
                        newNode.setNext(this.first);
                        this.first = newNode;
                    } else {
                        MainNode auxPrevious = aux.getPrevious();
                        newNode.setNext(aux);
                        newNode.setPrevious(auxPrevious);
                        aux.setPrevious(newNode);
                        auxPrevious.setNext(newNode);
                    }
                    this.length += 1;
                    return;
                }
                if (aux == this.last) {
                    newNode.setPrevious(aux);
                    aux.setNext(newNode);
                    this.last = newNode;
                    this.length += 1;
                    return;
                }
                aux = aux.getNext();
            } while (aux != null);
        }
        this.length += 1;
    }


    public int getLength() {
        return this.length;
    }

    public boolean verifyIfExists(char target) {
        boolean exist = false;

        if (getLength() != 0) {

            MainNode aux = this.first;
            do {
                if (aux.getFirstLetter() == Character.toUpperCase(target)) {
                    exist = true;
                }
                aux = aux.getNext();
            } while (aux != null);
        }

        return exist;
    }

    public void showList() {
        if (getLength() == 0) {
            System.out.println("\nNenhum elemento na lista");
            return;
        }
        MainNode aux = this.first;

        do {
            System.out.println(aux.getFirstLetter());
            aux = aux.getNext();

        } while (aux != null);

    }

    public void showReverseList() {
        if (getLength() == 0) {
            System.out.println("\nNenhum elemento na lista");
            return;
        }
        MainNode aux = this.last;

        do {
            System.out.println(aux.getFirstLetter());
            aux = aux.getPrevious();

        } while (aux != null);

    }

    public void removeLetterNode(char index) {
        index = Character.toUpperCase(index);


        if (getLength() == 0 || searchLetter(index) == -1) {
            return;
        }

        if (getLength() == 1) {
            this.first = null;
            this.last = null;
            this.length = 0;
            return;
        }

        MainNode aux = this.first;
        for (int i = 0; i < searchLetter(index); i += 1) {
            aux = aux.getNext();
        }

        MainNode auxPrevious = aux.getPrevious();
        MainNode auxNext = aux.getNext();

        if(aux == this.first){

            auxNext.setPrevious(null);
            this.first = auxNext;

            this.length -= 1;


        } else if (aux == this.last) {

            auxPrevious.setNext(null);
            this.last = auxPrevious;

            System.out.println(this.last.getNext());
            System.out.println(this.last.getPrevious().getFirstLetter());

            this.length -= 1;

        } else {
            auxPrevious.setNext(auxNext);
            auxNext.setPrevious(auxPrevious);
            this.length -= 1;
        }
    }


    public int searchLetter(char searchedLetter) {
        MainNode aux = this.first;
        int index = -1;

        for (int i = 0; aux != null; i += 1) {
            if (aux.getFirstLetter() == (searchedLetter)) {
                index = i;
            }
            aux = aux.getNext();
        }
        return index;
    }


}



