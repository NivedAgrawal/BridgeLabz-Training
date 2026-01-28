package scenerio_based;

import java.util.PriorityQueue;

class InvalidBackupPathException extends Exception {
 public InvalidBackupPathException(String message) {
     super(message);
 }
}

class BackupTask implements Comparable<BackupTask> {
 String path;
 int priority; 

 public BackupTask(String path, int priority) {
     this.path = path;
     this.priority = priority;
 }

 @Override
 public int compareTo(BackupTask other) {
     return Integer.compare(other.priority, this.priority);
 }
}

class BackupScheduler {

 PriorityQueue<BackupTask> queue = new PriorityQueue<>();

 public void scheduleBackup(String path, int priority)
         throws InvalidBackupPathException {

     if (path == null || path.isEmpty()) {
         throw new InvalidBackupPathException("Invalid backup path");
     }

     queue.add(new BackupTask(path, priority));
     System.out.println("Backup scheduled: " + path);
 }

 public void executeBackups() {
     System.out.println("Executing backups:");

     while (!queue.isEmpty()) {
         BackupTask task = queue.poll();
         System.out.println("Backing up: " + task.path +
                 " (Priority: " + task.priority + ")");
     }
 }
}

public class BackupApp {
 public static void main(String[] args) {

     BackupScheduler scheduler = new BackupScheduler();

     try {
         scheduler.scheduleBackup("/system/config", 5);
         scheduler.scheduleBackup("/user/docs", 2);
         scheduler.scheduleBackup("/database", 10);
     } catch (InvalidBackupPathException e) {
         System.out.println(e.getMessage());
     }

     scheduler.executeBackups();
 }
}
