package top.tinysand.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.function.Consumer;
import java.util.function.Function;

public abstract class AbstractRepository {
    //数据库DML操作模板抽象
    protected void hibernateDML(Consumer<Session> sessionConsumer) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction(); //开启事务
        sessionConsumer.accept(session);                      //数据持久化
//        commitAndClose(session, transaction);                 //事务提交
        commit(transaction);
    }

    //开启会话
    protected Session getSession() {
        return configuration.configure().buildSessionFactory().openSession();
    }

    //数据库DQL操作模板抽象
    protected <R> R hibernateDQL(Function<Session, R> query) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction(); //开启事务
        R result = query.apply(session);                      //数据查询
//        commitAndClose(session, transaction);                 //事务提交
        commit(transaction);
        return result;
    }

    //事务提交并关闭会话
    private void commitAndClose(Session session, Transaction transaction) {
        transaction.commit();
        session.close();
    }

    private void commit(Transaction transaction) {
        transaction.commit();
    }

    //实例化配置类
    private static Configuration configuration = new Configuration();
}
