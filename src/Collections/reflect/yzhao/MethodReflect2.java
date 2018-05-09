package Collections.reflect.yzhao;

import java.lang.reflect.*;
import java.util.ArrayList;

class TestB<T>{
    public TestB(int i, int j, String s) {

    }

    public TestB(T t){

    }

    public TestB(){}

    public int getInt(String s){
        return 0;
    }
}

class TestBChild extends TestB{
    public TestBChild(){
        super();
    }

    public TestBChild(int i, int j, String name){
        super(i, j, name);

    }

    public void print(){
        System.out.println("hahha");
    }

    public void pp(int i, String name){
        System.out.println("Num: " + i + " , Name: " + name);
    }
}


public class MethodReflect2 {
    public static void main(String[] args){
        Class<TestBChild> c = TestBChild.class;

        ArrayList<String> arrayList1 = getMethodList(c);
        ArrayList<String> arrayList2 = getDeclareMethodList(c);

        System.out.println("Declared method for: " + c.getName());
        for(String desc: arrayList2){
            System.out.println(desc);
        }

        System.out.println("------------------------------");
        System.out.println("\nMethods for: " + c.getName());
        for(String desc: arrayList1){
            System.out.println(desc);
        }

        System.out.println("##############################");
        System.out.println("Constructors for " + c.getName());

        Constructor[] constructors = c.getConstructors();

        ArrayList<String> constructDescList = getConstructorsDesciption(constructors);

        for(String desc: constructDescList){
            System.out.println(desc);
        }

    }

    public static ArrayList<String> getMethodList(Class c){
        Method[] methods = c.getMethods();
        ArrayList<String> arrayList = getMethodDescription(methods);
        return arrayList;
    }

    public static ArrayList<String> getDeclareMethodList(Class c){
        Method[] methods = c.getDeclaredMethods();
        ArrayList<String> arrayList = getMethodDescription(methods);
        return arrayList;
    }

    public static ArrayList<String> getMethodDescription(Method[] methods){
        ArrayList<String> arrayList = new ArrayList<>();

        for (Method m: methods){
            String modifiers = getModifiers(m);
            Class returnType = m.getReturnType();
            String returnTypeName = returnType.getName();

            String methodName = m.getName();

            String params = getParameters(m).toString();

            String throwsClause = getExceptionLists(m).toString();

            arrayList.add(modifiers + " " + returnTypeName + " " + methodName + " " + "(" + params + ")" + throwsClause);

        }
        return arrayList;
    }

    public static ArrayList<String> getParameters(Executable exec){
        Parameter[] parameters = exec.getParameters();
        ArrayList<String> arrayList = new ArrayList<>();

        for(int i=0; i<parameters.length; i++){
            int mod = parameters[i].getModifiers() & Modifier.parameterModifiers();
            String modifier = Modifier.toString(mod);
            String paramType = parameters[i].getType().getSimpleName();
            String paramName = parameters[i].getName();

            String temp = modifier + "  " + paramType + "  " + paramName;
            if(temp.trim().length() == 0){
                continue;
            }
            arrayList.add(temp.trim());
        }
        return arrayList;

    }

    public static ArrayList<String> getExceptionLists(Executable exec){
        ArrayList<String> exceptionlist = new ArrayList<>();
        for(Class<?> c :exec.getExceptionTypes()){
            exceptionlist.add(c.getSimpleName());
        }

        return exceptionlist;
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

    public static ArrayList<String> getConstructorsDesciption(Constructor[] constructors){
        ArrayList<String> constructorList = new ArrayList<>();

        for (Constructor constructor: constructors){
            String modifiers = getModifiers(constructor);

            String constructorName = constructor.getName();

            constructorList.add(modifiers + " " + constructorName + "(" + getParameters(constructor) + ") " +getExceptionLists(constructor));
        }
        return constructorList;
    }
}
