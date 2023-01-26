public class Main {

    public static void main(String[] args) {

        GuppaElectropriemnikov gr1 = new GuppaElectropriemnikov(1, "Станок универсальный", 5.5, 3, 0.17, 0.65, 1.16);
        GuppaElectropriemnikov gr2 = new GuppaElectropriemnikov(2, "Устройство подъемно-поворотное", 5.5, 2, 0.4, 0.75, 0.8);
        GuppaElectropriemnikov gr3 = new GuppaElectropriemnikov(3, "Вентиляционно-продувная система", 3.0, 1, 0.6, 0.8, 0.75);
        GuppaElectropriemnikov gr4 = new GuppaElectropriemnikov(4, "Станок вертикально сверлильный", 17.5, 5, 0.16, 0.5, 1.73);

        PRorSHR PR1 = new PRorSHR("ПР-1", new int[]{1, 2, 3, 4}, new int[]{3, 2, 1, 5});


        System.out.println(ArraysForStart.I_max_PRorSHR);





    }

}






