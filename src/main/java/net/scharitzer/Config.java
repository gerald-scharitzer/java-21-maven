package net.scharitzer;

import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;

import java.io.InputStream;
import java.util.Map;

public class Config {
	public static Config fromYaml(InputStream stream) {
		LoadSettings settings = LoadSettings.builder().build();
		Load load = new Load(settings);
		Map<String, Object> map = (Map<String, Object>) load.loadFromInputStream(stream); // FIXME check cast
		// TODO get values
		Config config = new Config();
		return config;
	}
}
