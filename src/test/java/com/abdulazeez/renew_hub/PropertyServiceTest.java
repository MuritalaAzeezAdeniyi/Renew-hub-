package com.abdulazeez.renew_hub;

import com.abdulazeez.renew_hub.dto.request.UploadPropertyRequest;
import com.abdulazeez.renew_hub.model.Property;
import com.abdulazeez.renew_hub.service.PropertyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PropertyServiceTest {
    @Autowired
    private PropertyService propertyService;

    @Test
    public void testThatCanUploadProperty(){
        String username = "abdul";
        UploadPropertyRequest uploadPropertyRequest = new UploadPropertyRequest();
        Path path = Paths.get("C:\\Users\\DELL\\Downloads\\Rectangle 4315.png");
        try(InputStream inputStream = new FileInputStream(path.toFile())){
            MultipartFile file = new MockMultipartFile("file", path.getFileName().toString(), "image/png", inputStream);
            uploadPropertyRequest.setTitle("My Picture");
            uploadPropertyRequest.setDescription("My Description");
            uploadPropertyRequest.setPrice("345");
            uploadPropertyRequest.setLocation("Abuja");
            uploadPropertyRequest.setImageUrl(file);

            Property property = propertyService.uploadProperty(uploadPropertyRequest,username);
            System.out.println(property);
            assertThat(property).isNotNull();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
