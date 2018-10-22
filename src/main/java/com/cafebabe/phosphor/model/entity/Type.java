package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;

/**
 * type
 * @author 
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Type implements Serializable {
    /**
     * 类型ID
     */
    private Integer typeId;

    /**
     * 类型名称
     */
    private String typeName;


}