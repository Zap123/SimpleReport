package com.zap123.Utils;

/**
 * Created by luca on 14/11/15.
 * HTTPServer to display a report
 */

import j2html.tags.Tag;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.simpleframework.http.core.ContainerServer;
import org.simpleframework.transport.Server;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;

import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class HTTPServer implements Container {
    private static String html;
    private final Executor executor;

    public HTTPServer(int size, String html) {
        this.executor = Executors.newFixedThreadPool(size);
        this.html = html;
    }

    public static void startServer(Tag report) throws Exception {
        Container container = new HTTPServer(10, report.render());
        Server server = new ContainerServer(container);
        Connection connection = new SocketConnection(server);
        SocketAddress address = new InetSocketAddress(8080);
        System.out.println("Starting SimpleReport at http://localhost:8080");
        connection.connect(address);
    }

    public void handle(Request request, Response response) {
        Task task = new Task(request, response);

        executor.execute(task);
    }

    public static class Task implements Runnable {

        private final Response response;
        private final Request request;

        public Task(Request request, Response response) {
            this.response = response;
            this.request = request;
        }

        public void run() {
            try {
                PrintStream body = response.getPrintStream();
                long time = System.currentTimeMillis();

                response.setValue("Content-Type", "text/html");
                response.setDate("Date", time);
                response.setDate("Last-Modified", time);

                body.println(html);
                body.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
