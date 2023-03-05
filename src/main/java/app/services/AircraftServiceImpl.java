package app.services;

import app.entities.Aircraft;
import app.repositories.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AircraftServiceImpl implements AircraftService {

    private final AircraftRepository aircraftRepository;

    private final SeatService seatServiceTest;

    public AircraftServiceImpl(AircraftRepository aircraftRepository, SeatService seatServiceTest) {
        this.aircraftRepository = aircraftRepository;
        this.seatServiceTest = seatServiceTest;
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void save(Aircraft aircraft) {
        int counter = 1;
        while (counter <= aircraft.getNUMBER_OF_SEATS()) {
            seatServiceTest.save(aircraft, counter);
            counter++;
        }
        aircraftRepository.save(aircraft);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void update(Aircraft aircraft) {
        if (aircraftRepository.existsById(aircraft.getId())) {
            save(aircraft);
        }
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void delete(Long id) {
        aircraftRepository.deleteById(id);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Aircraft findById(Long id) {
        return aircraftRepository.getById(id);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Aircraft> findAll() {
        return aircraftRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Aircraft findByBoardNumber(String boardNumber) {
        return aircraftRepository.findByBoardNumber(boardNumber);
    }
}
