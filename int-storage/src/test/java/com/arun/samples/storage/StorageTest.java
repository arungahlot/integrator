package com.arun.samples.storage;

import com.arun.samples.storage.api.StorageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.InputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StorageTest {
    @Mock
    private StorageService storageService;
    @InjectMocks
    private Storage storage;

    @Test
    public void TestCreateFolder() {
        assertThat(storage, notNullValue());
        when(storageService.put(any(InputStream.class), any(FeedProvider.class))).thenReturn(Boolean.TRUE);
        InputStream feedStream = getResourceAsStream("sample.csv");
        FeedProvider feedProvider = new FeedProvider("myInsuranceProvider", "csv", "http://samplecsvs.s3.amazonaws.com/Sacramentorealestatetransactions.csv");
        assertThat(storage.put(feedStream, feedProvider), is(true));
    }

    private InputStream getResourceAsStream(String fileName) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
    }
}