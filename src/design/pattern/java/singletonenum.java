package design.pattern.java;

//public class singletonenum {
//
//    private singletonenum(){}
//
//    public static singletonenum getInstance(){
//        return Singleton.SINGLETON.getSingletonenum();
//    }
//
//    private static enum Singleton{
//        SINGLETON;
//
//        private singletonenum singletonenum1;
//
//        private Singleton(){
//            singletonenum1 = new singletonenum();
//        }
//
//        public singletonenum getSingletonenum(){
//            return singletonenum1;
//        }
//    }
//
//}

public class singletonenum{
    private singletonenum(){}

    public static singletonenum getInstance(){
        return Singleton.INSTANCE.getSingletonenum();
    }

    private static enum Singleton{
        INSTANCE;
        private  singletonenum singletonenum1;

        private Singleton(){
            singletonenum1 = new singletonenum();
        }

        public singletonenum getSingletonenum(){
            return singletonenum1;
        }
    }
}
