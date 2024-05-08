package com.kupi.delegations.rest.api.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * pageable response DTO used for having correct API description definition.
 *
 * @param <T> page content type
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class PagedResponse<T> {

    @NotNull
    protected List<T> content;

    protected int number;

    protected int size;

    protected boolean empty;

    protected boolean first;

    protected boolean last;

    protected int numberOfElements;

    protected long totalElements;

    protected int totalPages;

    public static <T> PagedResponse<T> fromPage(Page<T> page) {
        return new PagedResponse<>(
                page.getContent(),
                page.getNumber(),
                page.getSize(),
                page.isEmpty(),
                page.isFirst(),
                page.isLast(),
                page.getNumberOfElements(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }
}