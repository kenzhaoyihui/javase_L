package Collections.reflect.yzhao;

import java.util.Random;
import java.util.concurrent.*;

public class completionTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException{
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletionService completionService = new ExecutorCompletionService(executorService);

        for(int i=0; i<=10; i++){
            final int result = i;
            completionService.submit(new Callable() {
                @Override
                public Object call() throws Exception {
                    //return null;
                    Thread.sleep(new Random().nextInt(5000));
                    return  result;
                }
            });
        }
        System.out.println(completionService.take().get());
    }
}