package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario on 5/12/16.
 */
public class EuroMillonesModel {
    private List<Integer> winnerCombination;
    private List<Integer> stars;

    public Double totalBets=0.0;
    public Double collection=0.0;
    public Double jackpot=0.0;
    public Double prizes=0.0;

    public EuroMillonesModel() {
        this.winnerCombination = new ArrayList<Integer>();
        this.stars = new ArrayList<Integer>();
    }

    public boolean addStar(Integer integer) {
        return stars.add(integer);
    }

    public boolean addNumber(Integer integer) {
        return winnerCombination.add(integer);
    }

    @Override
    public String toString() {
        return "EuroMillonesModel{" + "\n" +
                "winnerCombination=" + winnerCombination.toString() + "\n" +
                ", stars=" + stars.toString() + "\n" +
                ", totalBets=" + totalBets.toString() + "\n" +
                ", recaudation=" + collection.toString() + "\n" +
                ", bote=" + jackpot.toString() + "\n" +
                ", rewards=" + prizes.toString()+ "\n" +
                '}';
    }
}
