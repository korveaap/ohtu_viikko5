package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

//        Matcher m = new And( new HasAtLeast(60, "points"),
//                             
//                             new PlaysIn("EDM")
//        );
//        Matcher m = new And( new HasAtLeast(10, "goals"),
//                             new HasFewerThan(20, "assists"),
//                             new PlaysIn("PHI")
//        );
//        Matcher m = new Or( new And (new HasAtLeast(30, "goals"),
//                             new HasAtLeast(30, "assists") ), 
//                             new HasAtLeast(40, "assists")
//        );
        //Matcher m = new And(new Not( new PlaysIn("PHI") ),new Not( new PlaysIn("PIT") ));
        QueryBuilder query = new QueryBuilder();
        

        //Matcher m = query.playsIn("NYR").hasAtLeast(10, "goals").build();
//        Matcher m1 = query.playsIn("PHI")
//                .hasAtLeast(10, "goals")
//                .hasFewerThan(20, "assists").build();
//
//        Matcher m2 = query.playsIn("EDM")
//                .hasAtLeast(60, "points").build();

        //Matcher m = query.oneOf(m1, m2).build();
        
        Matcher m = query.oneOf(
                        query.playsIn("PHI")
                             .hasAtLeast(10, "goals")
                             .hasFewerThan(20, "assists").build(),
 
                        query.playsIn("EDM")
                             .hasAtLeast(60, "points").build()
                       ).build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
