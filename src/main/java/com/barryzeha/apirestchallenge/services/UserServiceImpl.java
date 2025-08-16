package com.barryzeha.apirestchallenge.services;

import com.barryzeha.apirestchallenge.model.User;
import com.barryzeha.apirestchallenge.model.UserLogin;
import com.barryzeha.apirestchallenge.model.UserWithToken;
import com.barryzeha.apirestchallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepo, PasswordEncoder passwordEncoder){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public ResponseEntity<User> saveUser(User user) {
        String passwordEncrypted = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncrypted);
        User  userSaved = userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
    }

    @Override
    public ResponseEntity<User> updateUser(User user) {
        return userRepo.findById(user.getId()).map(userFound->{
           user.setId(userFound.getId());
           user.setUpdateAt(LocalDateTime.now().toString());
           User userUpdated = userRepo.save(user);
            return ResponseEntity.status(HttpStatus.OK).body(userUpdated);
        }).orElseGet(()->{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        });
    }

    @Override
    public ResponseEntity<String> deleteUser(String userId) {
        return userRepo.findById(userId).map(user->{
            //We are not really deleting the user, only updating the 'deleted' field. Then, the user is not shown in the main list.
            user.setDelete(true);
            user.setId(userId);
            userRepo.save(user);
            return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
        }).orElseGet(()->{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User id not found");
        });

    }

    @Override
    public List<User> getAllUsers() {
        //return userRepo.findAll();
        return userRepo.findAllUsers();
    }

    @Override
    public ResponseEntity<User> getUserById(String id) {
        return userRepo.findById(id).map(user->{
            return ResponseEntity.status(HttpStatus.FOUND).body(user);
        }).orElseGet(()->{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        });
    }

    @Override
    public ResponseEntity<User> getUserByUsername(String name) {
        return userRepo.findUserByUserName(name).map(user->{
            return ResponseEntity.status(HttpStatus.FOUND).body(user);
        }).orElseGet(()->{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        });

    }

    @Override
    public ResponseEntity<UserWithToken> checkUserNameAndPassword(UserLogin user) {
        return userRepo.findUserByUserName(user.getUsername()).map(mUser->{
                if(passwordEncoder.matches(user.getPassword(),mUser.getPassword())) {
                    // TODO implement token
                    UserWithToken userWithToken = new UserWithToken(mUser.getId(), mUser.getUsername(), "Token yet gen");
                    return ResponseEntity.status(HttpStatus.OK).body(userWithToken);
                }else{
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).<UserWithToken>body(null);
                }
            }).orElseGet(()-> {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        });
    }
}
