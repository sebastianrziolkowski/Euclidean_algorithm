package main.java.Algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionTest {

    @Test
    public void NWDo() {
        Function f1 = new Function();
        assertEquals(12,f1.NWDo(24,36));
        assertEquals(3,f1.NWDo(51,36));
        assertEquals(36,f1.NWDo(72,36));
        assertEquals(4,f1.NWDo(1000,36));
        assertEquals(2,f1.NWDo(1000,22));
        assertEquals(100,f1.NWDo(1000,100));
        assertEquals(1,f1.NWDo(77,100));
        assertEquals(10,f1.NWDo(10,100));
        assertEquals(1,f1.NWDo(1,2));
    }

    @Test
    public void NWDd() {
        Function f1 = new Function();
        assertEquals(12,f1.NWDd(24,36));
        assertEquals(3,f1.NWDd(51,36));
        assertEquals(36,f1.NWDd(72,36));
        assertEquals(4,f1.NWDd(1000,36));
        assertEquals(2,f1.NWDd(1000,22));
        assertEquals(100,f1.NWDd(1000,100));
        assertEquals(1,f1.NWDd(77,100));
        assertEquals(10,f1.NWDd(10,100));
        assertEquals(1,f1.NWDd(1,2));
    }
}