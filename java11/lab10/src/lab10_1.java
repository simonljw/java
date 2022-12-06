
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class lab10_1 {
    private static Connection con;// 连接对象

    public static Connection getConnection() {
        String drivername = "com.mysql.cj.jdbc.Driver";
        // 数据库URL
        String url = "jdbc:mysql://localhost:3306/java2022?serverTimezone=UTC";
        String userName = "root";// 登录数据库用户名
        String password = "123456";// 用户密码

        try {
            // 加载MySQL驱动程序
            Class.forName(drivername);
            con = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public void getStudent( String sql) {// 查询学生相关信息
        try {
            con=getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("学号" + "\t姓名" + "\t系别" + "\t教学班" + "\t平均成绩");
            while (rs.next()) {
                String num = rs.getString("num");
                String name = rs.getString("name");
                String department = rs.getString("department");
                String tclass = rs.getString("tclass");
                double average = rs.getDouble("average");

                System.out.println(
                        num + "\t" + name + "\t" + department + "\t" + tclass + "\t" + average + "\t");
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getRowCount( String sql) {// 查询符合条件的记录数
        try {
            con=getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                System.out.println("符合条件的记录数有:" + rs.getInt(1) + "条");
            }

            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        lab10_1 myjdbc = new   lab10_1();
        String sql1 = "SELECT * from java2022 where tclass='ccd' ";

        String sql2 = "SELECT count(*) from java2022 where tclass='ccd'";
        myjdbc.getStudent(sql1);// 查询符合条件的学生
        myjdbc.getRowCount(sql2);// 统计符合条件的记录数
    }
}