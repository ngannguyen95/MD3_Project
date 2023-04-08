package ra.service.role;

import ra.model.Role;
import ra.model.RoleName;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();
    Role findByAll(RoleName name);
}
