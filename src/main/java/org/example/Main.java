package org.example;

import org.example.facade.DatabaseBackupFacade;

public class Main {
    public static void main(String[] args){
        DatabaseBackupFacade backupFacade = new DatabaseBackupFacade();

        System.out.println("--- SCENARIO 1: Production Database Backup ---");
        String successResult = backupFacade.performFullCloudBackup(
                "aitu_student_portal_db",
                240.0,
                "ProdSecretKey#2026",
                "aitu-backups-prod"
        );
        System.out.println("Result: " + successResult + "\n");


        System.out.println("--- SCENARIO 2: Invalid Security Key Handling ---");
        String failedResult = backupFacade.performFullCloudBackup(
                "freelance_marketplace_db",
                150.0,
                "short",
                "aitu-backups-dev"
        );
        System.out.println("Result: " + failedResult);
    }
}
