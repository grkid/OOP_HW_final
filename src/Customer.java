import java.util.Date;

public class Customer extends People implements RequestCustomer  {
    @Override
    public String requestBuy(int userID, int recipeID, int count, double actualPrice) {
        String fake_sql=Str.request+Str.buy+userID+" "+recipeID+" "+count+" "+actualPrice;
        return WebConnector.post(fake_sql);
    }
}
