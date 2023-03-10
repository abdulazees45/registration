package com.registration.main;

import static java.util.Optional.ofNullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
final class UserServiceImpl implements UserService {

  Map<String, User> users = new HashMap<>();
  
 
		  users.put("Azeez", new User("0","azeez","natham"));
  

  @Override
  public User save(final User user) {
    return users.put(user.getId(), user);
  }

  @Override
  public Optional<User> find(final String id) {
    return ofNullable(users.get(id));
  }

  @Override
  public Optional<User> findByUsername(final String username) {
    return users
      .values()
      .stream()
      .filter(u -> Objects.equals(username, u.getUsername()))
      .findFirst();
  }
}

