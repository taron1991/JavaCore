import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Student {
    private String name;

    List<Subject> subjects;

}