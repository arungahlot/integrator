package com.arun.samples.storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedProvider {
    private String provider;
    private String dataType;
    private String source;
}
