import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);
        List<Integer> list1 = new ArrayList<>();
        list1 = list;
        System.out.println(list1);
    }
}