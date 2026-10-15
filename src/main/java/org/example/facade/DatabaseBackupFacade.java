package org.example.facade;


import org.example.subsystem.*;

public class DatabaseBackupFacade {
    private final PostgresDumpService dumpService;
    private final GzipCompressionEngine compressionEngine;
    private final AesEncryptionModule encryptionModule;
    private final CloudStorageUploader cloudUploader;

    public DatabaseBackupFacade(){
        this.dumpService = new PostgresDumpService();
        this.compressionEngine = new GzipCompressionEngine();
        this.encryptionModule = new AesEncryptionModule();
        this.cloudUploader = new CloudStorageUploader();
    }

    public String performFullCloudBackup(String databaseName, double dataSizeMB, String secretKey, String cloudBucket){
        System.out.println("=== [DatabaseBackupFacade] Starting Automated Backup Pipeline ===");
        try{
            BackupArtifact artifact = dumpService.createSqlDump(databaseName, dataSizeMB);
            compressionEngine.compress(artifact);
            encryptionModule.encryptAndSign(artifact, secretKey);
            cloudUploader.uploadToBucket(artifact, cloudBucket);

            System.out.println("=== [DatabaseBackupFacade] Backup Pipeline Completed Successfully ===");
            return artifact.toString();

        } catch (IllegalArgumentException | IllegalStateException e){
            System.err.println("=== [DatabaseBackupFacade] Pipeline Aborted: " + e.getMessage() + " ===");
            return "Backup Failed: " + e.getMessage();
        }
    }
}
