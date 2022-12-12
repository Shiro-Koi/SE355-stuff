package com.nini.assignment2;

import org.zeromq.*;

public class Push {
    public static void main(String[] args) {
        try (ZContext context = new ZContext()) {
            ZMQ.Socket s1 = context.createSocket(SocketType.PUSH);
            s1.bind("tcp://*:1001");
            while (true) {
                s1.send("hama gyan kuri chaka");
            }
        }
    }
}
