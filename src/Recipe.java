public class Recipe {
    private int id;
    private String name;
    private int userID;
    private String picDir;
    private double price;
    private String description;
    //留待备用

    Recipe(int id,String name,int user,String picDir,double price,String description)
    {
        this.id=id;
        this.name=name;
        this.userID=user;
        this.picDir=picDir;
        this.price=price;
        this.description=description;
    }
}
