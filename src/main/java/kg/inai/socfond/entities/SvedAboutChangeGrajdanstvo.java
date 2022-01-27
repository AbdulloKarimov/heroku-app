package kg.inai.socfond.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Table
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SvedAboutChangeGrajdanstvo extends Audit<String> {

    @Id
    @GeneratedValue
    Long id;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    TypeUchastnik typeUchastnik;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    Country countryOld;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    Country countryNew;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateOfChangeGrajdanstvo;

    @Nullable
    String nameOfDocumentChangeGrajdanstvo;

    @Nullable
    String serie;

    @Nullable
    String number;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateVydachi;

    @Nullable
    String kemVydan;
}
