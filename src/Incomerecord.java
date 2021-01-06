public class Incomerecord {

    public Incomerecord(String name, int summ) {
        this.name = name;
        this.summ = summ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSumm() {
        return summ;
    }

    public void setSumm(int summ) {
        this.summ = summ;
    }

    String name;
    int summ;
}
