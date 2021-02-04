import com.example.dao.DogDao;
import com.example.entity.Dog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class DogMain {

     SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void init()  {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void selectDogById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DogDao mapper = sqlSession.getMapper(DogDao.class);
        Dog dog = mapper.selectDogById(2);
        System.out.println(dog);
        sqlSession.close();
    }
}
