package classType;

import org.junit.Test;

/**
 * @author: fl
 * @data: 2021-03-18 09:03
 * @description:
 **/
public class newClassTest {
    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

//        User u = new User();  //有就局部变量和没有局部变量的差别在于,invokespecial之后一个是astore_1  这个是将栈顶的引用消耗掉,指向局部变量
//        new User();           //pop 是将栈顶的局部变量消耗掉,不会存储

        /**
         * invokestatic加载静态
         * checkcast了类型转换
         */
//        User user = (User) Class.forName("classType.User").newInstance();
//        User user1 = User.class.newInstance();

        User.class.getConstructors();
    }

}


