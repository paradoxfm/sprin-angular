package ru.megazlo.springtest.dto.db;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

/**
 * @author paradoxfm - 02.09.2015
 */
@Entity
public class News extends AbstractPersistable<Long> {
}
