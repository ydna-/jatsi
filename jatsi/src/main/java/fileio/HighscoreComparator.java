package fileio;

import java.util.Comparator;

/**
 * Vertailuluokka Highscore-luokan olioille.
 */
public class HighscoreComparator implements Comparator<Highscore> {
    
    @Override
    public int compare(Highscore first, Highscore second) {
        if (first.getTotal() > second.getTotal()) {
            return -1;
        } else if (first.getTotal() < second.getTotal()) {
            return 1;
        } else {
            return 0;
        }
    }
    
}
