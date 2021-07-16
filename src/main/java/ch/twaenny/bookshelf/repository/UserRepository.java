package ch.twaenny.bookshelf.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ch.twaenny.bookshelf.model.AppUser;
import ch.twaenny.bookshelf.model.AppUserImpl;



public interface UserRepository
extends CrudRepository<AppUserImpl, Long>{

default AppUser insertUser(String userName, String password, List<String> roles, String string, String string2) {
	return save(new AppUserImpl(userName, password, roles));
}

@Query
Optional<AppUser> findByUserName(String userName);

default AppUser setRoles(AppUser user, List<String> roles) {
	return save(((AppUserImpl)user).setRoles(roles));
}
}

