public class Outer {

    private String value;

    

    public Outer(String value) {
        this.value = value;
    }


    // ここがpublicなのはSampleメソッドは外にあるから
    public class Inner {
        public void execute() {
            System.out.println(value);
        }
    }
    
}
