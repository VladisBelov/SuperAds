package superads.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import superads.entities.Advertisment;
import superads.entities.User;

@Repository
public interface AdvertismentRepository extends CrudRepository<Advertisment, Long> {

}
