package url.core.service;

import url.core.entity.User;

import java.util.List;

/**
 * Created by N0stress on 20/02/2017.
 */
public interface UserService {

    public List<User> findAll();

    public User findByNom(String Nom);

    public User findByMail(String mail);

    public User findById(long id);

    public void deleteUser();

    public void saveUser();
}
