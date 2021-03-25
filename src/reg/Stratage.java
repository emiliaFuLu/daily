package reg;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author: fl
 * @data: 2021-03-25 17:02
 * @description: 策略模式demo
 **/
public class Stratage {
    private static final Map<String, Function<Integer, Integer>> map = new HashMap<>(3);

    public static void main(String[] args) {
        Function<Integer, Integer> BusFunction = (Integer price) -> price * 2;
        Function<Integer, Integer> MetroFunction = (Integer price) -> price;
        Function<Integer, Integer> TaxiFunction = (Integer price) -> price * 3;

        map.put("bus",BusFunction);
        map.put("metro",MetroFunction);
        map.put("taxi",TaxiFunction);

        Object bus = map.get(getOperator("bus")).apply(20);
        Integer metro = map.get(getOperator("metro")).apply(20);
        Integer taxi = map.get(getOperator("taxi")).apply(20);
        System.out.println(bus);
        System.out.println(metro);
        System.out.println(taxi);

    }

    public static String getOperator(String type){
        if (type.contains("bus")){
            return "bus";
        }else if(type.contains("metro")){
            return "metro";
        }
        return "taxi";
    }
}
