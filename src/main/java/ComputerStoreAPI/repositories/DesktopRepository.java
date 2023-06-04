package ComputerStoreAPI.repositories;

import ComputerStoreAPI.model.Desktop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesktopRepository extends JpaRepository<Desktop, Long> {
}
