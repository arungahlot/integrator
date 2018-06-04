package com.arun.samples.storage;

import com.arun.samples.storage.api.StorageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.InputStream;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class StorageTest {
    private StorageService storageService;
    @InjectMocks
    private Storage storage;

    @Test
    public void TestCreateFolder() {
        assertThat(storage, notNullValue());

    }

    private InputStream getResourceAsStream(String fileName) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
    }
}