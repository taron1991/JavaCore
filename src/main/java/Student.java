import lombok.*;

import java.util.List;

/**
* класс Студент с предметами
**/
@Data
@Builder
@AllArgsConstructor
public class Student {
    private String name;

    List<Subject> subjects;

}
