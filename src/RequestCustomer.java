import java.util.Date;

public interface RequestCustomer extends RequestPeople {
    //顾客事务集合
    //REQUEST BUY UserID RecipeID count time actualPrice
    String requestBuy(int userID, int recipeID, int count,double actualPrice);
}
