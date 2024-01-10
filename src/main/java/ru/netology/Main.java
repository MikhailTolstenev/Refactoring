package ru.netology;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(8888);

//        server.addHandler("GET", "/spring.svg", new Handler() {
//            public void handle(Request request, BufferedOutputStream out) {
//                try {
//                    out.write((
//                            "HTTP/1.1 200 OK\r\n" +
//                                    "Content-Type: " + request.getMimeType() + "\r\n" +
//                                    "Content-Length: " + request.getLenght() + "\r\n" +
//                                    "Connection: close\r\n" +
//                                    "\r\n"
//                    ).getBytes());
//                    Files.copy(request.getFilePath(), out);
//                    out.flush();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        });

        server.addHandler("POST", "/spring.svg", new Handler() {
            public void handle(Request request, BufferedOutputStream out) {
                try {
                    out.write((
                            "HTTP/1.1 200 OK\r\n" +
                                    "Content-Type: " + request.getMimeType() + "\r\n" +
                                    "Content-Length: " + request.getLenght() + "\r\n" +
                                    "Connection: close\r\n" +
                                    "\r\n"
                    ).getBytes());
                    Files.copy(request.getFilePath(), out);
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        server.start();

    }
}