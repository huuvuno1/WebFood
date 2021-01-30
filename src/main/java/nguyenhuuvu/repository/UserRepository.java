package nguyenhuuvu.repository;

import org.springframework.data.repository.CrudRepository;

import nguyenhuuvu.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>{
	UserEntity findOneByUsername(String username);
}
