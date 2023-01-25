import java.util.*;

public class PRorSHR extends ArraysForStart {


    private String nazvanie_PRorSHR; // название ПР или ШР (ПР-1, ШРА-1, ШМА-1 и т.д.)
    private int[] nomera_oborudovaniya;// номер каждой группы электроприемников входищих в каждый ПР/ШР
    private int[] kolichesvo_stankov;// количесво каждой группы электроприемников входищих в каждый ПР/ШР


    PRorSHR(String nazvanie_PRorSHR, int[] nomera_oborudovaniya, int[] kolichesvo_stankov) {
        this.nazvanie_PRorSHR = nazvanie_PRorSHR;
        this.nomera_oborudovaniya = nomera_oborudovaniya;
        this.kolichesvo_stankov = kolichesvo_stankov;


        P_nom_All_gr.put(nazvanie_PRorSHR, PnomAllgr());
        P_sm_All_gr.put(nazvanie_PRorSHR, PsmAllgr());
        Q_sm_All_gr.put(nazvanie_PRorSHR, QsmAllgr());


        //  1, 4 ,8
        //  7, 12, 4

    }

    public double PnomAllgr() { //Номинальная мощность всех групп электроприемников входящих в группу ШР или ПР P_(ном гр)   кВт
        double sum = 0.0;

        for (int i = 0, j = nomera_oborudovaniya[i]; i < nomera_oborudovaniya.length; i++) {
            sum += P_Kazdogo_Priemnika.get(nazvanie_kazhdogo_priemnika.get(j)) * kolichesvo_stankov[i];/*
        сумма += получаю мощность приемника ( получаю String наименование оборудования из
        переменной "j"( согласно номерам в массиве "nomera_oborudovaniya")) и умножаю на количество этих станков в
        массиве "kolichesvo_stankov"
        */
        }
        return Math.round(sum * 100.0) / 100.0; // округление до 2-х знаков после запятой
    }

    public double PsmAllgr() { //Среднесменная активная всех групп электроприемников входящих в группу ШР или ПР P_(ном гр)   кВт
        double sum = 0.0;
        for (int i = 0, j = nomera_oborudovaniya[i]; i < nomera_oborudovaniya.length; i++) {
            sum += P_Kazdogo_Priemnika.get(nazvanie_kazhdogo_priemnika.get(j)) *
                    koefficient_Ispolzovaniya.get(nazvanie_kazhdogo_priemnika.get(j));
            /*
        сумма += получаю мощность приемника ( получаю String наименование оборудования из
        переменной "j"( согласно номерам в массиве "nomera_oborudovaniya")) и умножаю на коэффициент использования
        этих станков ( получаю String наименование оборудования изпеременной "j"
        ( согласно номерам в массиве "nomera_oborudovaniya"))
        */
        }
        return Math.round(sum * 100.0) / 100.0; // округление до 2-х знаков после запятой
    }

    public double QsmAllgr() { //Среднесменная реактивная всех групп электроприемников входящих в группу ШР или ПР P_(ном гр)   кВАр
        double sum = 0.0;
        for (int i = 0, j = nomera_oborudovaniya[i]; i < nomera_oborudovaniya.length; i++) {
            sum += P_sm_All_gr.get(nazvanie_kazhdogo_priemnika.get(j)) *
                    tg_f_Kazhdogo.get(nazvanie_kazhdogo_priemnika.get(j));
            /*
        сумма += получаю среднесменную мощность приемника ( получаю String наименование оборудования из
        переменной "j"( согласно номерам в массиве "nomera_oborudovaniya")) и умножаю на коэффициент мощности tgφ
        этих станков ( получаю String наименование оборудования изпеременной "j"
        ( согласно номерам в массиве "nomera_oborudovaniya"))
        */
        }
        return Math.round(sum * 100.0) / 100.0; // округление до 2-х знаков после запятой
    }

    public double m() { // Модуль (показатель) силовой сборки m

        ArrayList <Double> arrayList = new ArrayList<>();

        for (int i = 0, j = nomera_oborudovaniya[i]; i < nomera_oborudovaniya.length; i++) {
            arrayList.add(P_Kazdogo_Priemnika.get(nazvanie_kazhdogo_priemnika.get(j))); /*
        получаю мощность приемника ( получаю String наименование оборудования из
        переменной "j"( согласно номерам в массиве "nomera_oborudovaniya")) и добавляю в массив
        для дальнейшей сортировки
        */
        }
        Collections.sort(arrayList);

        return Math.round((arrayList.get(arrayList.size()-1)/arrayList.get(0)) * 10.0) / 10.0;  /*
         округление до 1-го знака после запятой
         самый мощный / самый маломощный станок в составе шинопровода
         */
    }

