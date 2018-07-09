package org.quickstart.modular.jarslink.service.a;

import com.alipay.jarslink.api.Action;

/**
 * 获取用户信息Action
 *
 * @author huyong
 */
public class UserAction implements Action<String, User>{
    @Override
    public User execute(String userName) {
        return new User()
                .setName(userName + "-new")
                .setAge(22)
                .setEmail("abc@gmail.com")
                .setGender(Gender.FEMALE)
                .setGender(Gender.MALE)
                .setMobile("131XXXXXXXX");
    }

    @Override
    public String getActionName() {
        return "user";
    }
}
