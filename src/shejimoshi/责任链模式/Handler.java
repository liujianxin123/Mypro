package shejimoshi.责任链模式;

public abstract class Handler {
    protected Handler successor = null;
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
    public abstract void handle();
}
