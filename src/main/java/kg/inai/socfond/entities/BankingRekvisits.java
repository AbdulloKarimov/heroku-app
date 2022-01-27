package kg.inai.socfond.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BankingRekvisits extends Audit<String> {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    Country country;

    @Column(columnDefinition = "TEXT")
    String fio;

    @Column(columnDefinition = "TEXT")
    String rekvisitNumber;

    String bankName;

    String filialName;

    String bikNumber;

    String binNumber;

    String numberRasschet;

    String correspondentSchet;

}
