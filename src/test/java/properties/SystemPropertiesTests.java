package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.System.getProperty;

public class SystemPropertiesTests {
    @Test
    void someTest5() {
        System.setProperty("anyValue", "anyText");
        String text = getProperty("anyValue", "some text");
        System.out.println(text); //
    }
    @Test
    @Tag("test6")
    void someTest6() {
        String browser = getProperty("browser", "Chrome");
        String version = getProperty("version", "103");
        String browserSize = getProperty("browserSize", "1820x980");

        System.out.println(browser); //
        System.out.println(version); //
        System.out.println(browserSize); //
    }

    @Test
    @Tag("hello")
    void someTest7() {
        System.out.println("Hello " + System.getProperty("anyText"));

        // gradle clean hello_test -DanyText=world!
        //     Hello world!
    }
}

