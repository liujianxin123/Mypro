package shejimoshi.责任链模式;

public class HandlerB extends Handler{
    @Override
    public void handle() {
        boolean handled = false;    //...
        if (!handled && successor != null) {
            successor.handle();
        }
    }
}
