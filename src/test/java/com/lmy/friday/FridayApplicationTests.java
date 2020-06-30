package com.lmy.friday;


import com.lmy.friday.mapper.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FridayApplicationTests {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void contextLoads() {
        String encode = new BCryptPasswordEncoder().encode("121891");
        System.out.println(encode);
        sysUserMapper.update(3,encode);
    }

}
