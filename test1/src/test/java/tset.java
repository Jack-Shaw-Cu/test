import org.junit.Test;

import javax.xml.ws.Holder;
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
        System.out.println("--------");
    }
}
