package app.repositories;

import app.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository <Passenger, Long>{
    Passenger findPassengerById (Long id);

}

