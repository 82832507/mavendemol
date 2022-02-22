package com.ys.community.dao;

import org.springframework.stereotype.Repository;

@Repository("alphahibernate")
public class alphodaoHibernateImpl implements alphadao{
    @Override
    public String select() {
        return "Hibernate";
    }
}
