public class PeopleFactory {
    public static People create(String type)
    {
        if(type.strip().equals(Str.seller.strip()))
            return new Seller();
        else if(type.strip().equals(Str.customer.strip()))
            return new Customer();
        else if(type.strip().equals((Str.customerDiscount1.strip())))
            return new CustomerDiscount1();
        else if(type.strip().equals(Str.customerDiscount2.strip()))
            return new CustomerDiscount2();
        else if(type.strip().equals(Str.admin.strip()))
            return new Customer();//管理员不需要一个额外的类型，但是需要申请信息
        System.out.println("PeopleFactory：未见过的类型。");
        return null;
    }
}
