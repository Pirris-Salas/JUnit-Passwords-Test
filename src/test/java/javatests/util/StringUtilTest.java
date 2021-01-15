package javatests.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void testRepeat(){

        Assert.assertEquals("Luis, Luis, Luis, ", StringUtil.repeat("Luis, ", 3));
        Assert.assertEquals("Salas, ", StringUtil.repeat("Salas, ", 1));
    }
}