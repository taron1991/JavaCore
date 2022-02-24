import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

public class TasksOfStreamApi {

    private static final String EMPTY = "";
    private static final long INCORRECT_RESULT = -1;

    /**
     * Метод вычисляет общий средний балл по всем студентам и их предметам и округляет данный бал до ближайшего целого
     *
     * @param students - студенты
     * @return средний балл по всем предметам у студентов
     */
    public long getAverageScore(List<Student> students) {
        Double average = students
                .stream()
                .flatMap(x -> x.subjects.stream())
                .mapToLong(x -> x.getScore())
                .summaryStatistics()
                .getAverage();

        double average1 = average;
        double ceil = Math.round(average1);
        long lo = (long) ceil;
        return lo;
    }

    /**
     * Метод находит имя лучшего ученика. Лучший ученик тот, у кого средний балл по его предметам наибольший.
     *
     * @param students студенты
     * @return имя лучшего ученика
     */

    public String getBestStudent(List<Student> students) {
        List<String> stringList = new ArrayList<>();
        String sup = " ";
        double grade = 0;
        for (int i = 0; i < students.size(); i++) {
            double average = students.get(i).getSubjects().stream().mapToInt(x -> x.getScore()).summaryStatistics().getAverage();
            if (average > grade) {
                grade = average;
                stringList.add(students.get(i).getName());
            }
        }

        for (int i = 0; i < stringList.size(); i++) {
            sup = stringList.get(stringList.size() - 1);
        }

        return sup;

    }


    /**
     * Вывести уникальное количество предметов
     *
     * @param students студенты
     * @return их предметы
     */
    public List<String> getUniqueSubject(List<Student> students) {
        return students
                .stream()
                .flatMap(x -> x.getSubjects().stream())
                .map(Subject::getName)
                .distinct()
                .collect(Collectors.toList());
    }
}



