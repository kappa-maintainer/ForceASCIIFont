package io.github.zekerzhayard.forceasciifont;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.google.common.collect.Maps;
import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.versioning.InvalidVersionSpecificationException;
import cpw.mods.fml.common.versioning.VersionRange;
import cpw.mods.fml.relauncher.Side;

public class ForceAsciiFont extends DummyModContainer {
    public ForceAsciiFont() {
        super(new ModMetadata());
        ModMetadata md = this.getMetadata();
        md.modId = "forceasciifont";
        md.name = "ForceAsciiFont";
        md.version = "@VERSION@";
        md.url = "https://www.curseforge.com/minecraft/mc-mods/forceasciifont";
        md.authorList.add("ZekerZhayard");
        md.authorList.add("kappa-maintainer");
        md.description = "Force ASCII fonts.";
    }

    @Override
    public File getSource() {
        return new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile());
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller) {
        return true;
    }

    @Override
    public boolean matches(Object mod) {
        return this.equals(mod);
    }

    @Override
    public Object getMod() {
        return this;
    }

    @Override
    public VersionRange acceptableMinecraftVersionRange() {
        try {
            return VersionRange.createFromVersionSpec("[1.7.10,1.12.2]");
        } catch (InvalidVersionSpecificationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<String, String> getSharedModDescriptor() {
        Map<String, String> descriptor = Maps.newHashMap();
        descriptor.put("modsystem", "FML");
        descriptor.put("id", getModId());
        descriptor.put("version", getDisplayVersion());
        descriptor.put("name", getName());
        descriptor.put("url", this.getMetadata().url);
        descriptor.put("authors", this.getMetadata().getAuthorList());
        descriptor.put("description", this.getMetadata().description);
        return descriptor;
    }


}
