package ru.megazlo.springtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.megazlo.springtest.dto.db.News;

/**
 * @author paradoxfm - 02.09.2015
 */
public interface NewsRepository extends JpaRepository<News, Long> {
}
