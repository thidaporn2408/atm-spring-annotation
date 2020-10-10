package th.ac.kmitl.atm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Bank {
    private String name; // attributes
    private Map<Integer, Customer> customers; // composition
    private DataSource dataSource;        // composition

    @Autowired
    public Bank(@Value("${bankname}") String name, DataSource dataSource) {
        this.name = name;
        this.dataSource = dataSource;
        this.customers = dataSource.readCustomers();
    }

    public void registerCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public Customer findCustomer(int id) {
        return customers.get(id);
    }

    public String getName() {
        return name;
    }
}
