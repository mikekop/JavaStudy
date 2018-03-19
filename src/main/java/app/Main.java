package app;

public class Main {

    String instanceName = "WD45-PC";
    String databaseName = "test";
    String userName = "WD45-PC\\WD45";
    String pass = "**********";
    String connectionUrl = "jdbc:sqlserver://localhost;databaseName=FromJavaDB;integratedSecurity=true";
    String connectionString = String.format(connectionUrl, instanceName, databaseName, userName, pass);

    public static void main (String[] arg)
    {
        System.out.print("dsfgsdfg");
    }
}
