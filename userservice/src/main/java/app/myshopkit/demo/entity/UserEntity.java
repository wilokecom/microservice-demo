package app.myshopkit.demo.entity;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity(name = "users")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(length = 100)
    private String age;

    @Column(length = 100)
    private String sex;
}
