package lab.lab1;

public class Currency {
    public static double getVal(String currency) {
        switch (currency) {
            case "Доллар":
                return 0.3125;
            case "Евро":
                return 0.2963;
            case "Тугрик":
                return 1052.03;
            case "Рубль РФ":
                return 29.2085;
            default:
                return 0;
        }
    }
}
