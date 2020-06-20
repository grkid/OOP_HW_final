public class CustomerDiscount1 extends Customer {

    @Override
    public String requestBuy(int userID, int recipeID, int count, double actualPrice) {
        actualPrice=(actualPrice-1>0)?(actualPrice-1):0;
        return super.requestBuy(userID, recipeID, count, actualPrice);
    }
}
