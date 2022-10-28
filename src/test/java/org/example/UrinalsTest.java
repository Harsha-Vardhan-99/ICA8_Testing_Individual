package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {
    @Test
    public void TestCase1() {
        System.out.println("======Harshavardhan Bodepudi======Test Case One Executed====");
        assertEquals(1,Urinals.getUrinals("100001"));
    }
    @Test
    public void TestCase2() {
        System.out.println("======Harshavardhan Bodepudi======Test Case Two Executed====");
        assertEquals(-1,Urinals.getUrinals("11"));
    }
    @Test
    public void TestCase3() {
        System.out.println("======Harshavardhan Bodepudi======Test Case Three Executed====");
        assertEquals(2,Urinals.getUrinals("000"));
    }
    @Test
    public void TestCase4() {
        System.out.println("======Harshavardhan Bodepudi======Test Case Four Executed====");
        assertEquals(1,Urinals.getUrinals("0"));
    }
    @Test
    public void TestCase5() {
        System.out.println("======Harshavardhan Bodepudi======Test Case Five Executed====");
        assertEquals(3,Urinals.getUrinals("10101111111000000001"));
    }

}