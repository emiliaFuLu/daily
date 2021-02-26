package anno;

import java.lang.reflect.Method;

/**
 * @author: fl
 * @data: 2020-07-23 17:51
 * @description:
 **/
public class Test {

    @Hello("hello")
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Test> cls = Test.class;
        Method method = cls.getMethod("main", String[].class);
        Hello hello = method.getAnnotation(Hello.class);
    }
}
