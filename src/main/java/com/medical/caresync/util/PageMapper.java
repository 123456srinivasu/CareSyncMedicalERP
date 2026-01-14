package com.medical.caresync.util;

import com.medical.caresync.dto.PageResponse;
import org.springframework.data.domain.Page;

import java.util.function.Function;

public class PageMapper {

    public static <T, R> PageResponse<R> mapToPageResponse(Page<T> page, Function<T, R> mapper) {

        PageResponse<R> response = new PageResponse<>();
        response.setContent(page.getContent().stream().map(mapper).toList());
        response.setPage(page.getNumber());
        response.setSize(page.getSize());
        response.setTotalElements(page.getTotalElements());
        response.setTotalPages(page.getTotalPages());
        response.setLast(page.isLast());

        return response;
    }
}
