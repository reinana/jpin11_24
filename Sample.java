import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Sample {
    public static void main(String[] args) {
                    //↓エンクロージングクラス
        // Test test = new Sample().new Inner();
        // インナークラスがstaticでないとnewしてnewする
        // SampleとInnerは同じクラス内にあるのでアクセスできる
        // test.execute();

        // Test test = new Inner(); // Innerクラスはstatic
        // test.execute();

        // Innerクラス単体で使いたいときはstatic
        // エンクロージングクラスと連動したいとき非static

        // new Outer("hoge").new Inner().execute();

        // List<Item> list = new ArrayList<>();
        // list.add(new Item("apple",100));
        // list.add(new Item("banana",80));
        // list.add(new Item("orange",120));

        // Collections.sort(list); Itemクラスに並び替えメソッドがあるときComparableを実装してないといけない
        // Collections.sort(list, new Item.ItemNameComparator()); // 引数2個ノトキ、Comparatorを実装したクラスを引数に入れる
        // Collections.sort(list, Item.getPriceComparator());
        // for(Item item: list) {
        //     System.out.println(item);
        // }

        // List<String> list = new ArrayList<>() {
        //     {//初期化ブロック コンストラクタより先に実行
        //         super.add("A");
        //         super.add("B");
        //         super.add("C");
        //     }
        // }

        // ---------------------------------------
        // Testインターフェースにあるexecuteメソッドの定義を後から決めるのがラムダ
        // Test test = () -> System.out.println("test");
        // Testインターフェースのexecuteメソッドを呼び出した時に実行したい内容
        // 書いたタイミングじゃなくて呼び出したタイミングで実行
        // test.execute();

        // ------------------------------------------


    }

    private static class Inner implements Test{
        //privateなので外部からはアクセスできない
        // 外部とはSampleクラス以外
        @Override
        public void execute() {
            System.out.println("inner test");
            
        }

    }
}