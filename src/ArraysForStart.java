import java.util.ArrayList;
import java.util.HashMap;

public class ArraysForStart {

    public static int nVsegoPR_SHR = 0; // количество ПР и ШР которые будут на схеме

    public static HashMap<Integer,String> nazvanie_kazhdogo_priemnika = new HashMap<>();// название каждой группы электроприемников, ключ - номер позиции в таблице(перечне электрооборудования)
    public static HashMap<String, Integer> n_kolichestvo_v_gruppe = new HashMap<>();// количество электроприемников в каждой группе, ключ - наименование оборудования
    public static HashMap<String, Double> P_Kazdogo_Priemnika= new HashMap<>(); //номинальная мощность каждого отдельно взятого приемника, ключ - наименование оборудования
    public static HashMap<String, Double> koefficient_Ispolzovaniya = new HashMap<>(); // коэффициент использования каждой группы, ключ - наименование оборудования
    public static HashMap<String, Double> cos_f_Kazhdogo = new HashMap<>(); //Коэффициент мощности cosφ каждого отдельно взятого приемника, ключ - наименование оборудования
    public static HashMap<String, Double> tg_f_Kazhdogo = new HashMap<>(); //Коэффициент мощности tgφ каждого отдельно взятого приемника, ключ - наименование оборудования
    public static HashMap<String, Double> P_Vseh_Priemnikov= new HashMap<>(); // номинальная мощность групп приемников, ключ - наименование оборудования
    public static HashMap<String, Double> P_sm_Vseh_Priemnikov= new HashMap<>(); // номинальная мощность групп приемников, ключ - наименование оборудования
    public static HashMap<String, Double> Q_sm_Vseh_Priemnikov= new HashMap<>();// номинальная мощность групп приемников, ключ - наименование оборудования



    public static HashMap<String, Integer>   //количество каждого вида приемника на 1 ПР/ШР
    public static double[] P_nom_All_gr = new double[4]; // Номинальная мощность всех ПР и ШР в порядке создания объектов
    public static double[] P_sm_All_gr = new double[4]; // Номинальная мощность всех ПР и ШР в порядке создания объектов
    public static double[] Q_sm_All_gr = new double[4]; // Номинальная мощность всех ПР и ШР в порядке создания объектов
    public static double[] K_i_PR_or_SHR = new double[5]; // Коэффициент максимума K_макс задается в методе класса (PRorSHR) для кажого ПР или ШР



}
