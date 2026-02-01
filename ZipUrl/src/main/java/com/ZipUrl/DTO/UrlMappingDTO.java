package com.ZipUrl.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UrlMappingDTO {
    private Long id;
    private String url;
    private String originalUrl;
    private String shortUrl;
    private int clickcount;
    private LocalDateTime createdDate;
    private String username;
}
