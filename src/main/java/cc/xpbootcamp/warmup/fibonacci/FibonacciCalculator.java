package cc.xpbootcamp.warmup.fibonacci;

import java.util.LinkedList;
import java.util.List;

public class FibonacciCalculator {

    private static List<Long> list = initList();

    public static long calculateByPosition(int position){
        if(list.size() >= position) return list.get(position-1);

        return 0;
    }

    private static List<Long> initList(){
        List<Long> list = new LinkedList<>();
        list.add(1L);
        list.add(1L);
        return list;
    }

}
