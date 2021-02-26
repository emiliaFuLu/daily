package hash;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: fl
 * @data: 2020-06-22 20:57
 * @description:
 **/
public class hash {
//    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//
//        map.put("1", "一");
//        map.put("2", "二");
//        map.put("3", "一");
//        map.put("4", "一");
//        map.put("5", "一");
//        map.put("6", "一");
//        map.put("7", "一");
//        map.put("8", "一");
//        map.put("9", "一");
//        map.put("10", "一");
//        map.put("11", "一");
//        map.put("12", "一");
//        map.put("13", "一");
//        map.put("14", "一");
//        map.put("15", "一");
//        map.put("16", "一");
//        map.put("17", "一");
//        map.put("18", "一");
//        map.put("19", "一");
//    }



    @Test
    public void test(){
        String a = "123";
        String b = "123";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a.equals(b));
    }



        public static void main(String[] args) {
            // 获取Java线程管理MXBean
            ThreadMXBean threadMXBean =  ManagementFactory.getThreadMXBean();
            // 获取线程和线程堆栈信息
            ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
            // 遍历线程线程，仅打印线程ID和线程名称信息
            for(ThreadInfo threadInfo:threadInfos){
                System.out.println("["+threadInfo.getThreadId()+"]"+threadInfo.getThreadName());
            }
        }

}



