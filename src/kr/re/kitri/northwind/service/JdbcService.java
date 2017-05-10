package kr.re.kitri.northwind.service;

import kr.re.kitri.northwind.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danawacomputer on 2017-05-10.
 */
public class JdbcService {

    public List<Customer> makeList(String url, String name, String password) {
        List<Customer> list = new ArrayList<>();
        String query =
                "select customerid, " +
                        "       companyname, " +
                        "       contactname, " +
                        "       address, " +
                        "       city, " +
                        "       phone " +
                        "from customers " +
                        "order by contactname";
        try {
            Connection conn =
                    DriverManager.getConnection(url, name, password);

            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Customer ct = new Customer(
                        rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(ct);
            }

            conn.close();
            System.out.println("connection closed..");

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }
}