package javatests.util;

import javatests.util.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void repeat_string_once(){

        Assert.assertEquals("Salas, ", StringUtil.repeat("Salas, ", 1));
    }

    @Test
    public void repeat_string_multiple_times(){

        Assert.assertEquals("Luis, Luis, Luis, ", StringUtil.repeat("Luis, ", 3));
    }

    @Test
    public void repeat_string_zero_times(){

        Assert.assertEquals("", StringUtil.repeat("Luis, ", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times(){

        StringUtil.repeat("Luis, ", -1);
    }
}