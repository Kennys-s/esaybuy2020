package Student.cn.bdqn.service;

import Student.cn.bdqn.entity.Grade;

import java.util.List;

public interface GradeService {
    int count();
    List<Grade> list(int index,int size);
}
