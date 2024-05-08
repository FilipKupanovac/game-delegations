package com.kupi.delegations.rest.api.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseVenue {
    private String name;
    private String address;
    private Double latitude;
    private Double longitude;
}
