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
public class SvedAboutBrakChangeNameOrSurname extends Audit<String>{

    @Id
    @GeneratedValue
    Long id;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    TypeUchastnik typeUchastnik;

    @Nullable
    String fioOld;

    @Nullable
    String reasonOfChange;

    @Nullable
    String priznakRastorjeniyaBraka;

    @Nullable
    String nameOfDocumentOldBrak;

    @Nullable
    String serieOldBrak;

    @Nullable
    String numberOldBrak;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateVydachiOld;

    @Nullable
    String kemVydanOldBrak;

    @Nullable
    String priznakNewBrak;

    @Nullable
    String nameOfDocumentNewBrak;

    @Nullable
    String serieNewBrak;

    @Nullable
    String numberNewBrak;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateVydachiNew;

    @Nullable
    String kemVydanNewBrak;

    @Nullable
    @Column(columnDefinition = "TEXT")
    String anotherReasonOfChangeSurname;

    @Nullable
    String nameOfDocumentChangeSurname;

    @Nullable
    String serieFioChange;

    @Nullable
    String numberFioChange;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateVydachiFioChange;

    @Nullable
    String kemVydanFioChange;

}
