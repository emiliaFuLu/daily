package test;

import org.junit.Test;
import sun.security.provider.MD4;

import javax.naming.Context;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @author: fl
 * @data: 2020-06-18 15:27
 * @description:
 **/
public class test {

    @Test
    public void test() {
        testinner(12);
    }

    public void testinner(int a) {
        //有和没有修改a值得差别,修改a的值就会报错,不修改就没问题
//        a = 13;
        innerClass innerClass = new innerClass() {
            @Override
            void doSome() {
                super.doSome();
                System.out.println("a = " + a);
            }
        };
        innerClass.doSome();
    }

    public class innerClass {
        void doSome() {
            System.out.println("调用内部类");
        }
    }


    @Test
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String val = "73.25%";
        for (int i = 0; i < 100000000; i++) {

            val = MD2(val);
//            System.out.println(val);
        }
        System.out.println("最终结果：" + val);
    }

    public static String MD2(String str) throws NoSuchAlgorithmException {
        // 获取MD2加密工具
        MessageDigest md = MessageDigest.getInstance("MD2");
        // 加密
        byte[] digest = md.digest(str.getBytes());
        // 获取二进制十六进制互转工具
        HexBinaryAdapter hexBinaryAdapter = new HexBinaryAdapter();
        // 将二进制数组转换为十六进制字符串,输出结果
        return hexBinaryAdapter.marshal(digest);
    }


}

