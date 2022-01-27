package kg.inai.socfond.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Table
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompetentOrganOtpravitel extends Audit<String> {
    @Id
    @GeneratedValue
    Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    Country country;

    String code;

    String codeTerrPodrazdel;

    String address;

    String phone;

    String fax;

    String email;
}
