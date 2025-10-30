package me.zdcoder.hastebin.core.repositories;

import me.zdcoder.hastebin.core.models.RecordModel;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface RecordRepository extends CrudRepository<RecordModel, Long> {

    Optional<RecordModel> findByHash(String hash);

    boolean existsByHash(String hash);

    void deleteAllByExpiryDateBefore(LocalDateTime time);
}
