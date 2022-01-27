package kg.inai.socfond.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "usr")
@Entity
public class User extends Audit<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String username;

    String password;

    String firstName;

    String lastName;

    String patronymic;

    String phoneNumber;

    String email;


    @CollectionTable
    @ManyToMany(fetch = FetchType.EAGER)
    List<UserRole> userRoles;
}
