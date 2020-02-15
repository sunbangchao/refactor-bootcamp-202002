package cc.xpbootcamp.warmup.fibonacci;

import java.util.LinkedList;
import java.util.List;

public class FibonacciCalculator {

    private static List<Long> list = initList();

    public static long calculateByPosition(int position){
        for (int i = list.size(); i < position; i++) {
            list.add(list.get(i-1) + list.get(i-2));
        }
        return list.get(position-1);
    }

    private static List<Long> initList(){
        List<Long> list = new LinkedList<>();
        list.add(1L);
        list.add(1L);
        return list;
    }

}
