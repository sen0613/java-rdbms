package kr.re.kitri.northwind;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by danawacomputer on 2017-05-08.
 */
public class NorthwindMain {
    public static void main(String[] args) {

        // 1. postgreSQL 데이터베이스 JDBC 드라이버를 로딩한다.
        // (드라이버 이름 : "org.postgresql.Driver")

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("driver loading ok..");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 2. 데이터베이스와 연결을 수행한다. 즉, 커넥션 객체를 만든다.
        String dburl = "jdbc:postgresql://localhost:5432/test";
        String username = "아이디를 입력하세요. "; //postgres
        String password = "패스워드를 입력하세요. "; //****$$$$
        try {
            Connection conn =
                    DriverManager.getConnection(dburl, username, password);
            System.out.println("connection ok...");


        // 3. SQL문을 DB로 전달한다.
            String sql = "INSERT INTO public.sample(first_name, last_name, age) VALUES (?, ?, ?);";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "찬호");
            pstmt.setString(2, "박");
            pstmt.setInt(3, 40);

            pstmt.setString(1, "승아");
            pstmt.setString(2, "류");
            pstmt.setInt(3, 25);

            pstmt.setString(1, "준성");
            pstmt.setString(2, "임");
            pstmt.setInt(3, 20);

            pstmt.setString(1, "태준");
            pstmt.setString(2, "김");
            pstmt.setInt(3, 27);

            pstmt.setString(1, "세원");
            pstmt.setString(2, "김");
            pstmt.setInt(3, 27);

            pstmt.executeUpdate();
            System.out.println("insert ok..");
            conn.close();
            System.out.println("connectiont closed..");

    } catch(
    SQLException e)

    {
        e.printStackTrace();
    }


}
}
