package ch.zhaw.mobileeng.abetterliving.repository;

import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import ch.zhaw.mobileeng.abetterliving.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Object> {

}
