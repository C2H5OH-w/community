package com.nowcoder.community.util;

import com.nowcoder.community.entity.User;
import org.springframework.stereotype.Component;

//保证并发环境下，保存用户信息，替代session
@Component
public class HostHolder {

    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user) {
        users.set(user);
    }
    public User getUser() {
        return users.get();
    }

    public void clear() {
        users.remove();
    }
}
