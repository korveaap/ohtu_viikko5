/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

/**
 *
 * @author aapo
 */
public class QueryBuilder {
    Matcher matcher;
    
    public QueryBuilder() {
        this.matcher = new And();
    }
            
    
    public QueryBuilder playsIn(String team) {
        this.matcher = new And(this.matcher,new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = new And(this.matcher,new HasAtLeast(value, category));
        return this;
    }
    
     public QueryBuilder hasFewerThan(int value, String category) {
        this.matcher = new And(this.matcher,new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder oneOf (Matcher m1, Matcher m2) {
        this.matcher = new Or(m1,m2);
        return this;
    }
    
    public Matcher build() {
        Matcher m = new And(this.matcher);
        this.matcher = new And();
        return m;
    }
}
