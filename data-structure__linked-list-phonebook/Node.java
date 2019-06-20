package com.company;

public class Node {
    private Contact contact;
    private Node next;
    private Node previous;

    Node(Contact contact) {
        this.contact = contact;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public void setPrevious(Node previous){
        this.previous = previous;
    }

    public Node getNext(){
        return this.next;
    }
    public Node getPrevious(){
        return this.previous;
    }


    public String getContactString(){
        return this.contact.toString();
    }
    public String getContactName() {
        return this.contact.getName();
    }


    public void setContactEmail(String email){
        this.contact.setEmail(email);
    }
    public void setContactPhone(String phone){
        this.contact.setPhone(phone);
    }







}
