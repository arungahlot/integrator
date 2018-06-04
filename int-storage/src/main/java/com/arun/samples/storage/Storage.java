package com.arun.samples.storage;

import com.arun.samples.storage.api.StorageService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.InputStream;

@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private StorageService service;

    public boolean put(InputStream feedStream, FeedProvider feedProvider) {
        return service.put(feedStream,feedProvider);
    }
}
