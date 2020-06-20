import javafx.collections.ObservableList;

import java.util.Vector;

public class CustomerReadyToBuy {
    //保存顾客即将购买的，在购物车中的物品。
    //需要得到列表信息。
    //由于javafx框架的传参问题，全部为static变量。

    public static String idReadyToBuy="-1";

    private static ObservableList<TableRecipe> data;

    private static Vector<String> bucket=new Vector<String>();
    private static Vector<Integer> counts=new Vector<Integer>();

    public static void addToBucket(int count)
    {
        if(!idReadyToBuy.equals("-1"))
        {
            bucket.add(idReadyToBuy);
            counts.add(count);
            idReadyToBuy="-1";
        }
        else
        {
            InfoApplication.showMessage("购物车模块出现错误。");
        }
    }
    public static void setData(ObservableList<TableRecipe> d) {
        data=d;
    }

    public static void setIdReadyToBuy(String idReadyToBuy) {
        CustomerReadyToBuy.idReadyToBuy = idReadyToBuy;
    }

    public static TableRecipe getItem(int index)
    {
        String id=bucket.get(index);
        int size=data.size();
        for (TableRecipe datum : data)
            if (datum.getId().equals(id)) {
                return datum;
            }
        return null;

    }

    public static int getCount(int index)
    {
        return counts.get(index);
    }

    public static int getSize()
    {
        return counts.size();
    }

    public static void clear()
    {
        //data不能清除
        idReadyToBuy="-1";
        bucket.clear();
        counts.clear();
    }
}
