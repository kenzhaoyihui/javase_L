package rpc;


import org.apache.xmlrpc.XmlRpcHandler;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcStreamServer;
import org.apache.xmlrpc.webserver.WebServer;

import java.net.InetAddress;

public class Server {
    public WebServer webServer;

    public Server() {
        try {
            //this.webServer = new WebServer(10080);
            this.webServer = new WebServer(10080, InetAddress.getByAddress(new byte[] {127,0,0,1}));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initServer() {
        //XmlRpcServer
        XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();

        //Handle mapping
        PropertyHandlerMapping propertyHandlerMapping = new PropertyHandlerMapping();

        try{
            //add the method for service
            propertyHandlerMapping.addHandler("Hello1", Handler.class);
        }catch (Exception e) {
            e.printStackTrace();
        }

        xmlRpcServer.setHandlerMapping(propertyHandlerMapping);

        //Running Service
        try{
            webServer.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.initServer();
    }
}
