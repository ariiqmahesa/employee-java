package com.example.employees.service;
import com.example.employees.repository.PositionRepository;
import org.springframework.stereotype.Service;
import com.example.employees.model.Position;
import java.util.List;
import java.util.Optional;

@Service
public class PositionService {
    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    public Optional<Position> findById(Long id) {
        return positionRepository.findById(id);
    }

    public Optional<Position> deleteById(Long id) {
        positionRepository.deleteById(id);
        return Optional.empty();
    }

    public Position save(Position position) {
        return positionRepository.save(position);
    }
}
