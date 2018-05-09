package Collections.reflect.yzhao;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

class MySuperClass{
    public int super_id = -1;
    public String super_name = "Unknown";
}

class MyClass extends MySuperClass{
    public int id = -1;
    public String name = "Unknown";
}


public class FieldReflect1 {
    public static void main(String[] args){
        Class<MyClass> c = MyClass.class;

        ArrayList<String> fieldsDescription = getDeclaredFieldsList(c);

        ArrayList<String> fieldDesc = getFieldsList(c);

        System.out.println("Decarlaed Fields for: " + c.getName());
        for (String desc: fieldsDescription){
            System.out.println(desc);
        }

        System.out.println("\nAccessible Fields for: " + c.getName());
        for (String desc: fieldDesc){
            System.out.println(desc);
        }
    }

    public static ArrayList<String> getDeclaredFieldsList(Class c){
        Field[] fields = c.getDeclaredFields();
        ArrayList<String> fieldList = getFieldsDescription(fields);
        return fieldList;
    }

    public static ArrayList<String> getFieldsList(Class c){
        Field[] fields = c.getFields();
        ArrayList<String> fieldsList = getFieldsDescription(fields);
        return fieldsList;
    }

    public static ArrayList<String> getFieldsDescription(Field[] fields){
        ArrayList<String> fieldList = new ArrayList<>();
        for (Field f: fields){
            int mod = f.getModifiers() & Modifier.fieldModifiers();
            String modifiers = Modifier.toString(mod);

            Class<?> type = f.getType();
            String fieldName = f.getName();
            fieldList.add(modifiers + "  " + type + "  " + fieldName);
        }

        return fieldList;
    }
}
