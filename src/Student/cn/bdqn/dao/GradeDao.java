package Student.cn.bdqn.dao;
import Student.cn.bdqn.entity.Grade;
import java.util.List;

public interface GradeDao {
    int count();//记录查询有多少条数据
    List<Grade> list(int index, int size);//index ,当前页面下标  size 当前页面中可以放多少条数据
}
