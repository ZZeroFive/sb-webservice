package ml.sb.ws.service.impl;

import lombok.extern.slf4j.Slf4j;
import ml.sb.ws.service.PermissionService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@Slf4j
@Component
@WebService(name = "StudentPermissionService",
        targetNamespace = "http://service.ws.sb.ml/")
public class PermissionServiceImpl implements PermissionService {
    @Override
    public String geUserPermission(String uId) {
        log.info("请求uID: {}", uId);
        return "permission has [create, read]";
    }
}
