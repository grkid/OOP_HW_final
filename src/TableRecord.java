import javafx.beans.property.SimpleStringProperty;

public class TableRecord {
    private final SimpleStringProperty customerID;
    private final SimpleStringProperty recipeID;
    private final SimpleStringProperty count;
    private final SimpleStringProperty time;
    private final SimpleStringProperty actualPrice;

    public TableRecord(String fid,String fRecipeID,String fCount,String fTime,String fActualPrice)
    {
        this.customerID=new SimpleStringProperty(fid);
        this.recipeID=new SimpleStringProperty(fRecipeID);
        this.count=new SimpleStringProperty(fCount);
        this.time=new SimpleStringProperty(fTime);
        this.actualPrice=new SimpleStringProperty(fActualPrice);
    }

    public String getCustomerID(){
        return customerID.get();
    }
    public void setCustomerID(String fCustomerID){
        customerID.set(fCustomerID);
    }
    public String getRecipeID(){
        return recipeID.get();
    }
    public void setRecipeID(String fRecipeID){
        recipeID.set(fRecipeID);
    }
    public String getCount(){
        return count.get();
    }
    public void setCount(String fCount){
        count.set(fCount);
    }
    public String getTime(){
        return time.get();
    }
    public void setTime(String fTime){
        time.set(fTime);
    }
    public String getActualPrice(){
        return actualPrice.get();
    }
    public void setActualPrice(String fd){
        actualPrice.set(fd);
    }
}
