package za.co.labournet.tax;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource
public interface RebateRepository extends JpaRepository<TaxRebate,Long>
{

}
