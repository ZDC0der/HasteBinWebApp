package me.zdcoder.hastebin.core.utility;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class HashGeneratorTest {


    @Test
    void generateHash_minLengthTest() {
        String value = HashGenerator.generateHash(0);
        Assertions.assertEquals(1, value.length());
    }
    @Test
    void generateHash_maxLengthTest() {
        String value = HashGenerator.generateHash(Long.MAX_VALUE);
        Assertions.assertEquals(11, value.length());
    }
}
