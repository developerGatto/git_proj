package utemezo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static void vegrehajt(String nev) {
        System.out.print(nev);
    }

    public static void main(String[] args) {

        int ciklusido = 0;
        int rr_utem = 0;

        List<Task> sjf = new ArrayList<>();
        List<Task> rr = new ArrayList<>();
        List<Task> done = new ArrayList<>();



        Scanner beolvas = new Scanner(System.in);
        while (beolvas.hasNextLine()) {
            String[] sor = beolvas.nextLine().split(",");
            Task task = new Task(sor[0], Integer.parseInt(sor[1]), Integer.parseInt(sor[2]), Integer.parseInt(sor[3]));

            if (task.getPrioritas() == 0) {
                rr.add(task);
            }
            else {
                sjf.add(task);
            }
        }


        Collections.sort(sjf, new SJFTaskComparator());
        Collections.sort(rr, new RRTaskComparator());
        String elozo = "";

        while (!sjf.isEmpty() || !rr.isEmpty()) {

            if (!sjf.isEmpty()) {
                if (sjf.get(0).getErkezes() <= ciklusido) {
                    elozo = sjf.get(0).getNev();
                    vegrehajt(sjf.get(0).getNev());
                    ciklusido += sjf.get(0).getLoketido();
                    sjf.get(0).setDone(ciklusido);
                    done.add(sjf.get(0));
                    sjf.remove(0);
                    if (rr_utem != 0) {
                        rr_utem = 2;
                    }
                    continue;
                }
            }
            if (!rr.isEmpty()) {
                if (rr.get(0).getErkezes() <= ciklusido) {
                    if (rr_utem == 2) {
                        Collections.rotate(rr, -1);
                        rr_utem = 0;
                    }

                    if (rr_utem == 0 && !rr.get(0).getNev().equals(elozo)) {
                        vegrehajt(rr.get(0).getNev());
                        elozo = rr.get(0).getNev();
                    }


                    rr.get(0).setLoketido(rr.get(0).getLoketido() -1);
                    rr_utem++;
                    if (rr.get(0).getLoketido() == 0) {
                        rr.get(0).setDone(ciklusido + 1);
                        done.add(rr.get(0));
                        rr.remove(0);
                        rr_utem = 0;
                    }
                }
            }
            ciklusido ++;
        }

        System.out.println();
        Collections.sort(done, new RRTaskComparator());
        for (int i = 0; i < done.size(); i++) {
            System.out.print(done.get(i).getNev() + ":" + (done.get(i).getDone()
                    - done.get(i).getErkezes() - done.get(i).getInit_loketido()));
            if (i != done.size() - 1) {
                System.out.print(",");
            }
        }
    }






}
