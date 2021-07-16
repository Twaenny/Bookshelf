package ch.twaenny.bookshelf.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ch.twaenny.bookshelf.repository.UserRepository;

@Service
public class UserDetailsSeviceImpl implements UserDetailsService {

	@Autowired UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) 
		throws UsernameNotFoundException
	{
		return userRepository.findByUserName(username)
			.orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
	}
}
