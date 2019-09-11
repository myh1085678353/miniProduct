package myh;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class test {

    public static void main(String[] args){

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(5);
        list.add(1);
        list.add(2);

        list.forEach(so -> System.out.println(so));
        System.out.println("---------排序过程-------------------");
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1+"-"+o2+" "+(o1 - o2));
                return o1 - o2;
            }
        });

        System.out.println("---------排序结果----------------");
        list.forEach(so -> System.out.println(so));
    }
}
