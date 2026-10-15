package org.example.subsystem;

import javax.swing.*;

public class BackupArtifact {
    private final String databaseName;
    private String fileName;
    private double sizeInMB;
    private boolean compressed;
    private boolean encrypted;
    private String checksum;
    private String cloudUrl;

    public BackupArtifact(String databaseName, String fileName, double sizeInMB){
        this.databaseName = databaseName;
        this.fileName = fileName;
        this.sizeInMB = sizeInMB;
        this.compressed = false;
        this.encrypted = false;
        this.checksum = "NONE";
        this.cloudUrl = "LOCAL_ONLY";
    }
    public String getDatabaseName(){
        return databaseName;
    }

    public String getfileName(){
        return fileName;
    }

    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    public double getSizeInMB(){
        return sizeInMB;
    }

    public void setSizeInMB(double sizeInMB){
        this.sizeInMB = sizeInMB;
    }

    public boolean isCompressed() {
        return compressed;
    }

    public void setCompressed(boolean compressed) {
        this.compressed = compressed;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public void setEncrypted(boolean encrypted){
        this.encrypted = encrypted;
    }

    public String getChecksum(){
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public String getCloudUrl(){
        return cloudUrl;
    }

    public void setCloudUrl(String cloudUrl) {
        this.cloudUrl = cloudUrl;
    }

    @Override
    public String toString(){
        return "BackupSummary[db='%s', file='%s', finalSize=%.2f MB, compressed=%s, encrypted=%s, sha256='%s', url='%s']"
                .formatted(databaseName, fileName, sizeInMB, compressed, encrypted, checksum, cloudUrl);    }

}
