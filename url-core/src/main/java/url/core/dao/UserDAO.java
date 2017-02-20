package url.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import url.core.entity.Url;
import url.core.entity.User;

/**
 * Created by N0stress on 20/02/2017.
 */
public interface UserDAO extends JpaRepository<User, Long> {

}
