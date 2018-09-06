package com.echan.app.entity;

import java.io.Serializable;

public class App implements Serializable {
    private String appId;
    private String appName;
    private String hostIp;
    private String projectId;
    private String deployPath;
    private String scriptPath;
    private String scriptStart;
    private String scriptCheck;
    private String scriptStop;
    private String logFile;

    public App(String appId, String appName, String hostIp, String projectId, String deployPath, String scriptPath, String scriptStart, String scriptCheck, String scriptStop, String logFile) {
        this.appId = appId;
        this.appName = appName;
        this.hostIp = hostIp;
        this.projectId = projectId;
        this.deployPath = deployPath;
        this.scriptPath = scriptPath;
        this.scriptStart = scriptStart;
        this.scriptCheck = scriptCheck;
        this.scriptStop = scriptStop;
        this.logFile = logFile;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getDeployPath() {
        return deployPath;
    }

    public void setDeployPath(String deployPath) {
        this.deployPath = deployPath;
    }

    public String getScriptPath() {
        return scriptPath;
    }

    public void setScriptPath(String scriptPath) {
        this.scriptPath = scriptPath;
    }

    public String getScriptStart() {
        return scriptStart;
    }

    public void setScriptStart(String scriptStart) {
        this.scriptStart = scriptStart;
    }

    public String getScriptCheck() {
        return scriptCheck;
    }

    public void setScriptCheck(String scriptCheck) {
        this.scriptCheck = scriptCheck;
    }

    public String getScriptStop() {
        return scriptStop;
    }

    public void setScriptStop(String scriptStop) {
        this.scriptStop = scriptStop;
    }

    public String getLogFile() {
        return logFile;
    }

    public void setLogFile(String logFile) {
        this.logFile = logFile;
    }
}
