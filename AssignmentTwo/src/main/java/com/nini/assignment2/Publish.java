package com.nini.assignment2;

import org.zeromq.*;

public class Publish {
    public static void main(String[] args) {

        try (ZContext context = new ZContext()) {
            ZMQ.Socket s1 = context.createSocket(SocketType.PUB);
            s1.bind("tcp://*:1001");
            while (true) {

                s1.send("Arabic hama gyan kuri chaka");
                s1.send("English mn kuri chakm");
            }

        }
    }
}
