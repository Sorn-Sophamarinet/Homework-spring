package kh.edu.istasd.fswdapi;
import kh.edu.istasd.fswdapi.domain.Customer;
import kh.edu.istasd.fswdapi.domain.KYC;
import kh.edu.istasd.fswdapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class MobileBankingApi implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MobileBankingApi.class, args);
    }

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

        KYC kyc = new KYC();
        Customer customer = new Customer();

        kyc.setNationalCardId("99991111");
        kyc.setIsVerified(false);
        kyc.setIsDeleted(false);
        kyc.setCustomer(customer);

        customer.setFullName("Sorn Sophamarinet");
        customer.setGender("F");
        customer.setEmail("net@gmail.com");
        customer.setPhoneNumber("099787115");
        customer.setKyc(kyc);
        customer.setRemark("Admin");
        customer.setIsDeleted(false);

        customerRepository.save(customer);
    }
}