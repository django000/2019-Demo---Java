package com.vitoz;

import java.io.IOException;

/**
 * Created by zhengwentao on 2018/9/4.
 */
public class Test {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println(reader.readLine()+"123");
//        Scanner sc = new Scanner(System.in);
//        System.out.println(sc.nextLine()+"123");
//        XiaoMing xiao = new XiaoMing();
//        Singer xiaoProxy = (Singer)Proxy.newProxyInstance(xiao.getClass().getClassLoader(), xiao.getClass().getInterfaces(), new InvocationHandler(){
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                if (method.getName().equals("sing")){
//                    System.out.println("给小明100块才唱歌");
//                    method.invoke(xiao, args);
//                }
//                return null;
//            }
//        });
//        xiaoProxy.sing();
    }

    private static void changeString(String text){
        text = "world";
    }
}

interface Singer{
    public void sing();
}
class XiaoMing implements Singer{
    @Override
    public void sing() {
        System.out.println("I am XiaoMing. ");
    }
}