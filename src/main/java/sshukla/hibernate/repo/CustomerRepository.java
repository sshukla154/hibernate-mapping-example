package sshukla.hibernate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sshukla.hibernate.onetomany.Customer;
import sshukla.hibernate.onetomany.OrderResponse;

import java.util.List;

/**
 * @author 'Seemant Shukla' on '28/09/2022'
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT new sshukla.hibernate.onetomany.OrderResponse(c.name, p.productName) FROM Customer c JOIN c.productList p")
    public List<OrderResponse> getJoinInformation();

}
