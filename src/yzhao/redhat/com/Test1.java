package yzhao.redhat.com;

class Item {
    private double price;
    private String name;

    public Item(String name, double initialPrice) {
        this.name = name;
        this.price = initialPrice;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public String toString() {
        return "[" + this.name + ", " + this.price + "]";
    }
}

public class Test1 {
    public static void main(String[] args) {
        Item[] myItems = { new Item("Pen", 2.11), new Item("Pencil", 0.10) };
        System.out.println("Before method  call  #1:" + myItems[0]);
        System.out.println("Before method  call  #2:" + myItems[1]);

        // Call the method passing the array of Item
        tryStateChange(myItems);

        System.out.println("After method  call  #1:" + myItems[0]);
        System.out.println("After method  call  #2:" + myItems[1]);

        String[] attr = new String[]{"qwe", "123", "ert", "qwer"};
        for (String s: attr){
            System.out.println(s);
        }
    }

    public static void tryStateChange(Item[] allItems) {
        if (allItems != null && allItems.length > 0) {
            allItems[0].setPrice(0.38);
        }
    }
}