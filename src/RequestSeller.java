public interface RequestSeller extends RequestPeople {
    //商家事务集合
    //REQUEST ADDRECIPE UserID Recipe_name Price Description <pic base64> 返回菜品ID
    //REQUEST DELETERECIPE RecipeID
    //REQUEST ALTERRECIPE RecipeID UserID Recipe_name PicDir Price Description
    //删除 //REQUEST SAVE UserID RecipeID <Base64>
    //REQUEST GET RECIPE UserID 返回个人的所有外卖信息

    String RequestAddRecipe(int userID,String RecipeName,String picDir,double price,String description);

    String RequestDeleteRecipe(int recipeID);

    String RequestAlterRecipe(int recipeID,int UserId,String RecipeName,String picDir,double price,String description);

    //String requestSavePic(int userID,int recipeID,String picDir);

    String RequestGetRecipe(int userID);
}
