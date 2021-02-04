package com.example.dao;

import com.example.entity.Emp;
import com.example.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpDao {

    public Integer save(Emp emp);
    public Integer delete(Emp emp);
    public Integer update(Emp emp);
    public Emp selectByNo(Integer empno);
    public Map<Object,Object> selectByNoReturnMap(Integer empno);
    public List<Emp> selectAll();
    @MapKey("ename")
    public Map<String,Emp> selectAll2();
    public List<Emp> selByNoAndSal(Emp emp);
    public List<Emp> selByNoAndSal2(@Param("empno") Integer empno,@Param("sal") Double sal);
    public List<Emp> selByNoAndSal3(Map<String,Object> map);

}
