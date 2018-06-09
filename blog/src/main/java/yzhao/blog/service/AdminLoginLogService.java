package yzhao.blog.service;

import yzhao.blog.bean.AdminLoginLog;

import java.util.List;

public interface AdminLoginLogService {

    List<AdminLoginLog> selectRencent(Integer adminId);

    int insert(AdminLoginLog adminLoginLog);

    int selectCountByAdminId(int adminId);
}
