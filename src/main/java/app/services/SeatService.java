package app.services;

import app.entities.Aircraft;
import app.entities.Flight;
import app.entities.Seat;

import java.util.Optional;
import java.util.Set;




import java.util.List;
import java.util.Set;

public interface SeatService {
    Seat save(Aircraft aircraft, Integer counter);

    void update(Seat seat);

    void delete(Long id);

    Seat findByNumberOfSeats(Integer numberSeat);

    List<Seat> findAll();

    void change();
}
