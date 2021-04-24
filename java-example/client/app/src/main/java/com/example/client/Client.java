package com.example.client;

import com.example.lib.Virus;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Client {
    private final static String HOST = "localhost";
    private final static int PORT = 7777;

    public static void main(String[] ars) {
//        Virus swineInfluenza = new Virus("influenza A virus subtype H1N1",
//                                         "A/H1N1", LocalDate.parse("1918-04-01"));

//        Virus mers = new Virus("Middle East respiratory syndrome ",
//                               "MERS", LocalDate.parse("2012-05-01"));
//
//        Virus covid = new Virus("Severe acute respiratory syndrome coroNavirus 2",
//                                "SARS‑CoV‑2", LocalDate.parse("2019-12-30"));

//        Object reallyBadVirus = buildReallyBadVirus();

//        String test_str = new String("test str");
//        registerVirus(test_str);

//        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new  FileOutputStream("virus.bin"))) {
//            objectOutputStream.writeObject(swineInfluenza);
//            objectOutputStream.writeObject(mers);
//            objectOutputStream.writeObject(covid);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        registerVirus(swineInfluenza);
//        registerVirus(mers);
//        registerVirus(covid);
//        registerVirus(reallyBadVirus);

        System.out.println(System.getProperty("java.runtime.version"));
        registerVirus(new Virus("test1", "t1", LocalDate.of(2010, 10, 10)));
    }

    private static Object buildReallyBadVirus() {
        Set root = new HashSet();
        Set s1 = root;
        Set s2 = new HashSet();
        for (int i = 0; i < 100; i++) {
            Set t1 = new HashSet();
            Set t2 = new HashSet();
            t1.add("foo"); // make it not equal to t2
            s1.add(t1);
            s1.add(t2);
            s2.add(t1);
            s2.add(t2);
            s1 = t1;
            s2 = t2;
        }
        return root;
    }

    // wont compile if we had a Virus as function parameter
    private static void registerVirus(Object p) {
        try (Socket socket = new Socket(HOST, PORT);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
            out.writeObject(p);
            out.flush();
            System.out.println("data is send");
        } catch (IOException ioException) {
            throw new RuntimeException("error sending data", ioException);
        }
    }
}

