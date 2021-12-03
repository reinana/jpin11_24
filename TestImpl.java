// public class TestImpl implements Test {
    // このままでは問題ある → public なので情報隠蔽すべき
    
class TestImpl implements Test {

    @Override
    public void execute() {
       System.out.println("test impl");; 
        
    }
    
}
