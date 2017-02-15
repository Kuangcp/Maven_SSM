package redis;

import com.test.bean.IUserDao;
import com.test.bean.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Myth on 2017/2/15 0015
 */
@ContextConfiguration(locations = {"classpath*:application.xml"})
public class RedisTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private IUserDao redisUserDao;

    /**
     * 新增
     * <br>------------------------------<br>
     */
    @Test
    public void testAddUser() {
        User user = new User();
        user.setId("user1");
        user.setName("java2000_wl");
        boolean result = redisUserDao.add(user);
        Assert.assertTrue(result);
    }

    /**
     * 批量新增 普通方式
     * <br>------------------------------<br>
     */
    @Test
    public void testAddUsers1() {
        List<User> list = new ArrayList<User>();
        for (int i = 10; i < 50000; i++) {
            User user = new User();
            user.setId("user" + i);
            user.setName("java2000_wl" + i);
            list.add(user);
        }
        long begin = System.currentTimeMillis();
        for (User user : list) {
            redisUserDao.add(user);
        }
        System.out.println(System.currentTimeMillis() -  begin);
    }

    /**
     * 批量新增 pipeline方式
     * <br>------------------------------<br>
     */
    @Test
    public void testAddUsers2() {
        List<User> list = new ArrayList<User>();
        for (int i = 10; i < 1500000; i++) {
            User user = new User();
            user.setId("user" + i);
            user.setName("java2000_wl" + i);
            list.add(user);
        }
        long begin = System.currentTimeMillis();
        boolean result = redisUserDao.add(list);
        System.out.println(System.currentTimeMillis() - begin);
        Assert.assertTrue(result);
    }

    /**
     * 修改
     * <br>------------------------------<br>
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId("user1");
        user.setName("new_password");
        boolean result = redisUserDao.update(user);
        Assert.assertTrue(result);
    }

    /**
     * 通过key删除单个
     * <br>------------------------------<br>
     */
    @Test
    public void testDelete() {
        String key = "user1";
        redisUserDao.delete(key);
    }

    /**
     * 批量删除
     * <br>------------------------------<br>
     */
    @Test
    public void testDeletes() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add("user" + i);
        }
        redisUserDao.delete(list);
    }

    /**
     * 获取
     * <br>------------------------------<br>
     */
    @Test
    public void testGetUser() {
        String id = "user1";
        User user = redisUserDao.get(id);
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getName(), "java2000_wl");
    }

    /**
     * 设置redisUserDao
     * @param redisUserDao the redisUserDao to set
     */
    public void setredisUserDao(IUserDao redisUserDao) {
        this.redisUserDao = redisUserDao;
    }
}
