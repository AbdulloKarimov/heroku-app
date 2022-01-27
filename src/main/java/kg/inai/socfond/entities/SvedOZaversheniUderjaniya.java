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
public class SvedOZaversheniUderjaniya extends Audit<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateResheniya;

    @Nullable
    String numberResheniya;

    @Nullable
    String uderjannayaSumma;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    Currency valuta;

    @Nullable
    Boolean uderjanPensiya;

    @Nullable
    String ostatok;

    @Nullable
    @ManyToOne
    Currency codeValuta;

    @Nullable
    @Column(columnDefinition = "TEXT")
    String prichinaPrekrasheniya;

}
