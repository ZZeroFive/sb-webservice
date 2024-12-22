package ml.sb.ws.service.impl;

import lombok.extern.slf4j.Slf4j;
import ml.sb.ws.domain.User;
import ml.sb.ws.service.UserService;
import org.springframework.stereotype.Component;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@WebService(name = "StudentService",
        targetNamespace = "http://service.ws.sb.ml/",
        endpointInterface = "ml.sb.ws.service.UserService")

public class UserServiceImpl implements UserService {
    @Override
    public boolean saveUser(@WebParam User user) {
        log.info("添加用户成功: {}", user);
        return false;
    }

    @Override
    public User getUserByID(@WebParam String id) {
        log.info("用户ID: {}", id);
        User u = new User();
        u.setId("10086");
        u.setName("zs");
        u.setAge(10);
        u.setScore(99);
        return u;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> resultLists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User u = new User();
            u.setId("10086_" + i);
            u.setName("zs_" + i);
            u.setAge(10+i);
            u.setScore(99+i);
            resultLists.add(u);
        }
        return resultLists;
    }
}