    public double Ki() { // Коэффициент использования ПР или ШР K_(и ПР1),кВАр
        return Math.round((PsmAllgr() / PnomAllgr()) * 100.0) / 100.0; // округление до 2-х знаков после запятой
    }

    public double tgf_PR_or_SHR() { // Средневзвешенный тангенс потерь ПР или ШР
        return Math.round((QsmAllgr() / PsmAllgr()) * 100.0) / 100.0; // округление до 2-х знаков после запятой
    }

    public double cosf_PR_or_SHR() { // Средневзвешенный тангенс потерь ПР или ШР
        return Math.round((Math.sqrt(1 / (1 + tgf_PR_or_SHR() * tgf_PR_or_SHR()))) * 100.0) / 100.0; // округление до 2-х знаков после запятой
    }

    public int n_ef() { // Эффективное число электроприемников n_э
        int sum = 0;
        for (int i = 0; i < Nomera_Grup_V_PRorSHR; i++) {
            sum += n_kolichestvo_v_gruppe.get(i);
        }
        return sum; //значение при n≥5,K_(и )≤0.2,m≥3 и〖 P〗_ном≠const, в других случаях будет подругому ,можно будет дополнить в будущем
    }

    public double K_max() { // Коэффициент максимума K_макс (данные из таблици по ссылке https://www.calc.ru/Raschetnaya-Nagruzka.html)
        int b = 0;
        int j = 0;
        int n = 0;
        double[][] K_max = {{3.23, 2.72, 2.24, 1.91, 1.62, 1.34, 1.23, 1.17, 1.05},
                {2.42, 1.99, 1.75, 1.55, 1.34, 1.19, 1.13, 1.1, 1.06},
                {1.76, 1.52, 1.36, 1.26, 1.19, 1.12, 1.09, 1.06, 1.05}};
        /*
        выбор из одномерных массивов (коэффициент использования {0 - 0.1},{0.11 - 0.2},{0.21 - 0.4})
        содержание одномерных массивов по количеству электроприемников{0-6, 7-9, 10-14, 16-20, 21-40, 41-70, 71-100, 101-160, 161-200}
        выбирал очень грубо, но для точной выборки необходимо переносить таблицу с данными полностью или учить SQL, но пока что иии тааак сойдет))
        */

        for (int i = 0; i < Nomera_Grup_V_PRorSHR.length; i++) { // расчет количества электроприборов которые входят в ПР или ШР
            n += n_kolichestvo_v_gruppe[(Nomera_Grup_V_PRorSHR[i] - 1)];
        }
        if (Ki() <= 0.1) {
            b = 0;
        } else if (Ki() <= 0.2) {
            b = 1;
        } else {
            b = 2;
        } // использую else на случай если Ki будет больше 0,4

        if (n <= 6) {
            b = 0;
        } else if (n <= 9) {
            j = 1;
        } else if (n <= 14) {
            j = 2;
        } else if (n <= 20) {
            j = 3;
        } else if (n <= 40) {
            j = 4;
        } else if (n <= 70) {
            j = 5;
        } else if (n <= 100) {
            j = 6;
        } else if (n <= 160) {
            j = 7;
        } else {
            j = 8;
        } // использую else на случай если n будет больше 160

        return K_max[b][j]; // округление до 2-х знаков после запятой
    }

    public double P_max() { // Средневзвешенный тангенс потерь ПР или ШР
        return Math.round(PsmAllgr() * K_max() * 100.0) / 100.0;  // округление до 2-х знаков после запятой
    }

    public double Q_max() { // Максимальная реактивная мощность ПР1 Q_(макс ПР1),кВАр
        return QsmAllgr();  // округление до 2-х знаков после запятой
    /*
        Q_(макс) = Q_см кВАр  при n>10 (в будущем можно изменить метод и добавить условие " при n<=10")
    */
    }

    public double S_max() { // Максимальная полная мощность ПР1 S_(макс ПР1), кВА
        return Math.round(Math.sqrt((P_max() * P_max()) + (Q_max() * Q_max())) * 100.0) / 100.0;  // округление до 2-х знаков после запятой
    }

    public double I_max() { // Максимальный ток нагрузки ПР1 I_(макс ПР1), A
        return Math.round(((S_max() * 1000) / (Math.sqrt(3) * 380)) * 100) / 100.0;  // округление до 2-х знаков после запятой
    }



    /*
    пройтись с самого начала по методам и впихнуть округление
    с помощью Math.round до 2-х знаков после запятой  туда где можно


    */


}

