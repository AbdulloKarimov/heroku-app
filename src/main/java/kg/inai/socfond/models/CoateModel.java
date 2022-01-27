package kg.inai.socfond.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CoateModel {

    Integer ate;

    Integer ateType;

    Integer parentId;

    String name;
}
