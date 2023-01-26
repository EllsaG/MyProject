import java.util.Objects;

public class GuppaElectropriemnikov extends ArraysForStart {

    private int n_pozicii_v_tablice; //номер позиции в таблице(перечне электрооборудования) для каждого наименования
    private String name; //Наименование электроприемника
    private double Pnom; //Мощность одного электроприемника Рн кВт
    private int n; // Количество электроприемников n, шт
    private double Ki; //Коэффициент использования Ки
    private double cosf; //Коэффициент мощности cosφ
    private double tgf; //Коэффициент мощности tgφ


    GuppaElectropriemnikov(int n_pozicii_v_tablice, String name, double Pnom,
                           int n, double Ki, double cosf, double tgf) {
        this.n_pozicii_v_tablice = n_pozicii_v_tablice;
        this.name = name;
        this.Pnom = Pnom;
        this.n = n;
        this.Ki = Ki;
        this.cosf = cosf;
        this.tgf = tgf;

        nazvanie_kazhdogo_priemnika.put(n_pozicii_v_tablice, name);
        P_Kazdogo_Priemnika.put(name, Pnom);
        koefficient_Ispolzovaniya.put(name, Ki);
        n_kolichestvo_v_gruppe.put(name, n) ;
        cos_f_Kazhdogo.put(name, cosf);
        tg_f_Kazhdogo.put(name, tgf);
        P_sm_Kazdogo_Priemnikov.put(name, PsmOne());
        Q_sm_Kazdogo_Priemnikov.put(name, QsmOne());



    }


    public double PsmOne() { // Среднесменная активная мощность группы электроприемников P_(см ),кВт
        return Math.round(P_Kazdogo_Priemnika.get(name) *
                koefficient_Ispolzovaniya.get(name) *100.0)/100.0;
    }

    public double QsmOne() { // Среднесменная реактивная мощность группы электроприемников Q_см,кВАр
        return Math.round(P_sm_Kazdogo_Priemnikov.get(name) *
                tg_f_Kazhdogo.get(name)*100.0)/100.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuppaElectropriemnikov that = (GuppaElectropriemnikov) o;
        return n_pozicii_v_tablice == that.n_pozicii_v_tablice &&
                Double.compare(that.Pnom, Pnom) == 0 &&
                n == that.n && Double.compare(that.Ki, Ki) == 0 &&
                Double.compare(that.cosf, cosf) == 0 &&
                Double.compare(that.tgf, tgf) == 0 &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(n_pozicii_v_tablice, name, Pnom, n, Ki, cosf, tgf);
    }
}
