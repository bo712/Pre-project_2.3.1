package web.service;

import org.springframework.transaction.annotation.Transactional;

public interface IRoleService {

    void setDefaultRoles();

    @Transactional
    boolean isRolesEmpty();
}
