
package ER1301.joinMe.model;

import java.util.Date;

public class Comentario {

    private String title;
    private String text;
    private String toUser;
    private String fromUser;
    private Date createdAt;
    
    public Comentario (String title, String text, String toUser, String fromUser){
        
        this.title = title;
        this.text = text;
        this.toUser = toUser;
        this.fromUser = fromUser;
        this.createdAt = new Date();
   
    }
   
    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getToUser() {
        return toUser;
    }

    public String getFromUser() {
        return fromUser;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }

    
    
}
