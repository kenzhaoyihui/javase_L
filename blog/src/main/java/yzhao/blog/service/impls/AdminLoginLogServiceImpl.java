package yzhao.blog.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yzhao.blog.bean.AdminLoginLog;
import yzhao.blog.dao.AdminLoginLogMapper;
import yzhao.blog.service.AdminLoginLogService;

import java.util.List;


@Service
public class AdminLoginLogServiceImpl implements AdminLoginLogService{

    @Autowired
    public AdminLoginLogMapper adminLoginLogMapper;

    @Override
    public int selectCountByAdminId(int adminId) {
        //return 0;

        return adminLoginLogMapper.selectCountByAdminId(adminId);
    }

    @Override
    public List<AdminLoginLog> selectRencent(Integer adminId) {
        //return null;
        return adminLoginLogMapper.selectRencent(adminId);
    }

    @Override
    public int insert(AdminLoginLog adminLoginLog) {
        //return 0;
        return adminLoginLogMapper.insert(adminLoginLog);
    }
}
