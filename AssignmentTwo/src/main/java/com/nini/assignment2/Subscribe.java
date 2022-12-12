package com.nini.assignment2;

import org.zeromq.*;

class Subscribe {
    public static void main(String[] args) {
        try (ZContext context = new ZContext()) {
            ZMQ.Socket s2 = context.createSocket(SocketType.SUB);
            s2.connect("tcp://localhost:1001");
            while(true) {
                s2.subscribe("English");
                String msg = s2.recvStr();
                System.out.println(msg);
            }
        }
    }

}