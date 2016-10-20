/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ER1301.joinMe.model;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author alex030293
 */
public class Contest {
    private Calendar start;
    private Calendar end;
    private ArrayList<String> participants;
    private ArrayList<Sentence> sentences;
    private String title;
    
    private ArrayList <Contest> listaValoraciones = new ArrayList<Contest>();

    public Contest(Calendar start, Calendar end, String title) {
        this.start = start;
        this.end = end;
        this.participants = new ArrayList<String>();
        this.sentences = new ArrayList<Sentence>();
        this.title = title;
    }

    public Calendar getStart() {
        return start;
    }

    public void setStart(Calendar start) {
        this.start = start;
    }

    public Calendar getEnd() {
        return end;
    }

    public void setEnd(Calendar end) {
        this.end = end;
    }

    public ArrayList<String> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<String> participants) {
        this.participants = participants;
    }

    public ArrayList<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(ArrayList<Sentence> sentences) {
        this.sentences = sentences;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public void addParticipantsToContest(String participant){
        
        if (!this.participants.contains(participant))
        this.participants.add(participant);
    }
    
    public void addSentenceToContest(Sentence sentence){
        
         this.sentences.add(sentence);
    }
    
    
    public List<String> getSentencesDetails(){
        List<String> listDetails = new ArrayList<String>();
         for (Sentence s : this.sentences){
             listDetails.add(s.getSentence() + " (" + s.getAuthor()+ ")"+ " - Valoración:  " + s.getRating());
         }
         
         return listDetails;
    }
    
    public void rateSentence(Sentence sentence, Integer rate){
        if (sentences.contains(sentence))
            sentence.setRating(rate);
    }

    public String getState(){
        String res = "";
        Calendar now = Calendar.getInstance();
        if (this.getStart().getTimeInMillis() <= now.getTimeInMillis())
            res += "NOT STARTED";
        if (this.getStart().getTimeInMillis() <= now.getTimeInMillis())
            res += "STARTED";
        if (now.getTimeInMillis() <= this.getEnd().getTimeInMillis()){
            res += "FINISHED:\n";
            Collections.sort(this.sentences, new Comparator<Sentence>() {
                public int compare(Sentence s1, Sentence s2) {
                    return s1.getRating() - s2.getRating();
                }
            });
            res += "winner = " + this.sentences.get(0).getAuthor() + this.sentences.get(0).getSentence();
        }
        
        return "";
    }
    
}
