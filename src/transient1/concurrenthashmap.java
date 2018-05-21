package transient1;

import java.util.HashMap;
import java.util.Hashtable;

//public class concurrenthashmap {
//    public static HashMap hashMap = new HashMap();
//    //public static Hashtable hashMap = new Hashtable();
//    //public static HashMap hashMap = new HashMap();
//
//    public static void main(String[] args) {
//        Thread threadA = new Thread(new Runnable() {
//            //@Override
//            public void run() {
//                for (int i = 0; i < 50000; i++) {
//                    hashMap.put("ThreadA" + (i + 1), "ThreadA" + i + 1);
//                    System.out.println("ThreadA" + (i + 1));
//                }
//            }
//        });
//
//        Thread threadB = new Thread(new Runnable() {
//            //@Override
//            public void run() {
//                for (int i = 0; i < 50000; i++) {
//                    hashMap.put("ThreadB" + (i + 1), "ThreadB" + i + 1);
//                    System.out.println("ThreadB" + (i + 1));
//                }
//            }
//        });
//
//        threadA.start();
//        threadB.start();
//    }
//}



import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class concurrenthashmap {
    public static ConcurrentHashMap hashtable = new ConcurrentHashMap();
    //public static Hashtable hashtable = new Hashtable();
    static {
        for (int i = 0; i < 5; i++) {
            hashtable.put("String" + (i + 1), i + 1);
        }
    }

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            //@Override
            public void run() {
                try {
                    //Iterator iterator1 = hashtable.keySet().iterator();
                    Iterator iterator = hashtable.keySet().iterator();
                    while (iterator.hasNext()) {
                        System.out.println(iterator.next());
                        TimeUnit.SECONDS.sleep(2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            //@Override
            public void run() {
                hashtable.put("z", "zValue");
                hashtable.put("zyh", "hello");
            }
        });

        threadA.start();
        threadB.start();
    }
}
