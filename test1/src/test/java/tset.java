import org.junit.Test;

import javax.xml.ws.Holder;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

/**
 * @author XT
 * @Title: tset
 * @Date: 2024/5/9 17:27
 * @description: tset测试
 */
public class tset {

    @Test
    public void test(){
       String name = "张三";
       name = "张三".equals(name) ? "李四" : name;
        Holder<String> holder = new Holder<>(name);
        System.out.println("李四".equals(holder.value));
         Consumer<String> consumer = value ->{

            if ("李四".equals(holder.value)) {
                holder.value = value;
                System.out.println("---");
            }
             System.out.println("213213");
        };
        System.out.println(holder.value);
    }


    @Test
    public void test1(){
        int a = 20;
        a = save(a);
        System.out.println(a);
    }

    public void kill(int a){
        a = 10;
    }

    public int save(int a){
        return  a = 30;
    }

    @Test
    public void test2(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
            System.out.println(list.get(i));
        }
    }

    public void test3(){
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            return "张三";
        }, null);
        try {
            completableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
