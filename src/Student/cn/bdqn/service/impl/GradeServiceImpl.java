package Student.cn.bdqn.service.impl;

import Student.cn.bdqn.dao.GradeDao;
import Student.cn.bdqn.dao.impl.GradeDaoImpl;
import Student.cn.bdqn.entity.Grade;
import Student.cn.bdqn.service.GradeService;

import java.util.List;

public class GradeServiceImpl implements GradeService {
    GradeDao dao=new GradeDaoImpl();
    @Override
    public int count() {
        return dao.count();
    }

    @Override
    public List<Grade> list(int index, int size) {
        return dao.list(index,size);
    }
}
