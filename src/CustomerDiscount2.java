public class CustomerDiscount2 extends Customer {
    @Override
    public String requestBuy(int userID, int recipeID, int count, double actualPrice) {
        actualPrice*=0.95;
        return super.requestBuy(userID, recipeID, count, actualPrice);
    }
}
