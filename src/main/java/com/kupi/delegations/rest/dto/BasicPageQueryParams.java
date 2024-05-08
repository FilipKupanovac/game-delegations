package com.kupi.delegations.rest.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

@Setter
@Getter
@EqualsAndHashCode
@ToString
public class BasicPageQueryParams {

    @NotNull
    @QueryParam("page")
    @DefaultValue("0")
    protected Integer page;

    @NotNull
    @QueryParam("size")
    @DefaultValue("20")
    @Max(100)
    protected Integer size;

    /**
     * Column that should be sorted.
     */
    @NotNull
    @QueryParam("column")
    @DefaultValue("createdAt")
    protected String column;

    /**
     * Sorting direction for the given column. Allowed values are 'asc', 'desc'.
     */
    @NotNull
    @QueryParam("direction")
    @DefaultValue("DESC")
    protected String direction;

    protected BasicPageQueryParams() {
    }

    protected BasicPageQueryParams(Integer page, Integer size, @Nullable String column, @Nullable String direction) {
        super();
        this.page = page;
        this.size = size;
        this.column = column;
        this.direction = direction;
    }
}