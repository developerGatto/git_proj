package utemezo;

public class Task {

    private String nev;
    private Integer prioritas;
    private Integer erkezes;
    private Integer loketido;
    private Integer done = 0;
    private Integer init_loketido;

    public Task(String nev, Integer prioritas, Integer erkezes, Integer loketido) {
        this.nev = nev;
        this.prioritas = prioritas;
        this.erkezes = erkezes;
        this.loketido = loketido;
        this.init_loketido = loketido;
    }

    public Integer getInit_loketido() {
        return init_loketido;
    }

    public void setDone(Integer done) {
        this.done = done;
    }

    public Integer getDone() {
        return done;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Integer getPrioritas() {
        return prioritas;
    }

    public void setPrioritas(Integer prioritas) {
        this.prioritas = prioritas;
    }

    public Integer getErkezes() {
        return erkezes;
    }

    public void setErkezes(Integer erkezes) {
        this.erkezes = erkezes;
    }

    public Integer getLoketido() {
        return loketido;
    }

    public void setLoketido(Integer loketido) {
        this.loketido = loketido;
    }


}
