package kr.re.kitri.northwind;

import kr.re.kitri.northwind.model.Customer;
import kr.re.kitri.northwind.service.JdbcService;
import kr.re.kitri.northwind.util.PostgresConstants;

import javax.annotation.PostConstruct;
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

        loadDriver(PostgresConstants.DRIVER_POSTGRES);

        JdbcService service = new JdbcService();
        List<Customer> list = service.makeList();

        if (list.size() > 0) {
            list.forEach(System.out::println);
        } else {
            System.out.println("데이터가 없습니다.");
        }
    }

    private static void loadDriver(String driverPostgres) {
        try {
            Class.forName(driverPostgres);
            System.out.println("driver ok..");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
