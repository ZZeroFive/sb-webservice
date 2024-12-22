package ml.sb.ws.service;



import ml.sb.ws.domain.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(name = "StudentService",
        targetNamespace = "http://service.ws.sb.ml/")
public interface UserService {
    @WebMethod
    boolean saveUser(User user);
    @WebMethod
    User getUserByID(String id);
    @WebMethod
    List<User> getAllUsers();
}
