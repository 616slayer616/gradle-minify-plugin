package org.padler.gradle.minify;

public class MinifyPluginExtension {

    private String cssDstDir = "";

    private String cssSrcDir = "";

    private String jsDstDir = "";

    private String jsSrcDir = "";

    private Boolean createJsSourceMaps = false;
    private Boolean renameToMin = false;

    public String getCssDstDir() {
        return cssDstDir;
    }

    public void setCssDstDir(String cssDstDir) {
        this.cssDstDir = cssDstDir;
    }

    public String getCssSrcDir() {
        return cssSrcDir;
    }

    public void setCssSrcDir(String cssSrcDir) {
        this.cssSrcDir = cssSrcDir;
    }

    public String getJsDstDir() {
        return jsDstDir;
    }

    public void setJsDstDir(String jsDstDir) {
        this.jsDstDir = jsDstDir;
    }

    public String getJsSrcDir() {
        return jsSrcDir;
    }

    public void setJsSrcDir(String jsSrcDir) {
        this.jsSrcDir = jsSrcDir;
    }

    public Boolean getCreateJsSourceMaps() {
        return createJsSourceMaps;
    }

    public void setCreateJsSourceMaps(Boolean createJsSourceMaps) {
        this.createJsSourceMaps = createJsSourceMaps;
    }

    public Boolean getRenameToMin() {
        return renameToMin;
    }

    public void setRenameToMin(Boolean renameToMin) {
        this.renameToMin = renameToMin;
    }
}
