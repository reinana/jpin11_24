import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


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
            // List<String> list = List.of("A","B","C","D","E");
            // Consumer<String> c = str -> System.out.println(str);
            // Consumer<String> c = System.out::println; // メソッドの中身をacceptに代入している
            // list.forEach(c);
            // メソッド参照
            // list.forEach(System.out::println);
            // 予め定義されているコンシューマー型を使うならメソッド参照
            // その時その時で定義したいならラムダ式
            // list.forEach(Sample::test); 
        
        // Supplier<String> s = () -> "hoge";
        // System.out.println(s.get());
        
        // Factoryのかわりに使えるラムダ
        // TestImplはTestの実装だからTest型で使える
        // sを使いまわせる
        // Supplier<Test> s = () -> new TestImpl();
        // test(() -> new TestImpl());
        // test(s);
        // test(s);
        // test(s); // 毎回新しいインスタンスが作られる参照が違う

        // ポリモーフィズムの場合は使いまわせない
        // Test t = new TestImpl();
        // test2(t);
        // test2(t);
        // test2(t);
        // test2(t); // 同じ参照を返す インスタンスは1つ

        // test2(new TestImpl());
        // test2(new TestImpl());
        // test2(new TestImpl());
        // test2(new TestImpl()); //こうするとFactoryになる

        // Function<String, String> f = str -> str.toUpperCase();
        // System.out.println(f.apply("a"));

        // Predicate<Item> p = item -> item.getPrice() >= 100;
        
        List<Item> list = List.of(
                    new Item("apple",100),
                    new Item("banana",80),
                    new Item("orange",120)
        );

        // list.stream().filter(p).forEach(System.out::println);
        // こっちの方が主流の書き方pは使いまわさないから
        list.stream()
            .filter(item -> item.getPrice() >= 100)
            .forEach(System.out::println);


    }

    private static void test2(Test t) {
        t.execute();
        System.out.println(t);
    }
    private static void test(Supplier<Test> s) {
        Test t = s.get();
        t.execute();
        System.out.println(t);
    }

    // Consumer型のメソッド引数を1つ受け取って消費する
    private static void test(String str) {
        System.out.println("test" + str);
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