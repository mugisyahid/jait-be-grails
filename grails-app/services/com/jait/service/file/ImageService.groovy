package com.jait.service.file

import com.cloudinary.Cloudinary
import grails.config.Config
import grails.core.support.GrailsConfigurationAware

class ImageService implements GrailsConfigurationAware {

    Cloudinary cloudinary

    @Override
    void setConfiguration(Config co) {
        Map config = [:]
        config.put("cloud_name", co.getRequiredProperty('grails.cloudinary.cloudName'))
        config.put("api_key", co.getRequiredProperty('grails.cloudinary.apiKey'))
        config.put("api_secret", co.getRequiredProperty('grails.cloudinary.apiSecret'))
        cloudinary = new Cloudinary(config)
    }

    /**
     *
     * https://cloudinary.com/documentation/java_image_upload
     * @param file
     * @param objectUtils
     * @return
     */
    //TODO: signed upload
    List<String> upload(Object file, Map param) {
        Map uploadResult = cloudinary.uploader().unsignedUpload(file, 'tujms8pt', param)
        return [uploadResult.get('public_id'), uploadResult.get('url')]
    }


    def delete(String id, Map options) {
        Map result = cloudinary.uploader().destroy(id, options);
        return result
    }

    String urlFromImageTag(String imageTag) {
        cloudinary.url().imageTag(imageTag)
    }
}
