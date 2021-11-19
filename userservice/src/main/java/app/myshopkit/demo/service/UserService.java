package app.myshopkit.demo.service;

import app.myshopkit.demo.dto.UserDTO;
import app.myshopkit.demo.entity.UserEntity;
import app.myshopkit.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll(){
        System.out.println(userRepository.findAll());
        return userRepository.findAll();
    }

    public void insert() {
       UserEntity userEntity = new UserEntity();
       userEntity.setAge("12");
       userEntity.setFirstName("Le Hung");
       userEntity.setLastName("Vuong");
       userRepository.save(userEntity);
    }

    public UserDTO insert(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setSex(userDTO.getSex());
        userEntity.setAge(userDTO.getAge());
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userRepository.save(userEntity);

        return userDTO;
    }
}
