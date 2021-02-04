import com.example.dao.EmpDao;
import com.example.dao.UserDao;
import com.example.entity.Emp;
import com.example.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    SqlSessionFactory sqlSessionFactory=null;

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
    public void selectByNo(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Emp emp = mapper.selectByNo(7369);
        System.out.println(emp);
        sqlSession.close();
    }

    @Test
    public void save(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Emp emp = new Emp();
        emp.setEmpno(3333);
        emp.setEname("zhangsan");
        Integer save = mapper.save(emp);
        System.out.println(save);
        sqlSession.close();
    }
    @Test
    public void update(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Emp emp = new Emp();
        emp.setEmpno(3333);
        emp.setEname("zhangsan");
        emp.setSal(3500.0);
        Integer update = mapper.update(emp);
        System.out.println(update);
        sqlSession.close();
    }
    @Test
    public void delete(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Emp emp = new Emp();
        emp.setEmpno(3333);
        mapper.delete(emp);
        sqlSession.close();
    }

    @Test
    public void selById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.selById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void saveuser(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setUserName("wangyao");
        mapper.saveUser(user);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void selectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        mapper.selectAll();
        sqlSession.close();
    }

    @Test
    public void selByNoAndSal(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Emp emp = new Emp ();
        emp.setEmpno(7369);
        emp.setSal(500.0);
        List<Emp> emps = mapper.selByNoAndSal(emp);
        for (Emp emp1 : emps) {
            System.out.println(emp1);
        }
        sqlSession.close();
    }

    @Test
    public void selByNoAndSal2(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Emp emp = new Emp ();
        emp.setEmpno(7369);
        emp.setSal(500.0);
        List<Emp> emps = mapper.selByNoAndSal2(7369,500.0);
        for (Emp emp1 : emps) {
            System.out.println(emp1);
        }
        sqlSession.close();
    }

    @Test
    public void selByNoAndSal3(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("empno",7369);
        map.put("sal",500.0);
        List<Emp> emps = mapper.selByNoAndSal3(map);
        for (Emp emp1 : emps) {
            System.out.println(emp1);
        }
        sqlSession.close();
    }

    @Test
    public void selectByNoReturnMap (){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Map<Object, Object> objectObjectMap = mapper.selectByNoReturnMap(7369);
        System.out.println(objectObjectMap);
        sqlSession.close();
    }

    @Test
    public void selectAll2 (){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Map<String, Emp> stringEmpMap = mapper.selectAll2();
        System.out.println(stringEmpMap);
        sqlSession.close();
    }

}
