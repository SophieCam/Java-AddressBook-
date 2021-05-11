package com.tts;

public class IndividualInfo {
//fields/variables are defined
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    //constructor of class
    public IndividualInfo(String firstName, String lastName, String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    //empty constructor
    public IndividualInfo() {

    }

    //getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override //customized toString to display string
    public String toString() {
        return "First Name: " + firstName +
                "; Last Name: " + lastName +
                "; Phone Number: " + phoneNumberCorrector (phoneNumber) +
                "; Email Address: " + emailAddress + ";"
                ;
    }

    //method below to validate email address
    public boolean isValid(String emailAddress) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return emailAddress.matches(regex);
    }
    //method below validates phone number
    public String phoneNumberCorrector(String aPhoneNumber) {
        StringBuilder sb = new StringBuilder(10);
        StringBuilder temp = new StringBuilder(aPhoneNumber);
        char[] chars = temp.toString().toCharArray();

        sb.append("("); //appends first parenthesis when phone number is displayed
        for (int i = 0; i < chars.length; i++) {
            if (i == 3) //appends 2nd parenthesis at position 3 when phone number is displayed
                sb.append(") ");
            else if (i == 6) //at position 6 in the number string, add a "-"
                sb.append("-");
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
