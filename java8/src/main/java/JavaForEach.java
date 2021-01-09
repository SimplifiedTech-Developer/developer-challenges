import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaForEach {
    public static void main(String[] args) {

        //1. forEach and Map Normal
        Map<String, Integer> stringIntegerMap = setupMapData();
        System.out.println("==============forEach and Map Normal==============");
        for (Map.Entry<String, Integer> value : stringIntegerMap.entrySet()) {
            System.out.println("Key : ".concat(value.getKey()).concat(" Value :").concat(value.getValue().toString()));
        }
        //1. forEach and Map Java 8
        System.out.println("==============forEach and Map Java 8==============");
        stringIntegerMap.forEach((k, v) -> System.out.println("Key : ".concat(k).concat(" Value :").concat(v.toString())));
        //2. forEach and List Normal
        List<String> stringList = setupListData();
        System.out.println("==============forEach and List Normal==============");
        for (String value : stringList) {
            System.out.println("List Value : ".concat(value));
        }
        System.out.println("==============forEach and List Java 8==============");
        //2. forEach and List Java 8
        stringList.forEach(x -> System.out.println("List Value : ".concat(x)));
        //2. forEach and List //Output : A,B,C,D,E
        System.out.println("============== forEach and List //Output : A,B,C,D,E==============");
        stringList.forEach(x -> System.out.println("List Value : ".concat(x)));
        //2. forEach and List Output C:
        System.out.println("==============2. forEach and List Output C==============");
        stringList.forEach(x -> {
            if (x.equalsIgnoreCase("C")) {
                System.out.println(x.toString());
            }
        });
        System.out.println("==============forEach and List method reference==============");
        //2. forEach and List method reference
        stringList.forEach(System.out::println);
        //2. forEach and List Stream and filter Output : B
        System.out.println("==============2. forEach and List Stream and filter Output : B==============");
        stringList.stream()
                .filter(c -> c.contains("B"))
                .forEach(System.out::println);
    }

    private static List<String> setupListData() {
        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
        items.add("E");

        return items;
    }

    private static Map<String, Integer> setupMapData() {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        return items;
    }
}
