/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ER1301.joinMe.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author alex030293
 */
public class Usuario {

    private String username = null;
    private String password = null;
    private String dni = null;
    private String name = null;
    private String surname = null;
    private String type = "regular";

    private ArrayList<Usuario> friends = new ArrayList<>();
    private ArrayList<String> files = new ArrayList<>();
    private ArrayList<String> wall = new ArrayList<>();
    private ArrayList<String> notifications = new ArrayList<>();
    private List<Mensaje> inbox = new ArrayList<>();
    private List<Challenge> challenges = new ArrayList<>();

    public Usuario(String username, String password, String dni, String name, String surname) {
        this.username = username;
        this.password = password;
        this.dni = dni;
        this.name = name;
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public ArrayList<Usuario> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<Usuario> friends) {
        this.friends = friends;
    }

    public ArrayList<String> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<String> files) {
        this.files = files;
    }

    public Usuario addFriend(Usuario friend) {
        this.friends.add(friend);
        return this;
    }

    public Usuario addFile(String file) {
        this.files.add(file);
        return this;
    }

    public Usuario post(String post) {
        this.wall.add(post);
        return this;
    }

    public ArrayList<String> getWall() {
        return this.wall;
    }

    public ArrayList<String> getNotifications() {
        return this.notifications;
    }

    public Usuario notify(String notification) {
        this.notifications.add(0, notification);
        return this;
    }

    public ArrayList<String> getFriendsNames() {
        ArrayList<String> t = new ArrayList<>();
        this.getFriends().stream().forEach((u) -> {
            t.add(0, u.getName());
        });
        return t;
    }

    public boolean sendMessage(Mensaje msg, String rcpt) {
        Boolean rcptExists = false;
        for (Usuario usr : Sistema.getUsers()) {
            if (usr.dni.equals(rcpt)) {
                rcptExists = true;
                usr.inbox.add(msg);
            }
        }

        if (!rcptExists) {
            for (GrupoDifusion grp : Sistema.getGroups()) {
                if (grp.getIdGrupoDifusion().equals(rcpt)) {
                    rcptExists = true;
                    grp.addMsg(msg);
                }
            }
        }

        return rcptExists;
    }

    public boolean postInWall(Mensaje msg, String rcpt) {

        Boolean rcptExists = false;
        for (Usuario usr : Sistema.getUsers()) {
            if (usr.dni.equals(rcpt)) {
                rcptExists = true;
                usr.inbox.add(msg);
            }
        }

        if (!rcptExists) {
            for (GrupoDifusion grp : Sistema.getGroups()) {
                if (grp.getIdGrupoDifusion().equals(rcpt)) {
                    rcptExists = true;
                    grp.addMsg(msg);
                }
            }
        }

        return rcptExists;
    }

    public boolean createContest(Calendar start, Calendar end, String title) {
        if (this.type.equals("admin")) {
            Sistema.getContests().add(new Contest(start, end, title));
            return true;
        } else {
            return false;
        }
    }

    public boolean joinContest(String contest) {
        Integer count = 0;
        Boolean res = false;
        ArrayList<Contest> contests = (ArrayList<Contest>) Sistema.getContests();
        for (Contest c : contests) {
            count++;
            if (c.getTitle().equals(contest)) {
                Calendar now = Calendar.getInstance();
                if (now.getTimeInMillis() - c.getStart().getTimeInMillis() <= 0) {
                    c.getParticipants().add(this.dni);
                    res = true;
                }
            }
        }
        return res;
    }

    public boolean submitSentence(String contest, String sentence) {
        Integer count = 0;
        Boolean res = false;
        ArrayList<Contest> contests = (ArrayList<Contest>) Sistema.getContests();
        for (Contest c : contests) {
            count++;
            if (c.getParticipants().contains(this.dni) && c.getTitle().equals(contest)) {
                Calendar now = Calendar.getInstance();
                if ((c.getStart().getTimeInMillis() <= now.getTimeInMillis()) && (now.getTimeInMillis() <= c.getEnd().getTimeInMillis())) {
                    c.getSentences().add(new Sentence(this.dni, sentence, c.getTitle()));
                    res = true;
                } 
            } 
        }
        return res;
    }

    public String getContestState(String contest) {
        Integer count = 0;
        String res = "Not found";
        ArrayList<Contest> contests = (ArrayList<Contest>) Sistema.getContests();
        for (Contest c : contests) {
            if (c.getTitle().equals(contest)) {
                res = c.getState();
            }
        }
        return res;
    }

    public boolean rateSentences(String contest, String s1, String s2, String s3) {
        Integer count = 0;
        Boolean res = false;
        ArrayList<Contest> contests = (ArrayList<Contest>) Sistema.getContests();
        for (Contest c : contests) {
            count++;
            if (c.getParticipants().contains(this.dni) && c.getTitle().equals(contest)) {
                Calendar now = Calendar.getInstance();
                if ((c.getStart().getTimeInMillis() <= now.getTimeInMillis()) && (now.getTimeInMillis() <= c.getEnd().getTimeInMillis())) {
                    ArrayList<Sentence> sentences = c.getSentences();
                    Integer votes = 0;
                    for(Sentence s : sentences){
                        if(!s.getAuthor().equals(this.dni)){
                            if(s.getSentence().equals(s1)){
                                s.setRating(s.getRating()+3);
                                Sistema.notifyUser(s.getAuthor(), "Un usuario ha valorado tu frase del concurso \""+ contest +"\" con 3 puntos.");
                                this.penalizeChallengers(s.getContest());
                                votes++;
                            }
                            if(s.getSentence().equals(s2)){
                                s.setRating(s.getRating()+2);
                                Sistema.notifyUser(s.getAuthor(), "Un usuario ha valorado tu frase del concurso \""+ contest +"\" con 2 puntos.");
                                this.penalizeChallengers(s.getContest());
                                votes++;
                            }
                            if(s.getSentence().equals(s3)){
                                s.setRating(s.getRating()+1);
                                Sistema.notifyUser(s.getAuthor(), "Un usuario ha valorado tu frase del concurso \""+ contest +"\" con 1 puntos.");
                                this.penalizeChallengers(s.getContest());
                                votes++;
                            }
                            
                            if(votes == 3){
                                res = true;
                            }
                        }else{
                            res = false;
                            break;
                        }
                    }
                    
                    res = true;
                } 
            } 
        }
        return res;
    }
    
    public boolean challengeUser(String user, String contest){
        Usuario u =     Sistema.getUserByDNI(user);
        if(u != null){
            u.challenges.add(new Challenge(this.dni, user, contest));
            return true;
        } else{
            return false;
        }
    }
    
    public void acceptChallenge(Challenge c){
        if(c != null){
            c.setStatus("accepted");
            Sistema.getUserByDNI(c.getFrom()).wall.add(c.getFrom()+" ha retado a "+c.getFrom()+" en el concurso "+c.getContest());
            Sistema.getUserByDNI(c.getTo()).wall.add(c.getFrom()+" ha retado a "+c.getFrom()+" en el concurso "+c.getContest());
        }
    }
    
    public Challenge getChallenge(String user, String contest){
        Challenge res = null;
        
        for(Challenge c : challenges){
            if(c.getContest().equals(contest) && c.getFrom().equals(user) && c.getStatus().equals("accepted")){
                res = c;
            }
        }
        
        return res;
    }
    
    private void applyPenalty(String contest){
        for(Contest c : Sistema.getContests()){
            if(c.getTitle().equals(contest)){
                for(Sentence s : c.getSentences()){
                    if(s.getAuthor().equals(dni)){
                        s.setRating(s.getRating() - 1);
                    }
                    
                }
            }
            
        }
    }
    
    private ArrayList<Usuario> penalizeChallengers(String contest){
        ArrayList<Usuario> res = null;
        for(Challenge c : challenges){
            if(c.getContest().equals(contest)){
                Sistema.getUserByDNI(c.getFrom()).applyPenalty(contest);
            }
        }
    
        return res;
    }
    
    
}
