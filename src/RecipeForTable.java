import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RecipeForTable {
    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty userID;
    private final StringProperty price;
    private final StringProperty description;

    public static String p_id="ID";
    public static String p_name="名称";
    public static String p_userID="商家ID";
    public static String p_price="价格";
    public static String p_description="描述";

    RecipeForTable(String id,String name,String userID,String price,String description)
    {
        this.id=new SimpleStringProperty(id,p_id);
        this.name=new SimpleStringProperty(name,p_name);
        this.userID=new SimpleStringProperty(userID,p_userID);
        this.price=new SimpleStringProperty(price,p_price);
        this.description=new SimpleStringProperty(description,p_description);
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public void setUserID(String userID) {
        this.userID.set(userID);
    }

    public String getid() {
        return id.get();
    }

    public String getname() {
        return name.get();
    }

    public String getprice() {
        return price.get();
    }

    public String getuserID() {
        return userID.get();
    }

    public String getdescription() {
        return description.get();
    }

    public StringProperty idProperty()
    {
        return id;
    }

    public StringProperty nameProperty()
    {
        return name;
    }

    public StringProperty userIDProperty()
    {
        return userID;
    }

    public StringProperty priceProperty()
    {
        return price;
    }

    public StringProperty descriptionProperty()
    {
        return description;
    }
}
