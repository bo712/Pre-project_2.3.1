package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.IRoleDao;

@Service
public class RoleService implements IRoleService {

    private IRoleDao roleDao;

    @Autowired
    public void setRoleDao(IRoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Transactional
    @Override
    public void setDefaultRoles() {
        if (isRolesEmpty()) {
            roleDao.setDefaultRoles();
        }
    }

    @Transactional
    @Override
    public boolean isRolesEmpty() {
        return roleDao.isRolesEmpty();
    }
}
