package Collections.reflect.yzhao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface AppService{
    public boolean createApp(String name);
    public void print(String name);
}

class AppServiceImpl implements  AppService{
    public boolean createApp(String name){
        System.out.println("App[" + name + "] has been created.");
        return true;
    }

    public void print(String name){
        System.out.println("Print " + name);
    }
}

class LoggerInterceptor implements InvocationHandler{
    private Object target;
    public LoggerInterceptor(Object target){
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println("Enterd " + target.getClass().getName() + "--" + method.getName() + ", with arguments{" + args[0] + "}");
        Object result = method.invoke(target, args);
        System.out.println("Before return: " + result);
        return result;
    }
}
public class DynasicProxy {
    public static void main(String [] args) {
        AppService target = new AppServiceImpl();

        InvocationHandler handler = new LoggerInterceptor(target);

        AppService proxy = (AppService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new LoggerInterceptor(target));

        AppService proxy1 = (AppService) Proxy.newProxyInstance(handler.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
        proxy.createApp("Ken Calvin");

        System.out.println("---------");
        proxy.print("Zhaoyihui");

        System.out.println("--------------------------");

        proxy1.createApp("lj");
        System.out.println("-------------------------");
        proxy1.print("zhaoyihui");

        System.out.println(proxy.getClass().getName());
    }
}
