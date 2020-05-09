package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.IRoleDao;

@Service
public class RoleService implements IRoleService {

    private IRoleDao roleDao;

    @Transactional
    @Override
    public void setDefaultRoles() {
        roleDao.setDefaultRoles();
    }
}
