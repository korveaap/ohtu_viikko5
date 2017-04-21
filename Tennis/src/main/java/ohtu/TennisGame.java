package ohtu;

import java.util.HashMap;

public class TennisGame {

    private int player1Points = 0;
    private int player2Points = 0;
    private String player1Name;
    private String player2Name;
    private boolean advantageSituation = false;
    private boolean deuceSituation = true;    
    private int scoreDifference = 0;
    private HashMap<Integer, String> scoreString;
      

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        ScoreStrings scoreStrings = new ScoreStrings();
        scoreString = scoreStrings.getScoreString();
        
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name)) {
            player1Points += 1;
        } else {
            player2Points += 1;
        }
        updateSituation();
    }

    private void updateSituation() {
        if (player1Points == player2Points) {
            deuceSituation = true;
        } else {
            deuceSituation = false;
        }
        if (player1Points >= 4 || player2Points >= 4) {
            advantageSituation = true;
        }
        scoreDifference =  player1Points - player2Points;
    }

    public String getScore() {
        String score = "";
        if (deuceSituation) {
            score = deuceScore();
        } else if (advantageSituation) {
            score = advantageScore();
        } else {
            score = normalScore(score);
        }
        return score;
    }

    private String normalScore(String score) {

        score = scoreString.get(player1Points) + "-" + scoreString.get(player2Points);
        return score;
    }

    private String advantageScore() {
                    
        String situation = advantageOrWin();
        String winningPlayer = winningPlayer();
        return situation + " " + winningPlayer;
    }

    private String winningPlayer() {
        String winningPlayer = player1Name;
        if (scoreDifference < 0) {
            winningPlayer = player2Name;
        }
        return winningPlayer;
    }

    private String advantageOrWin() {
        String situation = "Advantage";
        if (Math.abs(scoreDifference) >= 2) {
            situation = "Win for";
        }
        return situation;
    }

    private String deuceScore() {
        String score;
        if (player1Points <= 3) {
            score = scoreString.get(player1Points) + "-All";
        } else {
            score = "Deuce";
        }
        return score;
    }
}
