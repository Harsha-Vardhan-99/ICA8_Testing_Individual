package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {
    @Test
    public void TestCase1() {
        System.out.println("======Harshavardhan Bodepudi======Test One Executed====");
        assertEquals(1,Urinals.getUrinals("100001"));
    }
    @Test
    public void TestCase2() {
        System.out.println("======Harshavardhan Bodepudi======Test Two Executed====");
        assertEquals(0,Urinals.getUrinals("11"));
    }
    @Test
    public void TestCase3() {
        System.out.println("======Harshavardhan Bodepudi======Test Three Executed====");
        assertEquals(1,Urinals.getUrinals("000"));
    }

}