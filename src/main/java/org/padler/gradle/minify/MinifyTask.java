package org.padler.gradle.minify;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.*;
import org.padler.gradle.minify.minifier.CssMinifier;
import org.padler.gradle.minify.minifier.JsMinifier;
import org.padler.gradle.minify.minifier.options.CSSMinifierOptions;
import org.padler.gradle.minify.minifier.options.JSMinifierOptions;

import java.io.File;

public class MinifyTask extends DefaultTask {

    MinifyPluginExtension extension = getProject().getExtensions().findByType(MinifyPluginExtension.class);

    public MinifyTask() {
        if (extension == null) {
            extension = new MinifyPluginExtension();
        }
    }

    @Optional
    @InputDirectory
    public File getJsSrcDir() {
        if (extension.getJsSrcDir().isEmpty()) return null;
        return new File(extension.getJsSrcDir());
    }

    @Optional
    @InputDirectory
    public File getCssSrcDir() {
        if (extension.getCssSrcDir().isEmpty()) return null;
        return new File(extension.getCssSrcDir());
    }

    @Optional
    @OutputDirectory
    public File getJsDstDir() {
        if (extension.getJsDstDir().isEmpty()) return null;
        return new File(extension.getJsDstDir());
    }

    @Optional
    @OutputDirectory
    public File getCssDstDir() {
        if (extension.getCssDstDir().isEmpty()) return null;
        return new File(extension.getCssDstDir());
    }

    @Optional
    @Input
    public Boolean getCreateCssSourceMaps() {
        return extension.getCreateCssSourceMaps();
    }

    @Optional
    @Input
    public Boolean getCreateJsSourceMaps() {
        return extension.getCreateJsSourceMaps();
    }

    @Optional
    @Input
    public Boolean getOriginalFileNames() {
        return extension.getOriginalFileNames();
    }

    @TaskAction
    public void minify() {
        if (!extension.getCssSrcDir().isEmpty() && !extension.getCssDstDir().isEmpty()) {
            CssMinifier cssMinifier = new CssMinifier();
            CSSMinifierOptions minifierOptions = cssMinifier.getMinifierOptions();
            minifierOptions.setCreateSoureMaps(extension.getCreateCssSourceMaps());
            minifierOptions.setOriginalFileNames(extension.getOriginalFileNames());
            cssMinifier.minify(extension.getCssSrcDir(), extension.getCssDstDir());
        }
        if (!extension.getJsSrcDir().isEmpty() && !extension.getJsDstDir().isEmpty()) {
            JsMinifier jsMinifier = new JsMinifier();
            JSMinifierOptions minifierOptions = jsMinifier.getMinifierOptions();
            minifierOptions.setCreateSoureMaps(extension.getCreateJsSourceMaps());
            minifierOptions.setOriginalFileNames(extension.getOriginalFileNames());
            jsMinifier.minify(extension.getJsSrcDir(), extension.getJsDstDir());
        }
    }
}
