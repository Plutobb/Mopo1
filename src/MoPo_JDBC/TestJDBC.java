package MoPo_JDBC;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC {
     private static void testInsert (String mysql) throws SQLException {
         //1.先创建一个datasource对象;
         DataSource dataSource = new MysqlDataSource();
         //2.设置datasource属性,为链接数据库做准备;
         ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/jdbc?characterEncoding=utf8&useSSL=true");
         ((MysqlDataSource)dataSource).setUser("root");
         ((MysqlDataSource)dataSource).setPassword("010108");
         //3.创建Connection对象,用来表示链接了一次数据库;
         Connection connection = (Connection) dataSource.getConnection();
         //4.拼装sql语句;
         String sql = mysql;
         // statement 用来辅助拼装 SQL 的, setXXX 的类型需要和数据库表的类型匹配.
         // ? 的下标从 1 开始计算
         PreparedStatement statement = connection.prepareStatement(sql);
//         statement.setInt(1,2);
//         statement.setString(2,"科比");
         System.out.println(statement);
         //5.执行sql;
         int ret = statement.executeUpdate();
         System.out.println(ret);
         statement.close();
         connection.close();
     }
     public static void testSelect() throws SQLException {
         //0.准备好库和表;
         //1.先创建一个datasource对象;
         DataSource dataSource = new MysqlDataSource();
         //2.设置datasource属性,为链接数据库做准备;
         ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/jdbc?characterEncoding=utf8&useSSL=true");
         ((MysqlDataSource)dataSource).setUser("root");
         ((MysqlDataSource)dataSource).setPassword("010108");
         //3.创建Connection对象,用来表示链接了一次数据库;
         Connection connection = (Connection) dataSource.getConnection();
         //4.建立sql语句;
         String sql = "select * from student";
         PreparedStatement statement = connection.prepareStatement(sql);
         //    resultSet 中就包含了查询结果
         ResultSet resultSet = statement.executeQuery();
         while (resultSet.next()){
             int id = resultSet.getInt("id");
             String name = resultSet.getString("name");
             System.out.println(id +"-"+ name);
         }
     }

    public static void main(String[] args) throws SQLException {
         //每执行一次就插入一次;
         //testInsert("insert into student values(3,\"欧文\")");
        testSelect();
    }
}
