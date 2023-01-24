import java.util.Objects;

public class GuppaElectropriemnikov extends ArraysForStart {

    int n_pozicii_v_tablice; //номер позиции в таблице(перечне электрооборудования) для каждого наименования
    String name; //Наименование электроприемника
    double Pnom; //Мощность одного электроприемника Рн кВт
    int n; // Количество электроприемников n, шт
    double Ki; //Коэффициент использования Ки
    double cosf; //Коэффициент мощности cosφ
    double tgf; //Коэффициент мощности tgφ


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
        n_kolichestvo_v_gruppe.put(name, n) ;
        koefficient_Ispolzovaniya.put(name, Ki);
        cos_f_Kazhdogo.put(name, cosf);
        tg_f_Kazhdogo.put(name, cosf);
        P_Vseh_Priemnikov.put(name, PnomOnegr());
        P_sm_Vseh_Priemnikov.put(name, PsmOnegr());
        Q_sm_Vseh_Priemnikov.put(name, QsmOnegr());

    }

    public double PnomOnegr() { // Номинальная мощность группы электроприемников P_(ном гр)   кВт

        return P_Kazdogo_Priemnika.get(name) * n_kolichestvo_v_gruppe.get(name);
    }

    public double PsmOnegr() { // Среднесменная активная мощность группы электроприемников P_(см ),кВт
        return P_Vseh_Priemnikov.get(name) * koefficient_Ispolzovaniya.get(name);
    }

    public double QsmOnegr() { // Среднесменная реактивная мощность группы электроприемников Q_см,кВАр
        return P_sm_Vseh_Priemnikov.get(name) * tgf;
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
