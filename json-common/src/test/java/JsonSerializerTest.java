import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by churmuzache on 7/24/15.
 */
class MyClass {
    private String string1;
    private String string2;
    private String string3;
    private TestClass testClass;

    public class TestClass {
        private String string4 ;

        public String getString4() {
            return string4;
        }

        public void setString4(String string4) {
            this.string4 = string4;
        }
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    public String getString3() {
        return string3;
    }

    public void setString3(String string3) {
        this.string3 = string3;
    }

    public TestClass getTestClass() {
        return testClass;
    }

    public void setTestClass(TestClass testClass) {
        this.testClass = testClass;
    }
}
public class JsonSerializerTest {


    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final int NR_ENTITIES = 100000;

    @Ignore
    @Test
    public void testObjectMapperFunctionality() throws IOException {

        String s = "{\"string1\":\"s1\",\"string2\":\"s2\",\"string3\":\"s3\"}";

        MyClass myClass = new MyClass();
        myClass.setString1("s1");
        myClass.setString2("s2");
        myClass.setString3("s3");

        String json = objectMapper.writeValueAsString(myClass);
        Assert.assertEquals(json, s);
    }

    @Ignore
    @Test
    public void testObjectMapperFunctionalityNullField() throws IOException {

        String s = "{\"string1\":\"s1\",\"string2\":\"s2\",\"string3\":\"s3\"}";

        MyClass myClass = new MyClass();
        myClass.setString1("s1");
        myClass.setString2("s2");

        String json = objectMapper.writeValueAsString(myClass);
        System.out.println(json);
        //Assert.assertEquals(json, s);
    }

    @Test
    public void testJsonSerializerFunctionality() throws IOException, IllegalAccessException {

        String s = "{\"string1\":\"s1\",\"string2\":\"s2\",\"string3\":\"s3\"}";

        MyClass myClass = new MyClass();
        myClass.setString1("s1");
        myClass.setString2("s2");
        myClass.setString3("s3");


        MyClass.TestClass myTestClass = myClass.new TestClass();
        myTestClass.setString4("s4");

        myClass.setTestClass(myTestClass);

        String json = AbstractJsonSerializer.toJson(myClass);
        System.out.println("TEST FIELD "+json);
        //Assert.assertEquals(json, s);
    }

    @Ignore
    @Test
    public void testJsonSerializerFunctionalityNullField() throws IOException, IllegalAccessException {

        String s = "{\"string1\":\"s1\",\"string2\":\"s2\",\"string3\":\"s3\"}";

        MyClass myClass = new MyClass();
        myClass.setString1("s1");
        myClass.setString2("s2");

        String json = AbstractJsonSerializer.toJson(myClass);
        System.out.println("TEST WITH NULL FIELD "+json);
        //Assert.assertEquals(json, s);
    }
    @Ignore
    @Test
    public void testPerformance1() throws IOException {
        long startObjectMapper = System.currentTimeMillis();
        for (int i = 0; i < NR_ENTITIES; i++) {

            MyClass myClass = new MyClass();
            myClass.setString1("s1:" + (i + 1));
            myClass.setString2("s2:" + (i + 1));
            myClass.setString3("s3:" + (i + 1));

            objectMapper.writeValueAsString(myClass);

        }
        long endObjectMapper = System.currentTimeMillis();

        long timeObjectMapper = endObjectMapper - startObjectMapper;
        System.out.println("Response time:" + timeObjectMapper + " ms");
    }

    @Ignore
    @Test
    public void testPerformance2() throws IOException, IllegalAccessException {
        long startObjectMapper = System.currentTimeMillis();
        for (int i = 0; i < NR_ENTITIES; i++) {

            MyClass myClass = new MyClass();
            myClass.setString1("s1:" + (i + 1));
            myClass.setString2("s2:" + (i + 1));
            myClass.setString3("s3:" + (i + 1));

            AbstractJsonSerializer.toJson(myClass);

        }
        long endObjectMapper = System.currentTimeMillis();

        long timeObjectMapper = endObjectMapper - startObjectMapper;
        System.out.println("Response time:" + timeObjectMapper + " ms");
    }

}
