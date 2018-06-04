package com.arun.samples.storage;

import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.StorageOptions;
import com.google.common.net.MediaType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class StorageTest {
    private Storage storage;

    @Before
    public void setUp() throws Exception {
        storage = new Storage();
    }

    @Test
    public void TestCreateFolder() {
        assertThat(storage, notNullValue());
        storage.createFolder("TestFolder");
    }

    @Test
    public void TestLogin() throws IOException {
        InputStream credentialFile = getResourceAsStream("myProject-c1ce310fc65e.json");
        final GoogleCredentials googleCredentials = GoogleCredentials.fromStream(credentialFile);
        final com.google.cloud.storage.Storage storage = StorageOptions.newBuilder().setCredentials(googleCredentials)
                .setProjectId("myproject-c9cc6")
                .build().getService();
        final Page<Bucket> list = storage.list();

        com.google.cloud.storage.Storage.BucketGetOption options = com.google.cloud.storage.Storage.BucketGetOption.fields();
        final Bucket bucket = storage.get("myproject-c9cc6.appspot.com", options);
        final Blob chrysanthemum = bucket.create("Chrysanthemum", getResourceAsStream("flowers/Chrysanthemum.jpg"), MediaType.JPEG.toString());
        assertThat(chrysanthemum, notNullValue());


    }

    private InputStream getResourceAsStream(String fileName) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
    }
}