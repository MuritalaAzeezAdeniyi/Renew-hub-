package com.abdulazeez.renew_hub.service;

import com.abdulazeez.renew_hub.dto.request.UploadPropertyRequest;
import com.abdulazeez.renew_hub.model.Property;
import com.abdulazeez.renew_hub.model.Role;
import com.abdulazeez.renew_hub.model.Users;
import com.abdulazeez.renew_hub.repositry.PropertyRepo;
import com.abdulazeez.renew_hub.repositry.UserRepo;
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
    private final UserRepo userRepository;

    public PropertyServiceImpl(Cloudinary cloudinary, PropertyRepo repository, UserRepo userRepository) {
        this.cloudinary = cloudinary;
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public Property uploadProperty(UploadPropertyRequest request,String username) throws IOException {
        Property property = upload(request,username);
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



    private Property upload(UploadPropertyRequest request,String username) throws IOException {
        Users user = validateUser(username);
        Property property = new Property();
        property.setTitle(request.getTitle());
        property.setDescription(request.getDescription());
        property.setLocation(request.getLocation());
        property.setPrice(request.getPrice());
        property.setUser(user);
        property.setUser(user);
        return property;
    }

    private Users validateUser(String username) {
        Users user = userRepository.findByUsername(username);
        if(user == null){
            throw new RuntimeException("User not found");
        }
        if(user.getRole() != Role.SELLER){
            throw new RuntimeException("Only seller can upload property");
        }
        return user;
    }
}
