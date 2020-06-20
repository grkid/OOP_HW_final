public class Str {
    //警告消息
    public static String error="ERROR ";

    //ERROR <info>

    //目的
    public static String request="REQUEST ";
    public static String result="RESULT ";

    //结果
    public static String success="SUCCESS ";
    public static String failed="FAILED ";

    //"人"的事务集合
    //REQUEST ADDMONEY id val
    //REQUEST WITHDRAWMONEY id val
    //REQUEST LOGIN id pd
    //REQUEST REGISTER type pd Name 返回用户ID
    //REQUEST ALTERPASSWORD id origin_password new_password 更改密码
    //REQUEST GET ALLRECIPE 返回所有商品的所有信息
    //REQUEST GET  MONEY UserID  返回钱数
    //REQUEST GET INFO id 返回所有有关我的订单信息

    public static String addMoney="ADDMONEY ";
    public static String withdrawMoney="WITHDRAWMONEY ";
    public static String login="LOGIN ";
    public static String register="REGISTER ";
    public static String get="GET ";
    public static String allRecipe="ALLRECIPE ";
    public static String money="MONEY ";
    public static String alterPassword="ALTERPASSWORD ";
    public static String recipeInfo="RECIPEINFO ";
    public static String info="INFO ";
    public static String getPic="GETPIC ";

    //商家事务集合
    //REQUEST ADDRECIPE UserID Recipe_name PicDir Price Description
    //REQUEST DELETERECIPE RecipeID
    //REQUEST ALTERRECIPE RecipeID UserID Recipe_name PicDir Price Description
    //REQUEST SAVE UserID RecipeName <Base64>

    public static String addRecipe="ADDRECIPE ";
    public static String deleteRecipe="DELETERECIPE ";
    public static String alterRecipe="ALTERRECIPE ";
    public static String save="SAVE ";
    public static String alterName="ALTERNAME ";

    //REQUEST GET RECIPE UserID 返回个人的所有信息
    public static String recipe="RECIPE ";

    //顾客事务集合
    //REQUEST BUY UserID RecipeID count time actualPrice
    public static String buy="BUY ";
    public static String customerRecord="CUSTOMRECORD ";
    //管理员事务集合
    //REQUEST COUNT ...
    //TODO
    public static String admin="ADMIN ";

    public static String count="COUNT ";

    public static String customer="CUSTOMER ";
    public static String seller="SELLER ";
    public static String customerDiscount1="CUSTOMER_DISCOUNT1 ";//每一单都可以减免一元
    public static String customerDiscount2="CUSTOMER_DISCOUNT2 ";//每一单都可以打九五折
}
