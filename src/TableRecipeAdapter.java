public class TableRecipeAdapter {
    public static TableRecipe adapt(String a)
    {
        //a是单独一个
        String[] info=a.split(" ");
        if(info.length!=5)
            System.out.println("TableRecipeAdapter:适配失败，格式错误");
        String id=info[0];
        String name=Base64handler.Base64ToString(info[1]);
        String userID=info[2];
        String price=info[3];
        String description=Base64handler.Base64ToString(info[4]);
        return new TableRecipe(id,name,userID,price,description);
    }
}
