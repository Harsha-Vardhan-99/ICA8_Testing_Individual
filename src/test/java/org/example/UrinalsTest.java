package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {
    @Test
    public void TestCase() {
        System.out.println("======Harshavardhan Bodepudi======Test One Executed====");
        assertEquals(3,Urinals.getUrinals("100001"));
    }

}