package shejimoshi.观察者模式;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    private List<RegisterObserver> registerObservers = new ArrayList<RegisterObserver>();
    public void setRegisterObservers(RegisterObserver registerObserver){
        registerObservers.add(registerObserver);
    }

    /**
     * 使用观察者模式注册完成后发短息或者qq
     */
    public void doRegister(){

        //注册的逻辑。。。。

        //发信息的逻辑
        for(RegisterObserver registerObserver : registerObservers){
            registerObserver.doSomeThing();
        }
    }
}
