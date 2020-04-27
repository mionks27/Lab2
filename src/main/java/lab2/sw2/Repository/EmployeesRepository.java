package lab2.sw2.Repository;

import lab2.sw2.Entity.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeesEntity,String> {
}
