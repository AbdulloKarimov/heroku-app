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
public class PersonalDocument extends Audit<String> {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    Country country;

    @ManyToOne(cascade = {CascadeType.ALL})
    TypeDocument typeDocument;

    String serie;

    String numberDocument;

    String organVydavshiyDocument;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateVydachiDocument;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateOkonchaniyaDocument;

}
