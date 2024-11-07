package inheritance.lab.randomarraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {
    List<Integer> randomList;

    public RandomArrayList() {
        this.randomList = new ArrayList<>();
    }

    public int getRandomElement() {
        Random random = new Random();
        int randomIndex = random.nextInt(0, randomList.size());
        return this.randomList.remove(randomIndex);
    }
}
