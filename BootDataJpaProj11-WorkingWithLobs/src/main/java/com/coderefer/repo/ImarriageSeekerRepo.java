package com.coderefer.repo;

import com.coderefer.entity.MarriageSeeker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public class ImarriageSeekerRepo implements PagingAndSortingRepository<MarriageSeeker, Long> {
    @Override
    public Iterable<MarriageSeeker> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<MarriageSeeker> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends MarriageSeeker> S save(S entity) {
        return null;
    }

    @Override
    public <S extends MarriageSeeker> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<MarriageSeeker> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<MarriageSeeker> findAll() {
        return null;
    }

    @Override
    public Iterable<MarriageSeeker> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(MarriageSeeker entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends MarriageSeeker> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
