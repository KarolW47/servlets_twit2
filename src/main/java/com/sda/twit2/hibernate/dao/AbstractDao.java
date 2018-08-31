package com.sda.twit2.hibernate.dao;

import com.sda.twit2.hibernate.config.HibernateUtils;
import com.sda.twit2.hibernate.entity.BaseEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public abstract class AbstractDao<T extends BaseEntity> {

    protected abstract Class<T> getClazz();

    public void add(final T entity) {
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public T get(final Long id) {
        Session session = HibernateUtils.getSession();
        T entity = session.get(getClazz(), id);
        return entity;
    }

    public List<T> getAll() {
        Session session = HibernateUtils.getSession();
        List<T> entities = session.createQuery("FROM " + getClazz().getSimpleName()).list();
        return entities;
    }

    public boolean remove(final T entity) {
        if (entity == null) {
            return false;
        }
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            session.remove(entity);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(final T entity) {
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}
