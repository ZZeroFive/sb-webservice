package ml.sb.ws.config;


import ml.sb.ws.service.PermissionService;
import ml.sb.ws.service.RoleService;
import ml.sb.ws.service.UserService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class CXFConfig {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permService;

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), userService);
        endpoint.publish("/ws/api/user");
        return endpoint;
    }

    @Bean
    public Endpoint roleEndPoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), roleService);
        endpoint.publish("/ws/api/role");
        return endpoint;
    }

    @Bean
    public Endpoint permissionEndPoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), permService);
        endpoint.publish("/ws/api/permission");
        return endpoint;
    }
}
