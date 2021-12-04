@FunctionalInterface アノテーション 抽象メソッドが二個以上あるとエラー
public interface Test {
    void execute();
    // void hoge(); // 抽象メソッドはダメ
    static void hoge() { // static メソッドはOK
        System.out.println("hoge");
    }
}
// 関数型インターフェースは抽象メソッドを1個だけ持ってる→ラムダにできる
