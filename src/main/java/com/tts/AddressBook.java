package com.tts;

import java.util.Scanner;
import java.util.ArrayList;

public class AddressBook {
    //initializing ourAddressBook as an arraylist
    ArrayList ourAddressBook;

    //constructor
    public AddressBook() {
        this.ourAddressBook = new ArrayList<>();
    }

    Scanner scanner = new Scanner(System.in);
    IndividualInfo aPerson = new IndividualInfo(); //aPerson is an object of IndividualInfo class

    public void add() {
        // Function to suggest to users to add values to their entries
        System.out.println("Enter your first name.");
        String firstName = scanner.next();

        System.out.println("Enter your last name.");
        String lastName = scanner.next();

        System.out.println("Enter your phone number.");
        Integer phoneNumber = scanner.nextInt();

        //conditional to validate phone number, must be 10 digits
        if (phoneNumber.toString().length() !=10){
            System.out.println("The phone number must be 10 digits!");
            add();
        } else {
            System.out.println("Enter your email address.");
            String emailAddress = scanner.next();

            //conditional to validate email address, must be in proper format,
            // if it is, then a new instance of individualInfo called NewPerson is created
            // by storing the user's input into that new instance
            if (aPerson.isValid(emailAddress)) {
                System.out.println("This email is valid. Your entry has been added! \n");

                IndividualInfo NewPerson = new IndividualInfo(firstName, lastName, phoneNumber.toString(), emailAddress);

                ourAddressBook.add(NewPerson);

            } else {
                System.out.println("This email isn't valid...\n");
                add();
            }
        }
    }

    //Function to suggest to users to search by either firstname, email address, or phone number
    public void search() {
        if(ourAddressBook.size()==0) {
        System.out.println("There are no contents within our address book to search.\n");
    } else {
        System.out.println("Enter a name, number, or email address.");
        String searchFirstName = scanner.next();

        for (int i = 0; i < ourAddressBook.size(); i++) {
            IndividualInfo NewPerson = (IndividualInfo) ourAddressBook.get(i);

            if (searchFirstName.equals(NewPerson.getFirstName())
                    || searchFirstName.equals(NewPerson.getLastName())
                    || searchFirstName.equals(NewPerson.getEmailAddress())
                    || searchFirstName.equals(NewPerson.getPhoneNumber())
            ) {
                System.out.println(NewPerson.toString());
            } else {
                System.out.println("There is not a person with the information specified.\n");
            }
        }
    }

}
    // Function to delete entries by first name, last name, email, or phone number
    public void deletePerson () {
        System.out.println("Enter a name, number, or email address.");
        String deleteIndividual = scanner.next();

        for (int i = 0; i < ourAddressBook.size(); i++) {
            IndividualInfo NewPerson = (IndividualInfo) ourAddressBook.get(i);
            if ( deleteIndividual.equals(NewPerson.getFirstName())
                    || deleteIndividual.equals(NewPerson.getLastName())
                    || deleteIndividual.equals(NewPerson.getEmailAddress())
                    || deleteIndividual.equals(NewPerson.getPhoneNumber())
            ) {
                ourAddressBook.remove(i);
                System.out.println("There are now " + ourAddressBook.size() + " entries in our address book.");
            } else {
                System.out.println("Our records indicate there is no person that has " + "'" + deleteIndividual +"'" +
                        " as a part of their information");
            }
        }
    }

    // Function that prints all entries
    public void print() {
        if (ourAddressBook.size() == 0) {
            System.out.println("This address book is currently empty.");
        } else {
            for (int i = 0; i < ourAddressBook.size(); i++) {
                IndividualInfo NewPerson = (IndividualInfo) ourAddressBook.get(i);
                System.out.println(NewPerson.toString());
            }
            if (ourAddressBook.size() == 1) {
                System.out.println("There is currently a single entry in our address book.");
            } else {
                System.out.println("There are currently " + ourAddressBook.size() + " entries in our address book.");
            }
        }
    }

    // Function to let user know address book contents are empty
    public void deleteAddressBook() {
        if (ourAddressBook.size() == 0) {
            System.out.println("This address book is currently empty.");
        } else {
            ourAddressBook.clear();
            System.out.println("The contents of the entire address book have been removed.");
        }
    }

    // Function to allow user to quite the program
    public void quit() {
        System.out.println("Are you sure you want to quit?");
        String quitResponse = scanner.next().toUpperCase();

        if (quitResponse.equals("YES") || quitResponse.equals("Y")) {
            System.out.println("You have quit the program.");
            System.exit(0);
        }
    }
}