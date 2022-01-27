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
public class SvedAboutIjdivenec extends Audit<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Nullable
    String fio;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateOfBirth;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    TypeRodstva typeRodstva;

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
    @ManyToOne(cascade = {CascadeType.ALL})
    Country codeOfCountry;

    @Nullable
    @Column(columnDefinition = "TEXT")
    String address;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    SvedAboutStudyOfIjdivenec svedAboutStudyOfIjdivenec;

}
