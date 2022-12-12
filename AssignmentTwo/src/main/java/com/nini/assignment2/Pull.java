package com.nini.assignment2;

import org.zeromq.*;

public class Pull {
    public static void main(String[] args) {
        try (ZContext context = new ZContext()) {
            ZMQ.Socket s2 = context.createSocket(SocketType.PULL);
            s2.connect("tcp://localhost:1001");
            while(true) {
                String msg = s2.recvStr();
                System.out.println(msg);
            }
        }
    }
}
