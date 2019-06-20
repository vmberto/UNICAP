package com.company;

public class ContactList {

    private char listLetterId;
    private Node first;
    private Node last;
    private int length;


    ContactList(char listLetter) {
        this.listLetterId = listLetter;
        this.length = 0;
    }

    public void insertFirst(String name, String email, String phone) {
        Contact newContact = new Contact(name, email, phone);
        Node newNode = new Node(newContact);

        if (getLength() == 0) {
            this.first = newNode;
            this.last = newNode;
        } else if (getLength() == 1) {
            newNode.setNext(this.last);
            this.last.setPrevious(newNode);
            this.first = newNode;
        } else {
            newNode.setNext(this.first);
            this.first.setPrevious(newNode);
            this.first = newNode;
        }

        this.length += 1;
    }

    public int getLength() {
        return this.length;
    }

    public char getLetterId() {
        return this.listLetterId;
    }

    public void showList() {
        if (getLength() == 0) return;

        Node aux = this.first;
        do {
            System.out.println(aux.getContactString());
            aux = aux.getNext();
        } while (aux != null);
    }


    public void changeEmail(String contactToEdit, String contactNewEmail) {
        if (searchContactName(contactToEdit) == -1) {
            return;
        }

        Node aux = this.first;
        for (int i = 0; i < searchContactName(contactToEdit); i += 1) {
            aux = aux.getNext();
        }
        aux.setContactEmail(contactNewEmail);

    }

    public void changePhone(String contactToEdit, String contactNewPhone) {
        if (searchContactName(contactToEdit) == -1) {
            return;
        }

        Node aux = this.first;
        for (int i = 0; i < searchContactName(contactToEdit); i += 1) {
            aux = aux.getNext();
        }
        aux.setContactPhone(contactNewPhone);

    }

    public void findContact(String searchedContact) {
        if (searchContactName(searchedContact) == -1) {
            return;
        }
        Node aux = this.first;
        for (int i = 0; i < searchContactName(searchedContact); i += 1) {
            aux = aux.getNext();
        }
        System.out.println(aux.getContactString());
    }


    public void removeContact(String searchedContact) {

        if (searchContactName(searchedContact) == -1) {
            return;
        }

        if (getLength() == 1 && Character.toUpperCase(searchedContact.charAt(0)) == getLetterId()) {
            this.first = null;
            this.last = null;
            this.length = 0;
            return;
        }

        Node aux = this.first;
        for (int i = 0; i < searchContactName(searchedContact); i += 1) {
            aux = aux.getNext();
        }


        Node auxPrevious = aux.getPrevious();
        Node auxNext = aux.getNext();

        if(aux == this.first){
            auxNext.setPrevious(null);
            this.first = auxNext;

        } else if (aux == this.last) {

            auxPrevious.setNext(null);
            this.last = auxPrevious;


        } else {
            auxPrevious.setNext(auxNext);
            auxNext.setPrevious(auxPrevious);
        }


        this.length -= 1;

    }


    public int searchContactName(String searchedName) {
        Node aux = this.first;
        int index = -1;

        for (int i = 0; i < getLength(); i += 1) {
            if (aux.getContactName().toUpperCase().equals(searchedName.toUpperCase())) {
                index = i;
            }
            aux = aux.getNext();
        }
        return index;
    }


}
