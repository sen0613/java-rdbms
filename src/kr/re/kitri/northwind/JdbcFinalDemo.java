package kr.re.kitri.northwind;

import kr.re.kitri.northwind.model.Customer;
import kr.re.kitri.northwind.service.JdbcService;

import java.util.List;

/**
 * Created by danawacomputer on 2017-05-10.
 */
public class JdbcFinalDemo {

    public static final String DRIVER_POSTGRES = "org.postgresql.Driver";
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/northwind";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "swsw1225";

    public static void main(String[] args) {

        loadDriver(DRIVER_POSTGRES);
        JdbcService service = new JdbcService();
        List<Customer> list2 = service.makeList(DB_URL, USERNAME, PASSWORD);

        for(Customer e: list2) {
            System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n", e.getCustomerid(), e.getCompanyname(),
                    e.getContactname(), e.getAddress(),e.getCity(), e.getPhone());
        }
    }

    private static void loadDriver (String driverPostgres) {
        try {
            Class.forName(DRIVER_POSTGRES);
            System.out.println("driver loading ok..");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
