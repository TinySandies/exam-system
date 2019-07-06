package top.tinysand.dao.implement;

import org.springframework.stereotype.Repository;
import top.tinysand.model.UserRole;

@Repository(value = "userRoleRepo")
public class UserRoleRepo extends BaseHibernateRepo<UserRole> {
    // 根据用户id获取用户角色信息
    public UserRole getUserRoleById(String userId) {
        return this.get(UserRole.class, userId);
    }
}
