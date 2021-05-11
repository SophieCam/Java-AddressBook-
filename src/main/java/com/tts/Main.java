package com.tts;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressFunction = new AddressBook();

        boolean restart = true;
        while (restart) {

            //below runs at start of program
            System.out.println("Please choose what you'd like to do with the address book:\n" +
                    "1) Add an entry\n" +
                    "2) Remove an entry\n" +
                    "3) Search for a specific entry\n" +
                    "4) Print Address Book\n" +
                    "5) Delete Book\n" +
                    "6) Quit\n");

            //user will choose a number (1-6) and scanner will store it
            Integer userDecision = scanner.nextInt();

            //based on what user chooses(1-6) the function will run
            switch (userDecision) {
                case 1:
                    addressFunction.add();
                    break;

                case 2:
                    addressFunction.deletePerson();
                    break;

                case 3:
                    addressFunction.search();
                    break;
                case 4:
                    addressFunction.print();
                    break;
                case 5:
                    addressFunction.deleteAddressBook();
                    break;

                case 6:
                    addressFunction.quit();
                    break;

                default:
                    System.out.println("Please choose a number between 1 and 6 (inclusive).");
            }
        }

    }
}
