package rpc;

import com.example.bean.SystemUser;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Client {

    public void invoke(String name) {
        String result = "";

        XmlRpcClient xmlRpcClient = new XmlRpcClient();

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();

        try{
            config.setServerURL(new URL("http://127.0.0.1:10080"));
        }catch (Exception e) {
            e.printStackTrace();
        }

        xmlRpcClient.setConfig(config);

        try{
            result = (String) xmlRpcClient.execute("Hello1.sayHello", new Object[] {name});
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("==>Hello.sayHello Method invoke return result: " + result);
    }

    public static void main(String[] args){
        System.out.println("==>Input your name: ");
        String inputStr = "";
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            inputStr = bufferedReader.readLine().trim();
        } catch (Exception e){
            e.printStackTrace();
        }

        if (inputStr.length() < 1) {
            System.out.println("==>Lack the terminal args!");
        }else {
            Client client = new Client();
            client.invoke(inputStr);
        }
    }
}
