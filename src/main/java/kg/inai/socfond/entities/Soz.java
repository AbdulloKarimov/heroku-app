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
public class Soz extends Audit<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    CompetentOrganPoluchatel competentOrganPoluchatel;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    CompetentOrganOtpravitel competentOrganOtpravitel;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    ZnachimoeObstoyatelstvo znachimoeObstoyatelstvo;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    TypeUchastnik typeUchastnik;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    PersonalData personalData;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    PredstavitelData predstavitelData;

    /**
     * 6. Сведения о получаемой  пенсии
     **/
    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    TypePensiya typePensiya;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    Country country;

    @Nullable
    String razmerPensii;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    Currency currency;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate startDate;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate endDate;

    @Nullable
    Boolean poluchalPensiyu;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    Country codeCountryForOtherVedomstva;

    @Nullable
    String codeTerrOrgan;

    @ManyToOne(cascade = {CascadeType.ALL})
    @Nullable
    TypePensiya typePensiyaForOtherVedomstva;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateStartTakingPensiya;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateEndTakingPensiya;

    /** 9. Сведения о трудовой деятельности */
    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    SvedeniyaOTrudDeyatelnosti svedeniyaOTrudDeyatelnosti;

    /** 10.  Сведения об изменении размера пенсии */
    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateChangedPensiya;

    @Nullable
    String pereschitannyiRazmerPensii;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    Currency codeValuty;

    /** Сведения о смерти трудящегося (члена семьи) */
    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    SvedAboutDeath svedAboutDeath;

    /** 12. Сведения о вступлении в брак, расторжении брака, изменении фамилии, имени, отчества трудящегося (члена семьи) */
    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    SvedAboutBrakChangeNameOrSurname svedAboutBrakChangeNameOrSurname;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateOfChangeAddress;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    Country codeOfLivingCountry;

    @Nullable
    String address;

    /** 14. Сведения об изменении гражданства трудящегося (члена семьи) */

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    SvedAboutChangeGrajdanstvo svedAboutChangeGrajdanstvo;

    /** 15. Сведения об иждивенцах и 15.1 Сведения об учебе иждивенца */
    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    SvedAboutIjdivenec svedAboutIjdivenec;

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
