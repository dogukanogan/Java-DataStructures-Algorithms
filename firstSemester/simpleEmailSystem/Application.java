import java.util.Scanner;

public class Application {
    private ListOfEmails inbox = new ListOfEmails();
    private ListOfEmails archive = new ListOfEmails();
    private ListOfEmails sent = new ListOfEmails();
    private int nextId = 1; // id counter


    public void deleteById(int id) {
        Email email = null;

        // check all lists for the mail

        email = inbox.delete(id);
        if(email != null){
            System.out.println("Email " + id + " is deleted from Inbox.");
            return;
        }

        email = archive.delete(id);
        if(email != null){
            System.out.println("Email " + id + " is deleted from Archive.");
            return;
        }

        email = sent.delete(id);
        if(email != null){
            System.out.println("Email " + id + " is deleted from Sent.");
            return;
        } 

        if (email == null) System.out.println("No such email.");
        return;
    }

    public void readEmailById(int id) {
        Email email = null;
        
        // check all lists for the mail 

        email = inbox.read(id);
        if (email != null) return;

        email = archive.read(id);
        if (email != null) return;

        email = sent.read(id);
        if (email != null) return;

        System.out.println("No such email.");
        return;
    }


    public void start() {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("---Welcome to the Email Management System---");

        while(running) {
            System.out.println("\nEnter command\nN (for create and send new email)\nR <id> (read an email with the given id)\nA <id> (archive an email with the given id)\nD <id> (delete the email)\nS <Folder> (show the folder(inbox, archive, sent))\nU <Folder> (show unread emails in folder(inbox, archive, sent))\nC <Folder> (clear the contents of the folder)\nQ to quit): ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0];

            switch (command.toUpperCase()) {
                case "N":
                    System.out.print("Enter Subject: ");
                    String subject = scanner.nextLine();

                    System.out.print("Enter Message: ");
                    String message = scanner.nextLine();

                    Email newEmail = new Email(subject, nextId++, message, System.currentTimeMillis());
                    sent.add(newEmail);
                    System.out.println("Email sent and added to Sent folder.");
                    break;

                case "R":
                    if (parts.length < 2) {
                        System.out.println("Invalid Input.");
                        break;
                    }
                    int readId = Integer.parseInt(parts[1]);
                    readEmailById(readId);
                    break;

                case "A":
                    if (parts.length < 2) {
                        System.out.println("Invalid Input");
                        break;
                    }
                    int archiveId = Integer.parseInt(parts[1]);
                    Email archivedEmail = sent.delete(archiveId);
                    if (archivedEmail != null) {
                        archive.add(archivedEmail);
                        archivedEmail.markAsArchived();
                        System.out.println("Email " + archiveId + " archived from Sent.");
                    } else System.out.println("No such email.");
                    
                    break;

                case "D":
                    if (parts.length < 2) {
                        System.out.println("Invalid Input");
                        break;
                    }
                    int deleteId = Integer.parseInt(parts[1]);
                    deleteById(deleteId);
                    break;

                case "S":
                    if (parts.length < 2) {
                        System.out.println("Invalid Input");
                        break;
                    }
                    String folder = parts[1];
                    switch (folder.toLowerCase()) {
                        case "inbox":
                            inbox.showAll(true);
                            break;
                        case "archive":
                            archive.showAll(true);
                            break;
                        case "sent":
                            sent.showAll(true);
                            break;
                        default:
                        System.out.println("Invalid Folder.");
                        break;     
                    }
                    break;

                case "U":
                    if (parts.length < 2) {
                        System.out.println("Invalid Input");
                        break;
                    }
                    folder = parts[1];
                    switch (folder.toLowerCase()) {
                        case "inbox":
                            inbox.showAll(false);
                            break;
                        case "archive":
                            archive.showAll(false);
                            break;
                        case "sent":
                            sent.showAll(false);
                            break;
                        default:
                        System.out.println("Invalid Folder.");
                        break;     
                    }
                    break;

                case "C":
                    if (parts.length < 2) {
                        System.out.println("Invalid Input");
                        break;
                    }
                    folder = parts[1];
                    switch (folder.toLowerCase()) {
                        case "inbox":
                            for (Email e : inbox.getEmails()) {
                                archive.add(e);
                            }
                            inbox.clear();
                            System.out.println("Inbox emails moved to Archive.");
                            break;
                           
                        case "sent":
                            for (Email e : sent.getEmails()) {
                                archive.add(e);
                            }    
                            sent.clear();
                            System.out.println("Sent emails moved to Archive.");
                            break;
                        
                        case "archive":
                            archive.clear();
                            System.out.println("Archive cleared.");
                            break;
                        
                        default:
                            System.out.println("Invalid Folder.");
                            break;    
                    }

                    break;

                case "Q":
                    running = false;
                    System.out.println("Exiting Email Management System.");
                    break;
                default:
                    System.out.println("Invalid Input");        
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }

}