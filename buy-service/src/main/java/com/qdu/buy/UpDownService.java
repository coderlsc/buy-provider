package com.qdu.buy;

import org.springframework.web.multipart.MultipartFile;

public interface UpDownService {
     String updateHead(MultipartFile file) throws Exception;
}