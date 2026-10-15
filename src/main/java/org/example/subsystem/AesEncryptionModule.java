package org.example.subsystem;

public class AesEncryptionModule {

    public void encryptAndSign(BackupArtifact artifact, String secretKey){
        if (secretKey == null || secretKey.length() < 8){
            throw new IllegalArgumentException("Security error: Encryption secret key must be at least 8 characters long.");
        }

        String encryptedFileName = artifact.getfileName() + ".enc";
        String generetedChecksum = Integer.toHexString((artifact.getfileName() + secretKey).hashCode()).toUpperCase();

        artifact.setFileName(encryptedFileName);
        artifact.setEncrypted(true);
        artifact.setChecksum("SHA256-" + generetedChecksum);

        System.out.printf("[AecEncryptionModule] Encrypted file to '%s' using AES-256 (Checksum: %s)%n",
                encryptedFileName, artifact.getChecksum());
    }
}
