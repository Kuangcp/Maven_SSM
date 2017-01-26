/*
import com.myth.mysql.TableTurnClass;
import org.junit.Test;
import org.slf4j.LoggerFactory;

*/
/**
 * Created by Myth on 2017/1/21 0021
 * 生成Bean类文件，最好不要在实际使用时运行调试这个工具类，不然之后会有一堆的错误影响到这里不能运行！！IDEA特性
 *//*

public class TestCreateBean {
    private static org.slf4j.Logger log = LoggerFactory.getLogger(TestCreateBean.class);
    @Test
    public void createBean(){
        */
/*String table = "book";
        String [] names = table.split("_");

        if(names==null || names.length==1){
            table = table.substring(0,1).toUpperCase()+table.substring(1,table.length());
        }else{
            table="";
            for(String word:names){
                table += word.substring(0,1).toUpperCase()+word.substring(1,word.length());
            }
        }

        log.info(table);*//*

        TableTurnClass.CreateAllTable("main.java.com.book.bean","com.book.bean","ebook","root","123456",false);
        log.info("成功");

    }
}
*/
