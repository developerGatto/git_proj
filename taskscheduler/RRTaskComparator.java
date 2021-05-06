package utemezo;

import java.util.Comparator;

public class RRTaskComparator implements Comparator<Task> {

    @Override
    public int compare(Task task1, Task task2) {
        int erkezesCompare = task1.getErkezes().compareTo(task2.getErkezes());
        int nevCompare = task1.getNev().compareTo(task2.getNev());

        return (erkezesCompare == 0) ? nevCompare : erkezesCompare;

    }

}
