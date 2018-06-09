package yzhao.blog.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yzhao.blog.bean.Admin;
import yzhao.blog.dao.AdminMapper;
import yzhao.blog.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    public AdminMapper adminMapper;

    @Override
    public Admin getAdminById(Integer id) {
        //return null;
        return adminMapper.selectByPrimaryKey(id);
    }
}
