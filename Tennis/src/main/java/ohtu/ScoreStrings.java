/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import java.util.HashMap;

/**
 *
 * @author aapo
 */


public class ScoreStrings {
    private HashMap<Integer, String> scoreString = new HashMap();

    public ScoreStrings() {
        scoreString.put(0, "Love");
        scoreString.put(1, "Fifteen");
        scoreString.put(2, "Thirty");
        scoreString.put(3, "Forty");
    }

    public HashMap<Integer, String> getScoreString() {
        return scoreString;
    }
    
    
    
}
