public class TableRecordAdapter {
    public static TableRecord adapt(String a)
    {
        //a是单独一个
        String[] info=a.split(" ");
        if(info.length!=6)
            System.out.println("TableRecipeAdapter:适配失败，格式错误");
        String id=info[0];
        String name=info[1];
        String userID=info[2];
        String price=info[3]+" "+info[4];
        String description=info[5];
        return new TableRecord(id,name,userID,price,description);
    }
}
