package Collections.reflect.yzhao;

import java.lang.reflect.*;
import java.util.ArrayList;

class TestA<T>{
    public TestA(int i, String s){

    }

    public TestA(T t){

    }

    public int getInt(String a){
        return 0;
    }
}


public class MethodReflect1 {
    public static void main(String[] args){
        Class<TestA> cls = TestA.class;
        for (Method m : cls.getMethods()){
            System.out.println(m.getName());
            System.out.println(getModifiers(m));
            System.out.println(getParameters(m));
            System.out.println(getExceptionList(m));
            System.out.println("-----------------------------");
        }
    }

    public static ArrayList<String> getParameters(Executable exec){
        Parameter[] parms = exec.getParameters();
        ArrayList<String> parmList = new ArrayList<>();

        for (int i=0; i<parms.length; i++){
            int mod = parms[i].getModifiers() & Modifier.parameterModifiers();
            String modifiers = Modifier.toString(mod);

            String parmType = parms[i].getType().getSimpleName();
            String parmName = parms[i].getName();

            String temp = modifiers + "  " + parmType + " " + parmName;
            if(temp.trim().length() == 0){
                continue;
            }

            parmList.add(temp.trim());
        }
        return parmList;
    }

    public static ArrayList<String> getExceptionList(Executable exec){
        ArrayList<String> exceptionList = new ArrayList<>();

        for (Class<?> c: exec.getExceptionTypes()){
            exceptionList.add(c.getSimpleName());
        }
        return exceptionList;
    }

    public static String getModifiers(Executable exec){
        int mod = exec.getModifiers();
        if (exec instanceof Method){
            mod = mod & Modifier.methodModifiers();
        }else if (exec instanceof Constructor){
            mod = mod & Modifier.constructorModifiers();
        }

        return Modifier.toString(mod);
    }
}
