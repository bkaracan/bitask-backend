package com.bia.bitask_backend.common;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResponse<T> {

    private List<T> content;
    private int totalElemeents;
    private int totalPages;
    private boolean isLast;
    private boolean isFirst;
}
