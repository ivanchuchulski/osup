/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.example.server;

import org.junit.Test;
import static org.junit.Assert.*;

public class ServerTest {
    @Test public void testServerBuilds() {
        final int PORT = 7777;
        Server classUnderTest = new Server(PORT);
        assertNotNull(classUnderTest);
    }
}
