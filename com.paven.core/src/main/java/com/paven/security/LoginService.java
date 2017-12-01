package com.paven.security;

import com.paven.db.repository.PersonRepository;
import com.paven.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class LoginService implements UserDetailsService {

	@Autowired
	private PersonRepository personDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Person user = personDao.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("User not exist:" + username);
		return user;
	}

}
