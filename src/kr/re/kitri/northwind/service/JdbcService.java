package kr.re.kitri.northwind.service;

import kr.re.kitri.northwind.model.Customer;
import kr.re.kitri.northwind.util.PostgresConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danawacomputer on 2017-05-10.
 */
public class JdbcService {

    public final String QUERY =
            "select customerid, " +
                    "       companyname, " +
                    "       contactname, " +
                    "       address, " +
                    "       city, " +
                    "       phone " +
                    "from customers " +
                    "order by contactname";

    public List<Customer> makeList() {
        List<Customer> list = new ArrayList<>();

        Connection conn = this.getConnection();
        if (conn != null) {

            try {
                PreparedStatement pstmt = conn.prepareStatement(QUERY);
                ResultSet rs = pstmt.executeQuery();

                populateCustomer(rs, list);

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private void populateCustomer(ResultSet rs, List<Customer> list) throws SQLException {

        Customer cust;
        while (rs.next()) {
            cust = new Customer();
            cust.setCustomerid(rs.getString(1));
            cust.setCompanyname(rs.getString(2));
            cust.setContactname(rs.getString(3));
            cust.setAddress(rs.getString(4));
            cust.setCity(rs.getString(5));
            cust.setPhone(rs.getString(6));

            list.add(cust);

        }

    }
    private Connection getConnection(){

        try {
            Connection conn =
                    DriverManager.getConnection(
                            PostgresConstants.DB_URL,
                            PostgresConstants.USERNAME,
                            PostgresConstants.PASSWORD
                    );
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
}