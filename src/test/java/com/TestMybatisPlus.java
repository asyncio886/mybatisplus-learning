package com;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mappers.UserMapper;
import com.pojo.Sex;
import com.pojo.User;
import com.service.lpmls.BlogUserServiceImpl;
import com.service.lpmls.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

@SpringBootTest(classes = {WebApplication.class})
@RunWith(SpringRunner.class)
public class TestMybatisPlus {
    @Value("#{userMapper}")
    UserMapper userMapper;
    @Value("#{userServiceImpl}")
    UserServiceImpl userService;
    @Value("#{blogUserServiceImpl}")
    BlogUserServiceImpl blogUserService;
    @Test
    public void testSelectList(){
        List<User> list = userMapper.selectList(null);
        System.out.println(list);
    }
    @Test
    public void testInsert(){
        User user = new User();
        user.setId((long)100);
        user.setName("丁真");
        user.setPassword("1234567890");
        int effectLine = userMapper.insert(user);
        System.out.println(effectLine);
    }
    @Test
    public void testPlusIpml(){
        long count = userService.count();
        System.out.println(count);
    }
    public String ttt(){
        try {
            int i = 1/0;
        }catch (Exception e){
            return "ttt";
        }
        return  "aaa";
    }
    @Test
    public void testTTT(){
        System.out.println(ttt());
    }
    @Test
    @Transactional
    public void testService(){
        List<User> list = userService.list();
        User user = new User();
        user.setPassword("dsadsadsa");
        user.setName("fffffff");
        user.setId(11L);
        userService.saveOrUpdate(user);
        System.out.println(list);
    }
    @Test
    public void testDeleteLogic(){
        boolean st = userService.removeById(1);
        System.out.println(st);
    }
    @Test
    public void testWrapper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("password").eq("id",3);
        System.out.println(userService.list(queryWrapper));
    }
    @Test
    public void inSqlTest(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("password","SELECT password FROM user WHERE id = 3");
        System.out.println(userService.list(queryWrapper));
    }
    @Test
    public void testUpdateWrapper(){
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("id",3).set("name","习近平");
        userService.update(userUpdateWrapper);
    }
    @Test
    public void testCondition(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        String str = null;
        queryWrapper.isNull(str == null,"password");
        System.out.println(userService.list(queryWrapper));
    }
    @Test
    public void testLambdaColumn(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getId,"3");
        System.out.println(userService.list(lambdaQueryWrapper));
    }
    @Test
    public void testPage(){
        Page<User> page = new Page<>(1,1);
        page.setCurrent(1);
        page.setSize(2);
        Page<User> page1 = userMapper.selectPage(page,null);
        System.out.println(page1.getRecords());
    }
    @Test
    public void testXMLDesignPage(){
        Page<User> page = new Page<>(1,1);
        Page<User> page1 = userMapper.mySelectPage(page,"1");
        System.out.println(page1.getRecords());
    }
    @Test
    public void testWrapperDesignPage(){
        Page<User> page = new Page<>(2,1);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getPassword,"-1");
        userService.page(page,wrapper);
        System.out.println(page.getRecords());
    }
    @Test
    @Transactional
    public void testEnum(){
        User user = new User();
        user.setSex(Sex.MALE);
        user.setPassword("3333");
        user.setId(1111L);
        user.setName("fff");
        user.setIs_deleted(0);
        userService.save(user);
        System.out.println(userService.getById(1111L));
    }
    @Test
//    @Transactional
    public void testDynamic(){
        System.out.println(blogUserService.count());
    }
}
