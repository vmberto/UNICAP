package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opt = -1;
        FirstLetterList firstLetterList = new FirstLetterList();
        ContactList[] contactLists = new ContactList[26];

        char letters = 'A';

        for (int i = 0; i < contactLists.length; i += 1) {
            contactLists[i] = new ContactList(letters);
            letters += 1;
        }

        while (opt != 0) {

            System.out.println("\nDigite uma opção:\n" +
                    "0- Parar o programa\n" +
                    "1- Inserir Contato\n\n" +

                    "2- Mostrar Todos os Contatos\n" +
                    "3- Mostrar Todos os Contatos por Iniciais\n" +
                    "4- Mostrar um contato pelo Nome\n\n" +

                    "5- Alterar o Email de um Contato\n" +
                    "6- Alterar o Telefone de um Contato\n" +
                    "7- Excluir Contato\n\n" +

                    "8- Mostrar a lista das letras iniciais dos contatos\n" +
                    "9- Mostrar a lista reversa das letras iniciais dos contatos\n");
            opt = sc.nextInt();


            switch (opt) {
                case 1:
                    System.out.println("Insira um nome");
                    String name = sc.next();

                    if(Character.isLetter(name.charAt(0))){
                        firstLetterList.sortedInsert(name.charAt(0));
                    }
                    System.out.println("Insira um email");
                    String email = sc.next();
                    System.out.println("Insira um telefone");
                    String phone = sc.next();

                    for (int i = 0; i < contactLists.length; i += 1) {
                        if (Character.toUpperCase(name.charAt(0)) == contactLists[i].getLetterId()) {
                            contactLists[i].insertFirst(name, email, phone);
                        }
                    }
                    break;

                case 2: //DONE
                    for (int i = 0; i < contactLists.length; i += 1) {
                        contactLists[i].showList();
                    }
                    break;

                case 3: // DONE

                    char letterOpt = 0;
                    System.out.println("Digite a letra para exibir a lista de contatos");

                    boolean verifyIfEmpty = false;

                    letterOpt = sc.next().charAt(0);
                    for (int i = 0; i < contactLists.length; i += 1) {
                        if (Character.toUpperCase(letterOpt) == contactLists[i].getLetterId()) {
                            contactLists[i].showList();

                            if (contactLists[i].getLength() > 0) {
                                verifyIfEmpty = true;
                            } else {
                                verifyIfEmpty = false;
                            }

                        }
                    }
                    if (!verifyIfEmpty) {
                        System.out.println("A Lista da letra " + Character.toUpperCase(letterOpt) + " está vazia");
                    }
                    break;

                case 4:
                    String searchContact; //@REFACTOR: UNIFY VARIABLES

                    System.out.println("Digite o nome do Contato");
                    searchContact = sc.next();

                    for (int i = 0; i < contactLists.length; i += 1) {
                        contactLists[i].findContact(searchContact);
                    }
                    break;

                case 5:
                    String selectContact; //@REFACTOR: UNIFY VARIABLES
                    String newContactEmail;

                    System.out.println("Digite o nome do Contato");
                    selectContact = sc.next();
                    System.out.println("Digite o novo email do Contato");
                    newContactEmail = sc.next();

                    for (int i = 0; i < contactLists.length; i += 1) {
                        contactLists[i].changeEmail(selectContact, newContactEmail);
                    }
                    break;

                case 6:
                    String selectContact2; //@REFACTOR: UNIFY VARIABLES
                    String newContactPhone;

                    System.out.println("Digite o nome do Contato");
                    selectContact2 = sc.next();
                    System.out.println("Digite o novo email do Contato");
                    newContactPhone = sc.next();

                    for (int i = 0; i < contactLists.length; i += 1) {
                        contactLists[i].changePhone(selectContact2, newContactPhone);
                    }
                    break;
                case 7:
                    String contactToDelete;

                    System.out.println("Digite o nome do Contato para ser excluído");
                    contactToDelete = sc.next();

                    for (int i = 0; i < contactLists.length; i += 1) {

                        if(contactLists[i].getLetterId() == Character.toUpperCase(contactToDelete.charAt(0)) && contactLists[i].getLength() == 1){
                            firstLetterList.removeLetterNode(contactToDelete.charAt(0));
                        }
                        contactLists[i].removeContact(contactToDelete.toUpperCase());

                    }

                    break;

                case 8: //DONE
                    firstLetterList.showList();
                    break;

                case 9: //DONE
                    firstLetterList.showReverseList();
                    break;

            }


        }


    }
}
