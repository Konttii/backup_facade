package org.example.subsystem;

import java.util.Locale;

public class PostgresDumpService {
    public BackupArtifact createSqlDump(String databaseName, double estimateDataSizeMB){
        if (databaseName ==  null || databaseName.isBlank()){
            throw new IllegalArgumentException("Database name cannot be null or empty.");
        }
        if (estimateDataSizeMB <= 0){
            throw new IllegalArgumentException("Database size must be greeter than 0 MB.");
        }

        String dumpFileName = databaseName.trim().toLowerCase() + "_dump.sql";
        System.out.printf("[PostgresDumpService] Connecting to PostgreSQL database '%s'.");
        System.out.printf("[PostgresDumpService] Exporting tables ans schema to '%s' (Raw size: %.2f MB)%n",
                dumpFileName, estimateDataSizeMB);

        return new BackupArtifact(databaseName, dumpFileName, estimateDataSizeMB);
    }
}
