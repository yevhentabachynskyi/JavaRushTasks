package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;

public class SecurityProxyConnector implements Connector {
    private String str;
    private SimpleConnector simpleConnector;
    private SecurityChecker securityChecker;

    public SecurityProxyConnector(String str) {
        this.str = str;
        simpleConnector = new SimpleConnector(str);
    }

    @Override
    public void connect() {
        if (securityChecker.performSecurityCheck()){
            simpleConnector.connect();
            System.out.println("Successfully connected to " + str);
        }
        else System.out.println("Error connected to " + str);
    }
}
