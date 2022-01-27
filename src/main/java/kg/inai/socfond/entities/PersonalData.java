package kg.inai.socfond.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonalData extends Audit<String> {

    //персональные данные
    @Id
    @GeneratedValue
    Long id;

    @Column(columnDefinition = "TEXT")
    String fio;

    @Column(columnDefinition = "TEXT")
    String fioPriRojdenii;

    @ManyToOne(cascade = {CascadeType.ALL})
    Country grajdanstvo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;

    String placeOfBirth;

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

    @Enumerated(EnumType.STRING)
    Sex sex;

    //Удостоверяющий документ
    @OneToOne(cascade = {CascadeType.ALL})
    PersonalDocument personalDocument;

    //индивидуальный номер
    @ManyToOne(cascade = {CascadeType.ALL})
    Country country;

    String identityNumber;

    //подтверждающий документ
    @OneToOne(cascade = {CascadeType.ALL})
    PersonalAcceptDocument personalAcceptDocument;


    //ЭТОТ ЭНТИТИ ТАК ЖЕ ИСПОЛЬЗУЕТСЯ ДЛЯ СВЕДЕНИЙ ОБ УМЕРШЕМ
    String nameDocumentDeath;

    String serieAndNumberDocumentDeath;

    String organVydavshiyDeath;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateVydachiDeath;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateDeath;

    String placeOfDeath;


}
