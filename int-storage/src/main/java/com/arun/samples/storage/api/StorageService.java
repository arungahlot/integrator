package com.arun.samples.storage.api;

import com.arun.samples.storage.FeedProvider;

import java.io.InputStream;

public interface StorageService {
    boolean put(InputStream feedStream, FeedProvider feedProvider);
}
