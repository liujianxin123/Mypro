public class Station extends Thread{

    public Station(String name){
        super.setName(name);
    }
    // 创建一个静态钥匙
    static Object ob = new Object();//值是任意的
    static int tick = 50;
    @Override
    public void run(){
        while (tick > 0){

            synchronized (ob){
                if (tick > 0) {
                    System.out.println(getName() + "卖出了第" + tick + "张票");
                    try {
                        sleep(100);//休息一秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("优先级："+this.getPriority());
                    tick--;
                } else {
                    System.out.println("票卖完了");
                }
            }
//            try {
//                sleep(3000);//休息一秒
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
