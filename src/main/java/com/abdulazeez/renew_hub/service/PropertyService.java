package com.abdulazeez.renew_hub.service;

import com.abdulazeez.renew_hub.dto.request.UploadPropertyRequest;
import com.abdulazeez.renew_hub.model.Property;

import java.io.IOException;

public interface PropertyService {
    Property uploadProperty(UploadPropertyRequest Request) throws IOException;
}
