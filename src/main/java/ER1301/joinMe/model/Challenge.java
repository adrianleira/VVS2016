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
public class Challenge {
    private String from;
    private String to;
    private String contest;
    private String status;

    public Challenge(String from, String to, String contest) {
        this.from = from;
        this.to = to;
        this.contest = contest;
        this.status = "pending";
    }

    public String getFrom() {
        return from;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContest() {
        return contest;
    }

    public void setContest(String contest) {
        this.contest = contest;
    }
    
}
