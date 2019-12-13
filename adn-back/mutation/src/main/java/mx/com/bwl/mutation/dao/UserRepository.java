package mx.com.bwl.mutation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.bwl.mutation.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	

}
