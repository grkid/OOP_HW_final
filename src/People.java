import java.util.HashMap;

public class People implements RequestPeople {
    //单例模式
    protected String name;
    protected int id;
    protected String type;
    protected String password;
    protected double money;

    private People(){};

    private static People instance=null;

    public static synchronized People getInstance()
    {
        if(instance==null) {
            System.out.println("ERROR:People中未创建对象。");
            return null;
        }
        return instance;
    }

    public static void createInstance(String name, int id, String password, String type, double money)
    {
        synchronized (People.class)
        {
            if(instance!=null)
            {
                System.out.println("ERROR:People中重复创建对象。");
            }

            //TODO
            instance=PeopleFactory.create(type);

            assert instance != null;
            instance.id=id;
            instance.money=money;
            instance.name=name;
            instance.password=password;
            instance.type=type;
        }
    }

    @Override
    public String RequestAddMoney(int userID, double moneyVal) {
        //REQUEST ADDMONEY id val
        String fake_sql=Str.request+Str.addMoney+String.valueOf(userID)+" "+String.valueOf(moneyVal);
        return WebConnector.post(fake_sql);
    }

    @Override
    public String RequestWithdrawMoney(int userID, double moneyVal) {
        //REQUEST WITHDRAWMONEY ID VAL
        String fake_sql=Str.request+Str.withdrawMoney+String.valueOf(userID)+" "+String.valueOf(moneyVal);
        return WebConnector.post(fake_sql);
    }

    public String RequestLogin(int userID, String password)
    {
        //String a=WebConnector.post(Str.request+Str.login+"10005 23455");
        return WebConnector.post(Str.request+Str.login+String.valueOf(userID)+" "+password);
    }

    @Override
    public String RequestRegister(String type, String password, String name) {
        //    String a=Str.request+Str.register+"CUSTOMER "+"23456 "+Base64handler.StringToBase64("爱慕拆腻子");
        //    String b=WebConnector.post(a);
        //    System.out.println(b);
        String fake_sql=Str.request+Str.register+type+password+" "+Base64handler.StringToBase64(name);
        return WebConnector.post(fake_sql);
    }

    @Override
    public String GetAllRecipe() {
        //这个涉及大量内容
        return null;
    }

    @Override
    public String GetMoney(int UserID) {
        //REQUEST GET MONEY userID
        String fake_sql=Str.request+Str.get+Str.money+UserID;
        return WebConnector.post(fake_sql);
    }

    @Override
    public String RequestAlterPassword(int id,String old_password,String new_password){
        //REQUEST ALTERPASSWORD id origin_password new_password 更改密码
        String fake_sql=Str.request+Str.alterPassword+String.valueOf(id)+" "+old_password+" "+new_password;
        return WebConnector.post(fake_sql);
    }

    @Override
    public String RequestAlterName(int id,String name)
    {
        String fake_sql=Str.request+Str.alterName+String.valueOf(id)+" "+Base64handler.StringToBase64(name);
        return WebConnector.post(fake_sql);
    }

    @Override
    public String RequestGetPic(String name) {
        //REQUEST GETPIC <name.jpg>
        String fake_sql=Str.request+Str.getPic+name;
        return WebConnector.post(fake_sql);
    }
}
