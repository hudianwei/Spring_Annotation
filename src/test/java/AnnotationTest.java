import com.annotation.Person;
import com.annotation.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.naming.Name;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AnnotationTest {
    @Test
    public void testAnnotationIoc() {
        //1、启动 spring 容器
        //2、从 spring 容器中取出数据
        //3、通过对象调用方法
        /*
        *此外：下面三个注解是 @Component 注解的衍生注解，功能一样
@Repository ：dao层
@Service：service层
@Controller：web层
        * */
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) context.getBean("springuser");
        System.out.println(person.getId());
    }

    /*依赖注入注解 @Autowired　功能和注解 @Resource 一样，可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。
    只不过注解@Resource 是按照名称来进行装配，而@Autowired 则是按照类型来进行装配。
    * */
    @Resource(name = "student")
    public Student student;

    @Test
    public void test() {
        student.DiMethod();
    }

    @Autowired
    @Qualifier("student")
    public Student student1;

    @Test
    public void test1() {
        student.DiMethod();
    }
}
