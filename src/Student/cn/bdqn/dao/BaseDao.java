package Student.cn.bdqn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 工具类(添加 删除 修改 查询)
 */
public class BaseDao {
    private String driver="com.mysql.jdbc.Driver";  //驱动
    private String url = "jdbc:mysql://localhost:3306/myschool";
    private String userName="root";//账户名
    private String pwd="1234";//密码
    Connection conn = null;//连接
    PreparedStatement pstmt = null;//执行对象
    ResultSet rs = null;//结果集

    /**
     * 建立连接
     * @return
     */
    public Connection getConnection(){
        try{
            //1.加载驱动
            Class.forName(driver);
            //2.连接
            conn= DriverManager.getConnection(url,userName,pwd);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 查询
     * @param sql       需要你执行的SQL语句
     * @param param     ？的参数 (可有可无)
     * @return          返回结果集(rs)
     */
    public ResultSet getExecuteQuery(String sql,Object...param){
        try{//1.驱动  2.连接
            conn=getConnection();//连接成功
            //3.创建执行对象
            pstmt=conn.prepareStatement(sql);
            //如果有？你的param就不会为空
            if (param!=null && param.length>0){
                for(int i=0;i<param.length;i++){
                    //给SQL语句中的？占位符设置值
                    pstmt.setObject((i+1),param[i]);
                }
            }
            //返回执行对象
            rs = pstmt.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 删除 修改 添加
     * @param sql
     * @param param
     * @return 返回受影响的行数
     */
    public int getExecuteUpdate(String sql,Object...param){
        try{
            conn=getConnection();//创建连接
            //创建执行对象
            pstmt = conn.prepareStatement(sql);
            //给？设置参数
            if (param != null && param.length>0){
                for (int i=0;i<param.length;i++){
                    pstmt.setObject((i+1),param[i]);
                }
            }
            //返回结果
            return pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            //关闭
        }
        return  -1;
    }

    /**
     * 关闭所有
     */
    public void closeAll(){
        try{
            if (rs!=null){
                rs.close();
            }
            if (pstmt!=null){
                pstmt.close();
            }
            if (conn!=null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
