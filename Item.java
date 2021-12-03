import java.util.Comparator;

// public class Item implements Comparable<Item>{ Itemクラスに並び替えメソッドを持っている
public class Item {
    // Itemクラスを並べ替えたいときにComparableインターフェースをimplementsする
    private String name;
    private int price;
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    // ここに並び替えのメソッドがあるとこの並び替えしかできない
    // バリエーションがいるなら外に出す
    // @Override
    // public int compareTo(Item o) {
    //     System.out.println(this.name + " : " + o.name);
    //     if(this.price < o.price) {
    //         return -1;
    //     }
    //     if(o.price < this.price) {
    //         return 1;
    //     }
    //     return 0;
    // }
    @Override
    public String toString() {
        return "Item [name=" + name + ", price=" + price + "]";
    }

    // -----------インナークラスはpublicになっちゃうので困る---------

    // public static class ItemNameComparator implements Comparator<Item> {

    //     @Override
    //     public int compare(Item a, Item b) {
    //         // StringクラスにあるcompareToメソッドを使う
    //         return a.getName().compareTo(b.getName());
    //     }        
    // }
    

    // public static class ItemPriceComparator implements Comparator<Item> {

    //     @Override
    //     public int compare(Item a, Item b) {
    //         if(a.getPrice() < b.getPrice()) {
    //             return -1;
    //         }
    //         if(b.getPrice() < a.getPrice()) {
    //             return 1;
    //         }
    //         return 0;
    //     }
        
        
    // }

    // -------------ローカルクラスを作ろう--------------

    // public static Comparator<Item> getNameComparator() {
    //     class ItemNameComparator implements Comparator<Item> {

    //         @Override
    //         public int compare(Item a, Item b) {
    //             // StringクラスにあるcompareToメソッドを使う
    //             return a.getName().compareTo(b.getName());
    //         }        
    //     }
    //     return new ItemNameComparator();
    // }

    // public static Comparator<Item> getPriceComparator() {
    //     class ItemPriceComparator implements Comparator<Item> {

    //         @Override
    //         public int compare(Item a, Item b) {
    //             if(a.getPrice() < b.getPrice()) {
    //                 return -1;
    //             }
    //             if(b.getPrice() < a.getPrice()) {
    //                 return 1;
    //             }
    //             return 0;
    //         }        
    //     }
    //     return new ItemPriceComparator();
    // }

    // -----------------無名クラス--------------------------
    
    public static Comparator<Item>getNameComparator() {
        return new Comparator<Item>() {

            @Override
            public int compare(Item a, Item b) {
                // StringクラスにあるcompareToメソッドを使う
                return a.getName().compareTo(b.getName());
            }        
        };
    }

    public static Comparator<Item> getPriceComparator() {
        return new Comparator<Item>() {

            @Override
            public int compare(Item a, Item b) {
                if(a.getPrice() < b.getPrice()) {
                    return -1;
                }
                if(b.getPrice() < a.getPrice()) {
                    return 1;
                }
                return 0;
            }        
        };
    }
    


    
}
