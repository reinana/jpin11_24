public class Sample {
    public static void main(String[] args) {
                    //↓エンクロージングクラス
        // Test test = new Sample().new Inner();
        // // インナークラスがstaticでないとnewしてnewする
        // test.execute();

        Test test = new Inner(); // Innerクラスはstatic
        test.execute();

        // Innerクラス単体で使いたいときはstatic
        // エンクロージングクラスと連動したいとき非static

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