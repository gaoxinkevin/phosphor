package com.cafebabe.phosphor.util.GroupPrice;

import com.cafebabe.phosphor.model.entity.Group;

import java.math.BigDecimal;

public interface Price {
    BigDecimal getPrice(Group group);
}
