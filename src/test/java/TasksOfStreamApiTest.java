

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TasksOfStreamApiTest {

    TasksOfStreamApi tasksOfStreamApi;

    @BeforeTest
    public List<Student> init() {
        tasksOfStreamApi = new TasksOfStreamApi();

        Student vova = Student.builder()
                .name("Vova")
                .subjects(List.of(new Subject("maths", 3),
                        new Subject("rus", 4),
                        new Subject("geo", 2))).build();


        Student natasha = Student.builder()
                .name("Natasha")
                .subjects(List.of(
                        new Subject("maths", 5),
                        new Subject("rus", 4),
                        new Subject("geo", 4),
                        new Subject("arm", 2))).build();

        Student oleg = Student.builder()
                .name("Oleg")
                .subjects(List.of(
                        new Subject("maths", 5),
                        new Subject("chemistry", 3),
                        new Subject("physics", 3),
                        new Subject("music", 2))).build();

        List<Student>list = List.of(vova,natasha,oleg);

        return list;
    }

    @Test
    public void testAverageScore(){
        List<Student> list =init();

        //3+4+2+5+4+4+2+5+3+3+2=37/11->3.3->3

        final  int ok = 3;

        long averageScore = tasksOfStreamApi.getAverageScore(list);
        Assert.assertEquals(ok,averageScore);
    }

    @Test
    public void getBestName(){
        List<Student> list =init();

        String bestStudent = tasksOfStreamApi.getBestStudent(init());

        //vova 9/3->3.0
        //natasha->15/4->3.7->4.0
        //oleg->13/4->3.0
        Assert.assertEquals("Natasha",bestStudent);
    }

    @Test
    public void getDistinctSubjects(){
        List<Student> list =init();

        List<String> uniqueSubject = tasksOfStreamApi.getUniqueSubject(init());

        List<String> expected = List.of("maths","rus","geo","arm","chemistry","physics","music");
        Assert.assertEquals(uniqueSubject,expected);
    }

}