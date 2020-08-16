package com.ex7.restfulapi.demo;

import com.ex7.restfulapi.DemoSqLInjection.userInjection;
import com.ex7.restfulapi.model.UsersEntity;
import com.ex7.restfulapi.service.implement.CategoryServiceImp;
import com.ex7.restfulapi.service.implement.UsersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    CategoryServiceImp wareHouseServiceImp;
    @Test
    public void testCode(){
        System.out.println(wareHouseServiceImp.identity());
    }
    @Autowired
    UsersService usersService;
    @Test
    public void TestUserSerive(){
//        List<UsersEntity> list = usersService.getAll();
//        list.forEach(usersEntity -> System.out.println(usersEntity.getUserName()+"|"+usersEntity.getUserPassword()));
        System.out.println(usersService.getById(""));
    }
    @Autowired private
    userInjection userInjection;
    @Test
    public  void demoSQLInjection(){
        boolean actual = userInjection.Login("user","user");
        boolean expected = true;
        Assertions.assertEquals(actual,expected);

    }
    @Test
    public void Injection(){
        boolean actual = userInjection.Login("'hi' OR '1' = '1'","'' OR '1' = '1'");
        boolean expected = true;
        System.out.println(actual);
        Assertions.assertEquals(actual,expected);
    }
}
