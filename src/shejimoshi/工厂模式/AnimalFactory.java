package shejimoshi.工厂模式;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单工厂模式
 */
public class AnimalFactory{
    private static final Map<String,Animal> map = new HashMap<String,Animal>();
    static {
        map.put("dog",new Dog());
        map.put("cat",new Cat());
    }
    public static Animal getIntance(String type){
        if(type == null){
            return null;
        }
        return map.get(type);
    }

    public static void main(String[] args) {
        String type = "dog";
        Animal animal = AnimalFactory.getIntance(type);
        System.out.println(animal.say());
    }
}
