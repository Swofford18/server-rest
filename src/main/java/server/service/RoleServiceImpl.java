package server.service;

import server.model.Role;
import server.repository.RoleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role getAdminRole() {
        return roleRepository.getAdminRole();
    }

    public Role getUserRole() {
        return roleRepository.getUserRole();
    }
}
