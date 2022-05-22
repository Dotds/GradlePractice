import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        try {
            //1/注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2定义SQL
            String sql = "insert into learn.user values(4,'4','老王','777','4','2')";
            //3.获取Connection对象Statement
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Lyx99819");
            //4.获取SQL执行的对象
            stmt = conn.createStatement();
            //5.执行sql
            int count = stmt.executeUpdate(sql);
            //6.输出结果
            System.out.println(count);
            if (count>0){
                System.out.println("true");
            }else {
                System.out.println("false");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //7/释放资源
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
