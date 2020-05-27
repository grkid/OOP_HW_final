//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class People implements RequestPeople {
    protected String name;
    protected int id;
    protected String type;
    protected String password;
    protected double money;
    private static People instance = null;

    protected People() {
    }

    public static synchronized People getInstance() {
        if (instance == null) {
            System.out.println("ERROR:People中未创建对象。");
            return null;
        } else {
            return instance;
        }
    }

    public double getMoney() {
        return this.money;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getType() {
        return this.type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //此处不应该被调用
    private void setType(String type) {
        this.type = type;
    }

    public static void createInstance(String name, int id, String password, String type, double money) {
        synchronized(People.class) {
            if (instance != null) {
                System.out.println("ERROR:People中重复创建对象。");
            }

            instance = PeopleFactory.create(type);

            assert instance != null;

            instance.id = id;
            instance.money = money;
            instance.name = name;
            instance.password = password;
            instance.type = type;
        }
    }

    public String RequestAddMoney(int userID, double moneyVal) {
        String var10000 = Str.request;
        String fake_sql = var10000 + Str.addMoney + String.valueOf(userID) + " " + String.valueOf(moneyVal);
        return WebConnector.post(fake_sql);
    }

    public String RequestWithdrawMoney(int userID, double moneyVal) {
        String var10000 = Str.request;
        String fake_sql = var10000 + Str.withdrawMoney + String.valueOf(userID) + " " + String.valueOf(moneyVal);
        return WebConnector.post(fake_sql);
    }

    public static String RequestLogin(int userID, String password) {
        String var10000 = Str.request;
        return WebConnector.post(var10000 + Str.login + String.valueOf(userID) + " " + password);
    }

    public static String RequestRegister(String type, String password, String name) {
        String fake_sql = Str.request + Str.register + type + password + " " + Base64handler.StringToBase64(name);
        return WebConnector.post(fake_sql);
    }

    public String GetAllRecipe() {
        String fake_sql = Str.request + Str.get + Str.allRecipe;
        return WebConnector.post(fake_sql);
    }

    public String GetMoney(int UserID) {
        String fake_sql = Str.request + Str.get + Str.money + UserID;
        return WebConnector.post(fake_sql);
    }

    public String RequestAlterPassword(int id, String old_password, String new_password) {
        String fake_sql = Str.request + Str.alterPassword + String.valueOf(id) + " " + old_password + " " + new_password;
        return WebConnector.post(fake_sql);
    }

    public String RequestAlterName(int id, String name) {
        String var10000 = Str.request;
        String fake_sql = var10000 + Str.alterName + String.valueOf(id) + " " + Base64handler.StringToBase64(name);
        return WebConnector.post(fake_sql);
    }

    public String RequestGetPic(String name) {
        String fake_sql = Str.request + Str.getPic + name;
        return WebConnector.post(fake_sql);
    }

    @Override
    public String RequestGetInfo(int id) {
        String fake_sql=Str.request+Str.get+Str.info+id;
        return WebConnector.post(fake_sql);
    }
}
