import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ContactManager contactManager = new ContactManager();

        boolean programIsWorking = true;

        while (programIsWorking) {

                System.out.print("\n========== Contact book ==========\n");
                System.out.println("""
                        1.View all contacts
                        2.Create new contact
                        3.Update contact
                        4.Delete contact
                        5.Save contacts into the file
                        6.Import contacts from the file
                        7.Find contact by first name
                        8.Find contact by phone number
                        9.View information about contact
                        0.Exit
                        """);

                System.out.print("Choose the action - ");
                int action = scanner.nextInt();

                switch (action) {
                    case 1:
                        contactManager.viewAllContacts();
                        break;
                    case 2:
                        contactManager.createNewContact();
                        break;
                    case 3:
                        contactManager.upDateContact();
                        break;
                    case 4:
                        contactManager.deleteContact();
                        break;
                    case 5:
                        contactManager.saveContactsIntoFile();
                        break;
                    case 6:
                        contactManager.importContactFromFile();
                        break;
                    case 7:
                        contactManager.findContactByFirstName();
                        break;
                    case 8:
                        contactManager.findContactByPhoneNumber();
                        break;
                    case 9:
                        contactManager.getContactInfo();
                        break;
                    case 0:
                        programIsWorking = false;
                        break;
                    default:
                        System.out.println("\nWrong action!");

                }
            }
        }
    }
