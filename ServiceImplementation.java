package klef_jfsd_exam;

import java.util.Optional;

@ServiceImplementation
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer updateCustomer(Long id, String name, String address) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setName(name);
            customer.setAddress(address);
            return customerRepository.save(customer);
        }
        throw new RuntimeException("Customer not found");
    }
}