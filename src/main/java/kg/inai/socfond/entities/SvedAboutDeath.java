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
public class SvedAboutDeath extends Audit<String> {

    @Id
    @GeneratedValue
    Long id;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    TypeUchastnik typeUchastnik;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateDeath;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    Country grajdanstvo;

    @Nullable
    @Enumerated(EnumType.STRING)
    Sex sex;

    @Nullable
    String identityNumber;

    @Nullable
    String nameDocumentDeath;

    @Nullable
    String serieAndNumberDocumentDeath;

    @Nullable
    String organVydavshiyDeath;
}
