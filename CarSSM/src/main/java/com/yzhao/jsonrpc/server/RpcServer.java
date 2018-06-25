package com.yzhao.jsonrpc.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.jsonrpc4j.JsonRpcServer;
import com.yzhao.jsonrpc.enitity.HelloWorldService;
import com.yzhao.jsonrpc.enitity.HelloWorldServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RpcServer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    ObjectMapper mapper = new ObjectMapper();

    private JsonRpcServer rpcServer = null;
    HelloWorldService helloWorldService = new HelloWorldServiceImpl();

    public RpcServer() {
        super();

        rpcServer = new JsonRpcServer(mapper, new HelloWorldServiceImpl(), HelloWorldService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);
        System.out.println("JsonRpcService service being call");
        rpcServer.handle(req, resp);
    }
}
