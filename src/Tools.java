public class Tools {
    public static boolean isNumber(String money)
    {
        return money.equals(String.valueOf(Double.parseDouble(money))) || money.equals(String.valueOf(Integer.parseInt(money)));
    }
}
