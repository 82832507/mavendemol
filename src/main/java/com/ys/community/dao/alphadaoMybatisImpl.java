package com.ys.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class alphadaoMybatisImpl implements alphadao{
    @Override
    public String select() {
        return "Mybatis";
    }
}
