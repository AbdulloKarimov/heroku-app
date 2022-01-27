package kg.inai.socfond.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PredstavitelData extends Audit<String> {

    //персональные данные
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(columnDefinition = "TEXT")
    String fio;

    //Удостоверяющий документ
    @OneToOne(cascade = {CascadeType.ALL})
    PersonalDocument personalDocument;

    @ManyToOne(cascade = {CascadeType.ALL})
    Country countryOfLive;

    String postIndex;

    @ManyToOne(cascade = {CascadeType.ALL})
    Oblast oblastLive;

    @ManyToOne(cascade = {CascadeType.ALL})
    Rayon rayonLive;

    @ManyToOne(cascade = {CascadeType.ALL})
    PlaceName nasPunkt;

    String street;

    String houseNumber;

    String korpus;

    String appartmentNumber;

    String phoneNumber;

    String email;

    @OneToOne(cascade = {CascadeType.ALL})
    PolnomochiyaDocument polnomochiyaDocument;

    //индивидуальный номер
    @ManyToOne(cascade = {CascadeType.ALL})
    Country country;

    String identityNumber;

    //подтверждающий документ
    @OneToOne(cascade = {CascadeType.ALL})
    PersonalAcceptDocument personalAcceptDocument;
}
