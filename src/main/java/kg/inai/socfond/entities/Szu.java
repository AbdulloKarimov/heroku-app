package kg.inai.socfond.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Szu extends Audit<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    CompetentOrganPoluchatel competentOrganPoluchatel;

    @ManyToOne(cascade = {CascadeType.ALL})
    CompetentOrganOtpravitel competentOrganOtpravitel;


    @ManyToOne(cascade = {CascadeType.ALL})
    PersonalData personalData;

    /** 16. Сведения о завершении удержания */
    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    SvedOZaversheniUderjaniya svedOZaversheniUderjaniya;

    /** 17. Дополнительная информация */
    @Column(columnDefinition = "TEXT")
    String dopInfo;

    /** 18. Прилагаемый документ */

    @Column(columnDefinition = "TEXT")
    @Nullable
    String namePrilDocument;

    @Nullable
    String codePrilDocument;

    @Nullable
    String countOfPapersPrilDocument;

    @Column(columnDefinition = "TEXT")
    String documentBinaryFormat;
    //здесь добавить документ в бинарном формате







}
