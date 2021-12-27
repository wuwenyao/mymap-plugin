package mengxiao.plugins;

import com.janetfilter.core.Environment;
import com.janetfilter.core.plugin.MyTransformer;
import com.janetfilter.core.plugin.PluginConfig;
import com.janetfilter.core.plugin.PluginEntry;

import java.util.ArrayList;
import java.util.List;

public class MyPluginEntry implements PluginEntry {
    private static final String PLUGIN_NAME = "Licensee";
    private final List<MyTransformer> transformers = new ArrayList<>();

    public MyPluginEntry() {
    }

    @Override
    public void init(Environment environment, PluginConfig config) {
        transformers.add(new MapTransformer(config.getBySection(PLUGIN_NAME)));
    }

    @Override
    public String getName() {
        return PLUGIN_NAME;
    }

    @Override
    public String getAuthor() {
        return "mengxiao";
    }

    @Override
    public String getVersion() {
        return "v2.0.0";
    }

    @Override
    public String getDescription() {
        return "LicenseeName plugin for ja-netfilter";
    }

    @Override
    public List<MyTransformer> getTransformers() {
        return transformers;
    }
}
