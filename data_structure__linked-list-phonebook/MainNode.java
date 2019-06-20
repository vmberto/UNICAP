package com.company;

public class MainNode {
    private char firstLetter;
    private MainNode next;
    private MainNode previous;

    MainNode(char firstLetter) {
        this.firstLetter = Character.toUpperCase(firstLetter);
    }

    public void setFirstLetter(char firstLetter){
        this.firstLetter = Character.toUpperCase(firstLetter);
    }

    public void setNext(MainNode next){
        this.next = next;
    }

    public void setPrevious(MainNode previous){
        this.previous = previous;
    }

    public char getFirstLetter(){
        return this.firstLetter;
    }

    public MainNode getNext(){
        return this.next;
    }

    public MainNode getPrevious(){
        return this.previous;
    }






}
