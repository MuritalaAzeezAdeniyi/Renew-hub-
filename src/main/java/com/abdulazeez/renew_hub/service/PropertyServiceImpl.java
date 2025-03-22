package com.abdulazeez.renew_hub.service;

import com.abdulazeez.renew_hub.dto.request.UploadPropertyRequest;
import com.abdulazeez.renew_hub.model.Property;
import com.abdulazeez.renew_hub.repositry.PropertyRepo;
import com.cloudinary.Cloudinary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;
@Service
public class PropertyServiceImpl implements PropertyService {


    private final Cloudinary cloudinary;
    private  final PropertyRepo repository;

    public PropertyServiceImpl(Cloudinary cloudinary, PropertyRepo repository) {
        this.cloudinary = cloudinary;
        this.repository = repository;
    }

    @Override
    public Property uploadProperty(UploadPropertyRequest request) throws IOException {
        Property property = upload(request);
        String url = uploadContent(request.getImageUrl());
        property.setImageUrl(url);
        repository.save(property);
        return property;
    }

    private String uploadContent(MultipartFile file) throws IOException {
        String contentType = file.getContentType();
        String resourceType;

        if (contentType != null && contentType.startsWith("video/")) resourceType = "video";
        else if (contentType != null && contentType.startsWith("image/")) resourceType = "image";
        else throw new RuntimeException("Invalid file type. Only images and videos are supported.");

        Map<String, Object> params = Map.of("public_id", UUID.randomUUID().toString(), "resource_type", resourceType);
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), params);
        return uploadResult.get("url").toString();
    }



    private Property upload(UploadPropertyRequest request) {
        Property property = new Property();
        property.setTitle(request.getTitle());
        property.setDescription(request.getDescription());
        property.setLocation(request.getLocation());
        property.setPrice(request.getPrice());
        return property;
    }
}
