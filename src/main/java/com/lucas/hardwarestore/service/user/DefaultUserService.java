package com.lucas.hardwarestore.service.user;

import com.lucas.hardwarestore.dao.UserRepository;
import com.lucas.hardwarestore.model.user.UserModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service(value = "userService")
public class DefaultUserService implements UserService{
    @Resource(name = "userRepository")
    private UserRepository userRepository;

    @Override
    public List<UserModel> findAll() {
        return getUserRepository().findAll();
    }

    @Override
    public Optional<UserModel> findById(long id) {
        return getUserRepository().findById(id);
    }

    @Override
    public UserModel create(UserModel userModel) {
        return getUserRepository().save(userModel);
    }

    @Override
    public void delete(long id) {
        getUserRepository().deleteById(id);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
