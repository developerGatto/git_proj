package utemezo;

import java.util.Comparator;

public class SJFTaskComparator implements Comparator<Task> {

    @Override
    public int compare(Task task1, Task task2) {
        int erkezesCompare = task1.getErkezes().compareTo(task2.getErkezes());
        int loketidoCompare = task1.getLoketido().compareTo(task2.getLoketido());
        int nevCompare = task1.getNev().compareTo(task2.getNev());

        if (erkezesCompare == 0) {
            if (loketidoCompare == 0) {
                return nevCompare;
            }
            return loketidoCompare;
        }
        return erkezesCompare;
    }
}
