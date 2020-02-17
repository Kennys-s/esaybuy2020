package Student.cn.bdqn.dao.impl;

import Student.cn.bdqn.dao.BaseDao;
import Student.cn.bdqn.dao.GradeDao;
import Student.cn.bdqn.entity.Grade;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GradeDaoImpl extends BaseDao implements GradeDao {
    @Override
    public int count() {
        String sql="select count(*) from grade";
        String sql1="select * from grade where ?,?";
        ResultSet rss=getExecuteQuery(sql1);
        ResultSet rs=getExecuteQuery(sql);
        int num=0;
        try {
            if (rs.next()){
                num=rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public List<Grade> list(int index, int size) {
        List<Grade> list=new ArrayList<>();
        String sql="select * from grade limit ?,?";
        //index 当前页面下标  size是每一页要显示的条数
        //当size等于3时，每页显示三条数据
        //则 当index=1时， index-1=0 不需要偏移，则显示1-3条数据
        //当 index=2时， index-1=1 则 需要跳过前三条数据 显示4-6条 以此类推
        Object[] param={(index-1)*size,size};
        ResultSet rs=getExecuteQuery(sql,param);
        try {
            while (rs.next()){
                Grade g=new Grade();
                g.setGradeid(rs.getInt(1));
                g.setGradename(rs.getString(2));
                list.add(g);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
