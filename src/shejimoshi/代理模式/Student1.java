package shejimoshi.代理模式;

public class Student1 {
    private String name = "张三";
    private String age = "20";

    public String getName_Age(){
        return this.name + this.age;
    }

    public String getAll(String name,String age){
        return name + age;
    }
}
