package Student.cn.bdqn.util;

import Student.cn.bdqn.entity.Grade;

import java.util.List;

public class Page {
    //当前页码
    private int pageIndex=1;
    //每页显示的条数
    private int pageSize=3;
    //总条数
    private int totalCount;
    //总页数
    private int totalPageCount;
    //每页要显示的数据
    private List<Grade> list;
    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount>0){
            totalPageCount=(totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize)+1;
        }
        this.totalCount = totalCount;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public List<Grade> getList() {
        return list;
    }

    public void setList(List<Grade> list) {
        this.list = list;
    }
}
