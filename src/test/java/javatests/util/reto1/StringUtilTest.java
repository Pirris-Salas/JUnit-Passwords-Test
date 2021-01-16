package javatests.util.reto1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringUtilTest {
    private StringUtil stringUtil;
    @Before
    public void setUp(){
        stringUtil = new StringUtil();
    }

    @Test
    public void is_empty_when_value_is_null(){

        boolean result = StringUtil.isEmpty("null");

        Assert.assertTrue(result);
    }

    @Test
    public void is_empty_when_value_is_void(){

        boolean result = StringUtil.isEmpty("");

        Assert.assertTrue(result);
    }

    @Test
    public void is_empty_when_value_has_spaces(){

        boolean result = StringUtil.isEmpty("   ");

        Assert.assertTrue(result);
    }

    @Test
    public void is_not_empty_when_value_has_values(){

        boolean result = StringUtil.isEmpty("Luis");

        Assert.assertFalse(result);
    }

}