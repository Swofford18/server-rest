package server.service;

import server.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role getAdminRole();

    Role getUserRole();
}
