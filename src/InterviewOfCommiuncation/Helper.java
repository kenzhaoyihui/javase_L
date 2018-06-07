package InterviewOfCommiuncation;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public enum  Helper {
    INSTANCE;

    private static final ExecutorService tpool = Executors.newFixedThreadPool(2);

    public static String[] buildNoArr(int max){
        String[] noArr = new String[max];
        for(int i=0; i<max; i++){
            noArr[i] = Integer.toString(i+1);
        }

        return noArr;
    }

    public static String[] buildCharArr(int max){
        String[] charArr = new String[max];
        int tmp = 65;
        for(int i=0; i<max; i++){
            //charArr[i] = String.valueOf(tmp+i);
            charArr[i] = Integer.toString(tmp+i);
        }

        return charArr;
    }

    public static void print(String[] input){
        if(input == null){
            return;
        }
        for(String each: input){
            System.out.println(each);
        }
    }

    public void run(Runnable runnable){
        tpool.submit(runnable);
    }

    public void shutdown(){
        tpool.shutdown();
    }
}
