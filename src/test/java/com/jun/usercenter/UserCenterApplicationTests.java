package com.jun.usercenter;

import com.jun.usercenter.common.ErrorCodeEnum;
import com.jun.usercenter.model.domain.User;
import com.jun.usercenter.model.domain.request.UserRegisterRequest;
import com.jun.usercenter.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;

@SpringBootTest
class UserCenterApplicationTests {

    @Resource
    private UserService userService;
    @Test
    public void testSelect() {
        System.out.println("center-user test");
        User user = new User();
        user.setUsername("beihong");
        user.setUserAccount("123");
        user.setAvatarUrl("https://images.zsxq.com/FtsIYhFFv4i-XTQ3bY8NvCnH4rBj?e=1714492799&token=kIxbL07-8jAj8w1n4s9zv64FuZZNEATmlU_Vm6zD:KlYMXmIoOf3o7cQFe2Csjk0fKl4=");
        user.setGender(0);
        user.setUserPassword("123");
        user.setPhone("123");
        user.setEmail("123");
        Assertions.assertTrue(userService.save(user));
        System.out.println(user.getId());

    }

    @Test
    void testInsert(){
        long result1 = userService.userRegister("", "123121313", "123121313");
        Assertions.assertTrue(-1 == result1);

        long result2 = userService.userRegister("123", "123121313", "123121313");
        Assertions.assertTrue(-1 == result2);

        long result3 = userService.userRegister("12345", "1313", "1313");
        Assertions.assertTrue(-1 == result3);

        long result4 = userService.userRegister("12341", "1231&&sfs1", "1231&&sfs1");
        Assertions.assertTrue(-1 == result4);

        long result5 = userService.userRegister("123412", "123121313", "123121311");
        Assertions.assertTrue(-1 == result5);

        long result6 = userService.userRegister("123212", "123121313", "123121313");
        Assertions.assertTrue(-1 != result6);
    }


    @Test
    void testIdeal(){

        System.out.println(ErrorCodeEnum.SUCCESS);
    }

}
