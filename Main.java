package Collections;

import java.util.Iterator;

public class Main {
    public static void main(String [] args){
        ItMap<String,String> m = new ItHashMap<>();
        m.put("russia", "moscow");
        m.put("usa", "washington");
        m.put("germany", "berlin");
        m.put("france", "paris");
        m.put("belarus", "bryansk");
        m.put("belarus", "minsk");
        m.put("belarus", "minsk");

        System.out.println(m.size());
        System.out.println(m.get("france"));
        System.out.println(m.get("russia"));
        System.out.println(m.get("australia"));
        System.out.println(m.get("belarus"));
        Iterator<Node<String, String>> iter = m.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next().toString());
        }
    }
}
