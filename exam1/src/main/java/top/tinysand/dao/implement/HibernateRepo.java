package top.tinysand.dao.implement;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import top.tinysand.model.ExamTest;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@Repository(value = "hibernateRepo")
public class HibernateRepo {
    /*数据库DML操作模板抽象*/
    private void hibernateDML(Consumer<Session> sessionConsumer) {
        Session session = getSession();
        /*开启事务*/
        Transaction transaction = session.beginTransaction();
        /*数据持久化*/
        sessionConsumer.accept(session);
        /*事务提交*/
        transaction.commit();
    }

    /*开启会话*/
    private Session getSession() {
        return configuration.configure().buildSessionFactory().openSession();
    }

    /*数据库DQL操作模板抽象*/
    private <R> R hibernateDQL(Function<Session, R> query) {
        Session session = getSession();
        /*开启事务*/
        Transaction transaction = session.beginTransaction();
        /*数据查询*/
        R result = query.apply(session);

        /*事务提交*/
        transaction.commit();
        return result;
    }

    /*保存实体*/
    public void saveModel(ExamTest examTest) {
        hibernateDML(session -> session.save(examTest));
    }

    /*更新实体*/
    public void updateModel(ExamTest examTest) {
        hibernateDML(session -> session.update(examTest));
    }

    /*根据实体删除数据*/
    public void deleteModel(ExamTest examTest) {
        hibernateDML(session -> session.delete(examTest));
    }

    /*根据主键查询一条数据*/
    public <R> R queryRecord(Class<R> type, Integer id) {
        return hibernateDQL(session -> session.get(type, id));
    }

    /*根据类型查询多条数据*/
    public <R> List queryRecords(Class<R> type) {
        return hibernateDQL(session -> session.createQuery(
                "from " + type.getSimpleName()
        ).list());
    }

    /*实例化配置类*/
    private static Configuration configuration = new Configuration();
}
