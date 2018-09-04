package com.echan.middleware.entity;

public class Middleware {
    private String middlewareId;
    private String middlewareName;
    private String middlewareHost;
    private String scriptPath;
    private String scriptStart;
    private String scriptCheck;
    private String scriptStop;
    private String browserPath;

    public String getMiddlewareId() {
        return middlewareId;
    }

    public void setMiddlewareId(String middlewareId) {
        this.middlewareId = middlewareId;
    }

    public String getMiddlewareName() {
        return middlewareName;
    }

    public void setMiddlewareName(String middlewareName) {
        this.middlewareName = middlewareName;
    }

    public String getMiddlewareHost() {
        return middlewareHost;
    }

    public void setMiddlewareHost(String middlewareHost) {
        this.middlewareHost = middlewareHost;
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

    public String getBrowserPath() {
        return browserPath;
    }

    public void setBrowserPath(String browserPath) {
        this.browserPath = browserPath;
    }
}
