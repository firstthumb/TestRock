package net.javaci.testrock.core.dao;

import net.javaci.testrock.core.model.DomainObject;
import org.hibernate.criterion.Criterion;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: ekocaman
 * Date: 12/11/12
 */
public interface Dao<T extends DomainObject> {

    @Transactional(readOnly=true)
    T load(long id);

    @Transactional(readOnly=true)
    List<T> findAll();

    @Transactional(readOnly=true)
    T getCriteriaUnique(Criterion logicalExpression);

    @Transactional
    T save(T o);

    @Transactional
    void delete(T o);
}

