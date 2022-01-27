package kg.inai.socfond.entities;

import jdk.jfr.StackTrace;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Table
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SvedAboutStudyOfIjdivenec extends Audit<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Nullable
    String nameOfStudyPlace;

    @Nullable
    String addressOfStudyPlace;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateStartStudy;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateEndStudy;

    @Nullable
    String codeOfFormStudy;

    @Nullable
    String nameOfDocument;

    @Nullable
    String serie;

    @Nullable
    String number;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateVydachi;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateEnd;

    @Nullable
    String kemVydan;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateOtchisleniya;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateOfChangeFormStudy;

    @Nullable
    String nameOfDocumentOtchislenie;

    @Nullable
    String serieOtchislenie;

    @Nullable
    String numberOtchislenie;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateVydachiOtchislenie;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateEndOtchislenie;

    @Nullable
    String kemVydanOtchislenie;

}
