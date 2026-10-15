package org.example.subsystem;

public class GzipCompressionEngine {
    private static final double COMPRESSION_RATION = 0.35;

    public void compress(BackupArtifact artifact){
        if (artifact.isCompressed()){
            throw new IllegalStateException("Artifact is already compressed: " + artifact.getfileName());
        }

        double originalSize = artifact.getSizeInMB();
        double compressedSize = originalSize * COMPRESSION_RATION;
        String compressedFileName = artifact.getfileName() + ".gz";

        artifact.setSizeInMB(compressedSize);
        artifact.setFileName(compressedFileName);
        artifact.setCompressed(true);

        System.out.printf("\"[GzipCompressionEngine] Compressed '%s' (%.2f MB -> %.2f MB)%n",
                compressedFileName, originalSize, compressedSize);

    }
}
