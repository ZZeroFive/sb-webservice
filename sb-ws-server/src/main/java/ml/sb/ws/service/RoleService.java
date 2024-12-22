package ml.sb.ws.service;

import javax.jws.WebService;

@WebService(name = "StudentRoleService",
        targetNamespace = "http://service.ws.sb.ml/")
public interface RoleService {
    String getUserRole(String uID);
}
