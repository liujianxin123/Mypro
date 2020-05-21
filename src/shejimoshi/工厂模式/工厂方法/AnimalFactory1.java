package shejimoshi.工厂模式.工厂方法;

import shejimoshi.工厂模式.Animal;
import shejimoshi.工厂模式.Cat;
import shejimoshi.工厂模式.Dog;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单工厂模式
 */
public class AnimalFactory1 implements AnimalFactoryTall{
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
        Animal animal = AnimalFactory1.getIntance(type);
        System.out.println(animal.say());
    }
}
