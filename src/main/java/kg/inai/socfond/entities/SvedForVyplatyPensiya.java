package kg.inai.socfond.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.DateTimeException;
import java.time.LocalDate;

@Getter
@Setter
@Table
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SvedForVyplatyPensiya extends Audit<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @Nullable
    CompetentOrganPoluchatel competentOrganPoluchatel;

    @ManyToOne(cascade = {CascadeType.ALL})
    @Nullable
    CompetentOrganOtpravitel competentOrganOtpravitel;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateObrasheniya;

    @ManyToOne(cascade = {CascadeType.ALL})
    @Nullable
    PrichinaObrasheniya prichinaObrasheniya;

    @Nullable
    Boolean priznakZayaviyelya;

    @Column(columnDefinition = "TEXT")
    @Nullable
    String svedObUchastnike;

    @ManyToOne(cascade = {CascadeType.ALL})
    @Nullable
    TypeUchastnik typeUchastnik;

    @ManyToOne(cascade = {CascadeType.ALL})
    @Nullable
    PersonalData personalData;

    @ManyToOne(cascade = {CascadeType.ALL})
    @Nullable
    TypeRodstva typeRodstva;

    @ManyToOne(cascade = {CascadeType.ALL})
    @Nullable
    PredstavitelData predstavitelData;

    @ManyToOne(cascade = {CascadeType.ALL})
    @Nullable
    TypePensiya typePensiya;

    @Nullable
    Boolean poluchalPensiyu;

    @ManyToOne(cascade = {CascadeType.ALL})
    @Nullable
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

    @ManyToOne(cascade = {CascadeType.ALL})
    @Nullable
    Staj staj;

    @Column(columnDefinition = "TEXT")
    @Nullable
    String infoAboutFamily;

    @Nullable
    String countOfIjdivenec;

    @ManyToOne(cascade = {CascadeType.ALL})
    @Nullable
    DocumentBrak documentBrakOld;

    @ManyToOne(cascade = {CascadeType.ALL})
    @Nullable
    DocumentBrak documentBrakNew;

    @ManyToOne(cascade = {CascadeType.ALL})
    @Nullable
    BankingRekvisits bankingRekvisits;

    @Column(columnDefinition = "TEXT")
    @Nullable
    String otherInfo;

    @Column(columnDefinition = "TEXT")
    @Nullable
    String dopInfo;

    //Пункт 17 смотреть
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
