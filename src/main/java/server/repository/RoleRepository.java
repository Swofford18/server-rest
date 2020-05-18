package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import server.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r WHERE r.name='ROLE_ADMIN'")
    Role getAdminRole();

    @Query("SELECT r FROM Role r WHERE r.name='ROLE_USER'")
    Role getUserRole();
}
