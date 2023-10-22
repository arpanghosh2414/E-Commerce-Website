package com.company.demo.generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

@SuppressWarnings("deprecation")
public class CartIdGenerator  implements IdentifierGenerator, Configurable {

    private static Long ID = 1L;

    private String getCartId() {
        final String cartId = "BWCART1760" + ID++;
        return cartId;
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return this.getCartId();
    }
}
