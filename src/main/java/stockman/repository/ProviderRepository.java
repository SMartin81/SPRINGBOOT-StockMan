package stockman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import stockman.modele.Provider;
import java.util.List;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long>, JpaSpecificationExecutor<Provider>{
	
	  @Query("SELECT p FROM Provider p WHERE p.supplyList IS NOT EMPTY")
	  List<Provider> findNotEmptyProviders();
}
