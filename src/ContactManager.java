import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ContactManager {
    Scanner scanner = new Scanner(System.in);

    private final Contact[] contacts = new Contact[100];
    private int size = 0;

    public void viewAllContacts() {
        System.out.println("\n========== ALL OF YOURS CONTACTS ==========");
        if (size == 0) {
            System.out.println("\nNo contacts available!");
        } else {
            for (int i = 0; i < size; i++) {
                if (contacts[i] != null) {
                    System.out.println("\n========== Contact #" + (i + 1) + " ==========");
                    System.out.println(contacts[i]);
                }
            }
        }
    }

    public void createNewContact() {
        System.out.println("========== CREATING A NEW CONTACT ==========");

        System.out.print("Put the FIRST NAME of contact - "); // Getting data about new contact
        String firstName = scanner.nextLine();
        System.out.print("Put the LAST NAME of contact - ");
        String lastName = scanner.nextLine();
        System.out.print("Put the PHONE NUMBER - ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Put the EMAIL - ");
        String email = scanner.nextLine();

        try {                                                   // Try to create a new contact
            contacts[size] = (new Contact(firstName, lastName, phoneNumber, email));
            System.out.println("\nContact " + contacts[size].getFirstName() + " is created successfully!");
            size++;
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("========== Yours Contact book is already fool ==========");
        }
    }

    public void upDateContact() {
        if (size > 0) {

            try {
                System.out.println("========== UPDATE CONTACT ==========");

                viewAllContacts();

                System.out.print("\nPut the serial number of contact you would like to update - ");
                int contactToUpdate = scanner.nextInt() - 1;

                if (contactToUpdate < size && contactToUpdate >= 0) {
                    boolean upDatingIsNotFinished = true;
                    int continueUpdating; // Will be used to ask if user wants to update more than 1 field of contact

                    while (upDatingIsNotFinished) {
                        System.out.println("""
                                1.Update the first name
                                2.Update the last name
                                3.Update the phone number
                                4.Update the email""");
                        System.out.print("Put number of the field you would like to update - ");
                        int fieldToUpdate = scanner.nextInt();

                        switch (fieldToUpdate) {
                            case 1:
                                System.out.print("Put a new First name of the contact - ");
                                scanner.nextLine();
                                String newFullName = scanner.nextLine();
                                contacts[contactToUpdate].setFirstName(newFullName);

                                System.out.println("\nFirst name is updated to " + contacts[contactToUpdate].getFirstName());

                                System.out.println("\nWould you like to update anything else?");
                                System.out.println("1.Yes\n2.No");
                                System.out.print("Put the number of answer - ");
                                continueUpdating = scanner.nextInt();

                                switch (continueUpdating) {
                                    case 1:
                                        break;
                                    case 2:
                                        upDatingIsNotFinished = false;
                                        break;
                                    default:
                                        System.out.println("Wrong answer!\n");
                                }
                                break;

                            case 2:
                                System.out.print("Put a new Last name of the contact - ");
                                scanner.nextLine();
                                String newLastName = scanner.nextLine();
                                contacts[contactToUpdate].setLastName(newLastName);

                                System.out.println("\nLast name is updated to " + contacts[contactToUpdate].getLastName());

                                System.out.println("\nWould you like to update anything else?");
                                System.out.println("1.Yes\n2.No");
                                System.out.print("Put the number of answer - ");
                                continueUpdating = scanner.nextInt();

                                switch (continueUpdating) {
                                    case 1:
                                        break;
                                    case 2:
                                        upDatingIsNotFinished = false;
                                        break;
                                    default:
                                        System.out.println("Wrong answer!\n");
                                }
                                break;

                            case 3:
                                System.out.print("Put a new Phone number of the contact - ");
                                scanner.nextLine();
                                String newPhoneNumber = scanner.nextLine();
                                contacts[contactToUpdate].setPhoneNumber(newPhoneNumber);

                                System.out.println("\nPhone number is updated to " + contacts[contactToUpdate].getPhoneNumber());

                                System.out.println("\nWould you like to update anything else?");
                                System.out.println("1.Yes\n2.No");
                                System.out.print("Put the number of answer - ");
                                continueUpdating = scanner.nextInt();

                                switch (continueUpdating) {
                                    case 1:
                                        break;
                                    case 2:
                                        upDatingIsNotFinished = false;
                                        break;
                                    default:
                                        System.out.println("Wrong answer!\n");
                                }
                                break;

                            case 4:
                                System.out.print("Put a new Email of the contact - ");
                                scanner.nextLine();
                                String newEmail = scanner.nextLine();
                                contacts[contactToUpdate].setEmail(newEmail);

                                System.out.println("\nEmail is updated to " + contacts[contactToUpdate].getEmail());

                                System.out.println("\nWould you like to update anything else?");
                                System.out.println("1.Yes\n2.No");
                                System.out.print("Put the number of answer - ");
                                continueUpdating = scanner.nextInt();

                                switch (continueUpdating) {
                                    case 1:
                                        break;
                                    case 2:
                                        upDatingIsNotFinished = false;
                                        break;
                                    default:
                                        System.out.println("Wrong answer!\n");
                                }
                                break;

                            default:
                                System.out.println("\nWrong answer try again!\n");
                        }
                    }
                } else System.out.println("\nWrong serial number!");
            } catch (NullPointerException nullPointerException) {
                System.out.println(nullPointerException.getMessage());
            }
        } else System.out.println("\nNo contacts available!");
    }


    public void deleteContact() {
        if (size > 0) {

            try {
                System.out.println("========== DELETE CONTACT ==========");

                viewAllContacts();

                System.out.print("\nPut the serial number of the Contact to delete - ");
                int contactToRemove = scanner.nextInt() - 1;

                if (contactToRemove < size && contactToRemove >= 0 && contacts[contactToRemove] != null) {
                    System.out.println("Confirm deleting contact " + contacts[contactToRemove].getFirstName());
                    System.out.println("1.Yes\n2.No");
                    int confirm = scanner.nextInt();

                    switch (confirm) {
                        case 1:
                            System.out.println("Contact " + contacts[contactToRemove].getFirstName() + " deleted!");
                            contacts[contactToRemove] = null;
                            break;
                        case 2:
                            System.out.println("Deleting contact " + contacts[contactToRemove].getFirstName() + " canceled!");
                            break;
                    }
                } else {
                    System.out.println("Wrong serial number!\n");
                }
            } catch (NullPointerException nullPointerException) {
                System.out.println(nullPointerException.getMessage());
            }
        } else System.out.println("\nNo contacts available!");
    }

    public void findContactByFirstName() {
        if (size > 0) {

            System.out.println("========== Find contact by First Name ==========");
            System.out.print("Put the first name of the contact, you'd like to find - ");
            String firstName = scanner.nextLine();

            boolean contactFound = false;

            for (int i = 0; i < size; i++) {
                if (contacts[i] != null) {

                    if (firstName.equals(contacts[i].getFirstName())) {
                        System.out.println("\nContact with first name - " + firstName + " is found");
                        System.out.println(contacts[i]);
                        contactFound = true;
                    }

                }
            }

            if (!contactFound) System.out.println("\nContact with first name - " + firstName + " is not found.");

        } else System.out.println("\nNo contacts available!");
    }

    public void findContactByPhoneNumber() {
        if (size > 0) {

            System.out.println("========== Find contact by Phone Number ==========");
            System.out.print("Put the phone number of the contact, you'd like to find - ");
            String phoneNumber = scanner.nextLine();

            boolean contactFound = false;

            for (int i = 0; i < size; i++) {
                if (contacts[i] != null) {

                    if (phoneNumber.equals(contacts[i].getPhoneNumber())) {
                        System.out.println("\nContact with phone number - " + phoneNumber + " is found");
                        System.out.println(contacts[i]);
                        contactFound = true;
                    }

                }
            }

            if (!contactFound) System.out.println("\nContact with phone number - " + phoneNumber + " is not found.");

        } else System.out.println("\nNo contacts available!");
    }

    public void saveContactsIntoFile() {
        if (size > 0) {

            System.out.println("========== Save contacts into the File ==========");
            try {
                System.out.print("Put the full name of the file - ");
                String file = scanner.nextLine();

                FileWriter fileWriter = new FileWriter(file);

                for (int i = 0; i < size; i++) {
                    if (contacts[i] != null) {
                        String contact = String.valueOf(contacts[i]);
                        fileWriter.write(contact);
                        fileWriter.write("\n------------------------------------------------------------\n");
                    }
                }
                fileWriter.close();

                System.out.println("\n========== Successfully saved into the file " + file + " ==========\n");

            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());
            }
        } else System.out.println("\nNo contacts available!");
    }

    public void importContactFromFile() {
        System.out.println("========== Import contacts from the File ==========");

        System.out.print("Write the full name of the file - ");
        String nameOfFile = scanner.nextLine();

        try {
            FileReader fileReader = new FileReader(nameOfFile);
            Scanner scannerToReadFile = new Scanner(fileReader);

            while (scannerToReadFile.hasNextLine()) {
                String line = scannerToReadFile.nextLine();
                String[] contactsField = line.split(" ");

                String firstName = contactsField[0];
                String lastName = contactsField[1];
                String phoneNumber = contactsField[2];
                String email = contactsField[3];

                contacts[size] = new Contact(firstName, lastName, phoneNumber, email);
                size++;
            }
            fileReader.close();
            scannerToReadFile.close();

            System.out.println("\n========== Successfully imported to yours contacts ==========");

        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println(arrayIndexOutOfBoundsException.getMessage());
        }
    }

    public void getContactInfo() {
        if (size > 0) {

            System.out.println("========== View information about contact ==========");
            System.out.print("\nWrite first name of the contact - ");
            String firstName = scanner.nextLine();

            boolean contactFound = false;

            for (int i = 0; i < size; i++) {
                if (firstName.equals(contacts[i].getFirstName())) {
                    System.out.println(contacts[i]);
                    contactFound = true;
                }
            }

            if (!contactFound) System.out.println("\nThere is no contact with name " + firstName);

        } else System.out.println("\nNo contacts available!");
    }
}