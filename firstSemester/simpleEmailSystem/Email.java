import java.util.Date;

public class Email { 
    private String subject;
    private int id;
    private String message;
    private long time;
    private boolean isRead, isArchived;

    public Email(String subject, int id, String message, long time){
        this.subject = subject;
        this.id = id;
        this.message = message;
        this.time = new Date().getTime();
        this.isRead = false;
    }

    public int getId() {
        return id;
    }

    public void markAsRead() {
        this.isRead = true;
    }

    public boolean isRead() {
        return isRead;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void markAsArchived() {
        this.isArchived = true;
    }

    public String toString() {
        return String.format("ID : %d\nSubject: %s\nMessage: %s\nTime: %d\nStatus: %s %s\n",
        id, subject, message, time, isArchived ? "Archived" : "Sent", isRead ? "Read" : "Unread");
    }
}
