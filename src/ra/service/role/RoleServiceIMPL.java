package ra.service.role;

import ra.model.Role;
import ra.model.RoleName;
import ra.service.role.IRoleService;

import java.util.ArrayList;
import java.util.List;

public class RoleServiceIMPL implements IRoleService {
    public static List<Role> roles = new ArrayList<>();

    static {
        roles.add(new Role(1, RoleName.USER));
        roles.add(new Role(2, RoleName.PM));
        roles.add(new Role(3, RoleName.ADMIN));
    }

    @Override
    public List<Role> findAll() {
        return roles;
    }

    // tìm ra role
    @Override
    public Role findByAll(RoleName name) {
        for (Role role : roles) {
            if (role.getName() == name) {
                return role;
            }
        }
        return null;
    }
}
