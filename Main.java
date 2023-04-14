
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Party time! :)");
        MyListImpl<String> list = new MyListImpl<>();
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        list.add("fox");
        list.add("cat");
        list.add("dog");
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list);
        System.out.println(list.indexOf("cat"));
        System.out.println(list.indexOf("word"));
        System.out.println(list.contains("fox"));
        System.out.println(list.contains("word"));

        list.remove("dog");
        System.out.println(list);
        System.out.println(list.remove(1));
        System.out.println(list);

        list.clear();
        System.out.println(list);
        list.add("fox");
        list.add("cat");
        list.add("cat");
        list.set(2, "dog");
        System.out.println(list.get(2));
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}