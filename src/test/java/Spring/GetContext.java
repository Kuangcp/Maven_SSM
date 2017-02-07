package Spring;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Myth on 2017/2/7 0007
 * 网上流传的五种方法全是扯淡，可以得到bean了要加载Context得到bean干嘛，注入不好嘛，脑子有洞。。。
 */
public class GetContext extends ApplicationObjectSupport{
    private Logger Log = LoggerFactory.getLogger(GetContext.class);
    @Before
    public void InitSpringContext(){
        new ClassPathXmlApplicationContext("application.xml");
    }

    @Test
    public void Extends(){
        ApplicationContext context = getApplicationContext();
        Log.info(context.toString());
    }
}
