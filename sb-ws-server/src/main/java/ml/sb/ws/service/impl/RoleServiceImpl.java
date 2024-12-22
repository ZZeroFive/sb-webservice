package ml.sb.ws.service.impl;

import lombok.extern.slf4j.Slf4j;
import ml.sb.ws.service.RoleService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@Component
@Slf4j
@WebService(name = "StudentRoleService",
        targetNamespace = "http://service.ws.sb.ml/")
public class RoleServiceImpl implements RoleService {
    @Override
    public String getUserRole(String uID) {
        log.info("[getUserRole] : {}", uID);
        return "[getUserRole] " + uID;
    }
}
