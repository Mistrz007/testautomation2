package pl.mig.jdb;

import org.jdbi.v3.core.Handle;
import pl.mig.jdb.model.UserDao;

public class UserService {

    private static DatabaseJdbiService databaseJdbiService = new DatabaseJdbiService();
    private static UserDao userDao;
    private static Handle handle = databaseJdbiService.getHandle();

    public static JdbiUser getTestUser(Long id){
        userDao = handle.attach(UserDao.class);
        return userDao.getTestUserById(id);
    }
}
