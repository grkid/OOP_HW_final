public class Seller extends People implements RequestSeller {
    @Override
    public String RequestAddRecipe(int userID, String RecipeName, String picDir, double price, String description) {
        //REQUEST ADDRECIPE UserID Recipe_name Price Description <pic base64> 返回菜品ID
        String fake_sql=Str.request+Str.addRecipe
                +userID
                +" "+Base64handler.StringToBase64(RecipeName)
                +" "+price
                +" "+Base64handler.StringToBase64(description)
                +" "+Base64handler.imageToBase64(picDir);
        return WebConnector.post(fake_sql);
    }

    @Override
    public String RequestDeleteRecipe(int recipeID) {
        //REQUEST DELETERECIPE recipeID
        String fake_sql=Str.request+Str.deleteRecipe+recipeID;
        return WebConnector.post(fake_sql);
    }

    @Override
    public String RequestAlterRecipe(int recipeID, int UserId, String RecipeName, String picDir, double price, String description) {
        String fake_sql=Str.request+Str.alterRecipe
                +" "+recipeID
                +" "+UserId
                +" "+Base64handler.StringToBase64(RecipeName)
                +" "+price
                +" "+Base64handler.StringToBase64(description)
                +" "+Base64handler.imageToBase64(picDir);
        return WebConnector.post(fake_sql);
    }

//    @Override
//    public String requestSavePic(int userID, int recipeID, String picDir) {
//        return null;
//    }

    @Override
    public String RequestGetRecipe(int userID) {
        return null;
    }
}
