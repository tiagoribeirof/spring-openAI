package com.hackaton.team.hackazillians.dto;

import com.hackaton.team.hackazillians.entities.Priority;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link Priority}
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriorityDto implements Serializable {
    int id;
    String nivel;
}