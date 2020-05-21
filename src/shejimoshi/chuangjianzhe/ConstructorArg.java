package shejimoshi.chuangjianzhe;


import com.sun.tools.javac.util.StringUtils;

//在下面的 ConstructorArg 类中，当 isRef 为 true 的时候，arg 表示 String 类型的 refBeanId，
//type 不需要设置；当 isRef 为 false 的时候，arg、type 都需要设置。
//请根据这个需求，完善 ConstructorArg 类。
public class ConstructorArg {
    private boolean isRef;
    private Class type;
    private Object arg;

    private ConstructorArg(ConstructorArgBuilder builder){
        this.isRef = builder.isRef;
        this.type = builder.type;
        this.arg = builder.arg;
    }

    public static class ConstructorArgBuilder {
        private  boolean isRef;
        private  Class type;
        private  Object arg;


        public ConstructorArg builder(){
            if(isRef && type != null){

            }
            else if(!isRef && type == null){

            }
            else if(isRef && arg.getClass() != String.class){

            }
            if (!this.isRef && arg == null) {
                throw new IllegalArgumentException("...");
            }
            return new ConstructorArg(this);
        }


        public ConstructorArgBuilder setIsRef(boolean isRef){

            this.isRef = isRef;

            return this;
        }

        public ConstructorArgBuilder setType(Class type){

            this.type = type;

            return this;
        }
        public ConstructorArgBuilder setArg(Object arg){

            this.arg = arg;

            return this;
        }




    }


    public static void main(String[] args) {
        ConstructorArg constructorArg = new ConstructorArgBuilder().setArg(false).setIsRef(true).setType(String.class).builder();
    }
}
