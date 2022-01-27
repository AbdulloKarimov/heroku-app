package kg.inai.socfond.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrudovayaDeyatelnost extends Audit<String> {

    @Id
    @GeneratedValue
    Long id;

    String code;

    String name;
}
