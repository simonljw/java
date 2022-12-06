package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lab10_2 {
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

    public void upDateAutomima() {// 更新学生密码
        try {
            con=getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from java2022");
            int n;
            int count=0;
            while (rs.next()) {
                String num = rs.getString("num");
                String pwd=num.substring(3);
                String sql="update java2022 set pwd="+pwd+" where num="+num;
                Statement st1 = con.createStatement();
                n=st1.executeUpdate(sql);
                if(n>0)
                    count+=n;
                st1.close();
            }
            System.out.println("修改操作，受到影响的记录数有："+count+"条");
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Insertsql(String sql) {// 更新学生相关信息
        try {
            con=getConnection();
            Statement st = con.createStatement();
            int n = st.executeUpdate(sql);
            System.out.println("修改操作，受到影响的记录数有："+n+"条");
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Deletesql(String sql) {// 更新学生相关信息
        try {
            con=getConnection();
            Statement st = con.createStatement();
            int n = st.executeUpdate(sql);
            System.out.println("修改操作，受到影响的记录数有："+n+"条");            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getStudent( String sql) {// 查询学生相关信息
        try {
            con=getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("学号" + "\t姓名" + "\t系别" + "\t教学班" + "\t平均成绩"+"\t密码"+"\t手机号"+"\t电子邮箱");
            while (rs.next()) {
                String num = rs.getString("num");
                String name = rs.getString("name");
                String department = rs.getString("department");
                String tclass = rs.getString("tclass");
                double average = rs.getDouble("average");
                String pwd = rs.getString("pwd");
                String mobile = rs.getString("mobile");
                String email = rs.getString("email");

                System.out.println(
                        num + "\t" + name + "\t" + department + "\t" + tclass + "\t" + average + "\t"
                                +pwd+"\t" +mobile+"\t" +email);
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
            } else {
                System.out.println("没有符合条件的记录");
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Lab10_2 myjdbc = new Lab10_2();

        myjdbc.Insertsql("insert into java2022(num,name,department,tclass,average) values('2140708888','张三','中文系','CCA',78.5),('2140709999','李四','中文系','CCB',83.0)");
        myjdbc.getStudent("select * from java2022 where name ='张三' or name='李四'");
        myjdbc.getRowCount("select count(*) from java2022 where name ='张三' or name='李四'");
        myjdbc.upDateAutomima();
        myjdbc.getStudent("select * from java2022 where name ='张三' or name='李四'");
        myjdbc.getRowCount("select count(*) from java2022 where name ='张三' or name='李四'");
        myjdbc.Deletesql("delete from java2022 where name='张三' or name='李四'");
        myjdbc.getStudent("select * from java2022 where tclass='中文系'");
        myjdbc.getRowCount("select count(*) from java2022 where tclass='中文系'");
    }
}
