/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ER1301.joinMe.model;

/**
 *
 * @author alex030293
 */
public class Sentence {
    private String author;
    private String sentence;
    private String contest;
    private Integer rating;

    public Sentence(String author, String sentence, String contest) {
        this.author = author;
        this.sentence = sentence;
        this.contest = contest;
        this.rating = 0;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getContest() {
        return contest;
    }

    public void setContest(String contest) {
        this.contest = contest;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    
    
}
