package org.example.subsystem;

public class CloudStorageUploader {

    public void uploadToBucket(BackupArtifact artifact, String bucketName){
        if(bucketName == null || bucketName.isBlank()){
            throw new IllegalArgumentException("Cloud bucket name cannot be empty.");
        }
        if (!artifact.isEncrypted()){
            throw new IllegalStateException("Security Pokicy Violation: Cannot upload unencrypted database backup to cloud");
        }

        String url = "https://s3.cloud-storage.kz/%s/%s"
                .formatted(bucketName.trim().toLowerCase(), artifact.getfileName());

        System.out.printf("[CloudStorageUploader] Succesfully uploaded %.2f MB to '%s'%n",
                artifact.getSizeInMB(), url);
    }
}
