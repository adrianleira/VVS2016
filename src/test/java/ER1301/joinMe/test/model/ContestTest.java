/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ER1301.joinMe.test.model;

import java.util.ArrayList;
import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

import ER1301.joinMe.model.Contest;
import ER1301.joinMe.model.Sentence;

import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class ContestTest {
    
    private Contest c1, c2, c3;
    private Sentence sentence1, sentence2, sentence3;
    private String p1, p2, p3;
    
    
    public ContestTest() {
    }
    
    @Before
    public void setUp() {
        
        Calendar fechaInicio = Calendar.getInstance(); 
        Calendar fechaFin = Calendar.getInstance();
        fechaInicio.set(2016, Calendar.JANUARY, 1);
        fechaFin.set(2016, Calendar.JANUARY, 31);
          
        c1 = new Contest(fechaInicio, fechaFin , "Concurso 1");
        sentence1 = new Sentence("Paco", "Java es genial", c1.getTitle());
        
        Calendar fechaInicio2 = Calendar.getInstance(); 
        Calendar fechaFin2 = Calendar.getInstance();
        fechaInicio2.set(2016, Calendar.FEBRUARY, 1);
        fechaFin2.set(2016, Calendar.FEBRUARY, 29);
        
        c2 = new Contest(fechaInicio2, fechaFin2 , "Me gusta Join Me!");
        sentence2 = new Sentence("Luis", "Java es genial", c2.getTitle());
        
    }
    
    /**
     * Test of getStart method, of class Contest.
     * PR-UN-011
     */
    @Test
    public void testGetStart() {

        Calendar expResult = Calendar.getInstance();
        expResult.set(2016, Calendar.JANUARY, 1);
        Calendar result = c1.getStart();
        assertEquals(expResult.getTimeInMillis(), result.getTimeInMillis(), 100);
    }

    /**
     * Test of setStart method, of class Contest.
     * PR-UN-012
     */
    @Test
    public void testSetStart() {

        Calendar start = Calendar.getInstance();
        start.set(2016, Calendar.JANUARY, 1);
        c1.setStart(start);
        assertEquals(start, c1.getStart());
        
    }

    /**
     * Test of getEnd method, of class Contest.
     * PR-UN-013
     */
    @Test
    public void testGetEnd() {

        Calendar expResult = Calendar.getInstance();
        expResult.set(2016, Calendar.JANUARY, 31);
        Calendar result = c1.getEnd();
        assertEquals(expResult.getTimeInMillis(), result.getTimeInMillis(), 100);
    }

    /**
     * Test of setEnd method, of class Contest.
     * PR-UN-014
     */
    @Test
    public void testSetEnd() {

        Calendar end = Calendar.getInstance();
        end.set(2016, Calendar.JANUARY, 31);
        c1.setEnd(end);
        assertEquals(end, c1.getEnd());
    }

    /**
     * Test of getParticipants method, of class Contest
     * PR-UN-015.
     */
    @Test
    public void testGetParticipants() {

        ArrayList<String> expResult = new ArrayList<>();
        expResult.add(p1);
        expResult.add(p2);
        
        ArrayList<String> result = c1.getParticipants();
        result.add(p1);
        result.add(p2);
        
        assertEquals(expResult, result);

    }

    /**
     * Test of setParticipants method, of class Contest.
     * PR-UN-016
     */
    @Test
    public void testSetParticipants() {

        ArrayList<String> participants = new ArrayList<>();
        participants.add(p1);
        participants.add(p2);
        
        c1.setParticipants(participants);
        assertFalse(c1.getParticipants().isEmpty());
        assertEquals(c1.getParticipants().size(), 2);
    }

    /**
     * Test of getSentences method, of class Contest.
     * PR-UN-017
     */
    @Test
    public void testGetSentences() {
        
        ArrayList<Sentence> expResult = null;
        c1.setSentences(expResult);
        
        ArrayList<Sentence> result = c1.getSentences();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setSentences method, of class Contest.
     * PR-UN-018
     */
    @Test
    public void testSetSentences() {
        ArrayList<Sentence> sentences = new ArrayList<>();
        sentences.add(sentence1);
        c1.setSentences(sentences);
        assertFalse(c1.getSentences().isEmpty());

    }

    /**
     * Test of getTitle method, of class Contest.
     * PR-UN-019
     */
    @Test
    public void testGetTitle() {

        String expResult = "Concurso 1";
        String result = c1.getTitle();
        assertEquals(expResult, result);
        
	assertTrue(c1.getTitle().equals(expResult));	
    }

    /**
     * Test of setTitle method, of class Contest.
     * PR-UN-020
     */
    @Test
    public void testSetTitle() {

        String title = "Cambio";
        c2.setTitle(title);
        assertTrue(c2.getTitle().equals("Cambio"));	
    }

    /**
     * Test of getState method, of class Contest.
     */
    @Test
    public void testGetState() {

    /*    ArrayList<Sentence> sentences = new ArrayList<>();
        sentences.add(sentence1);
        c1.setSentences(sentences);
        sentence1 = new Sentence("Paco", "Java es genial", c1.getTitle());
        
        String autor = sentence1.getAuthor();
        sentence1.setAuthor("Paco");
        String sentence = sentence1.getSentence();
        sentence1.setSentence("Java es genial");
        String expResult = autor + "\n" + sentence;

        assertEquals(c1.getState(),expResult);*/

    }
    
}