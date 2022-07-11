import lombok.*;

/**
*Класс предмет с оценкой
**/
@Data
@Builder
@AllArgsConstructor
public class Subject {
    private String name;

    private int score;

}
