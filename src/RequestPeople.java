public interface RequestPeople {
    //"人"的事务集合
    //REQUEST ADDMONEY id val
    //REQUEST WITHDRAWMONEY id val
    //REQUEST LOGIN id pd
    //REQUEST REGISTER type pd Name 返回用户ID tested
    //REQUEST ALTERPASSWORD id origin_password new_password 更改密码
    //REQUEST GET ALL RECIPE 返回所有商品的所有信息
    //REQUEST GET  MONEY UserID  返回钱数
    //REQUEST GET INFO id 返回所有有关我的订单信息
    //REQUEST ALTERNAME id name 修改名字
    //REQUEST GETPIC <name> 返回图片的base64

    String RequestAddMoney(int userID, double moneyVal);

    String RequestWithdrawMoney(int userID, double moneyVal);


    //    String a=Str.request+Str.register+"CUSTOMER "+"23456 "+Base64handler.StringToBase64("爱慕拆腻子");
    //    String b=WebConnector.post(a);
    //    System.out.println(b);

    String GetAllRecipe();

    String GetMoney(int UserID);

    String RequestAlterPassword(int id,String old_password,String new_password);

    String RequestAlterName(int id,String newName);

    String RequestGetPic(String name);

    String RequestGetInfo(int id);
}
