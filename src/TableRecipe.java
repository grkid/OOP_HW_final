import javafx.beans.property.SimpleStringProperty;

public class TableRecipe {
    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty userID;
    private final SimpleStringProperty price;
    private final SimpleStringProperty description;

    public TableRecipe(String fid,String fname,String fuserID,String fprice,String fdescription)
    {
        this.id=new SimpleStringProperty(fid);
        this.name=new SimpleStringProperty(fname);
        this.userID=new SimpleStringProperty(fuserID);
        this.price=new SimpleStringProperty(fprice);
        this.description=new SimpleStringProperty(fdescription);
    }

    public String getId(){
        return id.get();
    }
    public void setId(String fId){
        id.set(fId);
    }
    public String getName(){
        return name.get();
    }
    public void setName(String fName){
        name.set(fName);
    }
    public String getUserID(){
        return userID.get();
    }
    public void setUserID(String fUserID){
        userID.set(fUserID);
    }
    public String getPrice(){
        return price.get();
    }
    public void setPrice(String fPrice){
        price.set(fPrice);
    }
    public String getDescription(){
        return description.get();
    }
    public void setDescription(String fd){
        description.set(fd);
    }

}
