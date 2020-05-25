public class PeopleFactory {
    public static People create(String type)
    {
        if(type.strip().equals(Str.seller.strip()))
            return new Seller();
        else if(type.strip().equals(Str.customer.strip()))
            return new Customer();
        System.out.println("PeopleFactory：未见过的类型。");
        return null;
    }
}
