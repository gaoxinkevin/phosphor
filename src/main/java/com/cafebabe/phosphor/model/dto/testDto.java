package com.cafebabe.phosphor.model.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class testDto{

    private String image;
    private MultipartFile file;
}
