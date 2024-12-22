package ml.sb.ws.service;


import javax.jws.WebService;

@WebService(name = "StudentPermissionService",
        targetNamespace = "http://service.ws.sb.ml/")
public interface PermissionService {

    String geUserPermission(String uId);
}
