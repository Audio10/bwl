package mx.com.bwl.mutation.service;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import mx.com.bwl.mutation.dao.UserRepository;
import mx.com.bwl.mutation.entity.User;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
	
final private UserRepository userRepository;

/**
 * Metodo para guardar un Usuario.
 * @param user
 * @return
 * 
 */
@Transactional
public User createUser(User user) {
	return this.userRepository.save(user);
}

/**
 * Metodo para actualizar un Usuario.
 * @param user
 * @return
 * 
 */
@Transactional
public User update(User user) {
	return this.userRepository.save(user);
}

/**
 * Metodo para eliminar un Usuario.
 * @param user
 * @return
 * 
 */
@Transactional
public void delete(User user) {
	this.userRepository.delete(user);
}

/**
 * Metodo para buscar un Usuario por name y password.
 * @param name Nickname o Usuario para login.
 * @param password Password del Usuario.
 * @return
 * 
 */
public User login(String name, String password) {
	return this.userRepository.findByNameAndPassword(name, password);
}

}
