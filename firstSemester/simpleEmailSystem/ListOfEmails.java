import java.util.LinkedList;

public class ListOfEmails {
    private LinkedList<Email> emails = new LinkedList<>();
    
    public void add(Email e) {
        emails.add(e);
    }

    public Email read(int id) {
        for (Email e : emails) {
            if (e.getId() == id) {
                e.markAsRead();
                System.out.println(e);
                return e;
            }
        }
        return null;
    }

    public Email delete(int id) {
        for (Email e : emails) {
            if (e.getId() == id) {
                emails.remove(e);
                return e;
            }
        }
        return null;
    }

    public void showAll(boolean showAll) {
        if (emails.isEmpty()) {
            System.out.println("The folder is empty.");
        } else {
            for (Email e: emails) {
                if(showAll || !e.isRead()) {
                 System.out.println(e);
                }
             }
        }
    }

    public void clear() {
        emails.clear();
    }

    public LinkedList<Email> getEmails() {
        return emails;
    }
}