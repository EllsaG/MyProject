
import java.util.ArrayList;
import java.util.HashMap;

public  class ArraysForStart {


    public static HashMap<Integer,String> nazvanie_kazhdogo_priemnika = new HashMap<>();// название каждой группы электроприемников, ключ - номер позиции в таблице(перечне электрооборудования)
    public static HashMap<String, Integer> n_kolichestvo_v_gruppe = new HashMap<>();// количество электроприемников в каждой группе, ключ - наименование оборудования
    public static HashMap<String, Double> P_Kazdogo_Priemnika= new HashMap<>(); //номинальная мощность каждого отдельно взятого приемника, ключ - наименование оборудования
    public static HashMap<String, Double> P_sm_Kazdogo_Priemnikov= new HashMap<>(); // номинальная мощность групп приемников, ключ - наименование оборудования
    public static HashMap<String, Double> Q_sm_Kazdogo_Priemnikov= new HashMap<>();// номинальная мощность групп приемников, ключ - наименование оборудования
    public static HashMap<String, Double> koefficient_Ispolzovaniya = new HashMap<>(); // коэффициент использования каждой группы, ключ - наименование оборудования
    public static HashMap<String, Double> cos_f_Kazhdogo = new HashMap<>(); //Коэффициент мощности cosφ каждого отдельно взятого приемника, ключ - наименование оборудования
    public static HashMap<String, Double> tg_f_Kazhdogo = new HashMap<>(); //Коэффициент мощности tgφ каждого отдельно взятого приемника, ключ - наименование оборудования


    public static ArrayList<String> nazvanie_PRorSHR = new ArrayList<>(); // названия всех ПР и ШР, ключ - наименование шинопровода или ПР
    public static HashMap<String, Double>  P_nom_All_PRorSHR = new HashMap<>(); // Номинальная мощность всех ПР и ШР, ключ - наименование шинопровода или ПР
    public static HashMap<String, Double>  P_sm_All_gr_PRorSHR = new HashMap<>(); // Номинальная мощность всех ПР и ШР, ключ - наименование шинопровода или ПР
    public static HashMap<String, Double>  Q_sm_All_gr_PRorSHR = new HashMap<>(); // Номинальная мощность всех ПР и ШР, ключ - наименование шинопровода или ПР
    public static HashMap<String, Double>  modul_silivoi_sborki = new HashMap<>(); // Модуль (показатель) силовой сборки m, ключ - наименование шинопровода или ПР
    public static HashMap<String, Double>  K_i_PRorSHR = new HashMap<>(); // Коэффициент использования K_i задается в методе класса (PRorSHR) для кажого ПР или ШР, ключ - наименование шинопровода или ПР
    public static HashMap<String, Double>  tg_f_PRorSHR = new HashMap<>(); // Тангенс потерь tgf задается в методе класса (PRorSHR) для кажого ПР или ШР, ключ - наименование шинопровода или ПР
    public static HashMap<String, Double>  cos_f_PRorSHR = new HashMap<>(); // Коэффициент мощности cosf K_макс задается в методе класса (PRorSHR) для кажого ПР или ШР, ключ - наименование шинопровода или ПР
    public static HashMap<String, Integer>  n_ef_PRorSHR = new HashMap<>(); // Эффективное чисто электроприемнико n_ef задается в методе класса (PRorSHR) для кажого ПР или ШР, ключ - наименование шинопровода или ПР
    public static HashMap<String, Double>  k_max_PRorSHR = new HashMap<>(); // Коэффициент максимума K_макс задается в методе класса (PRorSHR) для кажого ПР или ШР, ключ - наименование шинопровода или ПР
    public static HashMap<String, Double>  P_max_PRorSHR = new HashMap<>(); // Максимальная мощность всех ПР и ШР, ключ - наименование шинопровода или ПР
    public static HashMap<String, Double>  Q_max_PRorSHR = new HashMap<>(); // Максимальная мощность всех ПР и ШР, ключ - наименование шинопровода или ПР
    public static HashMap<String, Double>  S_max_PRorSHR = new HashMap<>(); // Максимальная мощность всех ПР и ШР, ключ - наименование шинопровода или ПР
    public static HashMap<String, Double>  I_max_PRorSHR = new HashMap<>(); // Максимальная ток нагрузки всех ПР и ШР, ключ - наименование шинопровода или ПР




}
